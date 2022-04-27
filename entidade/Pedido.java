package entidade;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entidade_enum.StatusPedido;

public class Pedido {
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	private Date data;
	private StatusPedido status;	
	private Cliente cliente;
	private List<ItemPedido> itens = new ArrayList<>();
	
	
	public Pedido() {
		
	}
	
	public Pedido(Date data, StatusPedido status, Cliente cliente) {
		this.data = data;
		this.status = status;
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public void addItem(ItemPedido item) {
		itens.add(item);
	}
	
	public void removeItem(ItemPedido item) {
		itens.remove(item);
	}
	
	public double totalPedido() {
		double soma = 0;
		for (ItemPedido item : itens) {
			soma += item.subTotal();
		}
		return soma;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Data: ");
		sb.append(sdf.format(data) + "\n");
		sb.append("Status Pedido: ");
		sb.append(status + "\n");
		sb.append(cliente + "\n");
		sb.append("Itens do pedido:\n");
		for (ItemPedido item : itens) {
			sb.append(item + "\n");
		}
		sb.append("Valor Total: R$");
		sb.append(String.format("%.2f", totalPedido()));
		return sb.toString();
	}

}
