/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.tblUsers;

import java.io.Serializable;

/**
 *
 * @author tahoa
 */
public class TblUsersError implements Serializable {
    private String incorrectErr;

    public TblUsersError() {
    }

    /**
     * @return the incorrectErr
     */
    public String getIncorrectErr() {
        return incorrectErr;
    }

    /**
     * @param incorrectErr the incorrectErr to set
     */
    public void setIncorrectErr(String incorrectErr) {
        this.incorrectErr = incorrectErr;
    }
    
    
}
