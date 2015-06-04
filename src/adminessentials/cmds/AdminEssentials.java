package adminessentials.cmds;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import adminessentials.utils.ConfigManager;

public class AdminEssentials implements CommandExecutor {

	private String[] MESSAGE = new String[] {
			ChatColor.BLUE + "/admin - Goes into admin mode.",
			ChatColor.BLUE + "/clearchat - Clears the text in the chat box.",
			ChatColor.BLUE
					+ "/mutechat - Mutes the entire server, excluding players with a bypass permission.",
			ChatColor.BLUE + "/adminessentials - Shows this help menu.",
			ChatColor.BLUE
					+ "/adminessentials reload - Reloads the configuration file.",
			ChatColor.BLUE
					+ "/pcc - Clears your chat, or a specified player's chat." };

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2,
			String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("You may not use this command.");
			return true;
		}

		Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("AdminEssentials")) {
			if (p.hasPermission("adminessentials.help")) {
				if (args.length == 0) {

					p.sendMessage(ChatColor.BLUE + "" + ChatColor.STRIKETHROUGH
							+ "--- " + ChatColor.GOLD + " AdminEssentials "
							+ ChatColor.BLUE + "" + ChatColor.STRIKETHROUGH
							+ " ---");

					p.sendMessage(MESSAGE);

					return true;
				} else if (args.length == 1) {
					if (args[0].equalsIgnoreCase("reload")) {
						if (p.hasPermission("adminessentials.reload")) {

							ConfigManager.getInstance().reloadConfig();

							p.sendMessage(ChatColor
									.translateAlternateColorCodes('&',
											"&6[&bAdminEssentials&6]&a Config Reloaded!"));

							return true;
						}

					} else {
						p.sendMessage(ChatColor.RED + "Incorrect usage!");
						return true;
					}

				} else if (args.length > 1) {
					p.sendMessage(ChatColor.RED + "Incorrect usage!");
					return true;
				}
			}
		}
		return true;
	}

}