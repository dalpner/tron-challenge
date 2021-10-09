package tronchallenge;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public class TronChallenge extends JavaPlugin {

    private final HashMap<UUID, Integer> playerLifeHashMap = new HashMap<>();
    private final HashMap<UUID, Integer> playerColorHashMap = new HashMap<>();

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

    public HashMap<UUID, Integer> getPlayerColorHashMap() {
        return playerColorHashMap;
    }

    public void addPlayerColorHashMap(UUID key, int num) {
        playerColorHashMap.put(key, num);
    }

    public HashMap<UUID, Integer> getPlayerLifeHashMap() {
        return playerLifeHashMap;
    }

    public int getSpezColorNum(UUID key){
        return playerColorHashMap.get(key);
    }

    public void addPlayerLifeHashMap(UUID key, int num) {
        playerLifeHashMap.put(key, num);
    }


}
