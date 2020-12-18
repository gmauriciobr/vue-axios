package br.com.gmauricio.dto;


import javax.validation.constraints.NotBlank;

import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;

public class PedidoDTO {
	
	private Long id;
	@NotBlank
	private String nome;
	@NotBlank
	private String urlProduto;
	@NotBlank
	private String urlImagem;
	private String descricao;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUrlProduto() {
		return urlProduto;
	}
	public void setUrlProduto(String urlProduto) {
		this.urlProduto = urlProduto;
	}
	public String getUrlImagem() {
		return urlImagem;
	}
	public void setUrlImagem(String urlImagem) {
		this.urlImagem = urlImagem;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static Pedido parseToPedido(PedidoDTO pedidoDTO) {
		Pedido pedido = new Pedido();
		pedido.setNome(pedidoDTO.getNome());
		pedido.setUrlProduto(pedidoDTO.getUrlProduto());
		pedido.setUrlImagem(pedidoDTO.getUrlImagem());
		pedido.setDescricao(pedidoDTO.getDescricao());
		pedido.setStatusPedido(StatusPedido.W);
		return pedido;
	}
	

}
