package com.shape;

public class FastSpeedStratergy implements SpeedStratergy {

	@Override
	public int getStepDistance() {
		return (RANDOM_GENERATOR.nextInt()*2);
	}
}
