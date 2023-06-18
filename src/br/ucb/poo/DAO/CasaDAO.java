package br.ucb.poo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import br.ucb.poo.bean.Casa;
import br.ucb.poo.factory.ConexaoFactory;

public class CasaDAO implements ProdutoDAO{
	ConexaoFactory conexao = new ConexaoFactory();
	Connection connection = conexao.conectar();
	
	public void registrarProduto(Casa produto) {
	
		String sql = "INSERT INTO casa (idUsuario, tittle, description, photo, price, manyBathrooms, manySuites, manyBedroom, manyGarage)"
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, produto.getIdUser());
			stmt.setString(2, produto.getTitle());
			stmt.setString(3, produto.getDescription());
			stmt.setString(4, produto.getPhoto());
			stmt.setInt(5, produto.getPrice());
			stmt.setInt(6, produto.getManyBathrooms());
			stmt.setInt(7, produto.getManySuites());
			stmt.setInt(8, produto.getManyBedroom());
			stmt.setInt(9, produto.getMavyGarage());
			
			
			stmt.execute();
			stmt.close();
		} catch (SQLException E) {
			E.printStackTrace();
		}
		
	};
	
	public ArrayList<Casa> listaProdutos(){
		
		String sql = "SELECT * FROM casa";
		
		ArrayList<Casa> casas = new ArrayList<>();
		try {
			Statement stmt =  connection.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				Casa casaLPS = new Casa();
				
				casaLPS.setId(rs.getInt("id"));
				casaLPS.setIdUser(rs.getInt("idUsuario"));;
				casaLPS.setTitle(rs.getString("tittle"));
				casaLPS.setDescription(rs.getString("description"));
				casaLPS.setPhoto(rs.getString("photo"));
				casaLPS.setPrice(rs.getInt("price"));
				casaLPS.setManyBathrooms(rs.getInt("manyBathrooms"));
				casaLPS.setManySuites(rs.getInt("manySuites"));
				casaLPS.setManyBedroom(rs.getInt("manyBedroom"));
				casaLPS.setManyGarage(rs.getInt("manyGarage"));
				casas.add(casaLPS);
			}
			
			rs.close();
			stmt.close();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return casas;
		
	};
	
	public Casa listaProduto(int id){
		Casa casa = new Casa();		
		String sql = "SELECT * FROM casa WHERE id = ?";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				casa.setId(rs.getInt("id"));
				casa.setIdUser(rs.getInt("idUsuario"));;
				casa.setTitle(rs.getString("tittle"));
				casa.setDescription(rs.getString("description"));
				casa.setPhoto(rs.getString("photo"));
				casa.setPrice(rs.getInt("price"));
				casa.setManyBathrooms(rs.getInt("manyBathrooms"));
				casa.setManySuites(rs.getInt("manySuites"));
				casa.setManyBedroom(rs.getInt("manyBedroom"));
				casa.setManyGarage(rs.getInt("manyGarage"));
				
			}else {
				System.out.println("Nâo tem usuario");
				
			}
		
			rs.close();
			stmt.close();
		}catch (SQLException E) {
			E.printStackTrace();
		}	
		return casa;
	}

	@Override
	public void registrarProduto() {
		// TODO Auto-generated method stub
		
	};
}