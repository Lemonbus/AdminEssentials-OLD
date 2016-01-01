package adminessentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import adminessentials.utils.ChatManager;
import adminessentials.utils.ConfigManager;

public class FakeLeave implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("FakeLeave")) {

			if (!sender.hasPermission("adminessentials.fakeleave")) {

				ChatManager.getInstance().messageNoPermission(sender);

				return true;
			}

			if (args.length <= 0) {

				if (sender instanceof Player) {

					Bukkit.broadcastMessage(ChatColor
							.translateAlternateColorCodes(
									'&',
									ConfigManager
											.getInstance()
											.getConfig()
											.getString(
													"Settings.fake-leave-message")
											.replaceAll("%PLAYER%",
													sender.getName())));

				} else
					ChatManager.getInstance().messageSenderOnly(sender);
			}

			if (args.length >= 1) {

				Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes(
						'&',
						ConfigManager.getInstance().getConfig()
								.getString("Settings.fake-leave-message")
								.replaceAll("%PLAYER%", args[0])));
			}
		}
		return true;
	}

}
