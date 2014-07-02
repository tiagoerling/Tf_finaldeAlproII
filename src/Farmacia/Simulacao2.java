/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Farmacia;

import Supermercado.Simulador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import supermercado.Acumulador;
import supermercado.Caixa;
import supermercado.Cliente;
import supermercado.GeradorClientes;
import supermercado.QueueTAD;

/**
 *
 * @author TIAGO
 */
public class Simulacao2 implements Simulador {

    private int duracao;
    private int numeroDeCaixaPrimeiraFila;
    private int numeroDeCaixaSegundaFila;
    private double probabilidadeChegada;
    private QueueTAD<Cliente> fila1;
    private QueueTAD<Cliente> fila2;
    private ListDoubleLinked<Caixa> caixa1;
    private ListDoubleLinked<Caixa> caixa2;
    private GeradorClientes geradorClientes;
    private Acumulador statTemposEsperaFila1;
    private Acumulador statComprimentosFila1;
    private int tempoAtendimendoCaixa1;
    private int tempoAtendimendoCaixa2;
    private int maxFila1;
    private int maxFila2;
    private int atenSemEspera1;
    private int atenSemEspera2;
    private int tempoVazia1;
    private int tempoVazia2;

    public Simulacao2(String a) throws FileNotFoundException, IOException {

        Path p = Paths.get(a);
        
        try ( Scanner s = new Scanner (Files.newBufferedReader(p,Charset.defaultCharset())) ) {
          
            while(s.hasNext()) {
                String frase = s.next();
                String array[] = new String[2];
                array = frase.split(";");
                duracao = Integer.parseInt( array[1]);
                frase = s.next();
                array = frase.split(";");
                numeroDeCaixaPrimeiraFila= Integer.parseInt( array[1]);
                frase = s.next();
                array = frase.split(";");
                numeroDeCaixaSegundaFila=  Integer.parseInt( array[1]);
                frase = s.next();
                array = frase.split(";");
                probabilidadeChegada=  Double.parseDouble(array[1]);
                
                        
               
            }
            s.close();
            
        } catch(IOException e) {
            System.out.println(e.getMessage()); // se deu problema retorna false
       
        }         
               
    }

    @Override
    public void imprimirResultados() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void simular() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String NumeroDeAtendimentos(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double tempoMedioAtendimento(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int utilizacao(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int MaximoFila(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double mediaTempoDeEspera(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int atendimentosSemEspera(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int tempoFilaVazia(int a) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
