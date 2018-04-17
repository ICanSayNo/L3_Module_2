import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

//Copyright 2018 (c)

public class Copyright {
	public static void main(String[] args) throws IOException {
		File f = new File("src/fileses");
		for (File e: f.listFiles()) {
			FileReader fr = new FileReader(e);
			if(e.getName().endsWith(".java")) {
				int c = fr.read();
				String file="";
				System.out.print(c);
				System.out.println(e.getName());
				while(c != -1){
					System.out.print((char)c);
					file = file + (char)c;
					c = fr.read();
				}
				if (!file.contains("//Copyright 2018 (c) Jeff The MemeLord")) {
					FileWriter fw = new FileWriter(e);
					file = "//Copyright 2018 (c) Jeff The MemeLord\n\n\n" + file;
					fw.write(file);
					fw.close();
				}
			}
			fr.close();
		}
	}
}
