import java.util.Random;
import java.util.Scanner;
public class Main
{
    //----- Crea un arreglo de un tamaño dado y lo llena con enteros pseudoaleatorios -----
    private static int[] datos; // arreglo de valores
    private static final Random generador = new Random();

    //------ Constructor -----------
    public Main(int tamanio) {
        datos = new int[tamanio]; // crea espacio para el arreglo
        // llena el arreglo con enteros aleatorios en el rango de 10 a 99
        for (int i = 0; i < tamanio; i++)
            datos[i] = 10 + generador.nextInt(90);
    }
    //Inicio del metodo bubble
    static void Burbuja(int[] b, int p) {
        int i, j, temp;

        for (i = 0; i <= p; i++) {
            for (j = 0; j < p - 1; j++) {
                if (b[j] > b[j + 1]) {
                    temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }
    }
    //Inicio del metodo de inserción
    static void insercionDirecta(int[] b) {
        int i, j, k;

        for (j = 1; j < b.length; j++) {
            i = j - 1;
            k = b[j];
            while (i >= 0)
                if (k < b[i]) {
                    b[i + 1] = b[i];
                    i = i - 1;
                } else
                    break;
            b[i + 1] = k;
        }
    }
    //Inicio del metodo quicksort
    static void QuickSort(int[] b, int izq, int der) {
        int i, j, v, aux;
        i = izq;
        j = der;
        v = b[(izq + der) / 2];

        do {
            while ((b[i] < v) && (j <= der))
                i++;
            while ((v < b[j]) && (j > izq))
                j--;
            if (i <= j) {
                aux = b[i];
                b[i] = b[j];
                b[j] = aux;
                i++;
                j--;
            }
        } while (i <= j);
        if (izq < j)
            QuickSort(b, izq, j);
        if (i < der)
            QuickSort(b, i, der);
    }
//Inicio del metodo shellsort
 static void shellsort(int[] a) {
        // Utiliza la secuencia de incrementos de Gonet


        for (int gap = a.length / 2; gap > 0; gap = gap == 2 ? 1 : (int) (gap / 2.2)){

            for (int i = gap; i < a.length; i++) {
                int tmp = a[i];
                int j = i;
                for (; j >= gap && (a[j - gap] > tmp); j -= gap)
                    a[j] = a[j - gap];
                a[j] = tmp;
            }
        }


    }
    //Inicio del metodo selección
    static void seleccion(int A[]) {
        int i, j, menor, pos, tmp;
        for (i = 0; i < A.length - 1; i++) { // Tomamos como menor el primero
            menor = A[i]; // De los elementos que quedan por ordenar
            pos = i; // y guardamos su posición
            for (j = i + 1; j < A.length; j++) { // buscamos en el resto
                if (A[j] < menor) { // Del array algún elemento
                    menor = A[j]; // Menor que el actual
                    pos = j;
                }
            }
            if (pos != i) { // Si hay alguno menor se intercambia
                tmp = A[i];
                A[i] = A[pos];
                A[pos] = tmp;
            }
        }
    }

    //Inicio
    public static void main( String[] args )
    {
        Scanner teclado = new Scanner(System.in);
        int option;
        long t1;
        long t2;
        int cantidadDatos;

        System.out.println("Bienvenid@ al benchnmark\nDigite la cantidad de datos a ordenar:");
        System.out.println("Recuerde que entre mas grande el valor del ordenamiento mas tiempo conlleva realizar el calculo:");
        cantidadDatos = teclado.nextInt();

        // Constructor.
        Main arregloOrden = new Main(cantidadDatos);


        System.out.println("Ingresa el arreglo a probar:\nEl resultado se mostrará en milisegundos");
        System.out.println("1) Burbuja(Mas Lento)\n2) Insercción\n3) ShellSort\n4)QuickSort(Mas Rapido\n5) Selección");
        option = teclado.nextInt();



        switch (option) {
            case 1:
                System.out.println("Burbuja:");
                t1 = System.currentTimeMillis();
                Main.Burbuja(Main.datos, datos.length);
                t2 = System.currentTimeMillis();
                System.out.println((t2 - t1) + " ms");
                break;
            case 2:
                System.out.println("InsercciónDirecta:");
                t1 = System.currentTimeMillis();
                Main.insercionDirecta(arregloOrden.datos);
                t2 = System.currentTimeMillis();
                System.out.println((t2 - t1) + " ms");
                break;
            case 3:
                System.out.println("ShellSort:");
                t1 = System.currentTimeMillis();
                Main.shellsort(Main.datos);
                t2 = System.currentTimeMillis();
                System.out.println((t2 - t1) + " ms");
                break;
            case 4:
                System.out.println("QuickSort:");
                t1 = System.currentTimeMillis();
                Main.QuickSort(Main.datos, 0, datos.length - 1);
                t2 = System.currentTimeMillis();
                System.out.println((t2 - t1) + " ms");
                break;
            case 5:
                System.out.println("Selección:");
                t1 = System.currentTimeMillis();
                Main.seleccion(Main.datos);
                t2 = System.currentTimeMillis();
                System.out.println((t2 - t1) + " ms");
                break;
            default:
                System.out.println("No existe esa opción, intenta de nuevo");
                break;
        }

        // -------------- Impresión de datos -------------------
        /*int l;
        for(l = 0; l < datos.length; l++)
            System.out.print(arregloOrden.datos[l] + " ");
        System.out.println();*/
    }
}
