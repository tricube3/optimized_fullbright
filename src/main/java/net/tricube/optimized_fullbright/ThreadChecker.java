package net.tricube.optimized_fullbright;


import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.tricube.optimized_fullbright.config.Config;

public class ThreadChecker {
	public static boolean distantHorizon = false;
    public static boolean scalableLux = false;
    public static boolean isClient() {
        Minecraft mc = Minecraft.getInstance();
        MinecraftServer server = mc.getSingleplayerServer();
        if (server == null) return true;
        return !server.isSameThread() && mc.isSameThread();
    }
	public static boolean checkDistantHorizons() {
		return distantHorizon;
	}
	public static void hasDistantHorizons(){
		distantHorizon = true;
	}
    public static boolean checkScalableLux() {
        return scalableLux;
    }
    public static void hasScalableLux(){
        scalableLux = true;
    }
	public static boolean shouldCancel(){
		return Config.enableFullbright.get() && ThreadChecker.isClient();
	}
}
