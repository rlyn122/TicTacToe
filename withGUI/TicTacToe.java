import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// 3x3 matrix and two player tictactoe via GUI


public class TicTacToe extends JFrame{

    //core game variables
    static boolean Player_Turn; //true if it is x player's turn, false if it o player's turn
    static String[][]  board = new String[3][3]; //0 if empty, 1 if x, 2 if o

    public static void button_Click(JButton button){
        if(button.getText().equals(" ")){

            if (Player_Turn==true){ //player x's turn
                button.setText("x");
        }
            else{ //player o's turn
                button.setText("o");
            }
            Player_Turn = !Player_Turn; //alternate player turn
        }
    }
     //implements game rules of tictactoe by using board String array[][], returns true if game is over, returns false if not over
    public static void game_rules(JButton button){
        String pos = button.getName();
        String sign = button.getText();

        int row = Character.getNumericValue(pos.charAt(0));
        int col = Character.getNumericValue(pos.charAt(1));
        board[row][col] = sign;

        if(wincheck(sign)==true){
            JOptionPane.showMessageDialog(null,"Player "+ sign + " has won!");
            System.exit(0);
        }
        if(stalemate_check(sign)==true){
            JOptionPane.showMessageDialog(null,"Stalemate has been reached, nobody wins :(.");
            System.exit(0);
        }


    }

    private static boolean wincheck(String symbol) {  //checks if symbol has 3 in a row, returns true if there is a winner
    if ((board[0][0] == symbol && board [0][1] == symbol && board [0][2] == symbol) ||
        (board[1][0] == symbol && board [1][1] == symbol && board [1][2] == symbol) ||
        (board[2][0] == symbol && board [2][1] == symbol && board [2][2] == symbol) ||
        
        (board[0][0] == symbol && board [1][0] == symbol && board [2][0] == symbol) ||
        (board[0][1] == symbol && board [1][1] == symbol && board [2][1] == symbol) ||
        (board[0][2] == symbol && board [1][2] == symbol && board [2][2] == symbol) ||
        
        (board[0][0] == symbol && board [1][1] == symbol && board [2][2] == symbol) ||
        (board[0][2] == symbol && board [1][1] == symbol && board [2][0] == symbol) ) {
        return true;
    }
    return false;
}
    private static boolean stalemate_check(String symbol) {  //checks if symbol has 3 in a row, returns true if there is a winner
        boolean t = true;
        for(int i = 0 ; i<board.length;i++){
            for(int j = 0 ; j<board[0].length;j++){
                if (board[i][j].equals(null)) {
                    t = false;
                }
            }
        }
    
    return t;
}


}