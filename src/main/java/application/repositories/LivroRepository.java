package application.repositories; //PACOTE DE REPOSITÓRIOS

import org.springframework.data.repository.CrudRepository; //IMPORTANDO O CRUD REPOSITORY DO SPRING FRAMEWORK
import application.models.Livro; //IMPORTANDO O MODEL LIVRO DA APLICAÇÃO

public interface LivroRepository extends CrudRepository<Livro, Integer> { // CRIA UMA INTERFACE DE ARMAZENAMENTO CHAMADA "LivroRepository" COM A EXTENSÃO DO REPOSITÓRIO CRUD.
    
}//FECHA A INTERFACE "LivroRepository"