/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libreriaedwhercar;
import java.util.Scanner;
/**
 *
 * @author edwar
 */
public class LibreriaEdwHerCar  {
/**
* @param args the command line arguments
*/  
    //llenado del arreglo
  public static int [ ] llenarArreglo ( int elementos ) {
    int i; int [ ] v; 
    v = new int [ elementos ];
    Scanner sc = new Scanner ( System.in );

    for ( i = 0; i < elementos; i++ ) {
      System.out.print ( "Elemento No.  " + (i+1) + "  = " );
      v [ i ] = sc.nextInt ( ); 
    }

    return v;
  }
    //Calcular la media aritmetica
  public static double promedio ( int [ ] v ) {
    double prom = 0.0;
    for ( int i = 0; i < v.length; i++ )
      prom += v[i];

    return prom / ( double ) v.length;  
  }
    //Calculando la desviacion estandar
  public static double desviacion ( int [ ] v ) {
    double prom, sum = 0; int i, n = v.length;
    prom = promedio ( v );

    for ( i = 0; i < n; i++ ) 
      sum += Math.pow ( v [ i ] - prom, 2 );

    return Math.sqrt ( sum / ( double ) n );
  }
    //Calculando la mediana
  public static double mediana ( int [ ] v ) {
    int pos = 0, n = v.length;
    double temp = 0, temp0 = 0;    
    // ordenar de menor a mayor
    v = burbuja ( v, 0 );

    temp = n / 2;
    if ( n % 2 == 0 ) {
      pos = (int)temp;      
      temp0 = (double)(v [ pos ] / v [ pos + 1 ]);
    }
    if ( n % 2 == 1 ) {
      pos = (int)(temp + 0.5);
      temp0 = (double)(v [ pos ]);  
    }

    return temp0;
  }
    //Calcular el rango
  public static int rango ( int [ ] v ) {
    // ordenar de mayor a menor
    v = burbuja ( v, 1 );
    
    return v [ v.length - 1 ] - v [ 0 ];
  }
    //Calcular la moda
  public static int moda ( int [ ] v ) {
    int i, j, moda = 0, n = v.length, frec;
    int frecTemp, frecModa = 0, moda1 = -1; 
  
    // ordenar de menor a mayor
    v = burbuja ( v, 0 );
    
    for ( i = 0; i < n; i++ ) {
      frecTemp = 1; 
      for ( j = i + 1; j < n; j++ ) {
        if ( v [ i ] == v [ j ] )
          frecTemp++;
      }
      if ( frecTemp > frecModa ) {
        frecModa = frecTemp;
        moda1 = v [ i ];
      }
    }
    return moda1;
  }
    //Ordenamiento
  public static int [ ] burbuja ( int [ ] v, int ord ) {
    int i, j, n = v.length, aux = 0;
    
    for ( i = 0; i < n - 1; i++ )
      for ( j = i + 1; j < n; j++ )
        if ( ord == 0 )
          if ( v [ i ] > v [ j ] ) {
            aux = v [ j ];
            v [ j ] = v [ i ];
            v [ i ] = aux;
          }
        else if ( ord == 1 )
          if ( v [ i ] < v [ j ] ) {
            aux = v [ i ];
            v [ i ] = v [ j ];
            v [ j ] = aux;
          }

    return v;
  }
    //Imprimir el arreglo ordenado
  public static void imprimirArreglo ( int [ ] v ) {
    for ( int i = 0; i < v.length; i++ )
      System.out.print ( v [ i ] + " " );
    System.out.println ( "" );
  }
    //Buscar un numero en espesifico dentro del arreglo
  public static int busquedaArreglo(int numbus, int[] v)
        {
        int pos=0;
        boolean presencia=false;
        
        //*****************************Intruducir el numero a buscar************************//
        
        //Verificar en que posicion esta o iria
        for(int i=0; i<v.length; i++){
            if(numbus == v[i]){
                presencia = true;
                pos = i;
            }
        }
 
        //*********************************Resultados**********************************//
        if(presencia){
            System.out.println("El numero "+numbus+" se encuentra en la posicion "+ (pos+1));
        }
        else{
            System.out.println("El numero no se encuentra en el arreglo");
        }
      return pos;
    }
  public static void main ( String [ ] args ) {
    int n; int numbus=0; int [] v;
    double media, mediana, moda, rango, desviacion;
    Scanner sc = new Scanner ( System.in );
    System.out.println ( "Dimension Arreglo : ");
    n = sc.nextInt ( );

    v = llenarArreglo ( n );
    media = promedio ( v );
    mediana = mediana ( v );    
    moda = moda ( v );
    rango = rango ( v );      
    desviacion = desviacion ( v );
    System.out.println ( " Moda del vector: " + moda);
    System.out.println ( " Media del vector: " + media);
    System.out.println ( " Mediana del vector: " + mediana);
    System.out.println ( " Rango del vector: " + rango);
    System.out.println ( " Desviacion del vector: " + desviacion);
    System.out.println("Tu arreglo ordenado es:");
    imprimirArreglo ( v );
    System.out.println("Escribe el numero que deseas buscar");
    numbus=sc.nextInt ( );
    busquedaArreglo( numbus, v);
  }
}
