package br.com.julianfernando.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ListarEditorasComJPA {

	public static void main(String[] args) {
		
		// criar o factory e setar a PU
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("livraria-pu");
		
		// criar o manager a partir do factory para poder realizar operações no banco de dados
		EntityManager manager = factory.createEntityManager();
		
		EditoraRepository repository = new EditoraRepository(manager);
		
		// obtem a lista de objetos Editora
		List<Editora> listaDeEditoras = repository.buscaTodos();
		
		// percorre imprimindo o nome e email das Editoras
		for (Editora editora : listaDeEditoras) {
			System.out.println("Editora: " + editora.getNome() + " - " + editora.getEmail());
		}

		// fecha os objetos factory e manager
		manager.close();
		factory.close();
	}
}
