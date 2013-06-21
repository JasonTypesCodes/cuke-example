package com.ociweb.cuke.example1;

public class HelloWorld {

	private String greeting;
	private String name;
	
	public HelloWorld(){
		this("World");
	}
	
	public HelloWorld(String name) {
		this("Hello", name);
	}

	public HelloWorld(String greeting, String name) {
		this.greeting = greeting;
		this.name = name;
	}

	public String sayHi() {
		return greeting + " " + name + "!";
	}
}
