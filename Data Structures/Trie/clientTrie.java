/* Jordan Brengman
	ENGR 143
	Final */


public class clientTrie {

    public static void main(String[] args) {
	 
        Trie t = new Trie();
		  
        t.add("app");
        t.add("apple");
        t.add("appled");		  
        t.add("one");
        t.add("two");
        t.add("three");
        t.add("four");
        t.add("five");
        t.add("six");
        t.add("seven");
        t.add("all");
        t.add("good");
        t.add("coders");
        t.add("go");
        t.add("to");
        t.add("heaven");
        t.printWords();
		  
		  System.out.println("***********");
		  // wordCount and contains
		  System.out.println("word count: " + t.wordCount() + " expects 16");
		  System.out.println("contains \"a\": " + t.contains("a") + " expects false");
		  System.out.println("contains \"app\": " + t.contains("app") + " expects true");
		  System.out.println("contains \"appl\": " + t.contains("appl") + " expects false");
		  System.out.println("contains \"apple\": " + t.contains("apple") + " expects true");
		  System.out.println("contains \"appled\": " + t.contains("appled") + " expects true");
		  System.out.println("contains \"apples\": " + t.contains("apples") + " expects false");
		  System.out.println("contains \"good\": " + t.contains("good") + " expects true");
		  System.out.println("contains \"go\": " + t.contains("go") + " expects true");
		  System.out.println("contains \"one\": " + t.contains("one") + " expects true");
		  System.out.println("contains \"two\": " + t.contains("two") + " expects true");
		  System.out.println("contains \"three\": " + t.contains("three") + " expects true");
		  
		  System.out.println("************");
		  // remove
		  t.remove("go");
		  t.remove("appled");
		  t.remove("one");
		  t.remove("two");
		  t.remove("three");
		  t.remove("four");
		  t.remove("five");
		  t.remove("six");
		  t.remove("seven");
		  t.remove("thiswordisnotinthetrie");
		  
		  System.out.println("Remove the words: go, appled, one, two, three, four, five, " +
		  		"six, seven, thiswordisnotinthetrie\n");
		  t.printWords();
		  System.out.println("\nexpects\n\nall\napp\napple\ncoders\ngood\nheaven\nto");
		  
		  System.out.println("***********");
		  // wordCount and contains after remove
		  System.out.println("word count: " + t.wordCount() + " expects 7");
		  System.out.println("contains \"a\": " + t.contains("a") + " expects false");
		  System.out.println("contains \"app\": " + t.contains("app") + " expects true");
		  System.out.println("contains \"appl\": " + t.contains("appl") + " expects false");
		  System.out.println("contains \"apple\": " + t.contains("apple") + " expects true");
		  System.out.println("contains \"appled\": " + t.contains("appled") + " expects false");
		  System.out.println("contains \"apples\": " + t.contains("apples") + " expects false");
		  System.out.println("contains \"good\": " + t.contains("good") + " expects true");
		  System.out.println("contains \"go\": " + t.contains("go") + " expects false");
		  System.out.println("contains \"one\": " + t.contains("one") + " expects false");
		  System.out.println("contains \"two\": " + t.contains("two") + " expects false");
		  System.out.println("contains \"three\": " + t.contains("three") + " expects false");
		  
		  
    }
}

