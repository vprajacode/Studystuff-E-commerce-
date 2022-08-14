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
@Table(name = "order_items", catalog = "urban_ladder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderItems.findAll", query = "SELECT o FROM OrderItems o"),
    @NamedQuery(name = "OrderItems.findByItemId", query = "SELECT o FROM OrderItems o WHERE o.itemId = :itemId"),
    @NamedQuery(name = "OrderItems.findByQty", query = "SELECT o FROM OrderItems o WHERE o.qty = :qty"),
    @NamedQuery(name = "OrderItems.findByModifiedAt", query = "SELECT o FROM OrderItems o WHERE o.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "OrderItems.findByCreatedAt", query = "SELECT o FROM OrderItems o WHERE o.createdAt = :createdAt")})
public class OrderItems implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "itemId", nullable = false)
    private Integer itemId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "qty", nullable = false)
    private int qty;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modified_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", nullable = false)
    @ManyToOne(optional = false)
    private OrderDetails orderId;
    @JoinColumn(name = "productId", referencedColumnName = "productId", nullable = false)
    @ManyToOne(optional = false)
    private Product productId;

    public OrderItems() {
    }

    public OrderItems(Integer itemId) {
        this.itemId = itemId;
    }

    public OrderItems(Integer itemId, int qty, Date modifiedAt, Date createdAt) {
        this.itemId = itemId;
        this.qty = qty;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Date getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(Date modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public OrderDetails getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderDetails orderId) {
        this.orderId = orderId;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemId != null ? itemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderItems)) {
            return false;
        }
        OrderItems other = (OrderItems) object;
        if ((this.itemId == null && other.itemId != null) || (this.itemId != null && !this.itemId.equals(other.itemId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrderItems[ itemId=" + itemId + " ]";
    }
    
}
