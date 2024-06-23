package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.crud.model.Books;
import com.crud.service.BookService;

@RestController
public class HomeController {

//	@RequestMapping(value="/v",method = RequestMethod.GET)
//	@ResponseBody
//	public String getBook() {
//		
//		return "THIS DEMO.";
//	}
	
//	@RequestMapping(value="/v",method = RequestMethod.GET)
//	public Books getBook() {
//		
//		Books bk=new Books();
//		bk.setId(1);
//		bk.setTitle("NEW K");
//		bk.setAuthor("GVS");
//		
//		return bk;
//	}
	
	@Autowired
	private BookService bs;
	
	//getAllBooks
	@RequestMapping(value="/v1",method = RequestMethod.GET)
	public List<Books> getAllBooks() {
		
		//List<Books> allBooks = bs.getAllBooks();
		
		return this.bs.getAllBooks();
	}
	
	//getsinglebook	
	@RequestMapping(value="/v1/{id}",method = RequestMethod.GET)
	public Books getSingleBooks(@PathVariable("id") int id) {
		
		
		return this.bs.getBookById(id);
	}
	//addd book
	@RequestMapping(value="/v1",method = RequestMethod.POST)
	public Books addBooks(@RequestBody Books b) {
		
	Books bk= this.bs.addBooks(b);
	
	return bk;
	}
	
	//delete Book
	@RequestMapping(value="/v1/del/{id}",method = RequestMethod.DELETE)
	public List<Books> deleteBook(@PathVariable int id){
		
	  return	this.bs.deleteBook(id);
	}
	
	//update book
	@RequestMapping(value="/v1/up/{id}", method = RequestMethod.PUT)
	public Books updateBooks(@RequestBody Books book,@PathVariable int id) {
	return	this.bs.updateBook(book, id);
	}
	
	
}
