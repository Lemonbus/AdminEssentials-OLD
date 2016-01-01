package adminessentials.utils;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;

public class ChatManager {

	private ChatManager() {

	}

	static ChatManager instance = new ChatManager();

	public static ChatManager getInstance() {
		return instance;
	}

	public void messageSenderOnly(CommandSender sender) {
		sender.sendMessage("Sorry, only players may use this command.");
	}

	public void messageNoPermission(CommandSender sender) {
		sender.sendMessage(ChatColor.translateAlternateColorCodes(
				'&',
				ConfigManager.getInstance().getConfig()
						.getString("no-permission-message")
						.replaceAll("%PLAYER%", sender.getName())));
	}
}
