package com.coded2.sas.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tb005_disciplina_curso database table.
 * 
 */
@Entity
@Table(name="tb_disciplina_curso")
@NamedQuery(name="DisciplinaCurso.findAll", query="SELECT d FROM DisciplinaCurso d")
public class DisciplinaCurso implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DisciplinaCursoPK id;

	@Column(name="qt_carga_horaria")
	private Integer qtCargaHoraria;

	//bi-directional many-to-one association to Curso
	@ManyToOne
	@JoinColumn(name="nu_curso",referencedColumnName="nu_curso",insertable=false,updatable=false)
	private Curso curso;

	//bi-directional many-to-one association to Disciplina
	@ManyToOne
	@JoinColumn(name="nu_disciplina",referencedColumnName="nu_disciplina",insertable=false,updatable=false)
	private Disciplina disciplina;

	public DisciplinaCurso() {
	}

	public DisciplinaCursoPK getId() {
		if (id == null) {
			id = new DisciplinaCursoPK();
			
		}

		return id;
	}

	public void setId(DisciplinaCursoPK id) {
		this.id = id;
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
		if (disciplina == null) {
			disciplina = new Disciplina();
		}

		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	
	public void addDisciplina(Disciplina disciplina){
		this.disciplina = disciplina;
		getId().setNuDisciplina(disciplina.getNuDisciplina());
	}
	
}