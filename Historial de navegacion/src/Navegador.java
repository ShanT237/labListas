public class Navegador {
    ListaDoble<PaginaWeb> historial;
    String nombre;
    NodoDoble<PaginaWeb> paginaActual;

    public Navegador(String nombre) {
        this.nombre = nombre;
        this.historial = new ListaDoble<>();
        PaginaWeb inicio = new PaginaWeb("/home", "navegador");
        historial.agregarInicio(inicio);
        this.paginaActual = historial.getNodoPrimero();
    }

    public void mostrarPaginaActual(){
        System.out.println("Pagina: " + paginaActual.getValorNodo().getTitulo() + " url: " + paginaActual.getValorNodo().getUrl());
    }

    public void visitarNuevaPagina(String url, String titulo){
        if(validarDatos(url, titulo)){
            PaginaWeb pagina = new PaginaWeb(url, titulo);
            if(paginaActual.getSiguienteNodo() != null){
                eliminarPaginasFuturas();
            }
            historial.agregarfinal(pagina);
            paginaActual = historial.getNodoUltimo();
            mostrarPaginaActual();
        } else{
            throw new RuntimeException("La pagina no existe");
        }


    }

    public void retroceder(){
        if(paginaActual.getAnteriorNodo() != null){
            paginaActual = paginaActual.getAnteriorNodo();
            mostrarPaginaActual();
        } else{
            throw new RuntimeException("No hay paginas previas");
        }
    }

    public void avanzar(){
        if(paginaActual.getSiguienteNodo() != null){
            paginaActual = paginaActual.getSiguienteNodo();
            mostrarPaginaActual();
        } else{
            throw new RuntimeException("Noy hay paginas siguientes");
        }
    }

    public void eliminarPaginasFuturas(){
        paginaActual.setSiguienteNodo(null);
        historial.setNodoUltimo(paginaActual);
    }

    public boolean validarDatos(String url, String titulo){
        if(url == null || titulo == null){
            return false;
        } else if (url.isBlank() || titulo.isBlank()) {
            return false;
        }
        return true;
    }
}
