package entity;

public class Libro extends Autor{
    private int id;
    private String titulo;
    private int aniopublicacion;
    private double precio;

 public Libro(){


 }
    public Libro (int idAutor,int id, String titulo, int aniopublicacion){
        super(idAutor);
        this.id = id;
        this.titulo = titulo;
        this.aniopublicacion = aniopublicacion;



    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAniopublicacion() {
        return aniopublicacion;
    }

    public void setAniopublicacion(int aniopublicacion) {
        this.aniopublicacion = aniopublicacion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "\n Libro{" +
                "id :" + id +
                ", titulo :'" + titulo + '\'' +
                ", Año de publicacion :" + aniopublicacion +
                ", precio :" + precio+
                '}';
    }
}
