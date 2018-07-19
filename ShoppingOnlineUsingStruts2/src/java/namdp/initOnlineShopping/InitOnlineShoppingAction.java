/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namdp.initOnlineShopping;

import java.util.Map;
import namdp.tbl_Mobile.tbl_MobileDAO;

/**
 *
 * @author DELL
 */
public class InitOnlineShoppingAction {
    private Map<String, String> itemList;
    private final String SUCCESS ="success";
    public InitOnlineShoppingAction() {
    }
    
    public String execute() throws Exception {
        tbl_MobileDAO dao = new tbl_MobileDAO();
        dao.getAllProduct();
        this.itemList = dao.getItemList();
        return SUCCESS;
    }

    /**
     * @return the itemList
     */
    public Map<String, String> getItemList() {
        return itemList;
    }

    /**
     * @param itemList the itemList to set
     */
    public void setItemList(Map<String, String> itemList) {
        this.itemList = itemList;
    }

    /**
     * @return the SUCCESS
     */
    public String getSUCCESS() {
        return SUCCESS;
    }
    
}
