import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
		//Save the extension of each file
		private static String getFileExtension(File file) {
		    String name = file.getName();
		    try {
		        return name.substring(name.lastIndexOf(".") + 1);
		    } catch (Exception e) {
		        return "";
		    }
		}
		
		/*The following static method is used three times. It could have been used 
		 * less times, but it's just a demo program...:-)
		 * */
		public static File[] OrderMyFiles (File rootFolder){
			   File[] listOfFiles = rootFolder.listFiles();
			   Arrays.sort(listOfFiles, new AlphanumFileComparator() );
			   return listOfFiles;
		}
		
		public static void main(String[] args) {

			  Scanner scanner = new Scanner(System.in);
			  System.out.println("Give the path of the folder.\n**IMPORTANT**\nMAKE SURE THE LAST CHARACTER OF THE PATH YOU GIVE IS / or \\");
			  String path = scanner.nextLine();
			  
			  File dir = new File(path);
			  int counter = 1; 
			  if (dir.isDirectory()) { // make sure that user's input is a directory
				  				  
				  System.out.println(Arrays.toString(OrderMyFiles(dir)));	//**First use**
				  
				  // inform the user about the files that are going to be renamed
				  System.out.println("There are the following files in this directory: ");
			      for (File i : OrderMyFiles(dir)){							//**Second use**
			    	  System.out.println(i.getName());
			    	  
			    	  //Get the file extension - Print it on screen for demonstration purposes		    	  
			    	  String ext = getFileExtension(i);
			    	  System.out.println("Current file extention is: " + ext);
			      }
			      
			      //Ask for a confirmation
			      System.out.println("Are you sure that you want to rename them? Give only [Y] or [N].");
			      String answer = scanner.nextLine();
			      String correctanswer = "Y";		//I used this extra string just for demo purposes
			      System.out.println("You gave " + answer.toUpperCase());
			      
			      if(answer.equalsIgnoreCase(correctanswer)){
			    	  
			    	  System.out.println("What prefix shall the files have?");
			    	  
			    	  String prefix = scanner.nextLine();	//The prefix that was given from user
			    	  
			    	  String extension;		//Here we keep the type of the file
			    	  
				      for (final File f : OrderMyFiles(dir)) {				//**third use**
				    	  
				          try {
				        	  extension = getFileExtension(f);
				        	  
				        	  //The file name of the files will be path/prefix_counter.extension
				              File newfile =new File(path + prefix + "_" + counter + "." + extension);
				              
				              if(f.renameTo(newfile)){
				                  System.out.println("File " + counter + " renamed succesful");
				              }else{
				                  System.out.println("File " + counter + "rename failed");
				              }
				              
				              counter++;
				              
				          } catch (Exception e) {
				        	  scanner.close();
				              e.printStackTrace();
				          }
				      }//close - for (final File f : OrderMyFiles(dir))
			      }else{
			    	  System.out.println("Negative or wrong parameter. No changes were made. The program will exit now...");
			    	  scanner.close();
			    	  System.exit(0);
			      }
			  }else{			//close - if (dir.isDirectory())
				  System.out.println("This path does not exists. The program will exit now...");
			  }
			  scanner.close();
		}
}
