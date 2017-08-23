package me.jadenPete.ItemKillCount;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

/*
 * This class listens for kills
 * and calls the Util class to work.
 */

public class Events implements Listener {
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event){
		Util.addKill(event.getEntity().getKiller(), false);
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent event){
		Util.addKill(event.getEntity().getKiller(), true);
	}
}
