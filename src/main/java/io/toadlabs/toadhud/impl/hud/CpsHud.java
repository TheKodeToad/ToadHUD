package io.toadlabs.toadhud.impl.hud;

import io.toadlabs.toadhud.common.TextHud;
import io.toadlabs.toadhud.impl.CpsListener;
import net.minecraft.text.Text;

public final class CpsHud extends TextHud {

	@Override
	protected Text getText() {
		return Text.of(CpsListener.left() + " cps");
	}

}
