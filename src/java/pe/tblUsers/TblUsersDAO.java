/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.tblUsers;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import pe.utils.DBUtils;

/**
 *
 * @author tahoa
 */
public class TblUsersDAO implements Serializable{
    public TblUsersDTO checkLogin(String userID, String password) throws ClassNotFoundException, SQLException {
        TblUsersDTO dto = null;
        Connection con  =null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if(con != null) {
                String sql = "SELECT fullName, status, roleID "
                        + "FROM tblUsers "
                        + "WHERE userID = ? "
                        + "AND password = ? "
                        + "AND roleID = 'AD' ";
                stm = con.prepareStatement(sql);
                stm.setString(1, userID);
                stm.setString(2, password);
                
                rs = stm.executeQuery();
                
                if(rs.next()) {
                    String fullName = rs.getString("fullName");
                    boolean status = rs.getBoolean("status");
                    String roleID = rs.getString("roleID");
                    
                    dto = new TblUsersDTO(userID, fullName, password, roleID, status);
                    
                }
            }
        } finally {
            if(rs != null) {
                rs.close();
            }
            if(stm != null) {
                stm.close();
            }
            if(con != null) {
                con.close();
            }
        }
        return dto;
        
    }
}
