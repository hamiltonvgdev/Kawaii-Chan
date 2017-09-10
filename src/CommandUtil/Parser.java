package CommandUtil;

import java.util.ArrayList;

import Core.Config;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Parser 
{
	public CommandContainer parse(String raw, MessageReceivedEvent event)
	{
		ArrayList<String> split = new ArrayList<String>();
		String command = raw;
		command = command.replaceFirst(Config.TRIGGER, "");
		for(String s: command.split(" "))
		{
			split.add(s);
		}
		
		String invoke = split.get(0);
		String[] message = new String[split.size() - 1];
		split.subList(1, split.size()).toArray(message);
		
		return new CommandContainer(invoke, message, event);
	}
}
