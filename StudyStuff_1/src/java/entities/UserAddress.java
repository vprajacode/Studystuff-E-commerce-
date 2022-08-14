/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vpraj
 */
@Entity
@Table(name = "user_address", catalog = "urban_ladder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAddress.findAll", query = "SELECT u FROM UserAddress u"),
    @NamedQuery(name = "UserAddress.findByUserAddId", query = "SELECT u FROM UserAddress u WHERE u.userAddId = :userAddId"),
    @NamedQuery(name = "UserAddress.findByAdd1", query = "SELECT u FROM UserAddress u WHERE u.add1 = :add1"),
    @NamedQuery(name = "UserAddress.findByAdd2", query = "SELECT u FROM UserAddress u WHERE u.add2 = :add2"),
    @NamedQuery(name = "UserAddress.findByCity", query = "SELECT u FROM UserAddress u WHERE u.city = :city"),
    @NamedQuery(name = "UserAddress.findByPincode", query = "SELECT u FROM UserAddress u WHERE u.pincode = :pincode"),
    @NamedQuery(name = "UserAddress.findByCountry", query = "SELECT u FROM UserAddress u WHERE u.country = :country")})
public class UserAddress implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "add_1", nullable = false, length = 50)
    private String add1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "add_2", nullable = false, length = 50)
    private String add2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "city", nullable = false, length = 20)
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "pincode", nullable = false, length = 10)
    private String pincode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "country", nullable = false, length = 20)
    private String country;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "userAddId", nullable = false)
    private Integer userAddId;
    @JoinColumn(name = "userId", referencedColumnName = "userId", nullable = false)
    @ManyToOne(optional = false)
    private User userId;

    public UserAddress() {
    }

    public UserAddress(Integer userAddId) {
        this.userAddId = userAddId;
    }

    public UserAddress(Integer userAddId, String add1, String add2, String city, String pincode, String country) {
        this.userAddId = userAddId;
        this.add1 = add1;
        this.add2 = add2;
        this.city = city;
        this.pincode = pincode;
        this.country = country;
    }

    public Integer getUserAddId() {
        return userAddId;
    }

    public void setUserAddId(Integer userAddId) {
        this.userAddId = userAddId;
    }

    public String getAdd1() {
        return add1;
    }

    public void setAdd1(String add1) {
        this.add1 = add1;
    }

    public String getAdd2() {
        return add2;
    }

    public void setAdd2(String add2) {
        this.add2 = add2;
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
        hash += (userAddId != null ? userAddId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAddress)) {
            return false;
        }
        UserAddress other = (UserAddress) object;
        if ((this.userAddId == null && other.userAddId != null) || (this.userAddId != null && !this.userAddId.equals(other.userAddId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.UserAddress[ userAddId=" + userAddId + " ]";
    }

   

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    
}
