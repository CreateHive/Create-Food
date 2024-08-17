package org.createhive.createculinary.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.createhive.createculinary.CreateCulinary;
import org.createhive.createculinary.fluid.ModFluids;
import org.createhive.createculinary.item.ModItemGroups;

public class ModBlocks {
    private static Object ModItemGroup;
    public static final Block CHOCOLATE_MILK_BLOCK = registerBlockWithoutBlockItem("chocolate_milk_block",
            new ModFluidBlock(ModFluids.CHOCOLATE_MILK_STILL, FabricBlockSettings.create()
                    .nonOpaque().dropsNothing()));

    public static final Block STRAWBERRY_MILK_BLOCK = registerBlockWithoutBlockItem("strawberry_milk_block",
            new ModFluidBlock(ModFluids.STRAWBERRY_MILK_STILL, FabricBlockSettings.create()
                    .nonOpaque().dropsNothing()));

    public static final Block BANANA_MILK_BLOCK = registerBlockWithoutBlockItem("banana_milk_block",
            new ModFluidBlock(ModFluids.BANANA_MILK_STILL, FabricBlockSettings.create()
                    .nonOpaque().dropsNothing()));

    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, new Identifier(CreateCulinary.MOD_ID, name), block);
    }

    private static Block RegisterBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(CreateCulinary.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(CreateCulinary.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CreateCulinary.LOGGER.info("Registering ModBlocks for " + CreateCulinary.MOD_ID);
    }
}
