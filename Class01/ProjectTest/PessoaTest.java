import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {
    private static Pessoa p1;

    @BeforeAll
    public static void inicializaObjeto(){
        p1 = new Pessoa("123", "Belizário", 2,1);
    }

    @Test
    @DisplayName("Testa o construtor e o getCpf")
    public void caseTest01(){
        assertEquals("123", p1.getCpf());
    }

    @Test
    @DisplayName("Testa o construtor e o getNome")
    public void caseTest02(){
        p1.setNome("Ophélia Birrenta");
        assertEquals("Ophélia Birrenta", p1.getNome());
    }

    @Test
    @DisplayName("Testa os métdos de acesso")
    public void casoTeste03(){
        p1.setNome("Renatinho");
        p1.setCpf("xpto");
        assertAll("descrição dos casos de test",
                () -> assertEquals("Renatinho",p1.getNome()),
                () -> assertEquals("xpto",p1.getCpf()),
                () -> assertEquals(2,p1.getMatricula()),
                () -> assertEquals(1,p1.getIdade())
        );
    }
}