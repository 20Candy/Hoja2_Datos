import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class calculadora1 implements calculadora {

    //Stack
    stack <String> operaciones= new stack<String>();

    //Metodos
    public int suma(int x, int y){
        int resultado= x+y;
        return resultado;
    }
    public int resta(int x, int y){
        int resultado= x-y;
        return resultado;

    }
    public int multiplicacion(int x, int y){
        int resultado= x*y;
        return resultado;

    }
    public int division(int x, int y){
        int resultado= x/y;
        return resultado;

        //hacer trycath division dentro de 0
    }

    public int operar(stack x){ 

        int resultado=-1;
        stack <String> temporal= new stack<String>();

        while(x.empty()==false){
            String temp= x.pop().toString();

            int a= -1;
            int b= -1;

            if(temp.equals("+")){
                a= Integer.parseInt(temporal.pop()+"");
                b= Integer.parseInt(temporal.pop()+"");
                resultado= suma(a, b);
                temporal.push(resultado+"");
                System.out.println("Se suma");
            
            }else if(temp.equals("-")){
                a= Integer.parseInt(temporal.pop()+"");
                b= Integer.parseInt(temporal.pop()+"");;
                resultado= resta(a, b);
                temporal.push(resultado+"");
                System.out.println("Se resta");

            }else if(temp.equals("*")){
                a= Integer.parseInt(temporal.pop()+"");
                b= Integer.parseInt(temporal.pop()+"");
                resultado= multiplicacion(a, b);
                temporal.push(resultado+"");
                System.out.println("Se multpilica");

            }else if(temp.equals("/")){
                a= Integer.parseInt(temporal.pop()+"");
                b= Integer.parseInt(temporal.pop()+"");
                resultado= division(a, b);
                temporal.push(resultado+"");
                System.out.println("Se divide");

            }else{
                temporal.push(temp+"");
                System.out.println("Se hace push");
            }
        }
        resultado= Integer.parseInt(temporal.pop()+"");
        return resultado;

    }
    
    public String decode(String a){
        String respuesta =""; 

        File file = new File(a);
        Scanner scan = null;
        
        //va metiendo las operaciones a un stack
        try{
            scan= new Scanner(file);

        }catch(FileNotFoundException e){
            System.out.println("\nNo se ha encontrado el archivo solicitado");
        }

        while(scan.hasNextLine()){
            operaciones.push(scan.nextLine());
        }

        //va a leer cada operacion
        while(operaciones.empty()==false){
            System.out.println("\nOperacion: " + operaciones.peek());

            String temp=(String) operaciones.pop();

            stack <String> operacion = new stack<String>();

            for(int i=temp.length()-1; i>=0; i--){
                
                String caracter= Character.toString(temp.charAt(i));
                if(!caracter.equals(" ")){
                    operacion.push(caracter);
                }

            }

            int resultado= operar(operacion);
            System.out.println("La respuesta es: " + resultado);

        }
        return respuesta; 
    }
}