package com.yannickmyxe.neochests.datagen;

import com.yannickmyxe.neochests.NeoChests;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = NeoChests.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class DataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent dataEvent) {
        DataGenerator gen = dataEvent.getGenerator();
        PackOutput packOut = gen.getPackOutput();
        ExistingFileHelper fileHelper = dataEvent.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = dataEvent.getLookupProvider();

        gen.addProvider(dataEvent.includeServer(), new LootTableProvider(packOut, Collections.emptySet(), List.of(
                new LootTableProvider.SubProviderEntry(ModBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider
        ));
    }
}
