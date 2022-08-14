package entities;

import entities.Product;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(ProductInventory.class)
public class ProductInventory_ { 

    public static volatile SingularAttribute<ProductInventory, Date> createdAt;
    public static volatile SingularAttribute<ProductInventory, Date> deletedAt;
    public static volatile CollectionAttribute<ProductInventory, Product> productCollection;
    public static volatile SingularAttribute<ProductInventory, Date> modifiedAt;
    public static volatile SingularAttribute<ProductInventory, Integer> qty;
    public static volatile SingularAttribute<ProductInventory, Integer> inventryId;

}