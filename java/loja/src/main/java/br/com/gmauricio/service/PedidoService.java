package br.com.gmauricio.service;

import java.util.List;

import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;

public interface PedidoService extends PersistenceService {

	public void salvar(Pedido pedido) throws Exception;
	
	public List<Pedido> lista(StatusPedido statusPedido) throws Exception;
	
	public List<Pedido> listaByUser(StatusPedido statusPedido, String username) throws Exception;
	
}
