package taewookim.events;

import net.minecraft.world.level.World;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import taewookim.ZombieApocalypse;
import taewookim.entities.RealZombie;

public class EntityReplaceWithSpawn implements Listener {

    @EventHandler
    public void spawn(EntitySpawnEvent e) {
        String entityname = ((CraftEntity) e.getEntity()).getHandle().getClass().getSimpleName();
        switch(entityname) {
            case "EntityZombie":
                if(true) {
                    e.setCancelled(true);
                    World w = ((CraftEntity) e.getEntity()).getHandle().dI();
                    w.addFreshEntity(new RealZombie(w, e.getLocation()), CreatureSpawnEvent.SpawnReason.NATURAL);
                }
                break;
            default:
                ZombieApocalypse.removing.add(e.getEntity());
                break;
        }
    }

}
