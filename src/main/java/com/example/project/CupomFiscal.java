package com.example.project;

public class CupomFiscal {

	public static String NOME_LOJA = "Arcos Dourados Com. de Alimentos LTDA";
	public static String LOGRADOURO = "Av. Projetada Leste";
	public static int NUMERO = 500;
	public static String COMPLEMENTO = "EUC F32/33/34";
	public static String BAIRRO = "Br. Sta Genebra";
	public static String MUNICIPIO = "Campinas";
	public static String ESTADO = "SP";
	public static String CEP = "13080-395";
	public static String TELEFONE = "(19) 3756-7408";
	public static String OBSERVACAO = "Loja 1317 (PDP)";
	public static String CNPJ = "42.591.651/0797-34";
	public static String INSCRICAO_ESTADUAL = "244.898.500.113";

	private static String ENDLN = System.lineSeparator();

	public static String dadosLoja() throws RuntimeException{
		if(NOME_LOJA.equals("")){
			throw new RuntimeException("O campo nome da loja é obrigatório");
		}

		if(LOGRADOURO.equals("")){
			throw new RuntimeException("O campo logradouro do endereço é obrigatório");
		}

		String numero1 = NUMERO + "";
		if(NUMERO == 0){
			numero1 = "s/n";
		}

		if(MUNICIPIO.equals("")){
			throw new RuntimeException("O campo município do endereço é obrigatório");
		}
		
		if(ESTADO.equals("")){
			throw new RuntimeException("O campo estado do endereço é obrigatório");
		}

		if(CNPJ.equals("")){
			throw new RuntimeException("O campo CNPJ da loja é obrigatório");
		}

		if(INSCRICAO_ESTADUAL.equals("")){
			throw new RuntimeException("O campo inscrição estadual da loja é obrigatório");
		}

		String output = NOME_LOJA + ENDLN;
        output += LOGRADOURO + ", " + numero1 + " " + COMPLEMENTO + ENDLN;
        output += BAIRRO + " - " + MUNICIPIO + " - " + ESTADO + ENDLN;
        output += "CEP:" + CEP + " Tel " + TELEFONE + ENDLN;
        output += OBSERVACAO + ENDLN;
        output += "CNPJ: " + CNPJ + ENDLN;
        output += "IE: " + INSCRICAO_ESTADUAL + ENDLN;

		return output;
	}

}
