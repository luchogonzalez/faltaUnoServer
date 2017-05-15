/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.utn.mobile.faltaunoserver;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lgonzalez
 */
@Entity
@Table(name = "canchas")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Canchas.findAll", query = "SELECT c FROM Canchas c")
    , @NamedQuery(name = "Canchas.findByCanchaId", query = "SELECT c FROM Canchas c WHERE c.canchaId = :canchaId")
    , @NamedQuery(name = "Canchas.findByNombre", query = "SELECT c FROM Canchas c WHERE c.nombre = :nombre")
    , @NamedQuery(name = "Canchas.findByDireccion", query = "SELECT c FROM Canchas c WHERE c.direccion = :direccion")
    , @NamedQuery(name = "Canchas.findByUrlFoto", query = "SELECT c FROM Canchas c WHERE c.urlFoto = :urlFoto")})
public class Canchas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cancha_id")
    private Short canchaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "url_foto")
    private String urlFoto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "canchaId")
    private Collection<Partidos> partidosCollection;

    public Canchas() {
    }

    public Canchas(Short canchaId) {
        this.canchaId = canchaId;
    }

    public Canchas(Short canchaId, String nombre, String direccion, String urlFoto) {
        this.canchaId = canchaId;
        this.nombre = nombre;
        this.direccion = direccion;
        this.urlFoto = urlFoto;
    }

    public Short getCanchaId() {
        return canchaId;
    }

    public void setCanchaId(Short canchaId) {
        this.canchaId = canchaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getUrlFoto() {
        return urlFoto;
    }

    public void setUrlFoto(String urlFoto) {
        this.urlFoto = urlFoto;
    }

    @XmlTransient
    public Collection<Partidos> getPartidosCollection() {
        return partidosCollection;
    }

    public void setPartidosCollection(Collection<Partidos> partidosCollection) {
        this.partidosCollection = partidosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (canchaId != null ? canchaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Canchas)) {
            return false;
        }
        Canchas other = (Canchas) object;
        if ((this.canchaId == null && other.canchaId != null) || (this.canchaId != null && !this.canchaId.equals(other.canchaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.utn.mobile.faltaunoserver.Canchas[ canchaId=" + canchaId + " ]";
    }
    
}
