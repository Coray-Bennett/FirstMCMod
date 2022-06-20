package net.fabricmc.example.Initialization;

import net.fabricmc.example.ArmorMaterial.Plastic;
import net.fabricmc.example.Items.PlasticItem;
import net.fabricmc.example.Items.PlasticStripItem;
import net.fabricmc.example.Items.SunglassesItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class RegisterItems {

    public static final ArmorMaterial PLASTIC = new Plastic();

    public static final Item PLASTIC_ITEM = new PlasticItem(new FabricItemSettings().group(CreateGroups.PLASTICS_GROUP));
    public static final Item PLASTIC_STRIP = new PlasticStripItem(new FabricItemSettings().group(CreateGroups.PLASTICS_GROUP));
    public static final Item SUNGLASSES = new SunglassesItem(PLASTIC, EquipmentSlot.HEAD, new FabricItemSettings().group(CreateGroups.PLASTICS_GROUP));

    public static void register() {

        Registry.register(Registry.ITEM, new Identifier("test", "plastic"), PLASTIC_ITEM);
        Registry.register(Registry.ITEM, new Identifier("test", "plastic_strip"), PLASTIC_STRIP);
        Registry.register(Registry.ITEM, new Identifier("test", "sunglasses"), SUNGLASSES);

    }

}
