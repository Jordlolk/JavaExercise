package aula_jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CrudProduto {

   private PreparedStatement preparedStatement;

   public void inserir(Prdouto produto) throws SQLException{
        String sql = "INSERT INTO produto (id , nome , preco , quantidade) VALUES (?,?,?,?)";
        preparedStatement = null;
        try{
            preparedStatement = ParametrosDaConexao.getConnectionBD().prepareStatement(sql);
            preparedStatement.setInt(1, produto.getId());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setDouble(3, produto.getPreco());
            preparedStatement.setInt(4, produto.getQuantidade());
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("Dados inseridos com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } 
   }
   public void deletar(Prdouto produto) throws SQLException{
        String sql = "DELETE FROM produto WHERE id = ?";
        try{
            preparedStatement = ParametrosDaConexao.getConnectionBD().prepareStatement(sql);
            preparedStatement.setInt(1, produto.getId());
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("Dado deletado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        } 
   }
   public void update(Prdouto produto) throws SQLException{
        String sql = "UPDATE produto SET nome = ? WHERE id = ?";
        try{
            preparedStatement = ParametrosDaConexao.getConnectionBD().prepareStatement(sql);
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setInt(2, produto.getId());
            preparedStatement.execute();
            preparedStatement.close();
            System.out.println("Dados atualizados com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
   public  void select(Prdouto prdouto) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
        try {
            String sql = "SELECT * FROM clientes";
            preparedStatement = ParametrosDaConexao.getConnectionBD().prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {
            	Integer id = resultSet.getInt("id"); 
                String nome = resultSet.getString("nome");
                Integer quantidade = resultSet.getInt("quantidade");
                Double preco = resultSet.getDouble("Preço");
                System.out.println("Id: " + id + ", Nome: " + nome + "Quantidade: "+ quantidade + "Preço: " + preco);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
            	if(resultSet != null) {
            		resultSet.close();
				}
            	if(preparedStatement != null) {
					preparedStatement.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
    }
}

