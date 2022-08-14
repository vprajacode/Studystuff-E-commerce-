package entities;

import java.util.Date;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(ShoppingSession.class)
public class ShoppingSession_ { 

    public static volatile SingularAttribute<ShoppingSession, Date> createdAt;
    public static volatile SingularAttribute<ShoppingSession, Integer> total;
    public static volatile SingularAttribute<ShoppingSession, Date> modifiedAt;
    public static volatile SingularAttribute<ShoppingSession, Integer> sessionId;
    public static volatile SingularAttribute<ShoppingSession, Integer> userId;

}