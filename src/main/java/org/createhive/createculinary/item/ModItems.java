package org.createhive.createculinary.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.createhive.createculinary.CreateCulinary;

import com.simibubi.create.Create;

public class ModItems {

    public static final Item GEAR_COOKIES = registerItem("gear_cookies", new Item(new FabricItemSettings().food(ModFoodComponents.GEAR_COOKIES)));
    public static final Item DISH = registerItem("dish", new Item(new FabricItemSettings()));
    public static final Item DIRTY_DISH = registerItem("dirty_dish", new Item(new FabricItemSettings()));
    public static final Item PASTA_DISH = registerItem("pasta_dish", new Item(new FabricItemSettings().food(ModFoodComponents.PASTA_DISH)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(CreateCulinary.MOD_ID, name), item);
    }

    public static void registerModItems() {
        CreateCulinary.LOGGER.info("Registering Mod Items for " + CreateCulinary.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }
}
