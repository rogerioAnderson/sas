package com.coded2.sas.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.coded2.infra.entity.Model;


/**
 * The persistent class for the tb007_turma_aluno database table.
 * 
 */
@Entity
@Table(name="tb_turma_aluno")
@NamedQuery(name="TurmaAluno.findAll", query="SELECT t FROM TurmaAluno t")
public class TurmaAluno extends Model implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TurmaAlunoPK id;

	@Column(name="nu_falta")
	private Integer nuFalta;

	@Column(name="vr_nota")
	private BigDecimal vrNota;

	//bi-directional many-to-one association to Aluno
	@ManyToOne
	@JoinColumn(name="co_matricula",referencedColumnName = "co_matricula", insertable = false, updatable = false)
	private Aluno aluno;

	//bi-directional many-to-one association to Turma
	@ManyToOne
	@JoinColumn(name="nu_turma",referencedColumnName = "nu_turma", insertable = false, updatable = false)
	private Turma turma;

	public TurmaAluno() {
	}

	public TurmaAlunoPK getId() {
		return this.id;
	}

	public void setId(TurmaAlunoPK id) {
		this.id = id;
	}

	public Integer getNuFalta() {
		return this.nuFalta;
	}

	public void setNuFalta(Integer nuFalta) {
		this.nuFalta = nuFalta;
	}

	public BigDecimal getVrNota() {
		return this.vrNota;
	}

	public void setVrNota(BigDecimal vrNota) {
		this.vrNota = vrNota;
	}

	public Aluno getAluno() {
		return this.aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Turma getTurma() {
		return this.turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

}