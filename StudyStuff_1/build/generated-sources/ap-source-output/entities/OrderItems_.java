package entities;

import entities.OrderDetails;
import entities.Product;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(OrderItems.class)
public class OrderItems_ { 

    public static volatile SingularAttribute<OrderItems, Integer> itemId;
    public static volatile SingularAttribute<OrderItems, Date> createdAt;
    public static volatile SingularAttribute<OrderItems, Product> productId;
    public static volatile SingularAttribute<OrderItems, OrderDetails> orderId;
    public static volatile SingularAttribute<OrderItems, Date> modifiedAt;
    public static volatile SingularAttribute<OrderItems, Integer> qty;

}