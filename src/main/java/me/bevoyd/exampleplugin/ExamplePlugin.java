package me.bevoyd.exampleplugin;

import com.sk89q.worldedit.util.Location;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.UUID;

public final class ExamplePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        World world = WorldGuard.getInstance().getPlatform().getMatcher().getWorldByName("world");
        assert world != null;
        Location location = new Location(world, 0, 0, 0);

        ProtectedRegion toRegion = WorldGuard.getInstance().getPlatform().getRegionContainer().createQuery().getApplicableRegions(location).iterator().next();
        assert toRegion != null;

        WorldGuard wg = WorldGuard.getInstance();
        for (UUID uuid : toRegion.getOwners().getUniqueIds()) {
            System.out.println("Owner: " + wg.getProfileCache().getIfPresent(uuid));
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
