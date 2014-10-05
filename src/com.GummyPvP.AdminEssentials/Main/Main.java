package com.GummyPvP.AdminEssentials.Main;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.GummyPvP.AdminEssentials.Commands.Admin;
import com.GummyPvP.AdminEssentials.Commands.AdminEssentials;
import com.GummyPvP.AdminEssentials.Commands.ClearChat;
import com.GummyPvP.AdminEssentials.Commands.MuteChat;
import com.GummyPvP.AdminEssentials.Listeners.ChatEvent;
import com.GummyPvP.AdminEssentials.Listeners.JoinEvent;
import com.GummyPvP.AdminEssentials.Listeners.QuitEvent;

public class Main extends JavaPlugin {

	public ArrayList<Player> admin = new ArrayList<Player>();
	public boolean Muted;

	public void onEnable() {
		registerCommands();
		registerEvents(this, new JoinEvent(this), new QuitEvent(this),
				new ChatEvent(this));
		if (!this.getDataFolder().exists()) {
			this.getDataFolder().mkdir();
		}

		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}

	public void registerEvents(org.bukkit.plugin.Plugin plugin, Listener... lis) {
		for (Listener l : lis) {
			Bukkit.getServer().getPluginManager().registerEvents(l, plugin);
		}
	}

	public void registerCommands() {
		getCommand("Admin").setExecutor(new Admin(this));
		getCommand("AdminEssentials").setExecutor(new AdminEssentials(this));
		getCommand("ClearChat").setExecutor(new ClearChat(this));
		getCommand("MuteChat").setExecutor(new MuteChat(this));
	}

}
