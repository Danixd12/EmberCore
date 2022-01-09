package d.studio.test.comandos.gamemode;

import d.studio.test.Core;
import d.studio.test.utils.utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemode_survival implements CommandExecutor {

    private final Core plugin;

    public gamemode_survival(Core plugin) {
        this.plugin = plugin;
        plugin.getCommand("gms").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            if(p.hasPermission("Core.staff")){
                p.setGameMode(GameMode.SURVIVAL);
                utils.message(p,"&a"+plugin.getCustomConfig().getString("prefix")+"Activando el modo survival.");
            } else {
                utils.message(p, plugin.getCustomConfig().getString("prefix")+"&cNo tienes permisos para ejecutar el comando.");
            }

        }
        return false;
    }
}
