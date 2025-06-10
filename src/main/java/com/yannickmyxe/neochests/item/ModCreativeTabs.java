package com.yannickmyxe.neochests.item;

import com.yannickmyxe.neochests.NeoChests;
import com.yannickmyxe.neochests.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NeoChests.MOD_ID);

    public static void register(IEventBus eventBus) {
        CREATIVE_TAB.register(eventBus);
    }

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS = CREATIVE_TAB.register("bismuth_items_tab", () ->
                CreativeModeTab.builder()
                        .icon(() -> new ItemStack(ModItems.BISMUTH.get()))
                        .title(Component.translatable("creativetab.neochests.bismuth_items"))
                        .displayItems((params, output) -> {
                            output.accept(ModItems.BISMUTH.get());
                            output.accept(ModItems.RAW_BISMUTH.get());
                        })
                .build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS = CREATIVE_TAB.register("bismuth_blocks_tab", () ->
            CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(NeoChests.MOD_ID, "bismuth_items_tab"))
                    .icon(() -> new ItemStack(ModBlocks.BISMUTH_BLOCK.get()))
                    .title(Component.translatable("creativetab.neochests.bismuth_blocks"))
                    .displayItems((params, output) -> {
                        output.accept(ModBlocks.BISMUTH_BLOCK.get());
                        output.accept(ModBlocks.BISMUTH_ORE_BLOCK.get());
                        output.accept(ModBlocks.BISMUTH_DEEPSLATE_ORE_BLOCK.get());
                    })
                    .build());
}
