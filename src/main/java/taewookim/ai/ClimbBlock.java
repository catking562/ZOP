package taewookim.ai;

import net.minecraft.world.entity.EntityInsentient;
import net.minecraft.world.entity.EntityLiving;
import net.minecraft.world.entity.ai.goal.PathfinderGoal;
import net.minecraft.world.entity.monster.EntityMonster;
import org.bukkit.craftbukkit.v1_20_R1.util.CraftVector;
import org.bukkit.entity.LivingEntity;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class ClimbBlock extends PathfinderGoal {

    EntityInsentient entity;
    double speed;
    double ddx = 0;
    double ddz = 0;

    public ClimbBlock(EntityInsentient entity, double speed) {
        this.entity = entity;
        this.speed = speed;
    }

    @Override
    public boolean a() {
        if(entity.j()!=null) {
            EntityLiving j = entity.j();
            double x = entity.dn();
            double y = entity.dp();
            double z = entity.dt();
            double jx = j.dn();
            double jy = j.dp();
            double jz = j.dt();
            if(y<jy) {
                double dx = jx-x;
                double dz = jz-z;
                if(Math.abs(dx)>Math.abs(dz)) {
                    if(!entity.getBukkitEntity().getWorld().getBlockAt((int) (x + (dx<0?-0.5D:+0.5D)), (int) y+1, (int)z).isPassable()||!entity.getBukkitEntity().getWorld().getBlockAt((int) (x + (dx<0?-0.5D:+0.5D)), (int) y, (int)z).isPassable()) {
                        ddz = 0;
                        ddx = dx<0?-0.1D:+0.1D;
                        return true;
                    }
                }else {
                    if(!entity.getBukkitEntity().getWorld().getBlockAt((int) x, (int) y+1, (int)(z + (dz<0?-0.5D:+0.5D))).isPassable()||!entity.getBukkitEntity().getWorld().getBlockAt((int) x, (int) y, (int)(z + (dz<0 ? -0.5D : +0.5D))).isPassable()) {
                        ddx = 0;
                        ddz = dz<0?-0.1D:+0.1D;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void e() {
        this.entity.f(CraftVector.toNMS(entity.getBukkitEntity().getVelocity().add(new Vector(ddx, speed, ddz))));
        this.entity.S = true;
    }
}
