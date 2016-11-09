package com.coded2.sas.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the tb005_disciplina_curso database table.
 * 
 */
@Embeddable
public class DisciplinaCursoPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="nu_curso", insertable=false, updatable=false)
	private Integer nuCurso;

	@Column(name="nu_disciplina", insertable=false, updatable=false)
	private Integer nuDisciplina;

	public DisciplinaCursoPK() {
	}
	public Integer getNuCurso() {
		return this.nuCurso;
	}
	public void setNuCurso(Integer nuCurso) {
		this.nuCurso = nuCurso;
	}
	public Integer getNuDisciplina() {
		return this.nuDisciplina;
	}
	public void setNuDisciplina(Integer nuDisciplina) {
		this.nuDisciplina = nuDisciplina;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DisciplinaCursoPK)) {
			return false;
		}
		DisciplinaCursoPK castOther = (DisciplinaCursoPK)other;
		return 
			this.nuCurso.equals(castOther.nuCurso)
			&& this.nuDisciplina.equals(castOther.nuDisciplina);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.nuCurso.hashCode();
		hash = hash * prime + this.nuDisciplina.hashCode();
		
		return hash;
	}
}