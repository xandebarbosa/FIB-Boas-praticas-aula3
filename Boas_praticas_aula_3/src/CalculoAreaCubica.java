import javax.swing.JOptionPane;

public class CalculoAreaCubica {

    public static void main(String[] args) {
        // Solicita ao usuário para inserir os valores de altura, largura e comprimento
        double altura = obterNumero("Digite a altura do cubo:");
        double largura = obterNumero("Digite a largura do cubo:");
        double comprimento = obterNumero("Digite o comprimento do cubo:");

        // Valida se os valores são negativos
        if (altura < 0 || largura < 0 || comprimento < 0) {
            JOptionPane.showMessageDialog(null, "Os valores não podem ser negativos. A área cúbica é zero.");
        } else {
            // Calcula a área cúbica do cubo
            double areaCubica = altura * largura * comprimento;
            JOptionPane.showMessageDialog(null, "A área cúbica do cubo é: " + areaCubica);
        }
    }

    // Método para obter um número do usuário usando JOptionPane
    private static double obterNumero(String mensagem) {
        boolean entradaValida = false;
        double numero = 0;

        do {
            try {
                String input = JOptionPane.showInputDialog(mensagem);
                if (input == null) {
                    System.exit(0); // O usuário pressionou Cancelar ou fechou a janela
                }

                numero = Double.parseDouble(input);
                entradaValida = true;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, insira um número válido.");
            }
        } while (!entradaValida);

        return numero;
    }
}
