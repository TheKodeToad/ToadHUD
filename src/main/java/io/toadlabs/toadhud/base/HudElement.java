package io.toadlabs.toadhud.base;

import static io.toadlabs.toadhud.Global.win;

import org.quiltmc.config.api.Config;
import org.quiltmc.config.api.Config.Creator;
import org.quiltmc.config.api.values.TrackedValue;

import net.minecraft.client.util.math.MatrixStack;

public abstract class HudElement {

	private final TrackedValue<Boolean> enabled = TrackedValue.create(false, "enabled");
	private final Position position = new Position();

	public void performRender(MatrixStack matrices) {
		int x = position.getX(win().getWidth());
		int y = position.getY(win().getHeight());
		int width = getWidth();
		int height = getHeight();

		// ignore gui scale - but avoid subpixels at all costs!
		matrices.translate(x / win().getScaleFactor(), y / win().getScaleFactor(), 0);
		render(matrices, x, y, width, height);
	}

	protected abstract void render(MatrixStack matrices, int x, int y, int width, int height);

	protected abstract int getWidth();

	protected abstract int getHeight();

	protected void createConfig(Config.Builder builder) {
		builder.field(enabled);
	}

	public final Creator getConfigCreator() {
		return this::createConfig;
	}

	public boolean isEnabled() {
		return enabled.value();
	}

	protected static TrackedValue<Colour> bg() {
		return TrackedValue.create(new Colour(0x64000000), "bg");
	}

	protected static TrackedValue<Colour> fg() {
		return TrackedValue.create(new Colour(0xFFFFFFFF), "fg");
	}

}
