import java.awt.event.*;  
import javax.swing.*; 
public class TicTacToeGame_GUI {
	static String[][] board = {{"","",""},{"","",""},{"","",""}};
	static String currentPlayer = "X";
	static int buttonSize = 50;
	public static boolean empty_board() {
		for (int x=0;x<3;x++) {
			for (int y=0;y<3;y++) {
				if (board[x][y] == "") {
					return false;
				}
			}
		}
		return true;
	}
	public static String won() {
		if (board[0][0].equals(board[1][1])&&board[1][1].equals(board[2][2])&&board[1][1]!=""
	      ||board[0][2].equals(board[1][1])&&board[1][1].equals(board[2][0])&&board[1][1]!="") {
	    	return board[1][1];
		}
		for (int i=0;i<3;i++) {
    		if (board[0][i].equals(board[1][i])&&board[1][i].equals(board[2][i])&&board[0][i]!=""
    		  ||board[i][0].equals(board[i][1])&&board[i][1].equals(board[i][2])&&board[0][i]!="") {
    			return board[i][i];
	    	}
    	}
		return "false";
	}
	public static void main(String[] args) {  
	    JFrame frame=new JFrame("Button Example");  
	    for (int x=0;x<3;x++) {
	    	for (int y=0;y<3;y++) {
	    		final int finalX = x;
	    		final int finalY = y;
	    		final JButton button = new JButton("");  
		    	button.setBounds(x*buttonSize,y*buttonSize,buttonSize,buttonSize); 
		    	final JTextField text=new JTextField();  
	    	    text.setBounds(x*buttonSize,y*buttonSize,buttonSize,buttonSize);  
		    	button.addActionListener(new ActionListener(){  public void actionPerformed(ActionEvent e){  
		    			board[finalX][finalY] = currentPlayer;
		    			text.setText(currentPlayer); 
		    			if (currentPlayer == "X") {
		    				currentPlayer = "O";
		    			}
		    			else {
		    				currentPlayer = "X";
		    			}
		    			
		    			button.setVisible(false); 
		    		}});  
		    	frame.add(button);
		    	frame.add(text);  
	    	}
	    }
	    frame.setSize(3*buttonSize+50,3*buttonSize+50);  
	    frame.setLayout(null);  
	    frame.setVisible(true);
	    while (true) {
	    	if (won()!= "false") {
	    		System.out.println(won()+"Won! Congrats!");
	    		break;
	    	}
	    	if (empty_board()) {
	    		System.out.println("Tie");
	    		break;
	    	}
	    }
	    System.out.println("Gameover");
	    frame.setVisible(false);
	}
}
