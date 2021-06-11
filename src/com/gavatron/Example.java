package com.gavatron;

public class Example {
	public static void main(String[] args) {
		
		//Creates a new author object and sets the author name
		Author a = new Author("Author test")
				
				//Sets the author icon, can be any compatible image
				.setIcon("https://cdn.discordapp.com/avatars/231627913823387648/15a410db5f37b68729c8e3779e1b90ca.webp?size=4096")
				
				//Sets the hyperlink URL (when clicking the author name)
				.setLink("https://google.com");
		
		//Creates a new embed object and sets the embed name
		Embed e = new Embed("Title")
				//Adds the author from above
				.setAuthor(a)
				
				//Sets the text in the embed
				.setDesc("Description")
				
				//Sets the accent color of the embed
				.setColor("65535");

		//Creates a new webhook object and sets the URL. To use this example, this is the only line you need to change
		Webhook w = new Webhook("WEBHOOK URL HERE")
				
				//Sets the webhook name, if different names are used on different messages, they will stay different after page refresh
				.setName("Gavatron77\'s Java Webhook Library")
				
				//Sets the contents of the webhook in text. To ping someone format as <@user_id>, to ping role format as <@&role_id>
				.setContent("Test message")
				
				//Sets the webhook icon. Unlike the name this does not persist through refresh, and will not overwrite the default webhook icon
				.setIcon("https://upload.wikimedia.org/wikipedia/"
						+ "commons/5/51/Color_circle_%28hue-sat%29.png")
				
				//Adds the embed from above
				.addEmbed(e);

		//Sends the constructed message
		w.send();													
	}
}
