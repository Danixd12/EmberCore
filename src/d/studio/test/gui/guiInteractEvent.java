package d.studio.test.gui;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import net.md_5.bungee.api.ChatColor;

public class guiInteractEvent implements Listener{

	@EventHandler
	public void clickEvent(InventoryClickEvent event) {
	
		if(event.getClickedInventory().getTitle().equalsIgnoreCase(ChatColor.GOLD + "Game Selector")) {
			Player p = (Player) event.getWhoClicked();
		
			switch(event.getCurrentItem().getType()) {
			case WOOL: //hcf
				p.sendMessage("asd");
				p.closeInventory();
				break;
			case FISHING_ROD: //practice
				p.sendMessage(ChatColor.RED + "This server is current whitelisted.");
				
				p.closeInventory();
				break;
			case DIAMOND_SWORD:
				p.sendMessage(ChatColor.RED + "This server is current whitelisted.");
				
				p.closeInventory();
				break;
			}
			
			event.setCancelled(true);
			
		}
		
		
	}
	
}
