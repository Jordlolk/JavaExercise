package aula_jdbc;

public class Venda {
    private int id;
    private double dataV;
    private int quantidade;
    private int idProduto;
    
    public int getId(){
        return id;
    }
    public int getQuantidade(){
        return quantidade;
    }
    public int getIdProduto(){
        return idProduto;
    }
    public double getDatav(){
        return dataV; 
    }
    public void setId(int id){
        this.id = id;
    }
    public void setQuantidade( int quantidade){
        this.quantidade = quantidade;
    }
    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }
    public void setDatav(Double dataV){
        this.dataV = dataV; 
    }
}
