package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestCupomFiscal {

	private String BREAK = System.lineSeparator();

	@Test
	public void lojaCompleta() {
		rodarTestarRetorno("Arcos Dourados Com. de Alimentos LTDA" + BREAK + 
				"Av. Projetada Leste, 500 EUC F32/33/34" + BREAK + 
				"Br. Sta Genebra - Campinas - SP" + BREAK + 
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK + 
				"Loja 1317 (PDP)" + BREAK + 
				"CNPJ: 42.591.651/0797-34" + BREAK + 
				"IE: 244.898.500.113" + BREAK);
	}

	@Test
	public void nomeVazio() {
		CupomFiscal.NOME_LOJA = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo nome da loja é obrigatório", e.getMessage());
		}
		CupomFiscal.NOME_LOJA = "Arcos Dourados Com. de Alimentos LTDA";
	}
	
	@Test
	public void logradouroVazio() {
		CupomFiscal.LOGRADOURO = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo logradouro do endereço é obrigatório", e.getMessage());
		}
		CupomFiscal.LOGRADOURO = "Av. Projetada Leste";
	}

	@Test
	public void numeroZero() {
		CupomFiscal.NUMERO = 0;
		rodarTestarRetorno("Arcos Dourados Com. de Alimentos LTDA" + BREAK +
				"Av. Projetada Leste, s/n EUC F32/33/34" + BREAK +
				"Br. Sta Genebra - Campinas - SP" + BREAK +
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK +
				"Loja 1317 (PDP)" + BREAK +
				"CNPJ: 42.591.651/0797-34" + BREAK +
				"IE: 244.898.500.113" + BREAK);

		CupomFiscal.NUMERO = 500;
	}
	
	@Test
	public void municipioVazio() {
		CupomFiscal.MUNICIPIO = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo município do endereço é obrigatório", e.getMessage());
		}
		CupomFiscal.MUNICIPIO = "Campinas";
	}

	@Test
	public void estadoVazio() {
		CupomFiscal.ESTADO = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo estado do endereço é obrigatório", e.getMessage());
		}
	    CupomFiscal.ESTADO = "SP";
	}
	
	@Test
	public void cnpjVazio() {
		CupomFiscal.CNPJ = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo CNPJ da loja é obrigatório", e.getMessage());
		}
	    CupomFiscal.CNPJ = "42.591.651/0797-34";
	}

	@Test
	public void inscricaoEstadualVazia() {
		CupomFiscal.INSCRICAO_ESTADUAL = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo inscrição estadual da loja é obrigatório", e.getMessage());
		}
		CupomFiscal.INSCRICAO_ESTADUAL = "244.898.500.113";
	}
	
	@Test
	public void exercicio02_Customizado() {

		CupomFiscal.NOME_LOJA = "Magic Box";
		CupomFiscal.LOGRADOURO = "Baker St";
		CupomFiscal.NUMERO = 221;
		CupomFiscal.COMPLEMENTO = "EDA A24/25/26";
		CupomFiscal.BAIRRO = "Marylebone";
		CupomFiscal.MUNICIPIO = "Sunnydale";
		CupomFiscal.ESTADO = "CA";
		CupomFiscal.CEP = "79297";
		CupomFiscal.TELEFONE = "(213) 70374-7092";
		CupomFiscal.OBSERVACAO = "Loja TW (BTVS)";
		CupomFiscal.CNPJ = "98.650.809/0001-63";
		CupomFiscal.INSCRICAO_ESTADUAL = "55021852-1";
		
		String expected = "Magic Box" + BREAK;
		expected += "Baker St, 221 EDA A24/25/26" + BREAK;
		expected += "Marylebone - Sunnydale - CA" + BREAK;
		expected += "CEP:79297 Tel (213) 70374-7092" + BREAK;
		expected += "Loja TW (BTVS)" + BREAK;
		expected += "CNPJ: 98.650.809/0001-63" + BREAK;
		expected += "IE: 55021852-1"; 

		rodarTestarRetorno(expected + BREAK);
	}

	private void rodarTestarRetorno(String expected) {

		// action
		String retorno = CupomFiscal.dadosLoja();

		// assertion
		assertEquals(expected, retorno);
	}
}
