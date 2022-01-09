package d.studio.test.comandos.gamemode;

import d.studio.test.Core;
//import d.studio.test.files.config;
import d.studio.test.utils.utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ResourceBundle;

public class gamemode_creative implements CommandExecutor {

    private final Core plugin;

    public gamemode_creative(Core plugin) {

        this.plugin = plugin;
        plugin.getCommand("gmc").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            if(p.hasPermission("Core.staff")){
            	
            	
                p.setGameMode(GameMode.CREATIVE);
                utils.message(p, "&a"+plugin.getCustomConfig().getString("prefix")+" activando el modo creativo.");
            } else {
                utils.message(p, plugin.getCustomConfig().getString("prefix")+"&cNo tienes permisos para ejecutar el comando.");
            }

        }
        return false;
    }
}
