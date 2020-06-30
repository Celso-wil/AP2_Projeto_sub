import arvore.ArvoreBinaria;
import bfs.BuscaPorProfundidade;
import dfs.BuscaPorNivel;
import dijkstra.Dijkstra;
import heapsort.Heapsort;
import java.util.Scanner;

public class Principal {
    private static final int arad = 0;
    private static final int bucharest = 1;
    private static final int craiova = 2;
    private static final int dobreva = 3;
    private static final int eforie = 4;
    private static final int fagaras = 5;
    private static final int giurgiu = 6;
    private static final int hisova = 7;
    private static final int lasi = 8;
    private static final int lugoj = 9;
    private static final int mehandia = 10;
    private static final int neamf = 11;
    private static final int orades = 12;
    private static final int pitesti = 13;
    private static final int rimnicu_vikea = 14;
    private static final int sibiu = 15;
    private static final int timisoara = 16;
    private static final int urziceni = 17;
    private static final int vaslui = 18;
    private static final int zerind = 19;

    public static void main(String[] args) {
        int i;
        Scanner s = new Scanner(System.in);
        System.out.print("Digite:\n para escolher HeapSort --> 1"
                + "\n para escolher Arvore Binaria --> 2"
                + "\n para escolher Busca por profundidade --> 3"
                + "\n para escolher Busca por nivel --> 4"
                + "\n para escolher Dijkstra --> 5"
                + "\n -> ");
        i = s.nextInt();


        if (i==1) {
            System.out.println("você escolheu HeapSort ");

            System.out.print("tamanho do vetor -> ");
            int tamanho = s.nextInt();
            int[] A = new int[tamanho];
            for (int j = 0; j < tamanho; ) {
                System.out.print(" um valor aleatorio -> ");
                A[j] = s.nextInt();
                j++;
            }
            Heapsort.sort(A);
            for (int val : A) {
                System.out.print("(" + val + ") ");
            }

        }
            if(i==2) {
                System.out.println("você escolheu Arvore Binaria ");
                String x;
                String y;
                String z;
                ArvoreBinaria a = new ArvoreBinaria("A");
                while (true) {
                    System.out.println("nomeie o nó pai -> ");
                    x = s.nextLine();
                    System.out.println(" nomeie o nó filho -> ");
                    y = s.nextLine();
                    System.out.print("para inserir nó a esquerda digite (e)\n" +
                            "para inserir o nó a direwita digite (d)\n" +
                            "-> ");
                    z = s.nextLine();
                    switch (z) {
                        case "e":
                            a.AdicionarNo(x, y, ArvoreBinaria.ModoRL.esquerda);
                            break;
                        case "d":
                            a.AdicionarNo(x, y, ArvoreBinaria.ModoRL.direita);
                            break;
                    }
                    System.out.println("--------------");
                    System.out.println(a.PreOrdem());

                }

            }
            if(i==3){
                System.out.println("você escolheu Busca por profundidade ");
                System.out.print("Digite o Tamanho do vetor -> ");
                int q = s.nextInt();
                BuscaPorNivel D = new BuscaPorNivel(q+1);
                for (int cont = 0; cont < q; ) {
                    System.out.print(" vertice pai -> ");
                    int pai2 = s.nextInt();
                    System.out.print(" vertice filho -> ");
                    int filho2 = s.nextInt();
                    D.adicionaAresta(pai2, filho2);
                    cont++;
                }
                System.out.println(D.toString());
                while (true) {
                    System.out.print("vertice inicial -> ");
                    int y1 = s.nextInt();
                    System.out.print(" o vertice final -> ");
                    int y2 = s.nextInt();
                    System.out.println(D.getCaminho(y1, y2));
                    System.out.println("quantidade de passos foi "  + D.cont() );
                    D.resetcont();
                }

            }
            if(i==4){
                System.out.println("você escolheu Busca por nivel ");

                System.out.print(" Tamanho do vetor -> ");
                int t = s.nextInt();
                BuscaPorProfundidade v = new BuscaPorProfundidade(t+1);
                for (int cont = 0; cont < t; ) {
                    System.out.print(" vertice pai -> ");
                    int pai = s.nextInt();
                    System.out.print(" vertice filho -> ");
                    int filho = s.nextInt();
                    v.adicionaAresta(pai, filho);
                    cont++;
                }
                System.out.println(v.toString());
                while (true) {
                    System.out.print(" vertice inicial -> ");
                    int x1 = s.nextInt();
                    System.out.print(" vertice final -> ");
                    int x2 = s.nextInt();
                    System.out.println("O menor caminho  --> " + v.getMenorCaminho(x1, x2));
                    System.out.println("quantidade de passos foi --> "  + v.cont());
                    v.resetcont();
                }


            }
            if(i==5){
                System.out.println(" você escolheu Dijkstra");

                Dijkstra d = new Dijkstra(20);
                d.distancia(orades, sibiu, 151);
                d.distancia(orades, zerind, 71);
                d.distancia(zerind, arad, 75);
                d.distancia(arad, sibiu, 140);
                d.distancia(arad, timisoara, 118);
                d.distancia(timisoara, lugoj, 111);
                d.distancia(lugoj, mehandia, 70);
                d.distancia(mehandia, dobreva, 75);
                d.distancia(dobreva, craiova, 120);
                d.distancia(craiova, pitesti, 138);
                d.distancia(craiova, rimnicu_vikea, 146);
                d.distancia(rimnicu_vikea, sibiu, 80);
                d.distancia(sibiu, fagaras, 99);
                d.distancia(fagaras, bucharest, 211);
                d.distancia(pitesti, bucharest, 101);
                d.distancia(bucharest, giurgiu, 90);
                d.distancia(bucharest, urziceni, 85);
                d.distancia(urziceni, hisova, 98);
                d.distancia(urziceni, vaslui, 142);
                d.distancia(vaslui, lasi, 92);
                d.distancia(lasi, neamf, 87);
                d.distancia(hisova, eforie, 86);
                d.distancia(rimnicu_vikea, pitesti, 97);
                while (true) {
                    System.out.println("\n------------------------------------");
                    System.out.println( "arad = 1 \n" +
                            "bucharest = 2\n" +
                            "craiova = 3\n"+
                            "dobreva = 4 \n" +
                            "eforie = 5\n" +
                            "fagaras = 6 \n" +
                            "giurgiu = 7\n" +
                            "hisova = 8\n" +
                            "lasi = 9\n" +
                            "lugoj = 10\n" +
                            "mehandia = 11\n" +
                            "neamf = 12\n" +
                            "orades = 13\n" +
                            "pitesti = 14\n" +
                            "rimnicu vikea = 15\n" +
                            "sibiu = 16\n" +
                            "timisoara = 17\n" +
                            "urziceni = 18\n" +
                            "vaslui = 19\n"+
                            "zerind = 20\n");
                    System.out.println("\n------------------------------------");
                    System.out.print("digite o codigo da cidade inicial (de 1 a 20) --> ");
                    int origem = s.nextInt() - 1;
                    System.out.print("Digite o código da cidade final (de 1 a 20) --> ");
                    int destino = s.nextInt() - 1;
                    System.out.println("Menor caminho-->");
                    for (Integer cidade : d.caminho(origem, destino)) {
                        System.out.print((cidade + 1) + " --> ");
                    }

        }
    }
}
}