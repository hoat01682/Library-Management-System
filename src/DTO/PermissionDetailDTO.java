/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

/**
 *
 * @author Duc3m
 */
public class PermissionDetailDTO {
    
    private int permission_id;
    private int function_id;
    private String action;

    public PermissionDetailDTO() {
        
    }
    
    public PermissionDetailDTO(int permission_id, int function_id, String action) {
        this.permission_id = permission_id;
        this.function_id = function_id;
        this.action = action;
    }

    public int getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(int permission_id) {
        this.permission_id = permission_id;
    }

    public int getFunction_id() {
        return function_id;
    }

    public void setFunction_id(int function_id) {
        this.function_id = function_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "PermissionDetailDTO{" + "permission_id=" + permission_id + ", function_id=" + function_id + ", action=" + action + '}';
    }
    
}
