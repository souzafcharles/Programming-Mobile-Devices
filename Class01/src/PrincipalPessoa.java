public class PrincipalPessoa {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("123", "Balthazar", 2,1);
        Pessoa p2 = new Pessoa("456", "Ophélia", 1,2);
        System.out.println(p1.getCpf());
        p1.setCpf("789");
        System.out.println(p1.getCpf());
        if("789".compareTo(p1.getCpf())==0){
            System.out.println("Teste realizado com sucesso!");
        }else{
            System.out.println("Teste falhou");
        }
    }
}
