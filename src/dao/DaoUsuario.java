package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import model.Usuario;
import services.Manager;

/**
 *
 * @author Jonas Marcos
 */
public class DaoUsuario {
    
    private EntityManager em;
    
    public DaoUsuario() {
        
        em = Manager.getInstance().getEm();      
    }
    
    public void salvar (Usuario u) {
        
        em.getTransaction().begin();
        
        if(u.getCodigo()>0){
            u = em.merge(u);
        } else {
        }
        
        em.persist(u);
        em.getTransaction().commit();
    }
    
    public List<Usuario> getAll() {
        
        Query qry = em.createQuery("Select u from model.Usuario u ");
        List usuarios = qry.getResultList();
        
        return (List<Usuario>) usuarios;
    }
    
    public void remover(Usuario u) {
    
        em.getTransaction().begin();
        em.remove(u);
        em.getTransaction().commit();
}
    
}
