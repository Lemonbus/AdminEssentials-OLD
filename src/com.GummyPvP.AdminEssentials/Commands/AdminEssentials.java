package com.GummyPvP.AdminEssentials.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.GummyPvP.AdminEssentials.Main.Main;

public class AdminEssentials implements CommandExecutor {

	private Main plugin;

	public AdminEssentials(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not use this command.");
			return true;
		}

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("AdminEssentials")) {
			if (args.length == 0) {
				p.sendMessage(ChatColor.BLUE + "---" + ChatColor.GOLD
						+ "AdminEssentials" + ChatColor.BLUE + "---");
				p.sendMessage(ChatColor.BLUE + "/admin - Goes into admin mode.");
				p.sendMessage(ChatColor.BLUE
						+ "/clearchat - Clears the text in the chat box.");
				p.sendMessage(ChatColor.BLUE
						+ "/mutechat - Mutes the entire server, excluding players with a bypass permission.");
				p.sendMessage(ChatColor.BLUE
						+ "/adminessentials - Shows this help menu.");
				p.sendMessage(ChatColor.BLUE
						+ "/adminessentials reload - Reloads the configuration file.");
				return true;
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("reload")) {
					plugin.reloadConfig();
					p.sendMessage(ChatColor.GREEN
							+ "Configuration file reloaded!");
					return true;
				} else {
					p.sendMessage(ChatColor.RED + "/AdminEssentials [reload]");
					return true;
				}
			} else if (args.length > 1) {
				p.sendMessage(ChatColor.RED + "/AdminEssentials [reload]");
				return true;
			}
		}
		return true;
	}

}
