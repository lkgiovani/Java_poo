package br.ucb.poo.exec;

import java.util.ArrayList;
import java.util.Scanner;

import br.ucb.poo.bean.Movel;
import br.ucb.poo.bean.User;
import br.ucb.poo.bean.Casa;
import br.ucb.poo.DAO.UsuarioDAO;
import br.ucb.poo.DAO.CasaDAO;
import br.ucb.poo.DAO.MovelDAO;
import br.ucb.poo.utilit.Limpa_tela;

public class Executora {

	public static void main(String[] args) {
		int opcao, opcaoLogin, opcaoCategoria;
		int idLogado = 0 ;
		
		UsuarioDAO daoUser = new UsuarioDAO();
		MovelDAO daoMovel = new MovelDAO();
		CasaDAO daoCasa = new CasaDAO();
		
		
		
		
		
		
		
		Scanner ler = new Scanner (System.in);
		
		
		do {
			Limpa_tela.limpatela();
			System.out.print("==================================================\n"
							+"         	Sale House - HOME \n"
							+"==================================================\n"
							+ "LOGIN(1) - REGISTRO(2) - (999) ENCERRAR\n");
			System.out.print("--------------------------------------------------\n");
			System.out.print("(3) BUSCAR PRODUTO\n");
			System.out.print("--------------------------------------------------\n");
			System.out.print("Produtos: \n");
			
			ArrayList<Casa> casas = new ArrayList<>();
			casas = daoCasa.listaProdutos();
			for(Casa a : casas) {
				System.out.println("-" + a.getTitle());
			}
			
			ArrayList<Movel> moveis = new ArrayList<>();
			moveis = daoMovel.listaProdutos();
			for (Movel a : moveis) {
				System.out.println("-" + a.getTitle());
			}
			System.out.print("--------------------------------------------------\n");
			System.out.print("Categorias:\n");
			System.out.print("-Casas\n");
			System.out.print("-Moveis\n");
			System.out.print("--------------------------------------------------\n\n");
			System.out.print("--------------------------------------------------\n");
			System.out.print("Opçao: ");
			opcao = ler.nextInt();
			System.out.println("\n=============================================\n");
			
			switch (opcao) {
			case 1: 
					do {
						Limpa_tela.limpatela();	
						System.out.print("==================================================\n"
		            					+"         		Sale House - LOGIN \n"
		            					+"==================================================\n"
		            					+"Conforme a lista abaico escolha o perfil de Acesso: \n"
		            					+ "(1) Continuar com acesso Público\n"
		            					+ "(2) Anunciante\n"
		            					+ "(3) Super Admin\n"
		            					+ "Perfil :");
						opcaoLogin = ler.nextInt();
						System.out.print("==================================================\n");

						switch (opcaoLogin) {
							case 1:
								Limpa_tela.limpatela();	
								break;
							case 2:
								Limpa_tela.limpatela();	
								do {
									
									String loginConfirm, senhaConfirm;
									
									System.out.print("==================================================\n"
						        					+"         	Sale House - LOGIN \n"
						        					+"==================================================\n");
									
									System.out.print("E-mail: ");
									loginConfirm = ler.next();
									
									System.out.print("Senha: ");
									senhaConfirm = ler.next();
									
									User consulta = daoUser.usuarioExiste(loginConfirm, senhaConfirm); 
									
									if (consulta != null) {
										
										idLogado = consulta.getId();
										
									} else {
										System.out.print("=====================================\n"
														+ "	Senha ou E-mail ERRADO!!\n"
														+ "====================================\n");
									}
									
								}while (idLogado < 1);
								
								break;
							case 3:
								Limpa_tela.limpatela();	
								do {
									
									String loginConfirm, senhaConfirm;
									
									System.out.print("==================================================\n"
						        					+"         	Sale House - LOGIN - ADM \n"
						        					+"==================================================\n");
									
									System.out.print("User: ");
									loginConfirm = ler.next();
									
									System.out.print("Senha: ");
									senhaConfirm = ler.next();
									
									User consulta = daoUser.usuarioExiste(loginConfirm, senhaConfirm); 
									
									if (consulta != null) {
										
										idLogado = consulta.getId();
										
									} else {
										System.out.print("=====================================\n"
														+ "	Senha ou E-mail ERRADO!!\n"
														+ "====================================\n");								
									}
									
								}while (idLogado < 1 );
								
								break;
			
							default:
								Limpa_tela.limpatela();
								System.out.print("======================================\n");
				            	System.out.print("           Valor invalido ! \n");
				            	System.out.print("======================================\n");
								break;
						}
					}while (opcaoLogin != 1);
				break;
			
			case 2: 
				
				
				Limpa_tela.limpatela();
				System.out.print("======================================\n");
            	System.out.print("           Cadastra Anúncio! \n");
            	System.out.print("======================================\n");
            	
            	System.out.print("Você que anúnciar[1] ou se cadastral[2]:  ");
            	int escolher = ler.nextInt();
            	
            	switch (escolher) {
				
            	case 1: 
					if (idLogado >= 1) {
	            		Limpa_tela.limpatela();
	    				System.out.print("======================================\n");
	                	System.out.print("           Cadastra Anúncio! \n");
	                	System.out.print("======================================\n");
	                	int c_m = 0;
	                	
	                	System.out.print("Você que anúncuar uma casa[1] ou um movel[2]:  ");
	                	c_m = ler.nextInt();
	            		
	                	if (c_m == 1) {
						
	            		Casa casa = new Casa();
	            		
	        		
	        			casa.setIdUser(idLogado);
	        			
	        	       	System.out.print("Informe o Titulo: ");
	        	       	casa.setTitle(ler.nextLine());
	        	     	casa.setTitle(ler.nextLine());
	        	        
	        	        System.out.print("Informe o Preço: ");
	        	        casa.setPrice(ler.nextInt());
	        	        

	        	        System.out.print("Informe a descrição: ");
	        	        casa.setDescription(ler.nextLine());
	        	        casa.setDescription(ler.nextLine());
	        	        
	        	        System.out.print("Adicione a foto ->  ");
	        	        casa.setPhoto(ler.next());
	        	        
	        	        
	        	        System.out.print("Informe a quantitade de quartos: ");
	        	        casa.setManyBedroom(ler.nextInt());
	        	        
	        	        System.out.print("Informe a quantitade de suites: ");
	        	        casa.setManySuites(ler.nextInt());
	        	        
	        	        System.out.print("Informe a quantitade de banheiro: ");
	        	        casa.setManyBathrooms(ler.nextInt());
	        	        
	        	        System.out.print("Informe se a garagem [1]sim/[2]não: ");
	        	        casa.setManyGarage(ler.nextInt());
	        	        
	        	        daoCasa.registrarProduto(casa);
	        	        
	        	       
	    
	        	    
					} else if (c_m == 2) {
						Movel movelNovo = new Movel();
						
						movelNovo.setIdUser(idLogado);
						
				       	System.out.print("Informe o Titulo: ");
				       	movelNovo.setTitle(ler.nextLine());
				       	movelNovo.setTitle(ler.nextLine());
				       	
				        System.out.print("Informe o Preço: ");
				        movelNovo.setPrice(ler.nextInt()); 
				        
				        System.out.print("Informe a descrição: ");
				        movelNovo.setDescription(ler.nextLine());	
				        movelNovo.setDescription(ler.nextLine());
				        
				        System.out.print("Adicione a foto ->  ");
				        movelNovo.setPhoto(ler.next());
				        
				        System.out.print("Informe a categoria: ");
				        movelNovo.setCategory(ler.nextLine());
				        movelNovo.setCategory(ler.nextLine());
				        
				        daoMovel.registrarProduto(movelNovo);;
				        
					} else {
						System.out.print("======================================\n");
		            	System.out.print("           Opção Invalida ! \n");
		            	System.out.print("======================================\n");
					}
					
					
					
				} else {
					System.out.print("======================================\n");
	            	System.out.print("           Vocë não esta logado ! \n");
	            	System.out.print("======================================\n");
				}
					break;
					
				case 2:
					Limpa_tela.limpatela();
					System.out.print("======================================\n");
	            	System.out.print("           Cadastra Anunciante! \n");
	            	System.out.print("======================================\n");
					
	            	User user = new User();
	            	
	            	System.out.print("Informe o Nome: ");
	        		user.setNome(ler.next());
	        		
	        		System.out.print("Informe o Sobrenome: ");
	        		user.setSobrenome(ler.next());
	        		
	        		System.out.print("Informea a data de nascimento [??/??/????]: ");
	        		user.setDataNascimento(ler.next());
	        		
	        		System.out.print("Informe o E-mail: ");
	        		user.setEmail(ler.next());
	        		
	        		System.out.print("Informe o cpf ou cnpj: ");
	        		user.setCpf_cnpj(ler.next());
	        		
	        		System.out.print("Informe o telefone: ");
	        		user.setTelefone(ler.next());
	        		
	        		System.out.print("Informe o cep(apenas numeros): ");
	        		user.setCep(ler.nextInt());
	        		
	        		System.out.print("Informe o endereço: ");
	        		user.setEndereco(ler.nextLine());
	        		user.setEndereco(ler.nextLine());
	        		
	        		System.out.print("Informe a UF: ");
	        		user.setEstado(ler.next());
	        		
	        		System.out.print("Informe o Bairro: ");
	        		user.setBairro(ler.nextLine());
	        		user.setBairro(ler.nextLine());
	        		
	        		System.out.print("Informe a Senha: ");
	        		user.setSenha(ler.next());
	            	
	        		daoUser.cadastraUsuario(user);
	        		
	        		 User consulta = daoUser.usuarioExiste(user.getEmail(), user.getSenha()); 
	        		 
	        		 if (consulta != null) {
							
						idLogado = consulta.getId();
							
					}else {
						idLogado = 0;
					}
	        		
	        		 break;
				
				default:
            	
	            	Limpa_tela.limpatela();
					System.out.print("======================================\n");
	            	System.out.print("           Valor invalido ! \n");
	            	System.out.print("======================================\n");
	            	
	            	break;
            	}
            	
            	break;
			case 3: 
				do {
				Limpa_tela.limpatela();
				System.out.print("==================================================\n"
		    					+"         	Sale House - Busca\n"
		    					+"==================================================\n");
				System.out.println("Conforme a lista abaixo escolha a categoria:\n"
								  +"(1) Casas\n"
								  +"(2) Moveis\n"
								  +"(99) sair.\n");
			  	System.out.print("Categoria:  ");
				opcaoCategoria = ler.nextInt();
				
				switch (opcaoCategoria) {
					case 1:
						int escolhaCasa; 
						int sair;
						for (Casa a : casas ) {
							
							System.out.println("Titulo: " + a.getTitle() + " (" + a.getId() + "):" );
							
						}
						System.out.print("==================================================\n");
						
						System.out.print("Escolha a casa:  ");
						escolhaCasa = ler.nextInt();
						
						Casa casa = daoCasa.listaProduto(escolhaCasa);
						
						
						
						Limpa_tela.limpatela();
						System.out.print("==================================================\n");
						System.out.println("Titulo: " + casa.getTitle());
						System.out.println("Preço: " + casa.getPrice());
						System.out.println("Descrição: " + casa.getDescription());
						System.out.println("Foto: " + casa.getPhoto());
						System.out.println("Quartos: " + casa.getManyBathrooms());
						System.out.println("Suites: " + casa.getManySuites());
						System.out.println("Banheiros: " + casa.getManyBedroom());
						String garagem = (casa.getMavyGarage() != 1) ? "Não tem garagem" : "tem garagem";
						System.out.println("Garagem: " + garagem);
						System.out.print("==================================================\n");
						
						System.out.print("sair[1]:  ");
						sair = ler.nextInt();
						
						if (sair == 1) {
							Limpa_tela.limpatela();
							break;
						}
						
						
					case 2:
						int escolhamovel; 
						int sair2;

						for (Movel a : moveis) {
							System.out.println("Titulo: " + a.getTitle() + " (" + a.getId() + "):" );
							
						}
						System.out.print("==================================================\n");
						System.out.print("Escolha o movel:  ");
						escolhamovel = ler.nextInt();
						
			
			Movel movel = daoMovel.listaProduto(escolhamovel);
						
						
						Limpa_tela.limpatela();
						System.out.print("==================================================\n");
						System.out.println("Titulo: " + movel.getTitle());
						System.out.println("Preço: " + movel.getPrice());
						System.out.println("Descrição: " + movel.getDescription());
						System.out.println("Foto: " + movel.getPhoto());
						System.out.println("Categoria: " + movel.getCategory());
						System.out.print("==================================================\n");
						
						System.out.print("sair[1]:  ");
						sair2 = ler.nextInt();
						
						if (sair2 == 1) {
							Limpa_tela.limpatela();
							break;
						}
	
					default:
						Limpa_tela.limpatela();
						System.out.print("======================================\n");
		            	System.out.print("           Valor invalido ! \n");
		            	System.out.print("======================================\n");
						
		            	break;
					}
				
				} while (opcaoCategoria != 99);
			case 999: 
				
				break;
			
			default:
					Limpa_tela.limpatela();
					System.out.print("======================================\n");
	            	System.out.print("           Valor invalido ! \n");
	            	System.out.print("======================================\n");
            	break;
			}
		
	
		}	while (opcao != 999);
		
		
		ler.close();
		
	}

}