package org.createhive.createculinary.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import org.createhive.createculinary.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GEAR_COOKIES, Models.GENERATED);

        // Dishies
        itemModelGenerator.register(ModItems.DISH, Models.GENERATED);
        itemModelGenerator.register(ModItems.DIRTY_DISH, Models.GENERATED);
        itemModelGenerator.register(ModItems.PASTA_DISH, Models.GENERATED);

        // Milkshakes
        itemModelGenerator.register(ModItems.MILKSHAKE_CUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOCOLATE_MILKSHAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOCOLATE_MILK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BANANA_MILKSHAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAWBERRY_MILKSHAKE, Models.GENERATED);
    }
}
