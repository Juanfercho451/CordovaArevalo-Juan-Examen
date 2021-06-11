package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.entidad.Comidas;
import ec.edu.ups.entidad.Pedidos;
import ec.edu.ups.entidad.TarjetaCredito;

@Stateless
public class TarjetaCreditoFacade extends AbstractFacade<TarjetaCredito> {

    @PersistenceContext(unitName = "CordovaArevalo-Juan-Examen")
    private EntityManager em;

    public TarjetaCreditoFacade() {
        super(TarjetaCredito.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
