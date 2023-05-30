package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Orientacao;

public class OrientacaoController implements ActionListener {
	private  JTextField textFieldCodOrientacao;
	private  JTextField textFieldCoDGRUPOOrientacao;
	private  JTextField textFieldTituloOrientacao;
	private  JTextField textFieldDataOrientacaoOrientacao;
	private  JTextArea  TextArea;


	public OrientacaoController(JTextField textFieldCodOrientacao, JTextField textFieldCoDGRUPOOrientacao,
			JTextField textFieldTituloOrientacao, JTextField textFieldDataOrientacaoOrientacao, JTextArea textArea) {
		super();
		this.textFieldCodOrientacao = textFieldCodOrientacao;
		this.textFieldCoDGRUPOOrientacao = textFieldCoDGRUPOOrientacao;
		this.textFieldTituloOrientacao = textFieldTituloOrientacao;
		this.textFieldDataOrientacaoOrientacao = textFieldDataOrientacaoOrientacao;
		TextArea = textArea;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String cdm = e.getActionCommand();
		if(cdm.equals("Cadastrar")) {
			try {
				cadastro();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}


		}

	}
	@SuppressWarnings("unused")
	private void Consulta() {
		Orientacao orientacao=new Orientacao();
		orientacao.codOrientacao=textFieldCodOrientacao.getText();
		System.out.println(orientacao);

	}


	private void cadastro() throws IOException {
		Orientacao orientacao=new Orientacao();
		orientacao.codOrientacao=textFieldCodOrientacao.getText();
		orientacao.codigoGP=textFieldCoDGRUPOOrientacao.getText();
		orientacao.titulo=textFieldTituloOrientacao.getText();
		orientacao.data=textFieldDataOrientacaoOrientacao.getText();
		orientacao.descricao=TextArea.getText();
		System.out.println(orientacao);


		cadastrarOrientacao(orientacao.toString());
		textFieldCoDGRUPOOrientacao.setText("");
		textFieldCodOrientacao.setText("");
		textFieldDataOrientacaoOrientacao.setText("");
		textFieldTituloOrientacao.setText("");
		TextArea.setText("");

	}


	private void cadastrarOrientacao(String csvOrientacao) throws IOException {
		String path= System.getProperty ("user.home") + File.separator + "SistemaCadastro";
		File dir= new File(path);
		if(!dir.exists()) {
			dir.mkdir();

		}
		File arq= new File(path, "Orientacao.csv");
		boolean existe=false;
		if(arq.exists()) {
			existe=true;
		}
		FileWriter fw= new FileWriter(arq, existe);

		PrintWriter pw= new PrintWriter(fw);
		pw.write(csvOrientacao+"\r\n");
		pw.flush();
		pw.close();
		fw.close();


	}
}
