<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <!-- CONFIGURANDO O DOCUMENTO JSP -->

<!DOCTYPE html> <!-- DECLARANDO O DOCUMENTO HTML -->

<html> <!-- INICIA O DOCUMENTO HTML -->

    <head> <!-- INICIA A TAG HEAD (CONTÉM METADADOS / INFORMAÇÕES PARA O DOCUMENTO) -->
        <meta charset="utf-8" /> <!-- DEFINE A CODIFICAÇÃO COMO UTF-8 -->
        <title>Novo Livro</title>  <!-- DEFINE O TÍTULO DO DOCUMENTO -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> <!-- CONECTA O DOCUMENTO JSP AO BOOTSTRAP -->
    </head> <!-- FINALIZA A TAG HEAD -->
 
    <body> <!-- INICIA A TAG BODY (DEFINE O CORPO DO DOCUMENTO, O QUE É VÍSIVEL AO USUÁRIO) -->
       
        <main class="container"> <!-- INICIA A TAG MAIN (CONTEÚDO PRINCIPAL DO DOCUMENTO) -->
            <h1>Novo Livro</h1> <!-- EXIBE UM TÍTULO h1 -->
            <hr> <!-- MOSTRA UMA LINHA HORIZONTAL NO DOCUMENTO -->

            <form action="insert" method="post"> <!-- INCIA O FORMULÁRIO QUE ENVIA DADOS PARA insert ATRAVÉS DO MÉTODO POST (DADOS ANEXADOS NO CORPO DA MENSAGEM, OU SEJA, NÃO APARECEM NA URL) -->
                <label for="titulo">Título</label> <!-- DEFINE UM RÓTULO PARA O INPUT -->
                <input type="text" name="titulo"/> <!-- FORNECE UM CAMPO PARA ENTRADA DE DADOS, NO CASO O NOME DE UM LIVRO QUE DESEJA INSERIR -->

                <a href="/livro/list" class="btn btn-danger">Voltar</a> <!-- EXIBE UM BOTÃO ESTILIZADO COM BOOTSTRAP PARA VOLTAR A PÁGINA -->
                <input type="submit" value="Salvar" class="btn btn-success"/> <!-- DEFINE UM BOTÃO ESTILIZADO COM O BOOTSTRAP PARA ENVIAR OS DADOS PRESENTES NO FORMULÁRIO -->
            </form> <!-- FINALIZA A TAG FORM -->
        </main> <!-- FINALIZA A TAG MAIN -->

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script> <!-- DECLARA O SEPARATE -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script> <!-- DECLARA O SEPARATE -->
    </body> <!-- FINALIZA A TAG BODY -->

</html> <!-- FINALIZA O DOCUMENTO HTML -->