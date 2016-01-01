package adminessentials.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import adminessentials.main.UpdateChecker;
import adminessentials.utils.AdminManager;
import adminessentials.utils.ConfigManager;

public class PlayerJoin implements Listener {

	protected UpdateChecker updateChecker;

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();

		if (p.isOp() || p.hasPermission("adminessentials.update")) {
			this.updateChecker = new UpdateChecker(ConfigManager.getInstance()
					.getPlugin(),
					"http://dev.bukkit.org/bukkit-plugins/adminessentials/files.rss");

			if (this.updateChecker.updateNeeded()) {
				p.sendMessage(ChatColor.AQUA + "[AdminEssentials] "
						+ ChatColor.DARK_AQUA + "Version: "
						+ this.updateChecker.getVersion()
						+ " has been released! Download it here: "
						+ ChatColor.RED + this.updateChecker.getLink());
			}
		}

		if (p.hasPermission("adminessentials.seeadmins")) {
			for (Player admins : AdminManager.getInstance().listInAdmin()) {
				p.showPlayer(admins);
			}
		} else {
			for (Player admins : AdminManager.getInstance().listInAdmin()) {
				p.hidePlayer(admins);
			}
		}
	}
}
