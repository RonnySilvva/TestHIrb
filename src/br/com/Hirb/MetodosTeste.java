package br.com.Hirb;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MetodosTeste {
	

//metodo com erro
	/*
	public void listar(){
		
		List<Pessoa> list=null;
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		try{
			
			session.beginTransaction();
			list = session.createQuery("select * from pessoa").list();
			session.getTransaction().commit();
			
			for(Pessoa pes:list){
				System.out.println("Nome: " + pes.getNome());
			}
	}catch(Exception e){
		System.out.println(e);
	}finally{
		session.close();
		factory.close();
	}}
	*/
	
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
	}