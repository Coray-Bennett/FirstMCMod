package net.fabricmc.example.Initialization;

import net.fabricmc.example.ArmorMaterial.Plastic;
import net.fabricmc.example.Blocks.PlasticBlock;
import net.fabricmc.example.ExampleMod;
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

    public static void register() {

        //standalone items
        Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, PlasticItem.PATH), PLASTIC_ITEM);
        Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, PlasticStripItem.PATH), PLASTIC_STRIP);
        Registry.register(Registry.ITEM, new Identifier(ExampleMod.MOD_ID, SunglassesItem.PATH), SUNGLASSES);


    }

}
