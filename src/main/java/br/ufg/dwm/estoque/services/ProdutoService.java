package br.ufg.dwm.estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.ufg.dwm.estoque.model.Produto;
import br.ufg.dwm.estoque.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    private static String URL_VENDA_API = "http://localhost:5005/api/produtosRecentementeCadastrados";

    @Autowired
    ProdutoRepository produtoRepository;

    public Produto salvarProduto(Produto produto){
        Produto produtoSalvo = produtoRepository.save(produto);
        this.enviarProdutoParaSistemaDeVendas(produtoSalvo);
        return produtoSalvo;
    }

    public Produto consultarProdutoPorId(Long id) {
        return produtoRepository.findOne(id);
    }

    public List<Produto> listarProdutos() {
        return (List<Produto>) produtoRepository.findAll();
    }

    public void enviarProdutoParaSistemaDeVendas(Produto produto) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(URL_VENDA_API, produto, Produto.class);
    }

}
