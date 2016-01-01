package adminessentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import adminessentials.utils.ChatManager;
import adminessentials.utils.ConfigManager;
import adminessentials.utils.Manager;

public class SlowChat implements CommandExecutor {
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if (cmd.getName().equalsIgnoreCase("SlowChat")) {
			
			if (sender.hasPermission("adminessentials.slowchat")) {
				
				if (args.length == 0) {
					
					if (Manager.getInstance().isSlowed()) {
						
						Manager.getInstance().setSlowed(false, 0);
						
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Manager.getInstance().getPrefix() + ConfigManager.getInstance().getConfig().getString("Settings.unSlowchat-message").replaceAll("%PLAYER%", sender.getName())));
						
						return true;
					}
					
					Manager.getInstance().setSlowed(true, 4);
					
					Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Manager.getInstance().getPrefix() + ConfigManager.getInstance().getConfig().getString("Settings.slowchat-message").replaceAll("%PLAYER%", sender.getName()).replaceAll("%TIME%", String.valueOf(Manager.getInstance().getSecondsSlowed()))));
					
					return true;
				}
				
				if (args.length == 1) {
					
					if (Manager.getInstance().isInteger(args[0])) {
						
						Manager.getInstance().setSlowed(true, Integer.parseInt(args[0]));
						
						Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', Manager.getInstance().getPrefix() + ConfigManager.getInstance().getConfig().getString("Settings.slowchat-message").replaceAll("%PLAYER%", sender.getName()).replaceAll("%TIME%", String.valueOf(Manager.getInstance().getSecondsSlowed()))));
						
					} else sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Manager.getInstance().getPrefix() + "&cPlease provide a valid number!"));
					
					
					return true;
				}
				
				if (args.length > 1) {
					
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', Manager.getInstance().getPrefix() + "&cPlease provide a valid number of arguments!"));
					
					return true;
				}
				
			} else ChatManager.getInstance().messageNoPermission(sender);
			
		}
		
		return true;
		
	}
 
}
