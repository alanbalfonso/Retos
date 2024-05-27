/*
 * Tema 9: HERENCIA Y POLIMORFISMO
 * Por: Alan Bauza Alfonso
 */

import java.util.ArrayList;

public class tema9 {
    public static void main(String[] args) {
        //objeto tipo libro
        Libro lib = new Libro("LIB-01", "UNO", 2024, 1234);
        lib.setEdicion(2024);
        System.out.println(lib.getEdicion());
        lib.despliega();

        //objeto tipo publicaciones
        Publicaciones pub = new Publicaciones("UNO",2024,1234);
        pub.setEdicion(2024);
        pub.despliega();
        System.out.println(pub.getEdicion());

        //objeto tipo revista
        Revista vogue = new Revista();
        vogue.despliega();

        ArrayList<Publicaciones> publicacion = new ArrayList<Publicaciones>();
        publicacion.add(lib);
        publicacion.add(vogue);
        System.out.println(publicacion);
        //por cada elemento dentro del arraylist hacer:
        for (Publicaciones item : publicacion){
            item.despliega();
        }
    }
}

class Publicaciones{
    //protected es privado dentro de su clase pero publico a las clases hijas
    protected String editor;
    protected int edicion;
    protected long fecha;
    //constructor vacio
    public Publicaciones(){}

    //constructor de la clase padre
    public Publicaciones(String editor, int edicion, long fecha){
        this.editor = editor;
        this.edicion = edicion;
        this.fecha = fecha;
    }

    public String getEditor() { 
        return this.editor; 
    }
    public int getEdicion() { 
        return this.edicion; 
    }
    public void setEditor( String editor) { 
        this.editor = editor; 
    }
    public void setEdicion( int edicion) { 
        this.edicion = edicion; 
    }

        public void setPublicaciones(String editor, long fecha){
            this.editor = editor;
            this.fecha = fecha;
        }

    //metodo original
    public void despliega(){
        System.out.println(editor);
    }
}

class Libro extends Publicaciones{
    private String ISBN;
    //constructor vacio
    public Libro(){}
    public Libro(String ISBN, String editor, int edicion, long fecha){
        //invocar al constructor de la clase padre
        super(editor,edicion,fecha);
        this.ISBN = ISBN;
    }
    public String getISBN() { 
        return this.ISBN; 
    }
    public void setISBN( String ISBN) {
        this.ISBN = ISBN; 
    }

        public void setLibro(String editor, long fecha, String ISBN){
            this.ISBN = ISBN;
            this.editor = editor;
            this.fecha = fecha;
        }
    
    //redefinicion de metodo heredado
    public void despliega(){
        //super utiliza la funcion despliega() original de Publicaciones
        super.despliega();
        System.out.println(fecha + " " + ISBN);
    }
}

class Revista extends Publicaciones{

}