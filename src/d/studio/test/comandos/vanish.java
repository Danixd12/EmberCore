package d.studio.test.comandos;

import d.studio.test.Core;
import d.studio.test.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class vanish implements CommandExecutor {

    private final Core plugin;

    public vanish(Core plugin) {
        this.plugin = plugin;
        plugin.getCommand("vanish").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    	
        if (sender instanceof Player) {
            Player p = ( Player ) sender;

            if (p.hasPermission("Core.staff")) {
                if (!p.hasPotionEffect(PotionEffectType.INVISIBILITY)){
                    p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,1000000, 1));
                    utils.message(p, (plugin.getCustomConfig().getString("prefix")+"&e Vanish activated."));
                } else {
                    p.removePotionEffect(PotionEffectType.INVISIBILITY);
                    utils.message(p, ("&c Vanish desactivated."));
                }

            } else {
                utils.message(p, plugin.getCustomConfig().getString("prefix")+"&cNo perms.");
            }
        }
        return false;
    }
}
