/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud.Classes;

/**
 *
 * @author cristiano pc
 */
public class Bem {
    private int codigo;
    private String nome;
    private double valor;
    
    public Bem(int codigo, String nome, double valor){
        this.codigo = codigo; 
        this.nome = nome;
        this.valor = valor;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getValor() {
        return valor;
    }
    public void setValor(double valor) {
        this.valor = valor;
    }
    
}
