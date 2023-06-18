package br.ucb.poo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ucb.poo.bean.Movel;
import br.ucb.poo.factory.ConexaoFactory;

public class MovelDAO  implements ProdutoDAO{
	ConexaoFactory conexao = new ConexaoFactory();
	Connection connection = conexao.conectar();
	
	public void registrarProduto(Movel produto) {
		
		String sql = "INSERT INTO movel (idUsuario, tittle, description, photo, price, category)"
				+ "VALUES(?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, produto.getIdUser());
			stmt.setString(2, produto.getTitle());
			stmt.setString(3, produto.getDescription());
			stmt.setString(4, produto.getPhoto());
			stmt.setInt(5, produto.getPrice());
			stmt.setString(6, produto.getCategory());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException E) {
			E.printStackTrace();
		}
		
	};
	
	public ArrayList<Movel> listaProdutos(){
		
		String sql = "SELECT * FROM movel";
		
		ArrayList<Movel> moveis = new ArrayList<>();
		try {
			Statement stmt =  connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Movel movelLPS = new Movel();
				movelLPS.setId(rs.getInt("id"));
				movelLPS.setIdUser(rs.getInt("idUsuario"));;
				movelLPS.setTitle(rs.getString("tittle"));
				movelLPS.setDescription(rs.getString("description"));
				movelLPS.setPhoto(rs.getString("photo"));
				movelLPS.setPrice(rs.getInt("price"));
				movelLPS.setCategory(rs.getString("category"));
				moveis.add(movelLPS);
			}
			
			rs.close();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return moveis;
		
	};
	
	public Movel listaProduto(int id){
		Movel movel = new Movel();		
		String sql = "SELECT * FROM movel WHERE id = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				movel.setId(rs.getInt("id"));
				movel.setIdUser(rs.getInt("idUsuario"));;
				movel.setTitle(rs.getString("tittle"));
				movel.setDescription(rs.getString("description"));
				movel.setPhoto(rs.getString("photo"));
				movel.setPrice(rs.getInt("price"));
				movel.setCategory(rs.getString("category"));
				
				
			}else {
				System.out.println("Nâo tem usuario");
				
			}
		
			rs.close();
			stmt.close();
		} catch (SQLException E) {
			E.printStackTrace();
		}
		
		
		return movel;
	}

	@Override
	public void registrarProduto() {
		// TODO Auto-generated method stub
		
	};
}
