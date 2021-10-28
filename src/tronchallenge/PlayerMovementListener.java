package tronchallenge;

import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMovementListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
// 192.168.178.35
        Player player = event.getPlayer();
        Block block = player.getLocation().getBlock().getRelative(BlockFace.DOWN);
        if (block.getType() == Material.RED_WOOL
                || block.getType() == Material.ORANGE_WOOL
                || block.getType() == Material.YELLOW_WOOL
                || block.getType() == Material.GREEN_WOOL
                || block.getType() == Material.CYAN_WOOL
                || block.getType() == Material.BLUE_WOOL
                || block.getType() == Material.PURPLE_WOOL
                || block.getType() == Material.PINK_WOOL
                || block.getType() == Material.BROWN_WOOL
                || block.getType() == Material.BLACK_WOOL) {
            if (block.getType() != TronChallenge.tronChallenge.getPlayerColorHashMap().get(player.getUniqueId())) {
                player.setHealth(0);
                TronChallenge.tronChallenge.addPlayerLifeHashMap(player.getUniqueId(), TronChallenge.tronChallenge.getPlayerLifeHashMap().get(player.getUniqueId())-1);
                if (TronChallenge.tronChallenge.getPlayerLifeHashMap().get(player.getUniqueId()) <=0){
                    player.kickPlayer("Du hast kein Leben mehr. Geh mal raus!");
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
