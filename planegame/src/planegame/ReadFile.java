package planegame;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ReadFile {
	
	static boolean read = true;
	static ArrayList <tempRank> results = new ArrayList<>();
	
	private static String top1 = "";
	private static String top2 = "";
	private static String top3 = "";
	
	public static String[] top = {top1,top2,top3};

	
	public ReadFile() {
		// TODO Auto-generated constructor stub
	}

	public static void readFile() {
		
		if(read) {
		try(Scanner input = new Scanner(new File("data.txt")))
		{
			if(input.hasNextLine())
				//System.out.print(input.nextLine());
			
			while (input.hasNextLine()) {
				String date = input.next();				
				String time = input.next();
				int playTime = input.nextInt();
				int level = input.nextInt();
				input.nextLine();
				
				results.add(new tempRank(date,time,playTime,level));
			}
			
		}
		catch(FileNotFoundException e) {
			System.out.println("File data.ext could not be found");
		}finally {
			read = false;
				
		}
		
		Collections.sort(results, new SortbyPlayTime());	
		
		// results.forEach((e)->{System.out.println(e);});
		getResults();
		

		
	}
	}

	/**
	 * @param read the read to set
	 */
	public static void setRead(boolean read) {
		ReadFile.read = read;
	}
	
	public static void getResults(){
		System.out.println("getResults");
		
		top1 ="";
		top2 ="";
		top3 ="";
		
		if(results.size()<3) {
			
			if(results.size()==1) {
				top1+= results.get(0);
			}
			else if(results.size()==2) {
				top1+= results.get(0);
				top2+= results.get(1);
				
			}
		}
		else {
		top1 += results.get(0);
		top2 += results.get(1);
		top3 += results.get(2);
		
		System.out.println(getTop1());
		System.out.println(results.get(0));
		}
		
	}

	/**
	 * @return the top1
	 */
	public static String getTop1() {
		return top1;
	}

	/**
	 * @param top1 the top1 to set
	 */
	public static void setTop1(String top1) {
		ReadFile.top1 = top1;
	}

	/**
	 * @return the top2
	 */
	public static String getTop2() {
		return top2;
	}

	/**
	 * @param top2 the top2 to set
	 */
	public static void setTop2(String top2) {
		ReadFile.top2 = top2;
	}

	/**
	 * @return the top3
	 */
	public static String getTop3() {
		return top3;
	}

	/**
	 * @param top3 the top3 to set
	 */
	public static void setTop3(String top3) {
		ReadFile.top3 = top3;
	}
	
}
class SortbyPlayTime implements Comparator<tempRank>
{
    // Used for sorting order of tempRank
   
    public int compare(tempRank a, tempRank b)
    {
       
    	return b.playTime - a.playTime;
    }
    
}
