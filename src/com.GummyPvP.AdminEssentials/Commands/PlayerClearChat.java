package com.GummyPvP.AdminEssentials.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.GummyPvP.AdminEssentials.Main.Main;

public class PlayerClearChat implements CommandExecutor {

	private Main plugin;

	public PlayerClearChat(Main plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not use this command.");
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("PlayerClearChat")) {

			if (args.length == 0) {
				for (int i = 0; i < 100; i++) {
					p.sendMessage(" ");
				}

				p.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Settings.prefix"))
						+ "Your chat has been cleared!");
				return true;
			}

			if (args.length == 1) {
				@SuppressWarnings("deprecation")
				Player target = Bukkit.getPlayer(args[0]);
				if (target == null) {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&',
							plugin.getConfig().getString("Settings.prefix"))
							+ args[0] + " is offline!");
					return true;
				}

				for (int i = 0; i < 100; i++) {
					target.sendMessage(" ");
				}

				target.sendMessage(ChatColor.translateAlternateColorCodes('&',
						plugin.getConfig().getString("Settings.prefix"))
						+ "Your chat has been cleared!");
			}

			if (args.length > 1)
				return false;
		}
		return true;
	}

}
