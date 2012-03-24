package com.vcazan.allaboard;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.inventory.ItemStack;

public class CartLeave implements Listener  {
	
	public static AllAboard plugin;
    Logger log = Logger.getLogger("Minecraft");

	public CartLeave(AllAboard instance) {
		plugin = instance;
	}

	@EventHandler
	public void onVehicleExit(VehicleExitEvent event){
		Vehicle v = event.getVehicle();
		if (plugin.enabled){
		v.remove();
		if (plugin.getConfig().getBoolean("drop-cart")) {
			Location loc = v.getLocation();
			World w = loc.getWorld();
			ItemStack cart = new ItemStack(Material.MINECART);
			w.dropItem(loc, cart);
		}
		}
	}

}