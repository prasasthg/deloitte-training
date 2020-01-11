package com.deloitte.movie;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;
public class MovieMain{

	public static void main(String[] Args)
	{   Scanner input= new Scanner(System.in);
	    List<MovieRecords> movieList = new ArrayList<>();
		MovieRecords movieObj = new MovieRecords();
		 int id=input.nextInt();
		 String name=input.nextLine();
		 String showdate=input.nextLine();
		 String showtime=input.nextLine();
		 String status=input.nextLine();
		 input.nextLine();
		 movieObj = new MovieRecords(id, name, showdate, showtime, status);
		 movieList.add(movieObj);
		 System.out.println(movieList);
		 
      		
		
	}
	
	}
