package br.com.gmauricio.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{
	
	@Cacheable("findByStatusPedido")
	public List<Pedido> findByStatusPedido(StatusPedido statusPedido, Pageable page);
	
	@Query("select p from Pedido p join p.user u where u.username = :username")
	public List<Pedido> findByUser(@Param("username") String username);
	
	@Query("select p from Pedido p join p.user u where u.username = :username and p.statusPedido = :statusPedido")
	public List<Pedido> findByUserAndStatus(@Param("username") String username, @Param("statusPedido") StatusPedido statusPedido);
	
}
