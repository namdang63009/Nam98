/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namdp.removeItem;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import namdp.cartObj.CartObj;

/**
 *
 * @author DELL
 */
public class RemoveItemFromCart {
    private String[] selectedItem;
    private final String SUCCESS = "success";
    
    public RemoveItemFromCart() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj)session.get("CART");
        
        if(cart != null){
            for (String item : selectedItem) {
                System.out.println("dd" + item);
                cart.removeItemFromCart(item);
            }
            session.put("CART", cart);
        }
        return SUCCESS;
    }

    /**
     * @return the selectedItem
     */
    public String[] getSelectedItem() {
        return selectedItem;
    }

    /**
     * @param selectedItem the selectedItem to set
     */
    public void setSelectedItem(String[] selectedItem) {
        this.selectedItem = selectedItem;
    }

    /**
     * @return the SUCCESS
     */
    public String getSUCCESS() {
        return SUCCESS;
    }
    
}
