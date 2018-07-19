/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namdp.tbl_Mobile;

import java.io.Serializable;

/**
 *
 * @author DELL
 */
public class tbl_MobileDTO implements Serializable{
    private String mobileId;
    private String mobileName;
    private float price;

    public tbl_MobileDTO() {
    }

    public tbl_MobileDTO(String mobileId, String mobileName, float price) {
        this.mobileId = mobileId;
        this.mobileName = mobileName;
        this.price = price;
    }

    /**
     * @return the mobileId
     */
    public String getMobileId() {
        return mobileId;
    }

    /**
     * @param mobileId the mobileId to set
     */
    public void setMobileId(String mobileId) {
        this.mobileId = mobileId;
    }

    /**
     * @return the mobileName
     */
    public String getMobileName() {
        return mobileName;
    }

    /**
     * @param mobileName the mobileName to set
     */
    public void setMobileName(String mobileName) {
        this.mobileName = mobileName;
    }

    /**
     * @return the price
     */
    public float getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(float price) {
        this.price = price;
    }
    
    @Override
    public boolean equals(Object obj){
        if(!(obj instanceof tbl_MobileDTO)){
            return false;
        }
        tbl_MobileDTO other = (tbl_MobileDTO) obj;
        
        if((this.mobileId == null && other.mobileId != null) 
                ||(this.mobileId != null && this.mobileId.equals(other.mobileId))){
            return false;
        }
        return true;
    }
    
    public int hashCode(){
        int hash = 0;
        hash += (mobileId != null ? mobileId.hashCode() : 0);
        return hash;
    }
}
