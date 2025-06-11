package com.yannickmyxe.neochests.util;

import com.yannickmyxe.neochests.NeoChests;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static TagKey<Block> createTag(String tagName) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(NeoChests.MOD_ID, tagName));
        }
    }

    public static class Items {

        public static final TagKey<Item> BISMUTH = createTag("bismuth");

        public static TagKey<Item> createTag(String tagName) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(NeoChests.MOD_ID, tagName));
        }
    }
}
