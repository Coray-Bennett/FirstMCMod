package net.fabricmc.example.Fluids;

import net.fabricmc.example.Initialization.RegisterItems;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.Properties;

public abstract class MoltenPlastic extends CustomFluid {

    public static final String PATH_STILL = "molten_plastic";
    public static final String PATH_FLOWING = "flowing_molten_plastic";
    public static final String PATH_BUCKET = "molten_plastic_bucket";
    public static final String PATH_BLOCK = PATH_STILL;

    @Override
    public Fluid getFlowing() {
        return RegisterItems.FLOWING_MOLTEN_PLASTIC;
    }

    @Override
    public Fluid getStill() {
        return RegisterItems.STILL_MOLTEN_PLASTIC;
    }

    @Override
    public Item getBucketItem() {
        return RegisterItems.MOLTEN_PLASTIC_BUCKET;
    }

    @Override
    protected BlockState toBlockState(FluidState state) {
        return RegisterItems.MOLTEN_PLASTIC_BLOCK.getDefaultState().with(Properties.LEVEL_15, getBlockStateLevel(state));
    }

    public static class Still extends MoltenPlastic {

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }

        @Override
        public int getLevel(FluidState state) {
            return 8;
        }
    }

    public static class Flowing extends MoltenPlastic {

        @Override
        protected void appendProperties(StateManager.Builder<Fluid, FluidState> builder) {
            super.appendProperties(builder);
            builder.add(LEVEL);
        }

        @Override
        public boolean isStill(FluidState state) {
            return false;
        }

        @Override
        public int getLevel(FluidState state) {
            return state.get(LEVEL);
        }
    }

}
