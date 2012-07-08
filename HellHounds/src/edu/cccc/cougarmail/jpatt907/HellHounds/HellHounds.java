package edu.cccc.cougarmail.jpatt907.HellHounds;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Server;


import edu.cccc.cougarmail.jpatt907.HellHounds.*;




public class HellHounds extends JavaPlugin {
	
	//all of this is generic, you can reuse it and just change the names.
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
    	
    	//This is stuff that Happens when the plugin Enables, if you wanted to have the plugin log a message when it enables you would put it here
    	log = this.getLogger();
        
    	
    	// you can put your onCommand stuff in this class, but if you want to put it somewhere else you make a command executer
    	//and tell is what class will handle commands, like this
        	
    	CommandExecutor myExecutor = new HellHoundsCommand(this);
    	getCommand("hounds").setExecutor(myExecutor);

    	//this makes the event listener actually listen
        getServer().getPluginManager().registerEvents(new  HellHoundsEventListener(null),this);

        
        
    	}
    

    public void onDisable() {
 //stuff that happens when server is shutting down
    }


}
    