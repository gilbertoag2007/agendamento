package com.empresa.agendadorapi.dto;

import java.util.Objects;

import org.springframework.data.annotation.Id;

public class UsuarioDTO {

	@Id
	private String id;
	
	/* nome do usuario*/
	private String nome;
	
	/* idade do usuario */
	private Integer idade;
	
	/* cpf do usuario */
	private String cpf;
	
	/* nome do responsavel pelo usuario - crianca*/
	private String responsavel;
	
	/*email de contato com usuario ou responsavel*/
	private String email;
	
	/* telefone do usuario ou responsavel*/
	private String telefone;
	
	private String observacao;

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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	@Override
	public String toString() {
		return "UsuarioDTO [id=" + id + ", nome=" + nome + ", idade=" + idade + ", cpf=" + cpf + ", responsavel="
				+ responsavel + ", email=" + email + ", telefone=" + telefone + ", observacao=" + observacao + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, id, idade, nome, observacao, responsavel, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UsuarioDTO other = (UsuarioDTO) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email) && Objects.equals(id, other.id)
				&& Objects.equals(idade, other.idade) && Objects.equals(nome, other.nome)
				&& Objects.equals(observacao, other.observacao) && Objects.equals(responsavel, other.responsavel)
				&& Objects.equals(telefone, other.telefone);
	}
	
	
	
	
}
