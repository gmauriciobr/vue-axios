package br.com.gmauricio.service;

import br.com.gmauricio.dto.UsuarioDTO;

public interface UsuarioService extends PersistenceService {
	
	public void salvar(UsuarioDTO usuarioDTO) throws Exception;

}
