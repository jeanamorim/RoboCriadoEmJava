/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package computacaointeligente;

/**
 *
 * @author JeanAmorim
 */
public class AgenteAspirador {

    private Ambiente ambiente;
    private Movimentos movimento;

    private PosicaoXY posXY;

    private int pilhaMovimentos;
    private int pontuacaoAspirador;
    
   //construtor
    public AgenteAspirador(Ambiente ambiente) {
        this.ambiente = ambiente;
        ambiente.setAgente(this);
        this.posXY = new PosicaoXY();
        this.movimento = Movimentos.CIMA;
        this.pontuacaoAspirador = 0;

    }
    //se ele ja tiver feito os 4 movimentos ele vai saber 
    //que nao vai ter nenhum outro movimento ai irá parar.

    public void movimentar() {
        if (this.pilhaMovimentos >= 4) {
            return;
        }
        PosicaoXY proximoMovimento = retornarMovimento();
        //this.pontuacaoAspirador++;
        char valor = this.ambiente.retornarValorPosicaoAmbiente(proximoMovimento);
       // this.pontuacaoAspirador++;
       //se ele encontrar l nos quatro movimento ou # ele para;
        if (valor == '#' || valor =='L') {

            proximoMovimento();
            aumentarPilha();
            movimentar();
            

        } else {
            this.ambiente.limpar();
            this.posXY = proximoMovimento;
            
        }
    }

    //ele fica sabendo o tamnho dele, ele nao vai conseguir encontrar nenhuma sujeira e ira parar

    private void aumentarPilha() {
        this.pilhaMovimentos++;
    }

    private void proximoMovimento() {  //precisamos nos movimentar
        switch (this.movimento) {
            case CIMA:
                this.movimento = Movimentos.BAIXO;
                break;
            case BAIXO:
                this.movimento = Movimentos.ESQUERDA;
                break;
            case ESQUERDA:
                this.movimento = Movimentos.DIREITA;
                break;
            case DIREITA:
                this.movimento = Movimentos.CIMA;
                break;
        }
    }

    public PosicaoXY retornarMovimento() {  //vamos retornar o movimento
        int retornoPosX = this.posXY.getPosX();
        int retornoPosY = this.posXY.getPosY();
        switch (movimento) {
            case CIMA: //se for para cima
                if (retornoPosX > 0) {    
                    retornoPosX -= 1;
                }
                break;
            case BAIXO:       //se for para baixo
                if (retornoPosX < this.ambiente.getTamanhoAmbiente() - 1) {
                    retornoPosX += 1;
                }
                break;
            case ESQUERDA:  //se for para esquerda
                if (retornoPosY > 0) {
                    retornoPosY -= 1;
                }
                break;
            case DIREITA://se for para direita
                if (retornoPosY < this.ambiente.getTamanhoAmbiente() - 1) {
                    retornoPosY += 1;
                }
                break;
        }
        return new PosicaoXY(retornoPosX, retornoPosY);
    }

    public PosicaoXY getPosicao() {
        return this.posXY;
    }

    public boolean AindaLimpando() {
        return pilhaMovimentos < 4;
    }

    public void zerarPilha() {
        this.pilhaMovimentos = 0;
    }
     public void exibirInfo() {
    	System.out.println("\n Pontuação Aspirador: " + this.pontuacaoAspirador);
    }

}
