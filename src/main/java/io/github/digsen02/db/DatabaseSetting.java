package io.github.digsen02.db;

import java.sql.*;

public class DatabaseSetting {
    public void setAccount(String userId, String serverId, String accountNum, double Money) {
        String query = "INSERT INTO accounts (userId, serverId, account, money) VALUES(?,?,?,?)";
        try (Connection connection = DatabaseConnection.getConnection()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, userId);
                statement.setString(2, serverId);
                statement.setString(3, accountNum);
                statement.setDouble(4, Money);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("successfully added account to the database");
                    System.out.println("userId = " + userId + " serverId = " + serverId + " accountNum = " + accountNum + " Money = " + Money);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public double getMoneyByUseridSeverAccountNum (String userId, String serverId, String accountNum) {
        String query = "SELECT * FROM accounts WHERE userId = ? AND serverId = ? AND account = ?";
        try(Connection connection = DatabaseConnection.getConnection()) {
            assert connection != null;
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, userId);
                statement.setString(2, serverId);
                statement.setString(3, accountNum);
                ResultSet rs = statement.executeQuery();
                while (rs.next()) {
                    return rs.getDouble("money");
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return -1;
    }
    public void setTimeLine (String userId, String serverId, String action,Timestamp time, Double Money, String account) {
        String query = "INSERT INTO log (userId, serverId, action, time, moneyRecord, accountRecord) VALUES(?,?,?,?,?,?)";
        try (Connection connection = DatabaseConnection.getConnection()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1,userId);
                statement.setString(2,serverId);
                statement.setString(3,action);
                statement.setTimestamp(4,time);
                statement.setDouble(5,Money);
                statement.setString(6,account);
                int rs = statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public Timestamp getTimeLine (String userId, String serverId, String account) {
        String query = "SELECT * FROM log WHERE userId = ? AND serverId = ? AND accountRecord = ?";
        try (Connection connection = DatabaseConnection.getConnection()) {
            assert connection != null;
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                 statement.setString(1,userId);
                 statement.setString(2,serverId);
                 statement.setString(3,account);
                 ResultSet rs = statement.executeQuery();
                 return rs.next() ? rs.getTimestamp("time") : null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public String getAccountsByServerIdAndUserId(String serverId, String userId) {
        String query = "SELECT * FROM accounts WHERE serverId = ? AND userId = ?";
        try(Connection connection = DatabaseConnection.getConnection()) {
            assert connection != null;
            try(PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, serverId);
                statement.setString(2, userId);
                ResultSet rs = statement.executeQuery();
                String accountNum = "";
                while (rs.next()) {
                    if (accountNum.equals("")) {
                        accountNum = accountNum  + rs.getString("account");
                    } else {
                        accountNum = accountNum + ":" + rs.getString("account");
                    }
                }
                return accountNum;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    // 아래 내용 다 모르겠음
    public void addAccountAccessRightsByServerIdAndUserId(String account, String userId, String serverId, String addUserId) {
        String queryCheck = "SELECT accountAccessRights FROM accounts WHERE account = ? AND userId = ? AND serverId = ?";
        String queryUpdate = "UPDATE accounts SET accountAccessRights = ? WHERE account = ? AND userId = ? AND serverId = ?";

        try (Connection connection = DatabaseConnection.getConnection()) {
            assert connection != null;
            try (PreparedStatement statementCheck = connection.prepareStatement(queryCheck);
                 PreparedStatement statementUpdate = connection.prepareStatement(queryUpdate)) {

                statementCheck.setString(1, account);
                statementCheck.setString(2, userId);
                statementCheck.setString(3, serverId);

                ResultSet resultSet = statementCheck.executeQuery();
                String currentAccessRights = "";
                if (resultSet.next()) {
                    currentAccessRights = resultSet.getString("accountAccessRights");
                    if (currentAccessRights != null && currentAccessRights.contains(addUserId)) {
                        System.out.println("accountAccessRights " + addUserId + " 는 이미 존재함");
                        return;
                    }
                }
                if (currentAccessRights == null || currentAccessRights.isEmpty()) {
                    currentAccessRights = addUserId;
                } else {
                    currentAccessRights = currentAccessRights + "," + addUserId;
                }

                statementUpdate.setString(1, currentAccessRights);
                statementUpdate.setString(2, account);
                statementUpdate.setString(3, userId);
                statementUpdate.setString(4, serverId);

                int rowsUpdated = statementUpdate.executeUpdate();
                System.out.println("Rows updated: " + rowsUpdated);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 아래 내용 다 모르겠음
    public void removeAccountAccessRightsByServerIdAndUserId(String account, String userId, String serverId,String removeUserId) {
        String queryCheck = "SELECT accountAccessRights FROM accounts WHERE account = ? AND userId = ? AND serverId = ?";
        String queryUpdate = "UPDATE accounts SET accountAccessRights = ? WHERE account = ? AND userId = ? AND serverId = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statementCheck = connection.prepareStatement(queryCheck);
             PreparedStatement statementUpdate = connection.prepareStatement(queryUpdate)) {

            statementCheck.setString(1, account);
            statementCheck.setString(2, userId);
            statementCheck.setString(3, serverId);

            ResultSet resultSet = statementCheck.executeQuery();
            String currentAccessRights = "";
            if (resultSet.next()) {
                currentAccessRights = resultSet.getString("accountAccessRights");

                if (currentAccessRights != null && !currentAccessRights.isEmpty()) {
                    String[] rightsArray = currentAccessRights.split(",");
                    StringBuilder updatedRights = new StringBuilder();
                    boolean found = false;
                    for (String right : rightsArray) {
                        if (right.trim().equals(removeUserId)) {
                            found = true;
                        } else {
                            if (updatedRights.length() > 0) {
                                updatedRights.append(",");
                            }
                            updatedRights.append(right.trim());
                        }
                    }
                    if (found) {
                        statementUpdate.setString(1, updatedRights.toString());
                        statementUpdate.setString(2, account);
                        statementUpdate.setString(3, userId);
                        statementUpdate.setString(4, serverId);

                        int rowsUpdated = statementUpdate.executeUpdate();
                        System.out.println("Rows updated: " + rowsUpdated);
                    } else {
                        System.out.println("AccountAccessRights " + removeUserId + "Not");
                    }
                } else {
                    System.out.println("No AccountAccessRights found for the given account and user.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public int getMaxCount() {
        String query = "SELECT MAX(count) AS max_count FROM accounts";
        try (Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("max_count");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
