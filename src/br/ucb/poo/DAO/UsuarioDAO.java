package br.ucb.poo.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.ucb.poo.bean.User;
import br.ucb.poo.factory.ConexaoFactory;

public class UsuarioDAO {

	ConexaoFactory conexao = new ConexaoFactory();
	Connection connection = conexao.conectar();
	
	public void cadastraUsuario(User usuario) {
		
		String sql = "INSERT INTO usuario (nome, sobrenome, dataNascimento, email, cpf_cnpj, telefone, cep, endereco, estado, bairro, senha) "
				+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getSobrenome());
			stmt.setString(3, usuario.getDataNascimento());
			stmt.setString(4, usuario.getEmail());
			stmt.setString(5, usuario.getCpf_cnpj());
			stmt.setString(6, usuario.getTelefone());
			stmt.setInt(7, usuario.getCep());
			stmt.setString(8, usuario.getEndereco());
			stmt.setString(9, usuario.getEstado());
			stmt.setString(10, usuario.getBairro());
			stmt.setString(11, usuario.getSenha());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException E) {
			E.printStackTrace();
		}
	};
	
	public User usuarioExiste(String email, String senha){
		User usuario = new User();
		
		String sql = "SELECT * FROM usuario WHERE email = ? AND senha = ?";
		
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				
				usuario.setId(rs.getInt("id"));
				usuario.setNome(rs.getString("nome"));
				usuario.setSobrenome(rs.getString("sobrenome"));
				usuario.setDataNascimento(rs.getString("dataNascimento"));
				usuario.setEmail(rs.getString("email"));
				usuario.setCpf_cnpj(rs.getString("cpf_cnpj"));
				usuario.setTelefone(rs.getString("telefone"));
				usuario.setCep(rs.getInt("cep"));
				usuario.setEndereco(rs.getString("endereco"));
				usuario.setEstado(rs.getString("estado"));
				usuario.setBairro(rs.getString("bairro"));
				usuario.setSenha(rs.getString("senha"));
				
			}else {
				System.out.println("Nâo tem usuario");
				
			}
		
			rs.close();
			stmt.close();
		} catch (SQLException E) {
			E.printStackTrace();
		}
		
		return usuario;
	};
	
	
}
