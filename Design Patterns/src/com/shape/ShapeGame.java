package com.shape;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ShapeGame extends JPanel {

  private static final long serialVersionUID = 1L;

  public static void main(String[] args) {
		JFrame jFrame = new JFrame();
		final ArrayList<Figure> figureList = new ArrayList<Figure>();
		final SpeedStratergy fastSpeedStratergy = new FastSpeedStratergy();
		final SpeedStratergy slowSpeedStratergy = new SlowSpeedStratergy();
		figureList.add(createSquare(jFrame,fastSpeedStratergy));
		figureList.add(createCircle(jFrame,fastSpeedStratergy));
		figureList.add(createTriangle(jFrame,fastSpeedStratergy));
		figureList.add(createEllipse(jFrame,fastSpeedStratergy));
		
		jFrame.setLayout(null);
		jFrame.setSize(1200, 900);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Thread(new Runnable() {
			  public void run() {
			    try {
			    	boolean finishFlag = false;
			    	int i = 0;
			    	while(!finishFlag) {
			    		i++;
			    		Thread.sleep(30);
				        for(Figure figure:figureList) {
				        	if (i < 100) { 
				        		figure.setStratergy(fastSpeedStratergy);
				        	} else {
				        		figure.setStratergy(slowSpeedStratergy);
				        	}
				        	if(figure.getDistance() >= 1100) {
				        		finishFlag = true;
				        		break;
				        	}
				        	else {
				        		figure.move();
				        		continue;
				        	}
				        }
			    	}
			    	
			    	int currMax = 0;
			    	Figure currMaxFigure = null;
			    	for(Figure figure: figureList) {
			    	  if(figure.getDistance() > currMax) {
			    	    currMax = figure.getDistance();
			    	    currMaxFigure = figure;
			    	  }
			    	}
			    	currMaxFigure.setWinner();
			    	System.out.println(currMaxFigure.toString() + " is winner.");
			    }
			    catch(InterruptedException ex) {
			      ex.printStackTrace();
			    }
			  }
			}).start();
		jFrame.setVisible(true);
		
	}
	
	public static Square createSquare(JFrame jFrame, SpeedStratergy speedStratergy) {
		Square square = new Square(speedStratergy);
		jFrame.add(square);
		return square;
	}
	
	public static Circle createCircle(JFrame jFrame, SpeedStratergy speedStratergy) {
		Circle circle = new Circle(speedStratergy);
		jFrame.add(circle);
		return circle;
	}
	
	public static Triangle createTriangle(JFrame jFrame, SpeedStratergy speedStratergy) {
		Triangle triangle = new Triangle(speedStratergy);
		jFrame.add(triangle);
		return triangle;
	}
	
	public static Ellipse createEllipse(JFrame jFrame, SpeedStratergy speedStratergy) {
	  Ellipse ellipse = new Ellipse(speedStratergy);
	  jFrame.add(ellipse);
	  return ellipse;
	}
	
}
