package net.cotf.CraftOfTheWild.entity.custom.StoneTalus;


import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;

public class StoneTalusStone extends net.minecraftforge.entity.PartEntity<StoneTalusEntity>{

    public final StoneTalusEntity parentMob;
    public final String name;
    private final EntityDimensions size;



    public StoneTalusStone(StoneTalusEntity parent, StoneTalusEntity parentMob, String name, EntityDimensions size) {
        super(parent);
        this.parentMob = parentMob;
        this.name = name;
        this.size = size;
    }
    public boolean isPickable() {
        return true;
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


    public boolean hurt(DamageSource hurt, float hurt1) {
        return this.isInvulnerableTo(hurt) ? false : this.parentMob.hurt(this, hurt, hurt1);
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
