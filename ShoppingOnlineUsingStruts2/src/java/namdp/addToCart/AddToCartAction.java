/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namdp.addToCart;

import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import namdp.cartObj.CartObj;
import namdp.tbl_Mobile.tbl_MobileDAO;
import namdp.tbl_Mobile.tbl_MobileDTO;

/**
 *
 * @author DELL
 */
public class AddToCartAction {
    private String item;
    private final String SUCCESS = "success";
    private final String FAIL ="fail";
    private Map<String, String> itemsList;
   
    public AddToCartAction() {
    }
    
    public String execute() throws Exception {
        Map session = ActionContext.getContext().getSession();
        CartObj cart = (CartObj)session.get("CART");
        if(cart == null){
            cart = new CartObj();
        }
        tbl_MobileDAO dao = new tbl_MobileDAO();
        tbl_MobileDTO dto = dao.getProduct(item);
        cart.addItemToCart(dto);
        session.put("CART", cart);
        
        dao.getAllProduct();
        this.itemsList = dao.getItemList();
        return SUCCESS;
    }

    /**
     * @return the item
     */
    public String getItem() {
        return item;
    }

    /**
     * @param item the item to set
     */
    public void setItem(String item) {
        this.item = item;
    }

    /**
     * @return the SUCCESS
     */
    public String getSUCCESS() {
        return SUCCESS;
    }

    /**
     * @return the FAIL
     */
    public String getFAIL() {
        return FAIL;
    }

    /**
     * @return the itemList
     */
    public Map<String, String> getItemList() {
        return itemsList;
    }

    /**
     * @param itemList the itemList to set
     */
    public void setItemList(Map<String, String> itemList) {
        this.itemsList = itemList;
    }
    
}
