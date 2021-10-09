package tronchallenge;

import org.bukkit.Material;

public class Colornames {

    public Material getColor(int colorNum) {
        switch (colorNum) {
            case 0:
                return Material.RED_WOOL;
            case 1:
                return Material.ORANGE_WOOL;
            case 2:
                return Material.YELLOW_WOOL;
            case 3:
                return Material.GREEN_WOOL;
            case 4:
                return Material.CYAN_WOOL;
            case 5:
                return Material.BLUE_WOOL;
            case 6:
                return Material.PURPLE_WOOL;
            case 7:
                return Material.PINK_WOOL;
            case 8:
                return Material.BROWN_WOOL;
            case 9:
                return Material.BLACK_WOOL;
            default:
                return Material.OBSIDIAN;
        }
    }
}
