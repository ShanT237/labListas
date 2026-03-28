
void main() {
    Bakery bakery = new Bakery("La Gran Panadería");
    bakery.registerNewClient("Juan Pérez", "001", "3001234567");
    bakery.registerNewClient("María López", "002", "3017654321");
    bakery.registerNewClient("Carlos Ruiz", "003", "3109876543");
    bakery.attendClient();
    bakery.consultNextClient();
}
