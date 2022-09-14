package br.com.td4u.langapi;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

public class LangController {

        // private List<Linguagem> linguagens =
        // List.of(
        //     new Linguagem("Java", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/java/java_256x256.png?raw=true", 2),
        //     new Linguagem("JS", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/javascript/javascript_256x256.png?raw=true", 1),
        //     new Linguagem("PHP", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/php/php_256x256.png?raw=true", 5)
        //     );

    @Autowired
    private LinguagemRepository repositorio;

    public LangController(LinguagemRepository repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/lang")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll();
        System.out.println("Codigo chamou");
        return linguagens;
    }

//    @GetMapping("/lang")
//    public List<Linguagem> obterLista() {
//        List<Linguagem> linguagens =
//         List.of(
//             new Linguagem("Java", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/java/java_256x256.png?raw=true", 2),
//             new Linguagem("JS", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/javascript/javascript_256x256.png?raw=true", 1),
//             new Linguagem("PHP", "https://github.com/abrahamcalf/programming-languages-logos/blob/master/src/php/php_256x256.png?raw=true", 5)
//            );
//        return linguagens;
//    }

    @PostMapping("/lang")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }


    @GetMapping(value = "/")
    public String processaInit(){
        return "<p><h1>Its RUNNING!</h1><h3>get http://localhost:8080/lang ou Post http://localhost:8080/lang with Postman </h3></p>";
    }

}
