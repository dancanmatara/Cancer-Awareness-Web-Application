/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cassiopeia.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author dancan
 */
@Entity
@Table(name = "cancer", catalog = "cancerdb", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cancer.findAll", query = "SELECT c FROM Cancer c")
    , @NamedQuery(name = "Cancer.findById", query = "SELECT c FROM Cancer c WHERE c.id = :id")
    , @NamedQuery(name = "Cancer.findByCancerName", query = "SELECT c FROM Cancer c WHERE c.cancerName = :cancerName")
    , @NamedQuery(name = "Cancer.findByLethalDegree", query = "SELECT c FROM Cancer c WHERE c.lethalDegree = :lethalDegree")
    , @NamedQuery(name = "Cancer.findByTreatmentType", query = "SELECT c FROM Cancer c WHERE c.treatmentType = :treatmentType")})
public class Cancer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "cancerName", nullable = false, length = 255)
    private String cancerName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LethalDegree", nullable = false, length = 50)
    private String lethalDegree;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TreatmentType", nullable = false, length = 50)
    private String treatmentType;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id")
    private List<Symptom> symptomList;

    public Cancer() {
    }

    public Cancer(Integer id) {
        this.id = id;
    }

    public Cancer(Integer id, String cancerName, String lethalDegree, String treatmentType) {
        this.id = id;
        this.cancerName = cancerName;
        this.lethalDegree = lethalDegree;
        this.treatmentType = treatmentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCancerName() {
        return cancerName;
    }

    public void setCancerName(String cancerName) {
        this.cancerName = cancerName;
    }

    public String getLethalDegree() {
        return lethalDegree;
    }

    public void setLethalDegree(String lethalDegree) {
        this.lethalDegree = lethalDegree;
    }

    public String getTreatmentType() {
        return treatmentType;
    }

    public void setTreatmentType(String treatmentType) {
        this.treatmentType = treatmentType;
    }

    @XmlTransient
    public List<Symptom> getSymptomList() {
        return symptomList;
    }

    public void setSymptomList(List<Symptom> symptomList) {
        this.symptomList = symptomList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cancer)) {
            return false;
        }
        Cancer other = (Cancer) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.cassiopeia.entity.Cancer[ id=" + id + " ]";
    }
    
}
