package org.createhive.createculinary.item.type;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.createhive.createculinary.item.ModItems;

public class PlateItem extends Item {
    public PlateItem(Settings settings) {
        super(settings);
    }

    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack retval = new ItemStack(ModItems.DIRTY_DISH);
        super.finishUsing(stack, world, user);
        if (stack.isEmpty()) {
            return retval;
        } else {
            if (user instanceof PlayerEntity player && !player.isCreative()) {
                player.getInventory().offerOrDrop(retval);
            }
            return stack;
        }
    }
}
