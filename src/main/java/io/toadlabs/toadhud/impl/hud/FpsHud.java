package io.toadlabs.toadhud.impl.hud;

import io.toadlabs.toadhud.common.TextHud;
import io.toadlabs.toadhud.impl.mixin.MinecraftClientAccessor;
import net.minecraft.text.Text;

public class FpsHud extends TextHud {

	@Override
	protected Text getText() {
		return Text.of(MinecraftClientAccessor.getCurrentFps() + " FPS");
	}

}
