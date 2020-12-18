package br.com.gmauricio.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.gmauricio.service.PersistenceService;

public class PersistenceServiceImpl implements PersistenceService {

	@PersistenceContext
	private EntityManager em;

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}


}
