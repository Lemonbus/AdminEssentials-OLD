package adminessentials.listeners;

import java.util.Date;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import adminessentials.utils.AdminManager;
import adminessentials.utils.ConfigManager;
import adminessentials.utils.Manager;

public class PlayerChat implements Listener {

	private HashMap<String, Long> slowTime = new HashMap<String, Long>();

	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e) {

		if (Manager.getInstance().isMuted()) {
			if (!e.getPlayer().hasPermission("adminessentials.mutechat.bypass")) {

				e.setCancelled(true);
				e.getPlayer().sendMessage(
						ChatColor.translateAlternateColorCodes('&',
								ConfigManager.getInstance().getConfig()
										.getString("Settings.chat-is-muted")));
				return;
			}
		}

		if (Manager.getInstance().isSlowed()) {

			if (!e.getPlayer().hasPermission("adminessentials.slowchat.bypass")) {

				if (!slowTime.containsKey(e.getPlayer().getName())) {
					slowTime.put(e.getPlayer().getName(),
							System.currentTimeMillis());
					return;
				}

				long mapTime = slowTime.get(e.getPlayer().getName()), currentTime = new Date().getTime() - mapTime;

				if ((currentTime / 1000) >= Manager.getInstance()
						.getSecondsSlowed()) {
					slowTime.put(e.getPlayer().getName(),
							System.currentTimeMillis());
					return;
				} else {
					e.setCancelled(true);

					e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', Manager.getInstance().getPrefix() + ConfigManager.getInstance().getConfig().getString("Settings.chat-is-slowed").replaceAll("%TIME%", String.valueOf((Manager.getInstance().getSecondsSlowed() - currentTime / 1000)))));

				}

			}
		}

			if (ConfigManager.getInstance().getConfig()
					.getBoolean("Settings.adminOnDutyPrefixEnabled")) {
				if (AdminManager.getInstance().isInAdminMode(e.getPlayer())) {

					e.setFormat(ChatColor.translateAlternateColorCodes(
							'&',
							ConfigManager.getInstance().getConfig()
									.getString("Settings.adminOnDutyPrefix"))
							+ e.getPlayer().getDisplayName()
							+ " "
							+ e.getMessage());

				} else
					return;
			} else
				return;
	}
}
