package Commands;

import java.io.File;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class Help implements Command
{

	public boolean called(String[] message, MessageReceivedEvent event) 
	{
		return true;
	}

	public void action(String[] message, MessageReceivedEvent event) 
	{
		event.getAuthor().openPrivateChannel().complete();
		event.getAuthor().getPrivateChannel().sendMessage("Kawaii Chan here! " + "\n"
				+ "These are all the commands that I can receive"  + "\n"
				+ "Please remember that you need to start each command with a \"!\" to get my attention" + "\n" + "\n"
				+ "!help: get the help list that you are reading right now" + "\n" + "\n"
				+ "!ping: PONG!" + "\n" + "\n"
				+ "!todolist: gives you your personalized to do list, as assigned by Hummus-Sama" ).
				complete();
	}

	public void done(boolean safe, MessageReceivedEvent event) 
	{
		
	}
	
}
