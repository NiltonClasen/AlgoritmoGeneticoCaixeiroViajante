/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Gustavo K. Heinen, Nilton E. Clasen e Mateus Kienen
 */
public class Main {

    public static void main(String[] args) {
        try {

//        Cidade cidade1 = new Cidade("1", 1);
//        Cidade cidade2 = new Cidade("2", 2);
//        Cidade cidade3 = new Cidade("3", 3);
//        Cidade cidade4 = new Cidade("4", 4);
//        Cidade cidade5 = new Cidade("5", 5);
//        Cidade cidade6 = new Cidade("6", 6);
//        Cidade cidade7 = new Cidade("7", 7);
//        Cidade cidade8 = new Cidade("8", 8);
//        Cidade cidade9 = new Cidade("9", 9);
//        Cidade cidade10 = new Cidade("10", 10);
//
//        cidade1.setDistancia(cidade2, 27);
//        cidade1.setDistancia(cidade3, 60);
//        cidade1.setDistancia(cidade4, 83);
//        cidade1.setDistancia(cidade5, 98);
//        cidade1.setDistancia(cidade6, 113);
//        cidade1.setDistancia(cidade7, 140);
//        cidade1.setDistancia(cidade8, 149);
//        cidade1.setDistancia(cidade9, 196);
//        cidade1.setDistancia(cidade10, 203);
//
//        cidade2.setDistancia(cidade1, 27);
//        cidade2.setDistancia(cidade3, 20);
//        cidade2.setDistancia(cidade4, 66);
//        cidade2.setDistancia(cidade5, 85);
//        cidade2.setDistancia(cidade6, 112);
//        cidade2.setDistancia(cidade7, 123);
//        cidade2.setDistancia(cidade8, 146);
//        cidade2.setDistancia(cidade9, 147);
//        cidade2.setDistancia(cidade10, 153);
//
//        cidade3.setDistancia(cidade1, 60);
//        cidade3.setDistancia(cidade2, 20);
//        cidade3.setDistancia(cidade4, 28);
//        cidade3.setDistancia(cidade5, 51);
//        cidade3.setDistancia(cidade6, 70);
//        cidade3.setDistancia(cidade7, 97);
//        cidade3.setDistancia(cidade8, 120);
//        cidade3.setDistancia(cidade9, 139);
//        cidade3.setDistancia(cidade10, 162);
//
//        cidade4.setDistancia(cidade1, 83);
//        cidade4.setDistancia(cidade2, 66);
//        cidade4.setDistancia(cidade3, 28);
//        cidade4.setDistancia(cidade5, 28);
//        cidade4.setDistancia(cidade6, 51);
//        cidade4.setDistancia(cidade7, 99);
//        cidade4.setDistancia(cidade8, 122);
//        cidade4.setDistancia(cidade9, 168);
//        cidade4.setDistancia(cidade10, 216);
//
//        cidade5.setDistancia(cidade1, 98);
//        cidade5.setDistancia(cidade2, 85);
//        cidade5.setDistancia(cidade3, 51);
//        cidade5.setDistancia(cidade4, 28);
//        cidade5.setDistancia(cidade6, 5);
//        cidade5.setDistancia(cidade7, 21);
//        cidade5.setDistancia(cidade8, 31);
//        cidade5.setDistancia(cidade9, 48);
//        cidade5.setDistancia(cidade10, 64);
//
//        cidade6.setDistancia(cidade1, 113);
//        cidade6.setDistancia(cidade2, 112);
//        cidade6.setDistancia(cidade3, 70);
//        cidade6.setDistancia(cidade4, 51);
//        cidade6.setDistancia(cidade5, 5);
//        cidade6.setDistancia(cidade7, 19);
//        cidade6.setDistancia(cidade8, 28);
//        cidade6.setDistancia(cidade9, 56);
//        cidade6.setDistancia(cidade10, 76);
//
//        cidade7.setDistancia(cidade1, 140);
//        cidade7.setDistancia(cidade2, 123);
//        cidade7.setDistancia(cidade3, 97);
//        cidade7.setDistancia(cidade4, 99);
//        cidade7.setDistancia(cidade5, 21);
//        cidade7.setDistancia(cidade6, 19);
//        cidade7.setDistancia(cidade8, 24);
//        cidade7.setDistancia(cidade9, 34);
//        cidade7.setDistancia(cidade10, 40);
//
//        cidade8.setDistancia(cidade1, 149);
//        cidade8.setDistancia(cidade2, 146);
//        cidade8.setDistancia(cidade3, 120);
//        cidade8.setDistancia(cidade4, 122);
//        cidade8.setDistancia(cidade5, 31);
//        cidade8.setDistancia(cidade6, 28);
//        cidade8.setDistancia(cidade7, 24);
//        cidade8.setDistancia(cidade9, 24);
//        cidade8.setDistancia(cidade10, 48);
//
//        cidade9.setDistancia(cidade1, 196);
//        cidade9.setDistancia(cidade2, 147);
//        cidade9.setDistancia(cidade3, 139);
//        cidade9.setDistancia(cidade4, 168);
//        cidade9.setDistancia(cidade5, 48);
//        cidade9.setDistancia(cidade6, 56);
//        cidade9.setDistancia(cidade7, 34);
//        cidade9.setDistancia(cidade8, 24);
//        cidade9.setDistancia(cidade10, 5);
//
//        cidade10.setDistancia(cidade1, 203);
//        cidade10.setDistancia(cidade2, 153);
//        cidade10.setDistancia(cidade3, 162);
//        cidade10.setDistancia(cidade4, 216);
//        cidade10.setDistancia(cidade5, 64);
//        cidade10.setDistancia(cidade6, 76);
//        cidade10.setDistancia(cidade7, 40);
//        cidade10.setDistancia(cidade8, 48);
//        cidade10.setDistancia(cidade9, 5);
//        mapa.adicionaCidade(cidade1);
//        mapa.adicionaCidade(cidade2);
//        mapa.adicionaCidade(cidade3);
//        mapa.adicionaCidade(cidade4);
//        mapa.adicionaCidade(cidade5);
//        mapa.adicionaCidade(cidade6);
//        mapa.adicionaCidade(cidade7);
//        mapa.adicionaCidade(cidade8);
//        mapa.adicionaCidade(cidade9);
//        mapa.adicionaCidade(cidade10);,
            Mapa mapa = new Mapa();
            mapa = lerArquivo(mapa);

            Populacao dadosPopulacao = new Populacao(100); // Minimo 10
            dadosPopulacao.CriaPopulacao(mapa);

            for (int idx = 0; idx < 500; idx++) {
                GA ga = new GA();
                dadosPopulacao = ga.IniciaAlteracoes(dadosPopulacao);

                Mapa mapaGod = dadosPopulacao.setIndividuoMaisApto();

                String Mapa = "Cidades:";
                for (int idx1 = 0; idx1 < mapaGod.getQntdCidades(); idx1++) {
                    Mapa += " " + mapaGod.getCidade(idx1).getNome();
                }
                System.out.println(Mapa + " - Distancia: " + mapaGod.getDistanciaTotal() + "\n");
            }

        } catch (Exception e) {
            System.out.println(e.getCause());
        }

    }

    private static Mapa lerArquivo(Mapa mapa) throws FileNotFoundException, IOException {
        String path = Main.class.getResource("entrada.txt").getPath();
        FileReader arq = new FileReader(path);
        BufferedReader lerArq = new BufferedReader(arq);
        String linha;
        int contador = 1;
        while ((linha = lerArq.readLine()) != null) {
            if (linha.contains("distancia de para")) {
                String aux = linha.substring(18);
                Cidade cidadeOrigem = mapa.getCidade(aux.split("x")[0]);
                Cidade cidadeDestino = mapa.getCidade(aux.split("x")[1].split("=")[0]);
                int distancia = Integer.parseInt(aux.split("=")[1]);
                cidadeOrigem.setDistancia(cidadeDestino, distancia);
            } else if (linha.contains("cidade:")) {
                String nome = linha.substring(7);
                Cidade cidade = new Cidade(nome, contador);
                mapa.adicionaCidade(cidade);
                contador++;
            }
        }

        return mapa;
    }
}
