/*
 * Signature, Purpose, Stub
 		String, int -> boolean
 */

import tester.Tester;

// to represent a pet owner
class Person {
    String name;
    IPet pet;
    int age;
 
    Person(String name, IPet pet, int age) {
        this.name = name;
        this.pet = pet;
        this.age = age;
        
    }
    
    //Template
    /*
     * Fields: 
     		...this.age... -- int
     		
     		Methods:
     		this.isOlder(Person other) -- boolean
     		
     	-> boolean
     		returns true if this person is older than the other
     */

    boolean isOlder(Person other){
    	if (this.age > other.age){
    		return true;
    	}
    	else{
    		return false;
    	}
    }
}
// to represent a pet
interface IPet { }
 
// to represent a pet cat
class Cat implements IPet {
    String name;
    String kind;
    boolean longhaired;
 
    Cat(String name, String kind, boolean longhaired) {
        this.name = name;
        this.kind = kind;
        this.longhaired = longhaired;
    }
}
 
// to represent a pet dog
class Dog implements IPet {
    String name;
    String kind;
    boolean male;
 
    Dog(String name, String kind, boolean male) {
        this.name = name;
        this.kind = kind;
        this.male = male;
    }
}

//Examples
class ExamplesIPet{
	ExamplesIPet(){}
	
	IPet toshio = new Dog ("Toshio", "Shih tzu", true);
	IPet jimmy = new Cat ("Jimmy", "Birman", false);
	IPet chaelle = new Cat ("Chaelle", "Persian", true);
	IPet kat = new Dog ("Kathleen","Golden Retriever", false);
	
	Person nigell = new Person ("Nigell", jimmy, 29);
	Person jezza = new Person ("Jezza", toshio, 20);
	Person juril = new Person ("Juril", chaelle, 25);
	Person luke = new Person ("Luke", kat, 23);
	
	//Test and debug
	boolean testIsOlder (Tester t){
		return 
				t.checkExpect(nigell.isOlder(luke), true) &&
				t.checkExpect(jezza.isOlder(juril), false) &&
				t.checkExpect(juril.isOlder(nigell), false) &&
				t.checkExpect(juril.isOlder(luke), true)&&
				t.checkExpect(nigell.isOlder(jezza), true)&&
				t.checkExpect(luke.isOlder(jezza), true);
	}
}
