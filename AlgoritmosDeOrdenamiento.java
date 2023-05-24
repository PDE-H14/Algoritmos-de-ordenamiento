/**
 *
 * @author porfi
 */

import java.util.Arrays;

public class AlgoritmosDeOrdenamiento {
    
    public static void bubblesort(int[][] a, int ini, int fin) {
        int n = fin-ini;
        int temp, temp2;
        for(int i = 0; i<n-1;i++){
            for(int j=0;j<n-i;j++){
                if (a[j][0]>a[j+1][0]){
                    temp = a[j][0];
                    temp2 = a[j][1];
                    a[j][0] = a[j+1][0];
                    a[j][1] = a[j+1][1];
                    a[j+1][0] = temp;
                    a[j+1][1] = temp2;
                }
            }
        }
    } 
    
    public static void insertionsort(int[][] a, int ini, int fin){
        int n = fin - ini;
        int temp, temp2;
        for(int i = 0; i<=n; i++){
            for(int j = i;j>0;j--){
                if(a[j-1][0]>a[j][0]){
                    temp = a[j-1][0];
                    temp2 = a[j-1][1];
                    a[j-1][0] = a[j][0];
                    a[j-1][1] = a[j][1];
                    a[j][0] = temp;
                    a[j][1] = temp2;
                }
            }
        }
    }  
    
    public static void merge(int[][] a, int ini,int mitad, int fin){
        int[][] b = new int[fin+1][2];
        for(int i = ini; i<fin;i++){
            b[i][0] = a[i][0];
            b[i][1] = a[i][1];
        }
        int i = ini, j = mitad;
        for (int k = ini; k < fin; k++) {
            if (i < mitad && (j >= fin || b[i][0] <= b[j][0])) {
                a[k][0] = b[i][0];
                i = i + 1;
            } else {
                a[k][0] = b[j][0];
                j = j + 1;
            }
        }
    }

  public static void mergesort(int[][] a, int ini, int fin){
      int mitad;
      if (ini<fin){
          mitad = (fin+ini)/2;
          mergesort(a,ini,mitad);
          mergesort(a,mitad+1,fin);
          merge(a,ini,mitad,fin);
      }
  }

    
    public static void selectionSort (int[][] a, int n){
        int temp, temp2;
        for (int i = 0; i < n-1; i++)
        {
            int min_idx = i;
            for (int j = i+1; j < n; j++){
                if (a[j][0] < a[min_idx][0]){
                    min_idx = j;
                }
            }
            temp = a[min_idx][0];
            temp2 = a[min_idx][1];
            a[min_idx][0] = a[i][0];
            a[min_idx][1] = a[i][1];
            a[i][0] = temp;
            a[i][1] = temp2;
        }
    }
    
     public static int partition(int[][] a, int ini, int fin){
        int temp, temp2;
        int pivot = a[fin][0];
        for (int i = ini; i < fin; i++)
        {
            if (a[i][0] <= pivot)
            {
                temp = a[i][0];
                temp2 = a[i][1];
                a[i][0] = a[ini][0];
                a[i][1] = a[ini][1];
                a[ini][0] = temp;
                a[ini][1] = temp2;
                ini++;
            }
        }
        temp = a[fin][0];
        temp2 = a[fin][1];
        a[fin][0] = a[ini][0];
        a[fin][1] = a[ini][1];
        a[ini][0] = temp;
        a[ini][1] = temp2;
        return ini;
    }
     
    public static void quicksort(int[][] a, int ini, int fin){
        if (ini >= fin) {
            return;
        }
        int pivot = partition(a, ini, fin);
        quicksort(a, ini, pivot - 1);
        quicksort(a, pivot + 1, fin);
    }
    
    public static void shellsort(int[][] a, int ini, int fin){
        int n = fin -ini;
        int temp,comparaciones = 0, salto = 1023;
        do{
            for(int i = 0; i<n; i+=salto){
                for(int j = i;j>0;j-=salto){
                    comparaciones++;
                    if(a[j-1][0]>a[j][0]){
                        temp = a[j-1][0];
                        a[j-1][0] = a[j][0];
                        a[j][0] = temp;
                    }
                }
            }
            salto/=2;
        }while(salto!=0);
        System.out.println("Comparaciones: "+comparaciones);
    }

    public static void bricksort(int[][] a, int ini, int fin){
        int n = fin - ini;
        boolean ordenado = false;
        int temp, temp2;
        while(!ordenado){
            ordenado = true;
            for(int i=1;i<n;i+=2){
                if (a[i][0]>a[i+1][0]){
                    temp = a[i][0];
                    temp2 = a[i][1];
                    a[i][0] = a[i+1][0];
                    a[i][1] = a[i+1][1];
                    a[i+1][0] = temp;
                    a[i+1][1] = temp2;
                    ordenado = false;
                }
            }
            for(int j=0;j<n;j+=2){
                if (a[j][0]>a[j+1][0]){
                    temp = a[j][0];
                    temp2 = a[j][1];
                    a[j][0] = a[j+1][0];
                    a[j][1] = a[j+1][1];
                    a[j+1][0] = temp;
                    a[j+1][1] = temp2;
                    ordenado = false;
                }
            }
        }
    }
    
    public static void ordenar3(int[][] a, int ini, int fin){
        int k, temp;
        if (a[ini][0]>a[fin][0]){
            temp = a[ini][0];
            a[ini][0] = a[fin][0];
            a[fin][0] = temp;
        }
        if (ini+1>=fin){
            return;
        }
        k = (fin-ini+1)/3;
        ordenar3(a,ini,fin-k);
        ordenar3(a,ini+k,fin);
        ordenar3(a,ini,fin-k);
    }
    
    public static boolean binarySearchRec(int[][] a, int ini, int fin, int x){
        int mitad;
        if (ini>fin){
            return false;
        }
        if (ini==fin){
            return (a[ini][0]==x);
        }
        mitad = (ini+fin)/2;
        if (x == a[mitad][0]){
            return true;
        }
        if (x<a[mitad][0]){
            return binarySearchRec(a,ini,mitad-1,x);
        }else{
            return binarySearchRec(a,mitad+1,fin,x);
        }
    }
    
    public static int binarySearchIter(int[][] a, int ini, int fin, int x){
        int mitad;
        while(ini<=fin){
            mitad = (fin+ini)/2;
            if(x==a[mitad][0]){
                return mitad;
            } else {
                if(x<a[mitad][0]){
                    fin = mitad-1;
                } else {
                    ini=mitad+1;
                }
            }
        }
        return -1;
    }
    
    public static void hanoi(int discos, String inicio, String apoyo, String destino){
        if(discos==1){
            System.out.println("disco "+discos+": de "+inicio+" --> "+destino);
            return;
        }
        hanoi(discos-1, inicio, destino, apoyo);
        System.out.println("disco "+discos+": de "+inicio+" --> "+destino);
        hanoi(discos-1, apoyo, inicio, destino);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] a = {
            {0,1},{9,1},{-3,1},{5,1},{2,1},{6,1},{8,1},{-6,1},{1,1},{3,1},{-18,1},{-6,2},{1,2},{-6,3}
        };
        int[][] b = {
            {0,1},{9,1},{-3,1},{5,1},{2,1},{6,1},{8,1},{-6,1},{1,1},{3,1},{-18,1},{-6,2},{1,2},{-6,3}
        };
        int[][] c = {
            {0,1},{9,1},{-3,1},{5,1},{2,1},{6,1},{8,1},{-6,1},{1,1},{3,1},{-18,1},{-6,2},{1,2},{-6,3}
        };
        int[][] d = {
            {0,1},{9,1},{-3,1},{5,1},{2,1},{6,1},{8,1},{-6,1},{1,1},{3,1},{-18,1},{-6,2},{1,2},{-6,3}
        };
        int[][] e = {
            {0,1},{9,1},{-3,1},{5,1},{2,1},{6,1},{8,1},{-6,1},{1,1},{3,1},{-18,1},{-6,2},{1,2},{-6,3}
        };
        int[][] f = {
            {0,1},{9,1},{-3,1},{5,1},{2,1},{6,1},{8,1},{-6,1},{1,1},{3,1},{-18,1},{-6,2},{1,2},{-6,3}
        };
        int[][] g = {
            {0,1},{9,1},{-3,1},{5,1},{2,1},{6,1},{8,1},{-6,1},{1,1},{3,1},{-18,1},{-6,2},{1,2},{-6,3}
        };
        int[][] h = {
            {0,1},{9,1},{-3,1},{5,1},{2,1},{6,1},{8,1},{-6,1},{1,1},{3,1},{-18,1},{-6,2},{1,2},{-6,3}
        };
        
        System.out.println("Arreglo inicial:"+Arrays.deepToString(a));
        bubblesort(a, 0, 13);
        bricksort(b, 0, 13);
        ordenar3(c,0,13);
        insertionsort(d,0,13);
        shellsort(e,0,13);
        quicksort(f, 0,13);
        mergesort(g,0,13);
        selectionSort(h,14);
        System.out.println("Arreglo ordenado (Bubble sort):"+Arrays.deepToString(a));
        System.out.println("Arreglo ordenado (Brick sort):"+Arrays.deepToString(b));
        System.out.println("Arreglo ordenado (ordenar3):"+Arrays.deepToString(c));
        System.out.println("Arreglo ordenado (Insertion sort):"+Arrays.deepToString(d));
        System.out.println("Arreglo ordenado (Shell sort):"+Arrays.deepToString(e));
        System.out.println("Arreglo ordenado (Quick sort):"+Arrays.deepToString(f));
        System.out.println("Arreglo ordenado (Merge sort):"+Arrays.deepToString(g));
        System.out.println("Arreglo ordenado (Selection sort):"+Arrays.deepToString(h));
        hanoi(3,"A","aux", "B");
        System.out.println("¿Está el 3 en mi arreglo? Busqueda recursiva: "+binarySearchRec(a, 0, 12, 3));
        int i = binarySearchIter(a, 0, 12, 3);
        System.out.println("¿Está el 3 en mi arreglo? Busqueda iterativa: "+i+" elemento buscado: "+(i>=0?a[i]:"No está en el arreglo"));
        
    }
}
