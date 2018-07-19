/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package namdp.tbl_Mobile;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.naming.NamingException;
import namdp.connection.DBUtils;

/**
 *
 * @author DELL
 */
public class tbl_MobileDAO implements Serializable {

    private Map<String, String> itemList;

    public Map<String, String> getItemList() {
        return itemList;
    }

    public void getAllProduct() throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getMyConnection();
            String sql = "SELECT mobileId, price, mobileName "
                    + "FROM tbl_Mobile ";

            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("mobileId");
                //float price = rs.getFloat("price");
                String mbName = rs.getString("mobileName");
                if (this.itemList == null) {
                    this.itemList = new HashMap<>();
                }
                this.itemList.put(id, mbName);
            }

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public tbl_MobileDTO getProduct(String mobileId) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getMyConnection();
            String sql = "SELECT mobileId, price, mobileName "
                    + "FROM tbl_Mobile "
                    + "WHERE mobileId = ?";

            stm = con.prepareStatement(sql);
            stm.setString(1, mobileId);
            rs = stm.executeQuery();
            if (rs.next()) {
               // String id = rs.getString("mobileId");
                float price = rs.getFloat("price");
                String mbName = rs.getString("mobileName");
                tbl_MobileDTO dto = new tbl_MobileDTO(mobileId, mbName, price);
                return dto;
        
            }

        } finally {
        
                if (rs != null) {
                    rs.close();
                }
                if (stm != null) {
                    stm.close();
                }
                if (con != null) {
                    con.close();
                }

        }
        return null;
    }

}
