package br.ufg.dwm.estoque.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ufg.dwm.estoque.model.Estoque;
import br.ufg.dwm.estoque.model.ItemEstoque;
import br.ufg.dwm.estoque.model.Produto;
import br.ufg.dwm.estoque.repositories.ItemEstoqueRepository;

@Service
public class ItemEstoqueService {

    @Autowired
    private ItemEstoqueRepository itemEstoqueRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private EstoqueService estoqueService;

    public ItemEstoque salvarItemEstoque(ItemEstoque item){
        Produto produto = produtoService.consultarProdutoPorId(item.getProduto().getId());
        Estoque estoque = estoqueService.consultarEstoquePorId(item.getEstoque().getId());

        ItemEstoque itemEstoque = new ItemEstoque();
        itemEstoque.setEstoque(estoque);
        itemEstoque.setProduto(produto);
        itemEstoque.setQuantidade(item.getQuantidade());
        itemEstoque.setData(item.getData());

        return itemEstoqueRepository.save(itemEstoque);
    }

    public List<ItemEstoque> listarItensEstoque(){
        return (List<ItemEstoque>) itemEstoqueRepository.findAll();
    }

	public ItemEstoque consultarItemVoPorId(Long id) {
		return itemEstoqueRepository.findOne(id);
	}

}
