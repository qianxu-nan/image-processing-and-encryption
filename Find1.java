import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.*;
import java.awt.image.Raster;
import java.lang.*;
import java.awt.Color;
class  Find1{
	public static void main(String[] args) 
	{
		
		File file = new File("hw2-4.png"); //read the image file
        BufferedImage img = null;
		
	
	try {
       img = ImageIO.read(new File("hw2-4.png"));
       int [][]r=new int[img.getWidth()][img.getHeight()];
       int [][]g=new int[img.getWidth()][img.getHeight()];
       int [][]b=new int[img.getWidth()][img.getHeight()];
	   //extrate the inforamtion from bufferedimage and assign the values from each pixels
	   for(int i=0; i<img.getWidth();i++) {
	          for (int j=0;j<img.getHeight();j++ )

	   {  
		        r[i][j] =(img.getRGB(i,j)>>16)&0xFF;
			    g [i][j]=(img.getRGB(i,j)>>8)&0xff;
				b[i][j]=(img.getRGB(i,j) &0xFF);
                 
	  
	   }
	   }
   
//convert the two dimension array to one dimension array
         int[] rarray = new int[img.getWidth()*img.getHeight()];
		 int[] garray = new int[img.getWidth()*img.getHeight()];
		 int[] barray = new int[img.getWidth()*img.getHeight()];
         for(int m = 0; m < img.getHeight(); m ++) {
            for(int s = 0; s < img.getWidth(); s ++) {
                rarray[m * img.getWidth() + s] = r[s][m];
                garray[m * img.getWidth() + s] = g[s][m];
                barray[m * img.getWidth() + s] = b[s][m];

            }
         }
	 int[][]Xu={{0,0,1},{0,1,1},{0,0,0},{0,0,1},{0,1,0},{1,0,1}};
	// find the location where embed my last name Xu 
	 for (int x=0;x<img.getWidth()*img.getHeight()-6 ; x++){ 
		 int[][] find= new int[6][3];
		 
		 int counter =0;
		 int check = 0;
		 for (int t=x;t<x+6 ;t++ ){
			 find[counter][0]= rarray[t]&1;
			 find[counter][1]= garray[t]&1;
			 find[counter][2]= barray[t]&1;
			 counter++;
		 }
		
	
	for (int k=0;k<6 ;k++ ){
		for (int q=0;q<3 ;q++ ){
		if (find[k][q]==Xu[k][q]){
			check++;
		}
	}
	}
	
    if (check==18){
       System.out.println("Found Xu!");
       //System.out.println(x);
	   
	   System.out.println("The Coordinate of the Encrypted Pixels(X,Y) are:");
	   for (int m=x;m<x+6;m++){
		   int x_cor=m%img.getWidth();
	       int y_cor=m/img.getWidth();
       System.out.println("X:"+x_cor+"    "+" Y: "+y_cor);
	}
    
	
	}
	
	
	}
}catch (IOException e){e.printStackTrace();}
}
}