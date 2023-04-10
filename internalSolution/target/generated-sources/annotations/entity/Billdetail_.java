package entity;

import entity.Billmaster;
import entity.Product;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.10.v20211216-rNA", date="2023-04-10T11:25:01")
@StaticMetamodel(Billdetail.class)
public class Billdetail_ { 

    public static volatile SingularAttribute<Billdetail, Integer> total;
    public static volatile SingularAttribute<Billdetail, Product> productid;
    public static volatile SingularAttribute<Billdetail, Integer> qty;
    public static volatile SingularAttribute<Billdetail, Billmaster> billid;
    public static volatile SingularAttribute<Billdetail, Integer> billdetailid;

}