package com.GummyPvP.AdminEssentials.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.GummyPvP.AdminEssentials.Main.Main;

public class Admin implements CommandExecutor { 

	private Main plugin;

	public Admin(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You're not allowed to use this command!");
			return true;
		}
		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("Admin")) {
			if (args.length != 0) {
				return false;
			}
			if (!plugin.admin.contains(p)) {
				plugin.admin.add(p);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Settings.admin-enable")));
				p.setGameMode(GameMode.CREATIVE);
				for (Player online : Bukkit.getOnlinePlayers()) {
					if (online.hasPermission("adminessentials.seeadmins")) {
						online.showPlayer(p);
					} else
						online.hidePlayer(p);
				}
			} else {
				plugin.admin.remove(p);
				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Settings.admin-disable")));
				p.setGameMode(GameMode.SURVIVAL);
				for (Player online : Bukkit.getOnlinePlayers()) {
					online.showPlayer(p);
				}
			}
		}
		return true;
	}
}
