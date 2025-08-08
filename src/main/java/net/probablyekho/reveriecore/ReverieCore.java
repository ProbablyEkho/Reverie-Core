package net.probablyekho.reveriecore;

import net.probablyekho.reveriecore.block.ModBlocks;
import net.probablyekho.reveriecore.item.ModItems;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ReverieCore.MODID)
public class ReverieCore {
    public static final String MODID = "reveriecore";
    public static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public ReverieCore(IEventBus modEventBus, ModContainer modContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(FMLCommonSetupEvent event) {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BATTERY);
        }
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.BUTTER);
            event.accept(ModItems.FISHSTICKS);
        }
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.COBBLED_ANDESITE);
            event.accept(ModBlocks.COBBLED_DIORITE);
            event.accept(ModBlocks.COBBLED_GRANITE);
            event.accept(ModBlocks.COBBLED_ANDESITE_SLAB);
            event.accept(ModBlocks.COBBLED_DIORITE_SLAB);
            event.accept(ModBlocks.COBBLED_GRANITE_SLAB);
            event.accept(ModBlocks.COBBLED_ANDESITE_WALL);
            event.accept(ModBlocks.COBBLED_DIORITE_WALL);
            event.accept(ModBlocks.COBBLED_GRANITE_WALL);
            event.accept(ModBlocks.COBBLED_ANDESITE_STAIRS);
            event.accept(ModBlocks.COBBLED_DIORITE_STAIRS);
            event.accept(ModBlocks.COBBLED_GRANITE_STAIRS);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }
}
