package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import model.Grupos;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import br.juliarafaela.ListaInt.Lista;
import model.Grupos;

public class ConsultaCorntoller implements ActionListener {
	 private JTextField  textFieldCodgpCp;
		private  JTextField textFieldAREA;
		private  JTextField textFieldTEMAGP;
		private  JTextField textFieldSUBAREA;
		private  JTextField textFieldDATA;
		private  JTextField textFieldNOMEGP;
		private  JTextArea  textAreaRAGP;
		private  JTextArea  TextAreaNomeAlunosGP;
		 private  JTextArea  textAreaCG;
	


	public ConsultaCorntoller(JTextField textFieldCodgpCp, JTextArea textAreaRAGP, JTextField textFieldTEMAGP,
				JTextField textFieldSUBAREA, JTextField textFieldDATA, JTextField textFieldNOMEGP,
				JTextField textFieldAREA, JTextArea textAreaNomeAlunosGP, JTextArea textAreaCG) {
			super();
			this.textFieldCodgpCp = textFieldCodgpCp;
			this.textFieldAREA = textFieldAREA;
			this.textFieldTEMAGP = textFieldTEMAGP;
			this.textFieldSUBAREA = textFieldSUBAREA;
			this.textFieldDATA = textFieldDATA;
			this.textFieldNOMEGP = textFieldNOMEGP;
			this.textAreaRAGP = textAreaRAGP;
			TextAreaNomeAlunosGP = textAreaNomeAlunosGP;
			this.textAreaCG = textAreaCG;
		}
	@Override
	public void actionPerformed(ActionEvent e) {
		String cdm = e.getActionCommand();
		if(cdm.equals("Pesquisar")) {
			
				try {
					Consulta();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	}
		
	}
	private void Consulta() throws Exception {
		var grupo=new Grupos();
		grupo.codigo=textFieldCodgpCp.getText();
		grupo.area=textFieldAREA.getText();
		grupo.tema=textFieldTEMAGP.getText();
		grupo.subarea=textFieldSUBAREA.getText();
		grupo.data=textFieldDATA.getText();
		grupo.nome=textFieldNOMEGP.getText();
		grupo.Ra=textAreaRAGP.getText();
		grupo.alunos=TextAreaNomeAlunosGP.getText();

	Lista ConGP=new Lista();
	
	if(!grupo.codigo.equals("")) {
		grupo=buscaCodorientacao(grupo.codigo);
	
	if(grupo!= null) {
		textAreaCG.setText("Codigo: "+ grupo.codigo+" - area: "+grupo.area +" - tema "+ grupo.tema+ "-subarea "+ grupo.subarea+ "- data "+ grupo.data+  "- nome "+ grupo.nome+ "-RA "+ grupo.Ra+ " Alunos  "+ grupo.alunos);
	}
	
	}else if(!grupo.area.equals("")) {
		ConGP = buscaArea(grupo.area);
	}else if(!grupo.tema.equals("")) {
		ConGP = buscaTema(grupo.tema);
	}else if(!grupo.subarea.equals("")) {
		ConGP = buscaSubarea(grupo.subarea);
	}else if(!grupo.data.equals("")) {
		ConGP = buscaData(grupo.data);
	}else if(!grupo.nome.equals("")) {
		ConGP = buscaNome(grupo.nome);
	}else if(!grupo.alunos.equals("")) {
		ConGP = buscaRa(grupo.Ra);
	}else if(!grupo.Ra.equals("")) {
		ConGP = buscaAlunos(grupo.alunos);
	} else {
		JOptionPane.showMessageDialog(null, "Prencha um campo", "ERRO!", JOptionPane.ERROR_MESSAGE);
	}
	int tamanholista = ConGP.size();
	StringBuffer buffer = new StringBuffer();
	if(tamanholista>0) {
	for(int i=0; i<tamanholista;i++) {
		Grupos grupo1 =(Grupos) ConGP.get(i);
		buffer.append("Codigo: "+ grupo1.codigo+" - area: "+grupo1.area +"- tema "+ grupo1.tema+ "-subarea "+ grupo1.subarea+ "- data"+ grupo1.data+  "- nome "+ grupo1.nome+ "-RA "+ grupo1.Ra+ "Alunos"+ grupo1.alunos);
	}
	textAreaCG.setText(buffer.toString());
	}
}



	private Grupos buscaCodorientacao(String codigo) throws IOException {
		Grupos grupo=new Grupos();
		String path= System.getProperty ("user.home") + File.separator + "SistemaCadastro";
		File arq= new File(path, "grupos.csv");
		if(arq.exists() && arq.isFile()) {
			FileInputStream fis=new FileInputStream(arq);
			InputStreamReader isr= new InputStreamReader(fis);
			BufferedReader buffer= new BufferedReader(isr);
			String linha=buffer.readLine();
			while(linha!=null) {
				String[] vetLinha=linha.split(";");
				if(vetLinha[0].equals(codigo)) {
					grupo.codigo=vetLinha[0];
					grupo.area=vetLinha[1];
					grupo.tema=vetLinha[2];
					grupo.subarea=vetLinha[3];
					grupo.data=vetLinha[4];
					grupo.nome=vetLinha[5];
					grupo.Ra=vetLinha[6];
					grupo.alunos=vetLinha[7];

					break;
				}
				linha=buffer.readLine();

			}           
			buffer.close();
			isr.close();
			fis.close();
		}
		if(grupo.codigo==null) {
			grupo=null;
		}
		return grupo;
	}
	private Lista buscaArea(String area) throws IOException {
		Lista ConGP=new Lista();
		String path= System.getProperty ("user.home") + File.separator + "SistemaCadastro";
		File arq= new File(path, "grupos.csv");
		if(arq.exists() && arq.isFile()) {
			FileInputStream fis=new FileInputStream(arq);
			InputStreamReader isr= new InputStreamReader(fis);
			BufferedReader buffer= new BufferedReader(isr);
			String linha=buffer.readLine();
			while(linha!=null) {
				String[] vetLinha=linha.split(";");
				if(vetLinha[1].equals(area)) {
					Grupos grupo= new Grupos();
					grupo.codigo=vetLinha[0];
					grupo.area=vetLinha[1];
					grupo.tema=vetLinha[2];
					grupo.subarea=vetLinha[3];
					grupo.data=vetLinha[4];
					grupo.nome=vetLinha[5];
					grupo.Ra=vetLinha[6];
					grupo.alunos=vetLinha[7];

				ConGP.addFirst(ConGP);
				
				}
				linha=buffer.readLine();

			}           
			buffer.close();
			isr.close();
			fis.close();
		}
		
		return ConGP;
	}
	
	private Lista buscaTema(String tema) throws IOException {
		Lista ConGP=new Lista();
		String path= System.getProperty ("user.home") + File.separator + "SistemaCadastro";
		File arq= new File(path, "grupos.csv");
		if(arq.exists() && arq.isFile()) {
			FileInputStream fis=new FileInputStream(arq);
			InputStreamReader isr= new InputStreamReader(fis);
			BufferedReader buffer= new BufferedReader(isr);
			String linha=buffer.readLine();
			while(linha!=null) {
				String[] vetLinha=linha.split(";");
				if(vetLinha[2].equals(tema)) {
					Grupos grupo= new Grupos();
					grupo.codigo=vetLinha[0];
					grupo.area=vetLinha[1];
					grupo.tema=vetLinha[2];
					grupo.subarea=vetLinha[3];
					grupo.data=vetLinha[4];
					grupo.nome=vetLinha[5];
					grupo.Ra=vetLinha[6];
					grupo.alunos=vetLinha[7];

				ConGP.addFirst(ConGP);
				
				}
				linha=buffer.readLine();

			}           
			buffer.close();
			isr.close();
			fis.close();
		}
		
		return ConGP;
	}
	
	private Lista buscaSubarea(String subarea) throws IOException {
		
		Lista ConGP=new Lista();
		String path= System.getProperty ("user.home") + File.separator + "SistemaCadastro";
		File arq= new File(path, "grupos.csv");
		if(arq.exists() && arq.isFile()) {
			FileInputStream fis=new FileInputStream(arq);
			InputStreamReader isr= new InputStreamReader(fis);
			BufferedReader buffer= new BufferedReader(isr);
			String linha=buffer.readLine();
			while(linha!=null) {
				String[] vetLinha=linha.split(";");
				if(vetLinha[3].equals(subarea)) {
					Grupos grupo= new Grupos();
					grupo.codigo=vetLinha[0];
					grupo.area=vetLinha[1];
					grupo.tema=vetLinha[2];
					grupo.subarea=vetLinha[3];
					grupo.data=vetLinha[4];
					grupo.nome=vetLinha[5];
					grupo.Ra=vetLinha[6];
					grupo.alunos=vetLinha[7];

				ConGP.addFirst(ConGP);
				
				}
				linha=buffer.readLine();

			}           
			buffer.close();
			isr.close();
			fis.close();
		}
		
		return ConGP;
	}
	
	private Lista buscaData(String data) throws IOException {
		Lista ConGP=new Lista();
		String path= System.getProperty ("user.home") + File.separator + "SistemaCadastro";
		File arq= new File(path, "grupos.csv");
		if(arq.exists() && arq.isFile()) {
		FileInputStream fis=new FileInputStream(arq);
		InputStreamReader isr= new InputStreamReader(fis);
		BufferedReader buffer= new BufferedReader(isr);
		String linha=buffer.readLine();
		while(linha!=null) {
			String[] vetLinha=linha.split(";");
			if(vetLinha[4].equals(data)) {
				Grupos grupo= new Grupos();
				grupo.codigo=vetLinha[0];
				grupo.area=vetLinha[1];
				grupo.tema=vetLinha[2];
				grupo.subarea=vetLinha[3];
				grupo.data=vetLinha[4];
				grupo.nome=vetLinha[5];
				grupo.Ra=vetLinha[6];
				grupo.alunos=vetLinha[7];

			ConGP.addFirst(ConGP);
			
			}
			linha=buffer.readLine();

		}           
		buffer.close();
		isr.close();
		fis.close();
	}
		return ConGP;
	
	}
	private Lista buscaNome(String nome) throws IOException {
		Lista ConGP=new Lista();
		String path= System.getProperty ("user.home") + File.separator + "SistemaCadastro";
		File arq= new File(path, "grupos.csv");
		if(arq.exists() && arq.isFile()) {
		FileInputStream fis=new FileInputStream(arq);
		InputStreamReader isr= new InputStreamReader(fis);
		BufferedReader buffer= new BufferedReader(isr);
		String linha=buffer.readLine();
		while(linha!=null) {
			String[] vetLinha=linha.split(";");
			if(vetLinha[5].equals(nome)) {
				Grupos grupo= new Grupos();
				grupo.codigo=vetLinha[0];
				grupo.area=vetLinha[1];
				grupo.tema=vetLinha[2];
				grupo.subarea=vetLinha[3];
				grupo.data=vetLinha[4];
				grupo.nome=vetLinha[5];
				grupo.Ra=vetLinha[6];
				grupo.alunos=vetLinha[7];

			ConGP.addFirst(ConGP);
			
			}
			linha=buffer.readLine();

		}           
		buffer.close();
		isr.close();
		fis.close();
	}
		return ConGP;
	
	}
	private Lista buscaRa(String Ra) throws IOException {
		Lista ConGP=new Lista();
		String path= System.getProperty ("user.home") + File.separator + "SistemaCadastro";
		File arq= new File(path, "grupos.csv");
		if(arq.exists() && arq.isFile()) {
		FileInputStream fis=new FileInputStream(arq);
		InputStreamReader isr= new InputStreamReader(fis);
		BufferedReader buffer= new BufferedReader(isr);
		String linha=buffer.readLine();
		while(linha!=null) {
			String[] vetLinha=linha.split(";");
			if(vetLinha[6].equals(Ra)) {
				Grupos grupo= new Grupos();
				grupo.codigo=vetLinha[0];
				grupo.area=vetLinha[1];
				grupo.tema=vetLinha[2];
				grupo.subarea=vetLinha[3];
				grupo.data=vetLinha[4];
				grupo.nome=vetLinha[5];
				grupo.Ra=vetLinha[6];
				grupo.alunos=vetLinha[7];

			ConGP.addFirst(ConGP);
			
			}
			linha=buffer.readLine();

		}           
		buffer.close();
		isr.close();
		fis.close();
	}
		return ConGP;
	
	}
	private Lista buscaAlunos(String alunos) throws IOException {
		Lista ConGP=new Lista();
		String path= System.getProperty ("user.home") + File.separator + "SistemaCadastro";
		File arq= new File(path, "grupos.csv");
		if(arq.exists() && arq.isFile()) {
		FileInputStream fis=new FileInputStream(arq);
		InputStreamReader isr= new InputStreamReader(fis);
		BufferedReader buffer= new BufferedReader(isr);
		String linha=buffer.readLine();
		while(linha!=null) {
			String[] vetLinha=linha.split(";");
			if(vetLinha[7].equals(alunos)) {
				Grupos grupo= new Grupos();
				grupo.codigo=vetLinha[0];
				grupo.area=vetLinha[1];
				grupo.tema=vetLinha[2];
				grupo.subarea=vetLinha[3];
				grupo.data=vetLinha[4];
				grupo.nome=vetLinha[5];
				grupo.Ra=vetLinha[6];
				grupo.alunos=vetLinha[7];

			ConGP.addFirst(ConGP);
			
			}
			linha=buffer.readLine();

		}           
		buffer.close();
		isr.close();
		fis.close();
	}
		return ConGP;
	
	}
		
	}	