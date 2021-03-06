package com.rest.app;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value="/book")
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBookRecords(){
        return bookRepository.findAll();
    }
    
    @GetMapping(value = "{bookId}")
    public Book getBookById(@PathVariable(value="bookId") Long bookId){
        return bookRepository.findById(bookId).get();
    }

    @PostMapping
    public Book createBookRecord(@RequestBody @Valid Book bookRecord){
        return bookRepository.save(bookRecord);
    }

    @PutMapping
    public Book updateBookRecord(@RequestBody @Valid Book bookRecord) throws NotFoundException {
        if(bookRecord == null || bookRecord.getBookId() == null) {
            throw new NotFoundException("Book with ID " + bookRecord.getBookId() + " does not exists");
        }
        Optional<Book> optionalBook = bookRepository.findById(bookRecord.getBookId());
        Book existingBookRecord = optionalBook.get();
        existingBookRecord.setName(bookRecord.getName());
        existingBookRecord.setSummary(bookRecord.getSummary());
        existingBookRecord.setRating(bookRecord.getRating());

        return bookRepository.save(existingBookRecord);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBookById(@PathVariable("bookId") Long id) throws NotFoundException{
        if(!bookRepository.findById(id).isPresent()){
            throw new NotFoundException("ID " + id +  " not found");
        }
        bookRepository.deleteById(id);
    }
}
