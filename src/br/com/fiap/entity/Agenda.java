package br.com.fiap.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "AGENDA", catalog = "Atividade4Persist")
public class Agenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAgenda")
	private int idAgenda;
	
	@Column(name = "Data")
	private LocalDate data;
	
	@Column(name = "Hora")
	private LocalTime hora;
	

	@Column(name = "Nome", length = 45)
	private String descricao;
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "agendas")
	private Set<Paciente> pacientes;
	
	public int getIdAgenda() {
		return idAgenda;
	}
	public void setIdAgenda(int idAgenda) {
		this.idAgenda = idAgenda;
	}
	public LocalDate getData() {
		return data;
	}
	public void setData(LocalDate data) {
		this.data = data;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Set<Paciente> getPacientes() {
		return pacientes;
	}
	public void setPacientes(Set<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	@Override
	public String toString() {
		return "Agenda [idAgenda=" + idAgenda + ", data=" + data + ", hora=" + hora + ", descricao=" + descricao + "]";
	}
	
	
}
