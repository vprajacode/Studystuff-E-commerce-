package entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(CartItem.class)
public class CartItem_ { 

    public static volatile SingularAttribute<CartItem, Date> createdAt;
    public static volatile SingularAttribute<CartItem, Date> deletedAt;
    public static volatile SingularAttribute<CartItem, Integer> productId;
    public static volatile SingularAttribute<CartItem, Date> modifiedAt;
    public static volatile SingularAttribute<CartItem, Integer> cartId;
    public static volatile SingularAttribute<CartItem, Integer> qty;
    public static volatile SingularAttribute<CartItem, Integer> sessionId;

}