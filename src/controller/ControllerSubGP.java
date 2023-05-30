package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Grupos;

public class ControllerSubGP implements ActionListener {
	 private JTextField    textFieldSubarea;
	 private  JTextArea   textAreaCS;
	 private  JTextField textFieldNOMEGP;
	 private  JTextField textFieldCodgpCp;
	
	
	




	public ControllerSubGP(JTextField textFieldSubarea, JTextArea textAreaCS, JTextField textFieldNOMEGP, JTextField textFieldCodgpCp) {
		super();
		this.textFieldSubarea = textFieldSubarea;
		this.textAreaCS = textAreaCS;
		this.textFieldNOMEGP = textFieldNOMEGP;
		this.textFieldCodgpCp=textFieldCodgpCp;
	}



	public void actionPerformed(ActionEvent e) {
		String cdm = e.getActionCommand();
		if(cdm.equals("Pesquisar")) {
		
				try {
					Consulta();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	
	}
		
	}



	private void Consulta() throws IOException {
		Grupos grupo=new Grupos();
		grupo.subarea=textFieldSubarea.getText();
		grupo.nome=textFieldNOMEGP.getText();
		grupo.codigo=textFieldCodgpCp.getText();
		
		grupo=buscaGrupo(grupo);
		
		
		if(grupo.subarea!= null) {
			textAreaCS.setText(" sub area : "+ grupo.subarea+" - codigo : "+grupo.codigo+ "nome"+ grupo.nome  );
		}else {
			textAreaCS.setText("Grupo não encontrado");
		}
		
	}



	private Grupos buscaGrupo(Grupos grupo) throws IOException {
		 String path= System.getProperty ("user.home") + File.separator + "SistemaCadastro";
		 File arq= new File(path, "grupos.csv");
		 if(arq.exists() && arq.isFile()) {
			 FileInputStream fis=new FileInputStream(arq);
			 InputStreamReader isr= new InputStreamReader(fis);
			 BufferedReader buffer= new BufferedReader(isr);
			 String linha=buffer.readLine();
			 while(linha!=null) {
				 String[] vetLinha=linha.split(";");
				 if(vetLinha[0].equals(grupo.subarea)) {
					 grupo.subarea=vetLinha[0];
					 grupo.codigo=vetLinha[3];
					 grupo.nome=vetLinha[2];
					 break;
				 }
				 linha=buffer.readLine();
				 
	}           
			 buffer.close();
			 isr.close();
			 fis.close();
		 }
		 return grupo;
	}
}