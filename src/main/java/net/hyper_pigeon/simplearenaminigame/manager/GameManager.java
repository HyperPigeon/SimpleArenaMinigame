package net.hyper_pigeon.simplearenaminigame.manager;

import net.hyper_pigeon.simplearenaminigame.tasks.ArenaTask;
import net.hyper_pigeon.simplearenaminigame.tasks.Countdown;
import net.hyper_pigeon.simplearenaminigame.SimpleArenaMinigame;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;


public class GameManager {
    private final SimpleArenaMinigame simpleArenaMinigame;
    public GameState gameState = GameState.LOBBY;
    private PlayerManager playerManager;
    private Countdown countdown;
    private ArenaTask arenaTask;

    public GameManager(SimpleArenaMinigame plugin){
        simpleArenaMinigame = plugin;
        playerManager = new PlayerManager(this);
    }

    public void setGameState(GameState state){
        if(this.gameState == state){
            return;
        }

        this.gameState = state;
        switch(state){
            case STARTING:
                Bukkit.broadcastMessage("STARTING ARENA.");
                getPlayerManager().setGamemodes();
                getPlayerManager().giveKits();
                this.countdown = new Countdown(this);
                this.countdown.runTaskTimer(simpleArenaMinigame,0,20);
                break;

            case ACTIVE:
                Bukkit.broadcastMessage("ARENA IS NOW ACTIVE.");
                this.arenaTask = new ArenaTask(this);
                this.arenaTask.runTaskTimer(simpleArenaMinigame,0,20);
                break;

            case END:
                getPlayerManager().setGamemodes();
                getPlayerManager().removeAllPlayers();
                Bukkit.broadcastMessage("ARENA HAS ENDED. HOPE YOU ENJOYED.");
                break;
        }
    }

    public PlayerManager getPlayerManager(){
        return playerManager;
    }


    public void addPlayer(Player player){
        getPlayerManager().addPlayer(player);
    }

    public void removePlayer(Player player){
        getPlayerManager().removePlayer(player);
    }

}
