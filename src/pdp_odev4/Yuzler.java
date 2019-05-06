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
public class Yuzler implements Runnable{
    static int size=0;
    static int[][] matris;
    static int yuzler1=0;
    
    Yuzler(int[][] matris,int size){
        this.size=size;
        this.matris=matris;
    }
  

    @Override
    public void run() // matrisin yüzler basamağını toplar 
    {
        for(int i=0;i<size;i++){            
                    yuzler1+=matris[i][1];                          
        }
        
    }
}