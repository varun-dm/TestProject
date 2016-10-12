package query;

import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class FileQuery {

    /** Dumb function to query an image name in a command-line
     * application and load it to a BufferedImage.
     *
     * @return the loaded image if succesful, null otherwise
     */
    static public BufferedImage queryFileIn()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Entrer le nom de l'image à charger :");
        String filename = sc.nextLine();
        
        try{
            File pathToFile = new File(filename);
            return ImageIO.read(pathToFile);
        } catch (IOException e) {
            System.err.println("Could not load Image !");
            return null;
        }
    }
    
    /** Dumb function save a BufferedImage to a file which filename
     * is queried in a command-line application.
     *
     * @param img the image to save
     */
    static public void queryFileOut(BufferedImage img)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Entrer le nom de l'image à sauvegarder :");
        String filename = new String("Res.jpg");
//        String filename = sc.nextLine();
        
        try{
            File pathToFile = new File(filename);
            ImageIO.write(img, "jpg", pathToFile);
        } catch (IOException e) {
            System.err.println("Could not save Image !");
        }
    }

}