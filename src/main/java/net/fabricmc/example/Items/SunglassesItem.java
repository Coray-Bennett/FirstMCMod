package net.fabricmc.example.Items;

import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;

public class SunglassesItem extends ArmorItem {

    public static final String PATH = "sunglasses";
    public SunglassesItem(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
    }



}
