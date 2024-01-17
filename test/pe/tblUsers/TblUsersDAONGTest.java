/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.tblUsers;

import java.sql.SQLException;
import static org.testng.Assert.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 *
 * @author anhkhoa
 */
public class TblUsersDAONGTest {
    private TblUsersDAO tblUsersDAO;
    
    public TblUsersDAONGTest() {
    }
    
    @BeforeMethod()
    public void setup() {
        tblUsersDAO = new TblUsersDAO();
    }
    
    @DataProvider(name = "validLoginData")
    public Object[][] validLoginData() {
        return new Object[][]{
            {"admin", "1"},
            {"hoadnt","1"}
        };
    }
    
    @Test(priority = 1, dataProvider = "validLoginData")
    public void testValidLoginData(String userID, String password) {
        try {
            System.out.println("Test with UserID: " + userID + " and Password: " + password);
            TblUsersDTO tblUsersDTO = tblUsersDAO.checkLogin(userID, password);
            
            assertNotNull(tblUsersDTO);
            assertEquals(tblUsersDTO.getUserID(), userID);
            assertEquals(tblUsersDTO.getPassword(), password);
            System.out.println("Test passed!");
        } catch (ClassNotFoundException e) {
            fail("ClassNotFound Exception: " + e.getMessage());
        } catch(SQLException e) {
            fail("SQL Exception: " + e.getMessage());
        }
        
    }
    
    @Test(priority = 2)
    @Parameters({"inValidUserID","inValidPassword"})
    public void testInvalidLoginData(@Optional("SE170443") String userID, @Optional("333") String password) {
        try {
            System.out.println("Test with UserID: " + userID + " and Password: " + password);
            TblUsersDTO tblUsersDTO = tblUsersDAO.checkLogin(userID, password);
            assertNull(tblUsersDTO);
            System.out.println("Test passed!");
            
        } catch (ClassNotFoundException e) {
            fail("ClassNotFound Exception: " + e.getMessage());
        } catch(SQLException e) {
            fail("SQL Exception: " + e.getMessage());
        }
    }
    
    
}
