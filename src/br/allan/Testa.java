package br.allan;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Testa {

	public static void main(String[] args) {
		Usuario usuario = new Usuario("Allan",new BigDecimal(4000));
		Usuario usuario2 = new Usuario("Andrea",new BigDecimal(2500));
		Usuario usuario3 = new Usuario("Janaina",new BigDecimal(3600));
		ArrayList<Usuario> usuarios = new ArrayList<>();
		usuarios.add(usuario);
		usuarios.add(usuario2);
		usuarios.add(usuario3);
		for(Usuario user:usuarios){
			System.out.println(user);
		}
		Collections.sort(usuarios);
		System.out.println("---------------------------------------------------------------------------------------------------");
		for(Usuario user:usuarios){
			System.out.println(user);
		}
		System.out.println("---------------------------------------------------------------------------------------------------");
		Collections.reverse(usuarios);
		for(Usuario user:usuarios){
			System.out.println(user);
		}
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("teste");
		EntityManager manager = factory.createEntityManager();
		manager.getTransaction().begin();
		manager.persist(usuario);
		for(Usuario user:usuarios){
			System.out.println(user);			
			manager.persist(user);			
		}
		manager.getTransaction().commit();
		Usuario user2 = (Usuario)manager.createQuery("SELECT u FROM Usuario u WHERE u.nome='Allan'").getSingleResult();
		System.out.println("Usuario selecionado"+user2);
		manager.close();
		factory.close();
		
		
		
		
		

	}

}
