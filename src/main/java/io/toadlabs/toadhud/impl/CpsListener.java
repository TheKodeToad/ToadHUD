package io.toadlabs.toadhud.impl;

import static io.toadlabs.toadhud.common.Global.mc;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.glfw.GLFW;

public class CpsListener {

	private static final List<Long> LEFT = new ArrayList<>(10), RIGHT = new ArrayList<>(10);

	public static void onMouseButton(long window, int button, int action, int modifiers) {
		if (action != GLFW.GLFW_PRESS)
			return;
		if (mc().currentScreen == null)
			return;

		if (button == GLFW.GLFW_MOUSE_BUTTON_LEFT)
			LEFT.add(System.currentTimeMillis());
		else if (button == GLFW.GLFW_MOUSE_BUTTON_RIGHT)
			RIGHT.add(System.currentTimeMillis());
	}

	public static int left() {
		LEFT.removeIf(CpsListener::test);
		return LEFT.size();
	}

	public static int right() {
		RIGHT.removeIf(CpsListener::test);
		return RIGHT.size();
	}

	private static boolean test(long time) {
		return System.currentTimeMillis() - time > 1000;
	}

}
