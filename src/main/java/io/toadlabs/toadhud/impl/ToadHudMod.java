package io.toadlabs.toadhud.impl;

import java.util.ArrayList;
import java.util.List;

import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.toadlabs.toadhud.base.HudElement;
import io.toadlabs.toadhud.impl.hud.FpsHud;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public final class ToadHudMod implements ModInitializer {

	private static final Identifier PHASE = new Identifier("toadhud", "render");
	public static final Logger LOGGER = LoggerFactory.getLogger("ToadHud");
	public static ToadHudMod instance;

	private final List<HudElement> elements = new ArrayList<>();

	@Override
	public void onInitialize(ModContainer mod) {
		addElement(new FpsHud());
		HudRenderCallback.EVENT.register(PHASE, this::render);
		instance = this;
	}

	private void render(MatrixStack matrices, float tickDelta) {
		for (HudElement element : elements) {
			if (!element.isEnabled())
				continue;

			element.performRender(matrices);
		}
	}

	public void addElement(HudElement element) {
		elements.add(element);
	}

}
