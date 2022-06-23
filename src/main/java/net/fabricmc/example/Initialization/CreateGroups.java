package net.fabricmc.example.Initialization;

import net.fabricmc.example.ExampleMod;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;

public class CreateGroups {

    public static final ItemGroup PLASTICS_GROUP = FabricItemGroupBuilder.build(
            new Identifier(ExampleMod.MOD_ID, "plastics"),
            () -> new ItemStack(RegisterItems.PLASTIC_ITEM)
    );

}
