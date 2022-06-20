package net.fabricmc.example.Initialization;

import net.fabricmc.example.ArmorMaterial.Plastic;
import net.fabricmc.example.Items.PlasticBlock;
import net.fabricmc.example.Items.PlasticItem;
import net.fabricmc.example.Items.PlasticStripItem;
import net.fabricmc.example.Items.SunglassesItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
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

    public static void register() {

        //items
        Registry.register(Registry.ITEM, new Identifier("test", PlasticItem.PATH), PLASTIC_ITEM);
        Registry.register(Registry.ITEM, new Identifier("test", PlasticStripItem.PATH), PLASTIC_STRIP);
        Registry.register(Registry.ITEM, new Identifier("test", SunglassesItem.PATH), SUNGLASSES);

        //blocks + block items
        Registry.register(Registry.BLOCK, new Identifier("test", PlasticBlock.PATH), PLASTIC_BLOCK);
        Registry.register(Registry.ITEM, new Identifier("test", PlasticBlock.PATH),
                new BlockItem(PLASTIC_BLOCK, new FabricItemSettings().group(CreateGroups.PLASTICS_GROUP)));



    }

}
