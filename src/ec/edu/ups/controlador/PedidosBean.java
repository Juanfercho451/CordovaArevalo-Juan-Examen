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
import ec.edu.ups.entidad.TarjetaCredito;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidosBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private PedidosFacade ejbPedidosFacade;
	private List<Pedidos> list;
	private String fecha;
	private String nombreCliente;
	private double subtotal;
	private double iva;
	private double total;
	private String observaciones;
	private Comidas comidas;
	private TarjetaCredito tarjetaCredito;

	public PedidosBean() {

	}

	@PostConstruct
	public void init() {
		list = ejbPedidosFacade.findAll();
		comidas = new Comidas();
	}

	public String add() {

		System.out.println(this.comidas);
		ejbPedidosFacade.create(new Pedidos(this.fecha, this.nombreCliente, this.subtotal, this.iva, this.total, this.observaciones, this.comidas, this.tarjetaCredito));
		list = ejbPedidosFacade.findAll();
		System.out.println(this.comidas);
		return null;
	}

	public String delete(Pedidos c) {
		ejbPedidosFacade.remove(c);
		list = ejbPedidosFacade.findAll();
		return null;
	}

	public void buscarPorAlmacen() {
		if (comidas != null) {
			this.list = ejbPedidosFacade.findByAlmacen(this.comidas.getCodigo());
		} else {
			this.list = this.ejbPedidosFacade.findAll();
		}
	}

	public String edit(Pedidos c) {
		c.setEditable(true);
		return null;
	}

	public String save(Pedidos c) {
		ejbPedidosFacade.edit(c);
		c.setEditable(false);
		return null;
	}
}
