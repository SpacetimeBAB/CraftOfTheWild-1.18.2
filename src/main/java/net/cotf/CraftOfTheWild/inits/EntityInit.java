package net.cotf.CraftOfTheWild.inits;

import net.cotf.CraftOfTheWild.CraftOfTheWild;
import net.cotf.CraftOfTheWild.entity.custom.StoneTalus.StoneTalusEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EntityInit {

    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITIES, CraftOfTheWild.MOD_ID);


    public static final RegistryObject<EntityType<StoneTalusEntity>> STONE_TALLUS =
            ENTITY_TYPES.register("stone_tallus",
                    () -> EntityType.Builder.of(StoneTalusEntity::new,MobCategory.MONSTER)
                            .sized(0.8f, 0.6f)
                            .build(new ResourceLocation(CraftOfTheWild.MOD_ID, "stone_tallus").toString()));




    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }

}
