package controller;

import model.Author;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/author")
public class AuthorController {


    Map<Integer, Author> authorMap = new HashMap<>();
    AtomicInteger authorId = new AtomicInteger();


    @PostMapping()
    public ResponseEntity<Author> createNewAuthor(@RequestBody Author author){

        author.setId(authorId.incrementAndGet());
        authorMap.put(author.getId(), author);

        return ResponseEntity.ok(author);
    }


    @GetMapping()
    public ResponseEntity<Map<Integer, Author>> getAllAuthor(){

        if(authorMap.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(authorMap);
    }

}
