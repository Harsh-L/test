/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatefulEjbClass.java to edit this template
 */
package ejb;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author ritesh
 */
@Stateful
public class CartBean implements CartBeanLocal {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private static List<CartItem> cartItems=new ArrayList<>();

    @Override
    public List<CartItem> getCartItems() {
        return cartItems;
    }

    @Override
    public void addItem(CartItem item) {
        if (!cartItems.contains(item)) {
            cartItems.add(item);
        }
    }

    @Override
    public void removeItem(CartItem item) {
        if (!cartItems.contains(item)) {
            cartItems.remove(item);
        }
    }

    @Override
    public int getGrossTotal() {
        int grossTotal=0;
        for(CartItem item:cartItems)
        {
            grossTotal+=item.getTotal();
        }
        return grossTotal;
    }

    @Override
    public void clearCart() {
        cartItems.clear();
    }
}
