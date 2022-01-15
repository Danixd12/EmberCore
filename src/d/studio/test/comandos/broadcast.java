package d.studio.test.comandos;

import d.studio.test.Core;
import d.studio.test.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class broadcast implements CommandExecutor {
    private final Core plugin;

    public broadcast(Core plugin) {
        this.plugin = plugin;
        plugin.getCommand("broadcast").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

        String message = "";
        if(p.hasPermission("Core.broadcast")) {
            if(args.length >= 1) {
                for (int i = 0; i < args.length; i++) {
                    message = message + args[i] + " ";
                    
                }
                String showMessage = plugin.getCustomConfig().getString("broadcast_prefix") + message;
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', showMessage));
            } else {
                utils.message(p, "&eYou must specify the mssage: /bc <message> (local) .");
            }
        } else {

            utils.message(p, plugin.getCustomConfig().getString("prefix")+"&cNo perms.");
        }

        return false;

    }
}
