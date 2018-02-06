import java.io.*;
import java.util.*;
public class Work {
	public static void list(String Dir){
		
		File directory =new File(Dir);
		File[] filelist=directory.listFiles();
		for(File file : filelist){
			if(file.isFile()){														//checks that the file is file or directory
				System.out.println("File Name : "+file.getName()+"   Path : "+file.getPath());
				
				
				}else if(file.isDirectory()){										//if it is directory then recall function
				list(file.getAbsolutePath());
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		ArrayList<File> files=new ArrayList<File>();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the path of file: ");						//taking the root file path from user
		String path=s.nextLine();
		File file = new File(path);
		FileReader f=null;
		String path1="";
		String path2="";
		//	File res=new File(path2);
			try{
			int c;
			f= new FileReader(file);
			int count=0;
			while((c=f.read())!=10){
				if((c)==10)
				{
					count++;								//C:\Users\Happy Kohli\Desktop
				}if(count==0){
					path1=path1+(char)c;					//getting the first path of file
				}
					}
   
		   list(path1.substring(0,path1.length()-1));			//calling the function
			
		   while((c=f.read())!=-1){
				path2=path2+(char)c;
			}
			
		   File OFile=new File(path2);
			FileWriter out=new FileWriter(OFile,true);
			for(int i=0;i<files.size();i++){
				out.write(files.get(i).getName());
				out.write(files.get(i).getAbsolutePath());				//writing files in .csv files
				out.write(10);
			}
			
			out.flush();												//neutralizing resources
			f.close();
			s.close();
						
		}
			catch(Exception e){
			System.out.println("Error Detected:- File Not Exist.");
		}
			
			finally{
			
		}
	}
}


			
