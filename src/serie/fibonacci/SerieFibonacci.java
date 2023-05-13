package serie.fibonacci;

import java.util.Scanner;

public class SerieFibonacci {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        long [] serie = new long[100];
        double tinicial, tfinal;
        long tot;
        int n, esc;
        serie[1]= 0;
        serie[2]= 1;
        
        System.out.println("que opcion desea    1. sin recursividad, 2. con recursividad");
        esc = leer.nextInt();
        if (esc == 1){
            System.out.println("Digite la cantidad de terminos");
            n = leer.nextInt(); 
            tinicial = System.nanoTime(); // nanoTime();  // currentTimeMillis();
            generarSin(n, serie);            
            tot = sumarSin(n, serie);
            tfinal = System.nanoTime();
            System.out.println("la suma de los "+n+" primeros terminos de la serie de fibonacci es "+ tot);
            System.out.println("tiempo(segundos) = " + (double)(tfinal - tinicial)/1000000);
        } else {
            int contador = 1;
            int guardar = 1;
            int pos = 1;
            System.out.println("Digite la cantidad de terminos");
            n = leer.nextInt();
            tinicial = System.nanoTime();
            guardarSerie(n, serie, guardar, pos);            
            tot = sumarCon(n, serie, contador);
            tfinal = System.nanoTime();
            System.out.println("la suma de los "+n+" primeros terminos de la serie de fibonacci es "+ tot);
            System.out.println("tiempo(segundos) = " + (double)(tfinal - tinicial)/1000000);
        }
    }   

    public static void generarSin(int lim, long suce[]){
        for (int i = 3; i <= lim+1; i++) {
            suce[i] = suce[i-2] + suce[i-1];
        }
    }
    
    public static void guardarSerie(int lim, long suce[], long valor, int i){
        if (i <= lim){
            suce[i] = generarCon(valor);
            guardarSerie(lim, suce,valor+1,i+1);
        }
    }
    
    public static long generarCon(long pos){
        if (pos == 0 || pos == 1){
            return pos;
        } else {
            return generarCon(pos-1)+ generarCon(pos-2);
        }
    }
    
    public static long sumarSin(int lim, long serie []){
        long res = 0;
        for (int i = 1; i <= lim +1; i++) {
            res = res + serie[i];
        }
        return res;
    }
    public static long sumarCon(int lim, long serie [], int i){
        if (i <= lim){
            return serie[i] + sumarCon(lim,serie, i + 1);
        } else {
            return 0;
        }
    }
}