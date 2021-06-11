import java.awt.event.*;  
import javax.swing.*;    
public class Testing {
	static String[][] board = {{"","",""},{"","",""},{"","",""}};
	static String current_player = "1";
	static Boolean game_over = false;
	public static void main(String[] args) {  
	    JFrame f=new JFrame("Button Example");  
	    for (int x=0;x<3;x++) {
	    	for (int y=0;y<3;y++) {
	    		final int finalx = x;
	    		final int finaly = y;
	    		final JTextField tf=new JTextField();  
	    	    tf.setBounds(x*100,y*100,100,100);  
	    		final JButton b = new JButton("");  
		    	b.setBounds(x*100,y*100,100,100);  
		    	b.addActionListener(new ActionListener(){  
		    		public void actionPerformed(ActionEvent e){  
		    			if (current_player == "1") {
		    				board[finalx][finaly] = "X";
		    				tf.setText("X"); 
		    				current_player = "2";
		    			}
		    			else {
		    				board[finalx][finaly] = "O";
		    				tf.setText("O"); 
		    				current_player = "1";
		    			}
		    			b.setVisible(false); 
		    			
		    		}
		    	});  
		    	f.add(b);f.add(tf);  
		    	
	    	}
	    }
	    f.setSize(350,350);  
	    f.setLayout(null);  
	    f.setVisible(true);
	    while (true) {
	    	for (int x=0;x<3;x++) {
	    		if (board[0][x] == "X"&&board[1][x] == "X"&&board[2][x] == "X" || board[x][0] == "X"&&board[x][1] == "X"&&board[x][2] == "X" || board[0][0] == "X"&&board[1][1] == "X"&&board[2][2] == "X"||board[0][2] == "X"&&board[1][1] == "X"&&board[2][0] == "X") {
	    			System.out.println("X Won");
	    			f.setVisible(false);
	    			game_over = true;
	    			break;
		    	}
	    	}
	    	for (int x=0;x<3;x++) {
	    		if (board[0][x] == "Y"&&board[1][x] == "Y"&&board[2][x] == "Y"||board[x][0] == "Y"&&board[x][1] == "Y"&&board[x][2] == "Y"||board[0][0] == "Y"&&board[1][1] == "Y"&&board[2][2] == "Y"||board[0][2] == "Y"&&board[1][1] == "Y"&&board[2][0] == "Y") {
	    			System.out.println("Y Won");
	    			f.setVisible(false);
	    			game_over = true;
	    			break;
		    	}
	    	}	
	    	if (game_over == true) {
	    		break;
	    	}
	    }
	}
}
