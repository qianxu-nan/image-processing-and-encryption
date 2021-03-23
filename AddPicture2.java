import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.*;
import java.awt.image.Raster;
import java.lang.*;
import java.awt.Color;
class AddPicture2
{
	public static int add(int x, int y,int z){
		   if (x==0 && y==1){
			   z=z+1;
		   }
		   else if (x==1 && y==0)
		   {
			   z= z-1;
		   }
		   else
		   {
			   
		   }

            return z;
		 }
		 
	public static int[] addPicture(int pos)
	{
		File file1 = new File("th.jpg"); //read the image file
        BufferedImage img1 = null;
		
	
	try
	{
		img1 = ImageIO.read(file1);
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	   int img_width1 = img1.getWidth();
	   int img_height1 = img1.getHeight();
       System.out.println("W="+img1.getWidth()+", H="+img1.getHeight());
      
       int [][]r1=new int[img_width1][img_height1];
       int [][]g1=new int[img_width1][img_height1];
       int [][]b1=new int[img_width1][img_height1];
//extrate the inforamtion from bufferedimage and assign the values from each pixels
	   for(int i=0; i<img_width1;i++)
	{
	          for (int j=0;j<img_height1;j++ )

			{  
		        r1[i][j] =(img1.getRGB(i,j)>>16)&0xFF;
			    g1[i][j]=(img1.getRGB(i,j)>>8)&0xff;
				b1[i][j]=(img1.getRGB(i,j) &0xFF);
                 
	  
			}
	}
	 
         
		 
//convert two dimension array to one dimension r,g,b array
         int[] rarray1 = new int[img_width1*img_height1];
		 int[] garray1 = new int[img_width1*img_height1];
		 int[] barray1 = new int[img_width1*img_height1];
         for(int m = 0; m < img_height1; m ++) 
		 {
            for(int s = 0; s < img_width1; s ++)
				{
                rarray1[m * img_width1 + s] = r1[s][m];
                garray1[m * img_width1 + s] = g1[s][m];
                barray1[m * img_width1 + s] = b1[s][m];

				}
         }
		 int[] array1 =new int[3*rarray1.length];
		 for(int m=0;m<rarray1.length;m++)
		 {
			 array1[m]=rarray1[m];
			 array1[rarray1.length+m]=garray1[m];
			 array1[2*rarray1.length+m]=barray1[m];
		 }
		
		 
		File file2 = new File("hw2-4.jpg"); //read the image file
        BufferedImage img2 = null;
		
	
	try
	{
		img2 = ImageIO.read(file2);
	}
	catch(IOException e)
	{
		e.printStackTrace();
	}
	
	   int img_width2 = img2.getWidth();
	   int img_height2 = img2.getHeight();
       System.out.println("W="+img2.getWidth()+", H="+img2.getHeight());
      
       int [][]r2=new int[img_width2][img_height2];
       int [][]g2=new int[img_width2][img_height2];
       int [][]b2=new int[img_width2][img_height2];
//extrate the inforamtion from bufferedimage and assign the values from each pixels
	   for(int i=0; i<img_width2;i++)
	{
	          for (int j=0;j<img_height2;j++ )

			{  
		        r2[i][j] =(img2.getRGB(i,j)>>16)&0xFF;
			    g2[i][j]=(img2.getRGB(i,j)>>8)&0xff;
				b2[i][j]=(img2.getRGB(i,j) &0xFF);
                 
	  
			}
	}
	 
         
		 
//convert two dimension array to one dimension r,g,b array
         int[] rarray2 = new int[img_width2*img_height2];
		 int[] garray2 = new int[img_width2*img_height2];
		 int[] barray2 = new int[img_width2*img_height2];
         for(int m = 0; m < img_height2; m ++) 
		 {
            for(int s = 0; s < img_width2; s ++)
				{
                rarray2[m * img_width2 + s] = r2[s][m];
                garray2[m * img_width2 + s] = g2[s][m];
                barray2[m * img_width2 + s] = b2[s][m];

				}
         }
		 int[] array2 =new int[3*rarray2.length];
		 for(int m=0;m<rarray2.length;m++)
		 {
			 array2[m]=rarray2[m];
			 array2[rarray2.length+m]=garray2[m];
			 array2[2*rarray2.length+m]=barray2[m];
		 }
	
		int [][]arraybit=new int[array2.length][8];
		for (int a=0; a<array2.length;a++)
		{
			int temp1 = array2[a];
			for (int b=0; b<8;b++)
				{   
					arraybit[a][7-b]= temp1&1;
					temp1 =temp1>>>1;
				}
		}
		int[] array2bit=new int[array2.length*8];
		for(int e= 0; e< array2.length; e ++)
			{
				for(int f = 0; f< 8; f ++) 
					{
						array2bit[e * 8 + f] = arraybit[e][f];
					}	
			}
		
		int[] arrayleast1=new int[array1.length];
	
		   for(int m=0;m<array1.length;m++)
		 {
			 arrayleast1[m]=array1[m]&1;
		 } 
		 for(int i=0; i<array2bit.length;i++)
		{
			array1[i+pos]=add(arrayleast1[i+pos],array2bit[i],array1[i+pos]);
		}
		return array1;
		    
	}
	public static void main(String[] args)throws IOException
	{
		File file3 = new File("th.jpg"); //read the image file
        BufferedImage img3 = null;
		
	
	
		img3 = ImageIO.read(file3);
	
	
	
	   int img_width3 = img3.getWidth();
	   int img_height3= img3.getHeight();
		int[] finalarray=addPicture(0);
		int[] rf = new int[finalarray.length/3];
		int[] gf = new int[finalarray.length/3];
		int[] bf = new int[finalarray.length/3];
		 for(int m=0;m<finalarray.length/3;m++)
		 {
			 rf[m]=finalarray[m];
			 gf[m]=finalarray[m+finalarray.length/3];
			 bf[m]=finalarray[m+2*finalarray.length/3];
		 }
		 BufferedImage newImage1=new BufferedImage(img_width3,img_height3,BufferedImage.TYPE_INT_RGB); 
		
		for(int m = 0; m < rf.length; m ++) 
		{
			int rgb=new Color(rf[m],gf[m],bf[m]).getRGB();
			newImage1.setRGB(m%img_width3,m/img_width3,rgb);  
		}
         File outputfile=new File("hw2-4-7.jpg");

		ImageIO.write(newImage1, "jpg", outputfile);
		
	}

}