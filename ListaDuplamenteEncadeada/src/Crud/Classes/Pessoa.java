/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Crud.Classes;

import ListaDuplamenteEncadeada.classes.ListaDuplamenteEncadeada;
import java.util.UUID;

/**
 *
 * @author cristiano pc
 */
public class Pessoa{
    private static int quantidade = 10000;
    private int codigo;
    private final String nome;
    private final ListaDuplamenteEncadeada<Bem> listaBens = new ListaDuplamenteEncadeada();
    
    public Pessoa(String nome){
        this.nome = nome;
        codigo = quantidade;
        quantidade++;
    }
    public int getCodigo() {
        return codigo;
    }
    public String getNome() {
        return nome;
    }
    public ListaDuplamenteEncadeada<Bem> getListaBens() {
        return listaBens;
    }
    public void adicionarBem(Bem bem) throws Exception{
        boolean contem = false;
        if (listaBens.tamanho() >= 1){
            for(Bem b: getListaBens()){
            if (bem.getCodigo()== b.getCodigo()){
                contem = true;
            }
        }
        if (!contem){
            getListaBens().adicionar(bem);
        }
        else{
            throw new Exception("Bem já cadastrado");
        }
        }
        else{
            listaBens.adicionar(bem);
        }

    }
    public float valorTotalBens(){
        float valorFinal = 0;
        try{
            for(Bem b: this.listaBens){
            valorFinal += b.getValor();
        }
        }
        catch(NullPointerException e){
        }

        return valorFinal;
    }
}
