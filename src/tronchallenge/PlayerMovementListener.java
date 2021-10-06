package tronchallenge;

import java.util.concurrent.ThreadLocalRandom;

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
    public void onPlayerMove(PlayerMoveEvent event){

        Player p = event.getPlayer();
        Block b = p.getLocation().getBlock().getRelative(BlockFace.DOWN);

        if (b.getType() != Material.OBSIDIAN && b.getType() != Material.AIR && b.getType() != Material.WATER){
            World w = p.getWorld();
            int rdmColor = ThreadLocalRandom.current().nextInt(9);;
//            System.out.println(rdmColor);
            switch (rdmColor){
                case 0:
                    w.getBlockAt(b.getLocation()).setType(Material.BLUE_WOOL);
                    break;

                case 1:
                    w.getBlockAt(b.getLocation()).setType(Material.LIGHT_BLUE_WOOL);
                    break;
                case 2:
                    w.getBlockAt(b.getLocation()).setType(Material.RED_WOOL);
                    break;
                case 3:
                    w.getBlockAt(b.getLocation()).setType(Material.ORANGE_WOOL);
                    break;
                case 4:
                    w.getBlockAt(b.getLocation()).setType(Material.YELLOW_WOOL);
                    break;
                case 5:
                    w.getBlockAt(b.getLocation()).setType(Material.PINK_WOOL);
                    break;
                case 6:
                    w.getBlockAt(b.getLocation()).setType(Material.MAGENTA_WOOL);
                    break;
                case 7:
                    w.getBlockAt(b.getLocation()).setType(Material.CYAN_WOOL);
                    break;
                case 8:
                    w.getBlockAt(b.getLocation()).setType(Material.PURPLE_WOOL);
                    break;
                case 9:
                    w.getBlockAt(b.getLocation()).setType(Material.GREEN_WOOL);
                    break;
                default:
                    w.getBlockAt(b.getLocation()).setType(Material.WHITE_WOOL);
            }
        }


    }
}
