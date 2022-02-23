package com.empresa.agendadorapi.dto;

import java.util.Objects;

public class ProfissionalDTO {
	
	private String id;
	
	/* Nome do professional*/
	private String nome;
		
	/* CPF do professional*/
	private String cpf;
	
	/* login do usuario */
	private String login;
	
	/* senha do usuario */
	private String senha;

	/*data de inclusao do funcionario*/
	private String dataInclusao;
	
	/* data exclusao funcionario*/
	private String dataExclusao;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(String dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public String getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(String dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	@Override
	public String toString() {
		return "ProfissionalDTO [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", login=" + login + ", senha=" + senha
				+ ", dataInclusao=" + dataInclusao + ", dataExclusao=" + dataExclusao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataExclusao, dataInclusao, id, login, nome, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProfissionalDTO other = (ProfissionalDTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataExclusao, other.dataExclusao)
				&& Objects.equals(dataInclusao, other.dataInclusao) && Objects.equals(id, other.id)
				&& Objects.equals(login, other.login) && Objects.equals(nome, other.nome)
				&& Objects.equals(senha, other.senha);
	}

	
}
