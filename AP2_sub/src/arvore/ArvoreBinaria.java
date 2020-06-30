package arvore;

public class ArvoreBinaria {

    public enum ModoRL {
        esquerda, direita
    }

    private Node arvore;

    public Node getArvore() {
        return arvore; }

    public void setArvore(Node arvore) {
        this.arvore = arvore; }

    public ArvoreBinaria(String raiz){
        setArvore(new Node(raiz));
    }

    public void AdicionarNo(String noPai, String nomeNo, ModoRL modo){
        if (modo == ModoRL.direita) {
            AdicionarNoDireita(noPai, nomeNo);
        } else if (modo == ModoRL.esquerda) {
            AdicionarNoEsquerda(noPai, nomeNo);
        }
    }

    public void AdicionarNoEsquerda(String noPai, String nomeNo){
        Node no = findNode(getArvore(), noPai);
        if (no == null) { return; }
        no.setEsquerda(new Node(nomeNo));
    }

    public void AdicionarNoDireita(String noPai, String nomeNo){
        Node no = findNode(getArvore(), noPai);
        if (no == null) { return; }
        no.setDireita(new Node(nomeNo));
    }

    private Node findNode(Node no, String nome){
        if (no == null || nome == null || nome.isEmpty()) { return null; }
        if (no.getNome().equals(nome)) { return no; }
        Node noesquerda = findNode(no.getEsquerda(), nome);
        if (noesquerda != null) { return noesquerda; }
        return findNode(no.getDireita(), nome);
    }

    public String PreOrdem(){
        if (getArvore() == null) { return ""; }
        return readPreOrdem(getArvore());
    }

    private String readPreOrdem(Node no){
        if (no == null) {return "";}
        String rt = no.toString();
        if (no.getEsquerda() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readPreOrdem(no.getEsquerda());
        }
        if (no.getDireita() != null) {
            rt += (rt.isEmpty() ? "" : ",") + readPreOrdem(no.getDireita());
        }
        return rt;
    }

}
