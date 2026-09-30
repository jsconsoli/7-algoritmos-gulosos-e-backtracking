public class Escalonamento {

    public static void main(String[] args) {

        int[] s = {4, 6, 13, 4, 2, 6, 7, 9, 1, 3, 9};
        int[] f = {8, 7, 14, 5, 4, 9, 10, 11, 6, 13, 12};

        // Ordena pelo tempo de término usando MergeSort
        mergeSort(s, f, 0, f.length - 1);

        // Executa o algoritmo guloso
        int[] v = sdm_Guloso(s, f, s.length);

        // Mostra resultado
        for (int i = 0; i < v.length; i++) {
            if(v[i]==1){
                System.out.println(
                    v[i] + " -> (" + s[i] + ", " + f[i] + ")"
                );
            }
        }
    }


    // =========================================================
    // MERGESORT
    // =========================================================

    public static void mergeSort(int[] s, int[] f, int inicio, int fim) {

        if (inicio < fim) {

            int meio = (inicio + fim) / 2;

            mergeSort(s, f, inicio, meio);
            mergeSort(s, f, meio + 1, fim);

            merge(s, f, inicio, meio, fim);
        }
    }


    // Junta as duas partes ordenadas
    public static void merge(
            int[] s,
            int[] f,
            int inicio,
            int meio,
            int fim) {

        int tamanho = fim - inicio + 1;

        int[] tempS = new int[tamanho];
        int[] tempF = new int[tamanho];

        int i = inicio;
        int j = meio + 1;
        int k = 0;

        // Compara os tempos de término
        while (i <= meio && j <= fim) {

            if (f[i] <= f[j]) {

                tempS[k] = s[i];
                tempF[k] = f[i];
                i++;

            } else {

                tempS[k] = s[j];
                tempF[k] = f[j];
                j++;
            }

            k++;
        }

        // Sobras da primeira metade
        while (i <= meio) {

            tempS[k] = s[i];
            tempF[k] = f[i];

            i++;
            k++;
        }

        // Sobras da segunda metade
        while (j <= fim) {

            tempS[k] = s[j];
            tempF[k] = f[j];

            j++;
            k++;
        }

        // Copia de volta
        for (k = 0; k < tamanho; k++) {

            s[inicio + k] = tempS[k];
            f[inicio + k] = tempF[k];
        }
    }


    // =========================================================
    // GULOSO
    // =========================================================

    public static int[] sdm_Guloso(int[] s, int[] f, int n) {

        int[] x = new int[n];

        // Primeira atividade é escolhida
        int i = 0;
        x[0] = 1;

        for (int k = 1; k < n; k++) {

            if (s[k] > f[i]) {

                x[k] = 1;
                i = k;
            }
        }

        return x;
    }
}