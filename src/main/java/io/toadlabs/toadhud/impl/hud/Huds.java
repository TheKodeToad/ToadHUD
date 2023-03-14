package io.toadlabs.toadhud.impl.hud;

import io.toadlabs.toadhud.ToadHud;

public final class Huds {

	public static final FpsHud FPS = new FpsHud();
	public static final CpsHud CPS = new CpsHud();

	public static void register() {
		ToadHud.addElement(FPS);
		ToadHud.addElement(CPS);
		FPS.setEnabled(true);
	}

}
