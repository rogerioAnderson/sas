package com.coded2.sas.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb007_turma_aluno database table.
 * 
 */
@Embeddable
public class TurmaAlunoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="co_matricula", insertable=false, updatable=false)
	private String coMatricula;

	@Column(name="nu_turma", insertable=false, updatable=false)
	private Integer nuTurma;

	public TurmaAlunoPK() {
	}
	public String getCoMatricula() {
		return this.coMatricula;
	}
	public void setCoMatricula(String coMatricula) {
		this.coMatricula = coMatricula;
	}
	public Integer getNuTurma() {
		return this.nuTurma;
	}
	public void setNuTurma(Integer nuTurma) {
		this.nuTurma = nuTurma;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof TurmaAlunoPK)) {
			return false;
		}
		TurmaAlunoPK castOther = (TurmaAlunoPK)other;
		return 
			this.coMatricula.equals(castOther.coMatricula)
			&& this.nuTurma.equals(castOther.nuTurma);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.coMatricula.hashCode();
		hash = hash * prime + this.nuTurma.hashCode();
		
		return hash;
	}
}