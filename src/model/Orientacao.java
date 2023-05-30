package model;

public class Orientacao {
    public String codOrientacao;
    public String codigoGP;
    public String titulo;
    public String data;
    public  String descricao;
	@Override
	public String toString() {
		return codOrientacao + ";" + codigoGP + ";" + titulo+ ";" + data + ";" + descricao;
	}
	
}
