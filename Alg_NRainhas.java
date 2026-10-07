import java.util.Stack;
import java.util.Vector;

public class Alg_NRainhas{
    public static void main(String[] args) {
        
    }

    public record Rainha(int linha, int coluna) {}

    public int nRainhas(int n){
        
        Stack <Rainha>pilha = new Stack<>();
        while (pilha.size()!= n) { //repeat para parar com n rainhas
            Rainha atual = new Rainha(0,0);
            for(int i =0;i<n;i++){ // percorre a linha
                for (Rainha r : pilha){ //for para validar as posicoes
                    int x = atual.linha - r.linha;
                    int y = atual.coluna - r.coluna;
                    int xPos = Math.abs(x);
                    int yPos = Math.abs(y);
                    if(r.coluna != atual.coluna && xPos!=yPos){// if posicao valida
                        pilha.push(atual);
                        atual.coluna=0;
                        atual.linha=i;
                        continue;
                    }
                    else{
                        if(pilha.empty()){
                            break;//para a busca 
                        }
                        else{
                            Rainha rar = pilha.pop();
                            atual.linha = atual.linha-1;
                            atual.coluna = rar.coluna+1;
                        }
                    }
                }
            }
        }
        return n;
    }
}