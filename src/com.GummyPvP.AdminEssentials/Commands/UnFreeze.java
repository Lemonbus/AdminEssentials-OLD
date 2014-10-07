package com.GummyPvP.AdminEssentials.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.GummyPvP.AdminEssentials.Main.Main;

public class UnFreeze implements CommandExecutor {

	private Main plugin;

	public UnFreeze(Main plugin) {
		this.plugin = plugin;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("unfreeze")) {
			if (args.length != 1) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Settings.prefix"))
						+ "/unfreeze <player>");
				return true;
			}

			Player p = Bukkit.getPlayer(args[0]);

			if (p == null || (!p.isOnline())) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Settings.prefix"))
						+ ChatColor.RED
						+ "Player "
						+ args[0]
						+ " is not online!");
				return true;
			}
			if (!plugin.frozen.contains(p)) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Settings.prefix"))
						+ ChatColor.RED
						+ "Player "
						+ p.getName()
						+ " is not frozen! Try /freeze.");
				return true;
			}
			plugin.frozen.remove(p);
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin
					.getConfig().getString("Settings.prefix"))
					+ ChatColor.GREEN
					+ "You have been unfrozen by "
					+ sender.getName());
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
					plugin.getConfig().getString("Settings.prefix"))
					+ ChatColor.GREEN + "Successfully unfroze " + p.getName() + "!");
			return true;

		}
		return true;
	}

}
