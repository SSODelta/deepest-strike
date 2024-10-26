package org.example;

import javax.swing.*;
import java.awt.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // Create a new JFrame
        JFrame frame = new JFrame("Deepest Strike");
        JPanel panel = new JPanel(){
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(image, 0, 0, null);
            }
        }

        // Set frame properties
        frame.setSize(800,
                600); // Set the size of the frame

        // Close operation
        frame.setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE);

        // Make the frame visible
        frame.setVisible(true);

    }
}