package report;

import javax.swing.JFrame;

public class GameFrame extends JFrame {

   public GameFrame() {
      GamePaper paper = new GamePaper();
      add(paper);
      setTitle("Macaron, How much?");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setBounds(400,70,700,700);
      setVisible(true);      
      addKeyListener(paper);
      Thread th = new Thread(paper);
      th.start();
      Thread snow = new Thread(paper);
       snow.start();
   }
   
   public static void main(String[] args) {
      new GameFrame();
   }

}