/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Supermercado;

/**
 *
 * @author TIAGO
 */
public interface Simulador {
    public void imprimirResultados();
    public void limpar();
    public void simular();
    public String NumeroDeAtendimentos();
    public String tempoMedioAtendimento();
    public String utilizacao();
    public String MaximoFila();
    public String mediaTempoDeEspera();
    public String atendimentosSemEspera();
    public String tempoFilaVazia();
    
    
    
    
    
}
