package Commands;

import java.util.ArrayList;
import java.util.HashMap;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;

public class MapStuff implements Command
{
	HashMap<String, String> ncs;
	
	public boolean called(String[] message, MessageReceivedEvent event)
	{
		ncs = new HashMap<String, String>();
		
		ncs.put("MP - Revive", "Used to position the player after he dies. "
				+ "Please format it as x-y, for the player's x/y respawn coordinates.");
		ncs.put("TL - Normal", "This is the layer for the normal, solid tiles.");
		ncs.put("TL - Hurt", "This layer is for tiles that hurt the player."
				+ " Please have one tile for each damage number, "
				+ "so one layer for tiles that do one damage to the player, "
				+ "another for two, another for three, etc."
				+ " Please include the damage dealt as a custom property in the layer");
		ncs.put("TL - Death", "This is the layer for the instakill tiles");
		ncs.put("TL - Portal", "This is the layer for the portal tiles that transports the "
				+ "player to a different map. Please include the health cost for travel, "
				+ "and the name of the map destination as custom layer properties.");
		return true;
	}

	public void action(String[] message, MessageReceivedEvent event) 
	{
		event.getAuthor().openPrivateChannel().complete();
		event.getAuthor().getPrivateChannel().
			sendMessage("Hello " + event.getAuthor().getName() + " sama").complete();
		event.getAuthor().getPrivateChannel().
			sendMessage("You have requested the naming convention for all Tiled Maps").complete();
		event.getAuthor().getPrivateChannel().
			sendMessage("Keep in mind that this is a work in progress thing, so this can "
					+ "change rapidly. Please keep up to date with this as often as possible").complete();
		event.getAuthor().getPrivateChannel().
			sendMessage("The naming conventions are formated as \"-----ID-Name-Description\", with the ID being: ").complete();
		event.getAuthor().getPrivateChannel().
			sendMessage("MP = Map Property" + "\n" +
					"TL = Tile Layer").complete();
		event.getAuthor().getPrivateChannel().
			sendMessage("The current naming conventionts are: ").complete();
		
		String response = "-----";
		Object[] keyset = ncs.keySet().toArray();
		Object[] valueset = ncs.values().toArray();
		
		for(int i = 0; i < ncs.keySet().size(); i ++)
		{
			response = response + keyset[i] + " - " + valueset[i] + "\n" + "-----";
		}
		System.out.println(response);
		event.getAuthor().getPrivateChannel().
			sendMessage("-----" + "\n" + response).complete();
	}

	public void done(boolean safe, MessageReceivedEvent event) 
	{
		
	}

}
