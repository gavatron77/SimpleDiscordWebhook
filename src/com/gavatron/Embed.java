package com.gavatron;

public class Embed {
	private String title;
	private String desc;
	private String author;
	private int color;
	private boolean descPresent = false;
	private boolean colorPresent = false;
	private boolean authorPresent = false;

	public Embed(String t) {
		title = t;
	}

	public void setDesc(String d) {
		desc = d;
		descPresent = true;
	}

	public void setColor(String c) {
		color = Integer.parseInt(c);
		colorPresent = true;
	}

	public void setAuthor(Author a) {
		author = a.getData();
		authorPresent = true;
	}

	public String getData() {
		String embed = "{\"title\":\"" + title + "\"";

		if (descPresent)
			embed += ",\"description\":\"" + desc + "\"";
		if (colorPresent)
			embed += ",\"color\":" + color + "";
		if (authorPresent)
			embed += author;

		embed += "}";
		return embed;
	}
}
