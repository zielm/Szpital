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
@Table(name = "ROZPOZNANIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Rozpoznanie.findAll", query = "SELECT r FROM Rozpoznanie r")
    , @NamedQuery(name = "Rozpoznanie.findByIdRozpoznania", query = "SELECT r FROM Rozpoznanie r WHERE r.idRozpoznania = :idRozpoznania")
    , @NamedQuery(name = "Rozpoznanie.findByNazwaChoroby", query = "SELECT r FROM Rozpoznanie r WHERE r.nazwaChoroby = :nazwaChoroby")})
public class Rozpoznanie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ROZPOZNANIA")
    private String idRozpoznania;
    @Basic(optional = false)
    @Column(name = "NAZWA_CHOROBY")
    private String nazwaChoroby;
    @OneToMany(mappedBy = "idRozpoznania")
    private Collection<Wizyta> wizytaCollection;

    public Rozpoznanie() {
    }

    public Rozpoznanie(String idRozpoznania) {
        this.idRozpoznania = idRozpoznania;
    }

    public Rozpoznanie(String idRozpoznania, String nazwaChoroby) {
        this.idRozpoznania = idRozpoznania;
        this.nazwaChoroby = nazwaChoroby;
    }

    public String getIdRozpoznania() {
        return idRozpoznania;
    }

    public void setIdRozpoznania(String idRozpoznania) {
        this.idRozpoznania = idRozpoznania;
    }

    public String getNazwaChoroby() {
        return nazwaChoroby;
    }

    public void setNazwaChoroby(String nazwaChoroby) {
        this.nazwaChoroby = nazwaChoroby;
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
        hash += (idRozpoznania != null ? idRozpoznania.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Rozpoznanie)) {
            return false;
        }
        Rozpoznanie other = (Rozpoznanie) object;
        if ((this.idRozpoznania == null && other.idRozpoznania != null) || (this.idRozpoznania != null && !this.idRozpoznania.equals(other.idRozpoznania))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encje.Rozpoznanie[ idRozpoznania=" + idRozpoznania + " ]";
    }
    
}
