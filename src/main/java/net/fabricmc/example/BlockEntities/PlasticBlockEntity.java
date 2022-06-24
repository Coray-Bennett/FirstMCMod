package net.fabricmc.example.BlockEntities;

import net.fabricmc.example.Blocks.PlasticBlock;
import net.fabricmc.example.ExampleMod;
import net.fabricmc.example.Helper.BlockHelper;
import net.fabricmc.example.Initialization.RegisterBlockEntities;
import net.fabricmc.example.Initialization.RegisterFluids;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Timer;
import java.util.TimerTask;

public class PlasticBlockEntity extends BlockEntity {

    public PlasticBlockEntity(BlockPos pos, BlockState state) {
        super(RegisterBlockEntities.PLASTIC_BLOCK_ENTITY, pos, state);
    }

    public static void tick(World world, BlockPos pos, BlockState state, PlasticBlockEntity entity) {

        ExampleMod.LOGGER.info("test");

        //if(!world.isClient()) {

            //is adjacent to lava
            if(BlockHelper.isDirectlyAdjacent(Blocks.LAVA, pos, world) ) {
                if(!state.get(PlasticBlock.NEAR_LAVA)) { world.setBlockState(pos, state.with(PlasticBlock.NEAR_LAVA, true)); }

                ExampleMod.LOGGER.info("lava detected");

            }
            //is not adjacent to lava
            else {
                if(state.get(PlasticBlock.NEAR_LAVA)) { world.setBlockState(pos, state.with(PlasticBlock.NEAR_LAVA, false)); }
            }

            if(state.get(PlasticBlock.NEAR_LAVA)) {

                world.setBlockState(pos, RegisterFluids.MOLTEN_PLASTIC_BLOCK.getDefaultState());

            }

        //}



    }

}
