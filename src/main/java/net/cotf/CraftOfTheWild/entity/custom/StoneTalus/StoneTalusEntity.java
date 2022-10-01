package net.cotf.CraftOfTheWild.entity.custom.StoneTalus;

import net.cotf.CraftOfTheWild.entity.variant.StoneTalusVariant;
import net.minecraft.Util;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.boss.EnderDragonPart;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class StoneTalusEntity extends Animal implements IAnimatable {

    public final StoneTalusEntity parentMob;
    public final String name;
    private final EntityDimensions size;


    private final StoneTalusPart[] subEntities;
    public final StoneTalusPart arm_right1;
    private final StoneTalusPart head;
    private final StoneTalusPart body;
    private final StoneTalusPart arm_left;
    private final StoneTalusPart left_leg;
    private final StoneTalusPart right_leg;

    private final StoneTalusStone[] subEntity;
    public final StoneTalusStone rock_forattack;



    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT=
            SynchedEntityData.defineId(StoneTalusEntity.class, EntityDataSerializers.INT);









        private AnimationFactory factory = new AnimationFactory(this);

        public StoneTalusEntity(EntityType<? extends Animal> p_30341_, Level p_30342_, StoneTalusPart[] subEntities, StoneTalusPart arm_right1, StoneTalusPart head, StoneTalusPart body, StoneTalusPart arm_left, StoneTalusPart left_leg, StoneTalusEntity parentMob, String name, EntityDimensions size, StoneTalusPart right_leg, StoneTalusStone[] subEntity, StoneTalusStone rock_forattack) {
            super(p_30341_, p_30342_);
            this.parentMob = parentMob;
            this.name = name;
            this.size = size;
            this.subEntities = new StoneTalusPart[]{this.parentMob.arm_left, this.parentMob.arm_right1, this.parentMob.head, this.parentMob.body, this.parentMob.left_leg, this.parentMob.right_leg};
            this.arm_right1 = new StoneTalusPart(this, "arm_right1", 1.0F, 1.0F, this.parentMob, this.name, this.size);
            this.head = new StoneTalusPart(this, "head", 1.0F, 1.0F, this.parentMob, this.name, this.size);
            this.body = new StoneTalusPart(this, "body", 1.0F, 1.0F, this.parentMob, this.name, this.size);;
            this.arm_left = new StoneTalusPart(this, "arm_left", 1.0F, 1.0F, this.parentMob, this.name, this.size);
            this.left_leg = new StoneTalusPart(this, "left_leg", 1.0F, 1.0F, this.parentMob, this.name, this.size);

            this.right_leg = new StoneTalusPart(this, "right_leg", 1.0F, 1.0F, this.parentMob, this.name, this.size);
            this.subEntity = new StoneTalusStone[]{this.parentMob.rock_forattack};
            this.rock_forattack = rock_forattack;
        }





        public static AttributeSupplier.Builder attributes() {
            return Mob.createMobAttributes()
                    .add(Attributes.MAX_HEALTH, 400.0D)
                    .add(Attributes.MOVEMENT_SPEED, (double) 1D)
                    .add(Attributes.ATTACK_DAMAGE,5D)
                    .add(Attributes.ARMOR,6D);
        }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public net.minecraftforge.entity.PartEntity<?>[] getParts() {
        return this.subEntities;
    }


        protected void registerGoals() {
            this.goalSelector.addGoal(2, new RandomLookAroundGoal(this));
            this.targetSelector.addGoal(3, (new HurtByTargetGoal(this)).setAlertOthers());
            this.goalSelector.addGoal(4,new MeleeAttackGoal(this,2.0d,false));
            this.goalSelector.addGoal(3,new NearestAttackableTargetGoal<>(this, Player.class,false));
        }



        protected PathNavigation createNavigation(Level waterBoundPathNavigation) {
            return new GroundPathNavigation(this, waterBoundPathNavigation);
        }



        public boolean doHurtTarget(Entity p_28319_) {
            boolean flag = p_28319_.hurt(DamageSource.mobAttack(this), (float)((int)this.getAttributeValue(Attributes.ATTACK_DAMAGE)));
            if (flag) {
                this.doEnchantDamageEffects(this, p_28319_);
                this.playSound(SoundEvents.LIGHTNING_BOLT_IMPACT, 1.0F, 1.0F);
            }

            return flag;
        }







        private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
            if (event.isMoving()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bungartius.swim", true));
                return PlayState.CONTINUE;
            }
            if (!this.isInWater()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bungartius.flop", true));
                return PlayState.CONTINUE;
            }
            if (this.isAggressive() && isAlive() && isInWater()) {
                event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.bungartius.bite", false));
                return PlayState.CONTINUE;
            }

            return PlayState.CONTINUE;
        }


        @Override
        public void registerControllers(AnimationData data) {
            data.addAnimationController(new AnimationController(this, "controller",
                    0, this::predicate));
        }

        @Override
        public AnimationFactory getFactory() {
            return this.factory;
        }



        protected SoundEvent getAmbientSound() {
            return SoundEvents.AMBIENT_BASALT_DELTAS_ADDITIONS;
        }

        protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
            return SoundEvents.HOGLIN_HURT;
        }

        protected SoundEvent getDeathSound() {
            return SoundEvents.DOLPHIN_DEATH;
        }




        protected float getSoundVolume() {
            return 0.5F;
        }




        @Override
        public void readAdditionalSaveData(CompoundTag tag) {
            super.readAdditionalSaveData(tag);
            this.entityData.set(DATA_ID_TYPE_VARIANT, tag.getInt("Variant"));

        }

        @Override
        public void addAdditionalSaveData(CompoundTag tag) {
            super.addAdditionalSaveData(tag);
            tag.putInt("Variant",this.getTypeVariant());
        }

        @Override
        protected void defineSynchedData() {
            super.defineSynchedData();
            this.entityData.define(DATA_ID_TYPE_VARIANT, 0);
        }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_146746_, DifficultyInstance p_146747_,
                                        MobSpawnType p_146748_, @Nullable SpawnGroupData p_146749_,
                                        @Nullable CompoundTag p_146750_) {
        StoneTalusVariant variant = Util.getRandom(StoneTalusVariant.values(), this.random);
        setVariant(variant);
        return super.finalizeSpawn(p_146746_, p_146747_, p_146748_, p_146749_, p_146750_);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    public StoneTalusVariant getVariant() {
        return StoneTalusVariant.byId(this.getTypeVariant() & 255);
    }

    private int getTypeVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    private void setVariant(StoneTalusVariant variant) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, variant.getId() & 255);
    }


    public boolean hurt(StoneTalusStone stoneTalusStone, DamageSource p_31020_, float p_31021_) {
        return true;
    }
}

