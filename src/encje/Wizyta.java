/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encje;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Monika
 */
@Entity
@Table(name = "WIZYTY")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wizyta.findAll", query = "SELECT w FROM Wizyta w")
    , @NamedQuery(name = "Wizyta.findByIdWizyty", query = "SELECT w FROM Wizyta w WHERE w.idWizyty = :idWizyty")
    , @NamedQuery(name = "Wizyta.findByDataPrzyjecia", query = "SELECT w FROM Wizyta w WHERE w.dataPrzyjecia = :dataPrzyjecia")
    , @NamedQuery(name = "Wizyta.findByLekarzProwadzacy", query = "SELECT w FROM Wizyta w WHERE w.lekarzProwadzacy = :lekarzProwadzacy")
    , @NamedQuery(name = "Wizyta.findByOpisDolegliwosci", query = "SELECT w FROM Wizyta w WHERE w.opisDolegliwosci = :opisDolegliwosci")})
public class Wizyta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID_WIZYTY")
    private Long idWizyty;
    @Basic(optional = false)
    @Column(name = "DATA_PRZYJECIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPrzyjecia;
    @Basic(optional = false)
    @Column(name = "LEKARZ_PROWADZACY")
    private String lekarzProwadzacy;
    @Column(name = "OPIS_DOLEGLIWOSCI")
    private String opisDolegliwosci;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "wizyta")
    private Wypis wypis;
    @JoinColumn(name = "ID_PACJENTA", referencedColumnName = "ID_PACJENTA")
    @ManyToOne(optional = false)
    private Pacjent idPacjenta;
    @JoinColumn(name = "ID_PROCEDURY", referencedColumnName = "ID_PROCEDURY")
    @ManyToOne
    private Procedura idProcedury;
    @JoinColumn(name = "ID_ROZPOZNANIA", referencedColumnName = "ID_ROZPOZNANIA")
    @ManyToOne
    private Rozpoznanie idRozpoznania;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "wizyta")
    private Collection<WizytaPacjenta> wizytaPacjentaCollection;

    public Wizyta() {
    }

    public Wizyta(Long idWizyty) {
        this.idWizyty = idWizyty;
    }

    public Wizyta(Long idWizyty, Date dataPrzyjecia, String lekarzProwadzacy) {
        this.idWizyty = idWizyty;
        this.dataPrzyjecia = dataPrzyjecia;
        this.lekarzProwadzacy = lekarzProwadzacy;
    }

    public Long getIdWizyty() {
        return idWizyty;
    }

    public void setIdWizyty(Long idWizyty) {
        this.idWizyty = idWizyty;
    }

    public Date getDataPrzyjecia() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(Date dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }

    public String getLekarzProwadzacy() {
        return lekarzProwadzacy;
    }

    public void setLekarzProwadzacy(String lekarzProwadzacy) {
        this.lekarzProwadzacy = lekarzProwadzacy;
    }

    public String getOpisDolegliwosci() {
        return opisDolegliwosci;
    }

    public void setOpisDolegliwosci(String opisDolegliwosci) {
        this.opisDolegliwosci = opisDolegliwosci;
    }

    public Wypis getWypis() {
        return wypis;
    }

    public void setWypis(Wypis wypis) {
        this.wypis = wypis;
    }

    public Pacjent getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(Pacjent idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    public Procedura getIdProcedury() {
        return idProcedury;
    }

    public void setIdProcedury(Procedura idProcedury) {
        this.idProcedury = idProcedury;
    }

    public Rozpoznanie getIdRozpoznania() {
        return idRozpoznania;
    }

    public void setIdRozpoznania(Rozpoznanie idRozpoznania) {
        this.idRozpoznania = idRozpoznania;
    }

    @XmlTransient
    public Collection<WizytaPacjenta> getWizytaPacjentaCollection() {
        return wizytaPacjentaCollection;
    }

    public void setWizytaPacjentaCollection(Collection<WizytaPacjenta> wizytaPacjentaCollection) {
        this.wizytaPacjentaCollection = wizytaPacjentaCollection;
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
        if (!(object instanceof Wizyta)) {
            return false;
        }
        Wizyta other = (Wizyta) object;
        if ((this.idWizyty == null && other.idWizyty != null) || (this.idWizyty != null && !this.idWizyty.equals(other.idWizyty))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encje.Wizyta[ idWizyty=" + idWizyty + " ]";
    }
    
}
