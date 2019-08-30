/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDuplamenteEncadeada.classes;

import Lista.classes.Lista;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 *
 * @author cristiano pc
 * @param <T>
 */
public class ListaDuplamenteEncadeada<T> implements Lista<T>{
    private int tamanho;
    private NoDuplo<T> inicio;
    private NoDuplo<T> fim;
    private final NoDuplo<T> inicioCabeca = new NoDuplo<T>();
    private final NoDuplo<T> fimCabeca = new NoDuplo<T>();
    

    public ListaDuplamenteEncadeada() {
    	this.tamanho= 0;
    	this.inicio = null;
    	this.fim = null;
        this.inicioCabeca.setProximo(fimCabeca);
        this.fimCabeca.setAnterior(inicioCabeca);


    }

    @Override
    public void adicionar(T elemento) {
        NoDuplo novoNo = new NoDuplo(elemento);
        if (inicioCabeca.getProximo().equals(fimCabeca)){
            inicioCabeca.setProximo(novoNo);
            fimCabeca.setAnterior(novoNo);
            inicio = novoNo;
            fim = novoNo;
        }
        else{
            novoNo.setAnterior(fim);
            fim.setProximo(novoNo);
            fim = novoNo;
            fimCabeca.setAnterior(novoNo);
        }
        tamanho++;
    }
    
    @Override
    public void adicionarNoInicio(T elemento) {
        if (inicioCabeca.getProximo().equals(fimCabeca)){
            this.adicionar(elemento);
        }
        else{
            NoDuplo novoNo = new NoDuplo(elemento);
            inicioCabeca.setProximo(novoNo);
            novoNo.setProximo(inicio);
            inicio.setAnterior(novoNo);
            inicio = novoNo;
            tamanho++;
        }
    }

    @Override
    public void adicionarNoFim(T elemento) {
        NoDuplo novoNo = new NoDuplo(elemento);
        if (inicioCabeca.getProximo().equals(fimCabeca)){
            inicio = novoNo;
            fim = novoNo;
            inicioCabeca.setProximo(novoNo);
            fimCabeca.setAnterior(novoNo);
        }
        else{
            novoNo.setAnterior(fim);
            fim.setProximo(novoNo);
            fimCabeca.setAnterior(novoNo);
            fim = novoNo;
            tamanho++;
        }
    }

    @Override
    public void adicionar(T elemento, int posicao) {
        NoDuplo novoNo = new NoDuplo(elemento);
        if (posicao==0){
            this.adicionarNoInicio(elemento);
        }
        else if (posicao==tamanho-1){
            this.adicionarNoFim(elemento);
        }
        else{
            int meio = this.tamanho/2;
            if (posicao >= meio){
                NoDuplo noAtual = fim;
                for(int i = tamanho-1; i>posicao; i--){
                    noAtual = noAtual.getAnterior();
                }
                novoNo.setAnterior(noAtual.getAnterior());
                noAtual.getAnterior().setProximo(novoNo);
                noAtual.setAnterior(novoNo);
                novoNo.setProximo(noAtual);
            }
            else{
                NoDuplo noAtual = inicio;
                for (int i =0; i>posicao; i++){
                   noAtual.getProximo();
                }
                novoNo.setProximo(noAtual);
                novoNo.setAnterior(noAtual.getAnterior());
                noAtual.setAnterior(novoNo);
            }
            tamanho++;
    }

    }
    

    @Override
    public T remover(int posicao) {
        return null;
    }

    @Override
    public T removerNoInicio() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removerNoFim() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T buscar(int posicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int existe(T elemento) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void limpar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int tamanho() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Lista.super.forEach(action); //To change body of generated methods, choose Tools | Templates.
    }
}

