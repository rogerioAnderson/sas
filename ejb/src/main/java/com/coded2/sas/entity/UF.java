package com.coded2.sas.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.coded2.infra.entity.Model;


/**
 * The persistent class for the tb008_uf database table.
 * 
 */
@Entity
@Table(name="tb_uf")
@NamedQuery(name="UF.findAll", query="SELECT u FROM UF u")
public class UF extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="sg_uf")
	private String sgUf;

	private String nome;

	//bi-directional many-to-one association to Pessoa
	@OneToMany(mappedBy="uf")
	private List<Pessoa> pessoas;

	public UF() {
	}

	public String getSgUf() {
		return this.sgUf;
	}

	public void setSgUf(String sgUf) {
		this.sgUf = sgUf;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Pessoa> getPessoas() {
		return this.pessoas;
	}

	public void setPessoas(List<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Pessoa addPessoa(Pessoa pessoa) {
		getPessoas().add(pessoa);
		pessoa.setUf(this);

		return pessoa;
	}

	public Pessoa removePessoa(Pessoa pessoa) {
		getPessoas().remove(pessoa);
		pessoa.setUf(null);

		return pessoa;
	}

	@Override
	public Object getId() {
		return getSgUf();
	}

}