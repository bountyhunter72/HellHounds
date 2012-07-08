package edu.cccc.cougarmail.jpatt907.HellHounds;


import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.entity.Wolf;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.plugin.Plugin;



public class WolfTimer {
	public static void wolfTimer(Plugin plugin, final Wolf wolf) {
		plugin.getServer().getScheduler()
				.scheduleSyncDelayedTask(plugin, new Runnable() {

					public void run() {
						Location target = wolf.getLocation();
						
						wolf.getWorld().strikeLightningEffect(target);
						wolf.setHealth(0);

					}
				}, 300);
		return;
	}
}