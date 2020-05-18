/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

/**
 *
 * @author Gustavo K. Heinen, Nilton E. Clasen e Mateus Kienen
 */
public class CidadeAtrelada {

    private Cidade m_dadosCidade;
    private int m_iDistancia;

    CidadeAtrelada(Cidade dadosCidade, int iDistancia) {
        m_dadosCidade = dadosCidade;
        m_iDistancia = iDistancia;
    }

    public Cidade getCidade() {
        return m_dadosCidade;
    }

    public void setCidade(Cidade dadosCidadeAtrelada) {
        m_dadosCidade = dadosCidadeAtrelada;
    }

    public int getDistancia() {
        return m_iDistancia;
    }

    public void setDistancia(int iDistancia) {
        m_iDistancia = iDistancia;
    }
}