package process;

import java.awt.image.BufferedImage;
import java.lang.Math;

public class ProcessImage {

    /** Dumb function to perform a convolution by a specific filter^n.
     *
     * @deprecated
     *
     * @param srcImg the image on which to apply the convolution kernel
     * @param kernel the kernel to be applied
     * @param n the 'size' of the kernel (n*n)
     * @param nb_steps the number of time the kernel should be applied (equivalent to ...)
     *
     * @return the result of the convolution
     */
    static public BufferedImage processing(BufferedImage srcImg, Kernel k, int nb_steps)
    {
        BufferedImage res;
        if(nb_steps%2==0) {
            res = srcImg;
        } else {
            res = ProcessImage.convolution(srcImg, k);
        }
        
        BufferedImage tmp;
        for(int i=0; i<nb_steps/2; ++i) {
            tmp = ProcessImage.convolution(res, k);
            res = ProcessImage.convolution(tmp, k);
        }

        return res;
    }
    
    /** Dumb function to perform a convolution by a specific filter.
     *
     * @param srcImg the image on which to apply the convolution kernel
     * @param kernel the kernel to be applied
     * @param n the 'size' of the kernel (n*n)
     *
     * @deprecated
     *
     * @return the result of the convolution
     */
    static public BufferedImage convolution(BufferedImage srcImg, Kernel k)
    {
        int n = k.getN();
        float[] vals = k.getValues();
        
        int imgHeight = srcImg.getHeight();
        int imgWidth = srcImg.getWidth();

        BufferedImage resImg = new BufferedImage(imgWidth, imgHeight, srcImg.getType());

        for (int y = 0; y < imgHeight-n; y++)
        {
            for (int x = 0; x < imgWidth-n; x++)
            {
                double resR = 0.0, resG = 0.0, resB = 0.0;
                
                for (int i = 0; i<n; ++i) {
                    for (int j = 0; j<n; ++j) {
                        int Color = srcImg.getRGB(x+i,y+j);
                        int R = (Color >> 16) & 0xff;
                        int G = (Color >> 8) & 0xff;
                        int B = Color & 0xff;

                        resR += ((double)R)*vals[n*i+j];
                        resG += ((double)G)*vals[n*i+j];
                        resB += ((double)B)*vals[n*i+j];
                    }
                }
                
                int cRes = 0xff000000 | (((int)Math.abs(resR)) << 16)
                                      | (((int)Math.abs(resG)) << 8)
                                      | ((int)Math.abs(resB));
                resImg.setRGB(x,y,cRes);
            }
        }

        return resImg;
    }
    
}