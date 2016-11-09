package com.coded2.sas.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.coded2.infra.entity.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the tb_curso database table.
 * 
 */
@Entity
@Table(name="tb_curso")
@NamedQuery(name="Curso.findAll", query="SELECT c FROM Curso c")
public class Curso extends Model {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tb_curso_NUCURSO_GENERATOR", sequenceName="tb_curso_nu_curso_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tb_curso_NUCURSO_GENERATOR")
	@Column(name="nu_curso")
	private Integer nuCurso;

	@Column(name="de_area_conhecimento")
	private String deAreaConhecimento;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim")
	private Date dtFim;

	@Column(name="no_curso")
	private String noCurso;

	//bi-directional many-to-one association to Aluno
	@OneToMany(mappedBy="curso")
	private List<Aluno> alunos;

	//bi-directional many-to-one association to DisciplinaCurso
	@OneToMany(mappedBy="curso")
	private List<DisciplinaCurso> disciplinas;

	//bi-directional many-to-one association to Turma
	@OneToMany(mappedBy="curso")
	private List<Turma> turmas;

	//uni-directional many-to-one association to Pessoa
	@ManyToOne
	@JoinColumn(name="nu_coordenador")
	private Pessoa coordenador;

	public Curso() {
	}

	public Integer getNuCurso() {
		return this.nuCurso;
	}

	public void setNuCurso(Integer nuCurso) {
		this.nuCurso = nuCurso;
	}

	public String getDeAreaConhecimento() {
		return this.deAreaConhecimento;
	}

	public void setDeAreaConhecimento(String deAreaConhecimento) {
		this.deAreaConhecimento = deAreaConhecimento;
	}

	public Date getDtFim() {
		return this.dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public String getNoCurso() {
		return this.noCurso;
	}

	public void setNoCurso(String noCurso) {
		this.noCurso = noCurso;
	}

	public List<Aluno> getAlunos() {
		return this.alunos;
	}

	public void setAlunos(List<Aluno> alunos) {
		this.alunos = alunos;
	}

	public Aluno addAluno(Aluno aluno) {
		getAlunos().add(aluno);
		aluno.setCurso(this);

		return aluno;
	}

	public Aluno removeAluno(Aluno aluno) {
		getAlunos().remove(aluno);
		aluno.setCurso(null);

		return aluno;
	}

	public List<DisciplinaCurso> getDisciplinas() {
		if (disciplinas == null) {
			disciplinas = new ArrayList<DisciplinaCurso>();
			
		}

		return disciplinas;
	}

	public void setDisciplinas(List<DisciplinaCurso> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public DisciplinaCurso addDisciplina(DisciplinaCurso disciplina) {
		getDisciplinas().add(disciplina);
		disciplina.getId().setNuCurso(nuCurso);
		disciplina.setCurso(this);

		return disciplina;
	}

	public DisciplinaCurso removeDisciplina(DisciplinaCurso disciplina) {
		getDisciplinas().remove(disciplina);
		disciplina.setCurso(null);

		return disciplina;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setCurso(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setCurso(null);

		return turma;
	}

	public Pessoa getCoordenador() {
		if (coordenador == null) {
			coordenador = new Pessoa();
			
		}

		return coordenador;
	}

	public void setCoordenador(Pessoa coordenador) {
		this.coordenador = coordenador;
	}

	@JsonIgnore
	@Override
	public Object getId() {
		return getNuCurso();
	}
	
	
}