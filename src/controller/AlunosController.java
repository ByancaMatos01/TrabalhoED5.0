package controller;

import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.JTextField;

import model.Aluno;

public class AlunosController  implements ActionListener {
	private  JTextField textFieldNome;
	private  JTextField textFieldRa;


	public AlunosController(JTextField textFieldNome, JTextField textFieldRa) {
		super();
		this.textFieldNome = textFieldNome;
		this.textFieldRa = textFieldRa;

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

	private void cadastro() throws IOException {
		Aluno aluno=new Aluno();
		aluno.Nome= textFieldNome.getText() ;
		aluno.Ra=textFieldRa.getText();

		System.out.println(aluno);
		cadastraAluno(aluno.toString());
		textFieldNome.setText("");
		textFieldRa.setText("");


	}

	private void cadastraAluno(String csvAluno) throws IOException {
		String path= System.getProperty ("user.home") + File.separator + "SistemaCadastro";
		File dir= new File(path);
		if(!dir.exists()) {
			dir.mkdir();

		}
		File arq= new File(path, "alunos.csv");
		boolean existe=false;
		if(arq.exists()) {
			existe=true;
		}
		FileWriter fw= new FileWriter(arq, existe);

		PrintWriter pw= new PrintWriter(fw);
		pw.write(csvAluno+"\r\n");
		pw.flush();
		pw.close();
		fw.close();


	}
}
