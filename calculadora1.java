/******************************************************************
@author Carol Arevalo 
@since 02/02/21

class calculadora1
******************************************************************/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
*Implemenrs interface calculadora1
*uso of stack in a calculator
*/
public class calculadora1 implements calculadora {

    //Stack
    stack <String> operaciones= new stack<String>();

    int resultado_final=-1;

    /** 
    * suma method - to add two numbers 
    * @return int
    * @param x,y
    */
    public int suma(int x, int y){
        int resultado= x+y;
        return resultado;
    }

    /** 
    * resta method - to subtract two numbers 
    * @return int
    * @param x,y
    */
    public int resta(int x, int y){
        int resultado= x-y;
        return resultado;

    }

    /** 
    * multiplicaion method - to multiplicate two numbers 
    * @return int
    * @param x,y
    */
    public int multiplicacion(int x, int y){
        int resultado= x*y;
        return resultado;

    }

    /** 
    * division method - to divide two numbers 
    * @return int
    * @param x,y
    */
    public int division(int x, int y){

        //try catch para division dentro de cero
        try{
            int resultado= x/y;
            return resultado;

        }catch(ArithmeticException e){
            System.out.println("Error: division dentro de 0");
        }
        
        resultado_final =0;
        return resultado_final; 
    }

    //******************************************************************************* */

    /** 
    * operar method - push or operate a number froma stack 
    * @return int
    * @param x
    */
    public int operar(stack x){ 

        int resultado=-1;
        stack <String> temporal= new stack<String>();
        boolean bien= x.empty();

        while(bien==false){
            String temp= x.pop().toString();
            bien= x.empty();

            int a= -1;
            int b= -1;

            //--------------------------------------------------
            if(temp.equals("+")){
            a= Integer.parseInt(temporal.pop()+"");
            b= Integer.parseInt(temporal.pop()+"");
            resultado= suma(a, b);
            temporal.push(resultado+"");
            System.out.println("Se suma");
            
            //-------------------------------------------------------
            }else if(temp.equals("-")){
                a= Integer.parseInt(temporal.pop()+"");
                b= Integer.parseInt(temporal.pop()+"");;
                resultado= resta(a, b);
                temporal.push(resultado+"");
                System.out.println("Se resta");
            
            //-------------------------------------------------------
            }else if(temp.equals("*")){
                a= Integer.parseInt(temporal.pop()+"");
                b= Integer.parseInt(temporal.pop()+"");
                resultado= multiplicacion(a, b);
                temporal.push(resultado+"");
                System.out.println("Se multpilica");

            //-------------------------------------------------------
            }else if(temp.equals("/")){
                a= Integer.parseInt(temporal.pop()+"");
                b= Integer.parseInt(temporal.pop()+"");
                resultado= division(a, b);
                temporal.push(resultado+"");
                System.out.println("Se divide");

            //-------------------------------------------------------
            }else{
                //verifica que sea un caracter valido
                boolean t= true; 
                try {  
                    Integer.parseInt(temp);  
                }catch(Exception e){  
                    System.out.println("\nSe encontro un caracter invalido, por favor revise su archivo");
                    bien=true; 
                    t=false; 
                }  

                //Si el numero es valido hace push
                if(t==true){
                    temporal.push(temp+"");
                    System.out.println("Se hace push");
                }
                
            }
        }

        //mientras no este vacio el stack 
        int tamaño= temporal.size();

        if(temporal.empty()==false){
            //tiene que quedar un dato de lo contrario hizo falta operadores
            if(tamaño!=1){
                System.out.println("Operacion incompleta: operadores faltantes");
            }
            resultado_final= Integer.parseInt(temporal.pop()+"");
        }
        
        return resultado_final;
    }

    //******************************************************************************* */

    /** 
    * decode method - reads operation from file.txt and save them in a stack 
    * @return String
    * @param a
    */

    public String decode(String a){
        String respuesta =""; 

        File file = new File(a);
        Scanner scan = null;
        
        //verifica que lea el archivo
        try{
            scan= new Scanner(file);

        }catch(FileNotFoundException e){
            System.out.println("\nNo se ha encontrado el archivo solicitado");
        }

        //va metiendo las operaciones a un stack
        while(scan.hasNextLine()){
            operaciones.push(scan.nextLine());
        }

        //va a leer cada operacion 
        while(operaciones.empty()==false){
            System.out.println("\nOperacion: " + operaciones.peek());

            String temp=(String) operaciones.pop();

            stack <String> operacion = new stack<String>();

            //va a separar los carcateres de la operacion y los envia a un stack 
            for(int i=temp.length()-1; i>=0; i--){
                
                String caracter= Character.toString(temp.charAt(i));
                if(!caracter.equals(" ")){
                    operacion.push(caracter);
                }

            }

            //el stack es enviado a operar
            int resultado= operar(operacion);
            System.out.println("La respuesta es: " + resultado);

        }
        return respuesta; 
    }
}