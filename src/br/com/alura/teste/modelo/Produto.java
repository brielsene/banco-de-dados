package br.com.alura.teste.modelo;

public class Produto {
	private int Id;
	private String nome, descricao;
	
	
	public Produto(String nome, String descricao) {
		this.nome = nome;
		this.descricao = descricao;
		
	}
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	@Override
	public String toString() {
		return "Produto [Id=" + Id + ", nome=" + nome + ", descricao=" + descricao + "]";
	}
	
	
	
	

}
