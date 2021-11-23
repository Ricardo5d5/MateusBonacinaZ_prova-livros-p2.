package application.models; //PACOTE RESPONSÁVEL POR MANIPULAR INFORMAÇÕES

import javax.persistence.Entity; //IMPORTANDO O ENTITY DO JAVA
import javax.persistence.GeneratedValue; //IMPORTANDO O GENERATED VALUE DO JAVA
import javax.persistence.GenerationType; //IMPORTANDO O GENERATION TYPE DO JAVA
import javax.persistence.Id; //IMPORTANDO O ID DO JAVA
import javax.persistence.Table; //IMPORTANDO O TABLE DO JAVA

@Entity //A ANOTAÇÃO ("@ENTITY") É UTILIZADA PARA INFORMAR QUE A CLASSE "Livro" É UMA ENTIDADE
@Table(name="livros") //ESPECÍFICA A TABELA "livros" PARA O ENTITY

public class Livro { //DECLARAMOS A CLASSE "Livro"

    @Id //ESPECÍFICA A CHAVE PRIMÁRIA DA ENTIDADE
    @GeneratedValue(strategy = GenerationType.IDENTITY) //UTILIZADO PARA INFORMAR A GERAÇÃO DO VALOR DO IDENTIFICADOR ÚNICO
    private int id; //CRIAÇÃO DE UMA VARÍAVEL PRIVADA INT "id"
    private String titulo; //CRIAÇÃO DE UMA VARÍAVEL PRIVADA STRING "titulo"

    public int getId() { //CRIA UMA FUNÇÃO PÚBLICA COM RETORNO INT CHAMADA "getId()" QUE NÃO TERÁ PARÂMETRO E QUE SERVE PARA PEGAR O VALOR DE "id" (GET)
        return id; //RETORNA O VALOR DE "id"
    } //FECHA A FUNÇÃO "getId()"

    public void setId(int id) { //CRIA UMA FUNÇÃO PÚBLICA VOID CHAMADA "setId()" QUE TERÁ UM PARÂMETRO INT "id" E QUE SERVE PARA DEFINIR O VALOR DE "id" (SET)
        this.id = id; //SETA O VALOR DE "this.id" IGUAL AO PASSADO NO PARÂMETRO ("id")
    } //FECHA A FUNÇÃO "setId()"
    
    public String getTitulo() { //CRIA UMA FUNÇÃO PÚBLICA COM RETORNO STRING CHAMADA "getTitulo()" QUE NÃO TERÁ PARÂMETRO E QUE SERVE PARA PEGAR O VALOR DE "titulo" (GET)
        return titulo; //RETORNA O VALOR DE "titulo"
    } //FECHA A FUNÇÃO "getTitulo()"
    
    public void setTitulo(String titulo) { //CRIA UMA FUNÇÃO PÚBLICA VOID CHAMADA "setTitulo()" QUE TERÁ UM PARÂMETRO STRING "titulo" E QUE SERVE PARA DEFINIR O VALOR DE "titulo" (SET)
        this.titulo = titulo; //SETA O VALOR DE "this.titulo" IGUAL AO PASSADO NO PARÂMETRO ("titulo")
    } //FECHA A FUNÇÃO "setTitulo()"

} //FECHA A CLASSE "Livro"
