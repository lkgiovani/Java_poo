package br.ucb.poo.DAO;

import java.util.ArrayList;


interface ProdutoDAO {
	void registrarProduto();
	Object listaProduto(int id);
	ArrayList<?> listaProdutos();
}
