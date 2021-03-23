import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.*;
import java.awt.image.Raster;
import java.lang.*;
import java.awt.Color;
class  Add11{
//define method add(int x, int y, int z),in order to change the last bit of the r,g,b
         public static int add(int x, int y, int z){
		   if (x==0 && y==1){
			   z=z+1;
		   }else if (x==1 && y==0){
			   z= z-1;
		   }
		   else
		   {
			   
		   }
			 return z;
           
		 }
		 
//define method addXu(int x1), in order to random select a position to embed the Xu
    public static void addXu(int x1){

		File file = new File("hw2.jpg"); //read the image file
        BufferedImage img = null;
		
	
	try {
       img = ImageIO.read(new File("hw2.jpg"));
	   int img_width = img.getWidth();
	   int img_height = img.getHeight();
       System.out.println("W="+img.getWidth()+", H="+img.getHeight());
      
       int [][]r=new int[img_width][img_height];
       int [][]g=new int[img_width][img_height];
       int [][]b=new int[img_width][img_height];
//extrate the inforamtion from bufferedimage and assign the values from each pixels
	   for(int i=0; i<img_width;i++) {
	          for (int j=0;j<img_height;j++ )

	   {  
		        r[i][j] =(img.getRGB(i,j)>>16)&0xFF;
			    g [i][j]=(img.getRGB(i,j)>>8)&0xff;
				b[i][j]=(img.getRGB(i,j) &0xFF);
                 
	  
	   }
	   }
	 
          int[]Xu={0,0,1,0,1,1,0,0,0,0,0,1,0,1,0,1,0,1};
		 
//convert two dimension array to one dimension r,g,b array
         int[] rarray = new int[img_width*img_height];
		 int[] garray = new int[img_width*img_height];
		 int[] barray = new int[img_width*img_height];
         for(int m = 0; m < img_height; m ++) {
            for(int s = 0; s < img_width; s ++) {
                rarray[m * img_width + s] = r[s][m];
                garray[m * img_width + s] = g[s][m];
                barray[m * img_width + s] = b[s][m];

            }
         }
		    
	    // System.out.println();
		 
		 //define a one dimension array which include continue 6 r,g,b {r[x1],g[x1],b[x1]...}
            int[]sp= new int[18];
		    int counter =0;
		    for (int t=x1;t<x1+6 ;t++ ){
			 sp[counter*3+0]= rarray[t];
			 sp[counter*3+1]= garray[t];
			 sp[counter*3+2]= barray[t];
			 
			 counter++;
		 }
		     
	   //define a one dimension array which include the last bit of the continue 6 r,g,b
	     int[]last= new int[18];
		 int counter1 =0;
		 for (int q=x1;q<x1+6 ;q++ ){
			 last[counter1*3+0]= rarray[q]&1;
			 last[counter1*3+1]= garray[q]&1;
			 last[counter1*3+2]= barray[q]&1;
			 counter1++;
		 }
		 for (int p1=0;p1<18 ;p1++ ){
			 System.out.print(last[p1]+"  ");
		 }
			 
       System.out.println();
	   //embed Xu into the picture
    
		int[] sp1=new int[18];
	  for (int k=0;k<18 ;k++ ){

      sp1[k]= add(last[k],Xu[k],sp[k]);
	  
	  System.out.print(sp1[k]+"  ");

       }
	 System.out.println();
	
	  //get the new r,g,b, and write into the image hw2-4.png
	     int counter2=0;
         for (int c=x1;c<x1+6 ;c++ ){
			 rarray[c] =sp1[counter2*3+0];
			 garray[c]= sp1[counter2*3+1] ;
			 barray[c]= sp1[counter2*3+2] ;
			
			 counter2++;
		 }
	   
       
       
	   for (int a=x1;a<x1+6 ;a++ ){
		
		int rgb=new Color(rarray[a],garray[a],barray[a]).getRGB();
		  
		   

    

		   img.setRGB(a%img_width,a/img_width,rgb); 
		   }

			 

		File outputfile=new File("hw2-4.png");
		ImageIO.write(img, "png", outputfile);
	}catch (IOException e){e.printStackTrace();}
	}

		 public static void main(String[] args) {
	//call the method addXu, and assign the initial location
	       addXu(281);  
          system.out.println(45522/16);
}

}	 
	

