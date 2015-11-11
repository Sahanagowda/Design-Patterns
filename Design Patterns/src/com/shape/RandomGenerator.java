package com.shape;

import java.util.Random;

public class RandomGenerator {

  private Random random;
  private int max;
  
  public RandomGenerator(int max) {
    random = new Random(System.currentTimeMillis());
    this.max = max;
  }
  
	public int nextInt() {
	  return random.nextInt(max) + 1;
	}
}
