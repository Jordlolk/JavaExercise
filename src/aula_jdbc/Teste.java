package aula_jdbc;

public class Teste {
    public static void main(String[] args){
        CrudVenda objeto = new CrudVenda();
        CrudProduto produtoCrud = new CrudProduto();
        Prdouto produtoEstoque = new Prdouto();
        Venda produto = new Venda();
        produtoEstoque.setId(1);
        produtoEstoque.setNome("Vaso");
        produtoEstoque.setQuantidade(30);
        produtoEstoque.setPreco(20.0);
        produto.setId(1);
        produto.setDatav(20.2);
        produto.setIdProduto(produtoEstoque.getId());
        produto.setQuantidade(20);
        try {
            produtoCrud.inserir(produtoEstoque);
            objeto.cadastrar(produto, produtoEstoque);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
