//creates window for gui
//https://stackoverflow.com/questions/59454490/tictactoe-with-gui-in-java

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Window {
    
    //constructor
    public Window()
    {
        
        JFrame frame = new JFrame();
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(3,3)); //3x3 matrix
        contentPanel.setBackground(new Color(30,140,50));

        //add buttons to each square of matrix
        for (int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++) 
            {
                //create a new button for a specific part of matrix
                final JButton button = new JButton();
                String string = i +  "" + j;
                button.setText(" "); //sets text on each button
                button.setName(string); //sets name on each button
                button.addActionListener(   //add an actionLister to button: place an X or an O
                    new ActionListener() {
                        public void actionPerformed(ActionEvent e) {
                            TicTacToe.button_Click(button);
                            //TicTacToe.gameRules(button);
                        }
                    });
                button.setBorder(BorderFactory.createLineBorder(Color.blue)); //creates lineborders between each square of matrix

                contentPanel.add(button);
            }

            
        }
        
        frame.setTitle("2 Player TicTacToe");
        frame.setLocation(400,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(contentPanel);
        frame.setSize(600,600);
        frame.setVisible(true);


    }

}