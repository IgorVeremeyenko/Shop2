package Classes;

import Classes.departments;
import Classes.sellers;
import Classes.shop;

import java.util.List;

public class Initialise {
    public shop Inite_shop(shop Shop, String name, String type){
        Shop.setName(name);
        Shop.setTypeOfShop(type);
        return Shop;
    }
    public sellers Inite_dseller(sellers Sellers, String name, String surname, String date, int salary){

        Sellers.setName(name);
        Sellers.setSurname(surname);
        Sellers.setBirthDate(date);
        Sellers.setSalary(salary);
        return Sellers;
    }
    public departments Inite_dep(departments Dep, String name, String type){
        Dep.setName(name);
        Dep.setTypeOfDepartment(type);
        return Dep;
    }
    public void Inite_Class(List<shop> list_shop, List<sellers> list_seller, List<departments> list_depo){

    }
}


