package com.harris.challenge.secret_agent_tools;

public class MessageDecoder {
	
	static String encodedMessage;
	static String decodedMessage;
	
	/**
	 * Example:
	 * decodeResponse("U__sFLeou_rktcehe!e,~"); should return a result of "Use_the_Force,_Luke!~"
	 */
	static String decodeResponse(String encodedString)
	{
		MessageDecoder.encodedMessage = encodedString;
		System.out.print("decodeResponse");
		String result = "";
		/*
		 * Enter code here to decode the encodedString and set result
		 */
		MessageDecoder.decodedMessage = result;
		return result;
	}
}
