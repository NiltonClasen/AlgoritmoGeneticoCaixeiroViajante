/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tsp;

import java.util.Random;

/**
 *
 * @author Gustavo K. Heinen, Nilton E. Clasen e Mateus Kienen
 */
public class GA {

    public Populacao IniciaAlteracoes(Populacao dadosPopulacao) {
        Populacao novaPopulacao = new Populacao(dadosPopulacao.getQntdPopulacao());

        Mapa mapaMaisApto = dadosPopulacao.setIndividuoMaisApto(); //Elitismo
        novaPopulacao.adicionaMapa(0, mapaMaisApto); //Salvo na posição 0 para deixar salvo caso a população não gere nenhuma boa

        for (int idx = 1; idx < dadosPopulacao.getQntdPopulacao(); idx++) { // Começa do index 1 para guardar o elitismo
            Mapa pai1 = selecionaAptoRandomico(dadosPopulacao);
            Mapa pai2 = selecionaAptoRandomico(dadosPopulacao);

            Mapa filho = crossover(pai1, pai2);

            mutacao(filho);

            novaPopulacao.adicionaMapa(idx, filho);
        }

        return novaPopulacao;
    }

    public Mapa selecionaAptoRandomico(Populacao dadosPopulacao) {
        Populacao dadosPopulacaoRandom = new Populacao(10);

        //Crio uma nova populacao pois dessa forma é possivel vir um individio apto, assim como um com genética ruim.
        for (int idx = 0; idx < 10; idx++) {
            Mapa mapa = new Mapa();
            dadosPopulacaoRandom.adicionaMapa(idx, mapa);
            int iRandom = new Random().nextInt(dadosPopulacao.getQntdPopulacao());
            for (int j = 0; j < dadosPopulacao.getMapa(iRandom).getQntdCidades(); j++) {
                dadosPopulacaoRandom.getMapa(idx).adicionaCidade(dadosPopulacao.getMapa(iRandom).getCidade(j));
            }
        }

        return dadosPopulacaoRandom.setIndividuoMaisApto();
    }

    public Mapa crossover(Mapa pai1, Mapa pai2) {
        int iNotaDeCorte = new Random().nextInt(pai1.getQntdCidades());

        if (iNotaDeCorte == 0) {
            iNotaDeCorte++;
        }

        Mapa mapaNaoUtilizado = new Mapa();
        for (int idx = 0; idx < pai1.getQntdCidades(); idx++) {
            mapaNaoUtilizado.adicionaCidade(pai1.getCidade(idx));
        }

        for (int idx = iNotaDeCorte; idx < pai1.getQntdCidades(); idx++) {
            Cidade cidade2 = pai2.getCidade(idx);

            pai2.setCidade(idx, pai1.getCidade(idx));
            pai1.setCidade(idx, cidade2);
        }

        int[] aIndex = new int[pai1.getQntdCidades()];

        int iContador = 0;
        for (int idx = 0; idx < pai1.getQntdCidades(); idx++) {
            int iTamanho = mapaNaoUtilizado.getQntdCidades();

            mapaNaoUtilizado.removeCidade(pai1.getCidade(idx));

            if (mapaNaoUtilizado.getQntdCidades() == iTamanho) {
                aIndex[iContador] = idx;
                iContador++;
            }
        }

        for (int idx = 0; idx < mapaNaoUtilizado.getQntdCidades(); idx++) {
            pai1.setCidade(aIndex[idx], mapaNaoUtilizado.getCidade(idx));
        }

        return pai1;
    }

    public void mutacao(Mapa filho) {
        if (new Random().nextInt(1000) < 10) {
            int iIdx1 = new Random().nextInt(filho.getQntdCidades());
            int iIdx2 = new Random().nextInt(filho.getQntdCidades());

            Cidade cidade1 = filho.getCidade(iIdx1);
            Cidade cidade2 = filho.getCidade(iIdx2);

            filho.setCidade(iIdx1, cidade2);
            filho.setCidade(iIdx2, cidade1);
        }
    }
}
