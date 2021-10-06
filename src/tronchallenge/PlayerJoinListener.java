package tronchallenge;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    private int colorNum = 1;

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.getPlayer().sendMessage("Ich bin klein!");
        Bukkit.broadcastMessage(String.format("%s ist gejoint", event.getPlayer().getDisplayName()));

        if (colorNum < 8) {
            if (TronChallenge.tronChallenge.getPlayerLifeHashMap().containsKey(event.getPlayer().getUniqueId())) {
                Bukkit.broadcastMessage("Verpiss dich wieder! Du warst schon einmal hier");
            } else {
                TronChallenge.tronChallenge.addPlayerLifeHashMap(event.getPlayer().getUniqueId(), 3);
            }
            if (TronChallenge.tronChallenge.getPlayerColorHashMap().containsKey(event.getPlayer().getUniqueId())) {
                Bukkit.broadcastMessage("Verpiss dich wieder! Du warst schon einmal hier");
            } else {
                TronChallenge.tronChallenge.addPlayerColorHashMap(event.getPlayer().getUniqueId(), colorNum++);
            }
        }

        Bukkit.broadcastMessage(String.format("Es wurde ein HashMapLife-Eintrag erstellt! %s", TronChallenge.tronChallenge.getPlayerLifeHashMap()));
        Bukkit.broadcastMessage(String.format("Es wurde ein HashMapColor-Eintrag erstellt! %s", TronChallenge.tronChallenge.getPlayerColorHashMap()));

    }

}
