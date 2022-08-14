/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vpraj
 */
@Entity
@Table(name = "order_details", catalog = "urban_ladder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderDetails.findAll", query = "SELECT o FROM OrderDetails o"),
    @NamedQuery(name = "OrderDetails.findByOrderId", query = "SELECT o FROM OrderDetails o WHERE o.orderId = :orderId"),
    @NamedQuery(name = "OrderDetails.findByTotal", query = "SELECT o FROM OrderDetails o WHERE o.total = :total"),
    @NamedQuery(name = "OrderDetails.findByCreatedAt", query = "SELECT o FROM OrderDetails o WHERE o.createdAt = :createdAt"),
    @NamedQuery(name = "OrderDetails.findByModifiedAt", query = "SELECT o FROM OrderDetails o WHERE o.modifiedAt = :modifiedAt")})
public class OrderDetails implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "total", nullable = false)
    private int total;
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

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "orderId", nullable = false)
    private Integer orderId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<PaymentDetails> paymentDetailsCollection;
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @ManyToOne(optional = false)
    private User userId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderId")
    private Collection<OrderItems> orderItemsCollection;

    public OrderDetails() {
    }

    public OrderDetails(Integer orderId) {
        this.orderId = orderId;
    }

    public OrderDetails(Integer orderId, int total, Date createdAt, Date modifiedAt) {
        this.orderId = orderId;
        this.total = total;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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

    @XmlTransient
    public Collection<PaymentDetails> getPaymentDetailsCollection() {
        return paymentDetailsCollection;
    }

    public void setPaymentDetailsCollection(Collection<PaymentDetails> paymentDetailsCollection) {
        this.paymentDetailsCollection = paymentDetailsCollection;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    @XmlTransient
    public Collection<OrderItems> getOrderItemsCollection() {
        return orderItemsCollection;
    }

    public void setOrderItemsCollection(Collection<OrderItems> orderItemsCollection) {
        this.orderItemsCollection = orderItemsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderId != null ? orderId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof OrderDetails)) {
            return false;
        }
        OrderDetails other = (OrderDetails) object;
        if ((this.orderId == null && other.orderId != null) || (this.orderId != null && !this.orderId.equals(other.orderId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.OrderDetails[ orderId=" + orderId + " ]";
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

  
}
