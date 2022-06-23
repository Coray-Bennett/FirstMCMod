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

    public static BooleanProperty MELTED = BooleanProperty.of("melted");

    //thread that will run once block is melting
    private final Thread melting;

    public PlasticBlock(Settings settings) {

        super(settings);
        this.setDefaultState( this.getDefaultState().with(MELTED, false));

        melting = new Thread(new Runnable() {

            int count = 0;
            final int MAX_COUNT = 10;
            @Override
            public void run() {

                //TODO: write this

            }
        });

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(MELTED);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack itemStack) {
        //TODO: write this, complete 'melted' thread first

    }



}
