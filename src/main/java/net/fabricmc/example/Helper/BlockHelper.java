package net.fabricmc.example.Helper;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 * @author Coray Bennett
 * @version 1.0.0
 * helper functions to deal with various block-related woes
 *
 */
public class BlockHelper {

    /**
     *function to check all adjacent blocks for a specific block, includes corners and edges
     * @param testBlock : Block, the type of block you are testing for
     * @param pos : BlockPos, position of center block
     * @param world : World, the world the block you are checking is in
     * @return : boolean, true if an adjacent block is adjacent, false otherwise
     */
    public static boolean isAdjacent(Block testBlock, BlockPos pos, World world) {

        //loop over blocks
        for(int x = -1; x <= 1; x++) {
            for(int y = -1; y <= 1; y++) {
                for(int z = -1; z <= 1; z++) {

                    //skips checking center block
                    if((x == 0) && (y == 0) && (z == 0)) {
                        continue;
                    }

                    //position of adjacent block
                    BlockPos adj_pos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);

                    //adjacent block value
                    Block block = world.getBlockState(adj_pos).getBlock();

                    if(block == testBlock) {
                        return true;
                    }


                }
            }
        }

        return false;

    }

    /**
     * function that tests for an adjacent block, corners and edges NOT included (6 faces checked)
     * @param testBlock : Block, the type of block you are testing for
     * @param pos : BlockPos, position of center block
     * @param world : World, the world the block you are checking is in
     * @return : boolean, true if an adjacent block is adjacent, false otherwise
     */
    public static boolean isDirectlyAdjacent(Block testBlock, BlockPos pos, World world) {

        //array of block positions that align with the faces of the center block
        final BlockPos[] checkBlockPos = {
            new BlockPos(pos.getX(), pos.getY() - 1, pos.getZ()),
            new BlockPos(pos.getX(), pos.getY() + 1, pos.getZ()),
            new BlockPos(pos.getX() - 1, pos.getY(), pos.getZ()),
            new BlockPos(pos.getX() + 1, pos.getY(), pos.getZ()),
            new BlockPos(pos.getX(), pos.getY(), pos.getZ() - 1),
            new BlockPos(pos.getX(), pos.getY(), pos.getZ() + 1),
        };

        for(BlockPos adj_pos : checkBlockPos) {

            //adjacent block value
            Block block = world.getBlockState(adj_pos).getBlock();

            if(block == testBlock) {
                return true;
            }

        }

        return false;
    }

    /**
     * function that updates a 3D array of blocks to match the specified block
     * @param adj_blocks : Block[][][], contains values of adjacent blocks, [x][y][z]
     * @param pos : BlockPos, position of center block
     * @param world : World, the world the block you are checking is in
     */
    public static void updateAdjacentBlocks(Block[][][] adj_blocks, BlockPos pos, World world) {

        //check for valid array size
        if(adj_blocks.length != 27) {return;}

        //loop over blocks
        for(int x = -1; x <= 1; x++) {
            for(int y = -1; y <= 1; y++) {
                for(int z = -1; z <= 1; z++) {

                    //position of adjacent block
                    BlockPos adj_pos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);

                    //adjacent block value
                    Block block = world.getBlockState(adj_pos).getBlock();

                    //update  adj_blocks
                    adj_blocks[adj_pos.getX()][adj_pos.getY()][adj_pos.getZ()] = block;
                }
            }
        }


    }


}
