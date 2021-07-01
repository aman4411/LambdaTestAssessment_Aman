package LambdaTestAssessment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class LambdaTestAssessment {

	public static void main(String[] args) {
		
		//create object of Scanner class & take input string
		Scanner sc = new Scanner(System.in);	
		String input  = sc.nextLine();
		
		//split the input string
		String[] machines = input.split(",samsung");
		
		//add 'samsung' to all splitted strings except the first one.
		for(int i=1;i<machines.length;i++) {
			StringBuilder temp = new StringBuilder(machines[i]);
			temp.insert(0, "samsung");
			machines[i] = temp.toString();
		}
		
		//maintain a list of all the machines with its name & price.
		List<WashingMachine> list = new ArrayList<>();
		calculateMachinePrice(machines,list);
		
		//sort the list based on price of each washing machine.
		Collections.sort(list,new CustomSortingComparator());
		
		//print sorted list of washing machines
		for(WashingMachine washingMachine : list) {
			System.out.println(washingMachine.getName() + washingMachine.getPrice());
		}
	}
	
	//function for storing all washing machines with their names & prices in a list.
	private static void calculateMachinePrice(String[] machines, List<WashingMachine> list) {
		
		for(String machine : machines) {
			int index = machine.length()-1;
			while(Character.isDigit(machine.charAt(index))) {
				index--;
			}
			WashingMachine washingMachine = new WashingMachine(machine.substring(0,index+1),machine.substring(index+1));
			list.add(washingMachine);
		}
		
	}
	
	//custom comparator for sorting washing machines based on its price.
    static class CustomSortingComparator implements Comparator<WashingMachine> {

	    @Override
	    public int compare(WashingMachine machine1, WashingMachine machine2) {
		    // TODO Auto-generated method stub
		    int priceCompare = machine1.getPrice().compareTo(machine2.getPrice());	
		    return priceCompare;
	    }
    }

}