package net.fabricmc.example.Items;

import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.block.piston.PistonBehavior;

public class PlasticBlock extends Block {

    public static final String PATH = "plastic_block";
    public static final Material MATERIAL = new Material(MapColor.BLACK, false, true, true,
                                                true, true, true, PistonBehavior.NORMAL);
    public static final float STRENGTH = 2.0f;

    public PlasticBlock(Settings settings) {
        super(settings);
    }

}
