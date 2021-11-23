package application; //CRIANDO PACOTE APPLICATION

import org.springframework.boot.SpringApplication; //IMPORTANDO O SPRING APPLICATION DO SPRING BOOT
import org.springframework.boot.autoconfigure.SpringBootApplication; //IMPORTANDO SPRING BOOT APPLICATION DO SPRING BOOT

@SpringBootApplication //ANOTAÇÃO DO SPRING BOOT APPLICATION
public class Application { //CRIANDO A CLASSE APPLICATION
    public static void main(String[] args) { //CRIANDO O MÉTODO MAIN DO PROJETO (RETORNO VOID)
        SpringApplication.run(Application.class, args);  //PARA SE INICIALIZAR A APLICAÇÃO COM O SPRING BOOT.
    } //FECHANDO O MÉTODO MAIN
} //FECHANDO A CLASSE APPLICATION