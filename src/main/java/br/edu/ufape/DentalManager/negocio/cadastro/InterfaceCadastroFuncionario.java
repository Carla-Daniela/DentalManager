package br.edu.ufape.DentalManager.negocio.cadastro;

import java.util.List;

import br.edu.ufape.DentalManager.negocio.basica.Funcionario;



public interface InterfaceCadastroFuncionario {
	
	List<Funcionario> procurarFuncionarioNome(String nome) throws FuncionarioInexistenteException;

	Funcionario procurarFuncionarioId(long id);

	List<Funcionario> listarFuncionario();

	void deletarFuncionarioId(Long id);

	void salvarFuncionario(Funcionario funcionario);

	void deletarFuncionario(Funcionario funcionario);

	Funcionario ProcurarFuncionarioCPF(long cpf) throws FuncionarioInexistenteException;

}
