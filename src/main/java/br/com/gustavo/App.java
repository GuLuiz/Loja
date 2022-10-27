package br.com.gustavo;

import br.com.gustavo.Loja.MenuPrincipal;

public final class App {
    private App() {
    }

    public static void main(String[] args) {

        MenuPrincipal menuPrincipal = new MenuPrincipal();

        menuPrincipal.mostrarMenuPrincipal();

       
        System.out.println("Fim");


    }
}
