package com.GummyPvP.AdminEssentials.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.GummyPvP.AdminEssentials.Main.Main;

public class ClearChat implements CommandExecutor {

	private Main plugin;

	public ClearChat(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("ClearChat")) {
			if (args.length != 0) {
				sender.sendMessage(ChatColor.RED + "/Clearchat");
				return true;
			}

			for (int i = 0; i < 100; i++) {
				Bukkit.broadcastMessage(" ");
			}
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes(
					'&',
					plugin.getConfig().getString("Settings.prefix")
							+ plugin.getConfig()
									.getString("Settings.clearchat-message")
									.replaceAll("{PLAYER}", sender.getName())));
			return true;
		}
		return true;
	}

}
