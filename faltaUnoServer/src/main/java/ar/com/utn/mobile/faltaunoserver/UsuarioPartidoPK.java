/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.utn.mobile.faltaunoserver;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author lgonzalez
 */
@Embeddable
public class UsuarioPartidoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "partido_id")
    private short partidoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id")
    private short usuarioId;

    public UsuarioPartidoPK() {
    }

    public UsuarioPartidoPK(short partidoId, short usuarioId) {
        this.partidoId = partidoId;
        this.usuarioId = usuarioId;
    }

    public short getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(short partidoId) {
        this.partidoId = partidoId;
    }

    public short getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(short usuarioId) {
        this.usuarioId = usuarioId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) partidoId;
        hash += (int) usuarioId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioPartidoPK)) {
            return false;
        }
        UsuarioPartidoPK other = (UsuarioPartidoPK) object;
        if (this.partidoId != other.partidoId) {
            return false;
        }
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ar.com.utn.mobile.faltaunoserver.UsuarioPartidoPK[ partidoId=" + partidoId + ", usuarioId=" + usuarioId + " ]";
    }
    
}
