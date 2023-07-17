package com.springboot.application.controllers;

import java.util.List;

import com.springboot.application.models.Produto;
import com.springboot.application.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProdutoController {
	//Injeta uma porção na classe ProdutoController para manipulação do banco de dados
	@Autowired
	public ProdutoController(ProdutoRepository produtoRepository) {
		this.produtoRepository = produtoRepository;
	}


	private ProdutoRepository produtoRepository;


	@GetMapping("/index")
	public String index(Model model) {
		return "index";
	}

	@GetMapping("/login")
	public String getLogin() {

		return "login";
	}
	@PostMapping("/login")
	public String index(){
		return "index";
	}
	//Configura parâmetros na página listarProdutos e exibe a mesma
	@GetMapping("/listar")
	public String listarProduto(Model model) {
		List<Produto> lista = produtoRepository.findAll();
		model.addAttribute("listaProdutos",lista);
		return "listarProdutos";
	}

	//Configura o objeto que receberá os atributos do front end
	@GetMapping("/cadastrar")
	public String cadastrarProduto(Model model) {
		model.addAttribute("produto", new Produto());
		return "cadastrarProduto";
	}
	//Carrega os atributos do front no objeto produto, e o salvo no banco
	@PostMapping("/cadastrar")
	public String addProduto(@ModelAttribute Produto produto, Model model) {
		produtoRepository.save(produto);
		listarProduto(model);
		return "listarProdutos";
	}
	//Deleta o registro passado como parâmetro do banco de dados
	@GetMapping("/excluir/{id}")
	public String excluirProduto(@PathVariable Long id, Model model) {
		produtoRepository.deleteById(id);
		listarProduto(model);
		return "listarProdutos";
	}
	//Altera um registro no banco de dados
	@GetMapping("/alterar/{id}")
	public String alterarProduto(@PathVariable Long id, Model model) {
		Produto p = produtoRepository.findById(id).get();
		model.addAttribute("produto",p);
		return"alterarProduto";
	}
	
	@PostMapping("/alterar")
	public String alteraProduto(@ModelAttribute Produto p,Model model) {
		//verificar se não há algum campo nulo ou que não foi alterado
		produtoRepository.save(p);
		listarProduto(model);
		return "listarProdutos";
	}

}
