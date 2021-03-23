import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.*;
import java.awt.image.Raster;
import java.lang.*;
import java.awt.Color;


class  Pixel
{
	public static void main(String[] args) 
	{
		// read the picture hw2.jpg into the java programming environment.
		
		File file = new File("hw2.jpg");
        BufferedImage img = null;
	
	try {
		
       img = ImageIO.read(new File("hw2.jpg"));  
	   int [][]r=new int[img.getWidth()][img.getHeight()];
       int [][]g=new int[img.getWidth()][img.getHeight()];
       int [][]b=new int[img.getWidth()][img.getHeight()];
	   
	  //get the r,g,b value of the every pixel. 
	  //convert the r,g,b to binary sring.
	   for(int i=0; i<img.getWidth();i++) {
	          for (int j=0;j<img.getHeight();j++ )

	   {  
		      r[i][j] =(img.getRGB(i,j)>>16)&0xFF;
			    g [i][j]=(img.getRGB(i,j)>>8)&0xff;
				b[i][j]=(img.getRGB(i,j) &0xFF);
				System.out.print(Integer.toBinaryString(r[i][j])+"  ");
				System.out.print(Integer.toBinaryString(g[i][j])+"  ");
				System.out.print(Integer.toBinaryString(b[i][j])+"  ");
                
				
                 
	   }
	   }
	   
	       
	
			
	
	} catch (IOException e){e.printStackTrace();
    }



	}
}
