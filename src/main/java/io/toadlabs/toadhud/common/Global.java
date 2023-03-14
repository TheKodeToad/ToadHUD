package io.toadlabs.toadhud.common;

import com.mojang.blaze3d.glfw.Window;

import net.minecraft.client.MinecraftClient;

public final class Global {

	public static MinecraftClient mc() {
		return MinecraftClient.getInstance();
	}

	public static Window win() {
		return mc().getWindow();
	}

}
