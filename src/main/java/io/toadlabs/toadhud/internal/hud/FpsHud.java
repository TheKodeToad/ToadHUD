package io.toadlabs.toadhud.internal.hud;

import io.toadlabs.toadhud.common.TextHud;
import io.toadlabs.toadhud.internal.ToadHudMod;
import io.toadlabs.toadhud.internal.mixin.MinecraftClientAccessor;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public final class FpsHud extends TextHud {

	@Override
	protected Text getText() {
		return Text.of(MinecraftClientAccessor.getCurrentFps() + " FPS");
	}

	@Override
	public Identifier getId() {
		return ToadHudMod.id("cps");
	}

}
