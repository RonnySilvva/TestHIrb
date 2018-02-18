package br.com.Hirb;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GravaPessoa {		
		public static void main(String[] args) {
			
			Pessoa pessoa = new Pessoa();
			pessoa.setId(2);
			pessoa.setNome("Teste 2");
			
			SessionFactory factory = new Configuration().configure().buildSessionFactory();
			Session session = factory.openSession();
			session.beginTransaction();
			
			session.save(pessoa);
			
			session.getTransaction().commit();
			session.close();
		}
		
	
	
}
