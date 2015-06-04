package adminessentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import adminessentials.utils.ChatManager;
import adminessentials.utils.ConfigManager;

public class PlayerClearChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,
			String commandLabel, String[] args) {
		if (!(sender instanceof Player)) {
			ChatManager.getInstance().messageSenderOnly(sender);
			return true;
		}

		Player p = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("PlayerClearChat")) {
			if (p.hasPermission("adminessentials.playerclearchat")) {
				if (args.length == 0) {
					for (int i = 0; i < 100; i++) {
						p.sendMessage(" ");
					}

					p.sendMessage(ChatColor.translateAlternateColorCodes(
							'&',
							ConfigManager.getInstance().getConfig()
									.getString("Settings.prefix"))
							+ ConfigManager
									.getInstance()
									.getConfig()
									.getString(
											"Settings.your-chat-has-been-cleared"));
					return true;
				}

				if (args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);
					if (target == null) {
						p.sendMessage(ChatColor.translateAlternateColorCodes(
								'&', ConfigManager.getInstance().getConfig()
										.getString("Settings.prefix"))
								+ args[0] + " is offline!");
						return true;
					}

					for (int i = 0; i < 100; i++) {
						target.sendMessage(" ");
					}

					target.sendMessage(ChatColor.translateAlternateColorCodes(
							'&', ConfigManager.getInstance().getConfig()
									.getString("Settings.prefix"))
							+ ConfigManager
									.getInstance()
									.getConfig()
									.getString(
											"Settings.your-chat-has-been-cleared"));
				}

				if (args.length > 1) {
					p.sendMessage(ChatColor.RED
							+ "Incorrect usage! Please use /" + commandLabel
							+ " <player>");
					return true;
				}
			} else
				ChatManager.getInstance().messageNoPermission(p);
		}
		return true;
	}

}
