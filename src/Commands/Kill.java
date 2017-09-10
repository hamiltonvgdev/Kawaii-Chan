package Commands;

import Core.Core;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Kill implements Command
{

	public boolean called(String[] message, MessageReceivedEvent event)
	{
		return true;
	}

	public void action(String[] message, MessageReceivedEvent event) 
	{
		event.getChannel().sendMessage("Goo Bai!").complete();
		Core.jda.shutdown();
	}

	public void done(boolean safe, MessageReceivedEvent event) 
	{
		
	}

}
