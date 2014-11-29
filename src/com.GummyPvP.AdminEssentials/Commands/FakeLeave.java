package com.GummyPvP.AdminEssentials.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.GummyPvP.AdminEssentials.Main.Main;

public class FakeLeave implements CommandExecutor {

	private Main plugin;

	public FakeLeave(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (cmd.getName().equalsIgnoreCase("FakeLeave")) {
			if (args.length == 0) {
				if (!(sender instanceof Player)) {
					sender.sendMessage("To use this command from console, please use /fakeleave (username)");
					return true;
				}

				Player p = (Player) sender;

				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes(
						'&',
						plugin.getConfig().getString("Settings.fakeleave-msg")
								.replaceAll("%PLAYER%", p.getName())));
				for (Player online : Bukkit.getOnlinePlayers()) {
					online.hidePlayer(p);
				}
				return true;
			}

			if (args.length == 1) {
				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes(
						'&',
						plugin.getConfig().getString("Settings.fakeleave-msg")
								.replaceAll("%PLAYER%", args[0])));
				return true;
			}

			if (args.length > 1)
				return false;
		}
		return true;
	}

}
