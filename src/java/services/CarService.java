/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import dao.CarDao;
import entities.Car;
import java.util.List;

/**
 *
 * @author me
 */
public class CarService {
    
    public static String getCars(){
        String result="";
        CarDao cd = new CarDao();
        List<Car> cars = cd.getCarList();
        result +=("<!DOCTYPE html>");
        result +=("<html>");
        result +=("<head>");
        result +=("<title>Available cars</title>");            
        result +=("</head>");
        result +=("<body>");
        result +=("<h1>These are the students: </h1>");
        result +=("<br />");
        for(Car c:cars) {
            result += "<p>"+c+"</p>";    
        }
        String add =" <a href='index.html'>Logout</a>";//---------------------
        result += "<p>"+add+"</p>";
        result +=("</body>");
        result +=("</html>");
        return result;
    }
}
