package view;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.AlunosController;
import controller.ConsultaCorntoller;
import controller.ControllerSubGP;
import controller.CosultaOrientacao;
import controller.GruposController;
import controller.OrientacaoController;

public class Tela extends JFrame {

	private static final long serialVersionUID = -9160693830683067583L;
	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldRa;
	private JTextField textFieldNOMEGP;
	private JTextField textFieldTEMAGP;
	private JTextField textFieldAREA;
	private JTextField textFieldSUBAREA;
	private JTextField textFieldDATA;
	private JTextField textFieldCOD;
	private JTextField textFieldCodgpCp;
	private JTextField textFieldSubarea;
	private JTextField textFieldCodOrientacao;
	private JTextField textFieldTituloOrientacao;
	private JTextField textFieldDataOrientacaoOrientacao;
	private JTextField textFieldCoDGRUPOOrientacao;
	private JTextField textFieldCodigoOrientacao;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("rawtypes")
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 790, 510);
		getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(10, 0, 727, 439);
		getContentPane().add(tabbedPane);

		JPanel CadstrarAlunos = new JPanel();
		tabbedPane.addTab("Aluno", null, CadstrarAlunos, "Cadastro de alunos");
		CadstrarAlunos.setLayout(null);

		JLabel lblNome = new JLabel("Nome: ");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNome.setBounds(10, 72, 74, 14);
		CadstrarAlunos.add(lblNome);

		JLabel lblRa = new JLabel("RA:");
		lblRa.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRa.setBounds(327, 72, 46, 14);
		CadstrarAlunos.add(lblRa);

		JButton btnlimpar = new JButton("Limpar");
		btnlimpar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnlimpar.setBounds(80, 166, 101, 23);
		CadstrarAlunos.add(btnlimpar);
		btnlimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Código para limpar ou redefinir os valores aqui
				// Exemplo: Limpar campos de texto
				textFieldNome.setText("");
				textFieldRa.setText("");
			}
		});


		JButton btncadastrar = new JButton("Cadastrar");
		btncadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btncadastrar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btncadastrar.setBounds(287, 166, 122, 23);
		CadstrarAlunos.add(btncadastrar);

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textFieldNome.setBounds(94, 71, 160, 20);
		CadstrarAlunos.add(textFieldNome);
		textFieldNome.setColumns(10);

		textFieldRa = new JTextField();
		textFieldRa.setBounds(383, 71, 171, 20);
		CadstrarAlunos.add(textFieldRa);
		textFieldRa.setColumns(10);

		JLabel lblCadastrarAlunos = new JLabel("Cadastrar Alunos");
		lblCadastrarAlunos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCadastrarAlunos.setBounds(213, 26, 276, 14);
		CadstrarAlunos.add(lblCadastrarAlunos);
		/*-------------- cadastro alunos -------------*/

		JPanel ConsultarGP = new JPanel();
		tabbedPane.addTab("Consultar GP", null, ConsultarGP, "Consultar Grupos");
		ConsultarGP.setLayout(null);

		textFieldCodgpCp = new JTextField();
		textFieldCodgpCp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCodgpCp.setBounds(195, 111, 187, 20);
		ConsultarGP.add(textFieldCodgpCp);
		textFieldCodgpCp.setColumns(10);

		JLabel lblCodigoGP = new JLabel("Código do Grupo: ");
		lblCodigoGP.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCodigoGP.setBounds(23, 112, 152, 19);
		ConsultarGP.add(lblCodigoGP);

		JButton btnPesquisar = new JButton("Pesquisar");
		btnPesquisar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPesquisar.setBounds(418, 110, 134, 23);
		ConsultarGP.add(btnPesquisar);

		JLabel lblConsultargp = new JLabel("Consultar Grupo: ");
		lblConsultargp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultargp.setBounds(230, 41, 152, 19);
		ConsultarGP.add(lblConsultargp);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(23, 164, 689, 2);
		ConsultarGP.add(separator_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(23, 164, 689, 236);
		ConsultarGP.add(scrollPane_2);

		JTextArea textAreaCG = new JTextArea();
		scrollPane_2.setViewportView(textAreaCG);

		JPanel ConsultarSubarea = new JPanel();
		ConsultarSubarea.setLayout(null);
		tabbedPane.addTab("Subarea", null, ConsultarSubarea, "Consultar Subarea");

		textFieldSubarea = new JTextField();
		textFieldSubarea.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldSubarea.setColumns(10);
		textFieldSubarea.setBounds(195, 111, 187, 20);
		ConsultarSubarea.add(textFieldSubarea);

		JLabel lblCdigoDo = new JLabel("Subarea : ");
		lblCdigoDo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigoDo.setBounds(23, 112, 152, 19);
		ConsultarSubarea.add(lblCdigoDo);

		JButton btnPesquisarSUB = new JButton("Pesquisar");
		btnPesquisarSUB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnPesquisarSUB.setBounds(418, 110, 134, 23);
		ConsultarSubarea.add(btnPesquisarSUB);

		JLabel lblConsultarSubarea = new JLabel("Consultar Subarea: ");
		lblConsultarSubarea.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultarSubarea.setBounds(230, 41, 152, 19);
		ConsultarSubarea.add(lblConsultarSubarea);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(23, 177, 689, 2);
		ConsultarSubarea.add(separator_1);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(23, 190, 689, 210);
		ConsultarSubarea.add(scrollPane_1);

		JTextArea textAreaCS = new JTextArea();
		scrollPane_1.setViewportView(textAreaCS);

		JPanel InserirOrientação = new JPanel();
		InserirOrientação.setLayout(null);
		tabbedPane.addTab("Orientação", null, InserirOrientação, "Inserir Orientação");

		JLabel lblCodigoorientao = new JLabel("Codigo Orientação: ");
		lblCodigoorientao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigoorientao.setBounds(10, 84, 153, 14);
		InserirOrientação.add(lblCodigoorientao);

		JLabel lblTituloDeOrientao = new JLabel("Titulo de Orientação:");
		lblTituloDeOrientao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTituloDeOrientao.setBounds(23, 145, 153, 29);
		InserirOrientação.add(lblTituloDeOrientao);

		JLabel lblDataDaOrientao = new JLabel("Data da Orientação:");
		lblDataDaOrientao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDaOrientao.setBounds(388, 152, 142, 14);
		InserirOrientação.add(lblDataDaOrientao);

		textFieldCodOrientacao = new JTextField();
		textFieldCodOrientacao.setColumns(10);
		textFieldCodOrientacao.setBounds(165, 83, 181, 20);
		InserirOrientação.add(textFieldCodOrientacao);

		textFieldTituloOrientacao = new JTextField();
		textFieldTituloOrientacao.setColumns(10);
		textFieldTituloOrientacao.setBounds(190, 151, 167, 20);
		InserirOrientação.add(textFieldTituloOrientacao);

		textFieldDataOrientacaoOrientacao = new JTextField();
		textFieldDataOrientacaoOrientacao.setColumns(10);
		textFieldDataOrientacaoOrientacao.setBounds(552, 151, 160, 20);
		InserirOrientação.add(textFieldDataOrientacaoOrientacao);

		JButton btnCadastrarOrientacao = new JButton("Cadastrar");
		btnCadastrarOrientacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCadastrarOrientacao.setBounds(131, 385, 125, 23);
		InserirOrientação.add(btnCadastrarOrientacao);

		JButton btnCancelar_1 = new JButton("Cancelar");
		btnCancelar_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar_1.setBounds(331, 385, 89, 23);
		InserirOrientação.add(btnCancelar_1);

		JLabel lblInserirOrientao = new JLabel("Inserir Orientação");
		lblInserirOrientao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblInserirOrientao.setBounds(261, 11, 198, 19);
		InserirOrientação.add(lblInserirOrientao);

		JLabel lblCodigoDoGrupo = new JLabel("Codigo do Grupo:  ");
		lblCodigoDoGrupo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodigoDoGrupo.setBounds(376, 83, 139, 17);
		InserirOrientação.add(lblCodigoDoGrupo);

		textFieldCoDGRUPOOrientacao = new JTextField();
		textFieldCoDGRUPOOrientacao.setColumns(10);
		textFieldCoDGRUPOOrientacao.setBounds(531, 83, 181, 20);
		InserirOrientação.add(textFieldCoDGRUPOOrientacao);

		JLabel lblDescrioDaOrientao = new JLabel("Descrição da Orientação: ");
		lblDescrioDaOrientao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDescrioDaOrientao.setBounds(10, 236, 198, 29);
		InserirOrientação.add(lblDescrioDaOrientao);

		JScrollPane scrollPaneDescricaoOrientacao = new JScrollPane();
		scrollPaneDescricaoOrientacao.setBounds(202, 240, 494, 128);
		InserirOrientação.add(scrollPaneDescricaoOrientacao);

		JTextArea textArea = new JTextArea();
		scrollPaneDescricaoOrientacao.setViewportView(textArea);
		textArea.setBackground(new Color(255, 255, 255));
		JPanel InserirGrupos = new JPanel();
		tabbedPane.addTab("InserirGrupos", null, InserirGrupos, "Cadastro de Grupos");
		InserirGrupos.setLayout(null);

		JLabel lblNomeGrupo = new JLabel("Nome: ");
		lblNomeGrupo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNomeGrupo.setBounds(10, 33, 74, 14);
		InserirGrupos.add(lblNomeGrupo);

		JLabel lblTemaGP = new JLabel("Tema do Grupo: ");
		lblTemaGP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTemaGP.setBounds(348, 47, 123, 19);
		InserirGrupos.add(lblTemaGP);

		JLabel lblAreaDoConhecimento = new JLabel("Area do conhecimento ");
		lblAreaDoConhecimento.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAreaDoConhecimento.setBounds(10, 80, 197, 14);
		InserirGrupos.add(lblAreaDoConhecimento);

		JLabel lblSubara = new JLabel("Subárea ");
		lblSubara.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSubara.setBounds(400, 99, 75, 14);
		InserirGrupos.add(lblSubara);

		JLabel lblDataDaFormao = new JLabel("Data da Formação: ");
		lblDataDaFormao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDataDaFormao.setBounds(10, 138, 139, 14);
		InserirGrupos.add(lblDataDaFormao);

		JLabel lblRaGP = new JLabel("RA: ");
		lblRaGP.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRaGP.setBounds(10, 221, 139, 14);
		InserirGrupos.add(lblRaGP);

		JLabel lblCodGupo = new JLabel("CodigoGP: ");
		lblCodGupo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCodGupo.setBounds(335, 138, 139, 17);
		InserirGrupos.add(lblCodGupo);

		textFieldNOMEGP = new JTextField();
		textFieldNOMEGP.setColumns(10);
		textFieldNOMEGP.setBounds(82, 32, 181, 20);
		InserirGrupos.add(textFieldNOMEGP);

		textFieldTEMAGP = new JTextField();
		textFieldTEMAGP.setColumns(10);
		textFieldTEMAGP.setBounds(518, 48, 167, 20);
		InserirGrupos.add(textFieldTEMAGP);

		textFieldAREA = new JTextField();
		textFieldAREA.setColumns(10);
		textFieldAREA.setBounds(184, 77, 167, 20);
		InserirGrupos.add(textFieldAREA);

		textFieldSUBAREA = new JTextField();
		textFieldSUBAREA.setColumns(10);
		textFieldSUBAREA.setBounds(485, 98, 160, 20);
		InserirGrupos.add(textFieldSUBAREA);

		textFieldDATA = new JTextField();
		textFieldDATA.setBounds(159, 137, 123, 20);
		InserirGrupos.add(textFieldDATA);
		textFieldDATA.setColumns(10);

		textFieldCOD = new JTextField();
		textFieldCOD.setColumns(10);
		textFieldCOD.setBounds(460, 137, 139, 20);
		InserirGrupos.add(textFieldCOD);

		JButton btnCodGerar = new JButton("Cadastrar");
		btnCodGerar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCodGerar.setBounds(105, 363, 118, 23);
		InserirGrupos.add(btnCodGerar);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancelar.setBounds(347, 363, 89, 23);
		InserirGrupos.add(btnCancelar);

		JLabel lblTitulo = new JLabel("Cadastro de Grupos");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTitulo.setBounds(261, 11, 198, 19);
		InserirGrupos.add(lblTitulo);
		btnCodGerar.addActionListener(Gcont);

		ControllerSubGP CsCont= new ControllerSubGP (textFieldSubarea,  textAreaCS,  textFieldNOMEGP, textFieldCodgpCp);

		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(82, 220, 171, 20);
		InserirGrupos.add(textField);

		JLabel lblRaGP_1 = new JLabel("RA: ");
		lblRaGP_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRaGP_1.setBounds(10, 262, 139, 14);
		InserirGrupos.add(lblRaGP_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(82, 261, 171, 20);
		InserirGrupos.add(textField_1);

		JLabel lblRaGP_1_1 = new JLabel("RA: ");
		lblRaGP_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRaGP_1_1.setBounds(10, 308, 139, 14);
		InserirGrupos.add(lblRaGP_1_1);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(82, 307, 171, 20);
		InserirGrupos.add(textField_2);

		JLabel lblRaGP_3 = new JLabel("RA: ");
		lblRaGP_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRaGP_3.setBounds(10, 191, 139, 14);
		InserirGrupos.add(lblRaGP_3);

		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(82, 190, 171, 20);
		InserirGrupos.add(textField_4);

		JPanel ConsultarOrientação = new JPanel();
		ConsultarOrientação.setLayout(null);
		tabbedPane.addTab("Consultar Orientação", null, ConsultarOrientação, "Consultar Orientação");

		textFieldCodigoOrientacao = new JTextField();
		textFieldCodigoOrientacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textFieldCodigoOrientacao.setColumns(10);
		textFieldCodigoOrientacao.setBounds(185, 97, 187, 20);
		ConsultarOrientação.add(textFieldCodigoOrientacao);

		JLabel lblCdigoDaOrientao = new JLabel("Código da Orientação ");
		lblCdigoDaOrientao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCdigoDaOrientao.setBounds(23, 98, 152, 19);
		ConsultarOrientação.add(lblCdigoDaOrientao);

		JButton btnConsultarOrientacao = new JButton("Pesquisar");
		btnConsultarOrientacao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConsultarOrientacao.setBounds(418, 96, 134, 23);
		ConsultarOrientação.add(btnConsultarOrientacao);

		JLabel lblConsultargp_1 = new JLabel("Consultar Orientação: ");
		lblConsultargp_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblConsultargp_1.setBounds(230, 41, 152, 19);
		ConsultarOrientação.add(lblConsultargp_1);

		JSeparator separator = new JSeparator();
		separator.setBounds(23, 174, 663, 28);
		ConsultarOrientação.add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 174, 712, 226);
		ConsultarOrientação.add(scrollPane);


		JTextArea textAreaConsultaOrientacao = new JTextArea();
		scrollPane.setViewportView(textAreaConsultaOrientacao);

		CosultaOrientacao CCont= new CosultaOrientacao (textFieldCodigoOrientacao, textAreaConsultaOrientacao, textFieldCoDGRUPOOrientacao, textFieldTituloOrientacao,  textFieldDataOrientacaoOrientacao, textArea);
		btnConsultarOrientacao.addActionListener(CCont);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		AlunosController Vcont= new AlunosController(textFieldNome, textFieldRa);
		btncadastrar.addActionListener(Vcont);
		btnPesquisar.addActionListener(Consult);
		btnPesquisarSUB.addActionListener(CsCont);

		OrientacaoController Ocontroller= new OrientacaoController(textFieldCodOrientacao, textFieldCoDGRUPOOrientacao, textFieldTituloOrientacao, textFieldDataOrientacaoOrientacao, textArea);
		btnCadastrarOrientacao.addActionListener((ActionListener) Ocontroller);






	}
}
