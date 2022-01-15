package d.studio.test.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class selectorOpenEvent implements Listener {

	// CLICK EVENT
	@EventHandler
	public void onInteract(PlayerInteractEvent event) {

		Player player = event.getPlayer();

		if (player.getItemInHand() != null && player.getItemInHand().getType() == Material.NETHER_STAR) {
			player.performCommand("gui");

		}
	}

}
