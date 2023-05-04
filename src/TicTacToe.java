import java.util.Scanner;
import java.util.Random;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.EmptyBorder;




public class TicTacToe extends JFrame{

    private JPanel grid; //grid where x and o's are placed
    private JPanel[] holes = new JPanel[9];  //holes for x and os
    private JLabel[] holes_f = new JLabel[9]; 

public TicTacToe(){
    setTitle("TicTacToe");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100,100,608,720);

    JPanel contentPane = new JPanel(); //JPanel hiolds objects inside it. Displays content of game window
    contentPane.setBackground(new Color(255, 253, 224));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(null);

    setContentPane(contentPane);

    JLabel label_title = new JLabel("TicTacToe"); //Title JPanel
    label_title.setForeground(new Color(10,70,10));
    label_title.setHorizontalAlignment(SwingConstants.CENTER);
    label_title.setFont(new Font("Sans Serif", Font.BOLD, 30));
    label_title.setBounds(0, 0, 602, 47);
    contentPane.add(label_title);

    grid  = new JPanel();                                   //square to hold holes for matrix
    grid.setBackground(new Color(0,0,0));
    grid.setBounds(32,80,500,500);
    grid.setLayout(null);

    contentPane.add(grid);

    holes[0] = new JPanel();                                //holes for Matrix 3x3, first row
    holes[0].setBackground(new Color(255,255,255));
    holes[0].setName("0");
    holes[0].setBounds(10, 10, 150, 150);
    grid.add(holes[0]);

    holes[1] = new JPanel();
    holes[1].setBackground(new Color(255,255,255));
    holes[1].setName("1");
    holes[1].setBounds(176, 10, 150, 150);
    grid.add(holes[1]);

    holes[2] = new JPanel();
    holes[2].setBackground(new Color(255,255,255));
    holes[2].setName("1");
    holes[2].setBounds(342, 10, 150, 150);
    grid.add(holes[2]);

    holes[3] = new JPanel();                                //holes for secopnd row
    holes[3].setBackground(new Color(255,255,255));
    holes[3].setName("3");
    holes[3].setBounds(10, 176, 150, 150);
    grid.add(holes[3]);

    holes[4] = new JPanel();
    holes[4].setBackground(new Color(255,255,255));
    holes[4].setName("4");
    holes[4].setBounds(176, 176, 150, 150);
    grid.add(holes[4]);

    holes[5] = new JPanel();
    holes[5].setBackground(new Color(255,255,255));
    holes[5].setName("5");
    holes[5].setBounds(342, 176, 150, 150);
    grid.add(holes[5]);

    holes[6] = new JPanel();                                //holes for 3rd row
    holes[6].setBackground(new Color(255,255,255));
    holes[6].setName("6");
    holes[6].setBounds(10, 342, 150, 150);
    grid.add(holes[6]);

    holes[7] = new JPanel();
    holes[7].setBackground(new Color(255,255,255));
    holes[7].setName("7");
    holes[7].setBounds(176, 342, 150, 150);
    grid.add(holes[7]);

    holes[8] = new JPanel();
    holes[8].setBackground(new Color(255,255,255));
    holes[8].setName("5");
    holes[8].setBounds(342, 342, 150, 150);
    grid.add(holes[8]);


    for(int i = 0 ; i<9 ; i++){                             //add jlabels for each section of matrix
        String s = Integer.toString(i);
    holes_f[i] = new JLabel(s);
    holes_f[i].setName("s");
    holes_f[i].setBounds(0, 0, 132, 132);
    holes[i].add(holes_f[i]);
    }


    add_sign('O',4);
    add_sign('X',1);
    
}



public static void main(String[] args){

    TicTacToe frame = new TicTacToe();
    frame.setVisible(true);

    char[][] board = {
        {' ',' ',' '},
        {' ',' ',' '},
        {' ',' ',' '}};

    run(board);
}

private void add_sign(char s, int i){     //loads image into a square i
    if(s == 'O'){
        holes_f[i].setIcon(loadImage("o.png"));
    }
    if(s == 'X'){
        holes_f[i].setIcon(loadImage("x.png"));
    }
}

private ImageIcon loadImage(String path){ //loads image with a path to the image
    Image image = new ImageIcon().getImage();
    try{
    image = new ImageIcon(getClass().getResource(path)).getImage();
    }catch (Exception e){
        System.out.println("Image not found");
    }
    Image scaledImage = image.getScaledInstance(150, 150,  java.awt.Image.SCALE_SMOOTH);
    return new ImageIcon(scaledImage);

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