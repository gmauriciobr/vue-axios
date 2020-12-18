package br.com.gmauricio.dto;

import javax.validation.constraints.NotNull;

import br.com.gmauricio.model.Usuario;

public class UsuarioDTO {
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public static Usuario parseToUser(UsuarioDTO dto) {
		Usuario user = new Usuario();
		user.setUsername(dto.getUsername());
		user.setPassword(dto.getPassword());
		return user;
	}

}
