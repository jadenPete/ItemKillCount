package me.jadenPete.ItemKillCount;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	// Fired when the plugin is enabled.
	@Override
	public void onEnable(){
		// Handle events in the Events class.
		getServer().getPluginManager().registerEvents(new Events(), this);
	}
	
	// Fired when the plugin is disabled.
	// Empty because there's nothing to do.
	@Override
	public void onDisable(){
		
	}
}
