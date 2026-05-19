import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Professor {
    private String nome;
    private int idade;
    private String matricula;
    private int tipo;

    public Professor() {
    }

    public Professor(String matricula) {
        this.matricula = matricula;
    }

    public Professor(String nome, int idade, String matricula, int tipo) {
        this.nome = nome;
        this.idade = idade;
        this.matricula = matricula;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String toString() {
        return "Matricula: " + matricula + "\nNome: " + nome
                + "\nIdade: " + idade + "\nTipo: " + tipo;
    }

    public void inserir(Connection conn) {
        String sql = "INSERT INTO professor (matricula, nome, idade, tipo) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, matricula);
            ps.setString(2, nome);
            ps.setInt(3, idade);
            ps.setInt(4, tipo);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir professor: " + e.getMessage());
        }
    }

    public void alterar(Connection conn) {
        String sql = "UPDATE professor SET nome = ?, idade = ?, tipo = ? WHERE matricula = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nome);
            ps.setInt(2, idade);
            ps.setInt(3, tipo);
            ps.setString(4, matricula);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao alterar professor: " + e.getMessage());
        }
    }

    public void excluir(Connection conn) {
        String sql = "DELETE FROM professor WHERE matricula = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, matricula);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir professor: " + e.getMessage());
        }
    }

    public void carregar(Connection conn) {
        String sql = "SELECT nome, idade, tipo FROM professor WHERE matricula = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, matricula);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    this.nome = rs.getString("nome");
                    this.idade = rs.getInt("idade");
                    this.tipo = rs.getInt("tipo");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao carregar professor: " + e.getMessage());
        }
    }
}
