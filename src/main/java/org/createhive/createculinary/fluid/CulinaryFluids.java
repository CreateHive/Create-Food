package org.createhive.createculinary.fluid;

import static net.minecraft.item.Items.BUCKET;

import javax.annotation.Nullable;

import com.simibubi.create.AllFluids;
import com.simibubi.create.content.decoration.palettes.AllPaletteStoneTypes;
import com.simibubi.create.foundation.data.CreateRegistrate;
import com.simibubi.create.foundation.fluid.FluidHelper;
import com.simibubi.create.foundation.utility.Iterate;
import com.tterrag.registrate.fabric.SimpleFlowableFluid;
import com.tterrag.registrate.util.entry.FluidEntry;


import io.github.fabricators_of_create.porting_lib.event.common.FluidPlaceBlockCallback;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidConstants;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariant;
import net.fabricmc.fabric.api.transfer.v1.fluid.FluidVariantAttributeHandler;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.EmptyItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.fluid.base.FullItemFluidStorage;
import net.fabricmc.fabric.api.transfer.v1.item.ItemVariant;


public class CulinaryFluids {
    public static void setRegister() {
        FluidPlaceBlockCallback.EVENT.register(CulinaryFluids::whenFluidsMeet);
    }
    private static final CreateRegistrate REGISTRATE = CreateGarnished.registrate()
            .setCreativeTab(GarnishedTabs.GARNISHED.key());

    private static ResourceLocation createLocation(String fluid, boolean isFlowing) {
        String getMotion;

        if (isFlowing) {
            getMotion = "_flow";
        } else {
            getMotion = "_still";
        }

        return new ResourceLocation(CreateGarnished.ID, "fluid/" + fluid + getMotion);
    }

    public static final FluidEntry<SimpleFlowableFluid.Flowing> GARNISH;


    public static FluidEntry<SimpleFlowableFluid.Flowing> masticResinRegistration(String colour0) {
        return REGISTRATE
                .fluid((colour0 == "" ? colour0 : colour0 + "_") + "mastic_resin",
                        createLocation((colour0 == "" ? colour0 : colour0 + "_") + "mastic_resin", false),
                        createLocation((colour0 == "" ? colour0 : colour0 + "_") + "mastic_resin", true)
                )
                .fluidProperties(p -> p.levelDecreasePerBlock(2)
                        .tickRate(25)
                        .flowSpeed(3)
                        .blastResistance(100f))
                .fluidAttributes(() -> new CreateAdditionsAttributeHandler("fluid.garnished." + (colour0 == "" ? colour0 : colour0 + "_") + "mastic_resin", 1500, 1400))
                .onRegisterAfter(Registries.ITEM, fluid -> {
                    Fluid source = fluid.getSource();
                    FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                            new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                    FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                            new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));
                }).register();
    }

    static  {
        GARNISH = REGISTRATE
                .fluid("garnish",
                        createLocation("garnish", false),
                        createLocation("garnish", true)
                )
                .fluidProperties(p -> p.levelDecreasePerBlock(2)
                        .tickRate(25)
                        .flowSpeed(3)
                        .blastResistance(100f))
                .onRegisterAfter(Registries.ITEM, fluid -> {
                    Fluid source = fluid.getSource();
                    FluidStorage.combinedItemApiProvider(source.getBucket()).register(context ->
                            new FullItemFluidStorage(context, bucket -> ItemVariant.of(BUCKET), FluidVariant.of(source), FluidConstants.BUCKET));
                    FluidStorage.combinedItemApiProvider(BUCKET).register(context ->
                            new EmptyItemFluidStorage(context, bucket -> ItemVariant.of(source.getBucket()), source, FluidConstants.BUCKET));
                }).register();
    }

    public static BlockState whenFluidsMeet(LevelAccessor world, BlockPos pos, BlockState blockState) {
        FluidState fluidState = blockState.getFluidState();

        if (fluidState.isSource() && FluidHelper.isLava(fluidState.getType()))
            return null;

        for (Direction direction : Iterate.directions) {
            FluidState metFluidState =
                    fluidState.isSource() ? fluidState : world.getFluidState(pos.relative(direction));
            if (!metFluidState.is(FluidTags.WATER))
                continue;
            BlockState lavaInteraction = getLavaInteraction(metFluidState);
            if (lavaInteraction == null)
                continue;
            return lavaInteraction;
        }
        return null;
    }

    @Nullable
    public static BlockState getLavaInteraction(FluidState fluidState) {
        // Fluids.lavaInteraction(fluidState, GARNISH.get(), AllPaletteStoneTypes.CALCITE.getBaseBlock().get());
        if (fluidState.is(GARNISH.get()))
            return AllPaletteStoneTypes.CALCITE.getBaseBlock().get().defaultBlockState();

        return null;
    }
}
