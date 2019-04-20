/**
 * Write a description of GrayScaleConverter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.io.*;

public class GrayScaleConverter {
    public ImageResource makeGray(ImageResource inImage) {
       ImageResource outImage = new ImageResource(inImage.getWidth(), inImage.getHeight());
       for(Pixel pixel: outImage.pixels()){
           Pixel inPixel = inImage.getPixel(pixel.getX(), pixel.getY());
           int average = (inPixel.getRed() + inPixel.getBlue() + inPixel.getGreen())/3;
           pixel.setRed(average);
           pixel.setGreen(average);
           pixel.setBlue(average);
       }
        return outImage; 
    }
    public void testGray() {
        ImageResource ir = new ImageResource();
        ImageResource gray = makeGray(ir);
        gray.draw();
    }
    public void selectAndConvert() {
        DirectoryResource dr = new DirectoryResource();
        for (File f: dr.selectedFiles()){
            ImageResource inImage = new ImageResource(f);
            String fname = inImage.getFileName();
            String newName = "gray-" + fname;
            ImageResource gray = makeGray(inImage);
            gray.setFileName(newName);
            gray.draw();
            gray.save();
        }
    }
}