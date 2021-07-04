package com.gavatron;

import java.net.URL;

import com.google.gson.JsonObject;

public class Author {
	JsonObject author = new JsonObject();

	public Author() {
	}
	
	public Author setName(String n) {
		author.addProperty("name", n);
		return this;
	}

	public Author setLink(String l) {
		try {
			author.addProperty("url", new URL(l).toString());
		} catch (Exception e) {
			System.err.println("Your author link is invalid for some reason.");
		}
		return this;
	}

	public Author setIcon(String i) {
		try {
			author.addProperty("icon_url", new URL(i).toString());
		} catch (Exception e) {
			System.err.println("Your author icon link is invalid for some reason.");
		}
		return this;
	}

	public String getData() {
		return author.toString();
	}
}
