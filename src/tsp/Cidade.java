/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.ArrayList;

/**
 *
 * @author Gustavo K. Heinen, Nilton E. Clasen e Mateus Kienen
 */
public class Cidade {

    private String m_sNome;
    private int m_iVertice;
    ArrayList<CidadeAtrelada> m_aDadosCidadeAtrelada = new ArrayList<>();

    public int getDistancia(Cidade cidadeDestino) {
        for (int idx = 0; idx < m_aDadosCidadeAtrelada.size(); idx++) {
            if (m_aDadosCidadeAtrelada.get(idx).getCidade() == cidadeDestino) {
                return m_aDadosCidadeAtrelada.get(idx).getDistancia();
            }
        }

        return 0;
    }

    public void setDistancia(Cidade cidade, int iDistancia) {
        CidadeAtrelada cidadeAtrelada = new CidadeAtrelada(cidade, iDistancia);
        m_aDadosCidadeAtrelada.add(cidadeAtrelada);
    }

    Cidade(String sNome, int iVertice) {
        m_sNome = sNome;
        m_iVertice = iVertice;
    }

    public int getVertice() {
        return m_iVertice;
    }

    public void setVertice(int iVertice) {
        this.m_iVertice = iVertice;
    }

    public String getNome() {
        return m_sNome;
    }

    public void setNome(String sNome) {
        this.m_sNome = sNome;
    }

    public int distanciaPara(Cidade cidadeDestino) {
        return getDistancia(cidadeDestino);
    }

}
