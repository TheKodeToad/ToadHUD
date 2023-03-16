package io.toadlabs.toadhud.common;

import static io.toadlabs.toadhud.common.Global.mc;

import org.quiltmc.config.api.Config.Builder;
import org.quiltmc.config.api.Config.SectionBuilder;
import org.quiltmc.config.api.values.TrackedValue;

import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;

public abstract class TextHud extends BackgroundHud {

	private final TrackedValue<Integer> fg = fg();
	private final TrackedValue<Boolean> fgShadow = fgShadow();
	private final TrackedValue<Integer> padding = padding();

	@Override
	protected void render(MatrixStack matrices, int x, int y, int width, int height) {
		super.render(matrices, x, y, width, height);
		renderText(matrices, getText(), width / 2F - getTextRenderer().getWidth(getText()) / 2,
				height / 2F - getTextRenderer().fontHeight / 2);
	}

	@Override
	protected int getWidth() {
		return getTextRenderer().getWidth(getText()) + padding.value();
	}

	@Override
	protected int getHeight() {
		return getTextRenderer().fontHeight + padding.value();
	}

	@Override
	protected void createConfig(SectionBuilder builder) {
		super.createConfig(builder);
		builder.field(fg);
		builder.field(fgShadow);
		builder.field(padding);
	}

	protected abstract Text getText();

	protected TextRenderer getTextRenderer() {
		return mc().textRenderer;
	}

	protected int renderText(MatrixStack matrices, Text text, float x, float y) {
		return renderText(matrices, text, x, y, fg.value());
	}

	protected int renderText(MatrixStack matrices, Text text, float x, float y, int rgba) {
		if (fgShadow.value())
			return getTextRenderer().drawWithShadow(matrices, text, x, y, rgba);

		return getTextRenderer().draw(matrices, text, x, y, rgba);
	}

}
