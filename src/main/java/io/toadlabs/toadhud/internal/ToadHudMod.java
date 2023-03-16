package io.toadlabs.toadhud.internal;

import java.util.ArrayList;
import java.util.List;

import org.quiltmc.config.api.Config;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.loader.api.config.QuiltConfig;
import org.quiltmc.qsl.base.api.entrypoint.client.ClientModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.toadlabs.toadhud.Huds;
import io.toadlabs.toadhud.base.HudElement;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public final class ToadHudMod implements ClientModInitializer {

	private static final String ID = "toadhud";
	private static final Identifier PHASE = new Identifier(ID, "render");
	public static final Logger LOGGER = LoggerFactory.getLogger("ToadHUD");
	public static ToadHudMod instance;

	private final List<HudElement> elements = new ArrayList<>();
	private Config config;

	public static Identifier id(String id) {
		return new Identifier(ID, id);
	}

	@Override
	public void onInitializeClient(ModContainer mod) {
		instance = this;

		Huds.register();
		HudRenderCallback.EVENT.register(PHASE, this::render);

		config = QuiltConfig.create(ID, "root", config -> {
			for (HudElement element : elements)
				config.section(element.getId().toString(), element.getConfigCreator());
		});
		save();

		Huds.FPS.setEnabled(true);
	}

	public void save() {
		config.save();
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
