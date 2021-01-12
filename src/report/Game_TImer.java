package report;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import report.GamePaper.ng;

public class Game_TImer extends Thread {
	JLabel time = new JLabel("1 : 00");
	int SLEEP_TIME = 1000;
	
	public Game_TImer(JLabel time) {
		
		this.time = time;
		
	}
	
	@Override
	public void run() {

		for(int j1 = 0; j1 >= -1; j1--) {
			for(int i1 = 60; i1>=0; i1--) {
				if( i1 >= 1 && i1 <= 9) {
					try {
						sleep(SLEEP_TIME);
					} catch (InterruptedException e) {
						
					}
					time.setText(j1 + " : 0" + i1);
				}
				else if(i1 == 60) {
					try {
						sleep(SLEEP_TIME);
					} catch (InterruptedException e) {
						
					}
				}
				else {
					try {
						sleep(SLEEP_TIME);
					} catch (InterruptedException e) {
						
					}
					time.setText(j1 + " : " + i1);
				}
				if(j1 == 0 && i1 == 0) {
					time.setText(j1 + " : 0" + i1);
					ng.nowGaming=false;
					int result = JOptionPane.showConfirmDialog(null, "Game Over!! \n Time is over.", "Macaron", JOptionPane.CLOSED_OPTION);
					if(result == JOptionPane.YES_OPTION) {
						new Ranking_name();
					}
					stop();
				}
				if(i1 == 0) {
					time.setText(j1 + " : 0" + i1);
					j1--;
					i1 = 60;
				}
			}
		}
		
	}	

}
