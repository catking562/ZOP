package taewookim.entities;

import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.PathfinderGoalNearestAttackableTarget;
import net.minecraft.world.entity.ai.navigation.NavigationAbstract;
import net.minecraft.world.entity.ai.navigation.NavigationSpider;
import net.minecraft.world.entity.monster.EntityZombie;
import net.minecraft.world.entity.player.EntityHuman;
import net.minecraft.world.level.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_20_R1.entity.CraftMonster;
import taewookim.ai.ClimbBlock;

public class RealZombie extends EntityZombie {

    public RealZombie(World world, Location loc) {
        super(EntityTypes.bp, world);
        this.a(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
    }

    @Override
    protected NavigationAbstract b(World world) {
        return new NavigationSpider(this, world);
    }

    @Override
    protected void x() {
        this.bO.a(8, new PathfinderGoalRandomLookaround(this));
        this.q();
    }

    @Override
    protected void q() {
        this.bO.a(2, new ClimbBlock(this, 0.2));
        this.bO.a(2, new PathfinderGoalZombieAttack(this, 2.0, false));
        this.bO.a(7, new PathfinderGoalRandomStrollLand(this, 0.5));
        this.bP.a(2, new PathfinderGoalNearestAttackableTarget(this, EntityHuman.class, true));
    }

    @Override
    public boolean f_() {
        return super.f_();
    }
}
