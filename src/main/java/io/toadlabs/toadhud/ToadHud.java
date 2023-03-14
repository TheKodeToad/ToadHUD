package io.toadlabs.toadhud;

import io.toadlabs.toadhud.base.HudElement;
import io.toadlabs.toadhud.impl.ToadHudMod;

public final class ToadHud {

	public static void addElement(HudElement element) {
		ToadHudMod.instance.addElement(element);
	}

}
