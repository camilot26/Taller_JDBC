package controller;

import controller.ControllerAutor;
import entity.Autor;
import entity.Libro;
import model.ModeLibro;
import model.ModelAutor;

import javax.swing.*;

public class ControllerLibro {
    public static void insertarId() {
        ModeLibro obj = new ModeLibro();
        ControllerAutor.listar();
        ModelAutor objAutor = new ModelAutor();
        Libro objLibro = new Libro();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "\n Ingrese el id del autor"));
        if (objAutor.findId(id) == null) {

            JOptionPane.showMessageDialog(null, "no found id");

        } else {
            String titulo = JOptionPane.showInputDialog(null, "Ingrese el nombre de libro");
            int ano = Integer.parseInt(JOptionPane.showInputDialog(null, "ingrese año de publicacion"));
            Double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "ingrese precio de libro"));
            objLibro.setTitulo(titulo);
            objLibro.setAniopublicacion(ano);
            objLibro.setPrecio(precio);
            objLibro.setIdAutor(id);
            objLibro = (Libro) obj.insertId(objLibro);
            JOptionPane.showMessageDialog(null, objLibro.toString());

        }

    }

    public static void listarAll(){
        ModeLibro obj=new ModeLibro();
        String ListLibros = "Lista de libros \n";
        for(Object iterador : obj.findAll()){
            Libro objlibro = (Libro) iterador;
            ListLibros += objlibro.toString()+"\n";


        }
        JOptionPane.showMessageDialog(null, ListLibros);
    }
    public static void eliminar() {
        ModeLibro obj = new ModeLibro();

        String LisLibros = getAllStrings();

        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "\n Entre el libro a eliminar"));
        Libro objLibro = obj.findId(id);

        if (objLibro == null) {

            JOptionPane.showMessageDialog(null, "El libro no existe con" + id );
        } else {
            int confirm = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar ? ?\n" + objLibro.toString());
            if (confirm == 0) {
                obj.delete(objLibro);
                JOptionPane.showMessageDialog(null, "El libro con  " + id + " ha sido eliminado");
            }

        }

    }

    public static String getAllStrings() {
        ModeLibro objectModel = new ModeLibro();

        String Listbook = "lISTA DE LIBROS \n";
        for (Object iterador : objectModel.findAll()) {
            // convertir del objet libro
            Libro objLibro = (Libro) iterador;
            Listbook += objLibro.toString() + "\n";


        }
        JOptionPane.showMessageDialog(null, Listbook);

        return Listbook;
    }
    public static void actualizar(){
        ModeLibro objectModel = new ModeLibro();
        String Listart = getAllStrings();
        int idUpdate = Integer.parseInt(JOptionPane.showInputDialog(null,Listart+ "Ingrese el id)"));
        Libro objLibro = objectModel.findId(idUpdate);
        if(objLibro==null){
            JOptionPane.showMessageDialog(null, "Libro not found");


        }else{
            String titulo =JOptionPane.showInputDialog(null,"ingrese el nuevo titulo del libro",objLibro.getTitulo());
            int ano = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el nuevo año de publicacion",objLibro.getAniopublicacion()));
            Double precio = Double.parseDouble(JOptionPane.showInputDialog(null,"Ingrese el nuevo precio del libro",objLibro.getPrecio()));
            objLibro.setPrecio(precio);
            objLibro.setTitulo(titulo);
            objLibro.setAniopublicacion(ano);
            objectModel.update(objLibro);

        }



    }

    public static void findName() {
        ModeLibro objectModel = new ModeLibro();

        String name = JOptionPane.showInputDialog(null, "Entre el titulo a buscar");


        String Listlibro = "Lista de libros con titulo : \n";
        if (objectModel.findName(name).isEmpty())
        {

            JOptionPane.showMessageDialog(null, "the name no exists");


        }else{
            for (Object iterador : objectModel.findName(name)) {
                // convertir del objet COder
                Libro objLibro = (Libro) iterador;
                Listlibro += objLibro.toString() + "\n";


            }

            JOptionPane.showMessageDialog(null, Listlibro);

        }


    }
    public static void listarId() {
        ModeLibro obj = new ModeLibro();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "\n Enter the id the coder to Search"));
        String Listlibro = "lista de libro  \n";
        if (obj.findId(id) == null) {

            JOptionPane.showMessageDialog(null, "no se encontro id");

        } else {

            Listlibro += obj.findId(id);

        }
        JOptionPane.showMessageDialog(null, Listlibro);


    }
    public static void findIdautor() {
        ModeLibro objectModel = new ModeLibro();
        ControllerAutor.listar();
        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Entre el id de autor  buscar"))    ;


        String Listlibro = "Lista de libros con ID DE AUTOR : \n"+id;
        if (objectModel.findIdautor(id).isEmpty())
        {

            JOptionPane.showMessageDialog(null, "EL ID DE AUTOR NO EXISTE");


        }else{
            for (Object iterador : objectModel.findIdautor(id)) {
                // convertir del objet COder
                Libro objLibro = (Libro) iterador;
                Listlibro += objLibro.toString() + "\n";


            }

            JOptionPane.showMessageDialog(null, Listlibro);

        }


    }



}
