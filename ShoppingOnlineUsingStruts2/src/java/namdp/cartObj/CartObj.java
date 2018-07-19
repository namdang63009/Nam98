/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namdp.cartObj;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import namdp.tbl_Mobile.tbl_MobileDTO;

/**
 *
 * @author DELL
 */
public class CartObj implements Serializable{
    private String customerId;
    private Map<tbl_MobileDTO, Integer> items;

    /**
     * @return the customerId
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * @param customerId the customerId to set
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * @return the items
     */
    public Map<tbl_MobileDTO, Integer> getItems() {
        return items;
    }
    
    public void addItemToCart(tbl_MobileDTO item){
        if(this.items == null){
            this.items = new HashMap<>();
        }
        int quantity = 1;
        if(this.items.containsKey(item)){
            quantity = this.items.get(item) + 1;
        }
        this.items.put(item, quantity);
    }
    
    public void removeItemFromCart(tbl_MobileDTO item){
        if(this.items == null){
            return;
        }
        if(this.items.containsKey(item)){
            this.items.remove(item);
            if(this.items.isEmpty()){
                this.items = null;
            }
        }
    }
    
    public void removeItemFromCart(String id){
        if(this.items == null){
            return;
        }
        tbl_MobileDTO dto = new tbl_MobileDTO(id, "", 0);
        if(this.items.containsKey(dto)){
            this.items.remove(dto);
            if(this.items.isEmpty()){
                this.items = null;
            }
        }
    }



   
    
    
}
