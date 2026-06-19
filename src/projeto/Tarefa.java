package projeto;

public class Tarefa {

	//Atributos da nossa tarefa
	private String titulo;
	private String descricao;
	private String status;
	
	//Metodo construtor da nossa classe
	public Tarefa(String titulo, String descricao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = "Pendente";
	}
	//Retorna ao titulo da tarefa
	public String getTitulo() {
		return titulo;		
	}
	//Retorna a descricao da tarefa
	public String getDescricao() {
		return descricao;
	}
	//Retorna ao status da tarefa
	public String getStatus() {
		return status;
	}
	//Altera o status da tarefa para concluido
	public void concluir() {
		this.status = "Concluída";
	}
	//Define como a tarefa será exibina na lista da tela
	@Override
	public String toString() {
		return titulo + " - " + status;
	}
}