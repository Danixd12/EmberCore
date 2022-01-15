package d.studio.test.gui;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
 
import java.util.ArrayList;

public class GUICommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
 
        if(sender instanceof Player){
            Player player = (Player) sender;
            Inventory gui = Bukkit.createInventory(player, 36, ChatColor.GOLD + "Game Selector");
 
            //Menu Options(Items)
            ItemStack kits = new ItemStack(Material.WOOL); 
            ItemStack hcf =  new ItemStack(Material.FISHING_ROD); 
            ItemStack pract = new ItemStack(Material.DIAMOND_SWORD); 
            
            //Edit the items
            ItemMeta kits_meta = kits.getItemMeta();
            kits_meta.setDisplayName(ChatColor.GOLD + "KitMap");
            ArrayList<String> kits_lore = new ArrayList<>();
            kits_lore.add(ChatColor.GRAY + "Left click to connect." + "\n" + ChatColor.GOLD + "*" + ChatColor.GRAY + "Online");
            kits_meta.setLore(kits_lore);
            kits.setItemMeta(kits_meta);
          
      
            ItemMeta hcf_meta = hcf.getItemMeta();
            hcf_meta.setDisplayName(ChatColor.DARK_GREEN + "HCF" + ChatColor.RED + " (Coming Soon)");
            ArrayList<String> hcf_lore = new ArrayList<>();
            hcf_lore.add(ChatColor.GRAY + "Left click to connect." + "\n" + ChatColor.GOLD + "*" + ChatColor.GRAY + "Online");
            hcf_meta.setLore(hcf_lore); 
            hcf.setItemMeta(hcf_meta);
            
            
            ItemMeta pract_meta = pract.getItemMeta();
            pract_meta.setDisplayName(ChatColor.LIGHT_PURPLE + "Practice" + ChatColor.RED + " (Coming Soon)");
            ArrayList<String> pract_lore = new ArrayList<>();
            pract_lore.add(ChatColor.GRAY + "Left click to connect." + "\n" + ChatColor.GOLD + "*" + ChatColor.GRAY + "Online");
            pract_meta.setLore(pract_lore);
            pract.setItemMeta(pract_meta);
 
            //Put the items in the inventory
            ItemStack[] menu_items = {kits, hcf, pract};
            
            gui.setItem(14, pract);
            gui.setItem(12, hcf);
            gui.setItem(22, kits);
            player.openInventory(gui);
 
 
        }
 
        return true;
    }


	
}
