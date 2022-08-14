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
@Table(name = "cart_item", catalog = "urban_ladder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartItem.findAll", query = "SELECT c FROM CartItem c"),
    @NamedQuery(name = "CartItem.findByCartId", query = "SELECT c FROM CartItem c WHERE c.cartId = :cartId"),
    @NamedQuery(name = "CartItem.findBySessionId", query = "SELECT c FROM CartItem c WHERE c.sessionId = :sessionId"),
    @NamedQuery(name = "CartItem.findByProductId", query = "SELECT c FROM CartItem c WHERE c.productId = :productId"),
    @NamedQuery(name = "CartItem.findByQty", query = "SELECT c FROM CartItem c WHERE c.qty = :qty"),
    @NamedQuery(name = "CartItem.findByCreatedAt", query = "SELECT c FROM CartItem c WHERE c.createdAt = :createdAt"),
    @NamedQuery(name = "CartItem.findByModifiedAt", query = "SELECT c FROM CartItem c WHERE c.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "CartItem.findByDeletedAt", query = "SELECT c FROM CartItem c WHERE c.deletedAt = :deletedAt")})
public class CartItem implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cartId", nullable = false)
    private Integer cartId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sessionId", nullable = false)
    private int sessionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "productId", nullable = false)
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty", nullable = false)
    private int qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modified_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;

    public CartItem() {
    }

    public CartItem(Integer cartId) {
        this.cartId = cartId;
    }

    public CartItem(Integer cartId, int sessionId, int productId, int qty, Date createdAt, Date modifiedAt, Date deletedAt) {
        this.cartId = cartId;
        this.sessionId = sessionId;
        this.productId = productId;
        this.qty = qty;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.deletedAt = deletedAt;
    }

    public Integer getCartId() {
        return cartId;
    }

    public void setCartId(Integer cartId) {
        this.cartId = cartId;
    }

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartId != null ? cartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartItem)) {
            return false;
        }
        CartItem other = (CartItem) object;
        if ((this.cartId == null && other.cartId != null) || (this.cartId != null && !this.cartId.equals(other.cartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.CartItem[ cartId=" + cartId + " ]";
    }
    
}
