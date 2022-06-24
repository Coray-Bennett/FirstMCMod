package net.fabricmc.example.Initialization;

import net.fabricmc.example.BlockEntities.PlasticBlockEntity;
import net.fabricmc.example.ExampleMod;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.util.registry.Registry;

public class RegisterBlockEntities {

    public static BlockEntityType<PlasticBlockEntity> PLASTIC_BLOCK_ENTITY;

    public static void register() {

        Registry.register(Registry.BLOCK_ENTITY_TYPE, ExampleMod.MOD_ID + ":plastic_block_entity",
                FabricBlockEntityTypeBuilder.create(PlasticBlockEntity::new , RegisterBlocks.PLASTIC_BLOCK).build(null));
    }

}
