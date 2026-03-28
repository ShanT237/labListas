public class Bakery {
    private String name;
    private ListaSimple<Client> list;


    public Bakery(String name) {
        this.name = name;
        this.list = new ListaSimple<>();
    }


    public void registerNewClient(String name, String id, String phoneNumber) {
        if (name == null || id == null || phoneNumber == null) {
            throw new RuntimeException("The data can not be null");

        } else if (verifyIdExistence(id)) {
            throw new RuntimeException("The user already exists in the system");
        } else {
            Client node = new Client(id, name, phoneNumber);
            list.agregarfinal(node);
        }
    }



    public boolean verifyIdExistence(String id) {
        for (Client node : list) {
            if (node.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public void attendClient(){
        if(list.estaVacia()){
            throw new RuntimeException("List is empty");
        }
        Client client = list.getNodoPrimero().getValorNodo();

        list.eliminarPrimero();
        System.out.println("Attending Cliente" + client.getName() );
    }

    public void consultNextClient(){
        if(list.estaVacia()){
            throw new RuntimeException("List is empty");
        }
        System.out.println("Next client is: " + list.getNodoPrimero().getValorNodo().getName());
    }

    public void consultList(){
        if (list.estaVacia()){
            throw new RuntimeException("List is empty");
        }
        list.imprimirLista();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ListaSimple<Client> getCliente() {
        return list;
    }

    public void setCliente(ListaSimple<Client> lista) {
        this.list = lista;
    }

}


