/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hieun
 */
public class SessionManager {
    private static SessionManager instance;
    private StaffDTO loggedInStaff;
    private AccountDTO loggedInAccount;
    
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        
        return instance;
    }

    public StaffDTO getLoggedInStaff() {
        return loggedInStaff;
    }

    public void setLoggedInStaff(StaffDTO loggedInStaff) {
        this.loggedInStaff = loggedInStaff;
    }

    public AccountDTO getLoggedInAccount() {
        return loggedInAccount;
    }

    public void setLoggedInAccount(AccountDTO loggedInAccount) {
        this.loggedInAccount = loggedInAccount;
    }
}
