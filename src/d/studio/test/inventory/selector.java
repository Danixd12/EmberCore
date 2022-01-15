package d.studio.test.inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class selector implements Listener {

	 public static void onJoin_selector(Player p) {
		 
	     //INVENTORY
           
			PlayerInventory pi = p.getInventory();
			

			ItemStack star = new ItemStack(Material.NETHER_STAR);
			ItemMeta meta_star = star.getItemMeta();
			
			meta_star.setDisplayName(ChatColor.YELLOW + "Server Selector");
			star.setItemMeta(meta_star);
			
			p.getInventory().setItem(3, star);
			
		 
		 }
		 
		 public static void onLeave_selector(Player p) {
			 
		     //INVENTORY
				PlayerInventory pi = p.getInventory();
			
				ItemStack star = new ItemStack(Material.NETHER_STAR, 2);
				
			    
				pi.removeItem(star);
			 
			 }

}