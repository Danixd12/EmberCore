package d.studio.test.comandos;

import d.studio.test.Core;
import d.studio.test.scoreboard.scoreboard_handler;
import d.studio.test.utils.utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class scoreboardDisable implements CommandExecutor {

    private final Core plugin;

    public scoreboardDisable(Core plugin) {

        this.plugin = plugin;
        plugin.getCommand("scoreboard-disable").setExecutor(this);
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;

                scoreboard_handler helper = scoreboard_handler.getByPlayer(p);

                helper.removeRows(10);
                utils.message(p, "&aScoreboard disabled.");
                

        return false;
    }
}
