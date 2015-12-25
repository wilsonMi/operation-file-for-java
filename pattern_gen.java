import java.io.*;


public class pattern_gen{
	public static void main(String[] args){
		
		try{
			
			String read_from_file = null;
			String str_temp = null;
			String command = null;
			String addr = null;
			String data = null;
			
			
			FileReader fr = new FileReader("test.txt");
			BufferedReader br = new BufferedReader(fr);  

			FileOutputStream out=new FileOutputStream("test1.txt");
            PrintStream p=new PrintStream(out);


			//先写固定四行
			str_temp = "5b017000000000080";
			p.println(str_temp);
			str_temp = "60000000000000010";
			p.println(str_temp);
			str_temp = "5b017002400000006";
			p.println(str_temp);
			str_temp = "60000000000000010";
			p.println(str_temp);
			//
			
			
			read_from_file = br.readLine(); 
			while(read_from_file!=null){
				System.out.println(read_from_file);	
				command = read_from_file.substring(0,5);
				
				System.out.println("cut_words is : "+command);	
				
				if(command.equals("write")){
				//write command	
				System.out.println("write command!");
				str_temp = "5b0170010000000f0";
				p.println(str_temp);
				str_temp = "60000000000000010";
				p.println(str_temp);
				
				//addr 15:8
				p.println("5b0170010000000"+read_from_file.substring(8,10));
				p.println("60000000000000010");
				
				//addr 7:0
				p.println("5b0170010000000"+read_from_file.substring(10,12));
				p.println("60000000000000010");
				
				//data 31:24
				p.println("5b0170010000000"+read_from_file.substring(15,17));
				p.println("60000000000000010");
				
				//data 23:16
				p.println("5b0170010000000"+read_from_file.substring(17,19));
				p.println("60000000000000010");
				
				//data 15:8
				p.println("5b0170010000000"+read_from_file.substring(19,21));
				p.println("60000000000000010");
				
				//data 7:0
				p.println("5b0170010000000"+read_from_file.substring(21,23));
				p.println("60000000000000010");
				
				p.println("5b017001800008d03");

				
					
				}else if(command.equals("delay")){
				//delay command	
				System.out.println("delay command!");	
				
				p.println("600000000000"+read_from_file.substring(6,11));	
					
					
				}else{
					System.out.println("error : unknown command!");
					
				}
				
				
				read_from_file = br.readLine(); 
				
			}





			
			//String str2 = br.readLine();   
			//while (str2 != null) {      
			//System.out.println(str2);
			//p.println(str2);
			//str2 = br.readLine();
			//} 
			
			br.close();   
			fr.close();    		
		}
		catch(IOException e){
			
			System.out.println("file don't find!");
		}
		
			
	}
}


