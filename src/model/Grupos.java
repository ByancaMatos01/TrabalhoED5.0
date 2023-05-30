package model;

import java.util.List;

public class Grupos {
	  public String codigo;
      public String area;
      public String tema;
      public String subarea;
      public String data;
      public String nome;
      public  String Ra;
      public  String alunos;
	@Override
	public String toString() {
		return codigo + ";" + area + ";" + tema + ";" + subarea + ";"
				+ data + ";" + nome + ";" + Ra + ";" + alunos;
	}
	
}
