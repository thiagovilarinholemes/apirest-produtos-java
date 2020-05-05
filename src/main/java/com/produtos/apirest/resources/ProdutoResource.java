package com.produtos.apirest.resources;

import com.produtos.apirest.models.Produto;
import com.produtos.apirest.repository.ProdutoRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Define que o controller e uma API Rest
@RequestMapping(value = "/api") // Define um prefix de rota
@Api(value = "API REST Produtos")
@CrossOrigin("*") // Qualquer dominio pode acessar a api
public class ProdutoResource {

    @Autowired // Importa a classe ProdutoRepository
    ProdutoRepository produtoRepository;


    @GetMapping("/produtos") // Rota para listar todos os produtos, "/api/produtos" pelo metodo GET
    @ApiOperation(value = "Retorna todos os produtos cadastrados no banco de dados")
    public List<Produto> listProduto(){
        return produtoRepository.findAll(); // Retorna a lsita de produtos
    }

    @GetMapping("/produto/{id}") // Rota para listar o produto pelo id, "/api/produto/1" pelo metodo GET
    @ApiOperation(value="Retorna um produto unico pelo id")
    public Produto listProdutoId(@PathVariable(value = "id") long id){ // @PathVariable define que deve passar o id recebido na URI para o long id, o nome deve ser o mesmo
        return produtoRepository.findById(id); // Retorna a lsita de produtos
    }

    @PostMapping("/produto") // Rota para salvar o produto "/api/produto" pelo metodo POST
    @ApiOperation(value="Salva um produto")
    public Produto salvarProduto(@RequestBody Produto produto){ // @RequestBody recebe os dados via body
        return produtoRepository.save(produto); // salva os dados
    }

    @DeleteMapping("/produto") // Rota para deletar o produto "/api/produto" pelo metodo POST
    @ApiOperation(value="Deleta um produto")
    public void deletarProduto(@RequestBody Produto produto){ // @RequestBody recebe os dados via body
        produtoRepository.delete(produto); // salva os dados
    }

    @PutMapping("/produto") // Rota para atualizar o produto "/api/produto" pelo metodo POST
    @ApiOperation(value="Atualiza um produto")
    public Produto atualizarProduto(@RequestBody Produto produto){ // @RequestBody recebe os dados via body
        return produtoRepository.save(produto); // salva os dados
    }
}
