package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Usuario;

@Repository
@Transactional
public class UsuarioDAO implements UserDetailsService {

    @PersistenceContext
    private EntityManager manager;

    public Usuario loadUserByUsername(String email) {
        List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
                .setParameter("email", email).getResultList();

        if (usuarios.isEmpty()) {
            throw new UsernameNotFoundException("Usuario " + email + " não foi encontrado");
        }

        return usuarios.get(0);
    }

    public void gravar(Usuario usuario) {
        manager.persist(usuario);
    }
    
    public void deletar(String email) {
    	manager.createQuery("delete from Usuario where email = :email").setParameter("email", email).executeUpdate();
    }
    
    public List<Usuario> listarUsuarios() {
        return manager.createQuery("select distinct(u) from Usuario u", Usuario.class).getResultList();
    }
    
    public Boolean testaEmail(String email) {
    	List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
                .setParameter("email", email).getResultList();

        if (usuarios.isEmpty()) {
            return false;
        }

        return true;
    }
    public Usuario buscaEmail(String email) {
    	List<Usuario> usuarios = manager.createQuery("select u from Usuario u where email = :email", Usuario.class)
                .setParameter("email", email).getResultList();

        if (usuarios.isEmpty()) {
            throw new EntityExistsException("Email não encontrado");
        }

        return usuarios.get(0);
    }
}