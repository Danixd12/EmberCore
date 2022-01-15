package d.studio.test;

import d.studio.test.comandos.broadcast;
import d.studio.test.comandos.fly;
import d.studio.test.comandos.gamemode.gamemode_creative;
import d.studio.test.comandos.gamemode.gamemode_spectator;
import d.studio.test.comandos.gamemode.gamemode_survival;
import d.studio.test.comandos.reload;
import d.studio.test.comandos.scoreboardDisable;
import d.studio.test.comandos.vanish;
import d.studio.test.events.joinEvent;
import d.studio.test.events.leaveEvent;
import d.studio.test.events.selectorOpenEvent;
import d.studio.test.gui.GUICommand;
import d.studio.test.gui.guiInteractEvent;
import d.studio.test.inventory.enderPearlEvent;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;

public final class Core extends JavaPlugin implements Listener {
	// imports
	ConsoleCommandSender consola = Bukkit.getConsoleSender();

	private static File file;
	private static FileConfiguration customFile;

	@Override
	public void onEnable() {

		consola.sendMessage("Cargando comando y eventos...");

		// fly
		new fly(this);
		// gamemode
		new gamemode_creative(this);
		new gamemode_survival(this);
		new gamemode_spectator(this);
		// vanish
		new vanish(this);
		// reload
		new reload(this);
		// broadcast
		new broadcast(this);
		// disable scoreboard
		new scoreboardDisable(this);
		// explosive bow
		// new explosiveBow(this);
		// gui
		getCommand("gui").setExecutor(new GUICommand());

		// config file
		createCustomConfig();

		// eventos
		PluginManager pl = getServer().getPluginManager();

		pl.registerEvents(new joinEvent(), this);

		new BukkitRunnable() {

			@Override
			public void run() {

				for (Player player : Bukkit.getOnlinePlayers()) {
					// TODO implement scoreboard updater
				}

			}

		}.runTaskTimer(this, 20L, 20L);

		pl.registerEvents(new leaveEvent(), this);
		
		pl.registerEvents(new selectorOpenEvent(), this);
		pl.registerEvents(new guiInteractEvent(), this);
		
		pl.registerEvents(new enderPearlEvent(), this);
		
		consola.sendMessage("Carga completada, plugin habilitado correctamente.");

	}

	// CONFIG
	public FileConfiguration getCustomConfig() {
		return this.customFile;
	}

	private void createCustomConfig() {
		file = new File(getDataFolder(), "config.yml");
		if (!file.exists()) {
			file.getParentFile().mkdirs();
			saveResource("config.yml", false);
		}

		customFile = new YamlConfiguration();
		try {
			customFile.load(file);
		} catch (IOException | InvalidConfigurationException e) {
			e.printStackTrace();
		}
	}

	public void reload() {
		customFile = YamlConfiguration.loadConfiguration(file);
	}

	@Override
	public void onDisable() {
		consola.sendMessage("El plugin se deshabilito");
	}
}
