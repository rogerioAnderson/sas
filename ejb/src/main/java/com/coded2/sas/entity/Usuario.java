package com.coded2.sas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.coded2.infra.entity.Model;


/**
 * The persistent class for the tb009_usuario database table.
 * 
 */
@Entity
@Table(name="tb_usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario extends Model  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="nu_usuario")
	private Integer nuUsuario;

	@Column(name="co_senha")
	private String coSenha;

	@Column(name="de_email")
	private String deEmail;

	private String nome;

	public Usuario() {
	}

	public Integer getNuUsuario() {
		return this.nuUsuario;
	}

	public void setNuUsuario(Integer nuUsuario) {
		this.nuUsuario = nuUsuario;
	}

	public String getCoSenha() {
		return this.coSenha;
	}

	public void setCoSenha(String coSenha) {
		this.coSenha = coSenha;
	}

	public String getDeEmail() {
		return this.deEmail;
	}

	public void setDeEmail(String deEmail) {
		this.deEmail = deEmail;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public Object getId() {
		return getNuUsuario();
	}

}