/**
 * Crie a classe Disciplina com três construtores (um padrão, um
 * que receba só código e outro que receba todos os parâmetros),
 * métodos de acesso e modificadores e os atributos privados nome,
 * do tipo String, professores, do tipo ArrayList<Professor> e
 * código, do tipo String. Crie o método toString() que retorna o
 * valor dos atributos.
 *
 * Crie os métodos de persistência da classe Disciplina: inserir,
 * alterar, excluir e carregar.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Disciplina {
    private String nome;
    private ArrayList<Professor> professores;
    private String codigo;

    public Disciplina() {
        this.professores = new ArrayList<>();
    }

    public Disciplina(String codigo) {
        this.codigo = codigo;
        this.professores = new ArrayList<>();
    }

    public Disciplina(String nome, ArrayList<Professor> professores, String codigo) {
        this.nome = nome;
        this.professores = professores;
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(ArrayList<Professor> professores) {
        this.professores = professores;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String toString() {
        return "Codigo: " + codigo + "\nNome: " + nome
                + "\nProfessores: " + professores;
    }

    public void inserir(Connection conn) {
        String sqlDisc = "INSERT INTO disciplina (codigo, nome) VALUES (?, ?)";
        String sqlRel = "INSERT INTO disciplina_professor (codigo_disciplina, matricula_professor) VALUES (?, ?)";
        try {
            try (PreparedStatement ps = conn.prepareStatement(sqlDisc)) {
                ps.setString(1, codigo);
                ps.setString(2, nome);
                ps.executeUpdate();
            }
            if (professores != null) {
                try (PreparedStatement ps = conn.prepareStatement(sqlRel)) {
                    for (Professor p : professores) {
                        ps.setString(1, codigo);
                        ps.setString(2, p.getMatricula());
                        ps.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao inserir disciplina: " + e.getMessage());
        }
    }

    public void alterar(Connection conn) {
        String sqlDisc = "UPDATE disciplina SET nome = ? WHERE codigo = ?";
        String sqlDelRel = "DELETE FROM disciplina_professor WHERE codigo_disciplina = ?";
        String sqlInsRel = "INSERT INTO disciplina_professor (codigo_disciplina, matricula_professor) VALUES (?, ?)";
        try {
            try (PreparedStatement ps = conn.prepareStatement(sqlDisc)) {
                ps.setString(1, nome);
                ps.setString(2, codigo);
                ps.executeUpdate();
            }
            try (PreparedStatement ps = conn.prepareStatement(sqlDelRel)) {
                ps.setString(1, codigo);
                ps.executeUpdate();
            }
            if (professores != null) {
                try (PreparedStatement ps = conn.prepareStatement(sqlInsRel)) {
                    for (Professor p : professores) {
                        ps.setString(1, codigo);
                        ps.setString(2, p.getMatricula());
                        ps.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao alterar disciplina: " + e.getMessage());
        }
    }

    public void excluir(Connection conn) {
        String sqlDelRel = "DELETE FROM disciplina_professor WHERE codigo_disciplina = ?";
        String sqlDelDisc = "DELETE FROM disciplina WHERE codigo = ?";
        try {
            try (PreparedStatement ps = conn.prepareStatement(sqlDelRel)) {
                ps.setString(1, codigo);
                ps.executeUpdate();
            }
            try (PreparedStatement ps = conn.prepareStatement(sqlDelDisc)) {
                ps.setString(1, codigo);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao excluir disciplina: " + e.getMessage());
        }
    }

    public void carregar(Connection conn) {
        String sqlDisc = "SELECT nome FROM disciplina WHERE codigo = ?";
        String sqlRel = "SELECT matricula_professor FROM disciplina_professor WHERE codigo_disciplina = ?";
        try {
            try (PreparedStatement ps = conn.prepareStatement(sqlDisc)) {
                ps.setString(1, codigo);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        this.nome = rs.getString("nome");
                    }
                }
            }
            this.professores = new ArrayList<>();
            try (PreparedStatement ps = conn.prepareStatement(sqlRel)) {
                ps.setString(1, codigo);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        Professor p = new Professor(rs.getString("matricula_professor"));
                        p.carregar(conn);
                        this.professores.add(p);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao carregar disciplina: " + e.getMessage());
        }
    }
}
