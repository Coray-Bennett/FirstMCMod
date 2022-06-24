package net.fabricmc.example.Initialization;

import net.fabricmc.example.ExampleMod;
import net.fabricmc.example.Fluids.MoltenPlastic;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.BucketItem;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterFluids {

    //fluids
    public static final FlowableFluid STILL_MOLTEN_PLASTIC = new MoltenPlastic.Still();
    public static final FlowableFluid FLOWING_MOLTEN_PLASTIC = new MoltenPlastic.Flowing();

    //fluid blocks
    public static final Block MOLTEN_PLASTIC_BLOCK = new FluidBlock(STILL_MOLTEN_PLASTIC, FabricBlockSettings.copy(Blocks.LAVA));

    //bucket items
    public static final Item MOLTEN_PLASTIC_BUCKET = new BucketItem(STILL_MOLTEN_PLASTIC,
            new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(CreateGroups.PLASTICS_GROUP));


    public static void register() {

        //fluids
        Registry.register(Registry.FLUID, new Identifier(ExampleMod.MOD_ID, MoltenPlastic.PATH_STILL), STILL_MOLTEN_PLASTIC);
        Registry.register(Registry.FLUID, new Identifier(ExampleMod.MOD_ID, MoltenPlastic.PATH_FLOWING), FLOWING_MOLTEN_PLASTIC);

        //fluid blocks
        Registry.register(Registry.BLOCK, new Identifier(ExampleMod.MOD_ID, MoltenPlastic.PATH_BLOCK), MOLTEN_PLASTIC_BLOCK);

        //bucket items
        Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, MoltenPlastic.PATH_BUCKET), MOLTEN_PLASTIC_BUCKET);

    }
}
