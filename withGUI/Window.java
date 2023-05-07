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
        frame.setTitle("2 Player TicTacToe");
        frame.setLocation(400,100);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,600);

        //content panel for start menu
        JPanel start_menu = new JPanel();
        start_menu.setLayout(new GridLayout(3,1));
        start_menu.setBackground(new Color(0,10,10));
        final JButton start = new JButton();
        start.setName("menuScreen");
        start.setText("Play!");
        start.addActionListener(
            new ActionListener() {
                    public void actionPerformed(ActionEvent e){
                        frame.add(initialize_contentPanel());//switch screens
                        frame.remove(start_menu);
                        frame.setVisible(true);
                        }
                    }
                );
        start_menu.add(start);

        frame.add(start_menu);
        frame.setVisible(true);




    }

    private static JPanel initialize_end_Panel()// generate an endscreen JPanel
    {
        JPanel end_Panel = new JPanel(new GridBagLayout());
        end_Panel.setBackground(new Color(0,0,0));
        JLabel label = new JLabel("Game Over!");
        end_Panel.add(label);
        return end_Panel;
    }

    private static JPanel initialize_contentPanel(){ // main gameplay JPanel

        //content panel for game screen
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
                            TicTacToe.game_rules(button);
                        }
                        }

                    );
                button.setBorder(BorderFactory.createLineBorder(Color.blue)); //creates lineborders between each square of matrix
                contentPanel.add(button);
            }
        }
        return contentPanel;
    }

}