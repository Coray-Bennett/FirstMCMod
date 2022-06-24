package net.fabricmc.example.Blocks;

import net.fabricmc.example.BlockEntities.PlasticBlockEntity;
import net.fabricmc.example.Initialization.RegisterBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;



public class PlasticBlock extends BlockWithEntity implements BlockEntityProvider {

    public static final String PATH = "plastic_block";
    public static final Material MATERIAL = new Material(MapColor.BLACK, false, true, true,
                                                true, true, true, PistonBehavior.NORMAL);
    public static final float STRENGTH = 2.0f;

    public final static BooleanProperty NEAR_LAVA = BooleanProperty.of("near_lava");

    public PlasticBlock(Settings settings) {

        super(settings);
        this.setDefaultState( this.getDefaultState().with(NEAR_LAVA, false));

    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(NEAR_LAVA);
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new PlasticBlockEntity(pos, state);
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return checkType(type, RegisterBlockEntities.PLASTIC_BLOCK_ENTITY, PlasticBlockEntity::tick);
    }



}
