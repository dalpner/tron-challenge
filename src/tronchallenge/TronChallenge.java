package tronchallenge;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class TronChallenge extends JavaPlugin {

    private final Map<UUID, Integer> playerLifeHashMap = new HashMap<>();
    private final Map<UUID, Material> playerColorHashMap = new HashMap<>();

    public static TronChallenge tronChallenge;

    @Override
    public void onEnable() {
        PluginManager myPluginManager = Bukkit.getPluginManager();
        myPluginManager.registerEvents(new PlayerMovementListener(), this);
        myPluginManager.registerEvents(new PlayerJoinListener(), this);
        tronChallenge = this;
    }

    @Override
    public void onDisable() {
        System.out.println("Shutting down...");
    }

    public Map<UUID, Material> getPlayerColorHashMap() {
        return playerColorHashMap;
    }

    public void addPlayerColorHashMap(UUID key, int num) {
        Material material = Colornames.getColor(num);
        playerColorHashMap.put(key, material);
    }

    public Map<UUID, Integer> getPlayerLifeHashMap() {
        return playerLifeHashMap;
    }

    public Material getSpezColorNum(UUID key){
        return playerColorHashMap.get(key);
    }

    public void addPlayerLifeHashMap(UUID key, int num) {
        playerLifeHashMap.put(key, num);
    }


}
