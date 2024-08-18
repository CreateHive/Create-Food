package org.createhive.createculinary.item;

import com.simibubi.create.Create;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.createhive.createculinary.CreateCulinary;

public class ModItemGroups {
    public static final ItemGroup CREATE_CULINARY = Registry.register(Registries.ITEM_GROUP,
            new Identifier(CreateCulinary.MOD_ID, CreateCulinary.MOD_GROUP),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.createculinary"))
                    .icon(() -> new ItemStack(ModItems.GEAR_COOKIES)).entries((displayContext, entries) -> {
                        entries.add(ModItems.GEAR_COOKIES);
                        // Dishies
                        entries.add(ModItems.DISH);
                        entries.add(ModItems.DIRTY_DISH);
                        entries.add(ModItems.PASTA_DISH);

                        // Milkshakes
                        entries.add(ModItems.MILKSHAKE_CUP);
                        entries.add(ModItems.STRAWBERRY_MILKSHAKE);
                        entries.add(ModItems.CHOCOLATE_MILKSHAKE);
                        entries.add(ModItems.BANANA_MILKSHAKE);
                    }).build());

    public static void registerItemGroups() {
        CreateCulinary.LOGGER.info("Registering Item Groups for " + CreateCulinary.MOD_ID);
    }
}