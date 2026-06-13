package cadastropoo;

import model.*;

public class CadastroPOO {

    public static void main(String[] args) {

        try {

            PessoaFisicaRepo repo1 =
                    new PessoaFisicaRepo();

            repo1.inserir(
                    new PessoaFisica(
                            1,
                            "João",
                            "11111111111",
                            20));

            repo1.inserir(
                    new PessoaFisica(
                            2,
                            "Maria",
                            "22222222222",
                            25));

            repo1.persistir("fisicas.bin");

            PessoaFisicaRepo repo2 =
                    new PessoaFisicaRepo();

            repo2.recuperar("fisicas.bin");

            System.out.println("PESSOAS FÍSICAS");

            for (PessoaFisica pf :
                    repo2.obterTodos()) {

                pf.exibir();
            }

            PessoaJuridicaRepo repo3 =
                    new PessoaJuridicaRepo();

            repo3.inserir(
                    new PessoaJuridica(
                            1,
                            "Empresa A",
                            "11111111111111"));

            repo3.inserir(
                    new PessoaJuridica(
                            2,
                            "Empresa B",
                            "22222222222222"));

            repo3.persistir("juridicas.bin");

            PessoaJuridicaRepo repo4 =
                    new PessoaJuridicaRepo();

            repo4.recuperar("juridicas.bin");

            System.out.println("PESSOAS JURÍDICAS");

            for (PessoaJuridica pj :
                    repo4.obterTodos()) {

                pj.exibir();
            }

        } catch (Exception e) {

            System.out.println(
                    "Erro: " + e.getMessage());
        }
    }
}