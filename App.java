public class App {
    public static void main(String[] args) {
        int[] resultado = Troco.troco(287);
        if (resultado != null) {
            int[] C = {100, 50, 20, 10, 5, 2, 1};
            for (int i = 0; i < resultado.length; i++) {
                System.out.println("Cédula " + C[i] + ": " + resultado[i]);
            }
        }
    }
}
