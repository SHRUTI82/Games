//TicTacToe
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
public class TicTacToe{
	static int choice;
	static int[] position=new int[9];
	static int[] u1position=new int[9];
	static int[] u2position=new int[9];
	static int[] uposition=new int[9];
	static int[] cposition=new int[9];

	public static void main(String args[])
	{
		int z;
		char[][] structure={{' ',' ','|',' ',' ','|',' ',' '},
				    {'-','-','|','-','-','|','-','-'},
				    {' ',' ','|',' ',' ','|',' ',' '},
				    {'-','-','|','-','-','|','-','-'},
				    {' ',' ','|',' ',' ','|',' ',' '}};
		
		z=begin(structure);
		structure[0][0]=' ';
		structure[0][3]=' ';
		structure[0][6]=' ';
		structure[2][0]=' ';
		structure[2][3]=' ';
		structure[2][6]=' ';
		structure[4][0]=' ';
		structure[4][3]=' ';
		structure[4][6]=' ';
		
		int k;
		int t=1;
			for(k=0;k<5;k++){
				if(z==2)
				t=TwoPlayers(structure,position,k);
				else if(z==1)
				t=Computer(structure,position,k);
				
				if(t==1)
				break;
				else if(k==4 && t==-1)
				System.out.printf(" Game Draw\n");
				else if(t==-1)
				continue;
			}
	
	}
	
	public static int begin(char[][] structure)// Function displaying the details of game
	{
		System.out.println("Welcome to Tic tac ");
	        System.out.println("This is a new game board number are as follows-"); 
		structure[0][0]='1';
		structure[0][3]='2';
		structure[0][6]='3';
		structure[2][0]='4';
		structure[2][3]='5';
		structure[2][6]='6';
		structure[4][0]='7';
		structure[4][3]='8';
		structure[4][6]='9';
		
		display(structure);
		
		System.out.println("Enter your choice - Press 1 for computer v/s player version and Press 2 for 2-Player version");
		Scanner s=new Scanner(System.in);
		choice=s.nextInt();
		 do
		 {
		 	if(choice==1 || choice ==2)
		 	return choice;
		 	else{
		 	System.out.println("Wrong choice enter again");
		 	choice=s.nextInt();}
		 }while(choice!=1 || choice!=2);
		 return 0;
	}
	
	
	public static int Computer(char[][] structure,int[] position,int k)
	{
		
	        int b=0;
	        char c;
		System.out.printf("Enter your desired location [1-9]\n");
		Scanner sc=new Scanner(System.in);
		int pos;
		
		do
		{
		        pos=sc.nextInt();
		        b=0;
			for(int n:position)
			{
				if(pos==n){
				b=1;System.out.printf("Wrong input enter other empty location :");break;
				}
				
			}
		}while(b==1);
		position[pos-1]=pos;
		uposition[pos-1]=pos;
		 
		c='×';
		shift(structure,pos,c);
		
		int x=checkwin(structure,uposition);
			if(x==1){
				display(structure);
	                       System.out.printf("Congratulations you win \n");
				return 1;
			}
		
	      
		int cpos=-1;
		
		if(k!=4){
		if(uposition[0]!=0 && uposition[1]!=0 || uposition[1]!=0 && uposition[2]!=0 || uposition[2]!=0 && uposition[0]!=0  )
		{
			for(int j=0;j<3;j++)
			if(position[j]==0)
			cpos=j+1;
		}
		else if(uposition[3]!=0 && uposition[4]!=0 || uposition[4]!=0 && uposition[5]!=0 || uposition[5]!=0 && uposition[3]!=0  )
		{
			for(int j=3;j<6;j++)
			if(position[j]==0)
			cpos=j+1;
		}
		else if(uposition[6]!=0 && uposition[7]!=0 || uposition[7]!=0 && uposition[8]!=0 || uposition[8]!=0 && uposition[6]!=0  )
		{
			for(int j=6;j<9;j++)
			if(position[j]==0)
			cpos=j+1;
		}
		else if(uposition[0]!=0 && uposition[4]!=0 || uposition[4]!=0 && uposition[8]!=0 || uposition[0]!=0 && uposition[8]!=0  )
		{
			for(int j=0;j<9;j+=4)
			if(position[j]==0)
			cpos=j+1;
		}
		else if(uposition[0]!=0 && uposition[3]!=0 || uposition[3]!=0 && uposition[6]!=0 || uposition[0]!=0 && uposition[6]!=0  )
		{
			for(int j=0;j<7;j+=3)
			if(position[j]==0)
			cpos=j+1;
		}
		else if(uposition[1]!=0 && uposition[4]!=0 || uposition[4]!=0 && uposition[7]!=0 || uposition[7]!=0 && uposition[1]!=0  )
		{
			for(int j=1;j<8;j+=3)
			if(position[j]==0)
			cpos=j+1;
		}
		else if(uposition[2]!=0 && uposition[5]!=0 || uposition[5]!=0 && uposition[8]!=0 || uposition[2]!=0 && uposition[8]!=0)
		{
			for(int j=0;j<3;j++)
			if(position[j]==0)
			cpos=j+1;
		}
		else if(uposition[2]!=0 && uposition[4]!=0 || uposition[4]!=0 && uposition[6]!=0 || uposition[2]!=0 && uposition[6]!=0 )
		{
			for(int j=2;j<7;j+=2)
			if(position[j]==0)
			cpos=j+1;
		}
		
		
		if(cpos==-1)
		{
			Random r=new Random();
			do{
		        	cpos=r.nextInt(9) + 1;
		        	b=0;
		        	
				for(int n:position){
					if(cpos==n){
					b=1;break;
					}
				
				}
			}
			while(b==1);
		}
		
		
	        System.out.println("Computer pick "+cpos) ;
		position[cpos-1]=cpos;
		cposition[cpos-1]=cpos;
		
	c='O';
	
	shift(structure,cpos,c);
	
	
	}
		display(structure);
		x=checkwin(structure,cposition);
			if(x==1){
				System.out.printf("You lose  \n");
				return 1;
			}
		return -1;
		
	}
	
	public static int TwoPlayers(char[][] structure,int[] position,int k)
	{
		
	        int b=0;
	        char c;
		System.out.printf("Player 1 Enter your desired location [1-9]\n");
		Scanner sc=new Scanner(System.in);
		int pos;
		
		do
		{
		        pos=sc.nextInt();
		        b=0;
			for(int n:position)
			{
				if(pos==n){
					b=1;
					System.out.printf("Wrong input enter other empty location :");
					break;
				}
				
			}
		}while(b==1);
		position[pos-1]=pos;
		u1position[pos-1]=pos;
		
		c='×';
		shift(structure,pos,c);
	
		display(structure);
		
		int x=checkwin(structure,u1position);
			if(x==1){
				System.out.printf("Congratulations PLayer 1 win \n");
				return 1;
			}
		
	        System.out.printf("Player 2 Enter your desired location [1-9]\n");
		Scanner s=new Scanner(System.in);
		int cpos=0;
		
		if(k!=4){
		do{
		        cpos=s.nextInt();
		        b=0;
			for(int n:position)
			{
				if(cpos==n){
					b=1;
					System.out.printf("Wrong input enter other empty location -");
					break;
				}
				
			}
		}while(b==1);
		position[cpos-1]=cpos;
		u2position[cpos-1]=cpos;
		}
	
		c='O';
		if(k!=4)
		shift(structure,cpos,c);
		
		
		
		display(structure);
		
		x=checkwin(structure,u2position);
			if(x==1){
				System.out.printf("Congratulations PLayer 2 win \n");
				return 1;
			}
		return -1;
	}
	public static void display(char[][] structure)//Function to display structure
	{
		for(int i=0;i<5;i++){
			for(int j=0;j<8;j++)
			System.out.print(structure[i][j]);
			System.out.println();
		}
	}
	public static void shift(char[][] structure,int b,char c)//Function to write symbols in gameboard
	{
		switch(b){
			case 1: 
			structure[0][0]=c;
			break;
			case 2: 
			structure[0][3]=c;
			break;
			case 3: 
			structure[0][6]=c;
			break;
			case 4: 
			structure[2][0]=c;
			break;
			case 5: 
			structure[2][3]=c;
			break;
			case 6: 
			structure[2][6]=c;
			break;
			case 7: 
			structure[4][0]=c;
			break;
			case 8: 
			structure[4][3]=c;
			break;
			case 9: 
			structure[4][6]=c;
			break;
			default : break;
		}
	}
		
	public static int checkwin(char[][] structure,int[] tion)//Function to check the winning status 
	{
		if(tion[0]!=0 && tion[1]!=0 && tion[2]!=0)
		return 1;
		else if(tion[3]!=0 && tion[4]!=0 && tion[5]!=0)
		return 1;
		else if(tion[6]!=0 && tion[7]!=0 && tion[8]!=0)
		return 1;
		else if(tion[0]!=0 && tion[3]!=0 && tion[6]!=0)
		return 1;
		else if(tion[1]!=0 && tion[4]!=0 && tion[7]!=0)
		return 1;
		else if(tion[2]!=0 && tion[5]!=0 && tion[8]!=0)
		return 1;
		else if(tion[0]!=0 && tion[4]!=0 && tion[8]!=0)
		return 1;
		else if(tion[2]!=0 && tion[4]!=0 && tion[6]!=0)
		return 1;
		else
		return 0;
	}
}


