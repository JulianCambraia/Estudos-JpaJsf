package br.com.julianfernando.jpa;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InsereEditoraComJPA {

	public static void main(String[] args) {
		
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		
		EntityManager manager = factory.createEntityManager();
		
		EditoraRepository repository = new EditoraRepository(manager);
		
		Editora editora1 = new Editora();
		
		Scanner entrada = new Scanner(System.in);
		System.out.println("Informe o nome da editora:");
		editora1.setNome(entrada.nextLine());
		
		System.out.println("Informe o email da editora:");
		editora1.setEmail(entrada.nextLine());
		
		repository.adiciona(editora1);
		
		manager.getTransaction().begin();
		manager.getTransaction().commit();
		
		manager.close();
		factory.close();
	}
}
