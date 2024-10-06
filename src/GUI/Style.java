/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

/**
 *
 * @author hieun
 */
public class Style {
    
    public static void tableStyle(JTable table) {
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Segoe UI", Font.PLAIN, 16)); 
    }
    
}
