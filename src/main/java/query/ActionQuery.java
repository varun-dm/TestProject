package query;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

import process.Kernel;

public class ActionQuery {

    /** Query a kernel in the command line
     *
     * @return the kernel as a vector of 9 floats
     */
    static public Kernel queryKernel()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Either enter 'const' or 'sobelX' or 'sobelY' :");

        String input = sc.nextLine();
        
        float[] values;
        int n;
        
        if(input.equals("sobelX")){
            values = new float[] {
                -0.5f, 0.0f, 0.5f,
                -1.0f, 0.0f, 1.0f,
                -0.5f, 0.0f, 0.5f,
            };
            n=3;
        } else if(input.equals("sobelY")){
            values = new float[] {
                -0.5f, -1.0f, -0.5f,
                 0.0f,  0.0f,  0.0f,
                 0.5f,  1.0f,  0.5f,
            };
            n=3;
        } else {
            if(!input.equals("const")) System.err.println("Assume it was written 'const'...");

            System.out.println("Enter size (should be odd) :");
            n = sc.nextInt();
            values = new float[n*n];
            float d = 1.0f/((float)(n*n));
            for(int i=0; i<n*n; ++i) {
                values[i]=d;
            }
        }

        return new Kernel(values,n);
    }
    
    /** Query a number of steps
     *
     * @return a number of steps 
     */
    static public int queryNbStep()
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Entrer le nombre de fois que le noyaux doit être appliqué :");
        int nb_step = sc.nextInt();
        
        return nb_step;
    }

}