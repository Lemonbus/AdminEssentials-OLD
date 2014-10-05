package com.GummyPvP.AdminEssentials.Main;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable() {
		//registerCommands();
		//registerEvents();
		if(!this.getDataFolder().exists()) {
			this.getDataFolder().mkdir();
		}
		
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
	}

}
