package d.studio.test.comandos;

import d.studio.test.Core;
import d.studio.test.utils.utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;


public class fly implements CommandExecutor {

    ConsoleCommandSender consola = Bukkit.getConsoleSender();

    private final Core plugin;

    public fly(Core plugin) {
        this.plugin = plugin;
        plugin.getCommand("fly").setExecutor(this);
    }


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;

            if (p.hasPermission("Core.staff")) {
                if (p.isFlying()) {

                    p.setAllowFlight(false);
                    p.setFlying(false);
                    utils.message(p, ("&c Fly desactivado."));

                } else {
                    p.setAllowFlight(true);
                    p.setFlying(true);
                    utils.message(p, ("&e Fly activado."));

                }
            } else {
                utils.message(p, plugin.getCustomConfig().getString("prefix")+"&cNo tienes permisos para ejecutar el comando.");
            }
        }
        return false;
    }
}
