package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entidade.Cliente;
import entidade.ItemPedido;
import entidade.Pedido;
import entidade.Produto;
import entidade_enum.StatusPedido;

public class main {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
		
		System.out.println("Entre com os dados do cliente:");
		
		//coleta de dados
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Nome: ");
		String nome = sc.next();
		System.out.print("Email: ");
		String email = sc.next();
		System.out.print("Data nascimento: ");
		Date dataNascimento = sdf.parse(sc.next());
		System.out.println();
		
		//instanciando cliente
		Cliente cliente = new Cliente(nome, email, dataNascimento);
				
		System.out.println("Entre com os dados do Pedido:");
		System.out.print("Status: ");
		StatusPedido  statusPedido = StatusPedido.valueOf(sc.next());		
		
		// instanciando pedido
		Pedido pedido = new Pedido(new Date(), statusPedido, cliente);
		
		System.out.print("Quantos itens tera seu pedido ?");
		int quantidadeItens = sc.nextInt();
		
		//pegar itens do pedido
		for (int i = 0; i < quantidadeItens; i++) {
			System.out.println("Entre com o item #" + (i+1));
			System.out.print("Nome Produto: ");
			String nomeProduto = sc.next();
			System.out.print("Preço Produto: ");
			double precoProduto = sc.nextDouble();
			System.out.print("Quantidade: ");
			int quantidadeProduto = sc.nextInt();
			
			Produto produto = new Produto(nomeProduto, precoProduto);
			ItemPedido item = new ItemPedido(quantidadeProduto, precoProduto, produto);
			pedido.addItem(item);			
		}		
		sc.close();
		
		//saidas
		System.out.println();
		System.out.println("Detalhes do Pedido:");
		System.out.println(pedido);
		
		
	}

}
