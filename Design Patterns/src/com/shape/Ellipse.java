package com.shape;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JComponent;

public class Ellipse extends JComponent implements Figure{

  private int x = 50;
  private int y = 550;
  private SpeedStratergy speedStratergy;
  private int moveCount = 0;
  private boolean winner;
  
  public Ellipse(SpeedStratergy speedStratergy) {
    this.speedStratergy = speedStratergy;
  }
  
  public Dimension getPreferredSize() {
    int width = 50;
    int height = 50;
    return new Dimension(width, height);
  }
  
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    if(winner) {
      g.setColor(Color.RED);
    } else {
      g.setColor(Color.GREEN);
    }
    g.fillOval(0, 0, 30, 50);
    if (moveCount%2 == 1) {
     g.setColor(Color.WHITE);
     g.drawLine(0, 25, 30, 25);
     g.drawLine(15, 0, 15, 50);
    } else {
     g.setColor(Color.WHITE);
     g.drawLine(0, 0, 30, 50);
     g.drawLine(0, 50, 30, 0);
    }
  }

  @Override
  public void move() {
    x+= speedStratergy.getStepDistance();
    moveCount++;
    System.out.println(" Ellipse distance travelled ="+this.x);
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
    return "Ellipse";
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
