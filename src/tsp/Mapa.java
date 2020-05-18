/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Gustavo K. Heinen, Nilton E. Clasen e Mateus Kienen
 */
public class Mapa {

    public ArrayList<Cidade> aDadosCidade = new ArrayList<>();
    private int m_iMaiorVertice = 0;
    private Cidade ultimaCidadeAdicionada;
    private int m_iDistanciaTotal = 999999;

    public void adicionaCidade(Cidade dadosCidade) {
        aDadosCidade.add(dadosCidade);

        if (dadosCidade.getVertice() > m_iMaiorVertice) {
            m_iMaiorVertice = dadosCidade.getVertice();
        }

        setUltimaCidadeAdicionada(dadosCidade);
    }

    public void setUltimaCidadeAdicionada(Cidade dadosCidade) {
        ultimaCidadeAdicionada = dadosCidade;
    }

    public Cidade getUltimaCidadeAdicionada() {
        return ultimaCidadeAdicionada;
    }

    public void setCidade(int index, Cidade cidade) {
        aDadosCidade.set(index, cidade);
    }

    public Cidade getCidade(int index) {
        return aDadosCidade.get(index);
    }

    public Cidade getCidade(String nome) {
        for (int i = 0; i < aDadosCidade.size(); i++) {
            if (aDadosCidade.get(i).getNome().equalsIgnoreCase(nome)) {
                return aDadosCidade.get(i);
            }
        }
        return null;
    }

    public int getQntdCidades() {
        return aDadosCidade.size();
    }

    public boolean ExisteCidade(int iVertice) {
        for (int idx = 0; idx < getQntdCidades(); idx++) {
            Cidade cidade = getCidade(idx);

            if (cidade.getVertice() == iVertice) {
                return true;
            }
        }

        return false;
    }

    public int getDistancia() {
        int iDistanciaDaRota = 0;
        for (int idx = 0; idx < getQntdCidades(); idx++) {
            Cidade cidadeInicial = getCidade(idx);
            Cidade cidadeDestino;
            if (idx + 1 < getQntdCidades()) {
                cidadeDestino = getCidade(idx + 1);
            } else {
                cidadeDestino = getCidade(0);
            }
            iDistanciaDaRota += cidadeInicial.distanciaPara(cidadeDestino);
        }

        m_iDistanciaTotal = iDistanciaDaRota;
        return iDistanciaDaRota;
    }

    public Mapa criaCaminhoAleatorio() {
        Mapa mapaAtual = new Mapa();

        for (int idx = 0; idx < getQntdCidades(); idx++) {
            mapaAtual.adicionaCidade(getCidade(idx));
        }

        Collections.shuffle(mapaAtual.aDadosCidade);

        return mapaAtual;
    }

    public boolean cidadeJaEscolhida(Mapa mapaAtual, int iRandom) {
        if (mapaAtual.getQntdCidades() == 0) {
            return false;
        }

        Cidade cidade = getCidade(iRandom);

        for (int idx = 0; idx < mapaAtual.getQntdCidades(); idx++) {
            if (mapaAtual.getCidade(idx) == cidade) {
                return true;
            }
        }

        return false;
    }

    public int getMaiorVertice() {
        return m_iMaiorVertice;
    }

    public int getDistanciaTotal() {
        return m_iDistanciaTotal;
    }

    public void setDistanciaTotal(int iDistanciaTotal) {
        this.m_iDistanciaTotal = iDistanciaTotal;
    }

    public void removeCidade(Cidade cidade) {
        aDadosCidade.remove(cidade);
    }
}
