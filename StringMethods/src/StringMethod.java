
public class StringMethod {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// (1)length of the string
	//========================	
 /*        String str = "Java";//literal java
		//it is created in pool, because this literal(constant)
		//it is not created in heap
		int l = str.length();// these are the return types of the methods
		//by using the dot(.) operator , we can call the methods of a class.
		
		// result will be "4".
		// it counts the characters of the string, that gives the length of the string.
		System.out.println(l);
	}*/
	
/*	(2)// change to lowerCase
 *     ========================
	
		// String objects are immutable(they can't change)
		//it will take the string and creates new string with all the lower cases and then it retuns the new string.
		String str1 = str.toLowerCase();
		System.out.println(str1);
	}*/
		
	/*(3)//Change to upperCase
	 *  ======================
		String str = "java";
		String str2 = str.toUpperCase();
		System.out.println(str2);// the result will be stored in heap
}*/
	/*
		
	//(4) String trim()--- removing the blank spaces
	 * ================
		String str = "  Welcome   ";
		String str3 = str.trim();
		System.out.println(str3);
	}*/
	
	//(5)SubString- it will give a part of a String as a new String
	//	==========   (for that we have to mention the index
		
/*		String str = "Welcome";
	String sub=	str.substring(3);//this substring(int beginIndex)
	String sub1 = str.substring(2, 6);//this substring(int beginIndex, int endIndex)
	System.out.println(sub);
	System.out.println(sub1);
		}*/
	
//(6)String Replace --- this takes the old character and replace with the new character	
//=================
	/*	String str = "Welcome";
		String str1 = str.replace('e', 'k');//replace(char oldChar, char newChar)
		System.out.println(str1);
	
	}*/
	
String  str = new String(" netbeans");
/*int len = str.length();//it is important that what is the type of value a method is returning.
System.out.println(len);*/


/*String str2 = str.toUpperCase();//it will return the string
System.out.println(str2);*/
System.out.println(str);
String str3 = str.trim();
System.out.println(str3);
	}	
}


