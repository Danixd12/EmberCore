package d.studio.test.comandos;

import d.studio.test.Core;
import d.studio.test.utils.utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class reload implements CommandExecutor {

    private final Core plugin;

    public reload(Core plugin) {
        this.plugin = plugin;
        plugin.getCommand("core-reload").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {


            Player p = (Player) sender;

            if(p.hasPermission("Core.reload")) {
                plugin.reload();;
                utils.message(p, plugin.getCustomConfig().getString("prefix")+"&aRecargando config.");
            } else {
                utils.message(p, plugin.getCustomConfig().getString("prefix")+"&cNo tienes permisos para ejecutar el comando.");
            }


        return false;
    }
}
