package adminessentials.listeners;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import adminessentials.utils.AdminManager;
import adminessentials.utils.ConfigManager;
import adminessentials.utils.Manager;

public class PlayerChat implements Listener {

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {

		if (Manager.getInstance().isMuted()) {
			if (e.getPlayer().hasPermission("adminessentials.mutechat.bypass"))
				return;
			e.setCancelled(true);
			e.getPlayer().sendMessage(
					ChatColor.translateAlternateColorCodes(
							'&',
							ConfigManager.getInstance().getConfig()
									.getString("Settings.chat-is-muted")));
		}

		if (ConfigManager.getInstance().getConfig()
				.getBoolean("Settings.adminOnDutyPrefixEnabled")) {
			if (AdminManager.getInstance().isInAdminMode(e.getPlayer())) {

				e.setFormat(ChatColor.translateAlternateColorCodes(
						'&',
						ConfigManager.getInstance().getConfig()
								.getString("Settings.adminOnDutyPrefix"))
						+ e.getPlayer().getDisplayName() + " " + e.getMessage());

			} else
				return;
		} else
			return;
	}
}
