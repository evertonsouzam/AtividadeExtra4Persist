package br.com.fiap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROCEDIMENTO", catalog = "Atividade4Persist")
public class Procedimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProcedimento")
	private int idProcedimento;
	
	@Column(name = "Descricao", length = 45)
	private String descricao;
	
	@Column(name = "Preco")
	private double preco;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cpfPac")
	private Paciente cpfPac;
	
	
	
	public int getIdProcedimento() {
		return idProcedimento;
	}
	public void setIdProcedimento(int idProcedimento) {
		this.idProcedimento = idProcedimento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public Paciente getCpfPac() {
		return cpfPac;
	}
	public void setCpfPac(Paciente cpfPac) {
		this.cpfPac = cpfPac;
	}
	@Override
	public String toString() {
		return "Procedimento [idProcedimento=" + idProcedimento + ", descricao=" + descricao + ", preco=" + preco
				 + "]";
	}
	
	

}
