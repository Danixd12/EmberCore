package d.studio.test.events;

import d.studio.test.inventory.enderPearl;
import d.studio.test.inventory.selector;
import d.studio.test.scoreboard.scoreboard_handler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.lang.reflect.InvocationTargetException;

public class leaveEvent implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent event) throws NoSuchMethodException, NoSuchFieldException, InvocationTargetException, IllegalAccessException {
    Player p = event.getPlayer();
    if(scoreboard_handler.hasScore(p)) {
        scoreboard_handler.removeScore(p);
    }
    
    // inventory
    enderPearl.onLeave_ender(p);
    //selector.onLeave_selector(p);
    }
}
