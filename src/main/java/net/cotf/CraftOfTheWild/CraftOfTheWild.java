package net.cotf.CraftOfTheWild;

import com.mojang.logging.LogUtils;
import net.cotf.CraftOfTheWild.inits.EntityInit;
import net.cotf.CraftOfTheWild.inits.ItemInit;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.EventBus;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;



@Mod(CraftOfTheWild.MOD_ID)
public class CraftOfTheWild
{
    // Directly reference a slf4j logger
    public static final String MOD_ID = "cotf";
    private static final Logger LOGGER = LogUtils.getLogger();

    public CraftOfTheWild()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();


        EntityInit.register(modEventBus);
        ItemInit.register(modEventBus);
        modEventBus.addListener(this::setup);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }




    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {

        }
    }
}
