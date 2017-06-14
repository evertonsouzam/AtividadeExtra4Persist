package br.com.fiap.core;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

import br.com.fiap.dao.GenericDao;
import br.com.fiap.entity.Agenda;
import br.com.fiap.entity.MatMed;
import br.com.fiap.entity.Paciente;
import br.com.fiap.entity.Procedimento;
import br.com.fiap.util.JpaUtil;

public class Main {

	public static void main(String[] args) {

		Paciente paciente = criarPaciente();

		try {
			GenericDao<Paciente> dao = new GenericDao<>(Paciente.class);
			dao.adicionar(paciente);
			dao.listar().toString();
			Paciente pacienteRetorno = dao.buscar(4);
			System.out.println(pacienteRetorno.toString());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			JpaUtil.emfClose();
		}

	}

	private static Paciente criarPaciente() {
		Paciente paciente = new Paciente();
		paciente.setCpf("12345678909");
		paciente.setDataNasc(LocalDate.of(1990, 03, 28));
		paciente.setNome("Everton Mendes");
		paciente.setTelefone("11123456789");
		
		paciente.setProcedimentos(criarProcedimentos(paciente));
		
		paciente.setMatMeds(criarMatMeds(paciente));
		
		Set<Paciente> pacientes = new HashSet<Paciente>();
		
		pacientes.add(paciente);

		paciente.setAgendas(criarAgendas(pacientes));
		
		return paciente;
		
	}
	
	private static Set<Agenda> criarAgendas(Set<Paciente> pacientes) {
		Agenda agenda1 = new Agenda();
		agenda1.setDescricao("Rotina");
		agenda1.setData(LocalDate.now());
		agenda1.setHora(LocalTime.now());
		agenda1.setPacientes(pacientes);
		
		Agenda agenda2 = new Agenda();
		agenda2.setDescricao("Retorno");
		agenda2.setData(LocalDate.now());
		agenda2.setHora(LocalTime.now());
		agenda2.setPacientes(pacientes);
		
		Agenda agenda3 = new Agenda();
		agenda3.setDescricao("Rotina");
		agenda3.setData(LocalDate.now());
		agenda3.setHora(LocalTime.now());
		agenda3.setPacientes(pacientes);
		
		
		Set<Agenda> agendas = new HashSet<Agenda>();
		
		agendas.add(agenda1);
		agendas.add(agenda2);
		agendas.add(agenda3);
		
		return agendas;
	}

	private static Set<MatMed> criarMatMeds(Paciente paciente) {
		MatMed medicamento1 = new MatMed();
		medicamento1.setCpfPac(paciente);
		medicamento1.setDescricao("Seringa");
		medicamento1.setFabricante("Plasticao");
		medicamento1.setPreco(10.00);
		
		Set<MatMed> medicamentos = new HashSet<MatMed>();
		
		medicamentos.add(medicamento1);

		return medicamentos;
	}

	private static Set<Procedimento> criarProcedimentos(Paciente paciente){
		Procedimento procedimento1 = new Procedimento();
		procedimento1.setCpfPac(paciente);
		procedimento1.setDescricao("Exame de Sangue");
		procedimento1.setPreco(50.00);

		Procedimento procedimento2 = new Procedimento();
		procedimento2.setCpfPac(paciente);
		procedimento2.setDescricao("Exame de Java");
		procedimento2.setPreco(100.00);

		Set<Procedimento> procedimentos = new HashSet<Procedimento>();
		
		procedimentos.add(procedimento1);
		procedimentos.add(procedimento2);

		return procedimentos;
	}

}
