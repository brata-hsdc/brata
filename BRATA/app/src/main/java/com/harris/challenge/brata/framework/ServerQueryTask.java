package com.harris.challenge.brata.framework;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import com.harris.challenge.brata.R;
import com.harris.challenge.secret_agent_tools.MessageDecoder;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.util.Log;

public class ServerQueryTask extends AsyncTask<String, Void, String> {

	/**
	 * Variable for holding the teams registration code
	 * The use of this is now abstracted from the user other than providing storage context
	 */
	private String TeamRegCode = "";
	private static String REG_CODE_KEY = "RegCode";

	protected Activity callingActivity;
    protected ProgressDialog dialog;
	protected String serverUrl;
	protected String regCode;

	public ServerQueryTask(Activity activity, String url)
	{
		this.callingActivity = activity;
		serverUrl = url;

		// in case the app restarted need to attempt to recover the regcode
		SharedPreferences settings = activity.getSharedPreferences(activity.getResources().getString(R.string.app_name), 0);
		if(settings.contains(REG_CODE_KEY)){
			// restore the last known value
			regCode = settings.getString(REG_CODE_KEY, "");
		}
		else {
			// Initialize storage of the regCode
			SharedPreferences.Editor editor = settings.edit();
			editor.putString(REG_CODE_KEY, "");
			editor.commit();
		}
	}

	@Override
    protected void onPreExecute() {

        dialog = new ProgressDialog(callingActivity);
        //dialog.setMessage("wait for a moment...");
        dialog.show();
    }
	
	@Override
	protected String doInBackground(String... params)
	{
		String encodedResponse = null;

		if (params.length != 1)
		{
		    Log.w("BRATA", "ServerQueryTask  doInBackground() - "
					+ "Querying the server only supports one message at a time and not " + params.length);
		    return encodedResponse;
		}
		
		String dbgMsg = "ServerQueryTask  doInBackground()"
    			+ " - Sending message to MasterServer"
    			+ " - \nURL:" + serverUrl 
    			+ " - \nmessage: " + params[0]
                + " - \nreg_code:" + regCode
                + " - \nbrata_version:2016";
		Log.d("BRATA", dbgMsg);
		
		JSONObject requestBody = new JSONObject();
		try
		{
			requestBody.put("message", params[0]);
            
            // Send reg_code to the server.
            // The server may send back a new one.
            // If it does, save it.
			requestBody.put("reg_code", regCode);
            requestBody.put("brata_version", "2016");
		}
		catch (JSONException e)
		{
		    Log.w("BRATA", "ServerQueryTask  doInBackground() - "
					+ "Exception while populating JSON Object: " + e.toString());
		    return encodedResponse;
		}
		
		try
		{
			if (serverUrl == null)
		    {
			    Log.w("BRATA", "ServerQueryTask  doInBackground() - "
						+ "Server url is null");
			    return encodedResponse;
		    }
			
			HttpClient client = new DefaultHttpClient();
			HttpPost request = new HttpPost(serverUrl);
			request.addHeader("Content-Type", "application/json");
			request.setEntity(new StringEntity(requestBody.toString(0)));
			
			HttpResponse response = client.execute(request);
			
		    StatusLine statusLine = response.getStatusLine();
		    HttpEntity httpEntity = response.getEntity();
		    
		    if (statusLine == null)
		    {
			    Log.w("BRATA", "ServerQueryTask  doInBackground() - "
						+ "No status in HTTP response");
			    return encodedResponse;
		    }
		    else if(statusLine.getStatusCode() != HttpStatus.SC_OK)
		    {
			    Log.w("BRATA", "ServerQueryTask  doInBackground() - "
						+ "HTTP status not ok: " + statusLine.getStatusCode()
						+ " " + statusLine.getReasonPhrase());
			    return encodedResponse;
		    }
		    else if (httpEntity == null)
		    {
			    Log.w("BRATA", "ServerQueryTask  doInBackground() - "
						+ "No body content in HTTP response");
			    return encodedResponse;
		    }
		    else // return message is present
		    {
		        ByteArrayOutputStream out = new ByteArrayOutputStream();
		        httpEntity.writeTo(out);
		        out.close();

			    Log.d("BRATA", "ServerQueryTask  doInBackground() - "
						+ "HTTP Response: " + httpEntity.toString()
						+ " --- " + out.toString());
		        JSONObject responseBody = new JSONObject(out.toString());
		        encodedResponse = responseBody.getString("message");
                
                // If the message has a reg_code, save it
                if (responseBody.has("reg_code"))
                {
					// but only save it if it actually changed
					String tmpRegCode = responseBody.getString("reg_code");
					if(!regCode.equals(tmpRegCode)) {
						regCode = tmpRegCode;
						SharedPreferences.Editor editor = callingActivity.getSharedPreferences(
								callingActivity.getResources().getString(R.string.app_name), 0).
								edit();
						editor.putString(REG_CODE_KEY, regCode);
						editor.commit();
					}
                }
		    }
		}
		catch (IllegalStateException e)
		{
		    Log.w("BRATA", "ServerQueryTask  doInBackground() - "
					+ "HTTP address error: " + e.toString());
		}
		catch (ClientProtocolException e)
		{
		    Log.w("BRATA", "ServerQueryTask  doInBackground() - "
					+ "HTTP protocol error: " + e.toString());
		}
 		catch (UnsupportedEncodingException e)
 		{
		    Log.w("BRATA", "ServerQueryTask  doInBackground() - "
					+ "Exception while encoding the body string: " + e.toString());
		}
 		catch (JSONException e)
		{
		    Log.w("BRATA", "ServerQueryTask  doInBackground() - "
					+ "Exception while encoding/decoding the JSON string: " + e.toString());
		}
		catch (IOException e)
		{
		    Log.w("BRATA", "ServerQueryTask  doInBackground() - "
					+ "Connection error or abort: " + e.toString());
		}
		
		return encodedResponse;
	}
	
	@Override
	protected void onPostExecute(String result)
	{
	    if (dialog.isShowing())
	    {
	        dialog.dismiss();
	    }
		String dbgMsg = "ServerQueryTask  onPostExecute()"
    			+ " - Message from server: " + result;
		Log.d("BRATA", dbgMsg);
		
		if(result != null && result.length() > 0)
		{
			MessageDecoder.decodeResponse(result);
		}

		callingActivity.finish();
	}
}
