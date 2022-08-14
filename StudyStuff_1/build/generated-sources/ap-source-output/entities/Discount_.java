package entities;

import entities.Product;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Discount.class)
public class Discount_ { 

    public static volatile SingularAttribute<Discount, Date> createdAt;
    public static volatile SingularAttribute<Discount, String> discountName;
    public static volatile SingularAttribute<Discount, Date> deletedAt;
    public static volatile CollectionAttribute<Discount, Product> productCollection;
    public static volatile SingularAttribute<Discount, Date> modifiedAt;
    public static volatile SingularAttribute<Discount, String> discountDesc;
    public static volatile SingularAttribute<Discount, Boolean> active;
    public static volatile SingularAttribute<Discount, Integer> discountId;
    public static volatile SingularAttribute<Discount, Integer> percent;

}