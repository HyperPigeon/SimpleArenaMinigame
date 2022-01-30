package net.hyper_pigeon.simplearenaminigame.commands;

import net.hyper_pigeon.simplearenaminigame.manager.GameManager;
import net.hyper_pigeon.simplearenaminigame.manager.GameState;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class JoinCommand implements CommandExecutor {

    private GameManager gameManager;

    public JoinCommand(GameManager gameManager){
        this.gameManager = gameManager;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(sender instanceof Player) {
            if(gameManager.gameState == GameState.STARTING){
                gameManager.addPlayer((Player) sender);
                return true;
            }
            return false;
        }

        return false;
    }
}
