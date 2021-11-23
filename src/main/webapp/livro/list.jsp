<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %> <!-- CONFIGURANDO O DOCUMENTO JSP -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> <!-- IMPORTANDO BIBLIOTECAS PARA O DOCUMENTO JSP E AS ATRIBUINDO O PREFIXO DE C -->

<!DOCTYPE html> <!-- DECLARANDO O DOCUMENTO HTML -->

<html>  <!-- INICIA O DOCUMENTO HTML -->
    
    <head> <!-- INICIA A TAG HEAD (CONTÉM METADADOS / INFORMAÇÕES PARA O DOCUMENTO) -->
        <meta charset="utf-8" /> <!-- DEFINE A CODIFICAÇÃO COMO UTF-8 -->
        <title>Livros</title> <!-- DEFINE O TÍTULO DO DOCUMENTO -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous"> <!-- CONECTA O DOCUMENTO JSP AO BOOTSTRAP -->
    </head> <!-- FINALIZA A TAG HEAD -->
    
    <body> <!-- INICIA A TAG BODY (DEFINE O CORPO DO DOCUMENTO, O QUE É VÍSIVEL AO USUÁRIO) -->
        
        <main class="container"> <!-- INICIA A TAG MAIN (CONTEÚDO PRINCIPAL DO DOCUMENTO) -->
            <h1>Livros</h1> <!-- EXIBE UM TÍTULO h1 -->
            <a href="/livro/insert" class="btn btn-primary">Novo livro</a> <!-- EXIBE UMA ÂNCORA ESTILIZADA COM BOOTSTRAP PARA REDIRECIONAR PARA A PÁGINA livro/insert -->

            <table> <!-- INICIA UMA TABELA -->
                <tr> <!-- ANUNCIA O ÍNICIO DE UMA LINHA DA TABELA -->
                    <th>ID</th> <!-- DEFINE O CABEÇALHO ID PARA A TABELA -->
                    <th>Título</th> <!-- DEFINE O CABEÇALHO Título PARA A TABELA -->
                </tr> <!-- FINALIZA A LINHA DA TABELA -->
                    
                <c:forEach var="l" items="${livros}"> <!-- TAG RESPONSÁVEL POR LISTAR TODOS OS LIVROS PRESENTES NA BASE DE DADOS E APLICAR A TODOS ELES AS PŔOXIMAS TAGS (UMA ESPÉCIE DE LOOP) -->
                <tr> <!-- ANUNCIA O ÍNICIO DE UMA LINHA DA TABELA -->
                    <td>${l.id}</td> <!-- DEFINE UMA CÉLULA DA TABELA COM O ID DO LIVRO -->
                    <td>${l.titulo}</td>  <!-- DEFINE UMA CÉLULA DA TABELA COM O Título DO LIVRO -->
                    
                    <td> <!-- DEFINE UMA CÉLULA DA TABELA -->
                        <a href="/livro/update/${l.id}" class="btn btn-primary">Atualizar livro</a> <!-- EXIBE UMA ÂNCORA ESTILIZADA COM BOOTSTRAP PARA ATUALIZAR O LIVRO -->
                    </td> <!-- FINALIZA UMA CÉLULA DA TABELA -->
                    
                    <td> <!-- DEFINE UMA CÉLULA DA TABELA -->
                        <a href="/livro/delete/${l.id}" class="btn btn-danger">Excluir livro</a>  <!-- EXIBE UMA ÂNCORA ESTILIZADA COM BOOTSTRAP PARA EXCLUIR O LIVRO -->
                    </td> <!-- FINALIZA UMA CÉLULA DA TABELA -->

                </tr> <!-- FINALIZA A LINHA DA TABELA -->

                </c:forEach> <!-- FINALIZA A TAG C:FOREACH (A ESPÉCIE DE LOOP) -->
            </table> <!-- FINALIZA UMA TABELA -->

            <h1>Lista de livros! Mateus Bonacina</h1> <!-- EXIBE UM TÍTULO h1 -->
        </main> <!-- FINALIZA A TAG MAIN -->

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script> <!-- DECLARA O SEPARATE -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script> <!-- DECLARA O SEPARATE -->
    </body> <!-- FINALIZA A TAG BODY -->

</html> <!-- FINALIZA O DOCUMENTO HTML -->