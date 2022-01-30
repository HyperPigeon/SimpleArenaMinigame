package net.hyper_pigeon.simplearenaminigame;

import net.hyper_pigeon.simplearenaminigame.commands.JoinCommand;
import net.hyper_pigeon.simplearenaminigame.commands.LeaveCommand;
import net.hyper_pigeon.simplearenaminigame.commands.StartCommand;
import net.hyper_pigeon.simplearenaminigame.listeners.PlayerDeathListener;
import net.hyper_pigeon.simplearenaminigame.manager.GameManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SimpleArenaMinigame extends JavaPlugin {

    private GameManager gameManager;

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.gameManager = new GameManager(this);
        this.getCommand("start").setExecutor(new StartCommand(gameManager));
        this.getCommand("join").setExecutor(new JoinCommand(gameManager));
        this.getCommand("leave").setExecutor(new LeaveCommand(gameManager));

        this.getServer().getPluginManager().registerEvents(new PlayerDeathListener(gameManager), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
