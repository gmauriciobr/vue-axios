package br.com.gmauricio.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import br.com.gmauricio.model.Oferta;
import br.com.gmauricio.model.Pedido;

public class OfertaDTO {
	
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
	
	private Long idPedido;
	@NotNull
	@Pattern(regexp = "^\\d+(\\.\\d{2})?$", message = "Valor deve ser númerico")
	private String valor;
	@NotNull
	@Pattern(regexp = "^\\d{2}/\\d{2}/\\d{4}$", message = "Formato deve ser dd/MM/yyyy")
	private String dataEntrega;
	private String comentario;
	
	public Long getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(Long idPedido) {
		this.idPedido = idPedido;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	public static Oferta parseToOferta(OfertaDTO dto) {
		Oferta oferta = new Oferta();
		oferta.setPedido(new Pedido(dto.getIdPedido()));
		oferta.setValor(new Double(dto.getValor()));
		oferta.setDataEntrega(LocalDate.parse(dto.getDataEntrega(), formatter));
		oferta.setComentario(dto.getComentario());
		return oferta;
	}

}
