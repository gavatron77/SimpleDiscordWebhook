# SimpleDiscordWebhook
Simple library to assemble Discord webhooks

Methods:
	Webhook w = new Webhook(URL)	- Creates the webhook object and sets the URL
	w.setName(name)					- Sets the webhook name, unique names persist per message
	w.setContent(words)				- Sets the text contents of the next message
	w.setAvatar(direct image link)	- Sets the webhook icon. After a page refresh, the icon resets to default
	w.send()						- Sends the message
