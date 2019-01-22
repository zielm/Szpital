/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encje;

import java.io.Serializable;
import java.util.Collection;
import javax.annotation.Generated;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.OneToMany;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Monika
 */
@Entity
@Table(name = "PACJENCI")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pacjent.findAll", query = "SELECT p FROM Pacjent p")
    , @NamedQuery(name = "Pacjent.findByIdPacjenta", query = "SELECT p FROM Pacjent p WHERE p.idPacjenta = :idPacjenta")
    , @NamedQuery(name = "Pacjent.findByPesel", query = "SELECT p FROM Pacjent p WHERE p.pesel = :pesel")
    , @NamedQuery(name = "Pacjent.findByPlec", query = "SELECT p FROM Pacjent p WHERE p.plec = :plec")
    , @NamedQuery(name = "Pacjent.findByImie", query = "SELECT p FROM Pacjent p WHERE p.imie = :imie")
    , @NamedQuery(name = "Pacjent.findByDrugieImie", query = "SELECT p FROM Pacjent p WHERE p.drugieImie = :drugieImie")
    , @NamedQuery(name = "Pacjent.findByNazwisko", query = "SELECT p FROM Pacjent p WHERE p.nazwisko = :nazwisko")
    , @NamedQuery(name = "Pacjent.findByNazwiskoRodowe", query = "SELECT p FROM Pacjent p WHERE p.nazwiskoRodowe = :nazwiskoRodowe")
    , @NamedQuery(name = "Pacjent.findByAdres", query = "SELECT p FROM Pacjent p WHERE p.adres = :adres")
    , @NamedQuery(name = "Pacjent.findByMiejsceUrodzenia", query = "SELECT p FROM Pacjent p WHERE p.miejsceUrodzenia = :miejsceUrodzenia")
    , @NamedQuery(name = "Pacjent.findByNumerTelefonu", query = "SELECT p FROM Pacjent p WHERE p.numerTelefonu = :numerTelefonu")
    , @NamedQuery(name = "Pacjent.findByPeselLike", query = "SELECT p FROM Pacjent p WHERE p.pesel LIKE CONCAT(:pesel,'%')")
    , @NamedQuery(name = "Pacjent.findByNazwiskoLike", query = "SELECT p FROM Pacjent p WHERE p.nazwisko LIKE CONCAT('%',:nazwisko,'%')")})
       

public class Pacjent implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    @Basic(optional = false)
    @Column(name = "ID_PACJENTA")
    private Long idPacjenta;
    @Column(name = "PESEL")
    private String pesel;
    @Column(name = "PLEC")
    private Character plec;
    @Column(name = "IMIE")
    private String imie;
    @Column(name = "DRUGIE_IMIE")
    private String drugieImie;
    @Column(name = "NAZWISKO")
    private String nazwisko;
    @Column(name = "NAZWISKO_RODOWE")
    private String nazwiskoRodowe;
    @Column(name = "ADRES")
    private String adres;
    @Column(name = "MIEJSCE_URODZENIA")
    private String miejsceUrodzenia;
    @Column(name = "NUMER_TELEFONU")
    private Long numerTelefonu;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPacjenta")
    private Collection<Wizyta> wizytaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPacjenta")
    private Collection<Upowaznienie> upowaznienieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pacjent")
    private Collection<WizytaPacjenta> wizytaPacjentaCollection;

    public Pacjent() {
    }

    public Pacjent(Long idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    public Long getIdPacjenta() {
        return idPacjenta;
    }

    public void setIdPacjenta(Long idPacjenta) {
        this.idPacjenta = idPacjenta;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Character getPlec() {
        return plec;
    }

    public void setPlec(Character plec) {
        this.plec = plec;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getDrugieImie() {
        return drugieImie;
    }

    public void setDrugieImie(String drugieImie) {
        this.drugieImie = drugieImie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNazwiskoRodowe() {
        return nazwiskoRodowe;
    }

    public void setNazwiskoRodowe(String nazwiskoRodowe) {
        this.nazwiskoRodowe = nazwiskoRodowe;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getMiejsceUrodzenia() {
        return miejsceUrodzenia;
    }

    public void setMiejsceUrodzenia(String miejsceUrodzenia) {
        this.miejsceUrodzenia = miejsceUrodzenia;
    }

    public Long getNumerTelefonu() {
        return numerTelefonu;
    }

    public void setNumerTelefonu(Long numerTelefonu) {
        this.numerTelefonu = numerTelefonu;
    }

    @XmlTransient
    public Collection<Wizyta> getWizytaCollection() {
        return wizytaCollection;
    }

    public void setWizytaCollection(Collection<Wizyta> wizytaCollection) {
        this.wizytaCollection = wizytaCollection;
    }

    @XmlTransient
    public Collection<Upowaznienie> getUpowaznienieCollection() {
        return upowaznienieCollection;
    }

    public void setUpowaznienieCollection(Collection<Upowaznienie> upowaznienieCollection) {
        this.upowaznienieCollection = upowaznienieCollection;
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
        hash += (idPacjenta != null ? idPacjenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pacjent)) {
            return false;
        }
        Pacjent other = (Pacjent) object;
        if ((this.idPacjenta == null && other.idPacjenta != null) || (this.idPacjenta != null && !this.idPacjenta.equals(other.idPacjenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "encje.Pacjent[ idPacjenta=" + idPacjenta + " ]";
    }
    
}
