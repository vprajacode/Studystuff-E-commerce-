package entities;

import entities.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(UserAddress.class)
public class UserAddress_ { 

    public static volatile SingularAttribute<UserAddress, String> pincode;
    public static volatile SingularAttribute<UserAddress, String> country;
    public static volatile SingularAttribute<UserAddress, String> city;
    public static volatile SingularAttribute<UserAddress, String> add2;
    public static volatile SingularAttribute<UserAddress, String> add1;
    public static volatile SingularAttribute<UserAddress, User> userId;
    public static volatile SingularAttribute<UserAddress, Integer> userAddId;

}