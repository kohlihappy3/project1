import java.io.*;
import java.util.*;
public class Work {
	
	
	public static void list(String Dir, ArrayList<File> files){
		File directory =new File(Dir);
		File[] filelist=directory.listFiles();
		for(File file : filelist){
			if(file.isFile()){														//checks that the file is file or directory
				System.out.println("File Name : "+file.getName()+"   Path : "+file.getPath());
				files.add(file);
				}else if(file.isDirectory()){										//if it is directory then recall function
				list(file.getAbsolutePath(),files);
			}
		}
	}
	
	
	public static void main(String[] args) throws IOException{
		ArrayList<File> files=new ArrayList<File>();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the path of file: ");								//taking the root file path from user
		String path=s.nextLine();
		File file = new File(path);
		FileReader f=null;
		String path1="";
		String path2="";
		try{
			int c;
			f= new FileReader(file);
			int count=0;
			while((c=f.read())!=10){
				if((c)==10)
				{
					count++;								
				}if(count==0){
					path1=path1+(char)c;											//getting the first path of file
				}
					}
   
		   list(path1.substring(0,path1.length()-1),files);								//calling the function
			
		   while((c=f.read())!=-1){
				path2=path2+(char)c;
			}
			
		    FileOutputStream  fileout=new FileOutputStream(path2,true);
		    BufferedWriter b=new BufferedWriter(new OutputStreamWriter(fileout));
		    Iterator<File> itr=files.iterator();
		    	while(itr.hasNext()){
		    	File temp=itr.next();
				b.write("File Name :- " + temp.getName());
				b.newLine();
				b.write("The Path :- " + temp.getAbsolutePath());					//writing files in .csv files
				b.newLine();
				b.newLine();
		    	}
																
			f.close();																//neutralizing resources		
				}
		
			catch(Exception e){
			System.out.println("Error Detected:- File Not Exist.");
		}
	}
}


			
