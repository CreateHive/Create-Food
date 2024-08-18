package org.createhive.createculinary.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.createhive.createculinary.item.ModItems;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> MIXABLE = List.of(ModItems.DIRTY_DISH);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.GEAR_COOKIES, 1)
                .pattern(" x ")
                .pattern("x x")
                .pattern(" x ")
                .input('x', Items.COOKIE)
                .criterion(hasItem(Items.COOKIE), conditionsFromItem(Items.COOKIE))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.GEAR_COOKIES)));

    }
}
