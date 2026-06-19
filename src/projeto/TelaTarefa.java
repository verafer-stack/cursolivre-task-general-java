package projeto;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//Classe responsável pela tela principal do sistema
//Estamos herdando o Jframe, ou seja, teremos uma janela grafica.
public class TelaTarefa extends JFrame{
	
	//Lista interna que armazena todas as tarefas cadastradas pelo usuário
	private ArrayList<Tarefa> tarefa = new ArrayList<>();
	
	//Campo onde o usuario digitará o titulo da tarefa.
	private JTextField campoTitulo;
	
	//Campo onde o usuario digitará a descrição da tarefa.
	private JTextArea campoDescricao;
	
	//Modelo responsavél por armazenar os dados exibidos na lista visual
	private DefaultListModel<Tarefa> modeloLista;
	
	//Lista visual que exibe as tarefas cadastradas na tela
	private JList<Tarefa> listaTarefa;
	
	//Construtor da nossa interface
	public TelaTarefa() {
		
		//Define o titulo da janela
		setTitle("Gerenciador de tarefas");
		
		// Define o tamanho da janela (largura x altura)
		setSize(850, 550);
		
		// Encerra o programa ao clicar no botão de fechar interface
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Centraliza a janela na tela
		setLocationRelativeTo(null);
	
		//Impede o usuário redimensionar a janela
		setResizable(false);

		//Chama o metodo responsável por montar a interface gráfica
		criarInterface();
		
		//Deixará nossa janela visivel
		setVisible(true);
	}
	
	//Método responsável por cirar e organizar todos os componentes visuais	
	private void criarInterface() {
		
		//Painel principal da nossa tela
		JPanel painelPrincipal = new JPanel(new BorderLayout(20, 20));
		
		//Define o espaçamento interno do painel principal
		painelPrincipal.setBorder(BorderFactory.createEmptyBorder(25,25,25,25));
		
		//Define a cor de fundo da aplicação
		painelPrincipal.setBackground(new Color(236, 240, 243));
		
		//Titulo principal da aplicação 
		JLabel titulo = new JLabel("Gerenciador de Tarefas");
		titulo.setFont(new Font("segoe UI", Font.BOLD, 30));
		titulo.setForeground(new Color(44,62,80));
		
		//Subtítulo principal da aplicação
		JLabel subtitulo = new JLabel("Organize suas tarefas de forma simples e " + "prática");
		subtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		subtitulo.setForeground(new Color(100,116,139));
		
		//Painel superior para agrupar título e subtítulo
		JPanel painelTopo = new JPanel(new GridLayout(2,1));
		painelTopo.setBackground(new Color(236, 240, 243));
		painelTopo.add(titulo);
		painelTopo.add(subtitulo);
		
		//Adiciona o painel superior no topo da tela
		painelPrincipal.add(painelTopo, BorderLayout.NORTH);
		
		//Cria o card/formulário para o cadastro de tarefas
		JPanel cardFormulario = criarCard();
		cardFormulario.setLayout(new BorderLayout(10,10));
	
		//Paramos aqui.
	
	}
	private JPanel criarCard()	{
		return;
		}
		
}