/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author hieun
 */
public class AccountDTO {
    private int id;
    private String username;
    private String password;
    private int permission_id;
    private String status;
    private int staff_id;

    public AccountDTO(String username, String password, int permission_id, String status, int staff_id) {
        this.username = username;
        this.password = password;
        this.permission_id = permission_id;
        this.status = status;
        this.staff_id = staff_id;
    }

    public AccountDTO(int id, String username, String password, int permission_id, String status, int staff_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.permission_id = permission_id;
        this.status = status;
        this.staff_id = staff_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStaff_id() {
        return staff_id;
    }

    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    @Override
    public String toString() {
        return "AccountDTO{" + "id=" + id + ", username=" + username + ", password=" + password + ", permission_id=" + permission_id + ", status=" + status + ", staff_id=" + staff_id + '}';
    }
    
}
