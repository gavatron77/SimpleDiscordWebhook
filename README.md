# SimpleDiscordWebhook
Simple library to assemble Discord webhooks  
  
Author methods:  
Author a = new Author() - Creates the Author object  
a.setName(String) - Sets the name of the author  
a.setLink(String) - Sets the clickable link on the author name  
a.setIcon(String) - Sets the author icon  
a.getData() - Returns the raw Json data  
  
Embed methods:
Embed e = new Embed() - Creates the Embed object  
e.setTitle(String) - Sets the title of the embed  
e.setDesc(String) - Sets the text in the embed  
e.setColor(String) - Sets the embed color, decimal format  
e.setColor(int, int, int) - Sets the color, RGB format  
e.setColor(Color) - Sets the color, Java Color format  
e.setAuthor(Author) - Sets the author  
e.addImage(String) - Adds an image to the embed  
e.addThumbnail(String) - Adds a thumbnail image to the embed  
e.addTimestamp(String) - Adds a timestamp to the embed, YYYY-MM-DDTHH:MM:SS.MSSZ format  
e.getData() - Returns the raw Json data  
  
Webhook methods:  
Webhook w = new Webhook(String) - Creates the Webhook object and sets the URL  
w.setURL(String) - Sets the target URL  
w.setName(String) - Sets the webhook name, unique names persist per message  
w.setContent(String) - Sets the text contents of the next message  
w.setIcon(String) - Sets the webhook icon. After a page refresh, the icon resets to default  
w.addEmbed(Embed) - Adds an Embed object (see above) to the webhook  
w.addJsonEmbed(String) - Adds an embed to the webhook through raw JSON  
w.getEmbeds() - Returns a JsonArray (Gson) of embeds  
w.getData() - Returns the raw Json data being sent to Discord. Useful for debugging  
w.send() - Sends the message  
w.send(boolean) - If boolean is true content, name, icon, and embeds will be reset to default  
w.getString() - Same as w.getData(), but returns a string.  
  
All of this is based off of this guide, if you need examples please visit it.  
https://birdie0.github.io/discord-webhooks-guide
