package aula_jdbc;

public class Prdouto {
    private int id;
    private String nome;
    private int quantidade;
    private double preco;

    /* Prdouto(int id , String nome , int quantidade , double preco){
        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.preco = preco;
    } */
    public int getId(){
        return id;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public String getNome(){
        return nome;
    }
    public double getPreco(){
        return preco; 
    }
    public void setNome(String nome){
        this.nome =  nome;
    }
     public void setId(int id){
        this.id =  id;
    }
     public void setPreco(double preco){
        this.preco =  preco;
    }
     public void setQuantidade(int quantidade){
        this.quantidade =  quantidade;
    }
}
