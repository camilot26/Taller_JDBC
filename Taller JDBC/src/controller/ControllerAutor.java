package controller;

import entity.Autor;
import model.ModelAutor;

import javax.swing.*;

public class ControllerAutor {
    public static void listar() {
        ModelAutor obj = new ModelAutor();
        String ListAutores = "Autor List \n";
        for (Object iterador : obj.findAll()) {
            // convertir del objet COder
            Autor objcoder = (Autor) iterador;
            ListAutores += objcoder.toString() + "\n";


        }
        JOptionPane.showMessageDialog(null, ListAutores);


    }

    public static String getAllStrings() {
        ModelAutor objectModel = new ModelAutor();

        String Listcoders = "coder List \n";
        for (Object iterador : objectModel.findAll()) {
            // convertir del objet COder
            Autor objAutor = (Autor) iterador;
            Listcoders += objAutor.toString() + "\n";


        }
        JOptionPane.showMessageDialog(null, Listcoders);

        return Listcoders;
    }


    public static void insertar() {
        ModelAutor obj = new ModelAutor();
        String nombre = JOptionPane.showInputDialog(null, "ADD AUTOR :");
        String nacionalidad = JOptionPane.showInputDialog(null, "ADD NACIONALIDAD");
        Autor objautor = new Autor();
        objautor.setNombre(nombre);
        objautor.setNacionalidad(nacionalidad);
        objautor = (Autor) obj.insert(objautor);
        JOptionPane.showMessageDialog(null, objautor.toString());


    }

    public static void eliminar() {
        ModelAutor obj = new ModelAutor();

        String Listcoders = getAllStrings();

        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "\n Enter the id the coder to delete"));
        Autor objAutor = obj.findId(id);

        if (objAutor == null) {

            JOptionPane.showMessageDialog(null, "The coder with the id " + id + " does not exist");
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete coder ?\n" + objAutor.toString());
            if (confirm == 0) {
                obj.delete(objAutor);
                JOptionPane.showMessageDialog(null, "The coder with the id " + id + " has been deleted");
            }

        }

    }

    public static void listarId() {
        ModelAutor obj = new ModelAutor();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "\n Enter the id the coder to Search"));
        String ListAutores = "Autor List \n";
        if (obj.findId(id) == null) {

            JOptionPane.showMessageDialog(null, "no found id");

        } else {

            ListAutores += obj.findId(id);

        }
        JOptionPane.showMessageDialog(null, ListAutores);


    }

    public static void update() {
        // 1. utilizar el modelo
        ModelAutor objectModel = new ModelAutor();
        String listaCoders = getAllStrings();
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(null, listaCoders + "\n Enter the id to "));
        Autor objAutor = objectModel.findId(idUpdate);
        if (objAutor == null) {

            JOptionPane.showMessageDialog(null, "AUtor not found");

        } else {
            String nombre = JOptionPane.showInputDialog(null, "UPDATE AUTOR", objAutor.getNombre());
            String nacionalidad = JOptionPane.showInputDialog(null, "UPDATE NACIONALIDAD", objAutor.getNacionalidad());
            objAutor.setNombre(nombre);
            objAutor.setNacionalidad(nacionalidad);
            objectModel.update(objAutor);


        }


    }

}
