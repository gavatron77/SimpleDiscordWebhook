package com.gavatron;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Embed {
	private String title;
	private String desc;
	private JsonObject author;
	private int color;
	private boolean descPresent = false;
	private boolean colorPresent = false;
	private boolean authorPresent = false;

	public Embed(String t) {
		title = t;
	}

	public Embed setDesc(String d) {
		desc = d;
		descPresent = true;
		return this;
	}

	public Embed setColor(String c) {
		color = Integer.parseInt(c);
		colorPresent = true;
		return this;
	}

	public Embed setAuthor(Author a) {
		author = JsonParser.parseString(a.getData()).getAsJsonObject();
		authorPresent = true;
		return this;
	}

	public String getData() {
		JsonObject embed = new JsonObject();
		embed.addProperty("title",title);

		if (descPresent)
			embed.addProperty("description", desc);
		if (colorPresent)
			embed.addProperty("color", color);
		if (authorPresent)
			embed.add("author", author);

		return embed.toString();
	}
}
