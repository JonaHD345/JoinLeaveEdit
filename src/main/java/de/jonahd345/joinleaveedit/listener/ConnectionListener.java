package de.jonahd345.joinleaveedit.listener;

import de.jonahd345.joinleaveedit.JoinLeaveEdit;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ConnectionListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        String message = JoinLeaveEdit.getInstance().getConfig().getString("Config.Join");
        message = PlaceholderAPI.setPlaceholders(player, message);
        e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', message));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player player = e.getPlayer();
        String message = JoinLeaveEdit.getInstance().getConfig().getString("Config.Leave");
        message = PlaceholderAPI.setPlaceholders(e.getPlayer(), message);
        e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
