/**
 * A classe Cliente possui os atributos nome e cpf, ambos do tipo
 * String, e um atributo conta do tipo ContaCorrente. Crie um
 * construtor que receba os atributos como parâmetros e os
 * métodos de acesso e os modificadores.
 *
 * CRUD: persistir apenas cpf (pk) e nome.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Cliente {
    private String nome;
    private String cpf;
    private ContaCorrente conta;

    public Cliente(String nome, String cpf, ContaCorrente conta) {
        this.nome = nome;
        this.cpf = cpf;
        this.conta = conta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public ContaCorrente getConta() {
        return conta;
    }

    public void setConta(ContaCorrente conta) {
        this.conta = conta;
    }

    public String toString() {
        return "CPF: " + cpf + "\nNome: " + nome + "\nConta: " + conta;
    }

    public void inserir(Connection conn) {
        String sql = "INSERT INTO cliente (cpf, nome) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ps.setString(2, nome);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir cliente: " + e.getMessage());
        }
    }

    public void atualizar(Connection conn) {
        String sql = "UPDATE cliente SET nome = ? WHERE cpf = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setString(2, cpf);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar cliente: " + e.getMessage());
        }
    }

    public void excluir(Connection conn) {
        String sql = "DELETE FROM cliente WHERE cpf = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir cliente: " + e.getMessage());
        }
    }

    public void carregar(Connection conn) {
        String sql = "SELECT nome FROM cliente WHERE cpf = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, cpf);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    this.nome = rs.getString("nome");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao carregar cliente: " + e.getMessage());
        }
    }
}
