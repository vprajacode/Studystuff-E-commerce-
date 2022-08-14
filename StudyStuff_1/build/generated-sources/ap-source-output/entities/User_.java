package entities;

import entities.OrderDetails;
import entities.Roles;
import entities.UserAddress;
import entities.UserPayment;
import entities.Wishlist;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile CollectionAttribute<User, UserPayment> userPaymentCollection;
    public static volatile SingularAttribute<User, String> userImg;
    public static volatile CollectionAttribute<User, UserAddress> userAddressCollection;
    public static volatile SingularAttribute<User, Date> modifiedAt;
    public static volatile CollectionAttribute<User, OrderDetails> orderDetailsCollection;
    public static volatile SingularAttribute<User, Roles> roleId;
    public static volatile SingularAttribute<User, String> mobile;
    public static volatile CollectionAttribute<User, Wishlist> wishlistCollection;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, Integer> userId;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile SingularAttribute<User, Date> createdAt;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, String> email;

}