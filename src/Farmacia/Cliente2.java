/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Farmacia;

import java.util.Random;

/**
 *
 * @author TIAGO
 */
public class Cliente2 {
    private int numero; //numero do cliente
	private int instanteChegada;
	private int tempoAtendimento; //quantidade de tempo que resta para o cliente no caixa
	private static final Random gerador = new Random();
	public  int tempoMinAtendimento;
	public  int tempoMaxAtendimento;

	public Cliente2(int n, int c, int tempMin, int tempMax)
	{
	    numero = n;
	    instanteChegada = c;
	    tempoAtendimento = gerador.nextInt(tempMax-tempMin+1)+tempoMinAtendimento; //gera valores entre 5 e 20
	}
	
	public int getNumero()
	{
	    return numero;
	}
	
	public int getInstanteChegada()
	{
	    return instanteChegada;
	}
	
	public void decrementarTempoAtendimento()
	{
	    tempoAtendimento--;
	}
	
	public int getTempoAtendimento()
	{
	    return tempoAtendimento;
	}
    
}
