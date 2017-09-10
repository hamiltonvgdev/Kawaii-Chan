package CommandUtil;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class CommandContainer 
{
	public String invoke;
	public String[] Message;
	public MessageReceivedEvent event;
	
	public CommandContainer(String invoke, String[] message, MessageReceivedEvent event)
	{
		this.invoke = invoke;
		this.Message = message;
		this.event = event;
	}
}
