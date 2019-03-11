package gui_add;
import java.io.*;
import java.util.*;

public class Comment {
	
	public static void writeComment(){
		try {
		FileReader reader = new FileReader("F:\\Demo\\comment.txt");
		BufferedReader br = new BufferedReader(reader);   
		String str;
		while((str = br.readLine()) != null) {
			System.out.println(str);
		} 
		br.close();
		
		FileOutputStream file = new FileOutputStream("F:\\Demo\\comment.txt",true);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(file));
		Scanner input = new Scanner(System.in);
		String comment = input.nextLine();
		while(comment.equals("#") == false) {
			bw.write(comment);
			bw.flush();
			bw.newLine();
			comment = input.next();
		}
		
		bw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		writeComment();
	}

}
