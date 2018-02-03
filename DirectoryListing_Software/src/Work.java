import java.io.*;
import java.util.*;
public class Work {
	public static void list(String Dir){
		File directory =new File(Dir);
		File[] filelist=directory.listFiles();
		for(File file : filelist){
			if(file.isFile()){
				System.out.println("File Name : "+file.getName()+"   Path : "+file.getPath());
			//	Files.add(file);
			}else if(file.isDirectory()){
				list(file.getAbsolutePath());
			}
		}
		
	}
	public static void main(String[] args) throws IOException{
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the path of file: ");
		String path=s.nextLine();
		File file = new File(path);
		FileReader f=null;
		String path1="";
		String path2="";
		//ArrayList<File> Files= new ArrayList<>;
		File res=new File(path2);
		FileWriter out= new FileWriter(res,true);
		try{
			int c;
			f= new FileReader(file);
			int count=0;
			while((c=f.read())!=10){
				if((c)==10)
				{
					count++;								//C:\Users\Happy Kohli\Desktop
				}if(count==0){
					path1=path1+(char)c;		
				}
					}
			System.out.print(path1);
		//	list(path1.substring(0,path1.length()-1));
			while((c=f.read())!=-1){
				path2=path2+(char)c;
			
			}
			
			
			
			
			
			
			
			f.close();
			s.close();
			

			
			
			
		}finally{
			
		}
	}
}


			
