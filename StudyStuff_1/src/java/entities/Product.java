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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author vpraj
 */
@Entity
@Table(name = "product", catalog = "urban_ladder", schema = "")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
     @NamedQuery(name = "Product.count", query = "SELECT COUNT(p) FROM Product p"),
    @NamedQuery(name = "Product.findByProductId", query = "SELECT p FROM Product p WHERE p.productId = :productId"),
    @NamedQuery(name = "Product.findByProductName", query = "SELECT p FROM Product p WHERE p.productName = :productName"),
    @NamedQuery(name = "Product.findByProductDesc", query = "SELECT p FROM Product p WHERE p.productDesc = :productDesc"),
    @NamedQuery(name = "Product.findByProductImg", query = "SELECT p FROM Product p WHERE p.productImg = :productImg"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByCreatedAt", query = "SELECT p FROM Product p WHERE p.createdAt = :createdAt"),
    @NamedQuery(name = "Product.findByModifiedAt", query = "SELECT p FROM Product p WHERE p.modifiedAt = :modifiedAt"),
    @NamedQuery(name = "Product.findByDeletedAt", query = "SELECT p FROM Product p WHERE p.deletedAt = :deletedAt")})
public class Product implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "productName", nullable = false, length = 20)
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    @Column(name = "productDesc", nullable = false, length = 60)
    private String productDesc;
    @Size(max = 5000)
    @Column(name = "product_img", length = 5000)
    private String productImg;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price", nullable = false)
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "created_at", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private Collection<Wishlist> wishlistCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productId", nullable = false)
    private Integer productId;
    @Column(name = "modified_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;
    @Column(name = "deleted_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deletedAt;
    @JoinColumn(name = "discountId", referencedColumnName = "discountId", nullable = false)
    @ManyToOne(optional = false)
    private Discount discountId;
    @JoinColumn(name = "inventoryId", referencedColumnName = "inventryId", nullable = false)
    @ManyToOne(optional = false)
    private ProductInventory inventoryId;
    @JoinColumn(name = "categoryId", referencedColumnName = "categoryId", nullable = false)
    @ManyToOne(optional = false)
    private ProductCategory categoryId;

    public Product() {
    }

    public Product(Integer productId) {
        this.productId = productId;
    }

    public Product(Integer productId, String productName, String productDesc, int price, Date createdAt) {
        this.productId = productId;
        this.productName = productName;
        this.productDesc = productDesc;
        this.price = price;
        this.createdAt = createdAt;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }


    public String getProductImg() {
        return productImg;
    }

    public void setProductImg(String productImg) {
        this.productImg = productImg;
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

    public Discount getDiscountId() {
        return discountId;
    }

    public void setDiscountId(Discount discountId) {
        this.discountId = discountId;
    }

    public ProductInventory getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(ProductInventory inventoryId) {
        this.inventoryId = inventoryId;
    }

    public ProductCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(ProductCategory categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Product[ productId=" + productId + " ]";
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDesc() {
        return productDesc;
    }

    public void setProductDesc(String productDesc) {
        this.productDesc = productDesc;
    }

  

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

   

    @XmlTransient
    public Collection<Wishlist> getWishlistCollection() {
        return wishlistCollection;
    }

    public void setWishlistCollection(Collection<Wishlist> wishlistCollection) {
        this.wishlistCollection = wishlistCollection;
    }
    
}
