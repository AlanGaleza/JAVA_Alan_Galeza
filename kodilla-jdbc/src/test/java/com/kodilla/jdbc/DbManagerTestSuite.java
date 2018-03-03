package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static org.assertj.core.api.Assertions.*;

public class DbManagerTestSuite {
    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then
        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getInt("ID") + ", " +
                    rs.getString("FIRSTNAME") + ", " +
                    rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        Assert.assertEquals(4, counter);
    }

    @Test
    public void testSelectUserAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "select u.firstname, u.lastname, count(*) as post_number " +
                "from users u, posts p " +
                "where p.user_id = u.id " +
                "group by p.user_id " +
                "having count(*) = 1 " +
                "order by u.LASTNAME, u.firstname";
        Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery);

        //Then

        int counter = 0;
        while(rs.next()) {
            System.out.println(rs.getString("FIRSTNAME") + "," + rs.getString("LASTNAME"));
            counter++;
        }
        rs.close();
        statement.close();
        assertThat(counter).isEqualTo(2);

    }
}