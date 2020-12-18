package br.com.gmauricio.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.gmauricio.dto.UsuarioDTO;
import br.com.gmauricio.model.Pedido;
import br.com.gmauricio.model.Pedido.StatusPedido;
import br.com.gmauricio.service.PedidoService;
import br.com.gmauricio.service.UsuarioService;

@Controller
@RequestMapping("usuario")
public class UsuarioController {
	
	@Autowired
	private PedidoService pedidoService;
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("pedido")
	public String home(Model model, Principal principal) {
		try {
			List<Pedido> pedidos = pedidoService.listaByUser(null, principal.getName());
			model.addAttribute("pedidos", pedidos);
			return "usuario/home";
		} catch (Exception e) {
			return "redirect:/usuario/home";
		}
	}
	
	@GetMapping("pedido/{statusPedido}")
	public String statusPedido(@PathVariable("statusPedido") String statusPedido, Model model) {
		try {
			model.addAttribute("pedidos", pedidoService.lista(StatusPedido.valueOf(statusPedido)));
			return "usuario/home";
		} catch (Exception e) {
			return "redirect:/usuario/home";
		}
	}
	
	@GetMapping("cadastro")
	public String cadastroUsuario(Model model) {
		model.addAttribute("usuarioDTO", new UsuarioDTO());
		return "usuario";
	}
	
	@PostMapping("cadastro")
	public String salvarUsuario(@Valid UsuarioDTO usuarioDTO) {
		try {
			usuarioService.salvar(usuarioDTO);
			return "redirect:/home";
		} catch (Exception e) {
			return "usuario";
		}
		
	}
	
	@ExceptionHandler(IllegalArgumentException.class)
	public String onErro() {
		return "redirect:/usuario/home";
	} 

}
