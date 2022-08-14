package entities;

import entities.User;
import javax.annotation.processing.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2022-06-16T17:41:25", comments="EclipseLink-2.7.7.v20200504-rNA")
@StaticMetamodel(Roles.class)
public class Roles_ { 

    public static volatile SingularAttribute<Roles, Integer> roleId;
    public static volatile CollectionAttribute<Roles, User> userCollection;
    public static volatile SingularAttribute<Roles, String> roleName;

}