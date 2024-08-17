package org.createhive.createculinary.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.createhive.createculinary.CreateCulinary;
import org.createhive.createculinary.fluid.ModFluids;
import org.createhive.createculinary.item.type.MilkshakeItem;
import org.createhive.createculinary.item.type.PlateItem;

public class ModItems {
    public static final Item GEAR_COOKIES = registerItem("gear_cookies", new Item(new FabricItemSettings().food(ModFoodComponents.GEAR_COOKIES)));
    // Dishies
    public static final Item DISH = registerItem("dish", new Item(new FabricItemSettings()));
    public static final Item DIRTY_DISH = registerItem("dirty_dish", new Item(new FabricItemSettings()));
    public static final PlateItem PASTA_DISH = (PlateItem) registerItem("pasta_dish", new PlateItem(new FabricItemSettings().food(ModFoodComponents.PASTA_DISH)));

    // Milkshakes
    public static final Item MILKSHAKE_CUP = registerItem("milkshake_cup", new Item(new FabricItemSettings()));
    public static final MilkshakeItem STRAWBERRY_MILKSHAKE = (MilkshakeItem) registerItem("strawberry_milkshake", new MilkshakeItem(new FabricItemSettings()));
    public static final MilkshakeItem CHOCOLATE_MILKSHAKE = (MilkshakeItem) registerItem("chocolate_milkshake", new MilkshakeItem(new FabricItemSettings()));
    public static final MilkshakeItem BANANA_MILKSHAKE = (MilkshakeItem) registerItem("banana_milkshake", new MilkshakeItem(new FabricItemSettings()));

    public static final Item CHOCOLATE_MILK_BUCKET = registerItem("chocolate_milk_bucket", new BucketItem(ModFluids.CHOCOLATE_MILK_STILL,
            new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static final Item STRAWBERRY_MILK_BUCKET = registerItem("strawberry_milk_bucket", new BucketItem(ModFluids.STRAWBERRY_MILK_STILL,
            new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));

    public static final Item BANANA_MILK_BUCKET = registerItem("banana_milk_bucket", new BucketItem(ModFluids.BANANA_MILK_STILL,
            new FabricItemSettings().recipeRemainder(Items.BUCKET).maxCount(1)));


    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CreateCulinary.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CreateCulinary.LOGGER.info("Registering Mod Items for " + CreateCulinary.MOD_ID);
    }
}
