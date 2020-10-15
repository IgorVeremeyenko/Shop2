package com.servlets;
import Classes.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Classes.DBConnection;

@WebServlet("/MyServlet")
public class MyServlet extends javax.servlet.http.HttpServlet {

    private Connection con = null;
    private Statement stmt = null;
    private sellers Sellers = new sellers();
    private shop Shop = new shop();
    private departments depo = new departments();
    private List<shop> list_shop = new ArrayList<shop>();
    private Initialise inite_shop = new Initialise();
    private List<sellers> list_sellers = new ArrayList<sellers>();
    private sellers Seller = new sellers();
    private List<departments> list_depo = new ArrayList<departments>();
    private departments Departments = new departments();

    protected void Initiate(javax.servlet.http.HttpServletRequest request,
                            javax.servlet.http.HttpServletResponse response) throws ServletException, IOException, SQLException, ClassNotFoundException {
        DBConnection connectionDB = new DBConnection();
        try {
            con = DBConnection.initializeDatabase();
            createDB();
        }catch (Exception e){
            e.fillInStackTrace();
        }finally {
            con.close();
        }

    }

    protected void doPost(javax.servlet.http.HttpServletRequest request,
                          javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

        try {

            RequestDispatcher dispatcher = request.getRequestDispatcher("/Shops/addShop.jsp");
            dispatcher.forward(request, response);
            response.sendRedirect("/Shops/addShop.jsp");

            String nameOfShop = request.getParameter("nameOfShop");
            String typeOfShop = request.getParameter("typeOfShop");
            list_shop.add(inite_shop.Inite_shop(Shop, nameOfShop, typeOfShop));
            dispatcher = request.getRequestDispatcher("/Shops/addShop2.jsp");
            dispatcher.forward(request, response);
            response.sendRedirect("/Shops/addShop2.jsp");

            String nameOfShop2 = request.getParameter("nameOfShop2");
            String typeOfShop2 = request.getParameter("typeOfShop2");
            shop Shop2 = new shop();
            list_shop.add(inite_shop.Inite_shop(Shop2, nameOfShop2, typeOfShop2));
            dispatcher = request.getRequestDispatcher("/Sellers/addSeller.jsp");
            dispatcher.forward(request, response);
            response.sendRedirect("/Seller/addSeller.jsp");

            String nameSeller1 = request.getParameter("nameSeller1");
            String surnameSeller1 = request.getParameter("surnameSeller1");
            String dateSeller1 = request.getParameter("dateSeller1");
            int salarySeller1 = Integer.parseInt(request.getParameter("salarySeller1"));
            list_sellers.add(inite_shop.Inite_dseller(Seller, nameSeller1, surnameSeller1, dateSeller1, salarySeller1));
            dispatcher = request.getRequestDispatcher("/Sellers/addSeller2.jsp");
            dispatcher.forward(request, response);
            response.sendRedirect("/Sellers/addSeller2.jsp");

            sellers Seller2 = new sellers();
            String nameSeller2 = request.getParameter("nameSeller2");
            String surnameSeller2 = request.getParameter("surnameSeller2");
            String dateSeller2 = request.getParameter("dateSeller2");
            int salarySeller2 = Integer.parseInt(request.getParameter("salarySeller2"));
            list_sellers.add(inite_shop.Inite_dseller(Seller2, nameSeller2, surnameSeller2, dateSeller2, salarySeller2));
            dispatcher = request.getRequestDispatcher("/Sellers/addSeller3.jsp");
            dispatcher.forward(request, response);
            response.sendRedirect("/Sellers/addSeller3.jsp");

            sellers Seller3 = new sellers();
            String nameSeller3 = request.getParameter("nameSeller3");
            String surnameSeller3 = request.getParameter("surnameSeller3");
            String dateSeller3 = request.getParameter("dateSeller3");
            int salarySeller3 = Integer.parseInt(request.getParameter("salarySeller3"));
            list_sellers.add(inite_shop.Inite_dseller(Seller3, nameSeller3, surnameSeller3, dateSeller3, salarySeller3));
            dispatcher = request.getRequestDispatcher("/Sellers/addSeller4.jsp");
            dispatcher.forward(request, response);
            response.sendRedirect("/Sellers/addSeller4");

            sellers Seller4 = new sellers();
            String nameSeller4 = request.getParameter("nameSeller4");
            String surnameSeller4 = request.getParameter("surnameSeller4");
            String dateSeller4 = request.getParameter("dateSeller4");
            int salarySeller4 = Integer.parseInt(request.getParameter("salarySeller4"));
            list_sellers.add(inite_shop.Inite_dseller(Seller4, nameSeller4, surnameSeller4, dateSeller4, salarySeller4));
            dispatcher = request.getRequestDispatcher("/Depos/addDepartment.jsp");
            dispatcher.forward(request, response);
            response.sendRedirect("/Depos/addDepartment.jsp");

            String nameDepo1 = request.getParameter("nameDepo1");
            String typeDepo1 = request.getParameter("typeDepo1");
            list_depo.add(inite_shop.Inite_dep(Departments, nameDepo1, typeDepo1));
            dispatcher = request.getRequestDispatcher("/Depos/addDepartment2.jsp");
            dispatcher.forward(request, response);
            response.sendRedirect("/Depos/addDepartment2.jsp");

            departments Departments2 = new departments();
            String nameDepo2 = request.getParameter("nameDepo2");
            String typeDepo2 = request.getParameter("typeDepo2");
            list_depo.add(inite_shop.Inite_dep(Departments2, nameDepo2, typeDepo2));
            dispatcher = request.getRequestDispatcher("/Finish.jsp");
            dispatcher.forward(request, response);

        }catch(Exception ex) {

            getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

    private void createDB() throws Exception {
        MysqlAccess dao = new MysqlAccess();
        //Создание БД
        try {
            stmt = con.createStatement();
            dao.creatDB(stmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //Регистрируем первый магазин
        try {
            dao.insertColumns(list_shop,list_sellers,list_depo,0,stmt,con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Регистрируем второй магазин
        try {
            dao.insertColumns(list_shop,list_sellers,list_depo,1,stmt,con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Добавляем еще продавцов
        try {
            dao.insertSellers(list_sellers, 2,stmt,con);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            dao.insertSellers(list_sellers, 3,stmt,con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Добавляем продавца в первый отдел
        try {
            dao.insertDepo(list_depo,0,3,stmt,con);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //Добавляем продавца во второй отдел
        try {
            dao.insertDepo(list_depo,1,4,stmt,con);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
