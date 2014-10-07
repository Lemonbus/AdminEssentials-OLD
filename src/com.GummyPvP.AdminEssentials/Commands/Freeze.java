package com.GummyPvP.AdminEssentials.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.GummyPvP.AdminEssentials.Main.Main;

public class Freeze implements CommandExecutor {

	private Main plugin;

	public Freeze(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("freeze")) {
			if (args.length != 1) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Settings.prefix"))
						+ "/freeze <player>");
				return true;
			}

			Player p = Bukkit.getPlayer(args[0]);

			if (p == null || (!p.isOnline())) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Settings.prefix"))
						+ ChatColor.RED
						+ "Player "
						+ p.getName()
						+ " is not online!");
				return true;
			}
			if (plugin.frozen.contains(p)) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Settings.prefix"))
						+ ChatColor.RED
						+ "Player "
						+ p.getName()
						+ " is already frozen! Try /unfreeze.");
				return true;
			}
			plugin.frozen.add(p);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin
					.getConfig().getString("Settings.prefix"))
					+ ChatColor.RED
					+ "You have been frozen by "
					+ sender.getName());
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					plugin.getConfig().getString("Settings.prefix"))
					+ ChatColor.GREEN + "Successfully froze " + p.getName() + "!");
			return true;

		}

		return true;
	}

}
