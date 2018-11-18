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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {

        Ambiente ambiente = new Ambiente(5);  //tamanho do ambiente
        ambiente.setAgente(null);

        AgenteAspirador agente = new AgenteAspirador(ambiente);
        //ambiente.exibirAmbiente();

        while (agente.AindaLimpando()) {
            agente.zerarPilha();
            agente.movimentar();
            ambiente.exibirAmbiente();
            Thread.sleep(2500);
        }

        agente.exibirInfo();
    }

}
