package d.studio.test.inventory;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EnderPearl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;


public class enderPearlEvent implements Listener {

	@EventHandler
	public void teleportPearl(ProjectileHitEvent event, Player p) {

		if (!(event.getEntity() instanceof EnderPearl)) {

			EnderPearl enderpearl = (EnderPearl) event.getEntity();

			Player player = (Player) enderpearl.getShooter();

			player.teleport(enderpearl.getLocation());
			
			p.sendMessage("asd");

		}
		
		ItemStack pearl = new ItemStack(Material.ENDER_PEARL);

		ItemMeta meta_pearl = pearl.getItemMeta();

		meta_pearl.setDisplayName(ChatColor.GREEN + "EnderButt");
		pearl.setItemMeta(meta_pearl);

		p.getInventory().setItem(5, pearl);

	}

}
