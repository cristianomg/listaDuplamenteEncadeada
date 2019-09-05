/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Crud.Classes.Pessoa;
import ListaDuplamenteEncadeada.classes.ListaDuplamenteEncadeada;
import java.util.Scanner;

/**
 *
 * @author cristiano pc
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int app = 1;
        ListaDuplamenteEncadeada<Pessoa> pessoas = new ListaDuplamenteEncadeada();
        String nome;
        while (app == 1){
            System.out.println("1- Incluir Pessoa");
            System.out.println("2- Excluir Pessoa");
            System.out.println("3- Consultar Pessoa");
            System.out.println("4- Listar Pessoas");
            System.out.println("5- Incluir Bem");
            System.out.println("6- Excluir Bem");
            int opc = sc.nextInt();
            switch(opc){
                case 1:
                    System.out.println("Informe o nome: ");
                    nome = sc.next();
                    Pessoa p = new Pessoa(nome);
                    pessoas.adicionar(p);
                        break;
                case 2:
                    System.out.println("Informe o nome: ");
                    nome = sc.next();
                    int pos = 0;
                    boolean removido = false;
                    for(Pessoa pe: pessoas){
                        if (pe.getNome().equals(nome)){
                            pessoas.remover(pos);
                            System.out.println("Pessoa Removida!!");
                            removido = true;
                        }
                        pos++;
                        if (!removido){
                            System.out.println("Pessoa não encontrada!!!");
                        }
                    }
                    break;
                case 3:
                    break;
                case 4:
                    for(Pessoa pessoa: pessoas){
                        System.out.println(pessoa.getNome() + pessoa.getCodigo());
                    }
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opção incorreta!!!");
            }
        }
    }
    
}
