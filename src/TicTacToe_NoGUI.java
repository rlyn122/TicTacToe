import java.util.Scanner;
import java.util.Random;


//below is implementation of TicTacToe game without GUI
//there is 1 player and 2 player TicTacToe modes, game ends after a player wins


public class TicTacToe_NoGUI{

    private static char[][] board = {{' ',' ',' '},
    {' ',' ',' '},
    {' ',' ',' '}}; 
    public static void main(String[] args){

        run(board);
    }


private static void run(char[][] board){              //game loop

    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();

    int runstate;

    System.out.println("Would you like to player 1 player or two player? (1/2)");  
    runstate = scanner.nextInt();

    if (runstate == 2){
        System.out.println("You selected 2 player tictactoe!");  
    }
    else {
        System.out.println("You selected 1 player tictactoe!\n Place your first x!");  
    }
    while(runstate==1){ //one player game loop
        
        player_turn(board, scanner,1,'X');
        if(endcheck(board,'X')==true){  //check if player x has won
            printboard(board);
            System.out.println(("Game Over player 1 (X) has won"));
            break;
        }
        npc_turn(board,rand,'O');
        if(endcheck(board,'O')==true){  //check if player o has won
            printboard(board);
            System.out.println("Game Over npc (o) has won");
            break;
           
        }

    }

    while(runstate==2){ //two player game loop
        
        player_turn(board, scanner,1,'X');

        if(endcheck(board,'X')==true){  //check if player x has won
            printboard(board);
            System.out.println(("Game Over player 1 (X) has won"));
            break;
           
        }

        player_turn(board, scanner,2,'O');

        if(endcheck(board,'O')==true){  //check if player o has won
            printboard(board);
            System.out.println("Game Over player 2 (o) has won");
            break;
           
        }
    }

    scanner.close();

}

private static void npc_turn(char[][] board, Random rand, char sign){
    int x;
    int y;
    while(true){
    x= rand.nextInt(3);
    y= rand.nextInt(3);
    if(board[x][y]==' '){
        insert(board,sign,x,y);
        System.out.printf("NPC has placed at %d,%d \n",x,y);
        break;
    }
    }
    
}

private static void player_turn(char[][] board, Scanner scanner, int player, char sign){ //runs player 1 or 2 turn and checks if valid input

    int row;
    int col;

    while(true){ //keeps running till there is a valid input

    printboard(board);
    System.out.printf("Player %d turn (%c): \n",player,sign);
    System.out.println("enter row: ");
    row = scanner.nextInt();
    System.out.println("enter column");
    col = scanner.nextInt();
    if(board[row][col]==' '){
        break;
    }
    System.out.println("invalid input");

    }
    insert(board, sign, row, col);
}



private static void insert(char[][] board ,char x, int row , int column){
    board[row][column] = x;
}


private static void printboard(char[][] board){


    for(int i = 0 ; i < 3 ; i++){
        for(int j = 0 ; j <3 ; j++){
            System.out.print("| "+ board[i][j] + " |");
        }
        System.out.println();
    }

}



private static boolean endcheck(char[][] board, char symbol) {  //checks if symbol has 3 in a row
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

}