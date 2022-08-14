/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.json.bind.annotation.JsonbTransient;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vpraj
 */
@Entity
@Table(name = "discount", catalog = "urban_ladder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Discount.findAll", query = "SELECT d FROM Discount d"),
    @NamedQuery(name = "Discount.count", query = "SELECT COUNT(d) FROM Discount d"),
    @NamedQuery(name = "Discount.findByDiscountId", query = "SELECT d FROM Discount d WHERE d.discountId = :discountId"),
    @NamedQuery(name = "Discount.findByDiscountName", query = "SELECT d FROM Discount d WHERE d.discountName = :discountName"),
    @NamedQuery(name = "Discount.findByDiscountDesc", query = "SELECT d FROM Discount d WHERE d.discountDesc = :discountDesc"),
    @NamedQuery(name = "Discount.findByActive", query = "SELECT d FROM Discount d WHERE d.active = :active"),
    @NamedQuery(name = "Discount.findByCreatedAt", query = "SELECT d FROM Discount d WHERE d.createdAt = :createdAt"),
    @NamedQuery(name = "Discount.findByModifiedAt", query = "SELECT d FROM Discount d WHERE d.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "Discount.findByDeletedAt", query = "SELECT d FROM Discount d WHERE d.deletedAt = :deletedAt")})
public class Discount implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "discountName", nullable = false, length = 20)
    private String discountName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "discountDesc", nullable = false, length = 60)
    private String discountDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "active", nullable = false)
    private boolean active;
    @Column(name = "percent")
    private Integer percent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "discountId", nullable = false)
    private Integer discountId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "discountId")
    private Collection<Product> productCollection;

    public Discount() {
    }

    public Discount(Integer discountId) {
        this.discountId = discountId;
    }

    public Discount(Integer discountId, String discountName, String discountDesc, boolean active, Date createdAt, Date modifiedAt, Date deletedAt) {
        this.discountId = discountId;
        this.discountName = discountName;
        this.discountDesc = discountDesc;
        this.active = active;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedAt = deletedAt;
    }

    public Integer getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Integer discountId) {
        this.discountId = discountId;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }
    @JsonbTransient
    @XmlTransient
    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (discountId != null ? discountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Discount)) {
            return false;
        }
        Discount other = (Discount) object;
        if ((this.discountId == null && other.discountId != null) || (this.discountId != null && !this.discountId.equals(other.discountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Discount[ discountId=" + discountId + " ]";
    }

    public String getDiscountName() {
        return discountName;
    }

    public void setDiscountName(String discountName) {
        this.discountName = discountName;
    }

    public String getDiscountDesc() {
        return discountDesc;
    }

    public void setDiscountDesc(String discountDesc) {
        this.discountDesc = discountDesc;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Integer getPercent() {
        return percent;
    }

    public void setPercent(Integer percent) {
        this.percent = percent;
    }

   
   

    
}
