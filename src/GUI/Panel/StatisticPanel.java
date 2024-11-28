package GUI.Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout;
import java.awt.Font;
import java.awt.Color;

/**
 * StatisticPanel displays summary statistics.
 */
public class StatisticPanel extends JPanel {
    
    private JLabel lblTotalBooks;
    private JLabel lblTotalMembers;
    private JLabel lblIssuedBooks;
    private JLabel lblAvgBooksPerMember;
    private JLabel lblMaxBooksBorrowed;
    private JLabel lblMinBooksBorrowed;
    private JLabel lblAvgBorrowDuration;

    public StatisticPanel() {
        initComponents();
        loadStatistics();
        customInit();
    }

    private void initComponents() {

        lblTotalBooks = new JLabel("Total Books: ", SwingConstants.CENTER);
        lblTotalMembers = new JLabel("Total Members: ", SwingConstants.CENTER);
        lblIssuedBooks = new JLabel("Issued Books: ", SwingConstants.CENTER);
        lblAvgBooksPerMember = new JLabel("Average Books per Member: ", SwingConstants.CENTER);
        lblMaxBooksBorrowed = new JLabel("Max Books Borrowed by a Member: ", SwingConstants.CENTER);
        lblMinBooksBorrowed = new JLabel("Min Books Borrowed by a Member: ", SwingConstants.CENTER);
        lblAvgBorrowDuration = new JLabel("Average Borrow Duration (days): ", SwingConstants.CENTER);

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addComponent(lblTotalBooks, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblTotalMembers, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblIssuedBooks, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblAvgBooksPerMember, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMaxBooksBorrowed, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblMinBooksBorrowed, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
                .addComponent(lblAvgBorrowDuration, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createSequentialGroup()
                .addGap(20)
                .addComponent(lblTotalBooks, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(lblTotalMembers, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(lblIssuedBooks, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(lblAvgBooksPerMember, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(lblMaxBooksBorrowed, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(lblMinBooksBorrowed, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addGap(10)
                .addComponent(lblAvgBorrowDuration, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE)
        );
    }

    private void customInit() {
        // Customize labels (e.g., fonts, colors)
        Font labelFont = new Font("Arial", Font.BOLD, 16);
        Color labelColor = new Color(50, 50, 50);

        lblTotalBooks.setFont(labelFont);
        lblTotalBooks.setForeground(labelColor);

        lblTotalMembers.setFont(labelFont);
        lblTotalMembers.setForeground(labelColor);

        lblIssuedBooks.setFont(labelFont);
        lblIssuedBooks.setForeground(labelColor);

        lblAvgBooksPerMember.setFont(labelFont);
        lblAvgBooksPerMember.setForeground(labelColor);

        lblMaxBooksBorrowed.setFont(labelFont);
        lblMaxBooksBorrowed.setForeground(labelColor);

        lblMinBooksBorrowed.setFont(labelFont);
        lblMinBooksBorrowed.setForeground(labelColor);

        lblAvgBorrowDuration.setFont(labelFont);
        lblAvgBorrowDuration.setForeground(labelColor);
    }

    private void loadStatistics() {
        int totalBooks = Database.DatabaseManager.getTotalBooks();
        int totalMembers = Database.DatabaseManager.getTotalMembers();
        int issuedBooks = Database.DatabaseManager.getIssuedBooks();
        double avgBooksPerMember = Database.DatabaseManager.getAverageBooksPerMember();
        int maxBooksBorrowed = Database.DatabaseManager.getMaxBooksBorrowed();
        int minBooksBorrowed = Database.DatabaseManager.getMinBooksBorrowed();
        double avgBorrowDuration = Database.DatabaseManager.getAverageBorrowDuration();

        lblTotalBooks.setText("Total Books: " + totalBooks);
        lblTotalMembers.setText("Total Members: " + totalMembers);
        lblIssuedBooks.setText("Issued Books: " + issuedBooks);
        lblAvgBooksPerMember.setText(String.format("Average Books per Member: %.2f", avgBooksPerMember));
        lblMaxBooksBorrowed.setText("Max Books Borrowed by a Member: " + maxBooksBorrowed);
        lblMinBooksBorrowed.setText("Min Books Borrowed by a Member: " + minBooksBorrowed);
        lblAvgBorrowDuration.setText(String.format("Average Borrow Duration (days): %.2f", avgBorrowDuration));
    }
}