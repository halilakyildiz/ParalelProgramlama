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
public class SeriHesaplama {
    
    static int[][] matris;
    static int binler=0,yuzler=0,onlar=0,birler=0;
    static int size=0;
  
    SeriHesaplama(int[][] matris,int size) {
        this.matris=matris;
        this.size=size;
        Topla();
        Yazdir();        
    }
    public  void Topla() // Matrisin her basamağını kendi aralarında toplar
    {      
        for(int i=0;i<size;i++){            
                binler+=matris[i][0];
                yuzler+=matris[i][1];
                onlar+=matris[i][2];
                birler+=matris[i][3];            
        }        
    }
    void Yazdir() // sonucu ekrana yazar
    {
        System.out.println("Sonuç: "+binler+yuzler+onlar+birler + "\n");
    }
}
