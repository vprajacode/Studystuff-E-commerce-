package entities;

import entities.OrderDetails;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(PaymentDetails.class)
public class PaymentDetails_ { 

    public static volatile SingularAttribute<PaymentDetails, Date> createdAt;
    public static volatile SingularAttribute<PaymentDetails, Integer> amount;
    public static volatile SingularAttribute<PaymentDetails, String> provider;
    public static volatile SingularAttribute<PaymentDetails, OrderDetails> orderId;
    public static volatile SingularAttribute<PaymentDetails, Integer> paymentId;
    public static volatile SingularAttribute<PaymentDetails, Date> modifiedAt;
    public static volatile SingularAttribute<PaymentDetails, Boolean> status;

}