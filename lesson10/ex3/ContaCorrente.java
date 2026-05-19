/**
 * A classe ContaCorrente tem os atributos numero e digito,
 * ambos int, o atributo agencia do tipo Agencia e o atributo
 * saldo do tipo double. Crie um construtor que receba os
 * atributos como parâmetros e os métodos de acesso e os
 * modificadores. Crie também o método depositar() que receba
 * um parâmetro double e aumente o saldo. Crie também um
 * método sacar() que receba um parâmetro double e diminua o
 * saldo.
 *
 * A conta não pode ficar negativa. Neste caso, dê uma mensagem
 * que o saque não foi efetuado e retorne zero. Caso contrário,
 * retorne o valor sacado. Crie um método consultarSaldo() que
 * retorne o saldo e um imprimirSaldo() que imprima o número da
 * conta com dígito, o número da agência com dígito e o saldo.
 *
 * O número da conta deve ter no máximo 4 dígitos positivos. O
 * dígito é validado a partir do algoritmo de módulo 11.
 *
 * CRUD: persistir apenas numero (pk) e digito.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaCorrente {
    private int numero;
    private int digito;
    private Agencia agencia;
    private double saldo;

    public ContaCorrente(int numero, Agencia agencia, double saldo) {
        setNumero(numero);
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero <= 0 || numero > 9999) {
            throw new IllegalArgumentException("O numero da conta deve ter no maximo 4 digitos e ser positivo.");
        }
        this.numero = numero;
        this.digito = Utils.calcularDigito(numero);
    }

    public int getDigito() {
        return digito;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public double sacar(double valor) {
        if (this.saldo - valor < 0) {
            System.out.println("Saque nao efetuado: saldo insuficiente.");
            return 0;
        }
        this.saldo -= valor;
        return valor;
    }

    public double consultarSaldo() {
        return saldo;
    }

    public void imprimirSaldo() {
        System.out.println("--------------------------------");
        System.out.println("Conta: " + numero + "-" + digito);
        if (agencia != null) {
            System.out.println("Agencia: " + agencia.getNumero() + "-" + agencia.getDigito());
        }
        System.out.println("Saldo: " + saldo);
        System.out.println("--------------------------------");
    }

    public String toString() {
        return "Numero: " + numero + "-" + digito + "\nAgencia: " + agencia
                + "\nSaldo: " + saldo;
    }

    public void inserir(Connection conn) {
        String sql = "INSERT INTO conta_corrente (numero, digito) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numero);
            ps.setInt(2, digito);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao inserir conta corrente: " + e.getMessage());
        }
    }

    public void atualizar(Connection conn) {
        String sql = "UPDATE conta_corrente SET digito = ? WHERE numero = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, digito);
            ps.setInt(2, numero);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar conta corrente: " + e.getMessage());
        }
    }

    public void excluir(Connection conn) {
        String sql = "DELETE FROM conta_corrente WHERE numero = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numero);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erro ao excluir conta corrente: " + e.getMessage());
        }
    }

    public void carregar(Connection conn) {
        String sql = "SELECT digito FROM conta_corrente WHERE numero = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, numero);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    this.digito = rs.getInt("digito");
                }
            }
        } catch (SQLException e) {
            System.err.println("Erro ao carregar conta corrente: " + e.getMessage());
        }
    }
}
