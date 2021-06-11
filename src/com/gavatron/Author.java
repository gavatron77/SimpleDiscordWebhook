package com.gavatron;

import java.net.URL;

public class Author {
	private String name;
	private URL link;
	private URL icon;
	private boolean linkPresent;
	private boolean iconPresent;

	public Author(String n) {
		name = n;
	}

	public void setLink(String l) {
		try {
			link = new URL(l);
			linkPresent = true;
		} catch (Exception e) {
			System.out.println("Your author link is invalid for some reason.");
		}
	}

	public void setIcon(String i) {
		try {
			icon = new URL(i);
			iconPresent = true;
		} catch (Exception e) {
			System.out.println("Your author icon link is invalid for some reason.");
		}
	}

	public String getData() {
		String author = ",\"author\":{";
		author += "\"name\":\"" + name + "\"";
		
		if (linkPresent)
			author += ",\"url\":\"" + link + "\"";
		if (iconPresent)
			author += ",\"icon_url\":\"" + icon + "\"";

		author += "}";
		return author;
	}
}
