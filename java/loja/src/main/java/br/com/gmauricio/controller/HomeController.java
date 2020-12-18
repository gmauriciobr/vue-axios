package br.com.gmauricio.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;
import br.com.gmauricio.service.PedidoService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	@Autowired
	private PedidoService pedidoService;

	@GetMapping()
	public String home(Model model, Principal principal) {
		try {
			List<Pedido> pedidos = pedidoService.lista(StatusPedido.E);
			model.addAttribute("pedidos", pedidos);
			return "home";
		} catch (Exception e) {
			return "redirect:/home";
		}
	}

}
