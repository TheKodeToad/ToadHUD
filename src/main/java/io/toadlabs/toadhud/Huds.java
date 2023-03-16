package io.toadlabs.toadhud;

import org.quiltmc.loader.api.ModInternal;

import io.toadlabs.toadhud.internal.hud.CpsHud;
import io.toadlabs.toadhud.internal.hud.FpsHud;

public final class Huds {

	public static final FpsHud FPS = new FpsHud();
	public static final CpsHud CPS = new CpsHud();

	@ModInternal
	public static void register() {
		ToadHud.addElement(FPS);
		ToadHud.addElement(CPS);
	}

}
