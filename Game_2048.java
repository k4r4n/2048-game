import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.border.*;
import javax.swing.JComponent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class Game_2048 extends game  {
    MainBoard next=new MainBoard();
    public JLabel[] grids;
    JFrame frame = new JFrame("2048 Game");
    public static void main(String[] args) {
        new Game_2048();
    }

    public Game_2048() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }
                
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
               
                
                
                frame.add(next);
                frame.add(new MenuPane(), BorderLayout.AFTER_LINE_ENDS);
                
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    
    
    public class MenuPane extends JPanel implements ActionListener{
         JButton New=new JButton("New");
         JButton exit= new JButton("Exit");
         JButton lastmove=new JButton("Last Move");
         JButton hint=new JButton("Hint");
        public MenuPane() {
            setBorder(new EmptyBorder(4, 4, 4, 4));
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;

            add(lastmove, gbc);
            gbc.gridy++;
            
            add(New, gbc);
            
            gbc.gridy++;
            add(hint, gbc);
            gbc.gridy++;
            
            add(exit, gbc);
            func();
                      
            
           
        }
        public static final int ROWS = 4;
        public static final int COLUMNS = 4;
        public void griding(){
			
			 JLabel grid=new JLabel();
			for (int row = 0,i=0; row < ROWS; row++,i++) {
                for (int col = 0,j=0; col < COLUMNS; col++,j++) {
                    int index = (row * COLUMNS) + col;
                   
                    grid=grids[index];
                    //score=max(score,oard[i][j]);
                    //Score_display.setText(" "+ score+" ");
                    if(board[i][j]!=0)
                    grid.setText(" "+board[i][j]+" ");
                    else
                    grid.setText(" ");
                    grid.setForeground(Color.red);
                    if(board[i][j]==score)
                    {Color lightyellow=new Color(255,255,0);
						grid.setBackground(lightyellow);
						grid.setOpaque(true);}
						
                    else if(board[i][j]==0){
                    Color lightyellow=new Color(192,192,192);
                    grid.setBackground(lightyellow);
                    grid.setOpaque(true);}
                    
                    else{
                    Color lightyellow=new Color(255,255,102);
                    grid.setBackground(lightyellow);
                    grid.setOpaque(true);}
                 
                    
                    
                    grid.setHorizontalAlignment(JLabel.CENTER);
                    grid.setFont(new Font(grid.getFont().getName(), grid.getFont().getStyle(), 40));
                    grid.setBorder(new LineBorder(Color.BLACK));

                }
            }
		}
		
        public void func()
        {
               exit.addActionListener(new ActionListener() {          
                public void actionPerformed(ActionEvent e) {
		
                Object[] options = new String[]{"YES, I will quit", "No, I will beat it"};
               int opt= JOptionPane.showOptionDialog(frame, "Moment of truth", "Do you really want to quit?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, options, options[1]);
                        
                        if(opt==JOptionPane.YES_OPTION)
                        {High_scores hscore=new High_scores();
							hscore.filewrite(score);
							
                            System.exit(0);
                        }
                       
                        
    }
});
               New.addActionListener(new ActionListener() {          
                public void actionPerformed(ActionEvent e) {
		
                Object[] options = new String[]{"YES, I want to", "No, I will play this"};
               int opt= JOptionPane.showOptionDialog(frame, "All your progress will be gone", "Do you really want to start fresh?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, options, options[1]);
                        
                        if(opt==JOptionPane.YES_OPTION)
                        {
							game_start();
							score=2;
							//Score_display.setText(" "+score+" ");
							griding();
							//subBoards.setGrid();
                           
                        }
                       
                        
    }
});
                lastmove.addActionListener(new ActionListener() {          
                public void actionPerformed(ActionEvent e) {
		
                Object[] options = new String[]{"YES, I want to", "No, I dont want to"};
               int opt= JOptionPane.showOptionDialog(frame, "You can cheat.But only once;)", "Do you really want to go back one move?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, options, options[1]);
                        
                        if(opt==JOptionPane.YES_OPTION)
                        {    copyBoard();
							 griding(); 
							 
                           
                        }
                       
                        
    }
});
               hint.addActionListener(new ActionListener() {          
                public void actionPerformed(ActionEvent e) {
		
                //Object[] options = new String[]{"YES, I want to", "No, I will play this"};
               JOptionPane.showMessageDialog(frame, "You have as many hints you want ;)\n"+gamehint(), "Hint",  JOptionPane.INFORMATION_MESSAGE, 
                        null);
                        
                      
                       
                        
    }
});
			}
         public void actionPerformed(ActionEvent a)
            {
				
			}
			
    }

    public class MainBoard extends JPanel implements KeyListener {

       
        
        SubBoard subBoards= new SubBoard();
        JLabel Score_display=new JLabel();
        void play(char ch)
	{   
			
			
			if(ch=='w')
			{
							
				setboard(0,0,'u');
				
				
				

			}
			if(ch=='a')
			{
				setboard(0,0,'l');
				
			}
			if(ch=='s'){setboard(0,0,'d');
				
				}
			if(ch=='d'){
				setboard(0,0,'r');
				
				}
			if(ch=='o'){
				
				setboard(rnd.nextInt(4),rnd.nextInt(4),'o');
				subBoards.setGrid();
			}	
				setboard(rnd.nextInt(4),rnd.nextInt(4),'k');
				Score_display.setText("Score: "+score+" ");
				subBoards.setGrid();
						
	}
	 public void keyPressed(KeyEvent e)
		  {   if(!finish && !trysomething){
			  
			 for(int i=0;i<size;i++)
			 for(int j=0;j<size;j++)
			 last[i][j]=board[i][j];
			 
			  int code=e.getKeyCode();
			  if(code==KeyEvent.VK_UP){
			  System.out.println("Up");
			  play('w');
		  }
			  if(code==KeyEvent.VK_DOWN){
			  System.out.println("DOWN");
			 play('s');
		  }
			  if(code==KeyEvent.VK_LEFT){
			  System.out.println("LEFT");
			  play('a');
		  }
			  if(code==KeyEvent.VK_RIGHT){
			  System.out.println("RIGHT");
			  play('d');
		  }
		 }
		 else if(trysomething){
			 Object[] options = new String[]{"Thinking...", "No, I dont want to play"};
               int opt= JOptionPane.showOptionDialog(frame, "Think of other move", "Moves left", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, options, options[0]);
                        
                        if(opt==JOptionPane.NO_OPTION)
                        {High_scores hscore=new High_scores();
							hscore.filewrite(score);
							
                            System.exit(0);    
                        }
                         else  trysomething=false;
                        
                        
                        
		 }
		 
		 else{
			 Object[] options = new String[]{"YES, I want to", "No, I will quit instead"};
               int opt= JOptionPane.showOptionDialog(frame, "Do you want to play again?\nYou have a lifeline", "Game Over!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, 
                        null, options, options[1]);
                        High_scores hscore=new High_scores();
							hscore.filewrite(score);
                        if(opt==JOptionPane.YES_OPTION)
                        {
							game_start();
							subBoards.setGrid();
							finish=false;
                           
                        }
                        else
                        System.exit(0);
	 }
		 
		  }
		  
		  public void keyReleased(KeyEvent e){System.out.println("key released");}
		  public void keyTyped(KeyEvent e){}
        public MainBoard() {
			
            setBorder(new EmptyBorder(4, 4, 4, 4));
          
            setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
           
                    subBoards.setBorder(new CompoundBorder(new LineBorder(Color.GRAY, 3), new EmptyBorder(4, 4, 4, 4)));
                  
                    Score_display.setText("Score: "+score+" ");
                    JLabel highscore=new JLabel();
                    High_scores hscore=new High_scores();
                    int readscore=hscore.fileread();
                    highscore.setText("High score:"+readscore+" ");
                    
			        subBoards.addKeyListener(this);
                    subBoards.setFocusable(true);
			        subBoards.setFocusTraversalKeysEnabled(false);
                    setboard((new Random()).nextInt(4),(new Random()).nextInt(4),'o');
                    subBoards.setGrid();
                    Color back=new Color(152,152,152);
                    subBoards.setBackground(back);
                  
                    Score_display.setFont(new Font(Score_display.getFont().getName(), Score_display.getFont().getStyle(), 40));
                    highscore.setFont(new Font(Score_display.getFont().getName(), Score_display.getFont().getStyle(), 20));
                    add(Score_display);
                   add(Box.createVerticalGlue());
                    add(highscore,BorderLayout.EAST);
                    
                     Score_display.setPreferredSize(new Dimension(50,50));
                  
                    add(subBoards);
                    
                   
           
        }
    }

    public class SubBoard extends JPanel {

        public static final int ROWS = 4;
        public static final int COLUMNS = 4;

        //public JLabel[] grids;
        
     
        public SubBoard() {
			
            setLayout(new GridLayout(ROWS, COLUMNS, 2, 2));
            Dimension screen_dim=new Dimension(java.awt.Toolkit.getDefaultToolkit().getScreenSize());
            screen_dim.setSize(screen_dim.getWidth()/2,screen_dim.getHeight()/2);
            setPreferredSize(screen_dim);
            grids = new JLabel[ROWS * COLUMNS];
            for (int row = 0,i=0; row < ROWS; row++,i++) {
                for (int col = 0,j=0; col < COLUMNS; col++,j++) {
                    int index = (row * COLUMNS) + col;
                    JLabel grid = new JLabel();
                    grids[index] = grid;
                    if(board[i][j]!=0)
                    grid.setText(" "+board[i][j]+" ");
                    else
                    grid.setText(" ");
                    grid.setHorizontalAlignment(JLabel.CENTER);
                    grid.setFont(new Font(grid.getFont().getName(), grid.getFont().getStyle(), 40));
                    grid.setBorder(new LineBorder(Color.BLACK));

                    add(grid);
                }
            }
        }
        
       public void setGrid()
        {   JLabel grid=new JLabel();
			for (int row = 0,i=0; row < ROWS; row++,i++) {
                for (int col = 0,j=0; col < COLUMNS; col++,j++) {
                    int index = (row * COLUMNS) + col;
                   
                    grid=grids[index];
                    
                    if(board[i][j]!=0)
                    grid.setText(" "+board[i][j]+" ");
                    else
                    grid.setText(" ");
                    grid.setForeground(Color.red);
                    if(board[i][j]==score)
                    {Color lightyellow=new Color(255,255,0);
						grid.setBackground(lightyellow);
						grid.setOpaque(true);}
						
                    else if(board[i][j]==0){
                    Color lightyellow=new Color(192,192,192);
                    grid.setBackground(lightyellow);
                    grid.setOpaque(true);}
                    
                    else{
                    Color lightyellow=new Color(255,255,225);
                    grid.setBackground(lightyellow);
                    grid.setOpaque(true);}
                 
                    
                    
                    grid.setHorizontalAlignment(JLabel.CENTER);
                    grid.setFont(new Font(grid.getFont().getName(), grid.getFont().getStyle(), 40));
                    grid.setBorder(new LineBorder(Color.BLACK));

                }
            }
		}
    }
}
