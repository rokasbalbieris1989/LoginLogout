/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import controllers.CarServlet;
import entities.Car;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author me
 */
public class CarDao extends Database {

    String server = "localhost:3306";
    String database = "bootcampdb";
    String username = "root";
    String password = "B,kv4s313";

    public List<Car> getCarList() {
        Car c;
        List<Car> cars = new ArrayList<>();
        String query = "SELECT * FROM `usercars`.`cars`";
        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, query);
        if (rs == null) {
            System.out.println("Error to the database");
        }
        try {
            while (rs.next()) {
                c = new Car(rs.getString(1), rs.getString(2),
                        rs.getInt(3));
                cars.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cars;
    }
}
