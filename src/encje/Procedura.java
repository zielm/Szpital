/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encje;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Monika
 */
@Entity
@Table(name = "PROCEDURY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Procedura.findAll", query = "SELECT p FROM Procedura p")
    , @NamedQuery(name = "Procedura.findByIdProcedury", query = "SELECT p FROM Procedura p WHERE p.idProcedury = :idProcedury")
    , @NamedQuery(name = "Procedura.findByNazwaProcedury", query = "SELECT p FROM Procedura p WHERE p.nazwaProcedury = :nazwaProcedury")})
public class Procedura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PROCEDURY")
    private String idProcedury;
    @Basic(optional = false)
    @Column(name = "NAZWA_PROCEDURY")
    private String nazwaProcedury;
    @OneToMany(mappedBy = "idProcedury")
    private Collection<Wizyta> wizytaCollection;

    public Procedura() {
    }

    public Procedura(String idProcedury) {
        this.idProcedury = idProcedury;
    }

    public Procedura(String idProcedury, String nazwaProcedury) {
        this.idProcedury = idProcedury;
        this.nazwaProcedury = nazwaProcedury;
    }

    public String getIdProcedury() {
        return idProcedury;
    }

    public void setIdProcedury(String idProcedury) {
        this.idProcedury = idProcedury;
    }

    public String getNazwaProcedury() {
        return nazwaProcedury;
    }

    public void setNazwaProcedury(String nazwaProcedury) {
        this.nazwaProcedury = nazwaProcedury;
    }

    @XmlTransient
    public Collection<Wizyta> getWizytaCollection() {
        return wizytaCollection;
    }

    public void setWizytaCollection(Collection<Wizyta> wizytaCollection) {
        this.wizytaCollection = wizytaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProcedury != null ? idProcedury.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Procedura)) {
            return false;
        }
        Procedura other = (Procedura) object;
        if ((this.idProcedury == null && other.idProcedury != null) || (this.idProcedury != null && !this.idProcedury.equals(other.idProcedury))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encje.Procedura[ idProcedury=" + idProcedury + " ]";
    }
    
}
