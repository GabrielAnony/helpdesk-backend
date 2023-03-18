package com.gabriel.helpdesk.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gabriel.helpdesk.domain.Chamado;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChamadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataAbertura = LocalDate.now();
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataFechamento;
	@NotNull(message = "O campo PRIORIDADE é requerido")
	private Integer prioridade;
	@NotNull(message = "O campo STATUS é requerido")
	private Integer status;
	@NotNull(message = "O campo TITULO é requerido")
	private String titulo;
	@NotNull(message = "O campo OBSERVAÇÕES é requerido")
	private String observacao;
	@NotNull(message = "O campo TECNICO é requerido")
	private Integer tecnico;
	@NotNull(message = "O campo CLIENTE é requerido")
	private Integer cliente;
	private String nomeTecnico;
	private String nomeCliente;

	public ChamadoDTO() {
		super();
	}

	public ChamadoDTO(Chamado obj) {
		this.id = obj.getId();
		this.dataAbertura = obj.getDataAbertura();
		this.dataFechamento = obj.getDataFechamento();
		this.prioridade = obj.getPrioridade().getCodigo();
		this.status = obj.getStatus().getCodigo();
		this.titulo = obj.getTitulo();
		this.observacao = obj.getObservacao();
		this.tecnico = obj.getTecnico().getId();
		this.cliente = obj.getCliente().getId();
		this.nomeCliente = obj.getCliente().getNome();
		this.nomeTecnico = obj.getTecnico().getNome();
	}
}
