package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ComidasFacade;
import ec.edu.ups.ejb.TarjetaCreditoFacade;
import ec.edu.ups.entidad.Comidas;
import ec.edu.ups.entidad.TarjetaCredito;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class TarjetaCreditoBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private TarjetaCreditoFacade ejbTarjetaCredito;

	private List<TarjetaCredito> list;
	private String numeroTarjeta;
	private String nombreTitular;
	private String fechaCaducidad;
	private int codigoVerificacion;

	public TarjetaCreditoBean() {
		super();
	}

	@PostConstruct
	public void init() {
		list = ejbTarjetaCredito.findAll();
	}

	public List<TarjetaCredito> getList() {
		return list;
	}

	public void setList(List<TarjetaCredito> list) {
		this.list = list;
	}

	public String getNumeroTarjeta() {
		return numeroTarjeta;
	}

	public void setNumeroTarjeta(String numeroTarjeta) {
		this.numeroTarjeta = numeroTarjeta;
	}

	public String getNombreTitular() {
		return nombreTitular;
	}

	public void setNombreTitular(String nombreTitular) {
		this.nombreTitular = nombreTitular;
	}

	public String getFechaCaducidad() {
		return fechaCaducidad;
	}

	public void setFechaCaducidad(String fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}

	public int getCodigoVerificacion() {
		return codigoVerificacion;
	}

	public void setCodigoVerificacion(int codigoVerificacion) {
		this.codigoVerificacion = codigoVerificacion;
	}

	public String add() {
		ejbTarjetaCredito.create(new TarjetaCredito(this.numeroTarjeta, this.nombreTitular, this.fechaCaducidad,
				this.codigoVerificacion));
		list = ejbTarjetaCredito.findAll();
		return null;
	}

	public String delete(TarjetaCredito c) {
		ejbTarjetaCredito.remove(c);
		list = ejbTarjetaCredito.findAll();
		return null;
	}

	public String edit(TarjetaCredito c) {
		c.setEditable(true);
		return null;
	}

	public String save(TarjetaCredito c) {
		ejbTarjetaCredito.edit(c);
		c.setEditable(false);
		return null;
	}
}
