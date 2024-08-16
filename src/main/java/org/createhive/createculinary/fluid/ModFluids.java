package org.createhive.createculinary.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.createhive.createculinary.CreateCulinary;

public class ModFluids {
    private static Fluid RegisterFluid(String name, Fluid fluid) {
        registerBucket(name, fluid);
        return Registry.register(Registries.FLUID, new Identifier(CreateCulinary.MOD_ID, name), fluid);
    }

    private static BucketItem registerBucket(String name, Fluid fluid) {
        return Registry.register(Registries.ITEM, new Identifier(CreateCulinary.MOD_ID, name),
                new BucketItem(fluid, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        CreateCulinary.LOGGER.info("Registering ModFluids for " + CreateCulinary.MOD_ID);
    }
}
