package de.jonahd345.joinleaveedit;

import de.jonahd345.joinleaveedit.listener.ConnectionListener;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinLeaveEdit extends JavaPlugin {
    @Getter
    private boolean isPlaceholderAPIEnabled;

    @Override
    public void onEnable() {
        System.out.println("[JoinLeaveEdit] Plugin loaded!");

        this.isPlaceholderAPIEnabled = getServer().getPluginManager().isPluginEnabled("PlaceholderAPI");

        loadConfig();
        this.init();
    }

    @Override
    public void onDisable() {
        System.out.println("[JoinLeaveEdit] Plugin disabled!");
    }

    private void init() {
        PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new ConnectionListener(), this);
    }

    public static JoinLeaveEdit getInstance() {
        return getPlugin(JoinLeaveEdit.class);
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }
}
