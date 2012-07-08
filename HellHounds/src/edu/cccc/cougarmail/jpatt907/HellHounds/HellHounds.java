package edu.cccc.cougarmail.jpatt907.HellHounds;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Server;


import edu.cccc.cougarmail.jpatt907.HellHounds.*;




public class HellHounds extends JavaPlugin {
	public static Logger log = Logger.getLogger("Minecraft");
	Server _server = null;
	JavaPlugin _parent = null;
	public static HellHounds plugin;
	
	HellHoundsEventListener _entityListener = null;
	HellHoundsCommand _commandExecutor = null;
	public String _dataFolder;
	public boolean _isShutdown = false;

	public boolean Initialize(Server server, JavaPlugin parent,
			String dataFolder) {
		this._server = server;
		this._parent = parent;

		
		this._entityListener = new HellHoundsEventListener(this);
		this._commandExecutor = new HellHoundsCommand(this);
		this._dataFolder = dataFolder;
		getServer().getPluginManager().registerEvents(
				new HellHoundsEventListener(this), this._parent);

		return true;
	}
    
    public void onEnable() {
    	log = this.getLogger();
        
        	
    	CommandExecutor myExecutor = new HellHoundsCommand(this);
    	getCommand("hounds").setExecutor(myExecutor);

        getServer().getPluginManager().registerEvents(new  HellHoundsEventListener(null),this);

        
        
    	}
    

    public void onDisable() {
 
    }


}
    