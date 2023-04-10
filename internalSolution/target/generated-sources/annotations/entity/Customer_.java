package entity;

import entity.Billmaster;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-10T11:25:01")
@StaticMetamodel(Customer.class)
public class Customer_ { 

    public static volatile SingularAttribute<Customer, String> address;
    public static volatile ListAttribute<Customer, Billmaster> billmasterList;
    public static volatile SingularAttribute<Customer, Integer> custid;
    public static volatile SingularAttribute<Customer, String> custname;
    public static volatile SingularAttribute<Customer, String> phoneno;
    public static volatile SingularAttribute<Customer, String> email;

}