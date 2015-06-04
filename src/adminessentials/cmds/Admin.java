package adminessentials.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import adminessentials.events.PlayerJoinAdminEvent;
import adminessentials.events.PlayerLeaveAdminEvent;
import adminessentials.utils.AdminManager;
import adminessentials.utils.ChatManager;
import adminessentials.utils.ConfigManager;

public class Admin implements CommandExecutor {

	@SuppressWarnings("deprecation")
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			ChatManager.getInstance().messageSenderOnly(sender);
			return true;
		}

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("admin")) {
			if (p.hasPermission("adminessentials.admin")) {
				if (AdminManager.getInstance().isInAdminMode(p)) {
					// Take them out
					AdminManager.getInstance().setAdminMode(p, false);

					for (Player online : Bukkit.getOnlinePlayers()) {
						online.showPlayer(p);
					}

					p.sendMessage(ChatColor.translateAlternateColorCodes(
							'&',
							ConfigManager.getInstance().getConfig()
									.getString("Settings.adminRemoveMessage")));
					Bukkit.getPluginManager().callEvent(
							new PlayerLeaveAdminEvent(p));
				} else {
					// Put them in
					AdminManager.getInstance().setAdminMode(p, true);

					for (Player online : Bukkit.getOnlinePlayers()) {
						if (online.hasPermission("adminessentials.seeadmins")) {
							online.showPlayer(p);
						} else
							online.hidePlayer(p);
					}

					p.sendMessage(ChatColor.translateAlternateColorCodes(
							'&',
							ConfigManager.getInstance().getConfig()
									.getString("Settings.adminAddMessage")));
					Bukkit.getPluginManager().callEvent(
							new PlayerJoinAdminEvent(p));

				}
			} else
				ChatManager.getInstance().messageNoPermission(p);
		}
		return true;
	}
}
