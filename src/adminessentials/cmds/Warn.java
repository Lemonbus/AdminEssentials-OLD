package adminessentials.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Warn implements CommandExecutor {

	@Override
	  public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args)
	  {
	     Player p = (Player) sender;
		 if (cmd.getName().equalsIgnoreCase("broadcast"))
		      if (!sender.hasPermission("adminessentials.warn")) {
 sender.sendMessage((ChatColor.translateAlternateColorCodes('&',"&cYou Do Not Have Permission To This Command")));
		    	  return true;
		      }
		        if (args.length == 0) {
		          sender.sendMessage(ChatColor.translateAlternateColorCodes(
		            '&', 
		        		  "&8> &cPlease Use /warn <Player> <Reason>"));
		          return true;
		        }
		        if (args.length == 1) {
			          if ((sender instanceof Player)) {
		        
		      }
		return false;
	  }
		        Player target = Bukkit.getPlayer(args[0]);
		        if (target == null) {
		          p.sendMessage(ChatColor.RED + "Player " + args[0] + " is offline!");
		          return true;
		        }

		        String message = null;
		        message = args[1].trim();
		        for (int ii = 2; ii != args.length; ii++) {
		          message = message + " " + args[ii];
			            
			          }
			          target.sendMessage(ChatColor.RED + "Warned By " + p.getName() + " For Reason " + message);
		        	sender.sendMessage(ChatColor.GREEN + args[0] + " Has Been Warned!");

		return false;
	  }
}

