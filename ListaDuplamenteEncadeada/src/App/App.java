/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;

import Crud.Classes.Bem;
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
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int app = 1;
        ListaDuplamenteEncadeada<Pessoa> pessoas = new ListaDuplamenteEncadeada();
        String nome;
        String nomeBem;
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
                    System.out.println("Pessoa cadastrada com sucesso!!!");
                    System.out.println("Codigo de acesso: " + p.getCodigo()); 
                       break;
                case 2:
                    System.out.println("Informe o nome: ");
                    nome = sc.next();
                    int pos = 0;
                    boolean removido = false;
                    try{
                        for(Pessoa pe: pessoas){
                            if (pe.getNome().equals(nome)){
                            pessoas.remover(pos);
                            System.out.println("Pessoa Removida com sucesso!!");
                            removido = true;
                            }
                            pos++;
                        }
                        if (!removido){
                            System.out.println("Pessoa não encontrada!!!");
                    }
                    }
                    catch(NullPointerException e){
                        System.out.println("Nenhum cadastro no sistema!!!");
                    }
                    break;
                case 3:
                    try{
                        System.out.println("Informe o nome: ");
                        nome = sc.next();
                        boolean encontrado = false;
                        for(Pessoa pe: pessoas){
                            if(pe.getNome().equals(nome)){
                                System.out.printf("%-7s%-10s%s%s\n", "Cod Pessoa: ", pe.getCodigo(),"Nome: ", pe.getNome());
                                System.out.println("Relação de bens");
                                System.out.printf("%-8s%-10s%-23s%s\n", "CodBem", "Nome do bem", "", "Valor");
                                System.out.printf("%-8s%-5s%-16s%s\n", "------", "------------", "--------------", "-----------");
                                for (Bem b: pe.getListaBens()){
                                    System.out.printf("%-8d%-10s%-19s%-,5.2f%n\n", b.getCodigo(), b.getNome(), "", b.getValor());
                                }
                                encontrado = true;
                            }
                            if(!encontrado){
                                System.out.println("Pessoa não encontrada no sistema!!!");
                            }
                        }
                    }
                    catch(NullPointerException e){
                        
                    }
                    break;
                case 4:
                    if (pessoas.tamanho()>= 1){
                        System.out.printf("%-10s%2s%-25s%2s%-20s\n", "Cod Pessoa", " ", "Nome da Pessoa", " ", "Valor Total Bens");
                        System.out.printf("%-10s%2s%-25s%2s%-20s\n", "----------", " ", "------------------------", " ", "----------------");
                        for(Pessoa pessoa: pessoas){
                            System.out.printf("%10s%2s%-25s%2s%-,5.2f%n\n", pessoa.getCodigo(), " ", pessoa.getNome(), " ", pessoa.valorTotalBens());

                    }
                    }
                    else{
                        System.out.println("Nenhum cadastro no sistema!!!");
                    }

                    break;
                case 5:
                    System.out.print("Informe o Codigo da pessoa: ");
                    int codigo = sc.nextInt();
                    for(Pessoa pessoa: pessoas){
                        if(pessoa.getCodigo()==codigo){
                            System.out.print("Informe o codigo do bem: ");
                            int codigoBem = sc.nextInt();
                            System.out.print("Informe o nome do bem: ");
                            nomeBem = sc.next();
                            System.out.print("Informe o valor do bem: ");
                            double valorBem = sc.nextDouble();
                            try{
                                Bem bem = new Bem(codigoBem, nomeBem, valorBem);
                                pessoa.adicionarBem(bem);
                                System.out.println("Bem cadastrado com sucesso!!!");
                            }
                            catch (Exception e){
                                System.out.println("Erro: " + e.getMessage());
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.print("Informe o Codigo da pessoa: ");
                    codigo = sc.nextInt();
                    for(Pessoa pessoa: pessoas){
                        if(pessoa.getCodigo()==codigo){
                            System.out.print("Informe o codigo do bem: ");
                            int codigoBem = sc.nextInt();
                            try{
                                pos = 0;
                                for(var b: pessoa.getListaBens()){
                                    if(b.getCodigo()== codigoBem){
                                        pessoa.getListaBens().remover(pos);
                                        System.out.println("Bem removido com sucesso!!!");
                                        break;
                                    }
                                    pos++;
                                }
                            }
                            catch (NullPointerException e){
                                System.out.println("Erro: Nenhum bem cadastrado!!!");
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Opção incorreta!!!");
            }
        }
    }
    
}
