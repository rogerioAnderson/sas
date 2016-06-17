package com.coded2.sas.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb003_aluno database table.
 * 
 */
@Entity
@Table(name="tb_aluno")
@NamedQuery(name="Aluno.findAll", query="SELECT a FROM Aluno a")
public class Aluno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="co_matricula")
	private String coMatricula;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_matricula")
	private Date dtMatricula;

	private String situacao;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="nu_curso")
	private Curso curso;

	//bi-directional many-to-one association to TurmaAluno
	@OneToMany(mappedBy="aluno")
	private List<TurmaAluno> turmas;

	//uni-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="nu_pessoa")
	private Pessoa pessoa;

	public Aluno() {
	}

	public String getCoMatricula() {
		return this.coMatricula;
	}

	public void setCoMatricula(String coMatricula) {
		this.coMatricula = coMatricula;
	}

	public Date getDtMatricula() {
		return this.dtMatricula;
	}

	public void setDtMatricula(Date dtMatricula) {
		this.dtMatricula = dtMatricula;
	}

	public String getSituacao() {
		return this.situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<TurmaAluno> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<TurmaAluno> turmas) {
		this.turmas = turmas;
	}

	public TurmaAluno addTurma(TurmaAluno turma) {
		getTurmas().add(turma);
		turma.setAluno(this);

		return turma;
	}

	public TurmaAluno removeTurma(TurmaAluno turma) {
		getTurmas().remove(turma);
		turma.setAluno(null);

		return turma;
	}

	public Pessoa getPessoa() {
		return this.pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}