package adminessentials.main;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import adminessentials.cmds.Admin;
import adminessentials.cmds.AdminEssentials;
import adminessentials.cmds.ClearChat;
import adminessentials.cmds.FakeJoin;
import adminessentials.cmds.FakeLeave;
import adminessentials.cmds.Freeze;
import adminessentials.cmds.MuteChat;
import adminessentials.cmds.PlayerClearChat;
import adminessentials.cmds.SlowChat;
import adminessentials.cmds.UnFreeze;
import adminessentials.listeners.PlayerChat;
import adminessentials.listeners.PlayerJoin;
import adminessentials.listeners.PlayerMove;
import adminessentials.listeners.PlayerQuit;
import adminessentials.utils.ConfigManager;

public class Main extends JavaPlugin {

	protected UpdateChecker updateChecker;

	public void onEnable() {

		loadListeners(this, new PlayerChat(), new PlayerQuit(), new PlayerJoin(), new PlayerMove());

		registerCommands();

		ConfigManager.getInstance().setup(this);

		this.updateChecker = new UpdateChecker(this,
				"http://dev.bukkit.org/bukkit-plugins/adminessentials/files.rss");

		if (updateChecker.updateNeeded()) {
			this.getLogger().warning(
					"[AdminEssentials] Version " + updateChecker.getVersion()
							+ " has been released! Download it here: "
							+ updateChecker.getLink());
		}
	}

	private void loadListeners(Plugin plugin, Listener... listeners) {

		for (Listener lis : listeners) {
			Bukkit.getServer().getPluginManager().registerEvents(lis, plugin);
		}

	}

	private void registerCommands() {

		getCommand("Admin").setExecutor(new Admin());
		getCommand("ClearChat").setExecutor(new ClearChat());
		getCommand("MuteChat").setExecutor(new MuteChat());
		getCommand("PlayerClearChat").setExecutor(new PlayerClearChat());
		getCommand("AdminEssentials").setExecutor(new AdminEssentials());
		getCommand("Freeze").setExecutor(new Freeze());
		getCommand("UnFreeze").setExecutor(new UnFreeze());
		getCommand("FakeJoin").setExecutor(new FakeJoin());
		getCommand("FakeLeave").setExecutor(new FakeLeave());
		getCommand("SlowChat").setExecutor(new SlowChat());

	}

}
