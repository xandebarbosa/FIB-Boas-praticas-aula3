import javax.swing.JOptionPane;

public class ValidaCPF {

    public static void main(String[] args) {
        ValidaCPF validador = new ValidaCPF();
        String cpf = JOptionPane.showInputDialog("Digite o CPF:");

        if (validador.isCPF(cpf)) {
            JOptionPane.showMessageDialog(null, "Número de CPF válido: " + validador.imprimeCPF(cpf));
        } else {
            JOptionPane.showMessageDialog(null, "Número de CPF inválido!");
        }
    }

    public boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
                || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
                || CPF.equals("99999999999") || (CPF.length() != 11)) {
            JOptionPane.showMessageDialog(null, "Número de CPF inválido!!!");
            return false;
        } else {
            return verificaDigitos(CPF);
        }
    }

    private boolean verificaDigitos(String CPF) {
        char dig10, dig11;
        int sm, i, r, num, peso;

        sm = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            num = Character.getNumericValue(CPF.charAt(i));
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        dig10 = (r == 10 || r == 11) ? '0' : (char) (r + '0');

        sm = 0;
        peso = 11;
        for (i = 0; i < 10; i++) {
            num = Character.getNumericValue(CPF.charAt(i));
            sm = sm + (num * peso);
            peso = peso - 1;
        }

        r = 11 - (sm % 11);
        dig11 = (r == 10 || r == 11) ? '0' : (char) (r + '0');

        // Verifica se os dígitos calculados conferem com os dígitos informados.
        return (dig10 == CPF.charAt(9) && dig11 == CPF.charAt(10));
    }

    public String imprimeCPF(String CPF) {
        return CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-"
                + CPF.substring(9, 11);
    }
}


