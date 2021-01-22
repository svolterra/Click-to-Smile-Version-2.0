package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

// Class modeled based on:
// https://www.w3schools.com/java/java_files_read.asp
// https://www.baeldung.com/java-random-list-element#:~:text=In%20order%20to%20get%20a,that%20exceeds%20your%20List's%20size.
public class MyFrame extends JFrame {
    private MyPanel panel;
    private JLabel motivationLabel;
    private List<String> motivations = new ArrayList<>();

    // MyFrame constructor
    public MyFrame() {
        panel = new MyPanel();

        initMotivationLabel();

        initEncourageButton();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(panel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    //EFFECTS: initializes motivation label and adds it to frame
    private void initMotivationLabel() {
        motivationLabel = new JLabel("", SwingConstants.CENTER);
        motivationLabel.setBounds(0, -22, 640, 200);
        add(motivationLabel);
    }


    //EFFECTS: initializes button of encouragement and adds it to frame
    private void initEncourageButton() {
        ImageIcon icon = new ImageIcon(new ImageIcon("moonwalkingparrot.gif").getImage().getScaledInstance(40,40,Image.SCALE_DEFAULT));
        JButton encourageButton = new JButton("Click me!");
        encourageButton.setFont(new Font("Ink Free", Font.BOLD, 20));
        encourageButton.setBounds(220, 260, 200, 80);
        encourageButton.setIcon(icon);

        setEncourageButtonFunction(encourageButton);

        add(encourageButton);
    }

    //EFFECTS: sets the function of encouragement button
    private void setEncourageButtonFunction(JButton encourageButton) {
        encourageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String randomString = randomizeWordList();
                formatMotivationLabel(randomString);
            }
        });
    }

    //EFFECTS: sets the text, font, and colour of motivational text which appears after clicking the button
    private void formatMotivationLabel(String randomString) {
        motivationLabel.setText(randomString);
        motivationLabel.setFont(new Font("SansSerif", Font.ITALIC, 18));
        motivationLabel.setForeground(new Color(0, 0, 0));
    }


    //EFFECTS: returns a random string from class's list of strings
    private String randomizeWordList() {
        List<String> encouragements = readTextFile();
        Random rand = new Random();
        String randomString = encouragements.get(rand.nextInt(encouragements.size()));
        return randomString;
    }


    //EFFECTS: reads .txt file of encouraging sentences and adds them to class's list of strings
    public List<String> readTextFile() {
        try {
            File encouragementTxt = new File("encouraging-sentences.txt");
            Scanner myReader = new Scanner(encouragementTxt);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                motivations.add(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error has occurred.");
        }
        return motivations;
    }
}

