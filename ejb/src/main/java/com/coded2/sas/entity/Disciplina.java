package com.coded2.sas.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.coded2.infra.entity.Model;


/**
 * The persistent class for the tb_disciplina database table.
 * 
 */
@Entity
@Table(name="tb_disciplina")
@NamedQuery(name="Disciplina.findAll", query="SELECT d FROM Disciplina d")
public class Disciplina extends Model{
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="tb_disciplina_nu_disciplina_GENERATOR", sequenceName="tb_disciplina_nu_disciplina_seq",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="tb_disciplina_nu_disciplina_GENERATOR")
	@Column(name="nu_disciplina")
	private Integer nuDisciplina;

	@Temporal(TemporalType.DATE)
	@Column(name="dt_fim")
	private Date dtFim;

	@Column(name="no_disciplina")
	private String noDisciplina;

	//bi-directional many-to-one association to DisciplinaCurso
	@OneToMany(mappedBy="disciplina")
	private List<DisciplinaCurso> cursos;

	//bi-directional many-to-one association to Turma
	@OneToMany(mappedBy="disciplina")
	private List<Turma> turmas;

	public Disciplina() {
	}

	public Integer getNuDisciplina() {
		return this.nuDisciplina;
	}

	public void setNuDisciplina(Integer nuDisciplina) {
		this.nuDisciplina = nuDisciplina;
	}

	public Date getDtFim() {
		return this.dtFim;
	}

	public void setDtFim(Date dtFim) {
		this.dtFim = dtFim;
	}

	public String getNoDisciplina() {
		return this.noDisciplina;
	}

	public void setNoDisciplina(String noDisciplina) {
		this.noDisciplina = noDisciplina;
	}

	public List<DisciplinaCurso> getCursos() {
		return this.cursos;
	}

	public void setCursos(List<DisciplinaCurso> cursos) {
		this.cursos = cursos;
	}

	public DisciplinaCurso addCurso(DisciplinaCurso curso) {
		getCursos().add(curso);
		curso.setDisciplina(this);

		return curso;
	}

	public DisciplinaCurso removeCurso(DisciplinaCurso curso) {
		getCursos().remove(curso);
		curso.setDisciplina(null);

		return curso;
	}

	public List<Turma> getTurmas() {
		return this.turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public Turma addTurma(Turma turma) {
		getTurmas().add(turma);
		turma.setDisciplina(this);

		return turma;
	}

	public Turma removeTurma(Turma turma) {
		getTurmas().remove(turma);
		turma.setDisciplina(null);

		return turma;
	}

	@Override
	public Object getId() {
		return getNuDisciplina();
	}

}