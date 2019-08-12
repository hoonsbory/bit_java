package NewBook;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class BookMgr {
	//Book[] 관리 
	List<Book> list = null;
	String fileName;
	
	BookMgr(){
		this("book.dat");
	}
	BookMgr(String fileName){
		this.fileName = fileName;
		list = (List<Book>) MyFile.load(fileName);
		if(list == null) {
			list = new ArrayList<Book>();
		}
	}
	
	//CURD
	
	public void add(Book data) {
		list.add(data);
	}
	
	public List<Book> getBookList() {
		return list;
	}
	
	
	public void save() {
		MyFile.save(fileName, list);
	}
}















