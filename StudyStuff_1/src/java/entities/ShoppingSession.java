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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author vpraj
 */
@Entity
@Table(name = "shopping_session", catalog = "urban_ladder", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"sessionId", "userId"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ShoppingSession.findAll", query = "SELECT s FROM ShoppingSession s"),
    @NamedQuery(name = "ShoppingSession.findBySessionId", query = "SELECT s FROM ShoppingSession s WHERE s.sessionId = :sessionId"),
    @NamedQuery(name = "ShoppingSession.findByUserId", query = "SELECT s FROM ShoppingSession s WHERE s.userId = :userId"),
    @NamedQuery(name = "ShoppingSession.findByTotal", query = "SELECT s FROM ShoppingSession s WHERE s.total = :total"),
    @NamedQuery(name = "ShoppingSession.findByCreatedAt", query = "SELECT s FROM ShoppingSession s WHERE s.createdAt = :createdAt"),
    @NamedQuery(name = "ShoppingSession.findByModifiedAt", query = "SELECT s FROM ShoppingSession s WHERE s.modifiedAt = :modifiedAt")})
public class ShoppingSession implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sessionId", nullable = false)
    private Integer sessionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "userId", nullable = false)
    private int userId;
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

    public ShoppingSession() {
    }

    public ShoppingSession(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public ShoppingSession(Integer sessionId, int userId, int total, Date createdAt, Date modifiedAt) {
        this.sessionId = sessionId;
        this.userId = userId;
        this.total = total;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Integer getSessionId() {
        return sessionId;
    }

    public void setSessionId(Integer sessionId) {
        this.sessionId = sessionId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sessionId != null ? sessionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ShoppingSession)) {
            return false;
        }
        ShoppingSession other = (ShoppingSession) object;
        if ((this.sessionId == null && other.sessionId != null) || (this.sessionId != null && !this.sessionId.equals(other.sessionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.ShoppingSession[ sessionId=" + sessionId + " ]";
    }
    
}
