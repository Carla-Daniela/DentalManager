package br.edu.ufape.DentalManager.negocio.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.DentalManager.dado.ColecaoAgenda;
import br.edu.ufape.DentalManager.dado.ColecaoAgendamento;
import br.edu.ufape.DentalManager.negocio.basica.Agendamento;
import br.edu.ufape.DentalManager.negocio.basica.DataAgendException;
import br.edu.ufape.DentalManager.negocio.basica.Funcionario;

@Service
public class CadastroAgendamento implements InterfaceCadastroAgendamento {
	@Autowired
	private ColecaoAgendamento colecaoagendamento;
	
	@Override
	public List<Agendamento> procurarAgendamentoPaciente(String nomePaciente) {
		return colecaoagendamento.findByNomePaciente(nomePaciente);
	}

	@Override
	public Agendamento procuraAgendamentoId(long id) {
		return colecaoagendamento.findById(id).orElse(null);
	}

	@Override
	public List<Agendamento> listarAgendamento(){
		return colecaoagendamento.findAll();
	}


	@Override
	public void salvarAgendamento(Agendamento agendamento)throws DataAgendException {
		colecaoagendamento.save(agendamento);
	}

	@Override
	public void deletarAgendamento(Agendamento agendamento) {
		colecaoagendamento.delete(agendamento);
	}
	
	@Override
	public void deletarAgendamentoId(long id) throws AgendamentoException {
		List<Agendamento>agendamentos= listarAgendamento();
		for(Agendamento agendamento : agendamentos) {
			if(agendamento.getId()== id){
				deletarAgendamento(agendamento);
			}
		}
		throw new AgendamentoException();
		
	}

}
