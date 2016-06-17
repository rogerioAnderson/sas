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

import com.coded2.infra.entity.Model;


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

	@Column(name="co_cpf")
	private String coCpf;

	@Column(name="co_rg")
	private String coRg;

	@Column(name="de_celular")
	private String deCelular;

	@Column(name="de_cidade_natal")
	private String deCidadeNatal;

	@Column(name="de_email")
	private String deEmail;

	@Column(name="de_endereco")
	private String deEndereco;

	@Column(name="de_telefone")
	private String deTelefone;

	@Column(name="de_titulacao")
	private String deTitulacao;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_nascimento")
	private Date dtNascimento;

	@Column(name="ic_funcao")
	private String icFuncao;

	@Column(name="no_graduacao")
	private String noGraduacao;

	@Column(name="no_mae")
	private String noMae;

	@Column(name="no_pai")
	private String noPai;

	@Column(name="no_pessoa")
	private String noPessoa;

	//bi-directional many-to-one association to UF
	@ManyToOne(fetch=FetchType.LAZY)	
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
	public Object getId() {
		return getNuPessoa();
	}
	
	

}