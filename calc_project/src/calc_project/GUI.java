package calc_project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;


public class GUI {
    public void createAndShowGUI() {

        JFrame jf = new JFrame("Calculator");
        jf.setLocationRelativeTo(null);
        jf.setPreferredSize(new Dimension(320, 200));
        jf.setResizable(false);
        jf.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        JTextField jb = new JTextField("");
        jb.setFont(new Font("Arial", Font.BOLD,13));
        jb.setHorizontalAlignment(SwingConstants.RIGHT);
        jb.setEnabled(false);
        jb.setText("0");
        jf.getContentPane().add(jb, gbc);

        gbc.gridwidth = 1;

        String digitsAndChars[] = new String[]
                {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "=", "C", "/"};


        final boolean[] whichArg = {true};
        final String[] nextToLastEntry = {new String("0")};
        final String[] operator = {new String()};

        final java.util.List<String> firstArgStr = new ArrayList<>();
        final List<String> secondArgStr = new ArrayList<>();
        final Integer[] args = {0,0,0};

        firstArgStr.add("0");
        secondArgStr.add("0");

        Calculations C = new Calculations();

        ActionListener myActionListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {



                String lastEntry = e.getActionCommand();
                String equals = "=";
                String operatorsStr = "+-/*";
                String digit = "0123456789";
                String Clear = "C";

                try {
                    //a
                    if (operatorsStr.contains(nextToLastEntry[0]) && operatorsStr.contains(lastEntry)) {
                        operator[0] = lastEntry;
                    }
                    //b
                    else if (operatorsStr.contains(nextToLastEntry[0]) && digit.contains(lastEntry)) {
                        secondArgStr.add(lastEntry);
                        String liczba2 = C.joinDigits(secondArgStr);
                        args[1] = Integer.valueOf(liczba2);
                        jb.setText(String.valueOf(args[1]));
                    }
                    //c
                    else if (operatorsStr.contains(nextToLastEntry[0]) && equals.contains(lastEntry)) {
                        args[2] = C.operation(operator[0], args[0], args[0]);
                        args[1] = args[0];
                        args[0] = args[2];
                        jb.setText(String.valueOf(args[2]));
                    }
                    //d
                    else if (Clear.contains(lastEntry)) {
                        firstArgStr.clear();
                        firstArgStr.add("0");
                        args[0] = 0;
                        secondArgStr.clear();
                        secondArgStr.add("0");
                        args[1] = 0;
                        operator[0] = "";
                        whichArg[0] = true;
                        args[2] = 0;
                        lastEntry = "0";
                        jb.setText("0");

                    }
                    //e
                    else if (digit.contains(nextToLastEntry[0]) && operatorsStr.contains(lastEntry)) {

                        args[0] = C.operation(operator[0], args[0], args[1]);
                        operator[0] = lastEntry;
                        args[1] = 0;
                        args[2] = args[0];

                        jb.setText(String.valueOf(args[0]));

                        firstArgStr.clear();
                        secondArgStr.clear();

                        whichArg[0] = false;

                    }
                    //f
                    else if (digit.contains(nextToLastEntry[0]) && digit.contains(lastEntry)) {
                        if (whichArg[0]) {
                            firstArgStr.add(lastEntry);
                            String liczba = C.joinDigits(firstArgStr);
                            args[0] = Integer.valueOf(liczba);
                            jb.setText(String.valueOf(args[0]));
                        } else {
                            secondArgStr.add(lastEntry);
                            String liczba2 = C.joinDigits(secondArgStr);
                            args[1] = Integer.valueOf(liczba2);
                            jb.setText(String.valueOf(args[1]));
                        }
                    }
                    //g
                    else if (digit.contains(nextToLastEntry[0]) && equals.contains(lastEntry)) {
                        if (operatorsStr.contains(operator[0])) {
                            args[2] = C.operation(operator[0], args[0], args[1]);
                        }
                        secondArgStr.clear();
                        jb.setText(String.valueOf(args[2]));
                    }
                    //h
                    else if (equals.contains(nextToLastEntry[0]) && operatorsStr.contains(lastEntry)) {
                        args[0] = args[2];
                        operator[0] = lastEntry;
                    }
                    //i
                    else if (equals.contains(nextToLastEntry[0]) && digit.contains(lastEntry)) {
                        firstArgStr.clear();
                        firstArgStr.add(lastEntry);
                        String liczba = C.joinDigits(firstArgStr);
                        args[0] = Integer.valueOf(liczba);
                        jb.setText(liczba);
                        secondArgStr.clear();
                        args[1] = 0;
                        secondArgStr.add("0");

                        whichArg[0] = true;
                        operator[0] = "";
                        args[2] = 0;
                    }
                    //j
                    else if (equals.contains(nextToLastEntry[0]) && equals.contains(lastEntry)) {
                        args[2] = C.operation(operator[0], args[2], args[1]);
                        args[0] = args[2];
                        jb.setText(String.valueOf(args[2]));
                    }

                    nextToLastEntry[0] = lastEntry;
                }
                catch (ArithmeticException e1){
                    jb.setText("ERROR: Dzielenie przez 0");
                    firstArgStr.clear();
                    firstArgStr.add("0");
                    args[0] = 0;
                    secondArgStr.clear();
                    secondArgStr.add("0");
                    args[1] = 0;
                    operator[0] = "";
                    whichArg[0] = true;
                    args[2] = 0;
                    lastEntry = "0";
                }
            }
        };

        int a = 0;
        for (int i=1; i<5;i++){
            for (int j=0; j<4;j++){
                gbc.gridy = i;
                gbc.gridx = j;
                JButton jbu = new JButton(digitsAndChars[a]);
                jbu.addActionListener(myActionListener);
                jf.getContentPane().add(jbu, gbc);
                a++;
            }
        }

        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}