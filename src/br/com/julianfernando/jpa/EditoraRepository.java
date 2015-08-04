package br.com.julianfernando.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class EditoraRepository {
	
	// Define um manager para realizar operações sobre os objetos editora no SGBD
	private EntityManager manager;

	public EditoraRepository(EntityManager manager) {
		super();
		this.manager = manager;
	}
	
	// persiste um objeto editora na memória
	public void adiciona(Editora editora) {
		this.manager.persist(editora);
	}

	// retorna um objeto editora 
	public Editora busca(Long id) {
		return this.manager.find(Editora.class, id);
	}
	// retorna uma coleção de objetos editora
	public List<Editora> buscaTodos() {
		Query query = this.manager.createQuery("SELECT e FROM Editora e");
		List<Editora> editoras = query.getResultList();
		return editoras;
	}
}
