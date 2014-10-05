package com.GummyPvP.AdminEssentials.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.GummyPvP.AdminEssentials.Main.Main;

public class MuteChat implements CommandExecutor {
	
	private Main plugin;
	
	public MuteChat(Main plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(cmd.getName().equalsIgnoreCase("MuteChat")) {
			if(args.length != 0) {
				sender.sendMessage(ChatColor.RED + "/Mutechat");
				return true;
			}
			if(plugin.Muted) {
				plugin.Muted = false;
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes(
						'&',
						plugin.getConfig().getString("Settings.prefix")
								+ plugin.getConfig()
										.getString("Settings.unmutechat-message")
										.replaceAll("{PLAYER}", sender.getName())));
			} else {
				plugin.Muted = true;
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes(
						'&',
						plugin.getConfig().getString("Settings.prefix")
								+ plugin.getConfig()
										.getString("Settings.clearchat-message")
										.replaceAll("{PLAYER}", sender.getName())));
			}
		}
		return true;
	}

}
