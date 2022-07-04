#!/usr/local/bin/perl

# define Strings

#subroutine to take random word from list of words  
sub make_word{
$string="computer,radio,calculator,teacher,bureau,police,geometry,president,subject,country,environment,classroom,animals,province,month,politics,puzzle,instrument,kitchen,language,vampire,ghost,solution,
service,software,virus25,security,phonenumber,expert,website,agreement,support,compatibility,advanced,search,triathlon,immediately,encyclopedia,endurance,distance,nature,history,organization,international,
championship,government,popularity,thousand,feature,wetsuit,fitness,legendary,variation,equal,approximately,segment,priority,physics,branche,science,mathematics,lightning,dispersion,accelerator,
detector,terminology,design,operation,foundation,application,prediction,reference,measurement,concept,perspective,overview,position,airplane,symmetry,dimension,toxic,algebra,illustration,classic,
verification,citation,unusual,resource,analysis,license,comedy,screenplay,production,release,emphasis,director,trademark,vehicle,aircraft,experiment";


	@word_arr = split(',', $string);

	$r=rand(100);

	$space=length( $word_arr[$r] );
	$chance=6;
	$word_s=$word_arr[$r];

	for($i=0;$i<$space;$i=$i+1){

 	  	$y=substr($word_s,$i,1);
  	  	$word[$i]=$y;
	}
		#print "@word \n";
 
	for($i=0;$i<$space;$i=$i+1)
	{
		$dash[$i]="_";
	}
}

#subroutine to print word
sub print_word{
    		print "Here is your word :";
    		for($i=0;$i<$space;$i=$i+1) {
    		print "@_[$i] " ;
    		}
    	print "\n";
}

# subroutine to print array
sub print_arr{
	print "Guess so far :";
	print " @array\n";
}

# This is called by subroutine guess
sub check{
	for($i=0;$i<$s;$i=$i+1)
    	{
    		if($array[$i] eq substr($x,0,1))
    		{
    			print "You have already chosen this letter. Make another guess :";
    			return 1;
    		}
    		
    	}
    	return 0;
}

#Subroutine to take user input and check his guess is right or wrong
sub guess{
        
        
    	print "Make a guess :";
    	$x=<STDIN>;
    	$x=lc($x);
    	
    	$s=@array;
    
        
    	$c=0;
    	if($word_arr[$r]   eq substr($x,0,$space) )
	{ 
		print " YOU WIN :)  ";
		return 1;
	}
	else
	{
		$n=check();
    		while($n==1)
    		{
    			$x=<STDIN>;
    			$x=lc($x);
    			if($word_arr[$r]   eq substr($x,0,$space) )
			{ 	print "YOU WIN :)  ";
				return 1;
			}
    	       	 $n=check();
    	 	}
    	 	push(@array ,substr($x,0,1));
    	 	
    		for($i=0;$i<$space;$i=$i+1){

        		if(substr($word[$i],0,1) eq substr($x,0,1))
			{ 
	        		if($c==0){
				print "Good guess! You have $chance body parts left \n";
				structure($chance);
				}
				$dash[$i]=substr($x,0,1);
				$c=1;
				
			}
   		}
	}
  	 
  	if($c==0){
  		$chance=$chance-1;
		print "Bad Guess! You have $chance body parts left  \n";
		structure($chance);
  	}
   	
   	$e=0;
   	for($i=0;$i<$space;$i=$i+1)
    	{
    		if($dash[$i]=~"_"){
    		$e=1;}
    	}
 
    	if($e==0)
    	{
    	       print "Here is your word : @dash \n";
    		print"YOU WIN :)";
    		return 1;
    	}  
        return 0;
}

#Subroutine to diaplay Hangman
sub structure{

		if($chance==0) 
		{		print "       ___________\n";
				print "       |         |\n";
				print "      (_)        |\n";
				print '      /|\        |';
				print "\n";
				print "       |         |\n";
				print '      / \        |';
				print "\n";
				print "                 |\n";
				print "_________________|_____                  \n";

		}
		elsif($chance==1) {
				print "       ___________\n";
				print "       |         |\n";
				print "      (_)        |\n";
				print "      /|         |\n";
				print "       |         |\n";
				print "      /          |\n";
				print "                 |\n";
				print "_________________|_____                  \n";

		}
		elsif($chance==2) {
				print "       ___________\n";
				print "       |         |\n";
				print "      (_)        |\n";
				print '      /|\        |';
				print "\n";
				print "       |         |\n";
				print "                 |\n";
				print "                 |\n";
				print "_________________|_____                  \n";

		}
		elsif($chance==3) {
				print "       ___________\n";
				print "       |         |\n";
				print "      (_)        |\n";
				print "      /|         |\n";
				print "       |         |\n";
				print "                 |\n";
				print "                 |\n";
				print "_________________|_____                  \n";

		}
		elsif($chance==4) {
				print "       ___________\n";
				print "       |         |\n";
				print "      (_)        |\n";
				print "       |         |\n";
				print "       |         |\n";
				print "                 |\n";
				print "                 |\n";
				print "_________________|_____                  \n";

		}
		elsif(@_[0]==5) {
				print "       ___________\n";
				print "       |         |\n";
				print "      (_)        |\n";
				print "                 |\n";
				print "                 |\n";
				print "                 |\n";
				print "                 |\n";
				print "_________________|_____                  \n";

		}
		elsif($chance==6) {
				print "       ___________\n";
				print "       |         |\n";
				print "                 |\n";
				print "                 |\n";
				print "                 |\n";
				print "                 |\n";
				print "                 |\n";
				print "_________________|_____                  \n";

				         

		}
	
}



        make_word();
	for($j=0;$j<$spaces+50;$j=$j+1)
	{    
   		print_word(@dash);
    		print_arr();
    		$n=guess();
    		if($n==1){
    			$j=1000;
   		 }
    		if($chance==0)
    		{
    			$j=1000;
    		}
   		 print "\n";
    		if($chance==0)
    		{
        		if($n==0){
    			print "YOU lOSE  :(   THe word is: $word_s \n";
    			}
    		
    		}
	}


 



 
	
	
	

