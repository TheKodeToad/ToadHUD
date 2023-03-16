package io.toadlabs.toadhud.internal.hud;

import io.toadlabs.toadhud.common.TextHud;
import io.toadlabs.toadhud.internal.CpsListener;
import io.toadlabs.toadhud.internal.ToadHudMod;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public final class CpsHud extends TextHud {

	@Override
	protected Text getText() {
		return Text.of(CpsListener.left() + " CPS");
	}

	@Override
	public Identifier getId() {
		return ToadHudMod.id("cps");
	}

}
