package adminessentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import adminessentials.events.ClearChatEvent;
import adminessentials.utils.ChatManager;
import adminessentials.utils.ConfigManager;

public class ClearChat implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("ClearChat")) {
			if (sender.hasPermission("adminessentials.clearchat")) {
				for (Player online : Bukkit.getOnlinePlayers()) {
					for (int i = 0; i < 120; i++) {
						online.sendMessage(" ");
					}
				}

				Bukkit.broadcastMessage(ChatColor
						.translateAlternateColorCodes(
								'&',
								ConfigManager.getInstance().getConfig()
										.getString("Settings.prefix")
										+ ConfigManager
												.getInstance()
												.getConfig()
												.getString(
														"Settings.clearchat-message")
												.replaceAll("%PLAYER%",
														sender.getName())));
				Bukkit.getPluginManager().callEvent(new ClearChatEvent(sender));

			} else
				ChatManager.getInstance().messageNoPermission(sender);
		}
		return true;
	}
}
