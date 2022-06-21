package net.fabricmc.example;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.example.Initialization.RegisterItems;
import net.fabricmc.fabric.api.client.render.fluid.v1.FluidRenderHandlerRegistry;
import net.fabricmc.fabric.api.client.render.fluid.v1.SimpleFluidRenderHandler;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientInitializer implements ClientModInitializer {

    public static final Logger LOGGER = LoggerFactory.getLogger("test_client");

    @Override
    public void onInitializeClient() {

        LOGGER.info("before");

        FluidRenderHandlerRegistry.INSTANCE.register(RegisterItems.STILL_MOLTEN_PLASTIC, RegisterItems.FLOWING_MOLTEN_PLASTIC,
                new SimpleFluidRenderHandler(
                        SimpleFluidRenderHandler.LAVA_STILL,
                        SimpleFluidRenderHandler.LAVA_FLOWING,
                        0xffea00
                ));

        LOGGER.info("after");

        //BlockRenderLayerMap.INSTANCE.putFluids(RenderLayer.getTranslucent(), RegisterItems.STILL_MOLTEN_PLASTIC, RegisterItems.FLOWING_MOLTEN_PLASTIC);
    }

}
