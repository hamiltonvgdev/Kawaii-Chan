package Commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import Core.Config;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class ToDoList implements Command
{
	Document html;
	ArrayList<String> tasks;
	
	public boolean called(String[] message, MessageReceivedEvent event) 
	{
		tasks = new ArrayList<String>();
		
		try {
			File in = new File("res/VGDev ToDoList.html");
			html = Jsoup.parse(in, "UTF-8");
			
			Elements bigDiv = html.select("div#" + event.getAuthor().getDiscriminator());
			for(Element task: bigDiv.select("div.task"))
			{
				if(!task.text().equals(""))
				{
					tasks.add(task.text());
				}
			}
			
			if(tasks.size() >= 1)
			{
				return true;
			}else
			{
				return false;
			}
		} catch (IOException e) {
			return false;
		}
	}

	public void action(String[] message, MessageReceivedEvent event) 
	{
		event.getAuthor().openPrivateChannel().complete();
		event.getAuthor().getPrivateChannel().
			sendMessage("Hello " + event.getAuthor().getName() + " sama").complete();
		event.getAuthor().getPrivateChannel().
			sendMessage("Here are all you assigned tasks:").complete();
		event.getAuthor().getPrivateChannel().
			sendMessage("--").complete();
		event.getAuthor().getPrivateChannel().
			sendMessage("-").complete();
		
		for(String s: tasks)
		{
			event.getAuthor().getPrivateChannel().
				sendMessage((tasks.indexOf(s) + 1) + ". " + s).complete();
		}
		
		event.getAuthor().getPrivateChannel().
			sendMessage("-").complete();
		event.getAuthor().getPrivateChannel().
			sendMessage("--").complete();
		
		event.getAuthor().getPrivateChannel().
			sendMessage("If you have any questions about your tasks"
					+ " or have completed one of the previously listed tasks, "
					+ "please contact Hummus-Sama for clarification.").complete();
	}

	public void done(boolean safe, MessageReceivedEvent event) 
	{
		if(!safe)
		{
			event.getAuthor().getPrivateChannel().
				sendMessage("Sorry " + event.getAuthor().getName() + ", but I cant seen to "
						+ "find your task list.").complete();
			
			event.getAuthor().getPrivateChannel().
				sendMessage("Either that means that you have completed all of you assignments, "
					+ "or something has gone terribly wrong.").complete();
			
			event.getAuthor().getPrivateChannel().
				sendMessage("Please contact Hummus-Sama for clarification.").complete();
		}else
		{
			event.getAuthor().getPrivateChannel().
				sendMessage("Work hard, and have a nice day!").complete();
		}
	}

}
