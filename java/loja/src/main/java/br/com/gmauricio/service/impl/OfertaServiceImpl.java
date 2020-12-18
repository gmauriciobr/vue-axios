package br.com.gmauricio.service.impl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.gmauricio.model.Oferta;
import br.com.gmauricio.service.OfertaService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class OfertaServiceImpl extends PersistenceServiceImpl implements OfertaService {
	
	public static final Log LOG = LogFactory.getLog(OfertaServiceImpl.class);
	
	@Override
	public void salvar(Oferta oferta) throws Exception {
		try {
			this.getEm().persist(oferta);
			this.getEm().flush();
		} catch (Exception e) {
			throw new Exception("Erro ao salvar oferta: " + e);
		}
	}

}
