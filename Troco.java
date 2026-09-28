public class Troco {

    public static int[] troco(int n) {

        int[] C = {100, 50, 20, 10, 5, 2, 1};
        int[] S = new int[C.length];

        int s = 0;

        int iteracoes = 0;
        int instrucoes = 0;

        while (s != n) {
            instrucoes++; // comparação: s != n
            iteracoes++;  // uma iteração do while

            int x = 0;
            instrucoes++; // atribuição x = 0

            for (int i = 0; i < C.length; i++) {
                instrucoes++; // comparação i < C.length
                iteracoes++;  // uma iteração do for

                instrucoes++; // comparação do if
                if (s + C[i] <= n) {

                    x = C[i];
                    instrucoes++;

                    S[i]++;
                    instrucoes++;

                    s += x;
                    instrucoes++;

                    break;
                }

                instrucoes++; // i++
            }

            instrucoes++; // comparação x == 0
            if (x == 0) {
                System.out.println("Não foi encontrada uma solução");

                System.out.println("Iterações: " + iteracoes);
                System.out.println("Instruções: " + instrucoes);

                return null;
            }
        }

        instrucoes++; // última comparação do while: s != n

        System.out.println("Iterações: " + iteracoes);
        System.out.println("Instruções: " + instrucoes);

        return S;
    }
}