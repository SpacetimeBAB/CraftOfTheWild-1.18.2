package net.cotf.CraftOfTheWild.entity.custom.StoneTalus;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;

public class StoneTalusPart extends net.minecraftforge.entity.PartEntity<StoneTalusEntity>{
    public final StoneTalusEntity parentMob;
    public final String name;
    private final EntityDimensions size;





    public StoneTalusPart(StoneTalusEntity stoneTalusEntity, String name, float v, float v1, StoneTalusEntity parentMob, String called, EntityDimensions size) {
        super(stoneTalusEntity);
        this.parentMob = parentMob;
        this.name = name;
        this.size = size;
    }

    public boolean isPickable() {
        return true;
    }

    public boolean hurt(DamageSource p_31020_, float p_31021_) {
        return this.isInvulnerable();
    }

    public boolean is(Entity p_31031_) {
        return this == p_31031_ || this.parentMob == p_31031_;
    }

    public Packet<?> getAddEntityPacket() {
        throw new UnsupportedOperationException();
    }

    public EntityDimensions getDimensions(Pose p_31023_) {
        return this.size;
    }

    public boolean shouldBeSaved() {
        return false;
    }

    @Override
    protected void defineSynchedData() {

    }

    @Override
    protected void readAdditionalSaveData(CompoundTag p_20052_) {

    }

    @Override
    protected void addAdditionalSaveData(CompoundTag p_20139_) {

    }
}
