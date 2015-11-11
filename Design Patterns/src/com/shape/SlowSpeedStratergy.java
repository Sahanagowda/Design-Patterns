package com.shape;

public class SlowSpeedStratergy implements SpeedStratergy {
	
	@Override
	public int getStepDistance() {
		return RANDOM_GENERATOR.nextInt();
	}

}
