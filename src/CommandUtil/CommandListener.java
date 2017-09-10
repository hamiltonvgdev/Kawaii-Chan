package CommandUtil;

import Core.Config;
import Core.Core;
import net.dv8tion.jda.core.events.ReadyEvent;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class CommandListener extends ListenerAdapter
{
	@Override
	public void onMessageReceived(MessageReceivedEvent event)
	{
		if(event.getMessage().getContent().startsWith(Config.TRIGGER) && 
				!(event.getMessage().getAuthor().getId()).equals(event.getJDA().getSelfUser().getId()))
		{
			Core.handleCommand(Core.parser.parse(event.getMessage().getContent().toLowerCase(), event), event);
		}
	}
	
	@Override
	public void onReady(ReadyEvent event)
	{
		//Core.log("status", "Logged as " + event.getJDA().getSelfUser().getName());
	}
}
