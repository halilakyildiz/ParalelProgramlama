/**
*
* @author Halil AKYILDIZ  halil.akyildiz@ogr.sakarya.edu.tr
* @since 2.05.2019
* <p>
*  Bu ödev kendime aittir ve herhangi kopya durumunda sorumluluk bana aittir.
* </p>
*/
package pdp_odev4;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 *
 * @author AKYILDIZ-PC
 */

public class PDP_Odev4 {

    /**
     * @param args the command line arguments
     */
    public static ArrayList<String> veri = new ArrayList<String>();
    
    
    static int[][] matris;
    public static void MatriseEkle() // Dosyadaki sayıları matrise alır
    {
       matris = new int[veri.size()][4];
        for(int i =0;i<veri.size();i++){
            String dizi = veri.get(i); // sıradaki satırı alır
            int sayac=1;
            for(int j=0;j<dizi.length();j++){
                String rakam= dizi.substring(j, sayac); // satırı karakter karakter alır
                sayac++; //bir sonraki sayı için arttırılır
                matris[i][j]=Integer.valueOf(rakam); // sayıyı matristeki yerine atar
            }
        }
        
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        String str="";         
        
        // dosyayı satır satır okuyup ArrayListe alır ( internetten hazır aldım)
        try{
            FileInputStream fstream=new FileInputStream("Sayilar.txt");
            DataInputStream dstream=new DataInputStream(fstream);
            BufferedReader breader=new BufferedReader(new InputStreamReader(dstream));            
          
            while((str = breader.readLine()) != null){
                veri.add(str);                
            }
           dstream.close();
        }
        catch(Exception e){
            System.out.println("Hata!!!" + e.getMessage());
        }
        
        MatriseEkle();
        
        int baslangicSeri=(int)System.nanoTime(); // Sistemin Seri Hesaplamadan önceki zaman değerini(nanosaniye) alır 
        SeriHesaplama s1 = new SeriHesaplama(matris,veri.size()); 
        int bitisSeri=(int)System.nanoTime(); // Sistemin Seri Hesaplamadan sonraki zaman değerini(nanosaniye) alır 
        
        // Paralel hesaplama için her toplama işlemi için ayrı Thread oluşurdum
        Thread binler=new Thread(new Binler(matris,veri.size()));
        Thread yuzler=new Thread(new Yuzler(matris,veri.size()));
        Thread onlar=new Thread(new Onlar(matris,veri.size()));
        Thread birler=new Thread(new Birler(matris,veri.size()));
        
        int baslangicParalel = (int)System.nanoTime(); // Paralel H önceki zaman değerini alır
        binler.start();
        yuzler.start();
        onlar.start();
        birler.start();
        int bitisParalel=(int)System.nanoTime();// Paralel H sonraki zaman değerini alır
        
        float sureSeri=(float)(bitisSeri-baslangicSeri)/1000000; //çıkan süre milisaniyeye dönüştürlür
        System.out.println("Seri Hesaplama Süresi: "+sureSeri +" milisaniye\n");
        
        float sureParalel=(float)(bitisParalel-baslangicParalel)/1000000;
        System.out.println("Paralel Hesaplama Süresi: "+sureParalel +" milisaniye\n");
       
        
        
        
    }
    
}
