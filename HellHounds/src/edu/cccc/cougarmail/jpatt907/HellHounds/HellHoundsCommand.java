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
	public static HellHounds plugin;

	public HellHoundsCommand(HellHounds instance) {
		plugin = instance;
}

	@Override
	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {
	       if (!(sender instanceof Player)) return false;
	        Player player = (Player)sender;
	              if (!player.isOp()) return false;
		if (args.length == 0)
			
		{	
			ArrayList<Entity> wolves = new ArrayList<Entity>();

			int amount = 8;
	        for (int i = 0; i < amount; i++) {
	            Wolf newWolf = (Wolf) player.getWorld().spawnCreature(player.getLocation(), EntityType.WOLF); 
	           
	           newWolf.setTamed(true);
	           newWolf.setOwner(player);
	           newWolf.setFireTicks(10000);
	           newWolf.setAngry(true);
	           newWolf.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 10000, 1));
	           newWolf.setMetadata("HellHound", new FixedMetadataValue(plugin, true));
	           wolves.add(newWolf);
	           WolfTimer.wolfTimer(plugin, newWolf);
	           }
		}
		
		return true;
	}
	
}	
