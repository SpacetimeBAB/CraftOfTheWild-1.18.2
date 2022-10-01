package net.cotf.CraftOfTheWild.inits;

import net.cotf.CraftOfTheWild.CraftOfTheWild;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, CraftOfTheWild.MOD_ID);

    public static final RegistryObject<Item> DIPLACANTHUS_EGGS = ITEMS.register("dipla_eggs",
            () -> new ForgeSpawnEggItem(EntityInit.STONE, 0xDFCC8F, 0x2D2611,
                    new Item.Properties().tab(CreativeModeTab.TAB_MISC)));







    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
