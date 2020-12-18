package br.com.gmauricio.service;

import br.com.gmauricio.model.Oferta;

public interface OfertaService extends PersistenceService {

	public void salvar(Oferta oferta) throws Exception;
	
}
