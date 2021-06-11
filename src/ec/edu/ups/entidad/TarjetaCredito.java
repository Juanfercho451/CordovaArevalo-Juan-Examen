package ec.edu.ups.entidad;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Almacen
 *
 */
@Entity

public class TarjetaCredito implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int codigo;
	private String numeroTarjeta;
	private String nombreTitular;
	private String fechaCaducidad;
	private int codigoVerificacion;

	@OneToMany(mappedBy = "tarjetaCredito")
	private List<Pedidos> pedidos;
	@Transient
	private boolean editable;

	public TarjetaCredito() {
		super();
	}

	public TarjetaCredito(String numeroTarjeta, String nombreTitutlar, String FechaCaducidad, int codigoVerificacion) {
		this.numeroTarjeta = numeroTarjeta;
		this.nombreTitular = nombreTitutlar;
		this.fechaCaducidad = fechaCaducidad;
		this.codigoVerificacion = codigoVerificacion;

	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
		result = prime * result + codigoVerificacion;
		result = prime * result + (editable ? 1231 : 1237);
		result = prime * result + ((fechaCaducidad == null) ? 0 : fechaCaducidad.hashCode());
		result = prime * result + ((nombreTitular == null) ? 0 : nombreTitular.hashCode());
		result = prime * result + ((numeroTarjeta == null) ? 0 : numeroTarjeta.hashCode());
		result = prime * result + ((pedidos == null) ? 0 : pedidos.hashCode());
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
		TarjetaCredito other = (TarjetaCredito) obj;
		if (codigo != other.codigo)
			return false;
		if (codigoVerificacion != other.codigoVerificacion)
			return false;
		if (editable != other.editable)
			return false;
		if (fechaCaducidad == null) {
			if (other.fechaCaducidad != null)
				return false;
		} else if (!fechaCaducidad.equals(other.fechaCaducidad))
			return false;
		if (nombreTitular == null) {
			if (other.nombreTitular != null)
				return false;
		} else if (!nombreTitular.equals(other.nombreTitular))
			return false;
		if (numeroTarjeta == null) {
			if (other.numeroTarjeta != null)
				return false;
		} else if (!numeroTarjeta.equals(other.numeroTarjeta))
			return false;
		if (pedidos == null) {
			if (other.pedidos != null)
				return false;
		} else if (!pedidos.equals(other.pedidos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "TarjetaCredito [codigo=" + codigo + ", numeroTarjeta=" + numeroTarjeta + ", nombreTitular="
				+ nombreTitular + ", fechaCaducidad=" + fechaCaducidad + ", codigoVerificacion=" + codigoVerificacion
				+ ", pedidos=" + pedidos + ", editable=" + editable + "]";
	}

}
