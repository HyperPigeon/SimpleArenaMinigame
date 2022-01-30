package net.hyper_pigeon.simplearenaminigame.tasks;

import net.hyper_pigeon.simplearenaminigame.manager.GameManager;
import net.hyper_pigeon.simplearenaminigame.manager.GameState;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class ArenaTask extends BukkitRunnable {

    private GameManager gameManager;
    private int timeLeft = 120;

    public ArenaTask(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public void run() {
        timeLeft--;
        if(timeLeft <= 0){
            cancel();
            gameManager.setGameState(GameState.END);
        }
        else if (gameManager.getPlayerManager().getPlayers().size() == 1){
            cancel();
            Bukkit.broadcastMessage(gameManager.getPlayerManager().getPlayers().get(0).getName() + " has won!");
            gameManager.setGameState(GameState.END);
        }
    }
}
