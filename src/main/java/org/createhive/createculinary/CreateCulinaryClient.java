package org.createhive.createculinary;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import org.createhive.createculinary.fluid.ModFluids;

public class CreateCulinaryClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.CHOCOLATE_MILK_STILL, new SimpleFluidRenderHandler(
                SimpleFluidRenderHandler.WATER_STILL, SimpleFluidRenderHandler.WATER_FLOWING, SimpleFluidRenderHandler.WATER_OVERLAY, 0x873e23
        ));
        FluidRenderHandlerRegistry.INSTANCE.register(ModFluids.CHOCOLATE_MILK_FLOWING, new SimpleFluidRenderHandler(
                SimpleFluidRenderHandler.WATER_FLOWING, SimpleFluidRenderHandler.WATER_STILL, SimpleFluidRenderHandler.WATER_OVERLAY, 0x873e23
        ));
    }
}
