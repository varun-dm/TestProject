package imgprocwrapper;

import java.awt.image.BufferedImage;

import ij.ImagePlus;
import ij.process.ImageProcessor;

public class ImgProcWrapper {
    
    static public BufferedImage convolve(BufferedImage bufferedImg, float[] kernel, int n)
    {
        ImagePlus imgPlus = new ImagePlus("tmp", bufferedImg);
        
        ImageProcessor imgProc = imgPlus.getProcessor();
        imgProc.convolve(kernel,n,n);
        
        return imgPlus.getBufferedImage();
    }
    
    static public BufferedImage blurGaussian(BufferedImage bufferedImg, float sigma)
    {
        ImagePlus imgPlus = new ImagePlus("tmp", bufferedImg);

        ImageProcessor imgProc = imgPlus.getProcessor();
        imgProc.blurGaussian(sigma);
        
        return imgPlus.getBufferedImage();
    }

}
