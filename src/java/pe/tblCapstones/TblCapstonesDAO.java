/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.tblCapstones;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import pe.utils.DBUtils;

/**
 *
 * @author tahoa
 */
public class TblCapstonesDAO implements Serializable {

    private List<TblCapstonesDTO> capstones;

    public List<TblCapstonesDTO> getCapstones() {
        return capstones;
    }

    public void searchCapstones(String searchValue) throws ClassNotFoundException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "SELECT id, name, description, userID "
                        + "FROM tblCapstones "
                        + "WHERE name LIKE ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");

                rs = stm.executeQuery();

                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String description = rs.getString("description");
                    String userID = rs.getString("userID");

                    TblCapstonesDTO dto = new TblCapstonesDTO(id, name, description, userID);

                    if (this.capstones == null) {
                        this.capstones = new ArrayList<>();
                    }
                    this.capstones.add(dto);

                }
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
    }

    public boolean deleteCapstone(String id) throws ClassNotFoundException, SQLException {
        boolean result = false;
        Connection con = null;
        PreparedStatement stm = null;

        try {
            con = DBUtils.getConnection();
            if (con != null) {
                String sql = "DELETE FROM dbo.tblCapstones "
                        + "WHERE id  = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                int effectRow = stm.executeUpdate();
                if (effectRow > 0) {
                    result = true;
                }
            }
        } finally {
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
        return result;
    }
}
