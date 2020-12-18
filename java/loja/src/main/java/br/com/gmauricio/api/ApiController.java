package br.com.gmauricio.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gmauricio.dto.OfertaDTO;
import br.com.gmauricio.model.Oferta;
import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;
import br.com.gmauricio.service.OfertaService;
import br.com.gmauricio.service.PedidoService;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private OfertaService ofertaService;

	@GetMapping("/pedido/aguardando")
	public ResponseEntity<List<Pedido>> getPedidosAguardando(){
		try {
			return ResponseEntity.ok(pedidoService.lista(StatusPedido.W));
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping("/oferta")
	public ResponseEntity<Oferta> criaOferta(@Valid @RequestBody OfertaDTO ofertaDTO) {
		try {
			Oferta oferta = OfertaDTO.parseToOferta(ofertaDTO);
			ofertaService.salvar(oferta);
			return ResponseEntity.ok(oferta);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
}
