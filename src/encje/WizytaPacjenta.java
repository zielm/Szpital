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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Monika
 */
@Entity
@Table(name = "WIZYTY_PACJENTOW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WizytaPacjenta.findAll", query = "SELECT w FROM WizytaPacjenta w")
    , @NamedQuery(name = "WizytaPacjenta.findByIdWizyty", query = "SELECT w FROM WizytaPacjenta w WHERE w.idWizyty = :idWizyty")
    , @NamedQuery(name = "WizytaPacjenta.findByDataPrzyjecia", query = "SELECT w FROM WizytaPacjenta w WHERE w.dataPrzyjecia = :dataPrzyjecia")
    , @NamedQuery(name = "WizytaPacjenta.findByDataWypisu", query = "SELECT w FROM WizytaPacjenta w WHERE w.dataWypisu = :dataWypisu")
    , @NamedQuery(name = "WizytaPacjenta.findByIdPacjenta", query = "SELECT w FROM WizytaPacjenta w WHERE w.idPacjenta = :idPacjenta")
    , @NamedQuery(name = "WizytaPacjenta.findByImie", query = "SELECT w FROM WizytaPacjenta w WHERE w.imie = :imie")
    , @NamedQuery(name = "WizytaPacjenta.findByNazwisko", query = "SELECT w FROM WizytaPacjenta w WHERE w.nazwisko = :nazwisko")
    , @NamedQuery(name = "WizytaPacjenta.findByPesel", query = "SELECT w FROM WizytaPacjenta w WHERE w.pesel = :pesel")
    , @NamedQuery(name = "WizytaPacjenta.findByPeselLike", query = "SELECT w FROM WizytaPacjenta w WHERE w.pesel LIKE CONCAT(:pesel,'%')")
    , @NamedQuery(name = "WizytaPacjenta.findByNazwiskoLike", query = "SELECT w FROM WizytaPacjenta w WHERE w.nazwisko LIKE CONCAT('%',:nazwisko,'%')")})
public class WizytaPacjenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_WIZYTY")
    private long idWizyty;
    @Basic(optional = false)
    @Column(name = "DATA_PRZYJECIA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataPrzyjecia;
    @Column(name = "DATA_WYPISU")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataWypisu;
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PACJENTA")
    private long idPacjenta;
    @Column(name = "IMIE")
    private String imie;
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Column(name = "PESEL")
    private String pesel;
    @JoinColumn(name = "ID_PACJENTA", referencedColumnName = "ID_PACJENTA", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pacjent pacjent;
    @JoinColumn(name = "ID_WIZYTY", referencedColumnName = "ID_WIZYTY", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Wizyta wizyta;

    public WizytaPacjenta() {
    }

    public WizytaPacjenta(long idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    public WizytaPacjenta(long idPacjenta, Date dataPrzyjecia) {
        this.idPacjenta = idPacjenta;
        this.dataPrzyjecia = dataPrzyjecia;
    }

    public long getIdWizyty() {
        return idWizyty;
    }

    public void setIdWizyty(long idWizyty) {
        this.idWizyty = idWizyty;
    }

    public Date getDataPrzyjecia() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(Date dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }

    public Date getDataWypisu() {
        return dataWypisu;
    }

    public void setDataWypisu(Date dataWypisu) {
        this.dataWypisu = dataWypisu;
    }

    public long getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(long idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Pacjent getPacjent() {
        return pacjent;
    }

    public void setPacjent(Pacjent pacjent) {
        this.pacjent = pacjent;
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
        hash += (int) idPacjenta;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof WizytaPacjenta)) {
            return false;
        }
        WizytaPacjenta other = (WizytaPacjenta) object;
        if (this.idPacjenta != other.idPacjenta) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encje.WizytaPacjenta[ idPacjenta=" + idPacjenta + " ]";
    }
    
}
