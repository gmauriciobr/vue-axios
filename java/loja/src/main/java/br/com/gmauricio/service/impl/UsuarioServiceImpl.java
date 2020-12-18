package br.com.gmauricio.service.impl;

import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.gmauricio.dto.UsuarioDTO;
import br.com.gmauricio.model.Usuario;
import br.com.gmauricio.service.UsuarioService;

@Service
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class UsuarioServiceImpl extends PersistenceServiceImpl implements UsuarioService {
	
	public static final Log LOG = LogFactory.getLog(UsuarioServiceImpl.class);
	
	public void salvar(UsuarioDTO usuarioDTO) throws Exception {
		try {
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			Usuario user = UsuarioDTO.parseToUser(usuarioDTO);
			user.setPassword(encoder.encode(usuarioDTO.getPassword()));
			user.setEnabled(true);
			
			this.getEm().persist(user);
			this.getEm().flush();
			
			StringBuilder sql = new StringBuilder();
			sql.append("insert into authorities values (:user, :role)");
			Query query = this.getEm().createNativeQuery(sql.toString());
			query.setParameter("user", user.getUsername());
			query.setParameter("role", "ROLE_USER");
			query.executeUpdate();
			
			this.getEm().flush();
		} catch (Exception e) {
			LOG.error(e);
			throw new Exception("Erro ao salvar usuario: " + e);
		}
	}

}
