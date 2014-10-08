package com.GummyPvP.AdminEssentials.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.GummyPvP.AdminEssentials.Commands.Admin;
import com.GummyPvP.AdminEssentials.Commands.AdminEssentials;
import com.GummyPvP.AdminEssentials.Commands.ClearChat;
import com.GummyPvP.AdminEssentials.Commands.Freeze;
import com.GummyPvP.AdminEssentials.Commands.MuteChat;
import com.GummyPvP.AdminEssentials.Commands.UnFreeze;
import com.GummyPvP.AdminEssentials.Listeners.ChatEvent;
import com.GummyPvP.AdminEssentials.Listeners.JoinEvent;
import com.GummyPvP.AdminEssentials.Listeners.MoveEvent;
import com.GummyPvP.AdminEssentials.Listeners.QuitEvent;

public class Main extends JavaPlugin {

	protected UpdateChecker updateChecker;

	public ArrayList<Player> admin = new ArrayList<Player>();
	public boolean Muted;
	public ArrayList<Player> frozen = new ArrayList<Player>();

	public void onEnable() {

		registerCommands();
		registerEvents(this, new JoinEvent(this), new QuitEvent(this),
				new ChatEvent(this), new MoveEvent(this));
		if (!this.getDataFolder().exists()) {
			this.getDataFolder().mkdir();
		}
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();

		if (!this.getConfig().contains("Settings.admin-enable")) {
			this.getConfig().set("Settings.admin-enable",
					"&dYou are now in ADMIN mode");
		}

		if (!this.getConfig().contains("Settings.admin-disable")) {
			this.getConfig().set("Settings.admin-disable",
					"&aYou are now in PLAY mode");
		}

		if (!this.getConfig().contains("Settings.update-notice")) {
			this.getConfig().set("Settings.update-notice", true);
		}

		if (!this.getConfig().contains("Settings.admin-prefix-enabled")) {
			this.getConfig().set("admin-prefix-enabled", false);
		}

		if (!this.getConfig().contains("Settings.admin-prefix")) {
			this.getConfig().set("admin-prefix", "&6[&bAM&6] ");
		}

		this.updateChecker = new UpdateChecker(this,
				"http://dev.bukkit.org/bukkit-plugins/adminessentials/files.rss");
		if (this.updateChecker.updateNeeded()) {
			this.getLogger().warning(
					"[AdminEssentials] Version " + updateChecker.getVersion()
							+ " has been released! Download it here: "
							+ updateChecker.getLink());
		}

	}

	public void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... lis) {
		for (Listener l : lis) {
			Bukkit.getServer().getPluginManager().registerEvents(l, plugin);
		}
	}

	public void registerCommands() {
		getCommand("Admin").setExecutor(new Admin(this));
		getCommand("Admin").setPermissionMessage(
				ChatColor.RED + "You may not use this command.");
		getCommand("AdminEssentials").setExecutor(new AdminEssentials(this));
		getCommand("AdminEssentials").setPermissionMessage(
				ChatColor.RED + "You may not use this command.");
		getCommand("ClearChat").setExecutor(new ClearChat(this));
		getCommand("ClearChat").setPermissionMessage(
				ChatColor.RED + "You may not use this command.");
		getCommand("MuteChat").setExecutor(new MuteChat(this));
		getCommand("MuteChat").setPermissionMessage(
				ChatColor.RED + "You may not use this command.");
		getCommand("Freeze").setExecutor(new Freeze(this));
		getCommand("Freeze").setPermissionMessage(
				ChatColor.RED + "You may not use this command.");
		getCommand("UnFreeze").setExecutor(new UnFreeze(this));
		getCommand("UnFreeze").setPermissionMessage(
				ChatColor.RED + "You may not use this command.");
	}
}
