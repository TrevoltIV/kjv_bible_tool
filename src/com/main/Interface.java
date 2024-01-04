package com.main;

import javax.swing.*;

import java.awt.*;
import java.awt.event.*;

public class Interface {
    private static JFrame frame;
    private static JPanel page1;
    private static JPanel page2;
    private static JPanel page3;
    private static JPanel page4;

    // Initialize UI
    public static void build() {
        frame = new JFrame("Trevolt's KJV Bible Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("res/icon.png");
        frame.setIconImage(icon.getImage());

        page1 = createPage("Browse");
        page2 = createPage("Random Verse");
        page3 = createPage("Word Occurrences");
        page4 = createPage("Phrase Occurrences");

        showPage(page1);

        frame.setSize(1280, 720);
        frame.setVisible(true);
    }

    // Return JPanel page for specified page name
    private static JPanel createPage(String pageName) {
        if (pageName == "Browse") {
            // Chapter Lookup
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));

            JLabel titleLabel = new JLabel("Browse");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(titleLabel, BorderLayout.NORTH);

            JTextField input = new JTextField(SwingConstants.CENTER);
            input.setPreferredSize(new Dimension(300, 25));
            panel.add(input, BorderLayout.CENTER);

            JButton searchBtn = new JButton("Search");
            panel.add(searchBtn);

            JTextArea resultTextArea = new JTextArea("");
            resultTextArea.setPreferredSize(new Dimension(1260, 600));
            resultTextArea.setEditable(false);
            resultTextArea.setFocusable(false);
            JScrollPane scrollPane = new JScrollPane(resultTextArea);
            panel.add(scrollPane, BorderLayout.CENTER);

            // Handle search button click
            searchBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String chapter = input.getText();

                    if (!chapter.isEmpty()) {
                        resultTextArea.setText(Search.specificChapter(chapter));
                    }
                }
            });

            input.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Do nothing
                }

                @Override
                public void focusLost(FocusEvent e) {
                    input.setFocusable(false);
                    input.setFocusable(true);
                }
            });

            return panel;
        } else if (pageName == "Word Occurrences") {
            // Word Occurrences
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));

            JLabel titleLabel = new JLabel("Word Occurrences");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(titleLabel, BorderLayout.NORTH);

            JTextField input = new JTextField(SwingConstants.CENTER);
            input.setPreferredSize(new Dimension(300, 25));
            panel.add(input, BorderLayout.CENTER);

            JButton searchBtn = new JButton("Search");
            panel.add(searchBtn);

            JTextField resultText = new JTextField("");
            resultText.setPreferredSize(new Dimension(1260, 25));
            resultText.setEditable(false);
            resultText.setFocusable(false);
            JScrollPane scrollPane = new JScrollPane(resultText);
            panel.add(scrollPane, BorderLayout.CENTER);

            // Handle search button click
            searchBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String word = input.getText();

                    if (!word.isEmpty()) {
                        resultText.setText(Search.wordOccurrences(word));
                    }
                }
            });

            input.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    // Do nothing
                }

                @Override
                public void focusLost(FocusEvent e) {
                    input.setFocusable(false);
                    input.setFocusable(true);
                }
            });

            return panel;
        } else if (pageName == "Phrase Occurrences") {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JLabel label = new JLabel(pageName, SwingConstants.CENTER);
            panel.add(label, BorderLayout.CENTER);

            return panel;
        } else if (pageName == "Random Verse") {
            // Random verse
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));

            JLabel titleLabel = new JLabel("Random Verse");
            titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
            titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
            panel.add(titleLabel, BorderLayout.NORTH);

            JButton searchBtn = new JButton("Generate");
            panel.add(searchBtn);

            JTextArea resultTextArea = new JTextArea("");
            resultTextArea.setPreferredSize(new Dimension(1260, 600));
            resultTextArea.setEditable(false);
            resultTextArea.setFocusable(false);
            JScrollPane scrollPane = new JScrollPane(resultTextArea);
            panel.add(scrollPane, BorderLayout.CENTER);

            // Handle generate button click
            searchBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    resultTextArea.setText(Search.randomVerse());
                }
            });

            return panel;
        } else {
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JLabel label = new JLabel("An error has occurred.", SwingConstants.CENTER);
            panel.add(label, BorderLayout.CENTER);

            return panel;
        }
    }

    // Display page on UI
    private static void showPage(JPanel page) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(page, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new FlowLayout());

        JButton page1Button = new JButton("Browse");
        page1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPage(page1);
            }
        });

        JButton page2Button = new JButton("Random Verse");
        page2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPage(page2);
            }
        });

        JButton page3Button = new JButton("Word Occurrences");
        page3Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPage(page3);
            }
        });

        JButton page4Button = new JButton("Phrase Occurrences");
        page4Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPage(page4);
            }
        });

        buttonPanel.add(page1Button);
        buttonPanel.add(page2Button);
        buttonPanel.add(page3Button);
        buttonPanel.add(page4Button);

        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

        frame.revalidate();
        frame.repaint();
    }
}