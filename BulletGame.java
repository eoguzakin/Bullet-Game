/**
 * @(#)Frame.java
 *
 *
 * @author 
 * @version 1.00 2021/11/21
 */
import java.awt.*;
import javax.swing.*;
public class BulletGame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("galaxy");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.getContentPane().add(new GamePanel(800,600));
        frame.pack();
    }
}
