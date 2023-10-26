package aula_jdbc;

import java.sql.PreparedStatement;
import java.sql.SQLException;



public class CrudVenda {
   private PreparedStatement statementAdjust;
   private PreparedStatement preparedStatement;

     public void cadastrar(Venda venda , Prdouto produto) throws SQLException{
         String sql = "INSERT INTO venda (id ,data_de_venda, quantidade , id_do_produto) VALUES (?,?,?,?)";
         statementAdjust = null;
         preparedStatement = null;
        try{
            preparedStatement = ParametrosDaConexao.getConnectionBD().prepareStatement(sql);
            preparedStatement.setInt(1,venda.getId());
            preparedStatement.setDouble(2,  venda.getDatav());
            preparedStatement.setInt(3, venda.getQuantidade());
            preparedStatement.setInt(4, venda.getIdProduto());
            try {
                String sql2 = "UPDATE produto SET quantidade = ? WHERE id = ?";
                statementAdjust = ParametrosDaConexao.getConnectionBD().prepareStatement(sql2);
                statementAdjust.setInt(1, produto.getQuantidade() - venda.getQuantidade());
                statementAdjust.setInt(2, produto.getId());
                statementAdjust.execute();
                statementAdjust.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            int valorQuantidade = venda.getQuantidade();
            if(valorQuantidade <= 0){
                throw new RuntimeException("Erro : Quantidade à venda é inaceitavél");
            } else{
                preparedStatement.execute();
                preparedStatement.close();
                System.out.println("Venda cadastrada com sucesso!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
   }
        public void canelar(Venda venda , Prdouto produto) throws SQLException{
            String sql = "DELETE FROM venda WHERE id = ?";
            try{
                preparedStatement = ParametrosDaConexao.getConnectionBD().prepareStatement(sql);
                preparedStatement.setInt(1, venda.getId());
                preparedStatement.execute();
                produto.setQuantidade(produto.getQuantidade() + venda.getQuantidade());
                preparedStatement.close();
                System.out.println("Dado da venda , deletado com sucesso!");
            } catch (Exception e) {
                e.printStackTrace();
        } 
    }
}
