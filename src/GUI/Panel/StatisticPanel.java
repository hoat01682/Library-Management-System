package GUI.Panel;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

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
    }

    private void initComponents() {
        setLayout(new GridLayout(7, 1, 10, 10));
        
        lblTotalBooks = new JLabel("Total Books: ", SwingConstants.CENTER);
        lblTotalMembers = new JLabel("Total Members: ", SwingConstants.CENTER);
        lblIssuedBooks = new JLabel("Issued Books: ", SwingConstants.CENTER);
        lblAvgBooksPerMember = new JLabel("Average Books per Member: ", SwingConstants.CENTER);
        lblMaxBooksBorrowed = new JLabel("Max Books Borrowed by a Member: ", SwingConstants.CENTER);
        lblMinBooksBorrowed = new JLabel("Min Books Borrowed by a Member: ", SwingConstants.CENTER);
        lblAvgBorrowDuration = new JLabel("Average Borrow Duration (days): ", SwingConstants.CENTER);
        
        add(lblTotalBooks);
        add(lblTotalMembers);
        add(lblIssuedBooks);
        add(lblAvgBooksPerMember);
        add(lblMaxBooksBorrowed);
        add(lblMinBooksBorrowed);
        add(lblAvgBorrowDuration);
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