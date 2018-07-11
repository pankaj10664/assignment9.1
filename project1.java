package project;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
 class Prince {

	public static void FilesCheck(String path,ArrayList<File> a1) throws IOException{
		File file21 = new File(path);
		File[] f = file21.listFiles();
		try {
		for(File file:f) {
			if(file.isFile()) {
				a1.add(file);
			}
			else if(file.isDirectory())
			{
				FilesCheck(file.getAbsolutePath() , a1);
			}
		} 
	} catch(Exception e) {
		return;
	}
	}
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		File file = new File("C:\\Users\\hp\\eclipse-workspace\\File Handling Project\\src\\project\\abc.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		System.out.println("Enter path for which you wish to know the files (use double backslashes i.e. \\)" );
		String str1 = sc.nextLine();
		System.out.println("Enter path where you want to store the file having names and paths of files (use double backslashes i.e. \\\\)");
		String str2 = sc.nextLine();
		sc.close();
		FileWriter w = new FileWriter(file);
		BufferedWriter out = new BufferedWriter(w);
		out.write(str1);
		out.newLine();
		out.write(str2);
		out.close();
		ArrayList <File> a = new ArrayList<File>();
		FilesCheck(str1,a);
		File file1 = new File(str2);
		FileWriter w1 = new FileWriter(file1, true);
		for(int i = 0 ; i < a.size() ; i++ )
		{
			w1.write("Name: " + a.get(i).getName() + " , " + a.get(i).getAbsolutePath() + "\n");
		}
		w1.flush();
		w1.close();
		FileReader fr = new FileReader(str2);
		int c;
		while((c = fr.read()) != -1) {
			System.out.print((char) c);
		}
		fr.close();
	}

}