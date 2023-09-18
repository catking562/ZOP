package taewookim;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;
import taewookim.events.EntityReplaceWithSpawn;

import java.util.ArrayList;

public class ZombieApocalypse extends JavaPlugin {

    public static ArrayList<Entity> removing = new ArrayList<>();

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(new EntityReplaceWithSpawn(), this);
    }

    @Override
    public void onDisable() {
        for(Entity en : removing) {
            en.remove();
        }
    }

}
