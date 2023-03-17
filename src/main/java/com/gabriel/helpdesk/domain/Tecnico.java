package com.gabriel.helpdesk.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.gabriel.helpdesk.domain.enums.Perfil;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tecnico extends Pessoa {

	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "tecnico")
	private List<Chamado> chamados = new ArrayList<>();

	public Tecnico() {
		super();
		addPerfil(Perfil.TECNICO);
	}

	public Tecnico(Integer id, String nome, String cpf, String email, String senha) {
		super(id, nome, cpf, email, senha);
		addPerfil(Perfil.TECNICO);
	}

}
