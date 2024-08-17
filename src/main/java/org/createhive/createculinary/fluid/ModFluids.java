package org.createhive.createculinary.fluid;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.createhive.createculinary.CreateCulinary;

public class ModFluids {
    public static final FlowableFluid CHOCOLATE_MILK_STILL = register("chocolate_milk_still", new ChocolateMilk.Still());
    public static final FlowableFluid CHOCOLATE_MILK_FLOWING = register("chocolate_milk_flowing", new ChocolateMilk.Flowing());

    private static FlowableFluid register(String name, FlowableFluid flowableFluid) {
        return Registry.register(Registries.FLUID, new Identifier(CreateCulinary.MOD_ID, name), flowableFluid);
    }
}
