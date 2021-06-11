package com.gavatron;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Webhook {
	private URL url;
	private String content;
	private String name = "Gavatron77\'s Java Webhook Library";
	private URL avatar;
	private boolean avatarPresent = false;

	public Webhook(URL u) {
		url = u;
	}

	public void setName(String n) {
		name = n;
	}

	public void setContent(String c) {
		content = c;
	}
	
	public void setAvatar(String a) throws MalformedURLException {
		avatar = new URL(a);
		avatarPresent = true;
	}

	public String getMessage() {
		String message = "{\"content\":\"" + content + "\"";
		
		if (avatarPresent)
			message = message + ",\"avatar_url\":\"" + avatar + "\"";
		
		message = message + ",\"username\":\"" + name + "\"";
		
		message = message + "}";
		return message;
	}

	public boolean send() {
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			http.setRequestProperty("Content-Type", "application/json");

			byte[] out = getMessage().getBytes(StandardCharsets.UTF_8);
			
			OutputStream stream = http.getOutputStream();
			stream.write(out);
			System.out.println(http.getResponseCode());
			http.disconnect();
			
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	public void clear() {
		
	}
}
