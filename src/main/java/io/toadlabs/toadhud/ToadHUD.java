package io.toadlabs.toadhud;

import io.toadlabs.toadhud.base.HudElement;
import io.toadlabs.toadhud.internal.ToadHUDMod;

public final class ToadHUD {

	public static void addElement(HudElement element) {
		ToadHUDMod.instance.addElement(element);
	}

}
