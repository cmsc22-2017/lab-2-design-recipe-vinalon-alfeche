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
    
  Person perish(IPet noPet){
    return new Person(this.name, noPet, this.age);    
  }
  
}
// to represent a pet
interface IPet {

public boolean sameNamePet(String itsname);
 
}
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
    
  public boolean sameNamePet(String itsname){
    return this.name == itsname;
  }
}


//TEMPLATE
/*
  Fields:
  
  ...this.name				-- String
  ...this.kind				-- String
  ...this.longhaired -- boolean
  
  Methods:
  
  	boolean sameNamePet()	-- boolean
 */
 
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
    
  public boolean sameNamePet(String itsname){
    return this.name == itsname;
  }
}

//TEMPLATE
/*
Fields:

...this.name				-- String
...this.kind				-- String
...this.male  			-- boolean

Methods:

	boolean sameNamePet()	-- boolean
*/


class NoPet implements IPet{
  NoPet(){}
	
  public boolean sameNamePet(String itsname){
    return false;
  }
}



//Examples
class ExamplesIPet{
  ExamplesIPet(){}
	
  IPet toshio = new Dog ("Toshio", "Shih tzu", true);
  IPet jimmy = new Cat ("Jimmy", "Birman", false);
  IPet chaelle = new Cat ("Chaelle", "Persian", true);
  IPet kat = new Dog ("Kathleen","Golden Retriever", false);
  IPet deboy = new Dog ("Deboy", "Beagle", true);
  IPet deboys = new Cat ("Deboy", "Egyptian Mau", false);
	
  IPet noPet = new NoPet();
  Person nigell = new Person ("Nigell", jimmy, 29);
  Person jezza = new Person ("Jezza", toshio, 20);
  Person juril = new Person ("Juril", chaelle, 25);
  Person luke = new Person ("Luke", kat, 23);
  Person ryan = new Person ("Ryan", deboy, 30);
  Person marian = new Person ("Marian", deboys, 26);
  Person alyssa = new Person ("Alyssa", noPet, 27);
  Person may = new Person ("May", noPet, 27);
	
	
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
	
   boolean testsameNamePet(Tester t){
     return 
       t.checkExpect(deboy.sameNamePet("Deboy"), true) &&
       t.checkExpect(jimmy.sameNamePet("Deboy"), false);
     }
	
     boolean testperish(Tester t){
       return
         t.checkExpect(this.alyssa.perish(noPet), alyssa) &&
         t.checkExpect(this.may.perish(noPet), may);
     }
}

	
