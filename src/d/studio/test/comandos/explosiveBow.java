/*package d.studio.test.comandos;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import d.studio.test.Core;
import d.studio.test.utils.utils;

public class explosiveBow implements CommandExecutor{

	private final Core plugin;
	
	 public explosiveBow (Core plugin) {

	        this.plugin = plugin;
	        plugin.getCommand("explosivebow").setExecutor(this);
	    }
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		Player p = ( Player ) sender;
		utils.message(p, "&e ee");
		
		//ItemStack bow = new ItemStack(Material.BOW);
	
		PlayerInventory pi = p.getInventory();
		ItemStack[] bow = new ItemStack[]{new ItemStack(Material.BOW)};


		pi.addItem(bow);
		
		
		
		return false;
	}
	

}*/
