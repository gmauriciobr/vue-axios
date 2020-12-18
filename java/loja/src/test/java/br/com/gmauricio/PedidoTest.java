package br.com.gmauricio;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;
import br.com.gmauricio.service.PedidoService;

@SpringBootTest
@TestPropertySource(locations="classpath:application.properties")
public class PedidoTest {
	
	@Autowired
	private PedidoService pedidoService; 
	
	//@Test
	public void salvarPedido() throws Exception {
		Pedido pedido = new Pedido();
		pedido.setNome("Macbook Pro");
		pedido.setStatusPedido(StatusPedido.W);
		pedido.setValor(20000D);
		pedido.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/31IkiZm5yLL._AC_.jpg");
		pedido.setUrlProduto("https://www.amazon.com.br/Macbook-Retina-Apple-Cinza-Espacial/dp/B07XD61MSM/ref=sr_1_1?__mk_pt_BR=ÅMÅŽÕÑ&dchild=1&keywords=MacBook+pro&qid=1607735513&sr=8-1");
		pedido.setDescricao("...");
		
		pedidoService.salvar(pedido);
		
		Pedido pedido2 = new Pedido();
		pedido2.setNome("Echo (4ª Geração)");
		pedido2.setStatusPedido(StatusPedido.A);
		pedido2.setValor(800D);
		pedido2.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/71JB6hM6Z6L._AC_SL1000_.jpg");
		pedido2.setUrlProduto("https://www.amazon.com.br/dp/B085FXDTTX?pf_rd_r=190HM2AJ21YMYYH5D2E8&pf_rd_p=0cabd025-c6ef-4fc6-a60e-094dafdb91b6");
		pedido2.setDescricao("...");
		pedidoService.salvar(pedido2);
		
		Pedido pedido3 = new Pedido();
		pedido3.setNome("PlayStation 5");
		pedido3.setStatusPedido(StatusPedido.A);
		pedido3.setValor(800D);
		pedido3.setUrlImagem("https://images-na.ssl-images-amazon.com/images/I/51n%2B6VOTGrL._AC_SL1000_.jpg");
		pedido3.setUrlProduto("https://www.amazon.com.br/PlayStation-Console-PlayStation®5/dp/B088GNRX3J/ref=sr_1_1?__mk_pt_BR=ÅMÅŽÕÑ&dchild=1&keywords=ps5&qid=1607973512&sr=8-1");
		pedido3.setDescricao("...");
		pedidoService.salvar(pedido3);
		
		assertNotNull(pedido.getId());
		assertNotNull(pedido2.getId());
		assertNotNull(pedido3.getId());
	}

}
