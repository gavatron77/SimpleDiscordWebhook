package com.gavatron;

import java.net.URL;

import com.google.gson.JsonObject;

public class Author {
	private String name;
	private URL link;
	private URL icon;
	private boolean linkPresent;
	private boolean iconPresent;

	public Author(String n) {
		name = n;
	}

	public Author setLink(String l) {
		try {
			link = new URL(l);
			linkPresent = true;
		} catch (Exception e) {
			System.err.println("Your author link is invalid for some reason.");
		}
		return this;
	}

	public Author setIcon(String i) {
		try {
			icon = new URL(i);
			iconPresent = true;
		} catch (Exception e) {
			System.err.println("Your author icon link is invalid for some reason.");
		}
		return this;
	}

	public String getData() {
		JsonObject author = new JsonObject();
		author.addProperty("name", name);
		
		if (linkPresent)
			author.addProperty("url", link.toString());
		if (iconPresent)
			author.addProperty("icon_url", icon.toString());

		return author.toString();
	}
}
