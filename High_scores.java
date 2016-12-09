import java.io.*;
public class High_scores{
	    FileOutputStream fout;
	    FileInputStream fin;
             public void filewrite( int score)
             {
				 try{
					 
              
             
             int sc=fileread();
             
             
             
             System.out.println(sc+"\n"+score);
             
             if(sc<score)
             {   fout = new FileOutputStream("highscore.txt");
				 fout.write(score);
				 fout.close();
            // fout.flush();
		 }
             
             
             
		 }catch(Exception e){System.out.println(e);}
		 }
		 public int fileread()
		  {       int sc=0;
				 try{
					 
                      fin = new FileInputStream("highscore.txt");
            
            
             sc=fin.read();
             fin.close();
		 }catch(Exception e){System.out.println(e);}
		 return sc;
		 }
			 
		 
            
             

}
