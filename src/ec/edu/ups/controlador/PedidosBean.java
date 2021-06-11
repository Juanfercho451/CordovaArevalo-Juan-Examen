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
		tarjetaCredito = new TarjetaCredito();
	}
	
	

	public List<Pedidos> getList() {
		return list;
	}

	public void setList(List<Pedidos> list) {
		this.list = list;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public double getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public double getIva() {
		return iva;
	}

	public void setIva(double iva) {
		this.iva = iva;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Comidas getComidas() {
		return comidas;
	}

	public void setComidas(Comidas comidas) {
		this.comidas = comidas;
	}

	public TarjetaCredito getTarjetaCredito() {
		return tarjetaCredito;
	}

	public void setTarjetaCredito(TarjetaCredito tarjetaCredito) {
		this.tarjetaCredito = tarjetaCredito;
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

	public void buscarPorTarjeta() {
		if (tarjetaCredito != null) {
			this.list = ejbPedidosFacade.findByAlmacen(this.tarjetaCredito.getCodigo());
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
