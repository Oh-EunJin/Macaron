package report;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import report.main.BackPan;

public class GamePaper extends JPanel implements Runnable, KeyListener {
	
   public static final int P_H = 220;
   public static final int P_W = 100;

   public static final int M_H[] = {30, 30, 30, 50};
   public static final int M_W[] = {30, 30, 30, 50};
   
   Vector<CPoint> v =new Vector<CPoint>();
   Vector<CPoint> v2 =new Vector<CPoint>();
   Vector<CPoint> v3 =new Vector<CPoint>();
   Vector<CPoint> v4 =new Vector<CPoint>();
   
   int x=200, y=460;
   static int intscore = 0;
   
   static class ng {
	   static boolean nowGaming = true;
   }
   static class user_jumsu1 {
	   static int user_jumsu = intscore;
   }
   
   JLabel time = new JLabel("1 : 00");
   JLabel score = new JLabel("SCORE");
   JLabel jumsu = new JLabel("0");
   JLabel prince = new JLabel(new ImageIcon("img/prince.png"));
   
   
   public GamePaper() {
      setLayout(null);
      for(int i=0; i<2; i++){
            int x=(int)(Math.random()*600);
            int y=(int)(Math.random()*700);
            v.add(new CPoint(x,y));
        }
        for(int i=0; i<2; i++){
            int x=(int)(Math.random()*600);
            int y=(int)(Math.random()*700);
            v2.add(new CPoint(x,y));
        }
        for(int i=0; i<2; i++){
            int x=(int)(Math.random()*600);
            int y=(int)(Math.random()*700);
            v3.add(new CPoint(x,y));
        }
        for(int i=0; i<3; i++){
            int x=(int)(Math.random()*600);
            int y=(int)(Math.random()*700);
            v4.add(new CPoint(x,y));
        }
      time.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
      time.setForeground(Color.WHITE);
      add(time);
      score.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
      score.setForeground(Color.WHITE);
      add(score);
      jumsu.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
      jumsu.setForeground(Color.WHITE);
      add(jumsu);
      add(prince);
      
      prince.setBounds(x, y, 100, 220);
      time.setBounds(580, 5, 100, 50);
      score.setBounds(5, 5, 200, 50);
      jumsu.setBounds(30, 40, 200, 50);
      
      Game_TImer timerTh = new Game_TImer(time);
      timerTh.start();
      
   }   
    public void paintComponent(Graphics g){
         super.paintComponent(g);
         ImageIcon icon=new ImageIcon("img/g_background.jpg");
         Image img=icon.getImage();
         g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);   //배경
         g.setColor(Color.WHITE);
         for(int i=0; i<v.size(); i++){
             CPoint p=v.get(i);
             g.drawImage(Toolkit.getDefaultToolkit().getImage("img/deco_macaron1.png"),(int)p.getX(), (int)p.getY(), 30, 30, this); 
         }
         for(int i=0; i<v2.size(); i++){
             CPoint p2=v2.get(i);
             g.drawImage(Toolkit.getDefaultToolkit().getImage("img/deco_macaron2.png"),(int)p2.getX(), (int)p2.getY(), 30, 30, this);
         }
         for(int i=0; i<v3.size(); i++){
             CPoint p3=v3.get(i);
             g.drawImage(Toolkit.getDefaultToolkit().getImage("img/macaron1.png"),(int)p3.getX(), (int)p3.getY(), 30, 30, this);
         }
         for(int i=0; i<v4.size(); i++){
             CPoint p4=v4.get(i);
             g.drawImage(Toolkit.getDefaultToolkit().getImage("img/b_macaron.png"),(int)p4.getX(), (int)p4.getY(), 50, 50, this);
             
         }
     }
   
    public void changeMacaPoaition(){
         for(int i=0; i<v.size(); i++){
             CPoint p=v.get(i);
             p.x+=0;
             p.y+=10;
             if(p.y>700) {
                if(p.x > 1 && p.x < 600) {
                     p.x=(int)(Math.random()*600);
                }
                p.y=0;
                p.isGet = false;
             }
             v.set(i, p);
         }
         
         for(int i=0; i<v2.size(); i++){
             CPoint p2=v2.get(i);
             p2.x+=0;
             p2.y+=10;
             if(p2.y>700) {
                if(p2.x > 1 && p2.x < 600) {
                     p2.x=(int)(Math.random()*600);
                }
                p2.y=0;
                p2.isGet = false;
             }
             v2.set(i, p2);
         }
         for(int i=0; i<v3.size(); i++){
             CPoint p3=v3.get(i);
             p3.x+=0;
             p3.y+=10;
             if(p3.y>700) {
                if(p3.x > 1 && p3.x < 600) {
                     p3.x=(int)(Math.random()*600);
                }
                p3.y=0;
                p3.isGet = false;
             }
             v3.set(i, p3);
         }
         for(int i=0; i<v4.size(); i++){
             CPoint p4=v4.get(i);
             p4.x+=0;
             p4.y+=10;
             if(p4.y>700) {
                if(p4.x > 1 && p4.x < 600) {
                     p4.x=(int)(Math.random()*600);
                }
                p4.y=0;
                p4.isGet = false;
             }
             v4.set(i, p4);
         }
     }
   
   @Override
   public void keyPressed(KeyEvent e) {
      switch(e.getKeyCode()) {
      case KeyEvent.VK_RIGHT:
         if(prince.getX() <= 580) {
            prince.setLocation(prince.getX() + 10, prince.getY());
         }
         break;
      case KeyEvent.VK_LEFT:
         if(prince.getX() >= 0) { 
            prince.setLocation(prince.getX() - 10, prince.getY());
         }
         break;
      }
   }

   @Override
   public void keyReleased(KeyEvent arg0) {
      // TODO Auto-generated method stub

   }

   @Override
   public void keyTyped(KeyEvent arg0) {
      // TODO Auto-generated method stub

   }
   
   public int isCollapse() {
      
      int getScore = 0;
      
      int dirX[] = {0, 1, 0, 1};
      int dirY[] = {0, 0, 1, 1};
      
      Object[] m = {v, v2, v3, v4};   // Vector 객체로 받아옴
      
      for(int n=0; n<m.length; n++) {
         
         Vector<CPoint> tmp = (Vector<CPoint>)m[n];    // Vector 형변환
         
         for(int i=0; i<tmp.size(); i++) {
            
            // 마카롱 왼쪽 위 좌표
            int mX1 = tmp.get(i).x;
            int mY1 = tmp.get(i).y;
            // 마카롱 오른쪽 아래 좌표
            int mX2 = tmp.get(i).x + M_W[n];
            int mY2 = tmp.get(i).y + M_H[n];
            // 왕자 왼쪽 위 좌표
            int px1 = prince.getX() + dirX[0] * P_W;
            int py1 = prince.getY() + dirY[0] * P_H;
            // 왕자 오른쪽 아래 좌표
            int px2 = prince.getX() + dirX[3] * P_W;
            int py2 = prince.getY() + dirY[3] * P_H;
            
            // 왕자 안에 마카롱이 들어왔는지 판단
            if (px1 <= mX1 && mX2 <= px2 && py1 <= mY1 && mY2 <= py2 && !tmp.get(i).isGet) {

               switch (n) {
               
               case 0 :
                  getScore += 10;
                  break;

               case 1 :
                  getScore += 20;
                  break;

               case 2 :
                  getScore += 20;
                  break;

               case 3 :
                  getScore -= 20;
                  break;
               
               }
               ((Vector<CPoint>)m[n]).get(i).isGet = true;
               continue;
            }

            for(int j=0; j<4; j++) {
               int px = prince.getX() + dirX[j] * P_W;
               int py = prince.getY() + dirY[j] * P_H;
               
               // 왕자의 각 꼭짓점에 마카롱이 충돌했는지 판단
               if (mX1 <= px && px <= mX2 && mY1 <= py && py <= mY2 && !tmp.get(i).isGet) {
                  
                  switch (n) {
                  
                  case 0 :
                     getScore += 10;
                     break;

                  case 1 :
                     getScore += 20;
                     break;

                  case 2 :
                     getScore += 20;
                     break;

                  case 3 :
                     getScore -= 20;
                     break;
                  
                  }
                  
                  ((Vector<CPoint>)m[n]).get(i).isGet = true;
                  break;
               }
            }
         }
      }
      return getScore;
   }
   
   @Override
    public void run(){
      
         while(ng.nowGaming){
             try{
                 Thread.sleep(50);
             }
             catch(Exception e){}
             
             changeMacaPoaition();
             repaint();

             intscore += isCollapse();
             if(intscore<=0)
            	 intscore=0;
             jumsu.setText(intscore + "");
         }
     }
   
   public class CPoint{
      int x, y;
      public boolean isGet;
      
      public CPoint(int a, int b) {
         x = a;
         y = b;
         isGet = false;
      }
      
      public int getX() {
         return x;
      }
      public int getY() {
         return y;
      }
   }
}
