import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


class LongIntegerMultiply implements ActionListener{

    JFrame frame;
    JButton btn, clrBTN, exitBTN;
    JTextField tf1,tf2;
    JTextArea ta;
    JLabel l1, l2, l3;
   static String sum="";
    LongIntegerMultiply(){
               JFrame frame = new JFrame("Long Integer Multiplication");
               l1 = new JLabel("Enter The First Number:");
		l2 = new JLabel("Enter The Second Number:");
                l3 = new JLabel("Result:");
                tf1 = new JTextField();
                tf2 = new JTextField();
                btn = new JButton("Calculate");
                clrBTN = new JButton("Clear");
                exitBTN = new JButton("Exit");
                ta = new JTextArea();
		l1.setBounds(10,10,200,10);
                tf1.setBounds(10,30,1000,30);
		l2.setBounds(10,70,200,50);
                tf2.setBounds(10,110,1000,30);
                btn.setBounds(300,150,500,30);
                l3.setBounds(10,180,200,50);
                ta.setBounds(10,230,1000,180);
                exitBTN.setBounds(900,450,100,30);
                clrBTN.setBounds(750,450,100,30);
                ta.setLineWrap(true);
		frame.add(l1);
                frame.add(tf1);
		frame.add(l2);
                frame.add(tf2);
                frame.add(btn);
                frame.add(l3);
                frame.add(ta);
                frame.add(clrBTN);
                frame.add(exitBTN);
                btn.addActionListener(this);
                clrBTN.addActionListener(this);
                exitBTN.addActionListener(this);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1050,600);
                frame.setLayout(null);
		frame.setVisible(true);

    }
 
   public void actionPerformed(ActionEvent e){
    if(e.getSource()==btn){
     String no1 = tf1.getText();
     String no2 = tf2.getText();
     char number1[] = no1.toCharArray();
     char number2[] = no2.toCharArray();
     //System.out.println(number1.length);
     multiply(number1, number2);
     ta.setText("");
     ta.append(sum);
     //System.out.println(sum);
     }
     if(e.getSource()==clrBTN){
      tf1.setText("");
      tf2.setText("");
      ta.setText("");

      }
     if(e.getSource()==exitBTN){
       System.exit(0);

      }



   }

 public static void main(String... s){
   LongIntegerMultiply obj = new LongIntegerMultiply();
 }


 static String add(String num1, String num2){ // Add function which takes two strings and convert them to the integer, then add them and then convert it into string again and returns the string. 
		//System.out.println("........The Addition Method........");
		char n1[]=num1.toCharArray();     //converts string into add array. 
		char n2[]=num2.toCharArray();  
                
		int add=0;
		char[] max;
		char[] min;
		int carry=0;
		
		String addtotal="";
		
		
		if(n1.length>n2.length){  // checks which array is larger.
			            max=n1;   // set large array into max. 
                        min=n2;   // set smaller array into min.
                        
                                        
		}
		else{
			           max=n2;
                       min=n1;
		}
		
	
          int diff = max.length-min.length;  // different between the lengths of two array.
          int c[] =new int[max.length];      // create new integer array which is of the size of large array.
   
          for(int i = max.length-1;i>=0;i--){   // insert the elements of smaller array into new array c from last index.
              try{ //System.out.println(i-diff);  // if index is less then 0 of smaller array then go to catch block.
                 c[i]=Character.getNumericValue(min[i-diff]);   // it transfers the integer value of each element in char smaller array into array c.
                  }

              catch(ArrayIndexOutOfBoundsException e){
                    c[i]=0;  // if index becomes 0 of smaller array then set element of c=0.
      

     }
	}
     
	    
              


		for(int i=(max.length-1);i>=0;i--){// to perform addition betwwen max and c array.
		
                      //  System.out.println("carry : "+carry);
                    //    System.out.println(" i "+i);
                       try{ 
					  //  System.out.println(" c "+c[i]+" max :"+max[i]);
			add = ((Character.getNumericValue(max[i])+c[i])+carry); 
                       //  System.out.println(add);
                         if(add > 9){
                          carry = 1;
                          add = add%10;    
	                 }
	                  else{
			 carry =0;
		          }
                        }
                       catch(ArrayIndexOutOfBoundsException e){
                      //System.out.println(" i in catch block"+i);
                           add=Character.getNumericValue(max[i])+carry;
                           if(add > 9){
                          carry = 1;
                          add = add%10;    
	                 }
	                  else{
			 carry =0;
		          }


                        }
               
			addtotal=addtotal+add;
		}
		
		addtotal = reverseString(addtotal);
		
		return addtotal;
		
	 	
		
	}
	
	
	public int[] reverseArray(int[] nums) {
    int[] reversed = new int[nums.length];
    for (int i=0; i<nums.length; i++) {
        reversed[i] = nums[nums.length - 1 - i];
    }
    return reversed;
}
	
	
	
	
 static void multiply(char a[], char b[]){
   int carry=0;
   String total1="";
   String total2="";
  sum="";
   int multi=0;
   
   for(int i=(b.length)-1;i>=0;i--){


       for(int c=i;c<(b.length)-1;c++)
      {
       total1 = total1+"0";
      // System.out.println(total1);
     
      }  
	  carry=0;
     for(int j=(a.length-1);j>=0;j--){
    // System.out.println("Carry:"+carry);
      multi = ((Character.getNumericValue(a[j])*Character.getNumericValue(b[i]))+carry); 
  //   System.out.println("a="+j+" and b="+i+":"+Character.getNumericValue(a[j])*Character.getNumericValue(b[i]));
       if(multi > 9){
        carry = multi/10;
        multi = multi%10;   
        
		//total1 = reverseString(total1);
       // System.out.print(total1);
	  
	   }
	    else{
			 carry =0;
		}
	//	System.out.println("multi:"+multi);
     
	 total1=total1+multi;
	 
   }
    
     total1 = reverseString(total1);
	 sum = add(sum, total1);
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	// System.out.println(total1);
	// sum=sum+(Double.parseDouble(total1));
	 total1="";
	 
  //   System.out.println(total1);
 
 // System.out.println(total1);

 }
  // total2 = sum.toString();
   //System.out.println(sum);
  
//   ta.setText(sum);
 }

public static String reverseString(String str){  
    char ch[]=str.toCharArray();  
    String rev="";  
    for(int i=ch.length-1;i>=0;i--){  
        rev+=ch[i];  
    }  
    return rev;  
} 
 

}