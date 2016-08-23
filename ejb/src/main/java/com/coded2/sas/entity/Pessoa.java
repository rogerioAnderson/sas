package com.coded2.sas.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import com.coded2.infra.entity.Model;
import com.coded2.infra.json.serializer.DateSerializer;
import com.coded2.infra.validation.contraintvalidators.annotation.CPF;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;


/**
 * The persistent class for the tb_pessoa database table.
 * 
 */
@Entity
@Table(name="tb_pessoa")
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public class Pessoa extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TB_PESSOA_NUPESSOA_GENERATOR", sequenceName="TB_PESSOA_NU_PESSOA_SEQ",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="TB_PESSOA_NUPESSOA_GENERATOR")
	@Column(name="nu_pessoa")
	private Integer nuPessoa;

	@Column(name="co_cep")
	private String coCep;

	@CPF
	@NotNull(message="Campo CPF Obrigatório")
	@Column(name="co_cpf")
	private String coCpf;

	@NotNull(message="Campo Identidade Obrigatório")
	@Column(name="co_rg")
	private String coRg;

	@NotNull(message="Campo Celular Obrigatório")
	@Column(name="de_celular")
	private String deCelular;

	@Column(name="de_cidade_natal")
	private String deCidadeNatal;

	@Column(name="de_email")
	private String deEmail;

	
	@NotNull(message="Campo Endereço Obrigatório")
	@Column(name="de_endereco")
	private String deEndereco;

	@NotNull(message="Telefone Campo obrigatório")
	@Digits(message="O telefone deve conter o DDD sem 0 e o numero com 9 ou 8 digitos", fraction = 0, integer = 11)
	@Column(name="de_telefone")
	private String deTelefone;

	@Column(name="de_titulacao")
	private String deTitulacao;
	
	
	@JsonSerialize(using=DateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy",locale="pt-BR")
	@NotNull(message="Data de Nascimento campo obrigatório")
	@Past(message="A data de Nascimento não pode ser uma data futura")
	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Date dtNascimento;

	
	@NotNull(message="Função Campo Obrigatório")
	@Column(name="ic_funcao")
	private String icFuncao;

	
	
	@Column(name="no_graduacao")
	private String noGraduacao;

	@Column(name="no_mae")
	private String noMae;

	@Column(name="no_pai")
	private String noPai;
	
	
	@NotNull(message="Nome da pessoa é obrigatório")
	@Column(name="no_pessoa")
	private String noPessoa;

	
	@NotNull(message="O estado de Nascimento deve ser informado")
	//bi-directional many-to-one association to UF
	@ManyToOne(fetch=FetchType.EAGER)	
	@JoinColumn(name="sg_uf")
	
	private UF uf;

	public Pessoa() {
	}

	public Integer getNuPessoa() {
		return this.nuPessoa;
	}

	public void setNuPessoa(Integer nuPessoa) {
		this.nuPessoa = nuPessoa;
	} 

	public String getCoCep() {
		return this.coCep;
	}

	public void setCoCep(String coCep) {
		this.coCep = coCep;
	}

	public String getCoCpf() {
		return this.coCpf;
	}

	public void setCoCpf(String coCpf) {
		this.coCpf = coCpf;
	}

	public String getCoRg() {
		return this.coRg;
	}

	public void setCoRg(String coRg) {
		this.coRg = coRg;
	}

	public String getDeCelular() {
		return this.deCelular;
	}

	public void setDeCelular(String deCelular) {
		this.deCelular = deCelular;
	}

	public String getDeCidadeNatal() {
		return this.deCidadeNatal;
	}

	public void setDeCidadeNatal(String deCidadeNatal) {
		this.deCidadeNatal = deCidadeNatal;
	}

	public String getDeEmail() {
		return this.deEmail;
	}

	public void setDeEmail(String deEmail) {
		this.deEmail = deEmail;
	}

	public String getDeEndereco() {
		return this.deEndereco;
	}

	public void setDeEndereco(String deEndereco) {
		this.deEndereco = deEndereco;
	}

	public String getDeTelefone() {
		return this.deTelefone;
	}

	public void setDeTelefone(String deTelefone) {
		this.deTelefone = deTelefone;
	}

	public String getDeTitulacao() {
		return this.deTitulacao;
	}

	public void setDeTitulacao(String deTitulacao) {
		this.deTitulacao = deTitulacao;
	}

	public Date getDtNascimento() {
		return this.dtNascimento;
	}

	public void setDtNascimento(Date dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public String getIcFuncao() {
		return this.icFuncao;
	}

	public void setIcFuncao(String icFuncao) {
		this.icFuncao = icFuncao;
	}

	public String getNoGraduacao() {
		return this.noGraduacao;
	}

	public void setNoGraduacao(String noGraduacao) {
		this.noGraduacao = noGraduacao;
	}

	public String getNoMae() {
		return this.noMae;
	}

	public void setNoMae(String noMae) {
		this.noMae = noMae;
	}

	public String getNoPai() {
		return this.noPai;
	}

	public void setNoPai(String noPai) {
		this.noPai = noPai;
	}

	public String getNoPessoa() {
		return this.noPessoa;
	}

	public void setNoPessoa(String noPessoa) {
		this.noPessoa = noPessoa;
	}

	
	public UF getUf() {
		if (uf == null) {
			uf =  new UF();
		}
		return uf;
	}

	public void setUf(UF uf) {
		this.uf = uf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((nuPessoa == null) ? 0 : nuPessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (nuPessoa == null) {
			if (other.nuPessoa != null)
				return false;
		} else if (!nuPessoa.equals(other.nuPessoa))
			return false;
		return true;
	}

	@Override
	@JsonIgnore
	public Object getId() {
		return getNuPessoa();
	}
	
	

}