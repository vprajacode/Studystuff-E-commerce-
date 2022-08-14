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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vpraj
 */
@Entity
@Table(name = "payment_details", catalog = "urban_ladder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PaymentDetails.findAll", query = "SELECT p FROM PaymentDetails p"),
    @NamedQuery(name = "PaymentDetails.findByPaymentId", query = "SELECT p FROM PaymentDetails p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "PaymentDetails.findByAmount", query = "SELECT p FROM PaymentDetails p WHERE p.amount = :amount"),
    @NamedQuery(name = "PaymentDetails.findByProvider", query = "SELECT p FROM PaymentDetails p WHERE p.provider = :provider"),
    @NamedQuery(name = "PaymentDetails.findByStatus", query = "SELECT p FROM PaymentDetails p WHERE p.status = :status"),
    @NamedQuery(name = "PaymentDetails.findByCreatedAt", query = "SELECT p FROM PaymentDetails p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "PaymentDetails.findByModifiedAt", query = "SELECT p FROM PaymentDetails p WHERE p.modifiedAt = :modifiedAt")})
public class PaymentDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "paymentId", nullable = false)
    private Integer paymentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount", nullable = false)
    private int amount;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "provider", nullable = false, length = 20)
    private String provider;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status", nullable = false)
    private boolean status;
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
    @JoinColumn(name = "orderId", referencedColumnName = "orderId", nullable = false)
    @ManyToOne(optional = false)
    private OrderDetails orderId;

    public PaymentDetails() {
    }

    public PaymentDetails(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public PaymentDetails(Integer paymentId, int amount, String provider, boolean status, Date createdAt, Date modifiedAt) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.provider = provider;
        this.status = status;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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

    public OrderDetails getOrderId() {
        return orderId;
    }

    public void setOrderId(OrderDetails orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PaymentDetails)) {
            return false;
        }
        PaymentDetails other = (PaymentDetails) object;
        if ((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.PaymentDetails[ paymentId=" + paymentId + " ]";
    }
    
}
