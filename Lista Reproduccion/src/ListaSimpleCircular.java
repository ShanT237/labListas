import java.util.Iterator;

public class ListaSimpleCircular<T> implements Iterable<T> {

    private Nodo<T> nodoPrimero;
    private Nodo<T> nodoUltimo;
    private int tamanio;

    public ListaSimpleCircular() {
        nodoPrimero = null;
        nodoUltimo = null;
        tamanio = 0;
    }

    // ==============================
    // AGREGAR AL INICIO
    // ==============================
    public void agregarInicio(T valorNodo) {

        Nodo<T> nuevoNodo = new Nodo<>(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevoNodo;
            nodoUltimo.setSiguienteNodo(nodoPrimero);
        } else {
            nuevoNodo.setSiguienteNodo(nodoPrimero);
            nodoPrimero = nuevoNodo;
            nodoUltimo.setSiguienteNodo(nodoPrimero);
        }
        tamanio++;
    }

    // ==============================
    // AGREGAR AL FINAL
    // ==============================
    public void agregarFinal(T valorNodo) {

        Nodo<T> nuevoNodo = new Nodo<>(valorNodo);

        if (estaVacia()) {
            nodoPrimero = nodoUltimo = nuevoNodo;
            nodoUltimo.setSiguienteNodo(nodoPrimero);
        } else {
            nodoUltimo.setSiguienteNodo(nuevoNodo);
            nodoUltimo = nuevoNodo;
            nodoUltimo.setSiguienteNodo(nodoPrimero);
        }
        tamanio++;
    }

    // ==============================
    public boolean estaVacia() {
        return nodoPrimero == null;
    }

    // ==============================
    // IMPRIMIR (CONTROLADO)
    // ==============================
    public void imprimirLista() {

        if (estaVacia()) return;

        Nodo<T> aux = nodoPrimero;

        do {
            System.out.print(aux.getValorNodo() + "\t");
            aux = aux.getSiguienteNodo();
        } while (aux != nodoPrimero);

        System.out.println();
    }

    // ==============================
    // OBTENER VALOR
    // ==============================
    public T obtenerValorNodo(int indice) {

        if (!indiceValido(indice)) return null;

        Nodo<T> aux = nodoPrimero;

        for (int i = 0; i < indice; i++) {
            aux = aux.getSiguienteNodo();
        }

        return aux.getValorNodo();
    }

    private boolean indiceValido(int indice) {
        if (indice >= 0 && indice < tamanio) return true;
        throw new RuntimeException("Índice no válido");
    }

    // ==============================
    // ELIMINAR
    // ==============================
    public T eliminar(T dato) {

        if (estaVacia()) throw new RuntimeException("Lista vacía");

        Nodo<T> actual = nodoPrimero;
        Nodo<T> previo = nodoUltimo;

        do {
            if (actual.getValorNodo().equals(dato)) {

                // Caso: un solo nodo
                if (tamanio == 1) {
                    nodoPrimero = nodoUltimo = null;
                }
                // Eliminar primero
                else if (actual == nodoPrimero) {
                    nodoPrimero = nodoPrimero.getSiguienteNodo();
                    nodoUltimo.setSiguienteNodo(nodoPrimero);
                }
                // Eliminar último
                else if (actual == nodoUltimo) {
                    nodoUltimo = previo;
                    nodoUltimo.setSiguienteNodo(nodoPrimero);
                }
                // Nodo intermedio
                else {
                    previo.setSiguienteNodo(actual.getSiguienteNodo());
                }

                tamanio--;
                return dato;
            }

            previo = actual;
            actual = actual.getSiguienteNodo();

        } while (actual != nodoPrimero);

        throw new RuntimeException("Elemento no encontrado");
    }

    // ==============================
    public T eliminarPrimero() {
        if (estaVacia()) throw new RuntimeException("Lista vacía");

        T valor = nodoPrimero.getValorNodo();

        if (tamanio == 1) {
            nodoPrimero = nodoUltimo = null;
        } else {
            nodoPrimero = nodoPrimero.getSiguienteNodo();
            nodoUltimo.setSiguienteNodo(nodoPrimero);
        }

        tamanio--;
        return valor;
    }

    // ==============================
    public T eliminarUltimo() {

        if (estaVacia()) throw new RuntimeException("Lista vacía");

        T valor = nodoUltimo.getValorNodo();

        if (tamanio == 1) {
            nodoPrimero = nodoUltimo = null;
        } else {
            Nodo<T> aux = nodoPrimero;

            while (aux.getSiguienteNodo() != nodoUltimo) {
                aux = aux.getSiguienteNodo();
            }

            nodoUltimo = aux;
            nodoUltimo.setSiguienteNodo(nodoPrimero);
        }

        tamanio--;
        return valor;
    }

    // ==============================
    public int obtenerPosicionNodo(T dato) {

        if (estaVacia()) return -1;

        Nodo<T> aux = nodoPrimero;
        int i = 0;

        do {
            if (aux.getValorNodo().equals(dato)) return i;
            aux = aux.getSiguienteNodo();
            i++;
        } while (aux != nodoPrimero);

        return -1;
    }

    // ==============================
    @Override
    public Iterator<T> iterator() {
        return new IteradorListaSimple();
    }

    protected class IteradorListaSimple implements Iterator<T> {

        private Nodo<T> actual = nodoPrimero;
        private int contador = 0;

        @Override
        public boolean hasNext() {
            return contador < tamanio;
        }

        @Override
        public T next() {
            T valor = actual.getValorNodo();
            actual = actual.getSiguienteNodo();
            contador++;
            return valor;
        }
    }

    // ==============================
    public int getTamanio() {
        return tamanio;
    }

    public Nodo<T> getNodoPrimero() {
        return nodoPrimero;
    }

    public void setNodoPrimero(Nodo<T> nodoPrimero) {
        this.nodoPrimero = nodoPrimero;
    }

    public Nodo<T> getNodoUltimo() {
        return nodoUltimo;
    }

    public void setNodoUltimo(Nodo<T> nodoUltimo) {
        this.nodoUltimo = nodoUltimo;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}