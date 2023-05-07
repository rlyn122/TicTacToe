import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 3x3 matrix and two player tictactoe via GUI


public class TicTacToe extends JFrame{

    //core game variables
    static boolean Player_Turn; //true if it is x player's turn, false if it o player's turn
    int[][] board = new int[3][3]; //0 if empty, 1 if x, 2 if o

    public static void button_Click(JButton button){
        if(button.getText().equals(" ")){

            if (Player_Turn==true) //player x's turn
                button.setText("x");
            else
                button.setText("o");

            Player_Turn = !Player_Turn; //alternate player turn
        }

    }


    //Constructor
    public TicTacToe(){



    }

    public static void main(String[] args){

        TicTacToe frame = new TicTacToe();
        
    }

}