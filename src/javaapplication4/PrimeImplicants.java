/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import static java.lang.Boolean.TRUE;
import java.util.Scanner;
import java.util.Vector;
import static javaapplication4.PrimeImplicants.bits;
import static javaapplication4.PrimeImplicants.i;

/**
 *
 * @author HP
 */
public class PrimeImplicants {
static step4 test2=new step4();
    static int i, j, k, m, count;
    static boolean end = true;
    static int range, drange,  bits, gp;
    static String binary1, binary2 = "", strbox = "", strbox2;
   static Vector<Vector<String>> num = new Vector<>();
        static Vector<Vector<Boolean>> check = new Vector<>();
       static  Vector<Vector<String>> box = new Vector<>();
       static  Vector<String> imp = new Vector<>();
        public static void form(){
          for (i=0 ; i <= bits; i++) {
            num.add(new Vector<String>());
            check.add(new Vector<Boolean>());
            box.add(new Vector<String>());
        }
        }
        public static void elements(int digit){
        
          
            gp = Integer.bitCount(digit);
            binary1 = Integer.toBinaryString(digit);
            binary2 = "";
            for (j = 0; j < bits - binary1.length(); j++) {
                binary2 += "0";
            }
            binary2 += binary1;
            //System.out.println(binary2);
            num.get(gp).add(binary2);
            check.get(gp).add(Boolean.FALSE);
        }
        
        public static void delements(int digit){
        
            
            gp = Integer.bitCount(digit);
            binary1 = Integer.toBinaryString(digit);
            binary2 = "";
            for (j = 0; j < bits - binary1.length(); j++) {
                binary2 += "0";
            }
            binary2 += binary1;
            num.get(gp).add(binary2);
            check.get(gp).add(Boolean.FALSE);
        
        }
        static int index;

    public static int changes(String word1, String word2, int bits) {
        int itr, changes = 0;
        for (itr = 0; itr < bits; itr++) {
            if (word1.charAt(itr) != word2.charAt(itr)) {
                changes++;
                index = itr;
            }
        }
        return changes;
    }

    public static String prime(String word, int bits) {
        int itr;
        String a = "";
        char c = 'A';
        for (itr = 0; itr < bits; itr++) {
            if (word.charAt(itr) == '0') {
                a = a + (c++) + "'";
            } else if (word.charAt(itr) == '1') {
                a += c++;
           
 } else if (word.charAt(itr) == '_') {
                c++;
            }
        }
        return a;
    }
    public  void theend(){
    while (end) {
        test2.textarea1+="\n"+"Step"+(++test2.steps)+"\n"+"-----"+"\n";
        
            for (i = 0; i < num.size() - 1; i++) {
                test2.textarea1+="Group"+String.valueOf(i)+"\n";
                for (j = 0; j < num.get(i).size(); j++) {
                    for (k = 0; k < num.get(i + 1).size(); k++) {
                        count = changes(num.get(i).get(j), num.get(i + 1).get(k), bits);
                        if (count == 1) {
                            check.get(i).set(j, TRUE);
                            check.get(i + 1).set(k, TRUE);
                            strbox = num.get(i).get(j);
                            strbox2 = strbox.substring(0, index) + '_' + strbox.substring(index + 1);
                            box.get(i).add(strbox2);
                        }
                    }
                    if (check.get(i).get(j) == false) {
                        //prime(num.get(i).get(j), bits);
                       
                        if (imp.contains(num.get(i).get(j))) {
                        } else {
                            test2.textarea1+=num.get(i).get(j)+"*"+"\n";
                            imp.add(num.get(i).get(j));
                        }
                        num.get(i).remove(j);
                        check.get(i).remove(j);
                        j--;
                    }
              
                }
                for(m=0 ;m<num.get(i).size();m++){
                test2.textarea1+=(num.get(i).get(m)+"\n");
                }
                num.get(i).clear();
                num.get(i).addAll(box.get(i));
                box.get(i).clear();
                check.get(i).clear();
                for (m = 0; m < num.get(i).size(); m++) {
                    check.get(i).add(Boolean.FALSE);
                }

            }
            if (num.get(num.size() - 1).size() != 0) {
                for (m = 0; m < num.get(num.size() - 1).size(); m++) {
                    if (check.get(check.size() - 1).get(m) == false) {
                        if (imp.contains(num.get(num.size() - 1).get(m))) {
                        } else {
                         test2.textarea1+=num.get(num.size() - 1).get(m)+"*"+"\n";
                            imp.add(num.get(num.size() - 1).get(m));
                        }
                        num.get(num.size() - 1).remove(m);
                        check.get(num.size() - 1).remove(m);
                    }
                    else{//test2.textarea1+=num.get(num.size() - 1).get(m)+"\n";
                        num.get(num.size() - 1).remove(m);
                        check.get(num.size() - 1).remove(m);}
                }
            }
            for (m = 0; m < num.size(); m++) {
                if (num.get(m).size() != 0) {
                    end = true;
                    break;
                } else {
                    end = false;

                }
            }
        }
        for (m = 0; m < imp.size(); m++) {
           test2.testarea2 +=prime(imp.get(m), bits)+"\n";
        }
    }
}
