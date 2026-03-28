//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    Navegador nav = new Navegador("Chrome");
    nav.visitarNuevaPagina("google.com", "Google");
    nav.visitarNuevaPagina("youtube.com", "YouTube");
    nav.visitarNuevaPagina("instagram.com", "Instagram");
    nav.retroceder();
    nav.retroceder();
    nav.visitarNuevaPagina("facebook.com", "Facebook");
}
