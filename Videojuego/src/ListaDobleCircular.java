public class ListaDobleCircular<T> {

    private NodoDoble<T> nodoPrimero;
    private NodoDoble<T> nodoUltimo;
    private int tamanio;

    public ListaDobleCircular() {
        nodoPrimero = null;
        nodoUltimo = null;
        tamanio = 0;
    }

    /**
     * Agrega un nuevo nodo en la posici�n dada
     * @param valor
     * @param posicion
     */
    public void insertar( T valor, int posicion ) {
        int cont = 0;

        for( NodoDoble<T> aux = nodoPrimero; cont < tamanio; cont++, aux = aux.getSiguienteNodo() ) {
            if( cont == posicion ) {
                NodoDoble<T> aux2 = aux.getAnteriorNodo();
                NodoDoble<T> nuevo = new NodoDoble<>( valor );
                aux2.setSiguienteNodo( nuevo );
                nuevo.setSiguienteNodo( aux );
                nuevo.setAnteriorNodo( aux2 );
                aux.setAnteriorNodo( nuevo );
                tamanio ++;
            }
        }
    }

    /**
     * Busca y retorna la posici�n de un nodo que tenga el valor ingresado por par�metro
     * @param valor a buscar
     * @return posici�n donde se encontr� el nodo
     */
    public int buscar( T valor ) {
        int cont = 0;
        int pos = -1;

        for( NodoDoble<T> aux = nodoPrimero; cont < tamanio; cont++, aux = aux.getSiguienteNodo() ) {
            if( aux.getValorNodo().equals( valor ) ) {
                pos = cont;
            }
        }
        return pos;
    }

    public void agregarFinal(T valorNodo) {

        NodoDoble<T> nuevoNodo = new NodoDoble<>( valorNodo );

        if( estaVacia() ) {
            nodoPrimero = nodoUltimo = nuevoNodo;
        }
        else {
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nodoPrimero.setAnteriorNodo(nuevoNodo);
            nodoUltimo.setSiguienteNodo( nuevoNodo );
            nuevoNodo.setAnteriorNodo( nodoUltimo );
            nodoPrimero = nuevoNodo;
        }
        tamanio++;
    }

    //Verificar si la lista esta vacia
    public boolean estaVacia() {
        return nodoPrimero == null && nodoUltimo == null;
    }

    /**
     * Imprime en consola la lista enlazada
     */
    public void imprimirLista() {

        NodoDoble<T> aux = nodoPrimero;
        int cont = 0;

        while( aux!=null && cont != tamanio ) {
            System.out.print( aux.getValorNodo()+"\t" );
            aux = aux.getSiguienteNodo();
            cont ++;
        }

        System.out.println();
    }

    public void eliminar(int posicion) {

        if (estaVacia()) {
            System.out.println("La lista está vacía");
            return;
        }

        if (posicion < 0 || posicion >= tamanio) {
            System.out.println("Posición inválida");
            return;
        }

        NodoDoble<T> actual = nodoPrimero;

        // Caso: solo un nodo
        if (tamanio == 1) {
            nodoPrimero = null;
            nodoUltimo = null;
        }
        else {
            // Recorrer hasta la posición
            for (int i = 0; i < posicion; i++) {
                actual = actual.getSiguienteNodo();
            }

            // Caso: eliminar el primero
            if (actual == nodoPrimero) {
                nodoPrimero = nodoPrimero.getSiguienteNodo();
                nodoPrimero.setAnteriorNodo(nodoUltimo);
                nodoUltimo.setSiguienteNodo(nodoPrimero);
            }
            // Caso: eliminar el último
            else if (actual == nodoUltimo) {
                nodoUltimo = nodoUltimo.getAnteriorNodo();
                nodoUltimo.setSiguienteNodo(nodoPrimero);
                nodoPrimero.setAnteriorNodo(nodoUltimo);
            }
            // Caso: nodo intermedio
            else {
                NodoDoble<T> anterior = actual.getAnteriorNodo();
                NodoDoble<T> siguiente = actual.getSiguienteNodo();

                anterior.setSiguienteNodo(siguiente);
                siguiente.setAnteriorNodo(anterior);
            }
        }

        tamanio--;
    }

    public NodoDoble<T> getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(NodoDoble<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public NodoDoble<T> getNodoUltimo() {
        return nodoUltimo;
    }

    public void setNodoUltimo(NodoDoble<T> nodoUltimo) {
        this.nodoUltimo = nodoUltimo;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}