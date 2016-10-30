package net.l_bulb.plugins.auth;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Auth implements CommandExecutor {
 
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if (cmd.getName().equalsIgnoreCase("auth")) {
				if (!(sender instanceof Player)) {
					sender.sendMessage("このコマンドはゲーム内から実行してください。");
				} else {
					Player player = (Player) sender;
					sender.sendMessage( "mcid=" + player.getPlayer().getName() + "&key=" + args[0]);
					String post = WebRequest.post("https://www.l-bulb.net/system/auth.php", "mcid=" + player.getPlayer().getName() + "&key=" + args[0]);
					String get = WebRequest.get("https://www.l-bulb.net/system/auth.php?mcid=" + player.getPlayer().getName() + "&key=" + args[0]);
					sender.sendMessage(post);
					sender.sendMessage(get);
				}
			return true;
		}
			return false;
	}

}