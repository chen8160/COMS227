package lab10;

import java.awt.Graphics;

/**
 * Cyclops look a lot like you and me, but they only have one eye.
 */
public class Portrait18YC extends Portrait {

	public Portrait18YC() {
		super(0.2);

		// Cyclops are all limb and no body.
		setBodyHeight(0.1);
		setArmSpan(0.5);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		int midX = getWidth() / 2;


		int eyeRadius = (int) (0.01 * SIZE);
		g.fillOval(midX - eyeRadius, headRadius - eyeRadius * 3, 3 * eyeRadius,
				2 * eyeRadius);


		int smileRadius = (int) (0.3 * headRadius);
		g.drawArc(midX - smileRadius, (int) (0.85 * headRadius),
				smileRadius * 2, smileRadius * 2, 0, -180);
	}
}