//package game_2048;
import java.util.*;
import java.io.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

class game {
	final int size=4;
	int board[][]=new int[4][4],last[][]=new int[4][4];
	int mult2=2;
	public int score=2;
	int no,total_blocks_filled=0;
	Scanner ss=new Scanner(System.in);
	Random rnd=new Random();
	boolean finish=false,trysomething=false;
	int max(int a,int b){return ((a>b)?a:b);}
	game()
	{  for(int i=0;i<size;i++)
		for(int j=0;j<size;j++)
		  board[i][j]=0;
		  
	}
	
	void calScore()
	{for(int i=0;i<size;i++)
		for(int j=0;j<size;j++)
		score=max(score,board[i][j]);
		
	}
	String gamehint(){
		int MAX=0,x1=-1,y1=-1,x2=-1,y2=-1;
	   for(int i=0;i<size;i++)
		for(int j=0;j<size-1;j++)
		{	if(board[i][j]==board[i][j+1] && board[i][j]!=0)
			{
			MAX=max(MAX,board[i][j]);
			if(MAX!=board[i][j]){
			x1=i;y1=j;x2=i;y2=j+1;
		}
		}
		    if(board[j][i]==board[j+1][i] && board[i][j]!=0){
		    MAX=max(MAX,board[j][i]);
		    if(MAX!=board[j][i]){
			x1=j;y1=i;x2=j+1;y2=i;
		}
		}
		
			}
			if(x1<x2 && x1>=0 && y1==y2){ 
				if((x1+x2)<size)
				return "Move Left";
				else
				return "Move Right";
				}
			else if(y1<y2 && y1>=0 && x1==x2){
				if((y1+y2)<size)
				return "Move Up";
				else 
				return "Move Down";
				}
				return "No Moves";
			
	}
	boolean check()
	{for(int i=0;i<size;i++)
		for(int j=0;j<size-1;j++)
		{
			if(board[i][j]==board[i][j+1])
		return false;
		if(board[j][i]==board[j+1][i])
		return false;
		
	}
	return true;
}
	void copyBoard()
	{
		for(int i=0;i<size;i++)
		for(int j=0;j<size;j++)
		board[i][j]=last[i][j];
	}
	void setboard(int row,int col,char dir)
	{   
		
		if(dir=='k')
		{
			if(board[row][col]!=0)
			setboard(rnd.nextInt(4),rnd.nextInt(4),'k');
			
		
			
			//else if(total_blocks_filled==size*size && check())
			
			else
			{
			board[row][col]=mult2;total_blocks_filled++;}
			if(total_blocks_filled==size*size && check())
			{High_scores hscore=new High_scores();
							hscore.filewrite(score);
			System.out.println("Game Over! Better Luck next time");
			finish=true;}
			else if(total_blocks_filled==size*size && !check())
			trysomething=true;
			
		}
		if(dir=='l')
		{   //System.out.println("left");
			for(int i=0;i<size;i++)
			{   int k=0;
			//System.out.print("outer for loop");
			for(int j=1;j<size;j++)
			{
			
				//System.out.print("inner for loop ");
			if(board[i][j]!=0 && board[i][k]==0)
			{
				board[i][k++]=board[i][j];
				
				board[i][j]=0;
			}
			if(board[i][j]==0 && board[i][k]!=0)
			k=j;
			
			
		}
		int flag=0;
		for(int j=0;j<size-1 && board[i][j]!=0 ;j++)
		
		if(board[i][j]==board[i][j+1])
		{
		board[i][j]*=2;total_blocks_filled--;
		//score=max(score,board[i][j]);
		board[i][j+1]=0;flag=1;break;
	      }
	      
	      //if(flag==1)
	      //i--;
		
		
	}//System.out.print(" left complete");
		}
		if(dir=='u')                                        //up direction
		{
			for(int i=0;i<size;i++)
			{   int k=0;
			//System.out.print("outer for loop");
			for(int j=1;j<size;j++)
			{
			
				//System.out.print("inner for loop ");
			if(board[j][i]!=0 && board[k][i]==0)
			{
				board[k++][i]=board[j][i];
				board[j][i]=0;
			}
			if(board[j][i]==0 && board[k][i]!=0)
			k=j;
			
		}
		int flag=0;
		for(int j=0;j<size-1  && board[j][i]!=0;j++)
		
		if(board[j][i]==board[j+1][i])
		{
		board[j][i]*=2;total_blocks_filled--;
		//score=max(score,board[i][j]);
		board[j+1][i]=0;flag=1;break;
	      }
	      
	      //if(flag==1)
	      //i--;
		
		
		}
	}
		if(dir=='d'){
		
			for(int i=0;i<size;i++)
			{   int k=size-1;
			//System.out.print("outer for loop");
			for(int j=size-2;j>=0;j--)
			{
			
				//System.out.print("inner for loop ");
			if(board[j][i]!=0 && board[k][i]==0)
			{
				board[k--][i]=board[j][i];
				board[j][i]=0;
			}
			if(board[j][i]==0 && board[k][i]!=0)
			k=j;
			
		}
		int flag=0;
		for(int j=size-1;j>=1  && board[j][i]!=0;j--)
		
		if(board[j][i]==board[j-1][i])
		{
		board[j][i]*=2;total_blocks_filled--;
		//score=max(score,board[i][j]);
		board[j-1][i]=0;flag=1;break;
		
	      }
	      
	      //if(flag==1)
	      //i--;
		
		
		}				
}
		if(dir=='r'){
			for(int i=0;i<size;i++)
			{   int k=size-1;
			//System.out.print("outer for loop");
			for(int j=size-2;j>=0;j--)
			{
			
				//System.out.print("inner for loop ");
			if(board[i][j]!=0 && board[i][k]==0)
			{
				board[i][k--]=board[i][j];
				
				board[i][j]=0;
			}
			if(board[i][j]==0 && board[i][k]!=0)
			k=j;
			
			
		}
		int flag=0;
		for(int j=size-1;j>=1 && board[i][j]!=0 ;j--)
		
		if(board[i][j]==board[i][j-1])
		{
		board[i][j]*=2;total_blocks_filled--;
		//score=max(score,board[i][j]);
		board[i][j-1]=0;flag=1;break;
	      }
	      
	      //if(flag==1)
	      //i--;
		
		}
	}
		if(board[row][col]==0 && dir=='o')
		{
			board[row][col]=mult2;
			total_blocks_filled=1;
		}
		calScore();
	
}
	void seeboard()
	{  System.out.println(" Score: "+score);
		for(int i=0;i<size;i++)
		{
		for(int j=0;j<size;j++)
		  System.out.print(board[i][j] +" ");
		  System.out.println();
	  }
		  
	}
	
	void game_start()
	
	{
		
		int rowfirst=rnd.nextInt(4);
		int colfirst=rnd.nextInt(4);
		for(int i=0;i<size;i++)
		for(int j=0;j<size;j++)
		board[i][j]=0;
		//System.out.println("row= "+rowfirst+" col= "+colfirst);
		setboard(rowfirst,colfirst,'o');
		
	}
	/*void play()
	{   char ch;
		//try{
		while(true)
		{   
			
				System.out.print("INPUT direction: ");
			ch=ss.next().charAt(0);                                       //used (char) System.in.read();
		    	//ch=(char) System.in.read();	
			
			if(ch=='w')
			{
							
				setboard(0,0,'u');
				//seeboard();
				
				

			}
			if(ch=='a')
			{
				setboard(0,0,'l');
				//seeboard();
			}
			if(ch=='s'){setboard(0,0,'d');
				//seeboard();
				}
			if(ch=='d'){
				setboard(0,0,'r');
				//seeboard();
				}
				setboard(rnd.nextInt(4),rnd.nextInt(4),'k');
				seeboard();
			if(ch!='w'&& ch!='a'&& ch!='s'&& ch!='d')
			break;
			
		}
		//}catch(IOException io){ System.out.println("ERROR in reading: "+io);}		
	}*/
	
    
	/*public static void main(String [] args)
	{   
		// addKeyListener(this);
			//  setFocusable(true);
			 // setFocusTraversalKeysEnabled(false);
		
		game g=new game();
		g.game_start();
		
		g.seeboard();
		g.play();
	
		
	}*/
	
	}
		
	

		
	
