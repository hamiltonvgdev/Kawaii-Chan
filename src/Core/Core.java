package Core;

import java.util.HashMap;

import javax.swing.JOptionPane;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDA.Status;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import CommandUtil.CommandContainer;
import CommandUtil.CommandListener;
import CommandUtil.Parser;
import Commands.Command;
import Commands.Help;
import Commands.Kill;
import Commands.MapStuff;
import Commands.Ping;
import Commands.ToDoList;

public class Core 
{
	public static JDA jda;
	
	public static final Parser parser = new Parser();
	
	public static HashMap<String, Command> commands = new HashMap<String, Command>();
	
	static long tick;
	static long time;
	
	public static void main(String[] args)
	{	
		try{
			
			tick = System.currentTimeMillis();
			
			jda = new JDABuilder(AccountType.BOT).addEventListener(new CommandListener()).
					setToken(Config.TOKEN).buildBlocking();
			jda.setAutoReconnect(Config.AUTORECONNECT);
			
			jda.getTextChannelsByName("the_kawaii_lair", true).get(0).
					sendMessage("Minasan Ohayogozaimasu!" + "\n"
					+ "Your personalized helper bot Kawaii-Chan is now online!" + "\n"
					+ "Since Kawaii-Chan is currently ran off of Hummus-sama's computer, her "
						+ "online presence is subjected to massive fluctuations." + "\n"
					+ "My current uptime schedule any time after 8:00 to an undisclosued time"
					+ ""+ "\n"
					+ "Please use this oppurtunity to the fullest potential, and if you "
						+ "don't know how, the \"!help\" command is always here to help!").
						complete();
			
		
			
			commands.put("ping", new Ping());
			commands.put("help", new Help());
			commands.put("todolist", new  ToDoList());
			commands.put("overload-order-66", new Kill());
			commands.put("mapstuff", new MapStuff());
			
			while(jda.getStatus() == Status.CONNECTED)
			{	
				if(System.currentTimeMillis() - tick >= 1000)
				{
					time ++;
					tick = System.currentTimeMillis();
				}
			}
			
			JOptionPane.showMessageDialog(null, "Total Run Time: " + time + " seconds");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void handleCommand(CommandContainer CC, MessageReceivedEvent event)
	{
		if(commands.containsKey(CC.invoke))
		{
			boolean safe = commands.get(CC.invoke).called(CC.Message, event);
			
			if(safe)
			{
				commands.get(CC.invoke).action(CC.Message, event);
				commands.get(CC.invoke).done(safe, event);
			}else
			{
				commands.get(CC.invoke).done(safe, event);
			}
		}
	}
}
