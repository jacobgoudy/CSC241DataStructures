
import javax.swing.JOptionPane;
import java.util.*;
import java.io.*;

public class PolyASolution extends SingleLinkedList<String>  {
// Q1: why extends
// A1: Because we do not want to copy the program of 
//     SingleLinkedList process here, like how JFrame is used.
// Q2: How about to replace it with an attribute of such a class,
//     say SingleLinkedList<String> a;
// A2: For the code in the rest, you need "a = new SingleLinkedList,"
//     for any instance method of this a, you need add object "a.," 
//     e.g., a.element, a.remove, a.add. Most importantly, when 
//     a.add(10) and add(10) of PolyA both are needed, the computer 
//     will not give any alert after the program forgets which one 
//     is in use. Then, the class PolyA's method and class SingleLinkedList
//     action can be exchanged without any alert.
// Q3: When we went over this materials in class? 
// A3: Click on "Inheritance and utilization of GUI classes" from class website.
//     Slide 1 - 22.
// Q4: What about I did not see them? 
// A4: Click on "Chapter 1 List, Stack, and Queue" from class website.
//     Slides 12-14, 17.
// Q5: How I know these slides are relevant to this project?
// A5: We handed out hard copies of these programs.       
    public PolyASolution (){
        super();   
    }
// Q6:  Why the above is needed? 
// A6:  Without it, you use of superclass method such as add(10), not add(b)
//      will incur an exception. 
// Q7:  How I know this is needed? 
// A7:  Slides 12-14, 17, in the materials of "chapter 1 ..." from class website.
// Q8:  How I know these slides are relevant to this project?
// A8:  We handed out hard copies of these programs. All use this super constructor.   
// Q9:  What is the similar work to be reused from the existing sample?
// A9:  Copy it. After that, change the class name from BigIA to PolyA.   
    public void initialization() {   
        String filename = JOptionPane.showInputDialog("Enter the file name: ");
        File inputFile = new File (filename);
        try {
            Scanner input = new Scanner(inputFile);
            double c = input.nextDouble();
            int e = input.nextInt();
            int p_e = e-1;
            add(""+c);
            while(input.hasNext()){
                c = input.nextDouble();
                e = input.nextInt();
                while(p_e-->e)
                    add("0");
                    add(""+c);
            }
            input.close();
        }
        catch (FileNotFoundException e)   {
            System.out.println("file reading fails.");
        }   
// Q10:  Why file processing?
// A10:  I preprared the information in files. Give the file name 
//      then I can see the result. No need for keying in the information
//      every time.   
// Q11: Have we covered the program of file reading and writing? 
// A11: Suppose to be covered early, but see the review materials in 
//      "Loop, file, exception, and randome number" slides 59-65.
// Q12: How about the exceptions, do I need it?
// A12: Usually yes. See the samples in the above materials. 
// Q13: When do we cover this in class? 
// A13: If not 141, 142, or 240, we have the mtarials covered in the first week
//      of 240. 
// Q14: If I do not use file processing here, will I lose the points? 
// A14: Not for Q1-3 in project1, but will in Q4. It is required there.
// Q15: I don't like file processing, I prefer to keyboard reading and screen display.
// A15: In the system development, you will not allowed to have screen display and 
//      keyboard. Assume that you are developing your windows word, will your program 
//      hold the users processing in word file or print out information covering the 
//      word file display?    
//      In the other hand, for debugging program, you do not need to repeat the input 
//      step by step. Moreover, you can easily known when the input ends.
// Q16: What is the main target in the above program? 
// A16: 1) for any nonzero e value, prepare the item (c, e)
//      2) for any gap between current e and previous e, say 7 and 2,
//         prepare "0" units to fill in:
//         (c,7)->(0,6)->(0,5)->(0,4)->(0,3)->(c,2).
//      3) Loops, nested loops, one for completing the item input
//         the other for filling in the gap.
// Q17: What materials are relevant? 
// A17: Slides 27-58 in  "Loop, file, exception, and randome number" for
//      lopp development. Among them, slides 39-40, 42-45 are on nested loop.  
// Q18: What about item creation? 
// Q18: It is required in the above three. It is realized by an instance method 
//      from super class because the items are maintained in the attribute "head" there.
// Q19: Where are the materials relevant?
// A19: Click on "instance method" from class website. Slides 9, 24 
// Q20: How this is ensured to know in CSC241 before the project is given? 
// A20: Quiz2 from class website
//             if bad score, 
//                 review the materials "Class," "Instance method," "Difference,"
//                        and instance method self-evaluation and solution. 
//      Sample in the program of Big Integer
//             BigIA, BigID, BigIC
//      if missed the class
//             see the link of them from class website, inside of ppt file of "Chapter 1".
//      if don't know the need for project work
//             hard copy is handed out in class
//      Hard copy was handed out twice in class.
// Q21: Why ""+c or ""+0? 
// A21: SingleLinkedList<String> can save one String only. c or 0 is numeric value, and 
//      needs to convert to String. Like add(""+val.charAt(i)) in the sample to convert 
//      a single character to String.
// Q22: Why need to read c and e before the loop starts? 
// A22: It is done so because of the need for setting the value of pre_e. As the result,
//      the gap can be determined from the past exponent and the next exponent.  
// Q23: What I can borrow from the sampel code?
// A23: See the conversion in the follows.
//      <Sample, existing>                                  <project work, as desired>
//      while(input.hasNext()){                             while(input.hasNext()){
//          String val = input.next();              ->            c = input.NextDouble()
//                                                                e = input.NextInt()
//          for(int i = 0; i<val.length(); i++)                   while(p_e-- > e)
//                                                                  add("0");
//            add(""+val.charAt(i));                              add(""+c);
//      }                                                   }
public String toString(){
    String val = element(0);
    if(val!=null){
        String ret = rec_string(1);
    
        double c = Double.parseDouble(val);
        if (c==0) {
            if (ret.equals(""))return"null";
            else return ret;
        }
        else if (ret.equals(""))return""+c;
        else if (c>0) return ret+" + " +c;
        else return ret+" - "+Math.abs(c);
    }
    else return"null";
}

private String rec_string(int x) {
    String val = element(x);
    if (val!=null){
        String ret = rec_string(x+1);
        double c = Double.parseDouble(val);
        if (c==0)
            return ret;
        else if (ret.equals(""))
            return c+"X^"+x; 
        else if (c>0)
            return ret+" + "+c+"X^"+x;
        else 
            return ret+" - "+Math.abs(c)+"X^"+x;
    }
    else 
        return"";
}
// Q24: Why toString and rec_String?
// A24: Don't want to see ==> in the display of polynormial. That is
//      NOT the normal way and unreable to general reader.
// Q25: Where to find relevant information?
// A25: 1) Slide 32-34 in "instance method" from class website. 
//      2) realization of toString in "Samples of instance method development"
//      3) Solution of "instance method" from class website. 
//      4) Quiz2 solution from "Quiz2" on the class website.
//      5) toString in BigIA.java, NOT in BigID.java and BigIC.java because the 
//         the use of insertion at the head only in the singleLinkedList. (ID and IC) 
//         use both head and tail to insert unit.
// Q26: If not found in class website, where else I can try? 
// A26: Handouts and hard copies. 
// Q27: What is the difference between the sample work and the desired project work?
// A27: 
//            <Sample, existing>                      <project work, as desired>
//            if(element(0)!=null)                             val = element(0)
//             return rec_string(1)+element(0);  ->   ret = rec_string(1);
//                                                    return ret+" + "+c   ;  no X!
//             else return "";                        more casees to handle because 
//                                                    of the existence of 0 unit. 
//
//             String ret = element(x);               String val = element(x);  
//             if (ret!=null)                         if (val!=null){
//                return rec_string(x+1)+ret;    ->    String ret = rec_string(x+1);
//                                                     double c=Double.parseDouble(val);
//                                                      return ret+" + "+c+"X^"+x;   
//       
//             else                                   more cases to handle because       
//                return "";                          of the existence of 0 unit.
// Q28: Recursion is needed? 
// A28: Yes, because the reserved order used in saving each item. This is decided
//      by the use of add of SingleLinkedList.
// Q29: Where to find relevant information? 
// A29: "Recusion development and solution" from the class website, espeically 
//      programs 1 and 5.
// 
//      System.out.print(x+" ");                      The unit is stored:    
//      f(x+1, y);                                    e0, e1, e2, ....       
//      prints out 1, 2, 3, 4, 5, 6, ... 
//      but                                       ->  must print out in the order
//      f(x+1, y);                                    ... + e2 + e1 + e0.
//      System.out.print(x+" ");!
//      prints out ... 5, 4, 3, 2, 1
public   PolyA add(PolyA right){
    PolyA tmp = new PolyA ();
    rec_add(this, right, 0, tmp);  
    return tmp;
}
private void rec_add(PolyA left, PolyA right, int p,  PolyA result){
    String lstr = left.element(p);
    String rstr = right.element(p);
    if(lstr==null && rstr==null) 
        return;
    double lv = (lstr!=null)?(Double.parseDouble(lstr)):0;
    double rv = (rstr!=null)?(Double.parseDouble(rstr)):0;
    double r = lv+rv;
    rec_add(left, right, p+1, result);
    result.add(""+r);
}
// Q30: Is this add the most difficult part?
// A30: No, opposite.
// see what inside of BigIA:
//   public   BigIA add(BigIA right){
//       BigIA tmp = new BigIA ();
//       rec_add(this, right, 0, 0, tmp);
//              need, need, need, NO, need
//                                because no need to calculate carry-in bit.
//       return tmp;     
//   }
//             One number deletion will be the solution!
//  
//
//   private void rec_add(BigIA left, BigIA right, 
//         int p, int cb, BigIA result){
//                Not needed! -- carry-in bit
//      String lstr = left.element(p);
//      String rstr = right.element(p);
//      int lv = (lstr!=null)?(Integer.parseInt(lstr)):0;
//      int rv = (rstr!=null)?(Integer.parseInt(rstr)):0;
//      if (lv ==0 && rv ==0 && cb ==0) return;        
//                So far, you do not need to change the code
//                unless the double value conversin (from string)
//      int r = lv+rv+cb;
//      cb = r/10;
//      r = r%10;
//                No cb, so that the calculation is easier.
//      rec_add(left, right, p+1, cb, result);
//                                not needed.
//      result.add(""+r);
//   }
//      Four changes are expected, which can be done in a minute.           
// The rest is given in the assignment. 
public static void main(String args[]){
    PolyA a = new PolyA ();
    PolyA b = new PolyA ();   
    PolyA c = new PolyA ();
    a.initialization();
    b.initialization();
    c = a.add(b);
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
}
}
