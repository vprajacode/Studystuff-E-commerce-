package entities;

import entities.Product;
import entities.User;
import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Wishlist.class)
public class Wishlist_ { 

    public static volatile SingularAttribute<Wishlist, Integer> listId;
    public static volatile SingularAttribute<Wishlist, Date> createdAt;
    public static volatile SingularAttribute<Wishlist, Date> deletedAt;
    public static volatile SingularAttribute<Wishlist, Product> productId;
    public static volatile SingularAttribute<Wishlist, User> userId;

}