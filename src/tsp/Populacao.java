/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.Collections;

/**
 *
 * @author Gustavo K. Heinen, Nilton E. Clasen e Mateus Kienen
 */
public class Populacao {

    private Mapa[] aMapas;
    private Mapa individuoMaisApto;

    public Populacao(int iTamanhoPopulacao) {
        aMapas = new Mapa[iTamanhoPopulacao];

    }

    public void CriaPopulacao(Mapa mapa) {
        for (int i = 0; i < aMapas.length; i++) {
            Mapa novoMapa = mapa.criaCaminhoAleatorio();

            aMapas[i] = novoMapa;
        }
    }

    public Mapa setIndividuoMaisApto() {
        if (individuoMaisApto == null) {
            individuoMaisApto = aMapas[0];
        }

        for (int i = 0; i < aMapas.length; i++) {
            Mapa mapa = aMapas[i];
            if (mapa.getDistancia() <= getIndividuoMaisApto().getDistanciaTotal()) {
                individuoMaisApto = mapa;
            }
        }

        return individuoMaisApto;
    }

    public Mapa getIndividuoMaisApto() {
        return individuoMaisApto;
    }

    public int getQntdPopulacao() {
        return aMapas.length;
    }

    public Mapa adicionaMapa(int idx, Mapa mapa) {
        return aMapas[idx] = mapa;
    }
    
    public Mapa getMapa(int idx) {
        return aMapas[idx];
    }

}
