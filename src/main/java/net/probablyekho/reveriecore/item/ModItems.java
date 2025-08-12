package net.probablyekho.reveriecore.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.probablyekho.reveriecore.ReverieCore;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(ReverieCore.MODID);

    public static final DeferredItem<Item> BATTERY = ITEMS.register("battery",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BUTTER = ITEMS.register("butter",
            () -> new Item(new Item.Properties().food(ModFoodComponents.BUTTER)));
    public static final DeferredItem<Item> FISHSTICKS = ITEMS.register("fish_sticks",
            () -> new Item(new Item.Properties().food(ModFoodComponents.FISHSTICKS)));
    public static final DeferredItem<Item> RAW_COPPER_CLUMP = ITEMS.register("raw_copper_clump",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_IRON_CLUMP = ITEMS.register("raw_iron_clump",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> RAW_GOLD_CLUMP = ITEMS.register("raw_gold_clump",
            () -> new Item(new Item.Properties()));
    public static final DeferredItem<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}