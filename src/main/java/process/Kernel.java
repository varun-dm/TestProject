package process;

import java.lang.Math;

/** Function representing a square filter.
 * Assume the filter is size is   
 *      n x n
 * where n is odd.
 */
public class Kernel {
    private int n;
    private float[] v;
    
    public Kernel(float[] vals, int nb) {
        v=vals;
        n=nb;
    }
    
    public int getN(){
        return n;
    }
    public float[] getValues(){
        return v;
    }
}