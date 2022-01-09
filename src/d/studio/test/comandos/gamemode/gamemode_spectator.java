package d.studio.test.comandos.gamemode;

import d.studio.test.Core;
import d.studio.test.utils.utils;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class gamemode_spectator implements CommandExecutor {

    private final Core plugin;

    public gamemode_spectator(Core plugin) {
        this.plugin = plugin;
        plugin.getCommand("gmsp").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {

            Player p = (Player) sender;
            if(p.hasPermission("Core.staff")){
                p.setGameMode(GameMode.SPECTATOR);
                utils.message(p,"&a"+plugin.getCustomConfig().getString("prefix")+"Activando el modo espectador.");
            } else {
                utils.message(p, plugin.getCustomConfig().getString("prefix")+"&cNo tienes permisos para ejecutar el comando.");
            }

        }
        return false;
    }
}
