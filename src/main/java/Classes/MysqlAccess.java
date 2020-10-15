package Classes;

import java.sql.*;
import java.util.List;

public class MysqlAccess {

    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    public void creatDB(Statement stmt) throws SQLException {
        try {

            String SQL_schema = "CREATE SCHEMA `Shop` DEFAULT CHARACTER SET utf8mb4";
            String SQL_table_shop = String.format("CREATE TABLE `Shop`.`shopTable` (  " +
                    "`id` INT NOT NULL AUTO_INCREMENT,   `name` VARCHAR(150) " +
                    "CHARACTER SET 'utf8mb4' NOT NULL,   `type` VARCHAR(50) CHARACTER SET 'utf8mb4' NOT NULL, " +
                    "`departmentId` INT NULL ,   PRIMARY KEY (`id`)) " +
                    "ENGINE = InnoDB DEFAULT CHARACTER SET = utf8mb4");
            String SQL_table_departments = String.format("CREATE TABLE `Shop`.`departments` (  " +
                    "`id` INT NOT NULL AUTO_INCREMENT,  `name` VARCHAR(150) CHARACTER SET 'utf8mb4' NOT NULL, " +
                    " `typeOfDepartment` VARCHAR(45) CHARACTER SET 'utf8mb4' NOT NULL,  `sellerId` INT NULL,  " +
                    " PRIMARY KEY (`id`))");
            String SQL_table_sellers = String.format("CREATE TABLE `Shop`.`sellers` (  " +
                    "`id` INT NOT NULL AUTO_INCREMENT,  `name` VARCHAR(100) CHARACTER SET 'utf8mb4' NOT NULL, " +
                    " `surname` VARCHAR(150) CHARACTER SET 'utf8mb4' NOT NULL,  `birthday` DATE NOT NULL," +
                    "  `salary` INT NOT NULL,   PRIMARY KEY (`id`))");

            //БД
            System.out.println("Creating database");
            stmt.executeUpdate(SQL_schema);
            System.out.println("Database created!");
            //Таблица отделов
            stmt.executeUpdate(SQL_table_departments);
            //Таблица магазина
            stmt.executeUpdate(SQL_table_shop);
            String SQL_alter_shop = String.format("alter TABLE `Shop`.`shopTable` add CONSTRAINT `depId_fk` FOREIGN KEY (`departmentId`) REFERENCES `shop`.`departments` (`id`)");
            stmt.executeUpdate(SQL_alter_shop);
            System.out.println("Table \"shop\" created!");
            //Таблица продавцов
            stmt.executeUpdate(SQL_table_sellers);
            System.out.println("Table \"sellers\" created!");
            String SQL_alter_dep = String.format("alter TABLE `Shop`.`departments` add CONSTRAINT `sellerId_fk` FOREIGN KEY (`sellerId`) REFERENCES `shop`.`sellers` (`id`)");
            stmt.executeUpdate(SQL_alter_dep);
            System.out.println("Table \"departments\" created!");

        } catch (Exception e){
            e.fillInStackTrace();
        }

    }
    public void insertColumns(List<shop> list_shop, List<sellers> list_seller,
                              List<departments> list_depo, int index, Statement stmt, Connection con) throws Exception{

        String SQL_insert_sellers = "INSERT INTO `shop`.`sellers` (`name`, `surname`, `birthday` , `salary`) VALUES ('" + list_seller.get(index).getName() +
                "', '" + list_seller.get(index).getSurname() + "' , '" + list_seller.get(index).getBirthDate() + "' , '" + list_seller.get(index).getSalary() + "' )";
        stmt.executeUpdate(SQL_insert_sellers);
        System.out.println("Seller inserted");
        statement = con.prepareStatement("select * from shop.sellers");
        resultSet = statement.executeQuery("select * from shop.sellers");
        int seller_id = 0;
        while(resultSet.next()){

            seller_id = resultSet.getInt("id");
        }

        String SQL_insert_departments = String.format("INSERT INTO `shop`.`departments` (`name`, `typeOfDepartment`, `sellerId`) VALUES ('%s','%s','%d')", list_depo.get(index).getName(),
                list_depo.get(index).getTypeOfDepartment(), seller_id);
        stmt.executeUpdate(SQL_insert_departments);
        System.out.println("Depo inserted");

        int department_id = 0;
        resultSet = statement.executeQuery("select * from `shop`.`departments`");
        while (resultSet.next()){
            department_id = resultSet.getInt("id");
        }

        String SQL_insert_shop = String.format("INSERT INTO shop.shopTable (name, type, departmentId) VALUES ( '%s' , '%s', '%s' )", list_shop.get(index).getName(),
                list_shop.get(index).getTypeOfShop(), department_id);
        stmt.executeUpdate(SQL_insert_shop);
        System.out.println("Shop inserted");
    }

    public void insertSellers(List<sellers> list_seller,int index, Statement stmt, Connection con) throws Exception{

        String SQL_insert_sellers = "INSERT INTO `shop`.`sellers` (`name`, `surname`, `birthday` , `salary`) VALUES ('" + list_seller.get(index).getName() +
                "', '" + list_seller.get(index).getSurname() + "' , '" + list_seller.get(index).getBirthDate() + "' , '" + list_seller.get(index).getSalary() + "' )";
        statement = con.prepareStatement("select * from shop.sellers");
        statement.executeUpdate(SQL_insert_sellers);
        System.out.println("Seller inserted");
    }

    public void insertDepo(List<departments> list_depo, int index, int index_seller, Statement stmt, Connection con) throws Exception{

        String SQL_insert_departments = String.format("INSERT INTO `shop`.`departments` (`name`, `typeOfDepartment`, `sellerId`) VALUES ('%s','%s','%d')", list_depo.get(index).getName(),
                list_depo.get(index).getTypeOfDepartment(), index_seller);
        statement = con.prepareStatement("select * from shop.departments");
        statement.executeUpdate(SQL_insert_departments);
        System.out.println("Depo inserted");
    }

}
