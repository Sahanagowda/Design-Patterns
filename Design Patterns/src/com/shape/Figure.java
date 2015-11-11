package com.shape;


public interface Figure {

  /**
   * Moves the figure randomly.
   */
	public void move();
	
	/**
	 * Returns the distance traversed.
	 * @return
	 */
	public int getDistance();
	
	/**
	 * Sets figure as winner.
	 */
	public void setWinner();
	
	public void setDistance(int x);
	
	public void setStratergy(SpeedStratergy speedStratergy);
}
