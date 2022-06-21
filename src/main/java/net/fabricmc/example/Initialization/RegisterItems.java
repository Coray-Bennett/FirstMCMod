package net.fabricmc.example.Initialization;

import net.fabricmc.example.ArmorMaterial.Plastic;
import net.fabricmc.example.Blocks.PlasticBlock;
import net.fabricmc.example.Fluids.MoltenPlastic;
import net.fabricmc.example.Items.PlasticItem;
import net.fabricmc.example.Items.PlasticStripItem;
import net.fabricmc.example.Items.SunglassesItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FluidBlock;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.fluid.FlowableFluid;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {

    public static final ArmorMaterial PLASTIC = new Plastic();

    //items
    public static final Item PLASTIC_ITEM = new PlasticItem(new FabricItemSettings().group(CreateGroups.PLASTICS_GROUP));
    public static final Item PLASTIC_STRIP = new PlasticStripItem(new FabricItemSettings().group(CreateGroups.PLASTICS_GROUP));
    public static final Item SUNGLASSES = new SunglassesItem(PLASTIC, EquipmentSlot.HEAD, new FabricItemSettings().group(CreateGroups.PLASTICS_GROUP));

    //blocks
    public static final Block PLASTIC_BLOCK = new Block(FabricBlockSettings.of(PlasticBlock.MATERIAL).strength(PlasticBlock.STRENGTH));

    //fluids
    public static final FlowableFluid STILL_MOLTEN_PLASTIC = new MoltenPlastic.Still();
    public static final FlowableFluid FLOWING_MOLTEN_PLASTIC = new MoltenPlastic.Flowing();
    public static final Item MOLTEN_PLASTIC_BUCKET = new BucketItem(STILL_MOLTEN_PLASTIC,
            new Item.Settings().recipeRemainder(Items.BUCKET).maxCount(1).group(CreateGroups.PLASTICS_GROUP));
    public static final Block MOLTEN_PLASTIC_BLOCK = new FluidBlock(STILL_MOLTEN_PLASTIC, FabricBlockSettings.copy(Blocks.LAVA));

    public static void register() {

        //items
        Registry.register(Registry.ITEM, new Identifier("test", PlasticItem.PATH), PLASTIC_ITEM);
        Registry.register(Registry.ITEM, new Identifier("test", PlasticStripItem.PATH), PLASTIC_STRIP);
        Registry.register(Registry.ITEM, new Identifier("test", SunglassesItem.PATH), SUNGLASSES);
        Registry.register(Registry.ITEM, new Identifier("test", MoltenPlastic.PATH_BUCKET), MOLTEN_PLASTIC_BUCKET);

        //blocks + block items
        Registry.register(Registry.BLOCK, new Identifier("test", PlasticBlock.PATH), PLASTIC_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("test", PlasticBlock.PATH),
                new BlockItem(PLASTIC_BLOCK, new FabricItemSettings().group(CreateGroups.PLASTICS_GROUP)));
        Registry.register(Registry.BLOCK, new Identifier("test", MoltenPlastic.PATH_BLOCK), MOLTEN_PLASTIC_BLOCK);

        //fluids
        Registry.register(Registry.FLUID, new Identifier("test", MoltenPlastic.PATH_STILL), STILL_MOLTEN_PLASTIC);
        Registry.register(Registry.FLUID, new Identifier("test", MoltenPlastic.PATH_FLOWING), FLOWING_MOLTEN_PLASTIC);



    }

}
