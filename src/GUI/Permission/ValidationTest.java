package GUI.Permission;

import org.junit.Test;
import static org.junit.Assert.*;
import javax.swing.JOptionPane;

public class ValidationTest {
    
    // Helper method to check for special characters
    private boolean containsSpecialCharacters(String name) {
        // Regex pattern allows letters, spaces and Vietnamese characters
        return !name.matches("^[a-zA-ZÀ-ỹ\\s]+$");
    }

    @Test
    public void testNameValidation() {
        // Valid names
        assertFalse(containsSpecialCharacters("Nguyen Van A"));
        assertFalse(containsSpecialCharacters("Trần Thị B"));
        assertFalse(containsSpecialCharacters("Lê Văn C"));
        
        // Invalid names with special characters
        assertTrue(containsSpecialCharacters("Nguyen@Van"));
        assertTrue(containsSpecialCharacters("Tran#Thi"));
        assertTrue(containsSpecialCharacters("Le123Van"));
        assertTrue(containsSpecialCharacters("Nguyen_Van"));
    }

    @Test
    public void testNameInput() {
        AddPermission_Frame frame = new AddPermission_Frame();
        
        // Test valid name
        frame.fullname_TextField.setText("Nguyen Van A");
        frame.validateName();
        assertNull(frame.getError());
        
        // Test invalid name
        frame.fullname_TextField.setText("Nguyen@Van#A");
        frame.validateName();
        assertEquals("Họ tên không được chứa ký tự đặc biệt.", 
                    frame.getError());
    }

    // Add this method to AddPermission_Frame class
    public boolean validateName() {
        String name = fullname_TextField.getText();
        if (containsSpecialCharacters(name)) {
            JOptionPane.showMessageDialog(this,
                "Họ tên không được chứa ký tự đặc biệt.",
                "Lỗi",
                JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}