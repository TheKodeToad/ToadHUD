package io.toadlabs.toadhud.common;

import static io.toadlabs.toadhud.common.Global.mc;

import org.quiltmc.config.api.Config.Builder;
import org.quiltmc.config.api.values.TrackedValue;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public abstract class TextHud extends BackgroundHud {

	private final TrackedValue<Integer> fg = fg();
	private final TrackedValue<Boolean> fgShadow = fgShadow();

	@Override
	protected void render(MatrixStack matrices, int x, int y, int width, int height) {
		super.render(matrices, x, y, width, height);
		renderText(matrices, getText(), x, y);
	}

	@Override
	protected int getWidth() {
		return getTextRenderer().getWidth(getText());
	}

	@Override
	protected int getHeight() {
		return getTextRenderer().fontHeight;
	}

	@Override
	protected void createConfig(Builder builder) {
		super.createConfig(builder);
		builder.field(fg);
		builder.field(fgShadow);
	}

	protected abstract Text getText();

	protected TextRenderer getTextRenderer() {
		return mc().textRenderer;
	}

	protected int renderText(MatrixStack matrices, Text text, int x, int y) {
		return renderText(matrices, text, x, y, fg.value());
	}

	protected int renderText(MatrixStack matrices, Text text, int x, int y, int rgba) {
		if (fgShadow.value())
			return getTextRenderer().drawWithShadow(matrices, text, x, y, rgba);

		return getTextRenderer().draw(matrices, text, x, y, rgba);
	}

}
