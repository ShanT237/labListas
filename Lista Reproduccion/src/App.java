public class App {
    ListaSimpleCircular<Cancion> canciones;
    Nodo<Cancion> cancionActual;

    public App(Cancion cancion) {
        this.canciones = new ListaSimpleCircular<>();
        canciones.agregarInicio(cancion);
        this.cancionActual = canciones.getNodoPrimero();
    }

    public void reproducirCancion() {
        if (cancionActual != null) {
            System.out.println("Reproduciendo Canción: " + cancionActual.getValorNodo().getTitulo() + " Duración: " + cancionActual.getValorNodo().getDuracion());
        } else {
            throw new RuntimeException("No hay canción actual");
        }
    }

    public void agregarCancion(Cancion cancion) {
        if (cancion != null) {
            canciones.agregarFinal(cancion);
        } else {
            throw new RuntimeException("La canción o puede ser null");
        }

    }


    public void reproducirSiguienteCancion() {
        if (cancionActual != null) {
            cancionActual = cancionActual.getSiguienteNodo();
            reproducirCancion();
        } else {
            throw new RuntimeException("No hay canciones");
        }
    }

    public void mostrarHistorialReproduccion() {
        if (!canciones.estaVacia()) {
            canciones.imprimirLista();
        } else {
            throw new RuntimeException("La playlist esta vacia");
        }
    }

    public void eliminarCancion(Cancion cancion) {
        for (Cancion i : canciones) {
            if (i.equals(cancion)) {
                canciones.eliminar(cancion);
                return;
            }
        }
        throw new RuntimeException("No se encontro la cancion");
    }


    public ListaSimpleCircular<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(ListaSimpleCircular<Cancion> canciones) {
        this.canciones = canciones;
    }

    public Nodo<Cancion> getCancionActual() {
        return cancionActual;
    }

    public void setCancionActual(Nodo<Cancion> cancionActual) {
        this.cancionActual = cancionActual;
    }
}
