package com.ociweb.cuke.example1;

public class HelloWorld {

	private String name;
	
	public HelloWorld(){
		this("World");
	}
	
	public HelloWorld(String name) {
		this.name = name;
	}

	public String sayHi() {
		return "Hello " + name + "!";
	}
}
