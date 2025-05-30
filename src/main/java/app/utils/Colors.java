package app.utils;

import java.awt.Color;

public enum Colors {
	ZINC(
		new Color(0xfafafa),
		new Color(0xf4f4f5),
		new Color(0xe4e4e7),
		new Color(0xd4d4d8),
		new Color(0xa1a1aa),
		new Color(0x71717a),
		new Color(0x52525b),
		new Color(0x3f3f46),
		new Color(0x27272a),
		new Color(0x18181b),
		new Color(0x09090b)
	),
	
	RED(
		new Color(0xfef2f2),
		new Color(0xfee2e2),
		new Color(0xfecaca),
		new Color(0xfca5a5),
		new Color(0xf87171),
		new Color(0xef4444),
		new Color(0xdc2626),
		new Color(0xb91c1c),
		new Color(0x991b1b),
		new Color(0x7f1d1d),
		new Color(0x450a0a)
	);
	
	private final Color[] colorShades;

	Colors(Color... shades) {
		if (shades.length != 11) {
			throw new IllegalArgumentException("Colors enum requires exactly 11 shades.");
		}
		this.colorShades = shades;
	}

	public Color getShade(int index) {
		if (index < 0 || index >= colorShades.length) {
			throw new IndexOutOfBoundsException("Shade index out of range: " + index);
		}
		return colorShades[index];
	}
}
