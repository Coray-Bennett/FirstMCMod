package net.fabricmc.example.Initialization;

import net.fabricmc.example.Blocks.PlasticBlock;
import net.fabricmc.example.ExampleMod;
import net.fabricmc.example.Fluids.MoltenPlastic;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterBlocks {

    //blocks
    public static final Block PLASTIC_BLOCK = new Block(FabricBlockSettings.of(PlasticBlock.MATERIAL).strength(PlasticBlock.STRENGTH));

    public static void register() {
        //blocks + block items
        Registry.register(Registry.BLOCK, new Identifier(ExampleMod.MOD_ID, PlasticBlock.PATH), PLASTIC_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, PlasticBlock.PATH),
                new BlockItem(PLASTIC_BLOCK, new FabricItemSettings().group(CreateGroups.PLASTICS_GROUP)));

    }

}
