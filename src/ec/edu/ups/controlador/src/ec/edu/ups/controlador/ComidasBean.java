package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.ejb.ComidasFacade;
import ec.edu.ups.entidad.Comidas;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ComidasBean implements Serializable {
	private static final long serialVersionUID = 1L;

	@EJB
	private ComidasFacade ejbComidasFacade;

	private List<Comidas> list;
	private String nombre;
	private double precio_unitario;

	public ComidasBean() {

	}

	@PostConstruct
	public void init() {
		list = ejbComidasFacade.findAll();
	}

	public List<Comidas> getList() {
		return list;
	}

	public void setList(List<Comidas> list) {
		this.list = list;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
	public double getPrecio_unitario() {
		return precio_unitario;
	}

	public void setPrecio_unitario(double precio_unitario) {
		this.precio_unitario = precio_unitario;
	}

	public String add() {
		ejbComidasFacade.create(new Comidas(this.nombre, this.precio_unitario));
		list = ejbComidasFacade.findAll();
		return null;
	}

	public String delete(Comidas c) {
		ejbComidasFacade.remove(c);
		list = ejbComidasFacade.findAll();
		return null;
	}

	public String edit(Comidas c) {
		c.setEditable(true);
		return null;
	}

	public String save(Comidas c) {
		ejbComidasFacade.edit(c);
		c.setEditable(false);
		return null;
	}
}