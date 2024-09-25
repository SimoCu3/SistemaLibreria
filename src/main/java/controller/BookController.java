package controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import model.Book;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/book")
public class BookController {

    Map<Integer, Book> bookMap = new HashMap<>();
    AtomicInteger bookId = new AtomicInteger();


    @PostMapping()
    public ResponseEntity<Book> createNewBook (@RequestBody Book book){

        book.setId(bookId.incrementAndGet());
        bookMap.put(book.getId(), book);

        return ResponseEntity.ok(book);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable("id")int id){
        if(bookMap.containsKey(id)){
            return ResponseEntity.ok(bookMap.get(id));
        }

        return ResponseEntity.status(404).body("Book not found");
    }

    @GetMapping()
    public ResponseEntity<Map<Integer, Book>> getAllBook(){

        if(bookMap.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(bookMap);
    }


    @PatchMapping("/book-name/{id}")
    public ResponseEntity<?> updateBookTitle(@PathVariable("id")int id, @PathVariable("name") String title){
        if(bookMap.containsKey(id)){
            Book book = bookMap.get(id);
            book.setTitle(title);
            return ResponseEntity.ok(book);
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteBookById(@PathVariable("id")int id){
        bookMap.remove(id);

        return ResponseEntity.ok(true);
    }

}
