package entidade;

public class ItemPedido {
	private Integer quantidade;
	private Double preco;
	//referenciar o produto aos itens
	private Produto produto;
	
	public ItemPedido() {
		
	}
	
	public ItemPedido(Integer quantidade, Double preco, Produto produto) {
		this.quantidade = quantidade;
		this.preco = preco;
		this.produto = produto;
	}
	
	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}	

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public Double subTotal() {
		return preco * quantidade;
	}
	
	public String toString() {
		return produto.getNome() + ", R$ " + String.format("%.2f", preco) + 
				", Quantidade: " + quantidade + ", Subtotal: R$ " + String.format("%.2f", subTotal());
	}
}
