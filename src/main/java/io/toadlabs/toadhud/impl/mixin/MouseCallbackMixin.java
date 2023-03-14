package io.toadlabs.toadhud.impl.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import io.toadlabs.toadhud.impl.CpsListener;
import net.minecraft.client.Mouse;

@Mixin(Mouse.class)
public class MouseCallbackMixin {

	@Inject(method = "onMouseButton", at = @At("HEAD"))
	public void onMouseButton(long window, int button, int action, int modifiers, CallbackInfo callback) {
		CpsListener.onMouseButton(window, button, action, modifiers);
	}

}
