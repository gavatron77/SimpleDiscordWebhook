package com.gavatron;

import java.awt.Color;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Embed {
	private JsonObject embed = new JsonObject();

	public Embed() {

	}

	public Embed setTitle(String t) {
		embed.addProperty("title", t);
		return this;
	}

	public Embed setDesc(String d) {
		embed.addProperty("description", d);
		return this;
	}

	public Embed setColor(String c) {
		embed.addProperty("color", Integer.parseInt(c));
		return this;
	}

	public Embed setColor(int r, int g, int b) {
		int c = r;
		c = (c << 8) + g;
		c = (c << 8) + b;
		embed.addProperty("color", c);
		return this;
	}
	
	public Embed setColor(Color c) {
		setColor(c.getRed(),c.getGreen(),c.getBlue());
		return this;
	}

	public Embed setAuthor(Author a) {
		embed.add("author", JsonParser.parseString(a.getData()).getAsJsonObject());
		return this;
	}

	public Embed addImage(String i) {
		JsonObject image = new JsonObject();
		image.addProperty("url", i);
		embed.add("image", image);
		return this;
	}

	public Embed addThumbnail(String i) {
		JsonObject image = new JsonObject();
		image.addProperty("url", i);
		embed.add("thumbnail", image);
		return this;
	}

	public Embed addTimestamp(String t) {
		embed.addProperty("timestamp", t);
		return this;
	}

	public String getData() {
		return embed.toString();
	}

	public Embed json(JsonObject d) {
		embed = d;
		return this;
	}
}
