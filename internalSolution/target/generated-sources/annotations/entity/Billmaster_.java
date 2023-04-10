package entity;

import entity.Billdetail;
import entity.Customer;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-10T11:25:01")
@StaticMetamodel(Billmaster.class)
public class Billmaster_ { 

    public static volatile SingularAttribute<Billmaster, Integer> billid;
    public static volatile SingularAttribute<Billmaster, Customer> custid;
    public static volatile SingularAttribute<Billmaster, Integer> grosstotal;
    public static volatile ListAttribute<Billmaster, Billdetail> billdetailList;

}