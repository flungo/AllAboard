package com.vcazan.allaboard;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class AllAboard extends JavaPlugin {
	
    private final CartListener cartListener = new CartListener(this);
    private final CartLeave cartLeave = new CartLeave(this);
    
    public PluginManager pm;
    
    public PluginDescriptionFile pdf;

    Logger log = Logger.getLogger("Minecraft");
    Boolean enabled = true;
    
    public void onEnable(){
    	pm = this.getServer().getPluginManager();
    	pdf = this.getDescription();

    	pm.registerEvents(this.cartListener, this);
    	pm.registerEvents(this.cartLeave, this);
    	
    	logMessage("Enabled");
    }
    
    public void onDisable(){
    	logMessage("Disabled");

	}
    
	public void logMessage(String msg) {
		logMessage(msg, Level.INFO);
	}
	
	public void logMessage(String msg, Level level) {
		log.log(level, "[" + pdf.getName() + "] " + msg);
	}
    
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
    	 
    	 if(cmd.getName().equalsIgnoreCase("autoboard")){
    	   if (sender.isOp()){
    		   if (enabled){
    			   sender.sendMessage("AllAboard is now disabed");
    			   enabled = false;
    		   }else{
    			   sender.sendMessage("AllAboard is now enabled");
    			   enabled = true;

    		   }
    	   }
    	   return true;
    	 }
    	 return false; }
    
}