package net.hyper_pigeon.simplearenaminigame.manager;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class PlayerManager {

    private GameManager gameManager;
    private ArrayList<Player> players;
    public PlayerManager(GameManager gameManager){
        this.gameManager = gameManager;
        players = new ArrayList<>();
    }

    public void setGamemodes(){
        if(gameManager.gameState == GameState.STARTING){
            players.stream().forEach(player -> player.setGameMode(GameMode.ADVENTURE));
        }
        else if(gameManager.gameState == GameState.END){
            players.stream().forEach(player -> player.setGameMode(GameMode.SURVIVAL));
        }

    }


    public void giveKits(){
        players.stream().filter(player -> player.getGameMode() == GameMode.ADVENTURE).forEach(this::giveKit);
    }

    public void giveKit(Player player) {
        player.getInventory().addItem(new ItemStack(Material.STONE_SWORD));
    }

    public void addPlayer(Player player){
        players.add(player);
        player.setGameMode(GameMode.ADVENTURE);
    }

    public void removePlayer(Player player){
        players.remove(player);
        if(player.isOnline())
            player.setGameMode(GameMode.SURVIVAL);
    }

    public void removeAllPlayers(){
        players.removeAll(players);
    }

    public ArrayList<Player> getPlayers(){
        return players;
    }

}
