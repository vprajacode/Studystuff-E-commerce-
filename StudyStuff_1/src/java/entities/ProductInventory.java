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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vpraj
 */
@Entity
@Table(name = "product_inventory", catalog = "urban_ladder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductInventory.findAll", query = "SELECT p FROM ProductInventory p"),
    @NamedQuery(name = "ProductInventory.findById", query = "SELECT p FROM ProductInventory p WHERE p.inventryId = :inventryId"),
    @NamedQuery(name = "ProductInventory.findByQty", query = "SELECT p FROM ProductInventory p WHERE p.qty = :qty"),
    @NamedQuery(name = "ProductInventory.findByCreatedAt", query = "SELECT p FROM ProductInventory p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "ProductInventory.findByModifiedAt", query = "SELECT p FROM ProductInventory p WHERE p.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "ProductInventory.findByDeletedAt", query = "SELECT p FROM ProductInventory p WHERE p.deletedAt = :deletedAt")})
public class ProductInventory implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "qty", nullable = false)
    private int qty;
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
    @Column(name = "inventryId", nullable = false)
    private Integer inventryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventoryId")
    private Collection<Product> productCollection;

    public ProductInventory() {
    }

    public ProductInventory(Integer inventryId) {
        this.inventryId = inventryId;
    }

    public ProductInventory(Integer inventryId, int qty, Date createdAt, Date modifiedAt, Date deletedAt) {
        this.inventryId = inventryId;
        this.qty = qty;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedAt = deletedAt;
    }

    public Integer getInventryId() {
        return inventryId;
    }

    public void setInventryId(Integer inventryId) {
        this.inventryId = inventryId;
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
        hash += (inventryId != null ? inventryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductInventory)) {
            return false;
        }
        ProductInventory other = (ProductInventory) object;
        if ((this.inventryId == null && other.inventryId != null) || (this.inventryId != null && !this.inventryId.equals(other.inventryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductInventory[ inventryId=" + inventryId + " ]";
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

   

    
}
