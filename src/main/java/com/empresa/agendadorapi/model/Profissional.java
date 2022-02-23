package com.empresa.agendadorapi.model;

import java.time.LocalDateTime;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("profissional")
public class Profissional {

	@Id
	private String id;
	
	/* Nome do professional*/
	private String nome;
	
	/* Funcao que o profissional exerce*/
	private String funcao;
	
	/* CPF do professional*/
	private String cpf;
	
	/* Data que o profisisonal foi incluído no sistema */
	
	private LocalDateTime dataInclusao;
	
	/* Data que o profesional foi excluido do sistema */
	private LocalDateTime dataExclusao;
	
	/*Login  do funcionario*/
	private String login;
	
	/* Senha do funcionario*/
	private String senha;
	
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDateTime getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(LocalDateTime dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public LocalDateTime getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(LocalDateTime dataExclusao) {
		this.dataExclusao = dataExclusao;
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

	@Override
	public String toString() {
		return "Profissional [id=" + id + ", nome=" + nome + ", login=" + login + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, dataExclusao, dataInclusao, funcao, id, login, nome, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profissional other = (Profissional) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(dataExclusao, other.dataExclusao)
				&& Objects.equals(dataInclusao, other.dataInclusao) && Objects.equals(funcao, other.funcao)
				&& Objects.equals(id, other.id) && Objects.equals(login, other.login)
				&& Objects.equals(nome, other.nome) && Objects.equals(senha, other.senha);
	}

	

}
