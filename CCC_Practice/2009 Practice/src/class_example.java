import java.util.ArrayList;

public class class_example {

	public static void main(String[] args) {
		
		Person baba1 = new Person("Stanka", 60, null, null);
		Person baba2 = new Person("Stankaka", 60, null, null);
		Person dyadu1 = new Person("Djudu", 60, null, null);
		Person dyadu2 = new Person("Djududu", 60, null, null);
		Person mama = new Person("Mama", 40, baba1, dyadu1);
		Person dada = new Person("Dada", 40, baba2, dyadu2);
		Person chris = new Person("Chris", 20, mama, dada);
		Person alex = new Person("Alex", 20, mama, dada);
		
		System.out.println(alex.getAll());
		
	}
	
	public static class Person {
		
		String name;
		int age;
		Person mom;
		Person dad;
		
		public Person(String name, int age, Person mom, Person dad){
			this.name = name;
			this.age = age;
			this.dad = dad;
			this.mom = mom;			
		}
		
		public ArrayList<Person> getGrands(){
			ArrayList<Person> grands = new ArrayList<Person>();
			grands.add(this.mom.mom);
			grands.add(this.mom.dad);
			grands.add(this.dad.mom);
			grands.add(this.dad.dad);
			return grands;
			
		}
		
		public String toString(){
			return this.name+" is "+this.age+" years old.";
		}
		
		public ArrayList<Person> getAll(){
			ArrayList<Person> all = new ArrayList<Person>();
			all.add(this);
			if (this.mom != null){
				all.addAll(this.mom.getAll());
			}
			if (this.dad != null){
				all.addAll(this.dad.getAll());
			}
			
			return all;
			
		}
		
	}

}
