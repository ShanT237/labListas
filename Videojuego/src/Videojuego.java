public class Videojuego {
    ListaDobleCircular<Jugador> jugadores;
    NodoDoble<Jugador> turno;

    public Videojuego(ListaDobleCircular<Jugador> jugadores) {
        this.jugadores = jugadores;
        this.turno = jugadores.getNodoPrimero();
    }

    public void avanzar(){
        if(jugadores.estaVacia()){
            throw new RuntimeException("La mesa está vacia");
        } else{
            turno = turno.getSiguienteNodo();
        }
    }

    public void consultarTurnoAnterior(){
        if(jugadores.estaVacia()){
            throw new RuntimeException("La mesa está vacia");
        } else{
            System.out.println("El jugador anterior fue: " + turno.getAnteriorNodo().getValorNodo().getNombre());
        }
    }

    public void consultarSiguiente() {
        if (jugadores.estaVacia()) {
            throw new RuntimeException("La mesa está vacia");
        } else {
            System.out.println("El siguiente jugador es: " + turno.getSiguienteNodo().getValorNodo().getNombre());
        }
    }

    public void eliminarJugador(Jugador jugador){
        if(jugador != null){
            int posicion = jugadores.buscar(jugador);
            if(jugador.equals(turno.getValorNodo())){
                turno = turno.getSiguienteNodo();
            }
            jugadores.eliminar(posicion);
        } else{
            throw new RuntimeException("El jugador no puede ser nulo");
        }
    }

    public void mostrarJugadoresEnMeSa(){
        jugadores.imprimirLista();
    }

    public ListaDobleCircular<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(ListaDobleCircular<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public NodoDoble<Jugador> getTurno() {
        return turno;
    }

    public void setTurno(NodoDoble<Jugador> turno) {
        this.turno = turno;
    }
}
