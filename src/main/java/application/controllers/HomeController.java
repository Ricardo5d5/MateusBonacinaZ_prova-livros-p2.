package application.controllers; //PACOTE RESPONSÁVEL POR FAZER A INTERMEDIAÇÃO DA PARTE DE VISUALIZAÇÃO E MODEL

import org.springframework.stereotype.Controller; //IMPORTANDO O CONTROLLER DO SPRING FRAMEWORK
import org.springframework.web.bind.annotation.RequestMapping; //IMPORTANDO O REQUEST MAPPING DO SPRING FRAMEWORK
import org.springframework.web.bind.annotation.RequestMethod; //IMPORTANDO O REQUEST METHOD DO SPRING FRAMEWORK

@Controller //ATRAVÉS DA ANOTAÇÃO CONTROLLER ("@Controller"), INDICAMOS QUE A CLASSE ABAIXO É UM CONTROLLER
public class HomeController { //DECLARAMOS A CLASSE "HomeController"
    @RequestMapping(method=RequestMethod.GET) //A ANOTAÇÃO DO REQUEST MAPPING ("@RequestMapping") TEM POR FINALIDADE FAZER O MAPEAMENTO, PORTANTO INDICA QUE O CONTROLADOR RECEBERÁ REQUISIÇÕES DO TIPO GET.
    public String index() { //CRIA UMA FUNÇÃO PÚBLICA COM RETORNO String CHAMADA "index()" SEM PARÂMETRO E QUE SERVE PARA APONTAR O CAMINHO DE "index.jsp"
        return "home/index.jsp"; //RETORNA O ENDEREÇO DO "/home/index.jsp"
    } //FECHA A FUNÇÃO "index()"

} //FECHA A CLASSE HomeController