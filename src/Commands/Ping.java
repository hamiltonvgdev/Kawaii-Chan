package Commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Ping implements Command
{

	public boolean called(String[] message, MessageReceivedEvent event) 
	{
		return true;
	}

	public void action(String[] message, MessageReceivedEvent event) 
	{
		event.getChannel().sendMessage("PONG!").complete();
	}

	public void done(boolean safe, MessageReceivedEvent event) 
	{
		
	}

}
