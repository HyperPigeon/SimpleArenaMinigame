package net.hyper_pigeon.simplearenaminigame.commands;

import net.hyper_pigeon.simplearenaminigame.manager.GameManager;
import net.hyper_pigeon.simplearenaminigame.manager.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class StartCommand implements CommandExecutor {

    private GameManager gameManager;

    public StartCommand(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        gameManager.setGameState(GameState.STARTING);
        return true;
    }
}
