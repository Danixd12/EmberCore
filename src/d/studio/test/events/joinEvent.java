package d.studio.test.events;


import d.studio.test.inventory.enderPearl;
import d.studio.test.inventory.selector;
import d.studio.test.scoreboard.bossbar_handler;
import d.studio.test.scoreboard.scoreboard_handler;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.inventivetalent.bossbar.BossBar;
import org.inventivetalent.bossbar.BossBarAPI;

import java.awt.TextComponent;
import java.lang.reflect.InvocationTargetException;


public class joinEvent implements Listener {


	//create scoreboard
	private void createScoreboard(Player p) {
        scoreboard_handler helper = scoreboard_handler.createScore(p);
       // helper.regenRows(plugin.getCustomConfig().toString("1"), null);
        
        if (p.hasPermission("Core.staff")) { // TODO Custom scoreboard config
            helper.setTitle("&cEmber&4PvP &7(Hub)");
            helper.setSlot(6, "&7&m--------------------------------");
            helper.setSlot(5, "&b" + p.getDisplayName());
            helper.setSlot(4, "");
            helper.setSlot(3, "&cOnline: &7" + Bukkit.getOnlinePlayers().size() + "/500");
            helper.setSlot(2, "&7&m---------------------------------");
            helper.setSlot(1, "&7emberpvp.net");
        } else {
            helper.setTitle("&cEmber&4PvP &7(Hub)");
            helper.setSlot(6, "&7&m--------------------------------");
            helper.setSlot(5, "&7" + p.getDisplayName());
            helper.setSlot(4, "");
            helper.setSlot(3, "&cOnline: &7" + Bukkit.getOnlinePlayers().size() + "/500");
            helper.setSlot(2, "&7&m--------------------------------");
            helper.setSlot(1, "&7emberpvp.net");
        }
	}
	
	//update scoreboard
	public void updateScoreboard(Player p) {
		if(scoreboard_handler.hasScore(p)) {
			scoreboard_handler helper = scoreboard_handler.getByPlayer(p);
			
			String players = String.valueOf(Bukkit.getOnlinePlayers().size());
			
			helper.setSlot(4, players);
		}
		
	
		
	}

    
	
    // EVENTOS
    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {

        Player p = event.getPlayer();
        Bukkit.broadcastMessage(ChatColor.RED + "" + ChatColor.BOLD + p.getDisplayName() + ChatColor.GRAY + " has joined the server.");

        if (p.hasPermission("Core.staff")) {
            p.setGameMode(GameMode.CREATIVE);
        }
        
        
        //create scoreboard
        createScoreboard(p);
        
        // inventory
        enderPearl.onJoin_ender(p);
        selector.onJoin_selector(p);

        
    }

}
