/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vpraj
 */
@Entity
@Table(name = "wishlist", catalog = "urban_ladder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Wishlist.findAll", query = "SELECT w FROM Wishlist w"),
    @NamedQuery(name = "Wishlist.findByListId", query = "SELECT w FROM Wishlist w WHERE w.listId = :listId"),
    @NamedQuery(name = "Wishlist.findByCreatedAt", query = "SELECT w FROM Wishlist w WHERE w.createdAt = :createdAt"),
    @NamedQuery(name = "Wishlist.findByDeletedAt", query = "SELECT w FROM Wishlist w WHERE w.deletedAt = :deletedAt")})
public class Wishlist implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "listId", nullable = false)
    private Integer listId;
    @JoinColumn(name = "productId", referencedColumnName = "productId", nullable = false)
    @ManyToOne(optional = false)
    private Product productId;
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @ManyToOne(optional = false)
    private User userId;

    public Wishlist() {
    }

    public Wishlist(Integer listId) {
        this.listId = listId;
    }

    public Wishlist(Integer listId, Date createdAt, Date deletedAt) {
        this.listId = listId;
        this.createdAt = createdAt;
        this.deletedAt = deletedAt;
    }

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (listId != null ? listId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Wishlist)) {
            return false;
        }
        Wishlist other = (Wishlist) object;
        if ((this.listId == null && other.listId != null) || (this.listId != null && !this.listId.equals(other.listId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Wishlist[ listId=" + listId + " ]";
    }

   
    
}
