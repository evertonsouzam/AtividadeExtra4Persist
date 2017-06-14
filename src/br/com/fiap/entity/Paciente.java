package br.com.fiap.entity;

import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PACIENTE", catalog = "Atividade4Persist")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPaciente")
	private Integer idPaciente;
	
	@Column(name = "cpf", length = 11)
	private String cpf;
	
	@Column(name = "Nome", length = 45)
	private String nome;

	@Column(name = "DataNasc")
	private LocalDate dataNasc;
	
	@Column(name = "Telefone", length = 20)
	private String telefone;

	@ManyToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="AGENDA_PACIENTE", 
			joinColumns=@JoinColumn(name="idPaciente"),
			inverseJoinColumns=@JoinColumn(name="idAgenda"))
	private Set<Agenda> agendas;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cpfPac")
	private Set<Procedimento> procedimentos;

	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "cpfPac")
	private Set<MatMed> matMeds;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public LocalDate getDataNasc() {
		return dataNasc;
	}
	public void setDataNasc(LocalDate dataNasc) {
		this.dataNasc = dataNasc;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Set<Agenda> getAgendas() {
		return agendas;
	}
	public void setAgendas(Set<Agenda> agendas) {
		this.agendas = agendas;
	}
	public Set<Procedimento> getProcedimentos() {
		return procedimentos;
	}
	public void setProcedimentos(Set<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}
	public Set<MatMed> getMatMeds() {
		return matMeds;
	}
	public void setMatMeds(Set<MatMed> matMeds) {
		this.matMeds = matMeds;
	}

	@Override
	public String toString() {
		return "Paciente [cpf=" + cpf + ", nome=" + nome + ", dataNasc=" + dataNasc + ", telefone=" + telefone
				+ ", agendas=" + agendas + ", procedimentos=" + procedimentos + ", matMeds=" + matMeds + "]";
	}
	
}
