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

import com.harris.challenge.secret_agent_tools.MessageDecoder;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

public class ServerQueryTask extends AsyncTask<String, Void, String> {

	protected Activity callingActivity;
    protected ProgressDialog dialog;
	protected String serverUrl;
	protected String teamId;
	
	public ServerQueryTask(Activity activity, String url, String teamId)
	{
		this.callingActivity = activity;
		serverUrl = url;
		this.teamId = teamId;
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
    			+ " - \nMessage: " + params[0] 
    			+ " - \nTeamID:" + teamId;
		Log.d("BRATA", dbgMsg);
		
		JSONObject requestBody = new JSONObject();
		try
		{
			requestBody.put("team_id", teamId);
			requestBody.put("message", params[0]);
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
