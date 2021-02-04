/******************************************************************
@author Carol Arevalo 
@since 02/02/21

class calc calculadora - main
******************************************************************/

/** 
* main- works as a controler
* 
*/

public class calc {

    public static void main (String [ ] args) {

        calculadora1 calcu= new calculadora1();
        System.out.println("Bienvenido a calculadora:");
        String respuesta= calcu.decode("C:\\Users\\DELL\\Desktop\\Hoja de trabajo 2\\datos.txt");
    } 
} 