package Commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public interface Command 
{
	public boolean called(String[] message, MessageReceivedEvent event);
	public void action(String[] message, MessageReceivedEvent event);
	public void done(boolean safe, MessageReceivedEvent event);
}
