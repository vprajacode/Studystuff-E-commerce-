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
@Table(name = "product_category", catalog = "urban_ladder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductCategory.findAll", query = "SELECT p FROM ProductCategory p"),
     @NamedQuery(name = "ProductCategory.count", query = "SELECT COUNT(p) FROM ProductCategory p"),
    @NamedQuery(name = "ProductCategory.findByCategoryId", query = "SELECT p FROM ProductCategory p WHERE p.categoryId = :categoryId"),
    @NamedQuery(name = "ProductCategory.findByCategoryName", query = "SELECT p FROM ProductCategory p WHERE p.categoryName = :categoryName"),
    @NamedQuery(name = "ProductCategory.findByCategoryDesc", query = "SELECT p FROM ProductCategory p WHERE p.categoryDesc = :categoryDesc"),
    @NamedQuery(name = "ProductCategory.findByCreatedAt", query = "SELECT p FROM ProductCategory p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "ProductCategory.findByModifiedAt", query = "SELECT p FROM ProductCategory p WHERE p.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "ProductCategory.findByDeletedAt", query = "SELECT p FROM ProductCategory p WHERE p.deletedAt = :deletedAt")})
public class ProductCategory implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "categoryName", nullable = false, length = 20)
    private String categoryName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "categoryDesc", nullable = false, length = 60)
    private String categoryDesc;
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
    @Column(name = "categoryId", nullable = false)
    private Integer categoryId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoryId")
    private Collection<Product> productCollection;

    public ProductCategory() {
    }

    public ProductCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public ProductCategory(Integer categoryId, String categoryName, String categoryDesc, Date createdAt, Date modifiedAt, Date deletedAt) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDesc = categoryDesc;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedAt = deletedAt;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
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
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductCategory)) {
            return false;
        }
        ProductCategory other = (ProductCategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ProductCategory[ categoryId=" + categoryId + " ]";
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDesc() {
        return categoryDesc;
    }

    public void setCategoryDesc(String categoryDesc) {
        this.categoryDesc = categoryDesc;
    }

    
    
}
