package net.l_bulb.plugins.auth;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class LBNAuth extends JavaPlugin {
	
	private static LBNAuth plugin;
	public static String prefix = "";
	public static String suffix = "";
	
	@Override
    public void onEnable() {
		plugin = this;
		
		getCommand("auth").setExecutor(new Auth());
		
		Bukkit.broadcast(LBNAuth.prefix
				+ "LBN-Authが有効になりました。"
				+ LBNAuth.suffix, "lbn.auth.admin");
	}

	@Override
    public void onDisable() {
		Bukkit.broadcast(LBNAuth.prefix
				+ "LBN-Authが無効になりました。"
				+ LBNAuth.suffix, "lbn.auth.admin");
	}

	public static LBNAuth getPlugin() {
		return plugin;
	}
}
