/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.utn.mobile.faltaunoserver;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author lgonzalez
 */
@Entity
@Table(name = "partidos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Partidos.findAll", query = "SELECT p FROM Partidos p")
    , @NamedQuery(name = "Partidos.findByPartidoId", query = "SELECT p FROM Partidos p WHERE p.partidoId = :partidoId")
    , @NamedQuery(name = "Partidos.findByFecha", query = "SELECT p FROM Partidos p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Partidos.findByHora", query = "SELECT p FROM Partidos p WHERE p.hora = :hora")
    , @NamedQuery(name = "Partidos.findByDuracion", query = "SELECT p FROM Partidos p WHERE p.duracion = :duracion")
    , @NamedQuery(name = "Partidos.findByJugFaltantes", query = "SELECT p FROM Partidos p WHERE p.jugFaltantes = :jugFaltantes")
    , @NamedQuery(name = "Partidos.findByModo", query = "SELECT p FROM Partidos p WHERE p.modo = :modo")})
public class Partidos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "partido_id")
    private Short partidoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "hora")
    @Temporal(TemporalType.TIME)
    private Date hora;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private float duracion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "jug_faltantes")
    private short jugFaltantes;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modo")
    private boolean modo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "partidos")
    private Collection<UsuarioPartido> usuarioPartidoCollection;
    @JoinColumn(name = "cancha_id", referencedColumnName = "cancha_id")
    @ManyToOne(optional = false)
    private Canchas canchaId;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    @ManyToOne(optional = false)
    private Usuarios usuarioId;

    public Partidos() {
    }

    public Partidos(Short partidoId) {
        this.partidoId = partidoId;
    }

    public Partidos(Short partidoId, Date fecha, Date hora, float duracion, short jugFaltantes, boolean modo) {
        this.partidoId = partidoId;
        this.fecha = fecha;
        this.hora = hora;
        this.duracion = duracion;
        this.jugFaltantes = jugFaltantes;
        this.modo = modo;
    }

    public Short getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(Short partidoId) {
        this.partidoId = partidoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getHora() {
        return hora;
    }

    public void setHora(Date hora) {
        this.hora = hora;
    }

    public float getDuracion() {
        return duracion;
    }

    public void setDuracion(float duracion) {
        this.duracion = duracion;
    }

    public short getJugFaltantes() {
        return jugFaltantes;
    }

    public void setJugFaltantes(short jugFaltantes) {
        this.jugFaltantes = jugFaltantes;
    }

    public boolean getModo() {
        return modo;
    }

    public void setModo(boolean modo) {
        this.modo = modo;
    }

    @XmlTransient
    public Collection<UsuarioPartido> getUsuarioPartidoCollection() {
        return usuarioPartidoCollection;
    }

    public void setUsuarioPartidoCollection(Collection<UsuarioPartido> usuarioPartidoCollection) {
        this.usuarioPartidoCollection = usuarioPartidoCollection;
    }

    public Canchas getCanchaId() {
        return canchaId;
    }

    public void setCanchaId(Canchas canchaId) {
        this.canchaId = canchaId;
    }

    public Usuarios getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Usuarios usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (partidoId != null ? partidoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Partidos)) {
            return false;
        }
        Partidos other = (Partidos) object;
        if ((this.partidoId == null && other.partidoId != null) || (this.partidoId != null && !this.partidoId.equals(other.partidoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.utn.mobile.faltaunoserver.Partidos[ partidoId=" + partidoId + " ]";
    }
    
}
