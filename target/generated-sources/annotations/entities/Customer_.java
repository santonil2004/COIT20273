package entities;

import entities.ServiceOrder;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

<<<<<<< HEAD
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-11T18:32:31")
=======
@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2016-05-06T17:08:24")
>>>>>>> jagat
@StaticMetamodel(Customer.class)
public class Customer_ extends User_ {

<<<<<<< HEAD
    public static volatile ListAttribute<Customer, ServiceOrder> serviceOrder;
    public static volatile SingularAttribute<Customer, String> status;
=======
    public static volatile SingularAttribute<Customer, String> firstName;
    public static volatile SingularAttribute<Customer, String> lastName;
    public static volatile SingularAttribute<Customer, String> password;
    public static volatile SingularAttribute<Customer, Address> address;
    public static volatile SingularAttribute<Customer, String> middleName;
    public static volatile SingularAttribute<Customer, Long> id;
    public static volatile SingularAttribute<Customer, String> phoneNo;
    public static volatile SingularAttribute<Customer, String> email;
>>>>>>> jagat

}