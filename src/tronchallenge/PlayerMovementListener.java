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

        Player p = event.getPlayer();
        Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);

        if (b.getType() != Material.OBSIDIAN && b.getType() != Material.AIR && b.getType() != Material.WATER) {
            World w = p.getWorld();
            Colornames cNames = new Colornames();

            w.getBlockAt(b.getLocation()).setType(cNames.getColor(TronChallenge.tronChallenge.getSpezColorNum(p.getUniqueId())));

        }
    }
}
