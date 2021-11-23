package application.controllers; //PACOTE RESPONSÁVEL POR FAZER A INTERMEDIAÇÃO DA PARTE DE VISUALIZAÇÃO E MODEL


import org.springframework.beans.factory.annotation.Autowired; //IMPORTANDO O AUTOWIRED DO SPRING FRAMEWORK
import org.springframework.stereotype.Controller; //IMPORTANDO O CONTROLLER DO SPRING FRAMEWORK
import org.springframework.web.bind.annotation.RequestMapping; //IMPORTANDO O REQUEST MAPPING DO SPRING FRAMEWORK
import org.springframework.web.bind.annotation.RequestMethod; //IMPORTANDO O REQUEST METHOD DO SPRING FRAMEWORK
import org.springframework.web.bind.annotation.RequestParam; //IMPORTANDO O REQUEST PARAM DO SPRING FRAMEWORK
import org.springframework.web.bind.annotation.PathVariable; //IMPORTANDO O PATH VARIABLE DO SPRING FRAMEWORK
import org.springframework.ui.Model; //IMPORTANDO O MODEL DO SPRING FRAMEWORK

import java.util.Optional; //IMPORTANDO O OPTIONAL DO JAVA

import application.models.Livro; //IMPORTANDO O MODEL LIVRO DA APLICAÇÃO
import application.repositories.LivroRepository; //IMPORTANDO O REPOSITORIO LivroRepository DA APLICAÇÃO



@Controller //ATRAVÉS DA ANOTAÇÃO CONTROLLER ("@Controller"), INDICAMOS QUE A CLASSE ABAIXO É UM CONTROLLER
@RequestMapping("/livro") //A ANOTAÇÃO DO REQUEST MAPPING ("@RequestMapping") TEM POR FINALIDADE FAZER O MAPEAMENTO, PORTANTO INDICA QUE O CONTROLADOR RECEBERÁ REQUISIÇÕES NO ENDEREÇO INDICADO ("/livro").
public class LivroController { //DECLARAMOS A CLASSE "LivroController"
    
    @Autowired //O AUTOWIRED (@AUTOWIRED) É A ANOTAÇÃO MAIS UTILIZA COM RELAÇÃO A INJEÇÃO DE DEPENDÊNCIAS. COMO O PRÓPRIO NOME DIZ, O AUTOWIRED, INDICA UM PONTO AONDE A INJEÇÃO AUTOMÁTICA DEVE SER APLICADA
    private LivroRepository livrosRepo; //CRIA UM OBJETO PRIVADO CHAMADO livrosRepo DO TIPO LivroRepository
   
    @RequestMapping("/list") //A ANOTAÇÃO DO REQUEST MAPPING ("@RequestMapping") TEM POR FINALIDADE FAZER O MAPEAMENTO, PORTANTO INDICA QUE O CONTROLADOR RECEBERÁ REQUISIÇÕES NO ENDEREÇO INDICADO ("/list").
    public String list(Model model) {  //CRIA UMA FUNÇÃO PÚBLICA COM RETORNO String CHAMADA "list()" QUE TERÁ UM PARÂMETRO MODEL "model" E QUE SERVE PARA LISTAR TODOS OS LIVROS
        model.addAttribute("livros", livrosRepo.findAll()); //ADICIONA O ATRÍBUTO "livros" AO MODELO E PREENCHE COM TODOS LIVROS DO "livrosRepo"
        return "list.jsp"; //RETORNA O ENDEREÇO DO "list.jsp"
    } //FECHA A FUNÇÃO "list()"


    public String listar(){ //CRIA UMA FUNÇÃO PÚBLICA COM RETORNO String CHAMADA "listar()" SEM PARÂMETRO E QUE SERVE PARA LISTAR TODOS OS LIVROS DENTRO DO "/livro"
      return "livro/list.jsp"; //RETORNA O ENDEREÇO DO "livro/list.jsp"
    } //FECHA A FUNÇÃO "listar()"


    @RequestMapping("/insert") //A ANOTAÇÃO DO REQUEST MAPPING ("@RequestMapping") TEM POR FINALIDADE FAZER O MAPEAMENTO, PORTANTO INDICA QUE O CONTROLADOR RECEBERÁ REQUISIÇÕES NO ENDEREÇO INDICADO ("/insert").
    public String formInsert(){ //CRIA UMA FUNÇÃO PÚBLICA COM RETORNO String CHAMADA "formInsert()" SEM PARÂMETRO E QUE SERVE PARA APONTAR O CAMINHO DE "insert.jsp"
      return "insert.jsp"; //RETORNA O ENDEREÇO DO "insert.jsp"
    } //FECHA A FUNÇÃO "formInsert()"
    
    
    @RequestMapping(value="/insert", method=RequestMethod.POST) //A ANOTAÇÃO DO REQUEST MAPPING ("@RequestMapping") TEM POR FINALIDADE FAZER O MAPEAMENTO, PORTANTO INDICA QUE O CONTROLADOR RECEBERÁ REQUISIÇÕES DO TIPO POST NO ENDEREÇO INDICADO ("/insert").
    public String saveInsert(@RequestParam("titulo") String titulo){ //CRIA UMA FUNÇÃO PÚBLICA COM RETORNO String CHAMADA "saveInsert()" COM O PARÂMETRO STRING "titulo" E QUE SERVE PARA INSERIR UM LIVRO NO "livrosRepo"
      Livro livro=new Livro(); //CRIA UMA INSTÂNCIA DO TIPO "Livro" CHAMADA DE "livro"
      livro.setTitulo(titulo); //DEFINE UM TÍTULO PARA "livro"
      livrosRepo.save(livro); //SALVA O "livro" NO "livrosRepo"
      return "redirect:/livro/list"; //REDIRECIONA O NAVEGADOR PARA "/livro/list"
    } //FECHA A FUNÇÃO "saveInsert()"
    

    @RequestMapping("/update/{id}") //A ANOTAÇÃO DO REQUEST MAPPING ("@RequestMapping") TEM POR FINALIDADE FAZER O MAPEAMENTO, PORTANTO INDICA QUE O CONTROLADOR RECEBERÁ REQUISIÇÕES NO ENDEREÇO INDICADO ("/insert"). O {id} é REFERENTE AO ID DO LIVRO
      public String formUpdate(Model model, @PathVariable int id ){ //CRIA UMA FUNÇÃO PÚBLICA COM RETORNO String CHAMADA "formUpdate()" COM OS PARÂMETRO MODEL "model" E INT "id" E QUE SERVE PARA VERIFICAR SE E POSSÍVEL ATUALIZAR O TÍTULO DO LIVRO NO REPOSITÓRIO
        Optional<Livro> livro=livrosRepo.findById(id); //BUSCA O LIVRO PELO "id" E VERIFICA SE ELE ESTÁ PRESENTE
        if(!livro.isPresent()) //SE ELE NÃO ESTIVER PRESENTE
          return "redirect:/livro/list"; //REDIRECIONA O NAVEGADOR PARA "/livro/list"
        model.addAttribute("livro",livro.get()); //ADICIONA O ATRIBUTO "livro" AO MODELO E PEGA O LIVRO
        return "/livro/update.jsp"; //RETORNA O ENDEREÇO DO "/livro/update.jsp"
      } //FECHA A FUNÇÃO "formUpdate()"


    @RequestMapping(value="/update",method=RequestMethod.POST) //A ANOTAÇÃO DO REQUEST MAPPING ("@RequestMapping") TEM POR FINALIDADE FAZER O MAPEAMENTO, PORTANTO INDICA QUE O CONTROLADOR RECEBERÁ REQUISIÇÕES DO TIPO POST NO ENDEREÇO INDICADO ("/update").
    public String saveUpdate(@RequestParam("titulo")String titulo, @RequestParam("id")int id){ //CRIA UMA FUNÇÃO PÚBLICA COM RETORNO String CHAMADA "saveUpdate()" COM OS PARÂMETRO STRING "titulo" E INT "id" E QUE SERVE PARA ATUALIZAR OS LIVROS DO REPOSITÓRIO
      Optional<Livro> livro=livrosRepo.findById(id); //BUSCA O LIVRO PELO "id" E VERIFICA SE ELE ESTÁ PRESENTE
      if(!livro.isPresent()) //SE ELE NÃO ESTIVER PRESENTE
        return "redirect:/livro/list"; //REDIRECIONA O NAVEGADOR PARA "/livro/list"
      livro.get().setTitulo(titulo); //SE ELE ESTIVER PRESENTE ELE PEGA O LIVRO E ATUALIZA O NOME DO LIVRO
      livrosRepo.save(livro.get()); //SALVA O "livro" NO "livrosRepo"
      return "redirect:/livro/list"; //RETORNA O ENDEREÇO DO "/livro/list.jsp"
    } //FECHA A FUNÇÃO "saveUpdate()"


    @RequestMapping("/delete/{id}") //A ANOTAÇÃO DO REQUEST MAPPING ("@RequestMapping") TEM POR FINALIDADE FAZER O MAPEAMENTO, PORTANTO INDICA QUE O CONTROLADOR RECEBERÁ REQUISIÇÕES NO ENDEREÇO INDICADO ("/delete/{id}"). O {id} é REFERENTE AO ID DO LIVRO
    public String formDelete(Model model, @PathVariable int id){ //CRIA UMA FUNÇÃO PÚBLICA COM RETORNO String CHAMADA "formDelete()" COM OS PARÂMETRO MODEL "model" E INT "id" E QUE SERVE PARA VERIFICAR SE E POSSÍVEL DELETAR LIVRO REPOSITÓRIO
      Optional<Livro> livro=livrosRepo.findById(id); //BUSCA O LIVRO PELO "id" E VERIFICA SE ELE ESTÁ PRESENTE
      if (!livro.isPresent()) //SE ELE NÃO ESTIVER PRESENTE
        return "redirect:/livro/list"; //REDIRECIONA O NAVEGADOR PARA "/livro/list"
      model.addAttribute("livro", livro.get()); //ADICIONA O ATRIBUTO "livro" AO MODELO E PEGA O LIVRO
      return "/livro/delete.jsp"; //RETORNA O ENDEREÇO DO "/livro/delete.jsp"
    }//FECHA A FUNÇÃO "formDelete()"


    @RequestMapping(value="/delete",method=RequestMethod.POST) //A ANOTAÇÃO DO REQUEST MAPPING ("@RequestMapping") TEM POR FINALIDADE FAZER O MAPEAMENTO, PORTANTO INDICA QUE O CONTROLADOR RECEBERÁ REQUISIÇÕES DO TIPO POST NO ENDEREÇO INDICADO ("/delete").
    public String confirmDelete(@RequestParam("id")int id){ //CRIA UMA FUNÇÃO PÚBLICA COM RETORNO String CHAMADA "confirmDelete()" COM O PARÂMETRO INT "id" E QUE SERVE PARA DELETAR O LIVRO REPOSITÓRIO
      livrosRepo.deleteById(id); //DELETA O DO REPOSITÓRIO PELO ID DO LIVRO
      return "redirect:/livro/list"; //REDIRECIONA O NAVEGADOR PARA /livro/list
      }//FECHA A FUNÇÃO "confirmDelete()"

} //FECHA A CLASSE "LivroController"