import query.FileQuery;
import query.ActionQuery;
import process.ProcessImage;
import process.Kernel;

import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Main {
    
    /** A wonderful program!
     */
    public static void main(String[] args)
    {
        BufferedImage img = FileQuery.queryFileIn();
        if(img!=null)
        {
            Kernel k = ActionQuery.queryKernel();
            int nb_steps = ActionQuery.queryNbStep();
            
            BufferedImage res;
            
            res = ProcessImage.processing(img, k, nb_steps);


            FileQuery.queryFileOut(res);
        }
    }
    
    
}
