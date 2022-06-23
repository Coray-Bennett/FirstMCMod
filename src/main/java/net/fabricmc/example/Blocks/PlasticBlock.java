package net.fabricmc.example.Blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class PlasticBlock extends Block {



    public static final String PATH = "plastic_block";
    public static final Material MATERIAL = new Material(MapColor.BLACK, false, true, true,
                                                true, true, true, PistonBehavior.NORMAL);
    public static final float STRENGTH = 2.0f;

    public final static BooleanProperty MELTED = BooleanProperty.of("melted");
    public final static BooleanProperty NEAR_LAVA = BooleanProperty.of("near_lava");

    public PlasticBlock(Settings settings) {

        super(settings);
        this.setDefaultState( this.getDefaultState().with(MELTED, false));
        this.setDefaultState( this.getDefaultState().with(NEAR_LAVA, false));

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(MELTED, NEAR_LAVA);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {

        //thread, alive as long as the block is placed, checks if near lava, updates BlockState
        new Thread(
                () -> {
                //TODO: figure out if this will work
                }
        );


    }



}
