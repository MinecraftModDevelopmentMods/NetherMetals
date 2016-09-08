package dank.modularity.api;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Loader;

import java.util.List;

@SuppressWarnings("unused")
public class ModularityApi {

    public static void angerPigmen(BlockPos pos, World world, EntityLivingBase revenge, final int radius) {
        List<EntityPigZombie> e = world.getEntitiesWithinAABB(EntityPigZombie.class, new AxisAlignedBB(pos.getX() - radius, pos.getY() - radius, pos.getZ() - radius, pos.getX() + radius, pos.getY() + radius, pos.getZ() + radius));
        for(EntityPigZombie pigZombie : e) {
            pigZombie.setRevengeTarget(revenge);
            pigZombie.attackEntityAsMob(revenge);
        }
    }

    public static boolean isServer() {
        return FMLCommonHandler.instance().getEffectiveSide().isServer();
    }

    public static boolean isClient() {
        return FMLCommonHandler.instance().getEffectiveSide().isClient();
    }

    public static boolean isDevEnv() {
        return (Boolean) Launch.blackboard.get("fml.deobfuscatedEnvironment");
    }

    public boolean isModuleLoaded(String module) {
        return Loader.isModLoaded("modularity" + module);
    }

}