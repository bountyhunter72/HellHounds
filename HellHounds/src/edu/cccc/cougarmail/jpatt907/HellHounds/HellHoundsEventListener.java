package edu.cccc.cougarmail.jpatt907.HellHounds;

import java.util.logging.Logger;
import org.bukkit.entity.Wolf;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;





public class HellHoundsEventListener implements Listener{
	public static HellHounds plugin;
	
    public HellHoundsEventListener(HellHounds instance) {

        plugin = instance;
}
Logger log;

@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = true)
public void onEntityDam(EntityDamageByEntityEvent event) {
   if ((event.getDamager() instanceof Wolf)) {
	 if(event.getDamager().hasMetadata("HellHound"))
	 {
		 event.getEntity().setFireTicks(100);
}
   }
   }

}
