import edu.duke.*;
import java.io.*;
public class GrayScale {
    public ImageResource makeGray(ImageResource inImage){
        ImageResource out= new ImageResource(inImage.getWidth(),inImage.getHeight());
        for(Pixel pix: out.pixels()){
            Pixel inpix=inImage.getPixel(pix.getX(),pix.getY());
            int avg=(inpix.getRed()+inpix.getGreen()+inpix.getBlue())/3;
            pix.setRed(avg);
            pix.setGreen(avg);
            pix.setBlue(avg);
        }
        return out;
    }
    
    public void testGray(){
        ImageResource ir= new ImageResource();
        ImageResource gray= makeGray(ir);
        gray.draw();
    }
    public void selectAndConvert(){
        DirectoryResource dr= new DirectoryResource();
        for(File f: dr.selectedFiles()){
            ImageResource inImage= new ImageResource(f);
            String fname=inImage.getFileName();
            String newName="Copy-"+fname;
            ImageResource gray= makeGray(inImage);
            gray.setFileName(newName);
            gray.draw();
            gray.save();
        }
    }
}
