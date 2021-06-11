package com.gavatron;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Webhook {
	private URL url;
	private String content;
	private String name = "Gavatron77\'s Java Webhook Library";
	private URL icon;
	private ArrayList<String> embeds = new ArrayList<>();
	private boolean iconPresent = false;
	private boolean embedsPresent = false;

	public Webhook(String u) {
		try {
			url = new URL(u);
		} catch (Exception e) {
			System.out.println("Your webhook URL is invalid for some reason.");
		}
	}

	public void setName(String n) {
		name = n;
	}

	public void setContent(String c) {
		content = c;
	}

	public void setIcon(String a) {
		try {
			icon = new URL(a);
		} catch (Exception e) {
			System.out.println("Your webhook icon URL is invalid for some reason.");
		}
		iconPresent = true;
	}

	public void addEmbed(Embed e) {
		embeds.add(e.getData());
		embedsPresent = true;
	}

	private String getEmbeds() {
		String jsonEmbeds = ",\"embeds\":[";
		int i = 0;
		int c = embeds.size();

		for (String e : embeds) {
			jsonEmbeds += e;
			i++;
			if (i < c)
				jsonEmbeds += ",";
		}

		jsonEmbeds += "]";
		return jsonEmbeds;
	}

	public String getData() {
		String message = "{\"content\":\"" + content + "\"";

		if (iconPresent)
			message += ",\"avatar_url\":\"" + icon + "\"";
		if (embedsPresent)
			message += getEmbeds();

		message += ",\"username\":\"" + name + "\"";
		message += "}";
		return message;
	}

	public boolean send() {
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			http.setRequestProperty("Content-Type", "application/json");

			byte[] out = getData().getBytes(StandardCharsets.UTF_8);

			OutputStream stream = http.getOutputStream();
			stream.write(out);
			http.getResponseCode();
			http.disconnect();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void clear() {

	}
}
