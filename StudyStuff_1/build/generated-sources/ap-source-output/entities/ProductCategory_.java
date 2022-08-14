package entities;

import entities.Product;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(ProductCategory.class)
public class ProductCategory_ { 

    public static volatile SingularAttribute<ProductCategory, Date> createdAt;
    public static volatile SingularAttribute<ProductCategory, Date> deletedAt;
    public static volatile CollectionAttribute<ProductCategory, Product> productCollection;
    public static volatile SingularAttribute<ProductCategory, Date> modifiedAt;
    public static volatile SingularAttribute<ProductCategory, String> categoryName;
    public static volatile SingularAttribute<ProductCategory, Integer> categoryId;
    public static volatile SingularAttribute<ProductCategory, String> categoryDesc;

}