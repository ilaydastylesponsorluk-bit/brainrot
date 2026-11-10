package com.example.brainrotblocks;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod(BrainrotBlocks.MODID)
public class BrainrotBlocks {
    public static final String MODID = "brainrotblocks";

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    public static final List<RegistryObject<Item>> ALL_ITEMS = new ArrayList<>();

    // Yeni karakter eklemek icin buraya bir satir ekle (+ texture, blockstate, model, lang, loot table)
    static {
        registerBlock("smiley_block", MapColor.COLOR_YELLOW);
        registerBlock("wooden_face_block", MapColor.WOOD);
    }

    private static void registerBlock(String name, MapColor color) {
        RegistryObject<Block> block = BLOCKS.register(name, () -> new Block(
                BlockBehaviour.Properties.of()
                        .mapColor(color)
                        .strength(1.0F)
                        .sound(SoundType.WOOL)
                        .noOcclusion()));
        ALL_ITEMS.add(ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties())));
    }

    public static final RegistryObject<CreativeModeTab> MAIN_TAB = TABS.register("main", () ->
            CreativeModeTab.builder()
                    .title(Component.literal("Brainrot Blocks"))
                    .icon(() -> ALL_ITEMS.get(0).get().getDefaultInstance())
                    .displayItems((params, output) -> ALL_ITEMS.forEach(i -> output.accept(i.get())))
                    .build());

    public BrainrotBlocks() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        TABS.register(bus);
    }
}
