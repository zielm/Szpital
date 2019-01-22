/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encje;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Monika
 */
@Entity
@Table(name = "UPOWAZNIENIA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Upowaznienie.findAll", query = "SELECT u FROM Upowaznienie u")
    , @NamedQuery(name = "Upowaznienie.findByIdUpowaznienia", query = "SELECT u FROM Upowaznienie u WHERE u.idUpowaznienia = :idUpowaznienia")
    , @NamedQuery(name = "Upowaznienie.findByStopienPokrewiensta", query = "SELECT u FROM Upowaznienie u WHERE u.stopienPokrewiensta = :stopienPokrewiensta")
    , @NamedQuery(name = "Upowaznienie.findByImie", query = "SELECT u FROM Upowaznienie u WHERE u.imie = :imie")
    , @NamedQuery(name = "Upowaznienie.findByNazwisko", query = "SELECT u FROM Upowaznienie u WHERE u.nazwisko = :nazwisko")
    , @NamedQuery(name = "Upowaznienie.findByNumerTelefonu", query = "SELECT u FROM Upowaznienie u WHERE u.numerTelefonu = :numerTelefonu")})
public class Upowaznienie implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue
    @Column(name = "ID_UPOWAZNIENIA")
    private Long idUpowaznienia;
    @Basic(optional = false)
    @Column(name = "STOPIEN_POKREWIENSTA")
    private String stopienPokrewiensta;
    @Column(name = "IMIE")
    private String imie;
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Basic(optional = false)
    @Column(name = "NUMER_TELEFONU")
    private long numerTelefonu;
    @JoinColumn(name = "ID_PACJENTA", referencedColumnName = "ID_PACJENTA")
    @ManyToOne(optional = false)
    private Pacjent idPacjenta;

    public Upowaznienie() {
    }

    public Upowaznienie(Long idUpowaznienia) {
        this.idUpowaznienia = idUpowaznienia;
    }

    public Upowaznienie(Long idUpowaznienia, String stopienPokrewiensta, long numerTelefonu) {
        this.idUpowaznienia = idUpowaznienia;
        this.stopienPokrewiensta = stopienPokrewiensta;
        this.numerTelefonu = numerTelefonu;
    }

    public Long getIdUpowaznienia() {
        return idUpowaznienia;
    }

    public void setIdUpowaznienia(Long idUpowaznienia) {
        this.idUpowaznienia = idUpowaznienia;
    }

    public String getStopienPokrewiensta() {
        return stopienPokrewiensta;
    }

    public void setStopienPokrewiensta(String stopienPokrewiensta) {
        this.stopienPokrewiensta = stopienPokrewiensta;
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

    public long getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(long numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    public Pacjent getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(Pacjent idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUpowaznienia != null ? idUpowaznienia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Upowaznienie)) {
            return false;
        }
        Upowaznienie other = (Upowaznienie) object;
        if ((this.idUpowaznienia == null && other.idUpowaznienia != null) || (this.idUpowaznienia != null && !this.idUpowaznienia.equals(other.idUpowaznienia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encje.Upowaznienie[ idUpowaznienia=" + idUpowaznienia + " ]";
    }
    
}
