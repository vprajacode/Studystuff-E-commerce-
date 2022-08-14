package entities;

import entities.Discount;
import entities.ProductCategory;
import entities.ProductInventory;
import entities.Wishlist;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Product.class)
public class Product_ { 

    public static volatile SingularAttribute<Product, String> productDesc;
    public static volatile SingularAttribute<Product, Date> createdAt;
    public static volatile SingularAttribute<Product, Date> deletedAt;
    public static volatile SingularAttribute<Product, Integer> productId;
    public static volatile SingularAttribute<Product, Date> modifiedAt;
    public static volatile SingularAttribute<Product, Integer> price;
    public static volatile SingularAttribute<Product, String> productImg;
    public static volatile SingularAttribute<Product, ProductInventory> inventoryId;
    public static volatile CollectionAttribute<Product, Wishlist> wishlistCollection;
    public static volatile SingularAttribute<Product, Discount> discountId;
    public static volatile SingularAttribute<Product, String> productName;
    public static volatile SingularAttribute<Product, ProductCategory> categoryId;

}