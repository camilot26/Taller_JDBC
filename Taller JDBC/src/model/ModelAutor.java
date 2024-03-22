package model;

import database.CRUD;
import database.ConfigDB;
import entity.Autor;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModelAutor implements CRUD {

    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        //2. Convertir objeto
        Autor objAutor = (Autor) obj;


        try {

            String sql = "insert into autor(nombre,nacionalidad) values(?,?);";
            // PREPARA EL STATEMENT Y DEVUELVE LA ID
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            //AGREGAR ASIGNAR VALORES
            objPrepare.setString(1, objAutor.getNombre());
            objPrepare.setString(2, objAutor.getNacionalidad());

            objPrepare.execute();

            //7 obtener los resultados con las llaves generadas
            ResultSet rs = objPrepare.getGeneratedKeys();
            while (rs.next()) {
                // set asigna get retira
                objAutor.setIdAutor(rs.getInt(1));


            }
            JOptionPane.showMessageDialog(null, "CODER INSERT WAS SUCEFULL");

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }


        ConfigDB.closeConnection();


        return objAutor;
    }


    @Override
    public boolean update(Object obj) {
        //1. abrir conexion


        Connection objConection = ConfigDB.openConnection();
        //2. convertir objeto

        Autor objAutor = (Autor) obj;
        //3. variable para conecer el estado

        boolean isUpdate = false;

        try {
            //4. crear la sentencia sql

            String sql = "update autor set nombre =?, nacionalidad =? where id =?";
            PreparedStatement objPrepare = objConection.prepareStatement(sql);
            //AGREGAR ASIGNAR VALORES
            objPrepare.setString(1, objAutor.getNombre());
            objPrepare.setString(2, objAutor.getNacionalidad());
            objPrepare.setInt(3, objAutor.getIdAutor());
            int totalAffectedRows = objPrepare.executeUpdate();
            if (totalAffectedRows > 0) {
                JOptionPane.showMessageDialog(null, "AUTOR UPDATE WAS SUCCESSFUL");
                isUpdate = true;

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }


        return isUpdate;


    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        //2. Convertir objeto
        Autor objAutor = (Autor) obj;
        boolean Isdeleted = false;


        try {

            String sql = "delete from autor where id =?";
            // PREPARA EL STATEMENT Y DEVUELVE LA ID
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //AGREGAR ASIGNAR VALORES
            objPrepare.setInt(1, objAutor.getIdAutor());

            int cambio = objPrepare.executeUpdate();
            if (cambio > 0) {
                JOptionPane.showMessageDialog(null, "CODER DELETE WAS SUCCESSFUL");
                Isdeleted = true;

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }


        ConfigDB.closeConnection();


        return Isdeleted;
    }

    @Override
    public List<Object> findAll() {
        List<Object> list = new ArrayList<>();
        Connection objconnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM autor;";
            PreparedStatement ps = objconnection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Autor objautor = new Autor();
                objautor.setIdAutor(rs.getInt("id"));
                objautor.setNombre(rs.getString("nombre"));
                objautor.setNacionalidad(rs.getString("nacionalidad"));
                list.add(objautor);


            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        ConfigDB.closeConnection();
        return list;
    }

    public Autor findId(int id) {
        Connection objConnection = ConfigDB.openConnection();

        Autor objAutor = null;

        try {
            String sql = "select * from autor where id =?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            ResultSet rs = objPrepare.executeQuery();
            if (rs.next()) {
                objAutor = new Autor();
                objAutor.setIdAutor(rs.getInt("id"));
                objAutor.setNombre(rs.getString("nombre"));
                objAutor.setNacionalidad(rs.getString("nacionalidad"));

            }
        } catch (Exception e) {


            JOptionPane.showMessageDialog(null, e.getMessage());


        }

        ConfigDB.closeConnection();
        return objAutor;

    }

}
