package org.createhive.createculinary.item;

import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
    public static final FoodComponent GEAR_COOKIES = new FoodComponent.Builder().hunger(6).saturationModifier(0.8f)
            .build();

    public static final FoodComponent PASTA_DISH = new FoodComponent.Builder().hunger(8).saturationModifier(0.8f)
            .build();
}
