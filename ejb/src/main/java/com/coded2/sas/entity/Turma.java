package com.coded2.sas.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.coded2.infra.entity.Model;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the tb006_turma database table.
 * 
 */
@Entity
@Table(name="tb_turma")
@NamedQuery(name="Turma.findAll", query="SELECT t FROM Turma t")
public class Turma extends Model implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="nu_turma")
	private Integer nuTurma;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim")
	private Date dtFim;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_inicio")
	private Date dtInicio;

	@Column(name="no_turma")
	private String noTurma;

	@Column(name="no_turno")
	private String noTurno;

	@Column(name="nu_dia_levtivo")
	private Integer nuDiaLevtivo;

	@Column(name="qt_carga_horaria")
	private Integer qtCargaHoraria;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="nu_curso")
	private Curso curso;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="nu_disciplina")
	private Disciplina disciplina;

	//bi-directional many-to-one association to TurmaAluno
	@OneToMany(mappedBy="turma")
	private List<TurmaAluno> alunos;

	//uni-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="nu_professor")
	private Pessoa professor;

	public Turma() {
	}

	public Integer getNuTurma() {
		return this.nuTurma;
	}

	public void setNuTurma(Integer nuTurma) {
		this.nuTurma = nuTurma;
	}

	public Date getDtFim() {
		return this.dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public Date getDtInicio() {
		return this.dtInicio;
	}

	public void setDtInicio(Date dtInicio) {
		this.dtInicio = dtInicio;
	}

	public String getNoTurma() {
		return this.noTurma;
	}

	public void setNoTurma(String noTurma) {
		this.noTurma = noTurma;
	}

	public String getNoTurno() {
		return this.noTurno;
	}

	public void setNoTurno(String noTurno) {
		this.noTurno = noTurno;
	}

	public Integer getNuDiaLevtivo() {
		return this.nuDiaLevtivo;
	}

	public void setNuDiaLevtivo(Integer nuDiaLevtivo) {
		this.nuDiaLevtivo = nuDiaLevtivo;
	}

	public Integer getQtCargaHoraria() {
		return this.qtCargaHoraria;
	}

	public void setQtCargaHoraria(Integer qtCargaHoraria) {
		this.qtCargaHoraria = qtCargaHoraria;
	}

	public Curso getCurso() {
		return this.curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina getDisciplina() {
		return this.disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List<TurmaAluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<TurmaAluno> alunos) {
		this.alunos = alunos;
	}

	public TurmaAluno addAluno(TurmaAluno aluno) {
		getAlunos().add(aluno);
		aluno.setTurma(this);

		return aluno;
	}

	public TurmaAluno removeAluno(TurmaAluno aluno) {
		getAlunos().remove(aluno);
		aluno.setTurma(null);

		return aluno;
	}

	public Pessoa getProfessor() {
		return this.professor;
	}

	public void setProfessor(Pessoa professor) {
		this.professor = professor;
	}

	@Override
	public Object getId() {
		return getNuTurma();
	}

}