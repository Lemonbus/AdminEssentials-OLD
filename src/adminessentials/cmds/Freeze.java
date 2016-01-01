package adminessentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import adminessentials.utils.ChatManager;
import adminessentials.utils.ConfigManager;
import adminessentials.utils.FreezeManager;

public class Freeze implements CommandExecutor {
	
	/**
	 * 
	 * Add permission message
	 * 
	 */

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("Freeze")) {
			
			if (sender.hasPermission("adminessentials.freeze")) {
				
				if (args.length == 0) {
					
					if (sender instanceof Player) {

						Player p = (Player) sender;
						
						if (FreezeManager.getInstance().isFrozen(p)) {
							
							p.sendMessage(ChatColor.translateAlternateColorCodes(
									'&', ConfigManager.getInstance().getConfig()
											.getString("Settings.prefix")
											+ "&cYou are already frozen!"));
							return true;
							
						}

						FreezeManager.getInstance().setFrozen(p, true);

						p.sendMessage(ChatColor.translateAlternateColorCodes(
								'&', ConfigManager.getInstance().getConfig()
										.getString("Settings.prefix")
										+ "&cYou have been frozen!"));
						return true;

					} else
						return true;
				}
				
				if (args.length >= 2) {
					
					sender.sendMessage(ChatColor.translateAlternateColorCodes(
							'&', ConfigManager.getInstance().getConfig()
									.getString("Settings.prefix")
									+ "&cPlease use the proper usage!"));
					return true;
					
				}
				
				// Arguments have to be 1
				
				Player target = Bukkit.getPlayer(args[0]);
				
				if (target == null) {
					
					sender.sendMessage(ChatColor.translateAlternateColorCodes(
							'&', ConfigManager.getInstance().getConfig()
									.getString("Settings.prefix")
									+ "&cPlayer is not online!"));
					return true;
					
				} else {
					
					if (FreezeManager.getInstance().isFrozen(target)) {
						
						sender.sendMessage(ChatColor.translateAlternateColorCodes(
								'&', ConfigManager.getInstance().getConfig()
										.getString("Settings.prefix")
										+ "&cPlayer is already frozen!"));
						return true;
					}
					
					sender.sendMessage(ChatColor.translateAlternateColorCodes(
							'&', ConfigManager.getInstance().getConfig()
									.getString("Settings.prefix")
									+ "&2Player &b" + target.getName() + " &2has been frozen!"));
					
					target.sendMessage(ChatColor.translateAlternateColorCodes(
							'&', "&cYou have been frozen!"));
					
					FreezeManager.getInstance().setFrozen(target, true);
					
					
				}
				
			} else
				ChatManager.getInstance().messageNoPermission(sender);
		}
		return true;
	}

}
