package br.com.gmauricio.service.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;
import br.com.gmauricio.repository.PedidoRepository;
import br.com.gmauricio.service.PedidoService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class PedidoServiceImpl extends PersistenceServiceImpl implements PedidoService {
	
	public static final Log LOG = LogFactory.getLog(PedidoServiceImpl.class);
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Override
	public void salvar(Pedido pedido) throws Exception {
		try {
			this.getEm().persist(pedido);
			this.getEm().flush();
		} catch (Exception e) {
			throw new Exception("Erro ao salvar pedido: " + e);
		}
	}
	
	@Override
	public List<Pedido> lista(StatusPedido statusPedido) throws Exception {
		try {
			return pedidoRepository.findByStatusPedido(statusPedido, PageRequest.of(0, 10, Sort.by("dataEntrega")));
		} catch(Exception e) {
			LOG.error(e);
			throw new Exception("Erro ao lista " + e);
		}
	}
	
	@Override
	public List<Pedido> listaByUser(StatusPedido statusPedido, String username) throws Exception {
		try {
			if(statusPedido == null) {
				return pedidoRepository.findByUser(username);
			} else {
				return pedidoRepository.findByUserAndStatus(username, null);
			}
		} catch (Exception e) {
			LOG.error(e);
			throw new Exception("Erro ao listaByUser: " + e);
		}
	}

}
