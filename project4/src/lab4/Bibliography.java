package lab4;

import java.util.Scanner;

public class Bibliography {
	public static void main(String[] args) {
		String s1 = "Dijkstra, Edsger#Go To Statement Considered Harmful#Communications of the ACM#1968#11";
		String s2 = "Levoy, Marc#Display of Surfaces from Volume Data#IEEE Computer Graphics and Applications#1988#8";
		String s3 = "Dean, Jeffrey; Ghemawat, Sanjay#MapReduce: Simplified Data Processing on Large Clusters#Communications of the ACM#2008#51";
		
		BibItem item1 = myHelperMethod(s1);
		System.out.println(item1);
		BibItem item2 = myHelperMethod(s2);
		System.out.println(item2);
		BibItem item3 = myHelperMethod(s3);
		System.out.println(item3);
	}

	private static BibItem myHelperMethod(String s) {
		Scanner parse = new Scanner(s);
		parse.useDelimiter("#");
		String author = parse.next();
		String title = parse.next();
		String journal = parse.next();
		int year = parse.nextInt();
		int volume = parse.nextInt();

		return new BibItem(author, title, journal, year, volume);
		// parse the given string s and return a new BibItem
	}
}
