/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacaointeligente;

import java.util.Random;

/**
 *
 * @author JeanAmorim
 */
public class Ambiente {

    private int tamanhoAmbiente;

    //char[] letras = new char[]{'C', 'M', 'A', 'S', 'L'};
    
    char[][] ambiente;
   // int cont = 0;

    //new char[tamanhoLabirinto][tamanhoLabirinto];
    private AgenteAspirador agente;
    
   //construtor para a classe ambiente
    public Ambiente(int tamanhoAmbiente) {
        this.tamanhoAmbiente = tamanhoAmbiente;//passo o valor do tamanhodo ambiente
        this.construirNovoAmbiente(); //vai construit o ambiente
    }

    //sortear letras
    Random random = new Random();

    // Construir o labirinto
    private void construirNovoAmbiente() {
        ambiente = new char[this.tamanhoAmbiente][this.tamanhoAmbiente];
        for (int i = 0; i < this.tamanhoAmbiente; i++) {
            for (int j = 0; j < this.tamanhoAmbiente; j++) {
                ambiente[i][j] = 'S'; 
               // ambiente[i][j] = letras[random.nextInt(letras.length)];
            }
        }
    }

    public char[][] getAmbiente() {
        return ambiente;
    }

    //exibe a matriz
    public void exibirAmbiente() {
       atualizarPosicaoAgente();
       // PosicaoXY posAgente = this.agente.getPosicao();
        //int x = posAgente.getPosX();
        //int y = posAgente.getPosY();
        for (int i = 0; i < tamanhoAmbiente; i++) {
            for (int j = 0; j < tamanhoAmbiente; j++) {
            //    if (i == y && j == x) {
             //       System.out.print("|" + "#" + "|");  // exibe a posicao do agente
             //   } else {
                    System.out.print("|" + ambiente[i][j] + "|");  // exibe o valor da posicao
              //  }
            }
            System.out.println("");
        }
        System.out.println("");
    }

    public int getTamanhoAmbiente() {

        return this.tamanhoAmbiente;
    }
//retorna o valor que esta ali naquela posicao do ambiente
//retorna o valor que esta ali

    public char retornarValorPosicaoAmbiente(PosicaoXY posicao) {
        return this.ambiente[posicao.getPosX()][posicao.getPosY()];
    }

    public void setAgente(AgenteAspirador agente) {
        this.agente = agente;
    }
//verifica se esta sujo e limpa trocando S por L

    public void limpar() {
        
       PosicaoXY posicao = this.agente.getPosicao();
       ambiente[posicao.getPosX()][posicao.getPosY()]='L';
       // int x = posicao.getPosX();
       // int y = posicao.getPosY();
        //if (ambiente[x][y] == 'S') {
        //    ambiente[x][y] = 'L';
       // }

    }
    private void atualizarPosicaoAgente() {
        if (this.agente != null) {
            PosicaoXY posAgente = this.agente.getPosicao();
            ambiente[posAgente.getPosX()][posAgente.getPosY()] = '#';

        }

    }

}
