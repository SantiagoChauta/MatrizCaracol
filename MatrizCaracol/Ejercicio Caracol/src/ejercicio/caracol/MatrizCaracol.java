
package ejercicio.caracol;

public class MatrizCaracol {
    private int n;//tamaño del que debera ser la matriz de la forma n*n
    private String matriz[][];//matriz de tamaño n*n
    private String numeros[];//vector de tamaño n*n
    private int limites;//se igual al numero de filas o de columna
    private int k=0;// contador para poder acceder al arreglo numeros
    private int i=0;//contador para las filas de la matriz
    private int j=0;//contador para las columnas de la matriz
    private int imitadorfilas=0;//copia el valor de limites, solo se usa en las funciones que trabajan las filas
    private int imitadorcolumnas=0;//copia el valor de limites, solo se usa en las funciones que trabajan las columnas
    private int numejecucionesLiBi=0;//numero de ejecuciones del metodo LineasBien
    private int numejecucionesColAba=0;//numero de ejecuciones del metodo ColumnasAbajo
    private String arraylist=" ";
    private int h=0;//contador para ejecutar los metodos con un ciclo for
    
    public MatrizCaracol(int tamaño, String[][] string){//se encarga de recibir el tamaño de la matriz 
        this.n=tamaño;//se igual al tamaño
        this.matriz=string;//se crea la matriz
        this.numeros=new String[n*n];//se crea el vector
        this.limites=n;//se establecen los limites de la matriz
    }
    public void CargarMatriz(){//se encarga de cargar los datos de la matriz
        for(i=0;i<n;i++){
            for(j=0;j<n;j++){
                numeros[k]=matriz[i][j];//Se llena el vector
                System.out.print(numeros[k]+" ");
                k++;    
            }
            System.out.println("");
        }
        System.out.println("");
        k=0;
    }
    public void Lineabien(){//se encarga de leer las filas de izquierda a derecha
        if(numejecucionesLiBi==0){//el numero de ejeciones evita que la variable k no sea la misma que en la ejecucion anterior
            k=n*numejecucionesLiBi;
        }
        else{
            k=n*numejecucionesLiBi;//k va a ser igual al numero de ejecuiones por el tamaño de la matriz
            k+=numejecucionesLiBi;//se le suma el numero de ejeciones para que k corresponda con la columa a leerse
            
        }
        for(h=0;h<limites;h++){//se ejecuta el ciclo hasta que h sea mayor o igual a los limites de la matriz
            arraylist+=numeros[k]+" ";
            k++;
        }
        k--;//como a k se le suma un 1 de mas, toca restaselo para que la opercion se realice correctamente
        numejecucionesLiBi++;//por cada ejecucion de la funcion de le suma 1
    }
    
    public void ColumnaAbajo(){// se encarga de imprimir los datos de las columnas de arriba a abajo
        k+=n;//El numero debajo de ka en la matriz esta a n posiciones mas, por lo que se le suma n a k para que lo iguale
        for(h=limites;h<limites*limites;h+=limites){//h se igual al limite y se ejecuta hasta que sea mayor o igual al limite al cuadrado, despues de cada ciclo se le suma el valor de los limites
            arraylist+=numeros[k]+" ";
            k+=n;
        }
        limites--;/*se disminuye en uno los limites, porque si teniamos una matriz n*n al leer la primera fila y la ultima columna,
                    nos queda faltando una matriz de tamaño (n-1)*(n-1) ejmplo, si teniamos una matriz 4*4
                    ahora tenemos una matriz 3*3*/
        k-=n;//se le resta n para que el vector quede en el ultimo numero que imprimio en pantalla, ya que en la ultima ejecucion se le suma un n de mas
    }
    
    public void InversaFila(){//se encarga de leer las filas de dercha a izquierda
        k--;//se le resta 1 porque necesitamos el numero que se encuentea justo atras
        imitadorfilas=limites;//imitador copia el valor de limtes
        while(imitadorfilas>0){//se ejecuta hasta que imitadorfilas sea 0
            arraylist+=numeros[k]+" ";
            k--;
            imitadorfilas--;
        }
        k++;//se le suma una k, por la misma razon que antes, porque se le resto uno de mas, toca volver a sumarlo para que quede en el ultimo numero impreso
        
    }
    public void ArribaColumna(){
        k-=n;//como el numero que esta encima de este en la matriz se encuentra a n espacios menos, a k se le resta n para que lo iguale
        limites--;/*este metodo(ArribaColumna) junto con el metodo InversaFilas, ha impreso la ultima fila 
                    y la primera columna, por lo que la matriz vuelve a encogerse y a la matriz (n-1)*(n-1)
                    pasa a ser una matriz (n-2)*(n-2) ejemplo: la matriz de tamaño n*n, n=4,paso a ser una matriz 
                    3x3 en el metodo Columna Abajo y en este metodo pasa a ser 2*2 */
        imitadorcolumnas=limites;//se iguala a los limites
        while(imitadorcolumnas>0){//Se repite hasta que imitador sea igual a 0
            arraylist+=numeros[k]+" ";
            k-=n;
            imitadorcolumnas--;
        }
       k+=n;
    }
    
    public String getarray(){
        return arraylist;
    }
}
