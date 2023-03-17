package com.gabriel.helpdesk.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriel.helpdesk.domain.enums.Prioridade;
import com.gabriel.helpdesk.domain.enums.Status;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = { "id" })
@Entity
public class Chamado implements Serializable {

	private static final long serialVersionUID = 1L;

	@NonNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;

	@NonNull
	private Prioridade prioridade;

	@NonNull
	private Status status;

	@NonNull
	private String titulo;

	@NonNull
	private String observacao;

	@NonNull
	@ManyToOne
	@JoinColumn(name = "tecnico_id")
	private Tecnico tecnico;


	@NonNull
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
}
