/**
 * A classe Agencia tem os atributos nome do tipo String, numero
 * e digito do tipo int. Crie um construtor que receba os atributos
 * como parâmetros e os métodos de acesso e os modificadores. O
 * numero e o digito da agencia devem seguir os mesmos padrões
 * do numero e do digito da conta corrente.
 *
 * CRUD: persistir apenas numero (pk) e digito.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Agencia {
    private String nome;
    private int numero;
    private int digito;

    public Agencia(String nome, int numero) {
        this.nome = nome;
        setNumero(numero);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0 || numero > 9999) {
            throw new IllegalArgumentException("O numero da agencia deve ter no maximo 4 digitos e ser positivo.");
        }
        this.numero = numero;
        this.digito = Utils.calcularDigito(numero);
    }

    public int getDigito() {
        return digito;
    }

    public String toString() {
        return "Nome: " + nome + "\nNumero: " + numero + "\nDigito: " + digito;
    }

    public void inserir(Connection conn) {
        String sql = "INSERT INTO agencia (numero, digito) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numero);
            ps.setInt(2, digito);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir agencia: " + e.getMessage());
        }
    }

    public void atualizar(Connection conn) {
        String sql = "UPDATE agencia SET digito = ? WHERE numero = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, digito);
            ps.setInt(2, numero);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar agencia: " + e.getMessage());
        }
    }

    public void excluir(Connection conn) {
        String sql = "DELETE FROM agencia WHERE numero = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numero);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir agencia: " + e.getMessage());
        }
    }

    public void carregar(Connection conn) {
        String sql = "SELECT digito FROM agencia WHERE numero = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numero);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    this.digito = rs.getInt("digito");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao carregar agencia: " + e.getMessage());
        }
    }
}
