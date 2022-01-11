package d.studio.test.inventory;


import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;

public class enderPearl implements Listener{
	
	 
	 public static void onJoin_ender(Player p) {
	 
     //INVENTORY

		PlayerInventory pi = p.getInventory();
		

		ItemStack pearl = new ItemStack(Material.ENDER_PEARL, 0);
		ItemMeta meta_pearl = pearl.getItemMeta();

		meta_pearl.setDisplayName(ChatColor.GREEN + "EnderButt");
		pearl.setItemMeta(meta_pearl);
		
		p.getPlayer().getInventory().setItem(5, pearl);
		pi.addItem(pearl);


	 
	 }
	 
	 public static void onLeave_ender(Player p) {
		 
	     //INVENTORY

			PlayerInventory pi = p.getInventory();
			ItemStack[] pearl = new ItemStack[]{new ItemStack(Material.ENDER_PEARL, 2)};

			pi.removeItem(pearl);
		 
		 }
}
