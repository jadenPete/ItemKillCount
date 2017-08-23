package me.jadenPete.ItemKillCount;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/*
 * This is the core class,
 * it performes the process.
 */

public class Util {
	public static void addKill(Player killer, boolean isPlayer){
		if(killer != null){
			ItemStack weapon = killer.getInventory().getItemInMainHand();
			ItemMeta weaponMeta = weapon.getItemMeta();
			List<String> weaponLore = weaponMeta.getLore();
			
			String killPrefix = "Mobs Killed: ";
			int killCount = 1;
			int killLine = 0;
			
			if(isPlayer){
				killPrefix = "Players Killed: ";
			}
			
			// If the lore doesn't exist, create it.
			if(weaponLore == null) {
				weaponLore = new ArrayList<String>();
			}
			
			// Find where we need to add/update the kill count.
			for(killLine = 0; killLine < weaponLore.size(); killLine++){
				if(weaponLore.get(killLine).startsWith(killPrefix)){
					break;
				}
			}
			
			// Do we need to add it or update it?
			if(weaponLore.size() > killLine){
				killCount = Integer.parseInt(weaponLore.get(killLine).replace(killPrefix, "")) + 1;
				weaponLore.set(killLine, killPrefix + killCount);
			} else {
				weaponLore.add(killPrefix + killCount);
			}
			
			// Once the lore is patched, update the item.
			weaponMeta.setLore(weaponLore);
			weapon.setItemMeta(weaponMeta);
		}
	}
}
