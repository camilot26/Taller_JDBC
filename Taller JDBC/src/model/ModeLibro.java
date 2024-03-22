package model;

import database.CRUD;
import database.ConfigDB;
import entity.Autor;
import entity.Libro;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ModeLibro implements CRUD {

    @Override
    public Object insert(Object obj) {


        return null;
    }

    @Override
    public boolean update(Object objeto) {
        //1. abrir conexion


        Connection objConection = ConfigDB.openConnection();
        //2. convertir objeto

        Libro objLibro = (Libro) objeto;
        //3. variable para conecer el estado

        boolean isUpdate = false;

        try {
            //4. crear la sentencia sql

            String sql = "update libro set titulo =?, anio_publicacion =?, precio =?, where id =?";
            PreparedStatement objPrepare = objConection.prepareStatement(sql);
            objPrepare.setString(1, objLibro.getTitulo());
            objPrepare.setInt(2, objLibro.getAniopublicacion());
            objPrepare.setDouble(3, objLibro.getPrecio());
            objPrepare.setInt(4, objLibro.getId());
            int totalAffectedRows = objPrepare.executeUpdate();
            if (totalAffectedRows > 0) {
                JOptionPane.showMessageDialog(null, "Libro ha sido actualizado");
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
        Libro objLibro = (Libro) obj;
        boolean Isdeleted = false;


        try {

            String sql = "delete from libro where id =?";
            // PREPARA EL STATEMENT Y DEVUELVE LA ID
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //AGREGAR ASIGNAR VALORES
            objPrepare.setInt(1, objLibro.getId());

            int cambio = objPrepare.executeUpdate();
            if (cambio > 0) {
                JOptionPane.showMessageDialog(null, "libro eliminado");
                Isdeleted = true;

            }

        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }


        ConfigDB.closeConnection();


        return Isdeleted;


    }

    public List<Object> findAll() {
        List<Object> list = new ArrayList<>();
        Connection objconnection = ConfigDB.openConnection();
        try {
            String sql = "SELECT * FROM libro;";
            PreparedStatement ps = objconnection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Libro objlibro = new Libro();
                objlibro.setId(rs.getInt("id"));
                objlibro.setTitulo(rs.getString("titulo"));
                objlibro.setAniopublicacion(rs.getInt("anio_publicacion"));
                objlibro.setPrecio(rs.getDouble("precio"));
                objlibro.setIdAutor(rs.getInt("id_autor"));
                list.add(objlibro);


            }


        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

        ConfigDB.closeConnection();
        return list;


    }


    public Object insertId(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Libro objLibro = (Libro) obj;
        try {
            String sql = " insert into libro(titulo,anio_publicacion,precio,id_autor) values(?,?,?,?)";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            objPrepare.setString(1, objLibro.getTitulo());
            objPrepare.setInt(2, objLibro.getAniopublicacion());
            objPrepare.setDouble(3, objLibro.getPrecio());
            objPrepare.setInt(4, objLibro.getIdAutor());
            objPrepare.execute();
            ResultSet rs = objPrepare.getGeneratedKeys();
            while (rs.next()) {
                objLibro.setId(rs.getInt(1));

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());


        }
        ConfigDB.closeConnection();
        return objLibro;
    }

    public Libro findId(int id) {
        Connection objConnection = ConfigDB.openConnection();

        Libro objLibro = null;

        try {
            String sql = "select * from libro where id =?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            ResultSet rs = objPrepare.executeQuery();
            if (rs.next()) {
                objLibro = new Libro();
                objLibro.setId(rs.getInt("id"));
                objLibro.setTitulo(rs.getString("titulo"));
                objLibro.setAniopublicacion(rs.getInt("anio_publicacion"));
                objLibro.setPrecio(rs.getDouble("precio"));
                objLibro.setIdAutor(rs.getInt("id_autor"));
            }
        } catch (Exception e) {


            JOptionPane.showMessageDialog(null, e.getMessage());


        }

        ConfigDB.closeConnection();
        return objLibro;

    }

    public List<Object> findName(String name) {

        Connection objConnection = ConfigDB.openConnection();
        List<Object> lista = new ArrayList<>();


        try {
            String sql = "select * from libro where titulo like ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setString(1, "%" + name + "%");
            ResultSet rs = objPrepare.executeQuery();
            while (rs.next()) {

                Libro Objlibro = new Libro();
                Objlibro.setId(rs.getInt("id"));
                Objlibro.setTitulo(rs.getString("titulo"));
                Objlibro.setAniopublicacion(rs.getInt("anio_publicacion"));
                Objlibro.setPrecio(rs.getDouble("precio"));
                Objlibro.setIdAutor(rs.getInt("id_autor"));
                lista.add(Objlibro);


            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, e.getMessage());

        }
        ConfigDB.closeConnection();
        return lista;
    }

    public List<Object> findIdautor(int id) {
        Connection objConnection = ConfigDB.openConnection();
        List<Object> lista = new ArrayList<>();


        try {
            String sql = "select * from libro where id_autor =?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            objPrepare.setInt(1, id);
            ResultSet rs = objPrepare.executeQuery();
            while (rs.next()) {

                Libro Objlibro = new Libro();
                Objlibro.setId(rs.getInt("id"));
                Objlibro.setTitulo(rs.getString("titulo"));
                Objlibro.setAniopublicacion(rs.getInt("anio_publicacion"));
                Objlibro.setPrecio(rs.getDouble("precio"));
                Objlibro.setIdAutor(rs.getInt("id_autor"));
                lista.add(Objlibro);


            }
        } catch (Exception e) {


            JOptionPane.showMessageDialog(null, e.getMessage());


        }

        ConfigDB.closeConnection();
        return lista;

    }









}
