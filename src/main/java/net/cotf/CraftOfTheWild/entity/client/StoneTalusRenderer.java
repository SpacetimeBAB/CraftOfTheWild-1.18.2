package net.cotf.CraftOfTheWild.entity.client;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.cotf.CraftOfTheWild.CraftOfTheWild;
import net.cotf.CraftOfTheWild.entity.custom.StoneTalus.StoneTalusEntity;
import net.cotf.CraftOfTheWild.entity.variant.StoneTalusVariant;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import java.util.Map;

public class StoneTalusRenderer extends GeoEntityRenderer<StoneTalusEntity> {
    public static final Map<StoneTalusVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(StoneTalusVariant.class), (p_114874_) -> {
                p_114874_.put(StoneTalusVariant.WILD,
                        new ResourceLocation(CraftOfTheWild.MOD_ID, "textures/entity/stone_talus/stone_tallus_box.png"));
                p_114874_.put(StoneTalusVariant.BOX,
                        new ResourceLocation(CraftOfTheWild.MOD_ID, "textures/entity/stone_talus/stone_tallus_without_box.png"));
            });


    public StoneTalusRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new StoneTalusModel());
        this.shadowRadius = 0.5f;
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull StoneTalusEntity instance) {
        return LOCATION_BY_VARIANT.get(instance.getVariant());
    }

    @Override
    public RenderType getRenderType(StoneTalusEntity animatable, float partialTicks, PoseStack stack,
                                    MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
                                    ResourceLocation textureLocation) {
        stack.scale(1F, 1F, 1F);
        return super.getRenderType(animatable, partialTicks, stack, renderTypeBuffer, vertexBuilder, packedLightIn, textureLocation);
    }
}
