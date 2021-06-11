package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Almacen
 *
 */
@Entity

public class Comidas implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String nombre;
	private double precio_unitario;
	@OneToMany(mappedBy = "comidas")
	private List<Pedidos> pedidos;
	@Transient
	private boolean editable;

	public Comidas() {
		super();
	}
	public Comidas(String nombre, double precio_unitario ) {
		this.nombre = nombre;
		this.precio_unitario = precio_unitario;
		
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
	public List<Pedidos> getPedidos() {
		return pedidos;
	}
	public void setPedidos(List<Pedidos> pedidos) {
		this.pedidos = pedidos;
	}
	public boolean isEditable() {
		return editable;
	}
	public void setEditable(boolean editable) {
		this.editable = editable;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio_unitario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comidas other = (Comidas) obj;
		if (codigo != other.codigo)
			return false;
		if (editable != other.editable)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pedidos == null) {
			if (other.pedidos != null)
				return false;
		} else if (!pedidos.equals(other.pedidos))
			return false;
		if (Double.doubleToLongBits(precio_unitario) != Double.doubleToLongBits(other.precio_unitario))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Comidas [codigo=" + codigo + ", nombre=" + nombre + ", precio_unitario=" + precio_unitario
				+ ", pedidos=" + pedidos + ", editable=" + editable + "]";
	}
	

	
}
