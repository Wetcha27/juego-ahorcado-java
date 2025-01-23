import java.util.Scanner;

public class Ahorcado {
    public static void main(String[] args) throws Exception {
        
        // Clase scanner que permite que el usuario escriba
        Scanner scanner = new Scanner(System.in);

        // Declaraciones y asignaciones
        String palabraSecreta = "flango";
        int intentosMax = 10;
        int intentos = 0;
        boolean palabraAdivinada = false;

        // Arreglos:
        char[] letrasAdivinadas = new char[palabraSecreta.length()];
        
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
            System.out.println(letrasAdivinadas[i]);
        }

        while(!palabraAdivinada && intentos < intentosMax){
            System.out.println("Palabra a adivinar: "+ String.valueOf(letrasAdivinadas) + " (" + palabraSecreta.length() + " letras)");
            System.out.println("Introducir una letra...");
            char letra = Character.toLowerCase(scanner.next().charAt(0)); // primera letra que se ingrese
            boolean letraCorrecta = false;
            
            for (int i = 0; i < palabraSecreta.length(); i++) {
                if(palabraSecreta.charAt(i) == letra){
                    letrasAdivinadas[i] = letra;
                    letraCorrecta = true;
                }
            }
            if (letraCorrecta){
                System.out.println("La letra ingresada fué correcta, ingrese otra");
            }else{
                intentos++;
                System.out.println("Incorrecto, te quedan " + (intentosMax - intentos) + " intentos.");
            }


            if(String.valueOf(letrasAdivinadas).equals(palabraSecreta)){
                palabraAdivinada = true;
                System.out.println("Adivinaste la palabra: " + palabraSecreta);
            }

        }
        if(!palabraAdivinada){
            System.out.println("GAME OVER");
        }
        scanner.close();
    }
}
