package net.tricube.optimized_fullbright.platform.fabric;

//? fabric {

import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;
import net.tricube.optimized_fullbright.ModInit;
import net.fabricmc.loader.api.FabricLoader;
import net.tricube.optimized_fullbright.ThreadChecker;import net.tricube.optimized_fullbright.config.Config;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		ModInit.onInitializeClient();
		if(FabricLoader.getInstance().isModLoaded("scalablelux")){
			ThreadChecker.hasScalableLux();
			ModInit.LOGGER.info("Found ScalableLux, enabling compatibility fix.");
		};
		if(FabricLoader.getInstance().isModLoaded("distanthorizons")){
			ThreadChecker.hasDistantHorizons();
			ModInit.LOGGER.info("Found Distant Horizons, disabling texture updates optimization.");
			if(Config.disableTextureUpdates.get()) Config.disableTextureUpdates.set(false);
		};
	}
}
//?}
