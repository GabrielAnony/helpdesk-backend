package com.gabriel.helpdesk.domain.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriel.helpdesk.domain.Tecnico;
import com.gabriel.helpdesk.domain.enums.Perfil;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
public class TecnicoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	protected Integer id;
	
	@Getter
	@Setter
	protected String nome;
	
	@Getter
	@Setter
	protected String cpf;
	
	@Getter
	@Setter
	protected String email;
	
	@Getter
	@Setter
	protected String senha;
	
	protected Set<Integer> perfis = new HashSet<>();
	
	@Getter
	@Setter
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	
	public TecnicoDTO(Tecnico obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
		this.dataCriacao = obj.getDataCriacao();
		setPerfil(Perfil.CLIENTE);
	}
	
		
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void setPerfil(Perfil perfil) {
		this.perfis.add(perfil.getCodigo());
	}
	
}
