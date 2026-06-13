package cadastropoo;

import java.util.Scanner;
import model.*;

public class CadastroPOO {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        PessoaFisicaRepo repoPF = new PessoaFisicaRepo();
        PessoaJuridicaRepo repoPJ = new PessoaJuridicaRepo();

        int opcao = -1;

        while (opcao != 0) {

            System.out.println("\n===== CADASTRO POO =====");
            System.out.println("1 - Incluir");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Exibir por ID");
            System.out.println("5 - Exibir Todos");
            System.out.println("6 - Salvar Dados");
            System.out.println("7 - Recuperar Dados");
            System.out.println("0 - Finalizar");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    System.out.print("Tipo: ");
                    int tipoInclusao = sc.nextInt();
                    sc.nextLine();

                    if (tipoInclusao == 1) {

                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();

                        System.out.print("Idade: ");
                        int idade = sc.nextInt();
                        sc.nextLine();

                        PessoaFisica pf =
                                new PessoaFisica(
                                        id,
                                        nome,
                                        cpf,
                                        idade);

                        repoPF.inserir(pf);

                        System.out.println("Pessoa Física cadastrada!");

                    } else {

                        System.out.print("ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Nome: ");
                        String nome = sc.nextLine();

                        System.out.print("CNPJ: ");
                        String cnpj = sc.nextLine();

                        PessoaJuridica pj =
                                new PessoaJuridica(
                                        id,
                                        nome,
                                        cnpj);

                        repoPJ.inserir(pj);

                        System.out.println("Pessoa Jurídica cadastrada!");
                    }

                    break;

                case 2:

                    System.out.println("\n1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    System.out.print("Tipo: ");
                    int tipoAlterar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("ID: ");
                    int idAlterar = sc.nextInt();
                    sc.nextLine();

                    if (tipoAlterar == 1) {

                        PessoaFisica pf =
                                repoPF.obter(idAlterar);

                        if (pf != null) {

                            System.out.println("\nDados atuais:");
                            pf.exibir();

                            System.out.print("Novo Nome: ");
                            String nome = sc.nextLine();

                            System.out.print("Novo CPF: ");
                            String cpf = sc.nextLine();

                            System.out.print("Nova Idade: ");
                            int idade = sc.nextInt();
                            sc.nextLine();

                            PessoaFisica novaPF =
                                    new PessoaFisica(
                                            idAlterar,
                                            nome,
                                            cpf,
                                            idade);

                            repoPF.alterar(novaPF);

                            System.out.println("Alterado com sucesso!");

                        } else {

                            System.out.println("Pessoa não encontrada.");
                        }

                    } else {

                        PessoaJuridica pj =
                                repoPJ.obter(idAlterar);

                        if (pj != null) {

                            System.out.println("\nDados atuais:");
                            pj.exibir();

                            System.out.print("Novo Nome: ");
                            String nome = sc.nextLine();

                            System.out.print("Novo CNPJ: ");
                            String cnpj = sc.nextLine();

                            PessoaJuridica novaPJ =
                                    new PessoaJuridica(
                                            idAlterar,
                                            nome,
                                            cnpj);

                            repoPJ.alterar(novaPJ);

                            System.out.println("Alterado com sucesso!");

                        } else {

                            System.out.println("Pessoa não encontrada.");
                        }
                    }

                    break;

                case 3:

                    System.out.println("\n1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    System.out.print("Tipo: ");
                    int tipoExcluir = sc.nextInt();

                    System.out.print("ID: ");
                    int idExcluir = sc.nextInt();
                    sc.nextLine();

                    if (tipoExcluir == 1) {

                        repoPF.excluir(idExcluir);

                    } else {

                        repoPJ.excluir(idExcluir);
                    }

                    System.out.println("Exclusão realizada.");

                    break;

                case 4:

                    System.out.println("\n1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    System.out.print("Tipo: ");
                    int tipoObter = sc.nextInt();

                    System.out.print("ID: ");
                    int idObter = sc.nextInt();
                    sc.nextLine();

                    if (tipoObter == 1) {

                        PessoaFisica pf =
                                repoPF.obter(idObter);

                        if (pf != null) {

                            pf.exibir();

                        } else {

                            System.out.println("Pessoa não encontrada.");
                        }

                    } else {

                        PessoaJuridica pj =
                                repoPJ.obter(idObter);

                        if (pj != null) {

                            pj.exibir();

                        } else {

                            System.out.println("Pessoa não encontrada.");
                        }
                    }

                    break;

                case 5:

                    System.out.println("\n1 - Pessoa Física");
                    System.out.println("2 - Pessoa Jurídica");
                    System.out.print("Tipo: ");
                    int tipoTodos = sc.nextInt();
                    sc.nextLine();

                    if (tipoTodos == 1) {

                        for (PessoaFisica pf :
                                repoPF.obterTodos()) {

                            pf.exibir();
                        }

                    } else {

                        for (PessoaJuridica pj :
                                repoPJ.obterTodos()) {

                            pj.exibir();
                        }
                    }

                    break;

                case 6:

                    System.out.print("Prefixo dos arquivos: ");
                    String prefixoSalvar =
                            sc.nextLine();

                    try {

                        repoPF.persistir(
                                prefixoSalvar
                                        + ".fisica.bin");

                        repoPJ.persistir(
                                prefixoSalvar
                                        + ".juridica.bin");

                        System.out.println(
                                "Dados salvos com sucesso!");

                    } catch (Exception e) {

                        System.out.println(
                                "Erro ao salvar: "
                                        + e.getMessage());
                    }

                    break;

                case 7:

                    System.out.print("Prefixo dos arquivos: ");
                    String prefixoRecuperar =
                            sc.nextLine();

                    try {

                        repoPF.recuperar(
                                prefixoRecuperar
                                        + ".fisica.bin");

                        repoPJ.recuperar(
                                prefixoRecuperar
                                        + ".juridica.bin");

                        System.out.println(
                                "Dados recuperados com sucesso!");

                    } catch (Exception e) {

                        System.out.println(
                                "Erro ao recuperar: "
                                        + e.getMessage());
                    }

                    break;

                case 0:

                    System.out.println("Sistema encerrado.");
                    break;

                default:

                    System.out.println("Opção inválida.");
            }
        }

        sc.close();
    }
}