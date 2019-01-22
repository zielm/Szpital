/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encje;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Monika
 */
@Entity
@Table(name = "WYPISY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wypis.findAll", query = "SELECT w FROM Wypis w")
    , @NamedQuery(name = "Wypis.findByIdWizyty", query = "SELECT w FROM Wypis w WHERE w.idWizyty = :idWizyty")
    , @NamedQuery(name = "Wypis.findByDataWypisu", query = "SELECT w FROM Wypis w WHERE w.dataWypisu = :dataWypisu")
    , @NamedQuery(name = "Wypis.findByTypWypisu", query = "SELECT w FROM Wypis w WHERE w.typWypisu = :typWypisu")
    , @NamedQuery(name = "Wypis.findByZalecenia", query = "SELECT w FROM Wypis w WHERE w.zalecenia = :zalecenia")})
public class Wypis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_WIZYTY")
    private Long idWizyty;
    @Basic(optional = false)
    @Column(name = "DATA_WYPISU")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataWypisu;
    @Basic(optional = false)
    @Column(name = "TYP_WYPISU")
    private String typWypisu;
    @Column(name = "ZALECENIA")
    private String zalecenia;
    @JoinColumn(name = "ID_WIZYTY", referencedColumnName = "ID_WIZYTY", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Wizyta wizyta;

    public Wypis() {
    }

    public Wypis(Long idWizyty) {
        this.idWizyty = idWizyty;
    }

    public Wypis(Long idWizyty, Date dataWypisu, String typWypisu) {
        this.idWizyty = idWizyty;
        this.dataWypisu = dataWypisu;
        this.typWypisu = typWypisu;
    }

    public Long getIdWizyty() {
        return idWizyty;
    }

    public void setIdWizyty(Long idWizyty) {
        this.idWizyty = idWizyty;
    }

    public Date getDataWypisu() {
        return dataWypisu;
    }

    public void setDataWypisu(Date dataWypisu) {
        this.dataWypisu = dataWypisu;
    }

    public String getTypWypisu() {
        return typWypisu;
    }

    public void setTypWypisu(String typWypisu) {
        this.typWypisu = typWypisu;
    }

    public String getZalecenia() {
        return zalecenia;
    }

    public void setZalecenia(String zalecenia) {
        this.zalecenia = zalecenia;
    }

    public Wizyta getWizyta() {
        return wizyta;
    }

    public void setWizyta(Wizyta wizyta) {
        this.wizyta = wizyta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idWizyty != null ? idWizyty.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wypis)) {
            return false;
        }
        Wypis other = (Wypis) object;
        if ((this.idWizyty == null && other.idWizyty != null) || (this.idWizyty != null && !this.idWizyty.equals(other.idWizyty))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encje.Wypis[ idWizyty=" + idWizyty + " ]";
    }
    
}
