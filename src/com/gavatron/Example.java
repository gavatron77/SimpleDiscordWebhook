package com.gavatron;

import java.net.MalformedURLException;
import java.net.URL;

public class Example {
	public static void main(String[] args) throws MalformedURLException {
		Webhook w = new Webhook(new URL("WEBHOOK URL"));			//Sets the webhook URL and creates the webhook object, format as https://ptb.discord.com/api/webhooks/xxxxxxxxxxx
		w.setName("Gavatron77\'s Java Webhook Library");			//Sets the webhook name, if different names are used on different messages, they will stay different after page refresh
		w.setContent("Test message");								//Sets the contents of the webhook in text. To ping someone format as <@user_id>, to ping role format as <@&role_id>
		w.setAvatar("https://upload.wikimedia.org/wikipedia/"		//Sets the webhook icon. Unlike the name this does not persist through refresh, and will not overwrite the default webhook icon
				+ "commons/5/51/Color_circle_%28hue-sat%29.png");
		w.send();													//Sends the constructed message.
	}
}
