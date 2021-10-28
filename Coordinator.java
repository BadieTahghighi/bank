import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Coordinator {
	
	
	 private int[] generateArray(int n,int min,int max)
	    {
	        int [] array=new int[n];
	        for ( int i=0;i<n;i++)
	        {
	            array[i]=(int)(Math.random()*(double)(max-min)+min);
	        }
	        return array;
	    }
	 
//	 private String[] generateStrings(int n, ArrayList<String> strings) {
//		 String[] array = new String[n];
//		 int max = strings.size();
//		 for(int i =0; i <n; i++) {
//			 int index = (int) (Math.random()*(max-0)+0);
//			 array[i] = strings.get(index);
//		 }
//		 return array;
//	 }
	    private long getTime()
	    {
	        return System.nanoTime();
	    }
	    public void experiment(int n,int maxRep) throws IOException
	    {
	       BufferedWriter writer=new BufferedWriter(new FileWriter("output.txt"));
	       
	       for (int num=100;num<=n;num+=50) // all  sizes
	       {
	           for (int rep=0;rep<maxRep;rep++)
	           {
	               System.out.println("Testing n= "+num);
	              
	               
	               writer.write(num+",");
	               Bank bank1 = new Bank("First Bank");
	               Bank2 bank2 = new Bank2("Second Bank");
	               Bank3 bank3 = new Bank3("Third Bank");
	               Bank4 bank4 = new Bank4("Fourth Bank");
	               String[] city = new String[] {"Mashhad", "Semnan", "Tehran", "Karaj", "Sari", "Rasht", "Grogan", "Isfahan", "Ahvaz", "Shiraz", "Kermanshah", "Kerman"};
	               ArrayList<String> cities = new ArrayList<>(Arrays.asList(city));
	               String[] name = {"Mahshid", "Sama", "Shahin", "Mozhgan", "Pooya", "Peyman", "Pezhman", "Arvid", "Leila", "Sadaf", "Farid", "Taher", "Zivar", "Adib"};
	               Integer [] ranges={0,100,1000,5000,10000,20000,25000,45000,50000,80000,85000,87000,88000,100000,110000,
	                       120000,122000,130000,200000,250000,300000,310000,400000,400500,800000,850000,1000000,1000900,2000000,200000000,2000000000};
	                   ArrayList<Integer> rangesList=new ArrayList<Integer>(Arrays.asList(ranges));
	               Random random = new Random();
	               
	               //add experiment
	               long begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   Account newAccount = new Account(index + 1, name[random.nextInt(name.length - 1)],
	                           random.nextDouble() * 1000, city[random.nextInt(city.length - 1)]);
	                   bank1.addAccount(newAccount);
	               }
	               long finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   Account newAccount = new Account(index + 1, name[random.nextInt(name.length - 1)],
	                           random.nextDouble() * 1000, city[random.nextInt(city.length - 1)]);
	                   bank2.addAccount(newAccount);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   Account newAccount = new Account(index + 1, name[random.nextInt(name.length - 1)],
	                           random.nextDouble() * 1000, city[random.nextInt(city.length - 1)]);
	                   bank3.addAccount(newAccount);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   Account newAccount = new Account(index + 1, name[random.nextInt(name.length - 1)],
	                           random.nextDouble() * 1000, city[random.nextInt(city.length - 1)]);
	                   bank4.addAccount(newAccount);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
	             
                   //find experiment
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank1.findAccount(index+1);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank2.findAccount(index+1);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank3.findAccount(index+1);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank4.findAccount(index+1);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   //city-aggregation experiment
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank1.getTotalBalancePerCity(cities);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank2.getTotalBalancePerCity();
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank3.getTotalBalancePerCity();
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank4.getTotalBalancePerCity();
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   //range-aggregation experiment
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank1.getTotalCountPerRange(rangesList);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank2.getTotalCountPerRange(rangesList);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank3.getTotalCountPerRange(rangesList);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
                   
                   begin=getTime();
	               for (int index = 0; index < num; index++) {
	                   bank4.getTotalCountPerRange(rangesList);
	               }
	               finish=getTime();
                   writer.write((finish-begin)/num+",");
	                   
	               
	               writer.write("\n");
	           }
	       }
	       writer.close();
	    } 

}

