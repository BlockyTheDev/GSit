package dev.geco.gsit.mcv.v1_19_R1_2.util;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.craftbukkit.v1_19_R1.*;
import org.bukkit.craftbukkit.v1_19_R1.entity.*;

import dev.geco.gsit.util.*;
import dev.geco.gsit.mcv.v1_19_R1_2.objects.*;

public class SpawnUtil implements ISpawnUtil {

    public boolean needCheck() { return false; }

    public boolean checkLocation(Location Location) { return true; }

    public boolean checkPlayerLocation(Entity Holder) { return true; }

    public Entity createSeatEntity(Location Location, Entity Rider, boolean Rotate) {

        SeatEntity seatEntity = new SeatEntity(Location);

        if(Rider != null && Rider.isValid()) ((CraftEntity) Rider).getHandle().startRiding(seatEntity, true);

        ((CraftWorld) Location.getWorld()).getHandle().entityManager.addNewEntity(seatEntity);

        if(Rotate) seatEntity.startRotate();

        return seatEntity.getBukkitEntity();
    }

    public Entity createPlayerSeatEntity(Entity Holder, Entity Rider) {

        PlayerSeatEntity playerSeatEntity = new PlayerSeatEntity(Holder.getLocation());

        if(Rider != null && Rider.isValid()) {

            playerSeatEntity.startRiding(((CraftEntity) Holder).getHandle(), true);

            ((CraftEntity) Rider).getHandle().startRiding(playerSeatEntity, true);
        }

        ((CraftWorld) Holder.getWorld()).getHandle().entityManager.addNewEntity(playerSeatEntity);

        return playerSeatEntity.getBukkitEntity();
    }

}