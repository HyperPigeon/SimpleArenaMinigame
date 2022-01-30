package net.hyper_pigeon.simplearenaminigame.tasks;

import net.hyper_pigeon.simplearenaminigame.manager.GameManager;
import net.hyper_pigeon.simplearenaminigame.manager.GameState;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown extends BukkitRunnable {

    private GameManager gameManager;

    private int timeLeft = 30;

    public Countdown(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public void run() {
        timeLeft--;
        if(timeLeft <= 0){
            cancel();
            gameManager.setGameState(GameState.ACTIVE);
        }

        Bukkit.broadcastMessage(timeLeft + " until game starts");
    }
}
