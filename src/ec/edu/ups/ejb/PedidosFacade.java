package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Comidas;
import ec.edu.ups.entidad.Pedidos;

@Stateless
public class PedidosFacade extends AbstractFacade<Pedidos> {

    @PersistenceContext(unitName = "CordovaArevalo-Juan-Examen")
    private EntityManager em;

    public PedidosFacade() {
        super(Pedidos.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
  /*  @SuppressWarnings("unchecked")
  	public List<Pedidos> findByAlmacen(int codigo){
          String jpql = "select p from Product p where p.almacen.codigo="+codigo;
          return (List<Pedidos>) em.createQuery(jpql).getResultList();
          
      }*/
}
