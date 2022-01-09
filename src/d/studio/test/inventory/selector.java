package d.studio.test.inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class selector implements Listener {

	 public static void onJoin_selector(Player p) {
		 
	     //INVENTORY

			PlayerInventory pi = p.getInventory();
			

			ItemStack star = new ItemStack(Material.NETHER_STAR);
			ItemMeta meta_star = star.getItemMeta();

			meta_star.setDisplayName(ChatColor.YELLOW + "Selector");
			star.setItemMeta(meta_star);
			
			p.getPlayer().getInventory().setItem(3, star);
			pi.addItem(star);


		 
		 }
		 
		 public static void onLeave_selector(Player p) {
			 
		     //INVENTORY
				PlayerInventory pi = p.getInventory();
				ItemStack star = new ItemStack(Material.NETHER_STAR);

			    pi.removeItem(star);
			 
			 }
}
