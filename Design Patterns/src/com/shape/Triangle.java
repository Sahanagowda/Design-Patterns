package com.shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JComponent;

public class Triangle extends JComponent implements Figure {
	
	private int x = 50;
	private int y = 400;
	private SpeedStratergy speedStratergy;
	private int moveCount = 0;
	private boolean winner;
  
  public Triangle(SpeedStratergy speedStratergy) {
    this.speedStratergy = speedStratergy;
  }
	
	@Override
	public Dimension getPreferredSize() {
		int width = 100;
		int height = 100;
		return new Dimension(width, height);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		if(winner) {
      g.setColor(Color.RED);
    } else {
      g.setColor(Color.GREEN);
    }
		g.fillPolygon(new int[]{0, 0, 50}, new int[]{0, 50 , 50}, 3);
		if(moveCount%2 == 0) {
      g.setColor(Color.WHITE);
    } else {
      g.setColor(Color.BLACK);
    }
		g.fillArc(3, 30, 10, 10, 0, 180);
		g.fillArc(18, 30, 10, 10, 0, 180);
	}

	@Override
	public void move() {
		x+= speedStratergy.getStepDistance();
		moveCount++;
		System.out.println(" Triangle distance travelled ="+this.x);
		setBounds(x,y,100,100);
	}

	@Override
	public int getDistance() {
		return x;
	}
	
	@Override
  public void setWinner() {
    winner = true;
    repaint();
  }
	
  @Override
  public String toString() {
    return "Triangle";
  }

	@Override
	public void setDistance(int x) {
		this.x += x;
	}

	@Override
	public void setStratergy(SpeedStratergy speedStratergy) {
		this.speedStratergy = speedStratergy;
		
	}
}
