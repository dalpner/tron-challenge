package tronchallenge;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMovementListener implements Listener {


    //TODO Was passiert wenn Spieler keine Leben mehr?

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        if (Colornames.standOnColor(player, block)) {
            if (block.getType() != TronChallenge.tronChallenge.getPlayerColorHashMap().get(player.getUniqueId())) {
                player.setHealth(0);
                TronChallenge.tronChallenge.addPlayerLifeHashMap(player.getUniqueId(), TronChallenge.tronChallenge.getPlayerLifeHashMap().get(player.getUniqueId())-1);
                if (TronChallenge.tronChallenge.getPlayerLifeHashMap().get(player.getUniqueId()) <=0){
                    player.setGameMode(GameMode.SPECTATOR);
                    event.getPlayer().sendMessage("Du hast leider keine Leben mehr. Ab jetzt heißt es zuschauen!");
                }
                event.getPlayer().sendMessage("Current lifes: " + TronChallenge.tronChallenge.getPlayerLifeHashMap().get(player.getUniqueId()));
            }
        }

        if (block.getType() != Material.OBSIDIAN && block.getType() != Material.AIR && block.getType() != Material.WATER) {
            World w = player.getWorld();
            w.getBlockAt(block.getLocation()).setType(TronChallenge.tronChallenge.getSpezColorNum(player.getUniqueId()));
        }
    }
}
