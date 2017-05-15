/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.utn.mobile.faltaunoserver;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lgonzalez
 */
@Entity
@Table(name = "usuario_partido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioPartido.findAll", query = "SELECT u FROM UsuarioPartido u")
    , @NamedQuery(name = "UsuarioPartido.findByPartidoId", query = "SELECT u FROM UsuarioPartido u WHERE u.usuarioPartidoPK.partidoId = :partidoId")
    , @NamedQuery(name = "UsuarioPartido.findByUsuarioId", query = "SELECT u FROM UsuarioPartido u WHERE u.usuarioPartidoPK.usuarioId = :usuarioId")
    , @NamedQuery(name = "UsuarioPartido.findByEstadoUsuario", query = "SELECT u FROM UsuarioPartido u WHERE u.estadoUsuario = :estadoUsuario")})
public class UsuarioPartido implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioPartidoPK usuarioPartidoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "estado_usuario")
    private boolean estadoUsuario;
    @JoinColumn(name = "partido_id", referencedColumnName = "partido_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Partidos partidos;
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuarios usuarios;

    public UsuarioPartido() {
    }

    public UsuarioPartido(UsuarioPartidoPK usuarioPartidoPK) {
        this.usuarioPartidoPK = usuarioPartidoPK;
    }

    public UsuarioPartido(UsuarioPartidoPK usuarioPartidoPK, boolean estadoUsuario) {
        this.usuarioPartidoPK = usuarioPartidoPK;
        this.estadoUsuario = estadoUsuario;
    }

    public UsuarioPartido(short partidoId, short usuarioId) {
        this.usuarioPartidoPK = new UsuarioPartidoPK(partidoId, usuarioId);
    }

    public UsuarioPartidoPK getUsuarioPartidoPK() {
        return usuarioPartidoPK;
    }

    public void setUsuarioPartidoPK(UsuarioPartidoPK usuarioPartidoPK) {
        this.usuarioPartidoPK = usuarioPartidoPK;
    }

    public boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public Partidos getPartidos() {
        return partidos;
    }

    public void setPartidos(Partidos partidos) {
        this.partidos = partidos;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioPartidoPK != null ? usuarioPartidoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPartido)) {
            return false;
        }
        UsuarioPartido other = (UsuarioPartido) object;
        if ((this.usuarioPartidoPK == null && other.usuarioPartidoPK != null) || (this.usuarioPartidoPK != null && !this.usuarioPartidoPK.equals(other.usuarioPartidoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.utn.mobile.faltaunoserver.UsuarioPartido[ usuarioPartidoPK=" + usuarioPartidoPK + " ]";
    }
    
}
