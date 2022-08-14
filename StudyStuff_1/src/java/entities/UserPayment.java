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
@Table(name = "user_payment", catalog = "urban_ladder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserPayment.findAll", query = "SELECT u FROM UserPayment u"),
    @NamedQuery(name = "UserPayment.findByUserPayId", query = "SELECT u FROM UserPayment u WHERE u.userPayId = :userPayId"),
    @NamedQuery(name = "UserPayment.findByPaymentType", query = "SELECT u FROM UserPayment u WHERE u.paymentType = :paymentType"),
    @NamedQuery(name = "UserPayment.findByProvider", query = "SELECT u FROM UserPayment u WHERE u.provider = :provider"),
    @NamedQuery(name = "UserPayment.findByAccountNo", query = "SELECT u FROM UserPayment u WHERE u.accountNo = :accountNo"),
    @NamedQuery(name = "UserPayment.findByExpiryDate", query = "SELECT u FROM UserPayment u WHERE u.expiryDate = :expiryDate")})
public class UserPayment implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "paymentType", nullable = false, length = 20)
    private String paymentType;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "provider", nullable = false, length = 20)
    private String provider;
    @Basic(optional = false)
    @NotNull
    @Column(name = "accountNo", nullable = false)
    private long accountNo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "expiryDate", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date expiryDate;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userPayId", nullable = false)
    private Integer userPayId;
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @ManyToOne(optional = false)
    private User userId;

    public UserPayment() {
    }

    public UserPayment(Integer userPayId) {
        this.userPayId = userPayId;
    }

    public UserPayment(Integer userPayId, String paymentType, String provider, long accountNo, Date expiryDate) {
        this.userPayId = userPayId;
        this.paymentType = paymentType;
        this.provider = provider;
        this.accountNo = accountNo;
        this.expiryDate = expiryDate;
    }

    public Integer getUserPayId() {
        return userPayId;
    }

    public void setUserPayId(Integer userPayId) {
        this.userPayId = userPayId;
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
        hash += (userPayId != null ? userPayId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserPayment)) {
            return false;
        }
        UserPayment other = (UserPayment) object;
        if ((this.userPayId == null && other.userPayId != null) || (this.userPayId != null && !this.userPayId.equals(other.userPayId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserPayment[ userPayId=" + userPayId + " ]";
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(long accountNo) {
        this.accountNo = accountNo;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }
    
}
