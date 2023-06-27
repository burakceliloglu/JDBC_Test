import java.sql.*;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws SQLException
    {
       //methods
    }

    public static void selectDemo() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        Statement statement = null;
        ResultSet resultSet;
        try
        {
            connection = dbHelper.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM city");
            ArrayList<City> cities = new ArrayList<City>();
            while (resultSet.next())
            {
                cities.add(new City(
                        resultSet.getString("city_id"),
                        resultSet.getString("city"),
                        resultSet.getString("country_id"),
                        resultSet.getString("last_update")));
            }
            System.out.println(cities.size());
        } catch (SQLException e)
        {
            dbHelper.showErrorMessage(e);
        } finally
        {
            connection.close();
        }
    }
    public static void insertDemo() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "INSERT city (city,country_id,last_update) values(?,?,?)";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"Duzce 2");
            preparedStatement.setString(2, "2");
            preparedStatement.setString(3,"2006-04-01");
            preparedStatement.executeUpdate();
            System.out.println("Inserted.");
        }
        catch (SQLException e)
        {
            dbHelper.showErrorMessage(e);
        }
        finally
        {
            preparedStatement.close();
            connection.close();
        }
    }
    public void updateDemo() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "update city set country_id = 77 where city_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"489");
            preparedStatement.executeUpdate();
            System.out.println("Updated.");
        }
        catch (SQLException e)
        {
            dbHelper.showErrorMessage(e);
        }
        finally
        {
            preparedStatement.close();
            connection.close();
        }
    }
    public static void deleteDemo() throws SQLException {
        Connection connection = null;
        DbHelper dbHelper = new DbHelper();
        PreparedStatement preparedStatement = null;
        try {
            connection = dbHelper.getConnection();
            String sql = "delete from city where city_id=?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,"617");
            preparedStatement.executeUpdate();
            System.out.println("Deleted.");
        }
        catch (SQLException e)
        {
            dbHelper.showErrorMessage(e);
        }
        finally
        {
            preparedStatement.close();
            connection.close();
        }
    }
}