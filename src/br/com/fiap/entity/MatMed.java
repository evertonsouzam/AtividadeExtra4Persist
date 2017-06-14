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
@Table(name = "MATMED", catalog = "Atividade4Persist")
public class MatMed {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idMatMed")
	private int idMatMed;
	
	@Column(name = "Descricao", length = 45)
	private String descricao;
	
	@Column(name = "Preco")
	private double preco;
	
	@Column(name = "Fabricante", length = 45)
	private String fabricante;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cpfPac")

	private Paciente cpfPac;
	
	
	public int getIdMatMed() {
		return idMatMed;
	}
	public void setIdMatMed(int idMatMed) {
		this.idMatMed = idMatMed;
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
	public String getFabricante() {
		return fabricante;
	}
	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	public Paciente getCpfPac() {
		return cpfPac;
	}
	public void setCpfPac(Paciente cpfPac) {
		this.cpfPac = cpfPac;
	}
	@Override
	public String toString() {
		return "MatMed [idMatMed=" + idMatMed + ", descricao=" + descricao + ", preco=" + preco + ", fabricante="
				+ fabricante + "]";
	}
	
	
}
