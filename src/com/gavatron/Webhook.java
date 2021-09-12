package com.gavatron;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
			System.err.println("Your webhook URL is invalid for some reason.");
		}
	}

	public Webhook setURL(String u) {
		try {
			url = new URL(u);
		} catch (Exception e) {
			System.err.println("Your webhook URL is invalid for some reason.");
		}
		return this;
	}

	public Webhook setName(String n) {
		name = n;
		return this;
	}

	public Webhook setContent(String c) {
		content = c;
		return this;
	}

	public Webhook setIcon(String a) {
		try {
			icon = new URL(a);
		} catch (Exception e) {
			System.err.println("Your webhook icon URL is invalid for some reason.");
		}
		iconPresent = true;
		return this;
	}

	public Webhook addEmbed(Embed e) {
		embeds.add(e.getData());
		embedsPresent = true;
		return this;
	}

	public Webhook addJsonEmbed(String e) {
		embeds.add(e);
		embedsPresent = true;
		return this;
	}

	private JsonArray getEmbeds() {
		JsonArray embedsJson = new JsonArray();

		for (String e : embeds) {
			embedsJson.add(JsonParser.parseString(e));
		}

		return embedsJson;
	}

	private JsonObject getData() {
		JsonObject message = new JsonObject();
		message.addProperty("content", content);

		if (iconPresent)
			message.addProperty("avatar_url", icon.toString());
		if (embedsPresent)
			message.add("embeds", getEmbeds());
		message.addProperty("username", name);
		return message;
	}

	public boolean send() {
		try {
			HttpURLConnection http = (HttpURLConnection) url.openConnection();
			http.setRequestMethod("POST");
			http.setDoOutput(true);
			http.setRequestProperty("Content-Type", "application/json");

			byte[] out = getData().toString().getBytes(StandardCharsets.UTF_8);

			OutputStream stream = http.getOutputStream();
			stream.write(out);
			http.getResponseCode();
			http.disconnect();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean send(boolean reset) {
		try {
			send();

			if (reset)
				reset();

			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void reset() {
		content = null;
		name = "Gavatron77\'s Java Webhook Library";
		icon = null;
		embeds = new ArrayList<>();
		iconPresent = false;
		embedsPresent = false;
	}

	public String getString() {
		return getData().toString();
	}
}
