/**
*
* @author Halil AKYILDIZ  halil.akyildiz@ogr.sakarya.edu.tr
* @since 2.05.2019
* <p>
*  Bu ödev kendime aittir ve herhangi kopya durumunda sorumluluk bana aittir.
* </p>
*/
package pdp_odev4;

/**
 *
 * @author AKYILDIZ-PC
 */
public class Birler implements Runnable{
    static int size=0;
    static int[][] matris;
    static int birler1=0;
    
    Birler(int[][] matris,int size){
        this.size=size;
        this.matris=matris;
    }
 
    @Override
    public void run()// matrisin birler basmaağını toplar
    {
         for(int i=0;i<size;i++){            
                birler1+=matris[i][3];                          
        }
         
    }
}
