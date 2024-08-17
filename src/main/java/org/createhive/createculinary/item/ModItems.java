package org.createhive.createculinary.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.createhive.createculinary.CreateCulinary;
import org.createhive.createculinary.item.type.PlateItem;

public class ModItems {
    public static final Item GEAR_COOKIES = registerItem("gear_cookies", new Item(new FabricItemSettings().food(ModFoodComponents.GEAR_COOKIES)));
    // Dishies
    public static final Item DISH = registerItem("dish", new Item(new FabricItemSettings()));
    public static final Item DIRTY_DISH = registerItem("dirty_dish", new Item(new FabricItemSettings()));
    public static final PlateItem PASTA_DISH = (PlateItem) registerItem("pasta_dish", new PlateItem(new FabricItemSettings().food(ModFoodComponents.PASTA_DISH)));

    // Milkshakes
    public static final Item MILKSHAKE_CUP = registerItem("milkshake_cup", new Item(new FabricItemSettings()));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CreateCulinary.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CreateCulinary.LOGGER.info("Registering Mod Items for " + CreateCulinary.MOD_ID);
    }
}
