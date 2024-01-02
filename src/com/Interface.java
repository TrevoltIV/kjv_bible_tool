package com;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Interface {
    private static JFrame frame;
    private static JPanel page1;
    private static JPanel page2;
    private static JPanel page3;
    private static JPanel page4;
    private static JPanel page5;

    // Initialize UI
    public static void build() {
        frame = new JFrame("Trevolt's KJV Bible Tool");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("res/icon.png");
        frame.setIconImage(icon.getImage());

        page1 = createPage("Chapter Lookup");
        page2 = createPage("Verse Lookup");
        page3 = createPage("Word Occurrences");
        page4 = createPage("Phrase Occurrences");
        page5 = createPage("Random Verse");

        showPage(page1);

        frame.setSize(1280, 720);
        frame.setVisible(true);
    }

    // Return JPanel page for specified page name
    private static JPanel createPage(String pageName) {
        if (pageName == "Chapter Lookup") {
            // Chapter Lookup
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));

            JLabel titleLabel = new JLabel("Chapter Lookup");
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
        } else if (pageName == "Verse Lookup") {
            // Verse Lookup
            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout(FlowLayout.CENTER));

            JLabel titleLabel = new JLabel("Verse Lookup");
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
                    String text = input.getText();

                    if (!text.isEmpty()) {
                        resultTextArea.setText(Search.specificVerse(text));
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
            JPanel panel = new JPanel();
            panel.setLayout(new BorderLayout());

            JLabel label = new JLabel(pageName, SwingConstants.CENTER);
            panel.add(label, BorderLayout.CENTER);

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

        JButton page1Button = new JButton("Chapter Lookup");
        page1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPage(page1);
            }
        });

        JButton page2Button = new JButton("Verse Lookup");
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

        JButton page5Button = new JButton("Random Verse");
        page5Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPage(page5);
            }
        });

        buttonPanel.add(page1Button);
        buttonPanel.add(page2Button);
        buttonPanel.add(page3Button);
        buttonPanel.add(page4Button);
        buttonPanel.add(page5Button);

        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);

        frame.revalidate();
        frame.repaint();
    }
}