package edu.cccc.cougarmail.jpatt907.HellHounds;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;


public class HellHoundsCommand implements CommandExecutor {
	
	//from here
	public static HellHounds plugin;

	public HellHoundsCommand(HellHounds instance) {
		plugin = instance;
}
	//to here is stuff you will added to pretty much every class so you can use the plugin instance.
	//the classes that have this are registered in the generic section of the main class
	
//this is the listener to use commands, don't forget the @Override or it wont work
// the 	public boolean onCommand(CommandSender sender, Command command,
//	String label, String[] args) is generic and will be used by all command listeners
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
	       if (!(sender instanceof Player)) return false;  //check to make sure the command didnt come from console
	        Player player = (Player)sender;
	              if (!player.isOp()) return false;
	        
		if (args.length == 0)
			
		{	
			//this spawns wolfs, stores them in a list for later killing, and sets a metadata value that they carry
			//to identify them as hellhounds in the Event Listener Class
			
			ArrayList<Entity> wolves = new ArrayList<Entity>();

			int amount = 8;
	        for (int i = 0; i < amount; i++) {
	            Wolf newWolf = (Wolf) player.getWorld().spawnCreature(player.getLocation(), EntityType.WOLF); 
	           //If you put CREEPER instead of WOLF it would spawn creepers instead, the javadocs for bukkit
	            //list the valid entity types but you can't outright spawn them all because some require
	            //additional information (like spawning an NPC)
	           newWolf.setTamed(true);
	           newWolf.setOwner(player); //make whoever spawned them the owner
	           newWolf.setFireTicks(10000); //lights them on fire for 10000 ticks, one second = 20 ticks
	           newWolf.setAngry(true); //this actuall doesnt works since they are tamed
	           
	           newWolf.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000, 1)); 
	           
	           newWolf.setMetadata("HellHound", new FixedMetadataValue(plugin, true));
	           wolves.add(newWolf); //add them to the arraylist so we can find them later
	           WolfTimer.wolfTimer(plugin, newWolf);  //here I am passing plugin to the timer instead of registering the timer
	                                                   //class and having it get its own instance.
	           }
		}
		
		return true;
	}
	
}	
