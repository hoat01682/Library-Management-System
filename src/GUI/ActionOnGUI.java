/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import DTO.StaffDTO;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hieun
 */
public class ActionOnGUI {
    
    // Thoát frame hiện tại và hiện frame mới
    public static void disposeAndOpenNewFrame(JFrame disposeFrame, JFrame newFrame) {
        disposeFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                JFrame openFrame = newFrame;
                openFrame.setVisible(true); 
            }
        });
    }
    
    public static <T> void showDataOnTable(DefaultTableModel model, ArrayList<T> list) {
        model.setRowCount(0);

        if (list.isEmpty()) {
            return;
        }

        T firstObject = list.get(0);

        if (firstObject instanceof StaffDTO) {
            for (T item : list) {
                
                StaffDTO staff = (StaffDTO) item;
                
                Object[] rowData = new Object[]{
                    staff.getId(),
                    staff.getFullName(),
                    staff.getEmail(),
                    staff.getPhone(),
                    staff.getAddress(),
                    staff.getHireDate(),
                    staff.getStatus(),
                };

                model.addRow(rowData);
            }
        }
    }
    
}
