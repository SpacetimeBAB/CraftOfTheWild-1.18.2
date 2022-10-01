package net.cotf.CraftOfTheWild.entity.client;

import net.cotf.CraftOfTheWild.CraftOfTheWild;
import net.cotf.CraftOfTheWild.entity.custom.StoneTalus.StoneTalusEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class StoneTalusModel extends AnimatedGeoModel<StoneTalusEntity> {


    @Override
    public ResourceLocation getModelLocation(StoneTalusEntity object) {
        return new ResourceLocation(CraftOfTheWild.MOD_ID, "animations/goologongia.animation.json");
    }

    @Override
    public ResourceLocation getTextureLocation(StoneTalusEntity object) {
        return StoneTalusRenderer.LOCATION_BY_VARIANT.get(object.getVariant());
    }

    @Override
    public ResourceLocation getAnimationFileLocation(StoneTalusEntity animatable) {
        return new ResourceLocation(CraftOfTheWild.MOD_ID, "geo/goologongia.geo.json");
    }
}