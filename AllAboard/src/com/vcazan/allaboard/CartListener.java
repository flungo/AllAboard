package com.vcazan.allaboard;

import java.util.logging.Logger;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;


public class CartListener implements Listener {

		public final AllAboard plugin;
		
	    Logger log = Logger.getLogger("Minecraft");

		public CartListener(AllAboard instance) {
			
			this.plugin = instance;
		}

		@EventHandler
		public void onVehicleEntityCollision(VehicleEntityCollisionEvent event){
			Vehicle cart = event.getVehicle();
			Entity hitWhat = event.getEntity();
			
			log.info("Colission");

			if (cart instanceof Minecart && !(hitWhat instanceof Minecart)){
				if (hitWhat instanceof Player && !cart.isEmpty()){
					event.setCancelled(true);
				}else if (cart.isEmpty()){
					event.setCancelled(true);
					cart.setPassenger(hitWhat);
				}
				
			}

		}
		
}

