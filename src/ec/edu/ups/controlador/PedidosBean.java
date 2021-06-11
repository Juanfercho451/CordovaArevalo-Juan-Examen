package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ComidasFacade;
import ec.edu.ups.ejb.PedidosFacade;
import ec.edu.ups.entidad.Comidas;
import ec.edu.ups.entidad.Pedidos;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private PedidosFacade ejbPedidosFacade;
	private List<Pedidos> list;
	private String nombre;
	private double costoUnitario;
	private int stock;
	private Comidas comidas;
	//private Almacen almacen;

	public PedidosBean() {

	}

	@PostConstruct
	public void init() {
		list = ejbPedidosFacade.findAll();
		comidas = new Comidas();
	}

	

	public String add() {

		System.out.println(this.categoria);
		ejbProductFacade.create(new Product(this.nombre, this.costoUnitario, this.stock, this.categoria, this.almacen));
		list = ejbProductFacade.findAll();
		System.out.println(this.almacen);
		return null;
	}

	public String delete(Product c) {
		ejbProductFacade.remove(c);
		list = ejbProductFacade.findAll();
		return null;
	}

	public void buscarPorAlmacen() {
		if (almacen != null) {
			this.list = ejbProductFacade.findByAlmacen(this.almacen.getCodigo());
		} else {
			this.list = this.ejbProductFacade.findAll();
		}
	}

	public String edit(Product c) {
		c.setEditable(true);
		return null;
	}

	public String save(Product c) {
		ejbProductFacade.edit(c);
		c.setEditable(false);
		return null;
	}
}
