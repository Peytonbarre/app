package com.wings.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.function.Consumer;
import java.util.function.Function;

public class QueryExecuter {
        public static <T> T executeQuery(String sql, Consumer<PreparedStatement> paramSetter, Function<ResultSet, T> mapper) throws SQLException {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            paramSetter.accept(pstmt);
            ResultSet rs = pstmt.executeQuery();
            T result = mapper.apply(rs);
            rs.close();
            pstmt.close();
            return result;
        }

        public static void executeUpdate(String sql, Consumer<PreparedStatement> paramSetter) throws SQLException {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            paramSetter.accept(pstmt);
            pstmt.executeUpdate();
            pstmt.close();
        }
}