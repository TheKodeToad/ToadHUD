package io.toadlabs.toadhud.common;

import org.quiltmc.config.api.Config.Builder;
import org.quiltmc.config.api.values.TrackedValue;

import io.toadlabs.toadhud.base.HudElement;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.util.math.MatrixStack;

public abstract class BackgroundHud extends HudElement {

	private final TrackedValue<Integer> bg = bg();

	@Override
	protected void render(MatrixStack matrices, int x, int y, int width, int height) {
		DrawableHelper.fill(matrices, x, y, width, height, bg.value());
	}

	@Override
	protected void createConfig(Builder builder) {
		super.createConfig(builder);
		builder.field(bg);
	}

}
