package entities;

import entities.OrderItems;
import entities.PaymentDetails;
import entities.User;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(OrderDetails.class)
public class OrderDetails_ { 

    public static volatile SingularAttribute<OrderDetails, Date> createdAt;
    public static volatile SingularAttribute<OrderDetails, Integer> total;
    public static volatile SingularAttribute<OrderDetails, Integer> orderId;
    public static volatile SingularAttribute<OrderDetails, Date> modifiedAt;
    public static volatile CollectionAttribute<OrderDetails, PaymentDetails> paymentDetailsCollection;
    public static volatile CollectionAttribute<OrderDetails, OrderItems> orderItemsCollection;
    public static volatile SingularAttribute<OrderDetails, User> userId;

}