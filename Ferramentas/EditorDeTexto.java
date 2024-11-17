package ConversorDeMoedas.Documentacao.Ferramentas;

import java.util.ArrayList;

public class EditorDeTexto {

    public void toTitle(String texto) {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
        System.out.println(texto);
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    public void line() {
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
    }

    public void toMenu(ArrayList<String> opcoes, int numeroDeOpcoes) {
        for (int i = 0; i < (numeroDeOpcoes); i++){
            System.out.println("( " + (i+1) + " ) " + opcoes.get(i));
        }
    }
}
