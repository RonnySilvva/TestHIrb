package br.com.Hirb;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MetodosTeste {
	
	public void adicionar(){
		
		Pessoa pessoa = new Pessoa();
		pessoa.setId(6);
		pessoa.setNome("Teste 6");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.save(pessoa);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void listarForm(){
		try{

			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			
				List<Pessoa> listPessoas = new ArrayList<>();	
				
				
				listPessoas = session.createQuery("from Pessoa").list();
				
				int tamanho = listPessoas.size();
				
				for(int i = 0; i<tamanho;i++){
					Pessoa pessoa = listPessoas.get(i);
					
					System.out.println(pessoa.getId()+" - "+ pessoa.getNome());
				}
				
				session.close();
				factory.close();
		}catch(Exception e){
			System.out.println(e);
				}

			}
	
	public void alterar(){
		Pessoa pessoa = new Pessoa();
		pessoa.setId(2);
		pessoa.setNome("Teste 123");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.update(pessoa);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	public void remover(){
		Pessoa pessoa = new Pessoa();
		pessoa.setId(2);
		pessoa.setNome("Teste 123");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		session.delete(pessoa);
		
		session.getTransaction().commit();
		session.close();
		
	}
	
	}