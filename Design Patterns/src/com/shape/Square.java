package com.shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Random;

import javax.swing.JComponent;

public class Square extends JComponent implements Figure{
	
	private int x = 50;
	private int y = 100;
	private SpeedStratergy speedStratergy;
	private int moveCount = 0;
	private boolean winner;
	
	public Square(SpeedStratergy speedStratergy) {
	  this.speedStratergy = speedStratergy;
  }
	
	@Override
	public Dimension getPreferredSize() {
		int width = 50;
		int height = 50;
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
		g.fillRect(0, 0, 50, 50);
		if(moveCount%2 == 0) {
		  g.setColor(Color.WHITE);
		} else {
		  g.setColor(Color.BLACK);
		}
		g.fillOval(15, 20, 8, 8);
		g.fillOval(35, 20, 8 , 8);
	}

	@Override
	public void move() {
		x+= speedStratergy.getStepDistance();
		moveCount++;
		System.out.println(" Square distance travelled ="+this.x);
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
    return "Square";
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
