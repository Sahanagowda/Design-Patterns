package com.shape;

public interface SpeedStratergy {

	static final RandomGenerator RANDOM_GENERATOR = new RandomGenerator(5);
	
	public int getStepDistance();
}
