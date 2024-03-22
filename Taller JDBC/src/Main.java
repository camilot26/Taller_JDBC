import controller.ControllerAutor;
import controller.ControllerLibro;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String opcion = "";
        String opcion1 = "";
        do {
            opcion = JOptionPane.showInputDialog("""
                    Ingrese una opcion:
                    1. LISTAR \s
                    2. INSERTAR
                    3. EDITAR
                    4. ELIMINAR\s
                    5. BUSCAR\s
                    6. CONSULTAS AVANZADAS\s
                    7. exit
                    """);
            switch (opcion) {

                case "1":

                    opcion1 = JOptionPane.showInputDialog("""
                            INGRESE UNA OPCION
                            1.Autores
                            2.Libros""");

                    switch (opcion1) {
                        case "1":
                            opcion1 = JOptionPane.showInputDialog("""
                                    INGRESE UNA OPCION
                                    1.LISTAR TODOS
                                    2.LISTAR AUTOR CON ID""");

                            if (opcion1.equals("1")) {
                                ControllerAutor.listar();
                            } else {
                                ControllerAutor.listarId();
                            }
                            break;

                        case "2":
                            ControllerLibro.listarAll();

                            break;
                    }


                    break;
                case "2":
                    opcion1 = JOptionPane.showInputDialog("""
                            INGRESE UNA OPCION
                            1.Autores
                            2.Libros""");

                    switch (opcion1) {
                        case "1":


                            ControllerAutor.insertar();


                            break;
                        case "2":
                            ControllerLibro.insertarId();

                            break;
                    }
                    break;
                case "3":
                    opcion1 = JOptionPane.showInputDialog("""
                            INGRESE UNA OPCION
                            1.Autores
                            2.Coders""");

                    switch (opcion1) {
                        case "1":


                            ControllerAutor.update();


                            break;
                        case "2":
                            ControllerLibro.actualizar();

                            break;
                    }
                    break;

                case "4":
                    opcion1 = JOptionPane.showInputDialog("""
                            INGRESE UNA OPCION
                            1.Autores
                            2.Libros""");

                    switch (opcion1) {
                        case "1":


                            ControllerAutor.eliminar();


                            break;
                        case "2":
                            ControllerLibro.eliminar();

                            break;


                    }
                    break;
                case "5":
                    opcion1 = JOptionPane.showInputDialog("""
                            INGRESE UNA OPCION
                            1.Buscar libros por nombre
                            2.Buscar libros por id
                            3.Buscar libros por Id de autor
                            """);
                    switch (opcion1) {

                        case "1":
                            ControllerLibro.findName();
                            break;


                        case "2":
                            ControllerLibro.listarId();
                            break;

                        case "3":
                            ControllerLibro.findIdautor();
                            break;
                    }




                    break;

            }


        } while (!opcion.equals("7"));
    }
}