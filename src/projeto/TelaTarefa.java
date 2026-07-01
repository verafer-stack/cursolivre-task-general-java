package projeto;
 
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
 
//Classe responsável pela tela principal do sistema
//Estamos herdando o Jframe, ou seja, teremos uma janela grafica.
public class TelaTarefa extends JFrame{
	//Lista interna que armazena todas as tarefas cadastradas pelo usuário
	private ArrayList<Tarefa> tarefas = new ArrayList<>();
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
		// Titulo do formulario
		JLabel tituloFormulario = new JLabel("Nova tarefa");
		tituloFormulario.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tituloFormulario.setForeground(new Color(44, 62, 80));
		//Painel que agrupa os campos do formulario
		JPanel campos = new JPanel(new GridLayout(4, 1, 8, 8));
		campos.setBackground(Color.WHITE);
		//Label do compo de titulo
		JLabel labelTitulo = new JLabel("Título");
		labelTitulo.setFont(new Font("segoe UI", Font.BOLD, 14));
		//Campo para digitar o titulo
		campoTitulo = new JTextField();
		campoTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		campoTitulo.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(203,213,225)),
				BorderFactory.createEmptyBorder(8,10,8,10)));
		//Label do campo de descriçao
		JLabel labelDescricao = new JLabel("Descrição");
		labelDescricao.setFont(new Font("Segoe UI", Font.BOLD, 14));
		campoDescricao = new JTextArea();
		campoDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		campoDescricao.setLineWrap(true);
		campoDescricao.setWrapStyleWord(true);
		campoDescricao.setBorder(BorderFactory.createEmptyBorder(8,10,8,10));
		//Scroll para o campo descrição
		JScrollPane scrollDescricao = new JScrollPane(campoDescricao);
		scrollDescricao.setBorder(BorderFactory.createLineBorder(new Color(203,213,225)));
		//Adiciona os labels
		campos.add(labelTitulo);
		campos.add(campoTitulo);
		campos.add(labelDescricao);
		campos.add(scrollDescricao);
 
		//Botão para adicionar uma nova tarefa
		JButton botaoAdicionar = criarBotao("Adicionar tarefa", new Color(37,99,235));
		//adiciona titulo, campo e botão ao card de formulario
		cardFormulario.add(tituloFormulario, BorderLayout.NORTH);
		cardFormulario.add(campos, BorderLayout.CENTER);
		cardFormulario.add(botaoAdicionar, BorderLayout.SOUTH);
		//adiciona o card do formulario a esquerda da tela
		painelPrincipal.add(cardFormulario, BorderLayout.WEST);
		//cria o card na lista de tarefas
		JPanel cardLista = criarCard();
		cardLista.setLayout(new BorderLayout(10,10));
 
		//Titulo da área de tarefas cadastradas
		JLabel tituloLista = new JLabel("Tarefas cadastradas");
		tituloLista.setFont(new Font("Segoe UI", Font.BOLD, 20));
		tituloLista.setForeground(new Color(44,62,80));
		//Modelo que guarda os dados qie será exibida na JList
		modeloLista = new DefaultListModel<>();
		//Lista visual que exibirá as tarefas
		listaTarefa = new JList<>(modeloLista);
		//Define um renderer personalizado para exibir cada tarefa como um card
		listaTarefa.setCellRenderer(new TarefaCardRenderer());
		//Define uma altura fixa para cada tarefa exbida
		listaTarefa.setFixedCellHeight(75);
		//Permite selecionar apenas uma tarefa por vez
		listaTarefa.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		//Define a cor de fundo da lista
		listaTarefa.setBackground(Color.WHITE);
		//Scroll para a lista de tarefascadastradas
		JScrollPane scrollLista = new JScrollPane(listaTarefa);
		scrollLista.setBorder(BorderFactory.createLineBorder(new Color(226,232,240)));
		//Painel inferior, onde ficam os botões de ação na lista de tarefas
		JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		painelBotoes.setBackground(Color.WHITE);
		//botoes para concluir e remover uma tarefa cadastrada
		JButton botaoConcluir = criarBotao ("Concluir", new Color(22,163,74));
		JButton botaoRemover = criarBotao ("Remover", new Color(220,38,38));
		//Adiciona os boto~es no painel inferior
		painelBotoes.add(botaoConcluir);
		painelBotoes.add(botaoRemover);
		//Adiciona titulo, lista e botoes ao card da lista
		cardLista.add(tituloLista, BorderLayout.NORTH);
		cardLista.add(scrollLista, BorderLayout.CENTER);
		cardLista.add(painelBotoes, BorderLayout.SOUTH);
		//Adiciona o card da lista ao centro da tela
		painelPrincipal.add(cardLista);
		//adiciona o painel principal a nossa janela
		add(painelPrincipal);
		//Eventos para os botos de adicionar, concluir e remover tarefa
		botaoAdicionar.addActionListener(e -> adicionarTarefa());
		botaoConcluir.addActionListener(e -> adicionarTarefa());
		botaoRemover.addActionListener(e -> adicionarTarefa());
	}	
 
	 	//metodo responsavel por cirar um painel com aparencia de card
	private JPanel criarCard() {
		JPanel painel = new JPanel();
		painel.setBackground(Color.WHITE);
		painel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(new Color(226,232,240)),
				BorderFactory.createEmptyBorder(20,20,20,20)
				));
		painel.setPreferredSize(new Dimension(300,400));
		return painel;
	}
		//método responsavel por criar os botoes padronizados
		private JButton criarBotao(String texto, Color cor) {
			//cria o botao com base no texto recebido na criacao da nossa interface
			JButton botao = new JButton(texto);
			botao.setFont(new Font("Segoe UI", Font.BOLD, 14));//fonte do botão
			botao.setBackground(cor);//cor de fundo
			botao.setForeground(Color.WHITE);//cor do texto
			botao.setFocusPainted(false);//remove a borda de foco
			botao.setCursor(new Cursor(Cursor.HAND_CURSOR));//Define espaçamento interno do botão(também chamamos de padding)
			botao.setBorder(BorderFactory.createEmptyBorder(10,18,10,18));
			return botao;
	}
		//Método responsavel por adicionar uma nova tarefa
		private void adicionarTarefa() {
			//Captura o título e descricao digitado pelo usuário
			String titulo = campoTitulo.getText().trim();
			String descricao = campoDescricao.getText().trim();
			//Verifica se os campos estão vazios
			if (titulo.isEmpty() || descricao.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Preencha todos os campos");
				return;
	}
		//cria um novo objeto tarefa		
		Tarefa tarefa = new Tarefa(titulo, descricao);
		tarefas.add(tarefa);//adiciona a tarefa a lista interna
		modeloLista.addElement(tarefa);//adiciona a tarefa
		//Limpa os campos de titulo
		campoTitulo.setText("");
		campoDescricao.setText("");
	}
		private void concluirTarefa() {
			//pega a tarefa selecionada na lista visual
		Tarefa tarefaSelecionada = listaTarefa.getSelectedValue();
			//verifica se o usuario selecionou uma tarefa
		if(tarefaSelecionada == null) {
			JOptionPane.showMessageDialog(this, "Selecione uma tarefa");
		return;
	}
		tarefaSelecionada.concluir();//Altera o status da tarefa
		listaTarefa.repaint(); //Atualiza visualmente a lista
	}
		//metodo responsavel por remover uma tarefa
		private void removerTarefa() {
			//pega a tarefa seleciona na lista
		Tarefa tarefaSelecionada = listaTarefa.getSelectedValue();
		//verifica se p usuario selecionou uma tarefa
		if (tarefaSelecionada == null) {
			JOptionPane.showMessageDialog(this, "Selecione uma tarefa");
		return;
}
		tarefas.remove(tarefaSelecionada);//remove da lista interna
		modeloLista.removeElement(tarefaSelecionada);//remove da lista visual
}
		//Classe interna para fazer a renderização do card de tarefa
		private class TarefaCardRenderer extends JPanel implements ListCellRenderer<Tarefa>{
		private JLabel labelTitulo;//exibe o titulo
		private JLabel labelDescricao;//exibe a descricao
		private JLabel labelStatus;//exibe o status
		//construtor do renderer
	public TarefaCardRenderer() {
		setLayout(new BorderLayout(8,5));
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 8, 0, Color.WHITE),
				BorderFactory.createEmptyBorder(10,12,10,12)
				));//define a borda e o espaçamento
		//cria e estiliza a label do titulo
		labelTitulo = new JLabel();
		labelTitulo.setFont(new Font("Segoe UI", Font.BOLD, 15));
		labelTitulo.setForeground(new Color(30,41,59));
		//cria e estiliza a label de descricao
		labelDescricao = new JLabel();
		labelDescricao.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		labelDescricao.setForeground(new Color(100,116,139));
		labelStatus = new JLabel(); //estiliza o status
		labelStatus.setFont(new Font("Segoe UI", Font.BOLD, 12));
		//Organiza o titulo e a descricao em 2 linhas e 1 coluna
		JPanel painelTexto = new JPanel(new GridLayout(2,1));
		painelTexto.setOpaque(false); //deixa o painel transparente
		painelTexto.add(labelTitulo);//adiciona o titulo
		painelTexto.add(labelDescricao);//adiciona descricao
	//adiciona o painel no centro do card
		add(painelTexto, BorderLayout.CENTER);
		add(labelStatus, BorderLayout.EAST);
		// Método para recriar a listagem
	}
        @Override
        public Component getListCellRendererComponent(
                JList<? extends Tarefa> list,
                Tarefa tarefa,
                int index,
                boolean isSelected,
                boolean cellHasFocus
        ) {
 
            // Define o título que será exibido no card
            labelTitulo.setText(tarefa.getTitulo());
 
            // Define a descrição que será exibida no card
            labelDescricao.setText(tarefa.getDescricao());
 
            // Define o status que será exibido no card
            labelStatus.setText(tarefa.getStatus());
 
            // Se a tarefa estiver concluída, o status fica verde
            if (tarefa.getStatus().equals("Concluída")) {
                labelStatus.setForeground(new Color(22, 163, 74));
            } else {
                // Caso contrário, o status fica laranja
                labelStatus.setForeground(new Color(234, 88, 12));
            }
 
            // Se o card estiver selecionado, muda a cor do fundo
            if (isSelected) {
                setBackground(new Color(219, 234, 254));
            } else {
                // Caso contrário, usa um fundo claro
                setBackground(new Color(248, 250, 252));
            }
 
            // Retorna o próprio painel personalizado para ser exibido na lista
            return this;
        }	
	}

} 
