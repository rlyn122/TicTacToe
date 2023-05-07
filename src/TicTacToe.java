import javax.swing.*;
import java.awt.*;

// 3x3 matrix and two player tictactoe via GUI


public class TicTacToe extends JFrame{

    private JPanel grid; //grid where x and o's are placed
    private JPanel[] holes = new JPanel[9];  //holes for x and os
    private JLabel[] holes_f = new JLabel[9]; 

    private static char[][] board = {{' ',' ',' '},
                                    {' ',' ',' '},
                                    {' ',' ',' '}}; 


    public static void main(String[] args){

        TicTacToe frame = new TicTacToe();

        
    }

    
public TicTacToe(){

    //set JFrame's title, size, layout, and close operation
    setTitle("TicTacToe");
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setBounds(100,100,608,720);

    //JPanel contentPane is  objects inside it which displays content of game window: set color, size, and borders
    JPanel contentPane = new JPanel(); 
    contentPane.setBackground(new Color(255, 253, 224));
    contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
    contentPane.setLayout(null);
    //set the JPanel so it is visible
    setContentPane(contentPane);

    //Title JPanel
    JLabel label_title = new JLabel("TicTacToe"); 
    label_title.setForeground(new Color(10,70,10));
    label_title.setHorizontalAlignment(SwingConstants.CENTER);
    label_title.setFont(new Font("Sans Serif", Font.BOLD, 30));
    label_title.setBounds(0, 0, 602, 47);
    contentPane.add(label_title);

    //create a new jpanel to hold holes for matrix
    grid  = new JPanel();                                   
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

    //set as window as visible
    this.setVisible(true);
    
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
}