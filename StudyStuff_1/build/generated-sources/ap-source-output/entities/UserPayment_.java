package entities;

import entities.User;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(UserPayment.class)
public class UserPayment_ { 

    public static volatile SingularAttribute<UserPayment, Date> expiryDate;
    public static volatile SingularAttribute<UserPayment, String> provider;
    public static volatile SingularAttribute<UserPayment, Long> accountNo;
    public static volatile SingularAttribute<UserPayment, Integer> userPayId;
    public static volatile SingularAttribute<UserPayment, User> userId;
    public static volatile SingularAttribute<UserPayment, String> paymentType;

}