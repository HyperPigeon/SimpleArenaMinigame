package net.hyper_pigeon.simplearenaminigame.listeners;

import net.hyper_pigeon.simplearenaminigame.manager.GameManager;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {

    private GameManager gameManager;

    public PlayerDeathListener(GameManager gameManager){
        this.gameManager = gameManager;
    }


    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent playerDeathEvent){
        playerDeathEvent.getPlayer().setGameMode(GameMode.SPECTATOR);
        gameManager.removePlayer(playerDeathEvent.getPlayer());
    }
}
