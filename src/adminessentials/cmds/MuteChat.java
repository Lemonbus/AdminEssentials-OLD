package adminessentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import adminessentials.events.MuteChatEvent;
import adminessentials.utils.ChatManager;
import adminessentials.utils.ConfigManager;
import adminessentials.utils.Manager;

public class MuteChat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String s,
			String[] args) {
		if (cmd.getName().equalsIgnoreCase("MuteChat")) {
			if (sender.hasPermission("adminessentials.mutechat")) {
				if (Manager.getInstance().isMuted()) {
					Manager.getInstance().setMuted(false);

					Bukkit.broadcastMessage(ChatColor
							.translateAlternateColorCodes(
									'&',
									ConfigManager
											.getInstance()
											.getConfig()
											.getString(
													"Settings.unMutechat-message"))
							.replaceAll("%PLAYER%", sender.getName()));
				} else {
					Manager.getInstance().setMuted(true);

					Bukkit.broadcastMessage(ChatColor
							.translateAlternateColorCodes(
									'&',
									ConfigManager
											.getInstance()
											.getConfig()
											.getString(
													"Settings.mutechat-message"))
							.replaceAll("%PLAYER%", sender.getName()));
					Bukkit.getPluginManager().callEvent(
							new MuteChatEvent(sender));
				}
			} else
				ChatManager.getInstance().messageNoPermission(sender);
		}
		return true;
	}
}
