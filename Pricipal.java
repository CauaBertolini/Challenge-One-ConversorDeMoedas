package ConversorDeMoedas.Documentacao;

import ConversorDeMoedas.Documentacao.Ferramentas.EditorDeTexto;
import ConversorDeMoedas.Documentacao.Models.ConvercaoApi;
import ConversorDeMoedas.Documentacao.Models.ResponseApi;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Scanner;

// KEY = 82c5b5581e00e617cbdc746c
public class Pricipal {
    public static void main(String[] args) throws InterruptedException, MalformedURLException {
        //Tools
        EditorDeTexto editorDeTexto = new EditorDeTexto();
        Scanner leitor = new Scanner(System.in);
        Gson gson = new GsonBuilder().create();

        //Variáveis constantes
        String key = "82c5b5581e00e617cbdc746c";;
        String moeda = "";
        String conversaoPara = "";
        double valor = 0;
        Boolean valido = false;

        //Alimentando Editor de Texto
        ArrayList<String> menu = new ArrayList<>();
        menu.add("Dólar ==> Peso Argentino");
        menu.add("Peso Argentino ==> Dólar");
        menu.add("Dólar ==> Real Brasileiro");
        menu.add("Real Brasileiro ==> Dólar");
        menu.add("Dólar ==> Peso Colombiano");
        menu.add("Peso Colombiano ==> Dólar");
        menu.add("Sair");

        while (true) {
            editorDeTexto.toTitle("Conversor de Moedas Bertol (Baseado em ExchangeRate-API)");
            editorDeTexto.toMenu(menu, 7);
            editorDeTexto.line();
            System.out.println("Escolha uma opção válida: ");
            int opc = leitor.nextInt();
            if (opc == 1){
                moeda = "USD";
                conversaoPara = "ARS";
                valido = true;
            } else if (opc == 2) {
                moeda = "ARS";
                conversaoPara = "USD";
            } else if (opc == 3) {
                moeda = "USD";
                conversaoPara = "BRL";
                valido = true;
            } else if (opc == 4) {
                moeda = "BRL";
                conversaoPara = "USD";
                valido = true;
            } else if (opc == 5) {
                moeda = "USD";
                conversaoPara = "COP";
                valido = true;
            } else if (opc == 6) {
                moeda = "COP";
                conversaoPara = "USD";
                valido = true;
            } else if (opc == 7) {
                break;
            } else {
                editorDeTexto.line();
                System.out.println("Opção inválida, tente novamente!");
                Thread.sleep(2000);
            } if (valido) {
                String endereco = "https://v6.exchangerate-api.com/v6/" + key + "/pair/" + moeda + "/" + conversaoPara;
                ;
                try {
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder().uri(URI.create(endereco)).build();
                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                    String json = response.body();
                    editorDeTexto.line();

                    ConvercaoApi responseApi = gson.fromJson(json, ConvercaoApi.class);
                    ResponseApi cotacaoAtual = new ResponseApi(responseApi);

                    System.out.println("Informe o valor em " + moeda + " que deseja converter para " + conversaoPara + ":");
                    valor = leitor.nextDouble();
                    editorDeTexto.line();
                    System.out.println(valor +  " " + moeda + " em " + conversaoPara + " na cotação atual, atualizada em: (" + cotacaoAtual.getDataCotacao() + ") fica no valor de " + conversaoPara +  " " + cotacaoAtual.getValorCotado(valor));
                    Thread.sleep(5000);

                } catch (Exception e) {
                    System.out.println("Erro:");
                    System.out.println(e.getMessage());
                    System.out.println(e.getCause());
                }





            }


        }


    }
}
