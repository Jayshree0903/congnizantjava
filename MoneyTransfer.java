//33
import java.sql.*;

public class MoneyTransfer {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/bank";
        String user = "root";
        String password = "your_password";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            conn.setAutoCommit(false);

            PreparedStatement debit = conn.prepareStatement("UPDATE accounts SET balance = balance - ? WHERE id = ?");
            PreparedStatement credit = conn.prepareStatement("UPDATE accounts SET balance = balance + ? WHERE id = ?");

            debit.setDouble(1, 100);
            debit.setInt(2, 1); // from account

            credit.setDouble(1, 100);
            credit.setInt(2, 2); // to account

            debit.executeUpdate();
            credit.executeUpdate();

            conn.commit();
            System.out.println("Transfer successful.");
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                System.out.println("Transaction failed. Rolling back.");
                Connection conn = DriverManager.getConnection(url, user, password);
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
