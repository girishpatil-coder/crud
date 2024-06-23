package com.crud.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.crud.model.Books;

@Component
public class BookService {

	private static  List<Books> list =new ArrayList<Books>();
	
	static {
		
		list.add(new Books(1, "abcA", "abc1"));
		list.add(new Books(2, "abc", "abc2"));
		list.add(new Books(3, "abcd", "abc3"));
	}
	
	//get ALl books
	public List<Books> getAllBooks(){
		
		return list;
	}
	
	//get signle book
	public Books getBookById(int id) {
		Books books = list.stream().filter(e->e.getId()==id).findFirst().get();
		
		return books;
	}
	
	//add books
	public Books addBooks(Books b) {
		list.add(b);
		return b;
	}
	
	//delete book
	public List<Books> deleteBook(int id){
		
//		list.stream().filter(			
//				e->{if(e.getId()!=id) {			
//			return true;
//		}else {
//			return false;
//		}
//			
//		}).collect(Collectors.toList());
		
		list=list.stream().filter(e->e.getId()!=id).collect(Collectors.toList());
		
		return list;
	}
	
	
	//update list
	
	public Books updateBook(Books book,int id) {
		System.out.println(book);
		list =list.stream().map(b->{
			if(b.getId()==id) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
			}
			return b;
		}).collect(Collectors.toList());
		System.out.println(list);
		//return list;
		return book;
	}
}
