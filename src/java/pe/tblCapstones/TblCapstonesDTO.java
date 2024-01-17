/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.tblCapstones;

import java.io.Serializable;

/**
 *
 * @author tahoa
 */
public class TblCapstonesDTO implements Serializable{
    private String id;
    private String name;
    private String description;
    private String userID;

    public TblCapstonesDTO() {
    }

    public TblCapstonesDTO(String id, String name, String description, String userID) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userID = userID;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * @param userID the userID to set
     */
    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    
}
