package ma.enset.keynoteprojet.web;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repositories.ProductRepository;
import ma.enset.keynoteprojet.entities.Keynote;
import ma.enset.keynoteprojet.repositories.KeyNoteRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@AllArgsConstructor

public class KeyNoteController {

    private KeyNoteRepository keyNoteRepository;

    @GetMapping("/products")
    @PreAuthorize("hasAuthority('ADMIN')")
    public List<Keynote> products(){
        return keyNoteRepository.findAll();
    }

    @GetMapping("/products/{id}")
    @PreAuthorize("hasAuthority('USER')")

    public Keynote getProducts(@PathVariable String id){
        return keyNoteRepository.findById(id).orElse(null);
    }
    @GetMapping("/auth")
    public Authentication authentication(Authentication authentication){
        return authentication;
    }
}
