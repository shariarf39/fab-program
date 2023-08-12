package com.fabred.fabprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class Functions extends AppCompatActivity {
    private ListView request_list;
    SharedPreferences sharedPreferences;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.functions);


        request_list = findViewById(R.id.listview);


        sharedPreferences = getSharedPreferences("fab_program", Context.MODE_PRIVATE);
        String element = sharedPreferences.getString("language", "Nothing");

        sharedPreferences = getSharedPreferences("basic_to_advance", Context.MODE_PRIVATE);


        if(element.equals("cpp")){
            hashMap = new HashMap<>();
            hashMap.put("name", "Function in C++\nhe function in C++ language is also known as procedure or subroutine in other programming languages.\n" +
                    "\n" +
                    "To perform any task, we can create function. A function can be called many times. It provides modularity and code reusability.\n" +
                    "Advantage of functions in C\n" +
                    "There are many advantages of functions.\n" +
                    "\n" +
                    "1) Code Reusability\n" +
                    "\n" +
                    "By creating functions in C++, you can call it many times. So we don't need to write the same code again and again.\n" +
                    "\n" +
                    "2) Code optimization\n" +
                    "\n" +
                    "It makes the code optimized, we don't need to write much code.\n" +
                    "\n" +
                    "Suppose, you have to check 3 numbers (531, 883 and 781) whether it is prime number or not. Without using function, you need to write the prime number logic 3 times. So, there is repetition of code.\n" +
                    "\n" +
                    "But if you use functions, you need to write the logic only once and you can reuse it several times.\n" +
                    "Types of Functions\n" +
                    "There are two types of functions in C programming:\n" +
                    "\n" +
                    "1. Library Functions: are the functions which are declared in the C++ header files such as ceil(x), cos(x), exp(x), etc.\n" +
                    "\n" +
                    "2. User-defined functions: are the functions which are created by the C++ programmer, so that he/she can use it many times. It reduces complexity of a big program and optimizes the code.\n" +
                    "Declaration of a function\n" +
                    "The syntax of creating function in C++ language is given below:");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "#include <iostream>\n" +
                    "using namespace std;\n" +
                    "void func() {\n" +
                    "   static int i=0; //static variable\n" +
                    "   int j=0; //local variable\n" +
                    "   i++;\n" +
                    "   j++;\n" +
                    "   cout<<\"i=\" << i<<\" and j=\" <<j<<endl;\n" +
                    "}\n" +
                    "int main()\n" +
                    "{\n" +
                    " func();\n" +
                    " func();\n" +
                    " func();\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Outputs:\n\n" +
                    "      sampleProgramOutput: '''i= 1 and j= 1\n" +
                    "i= 2 and j= 1\n" +
                    "i= 3 and j= 1");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "return_type function_name(data_type parameter...)\n" +
                    "{\n" +
                    "//code to be executed\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Call by value in C++\nThere are two ways to pass value or data to function in C language: call by value and call by reference. Original value is not modified in call by value but it is modified in call by reference.\n" +
                    "Let's understand call by value and call by reference in C++ language one by one.\n" +
                    "Call by value in C++\n" +
                    "In call by value, original value is not modified.\n" +
                    "\n" +
                    "In call by value, value being passed to the function is locally stored by the function parameter in stack memory location. If you change the value of function parameter, it is changed for the current function only. It will not change the value of variable inside the caller method such as main().\n" +
                    "\n" +
                    "Let's try to understand the concept of call by value in C++ language by the example given below:");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "#include <iostream>\n" +
                    "using namespace std;\n" +
                    "void change(int data);\n" +
                    "int main()\n" +
                    "{\n" +
                    "int data = 3;\n" +
                    "change(data);\n" +
                    "cout << \"Value of the data is: \" << data<< endl;\n" +
                    "return 0;\n" +
                    "}\n" +
                    "void change(int data)\n" +
                    "{\n" +
                    "data = 5;\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\nValue of the data is: 3");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Call by value in C++\n In call by reference, original value is modified because we pass reference (address).\n" +
                    "\n" +
                    "Here, address of the value is passed in the function, so actual and formal arguments share the same address space. Hence, value changed inside the function, is reflected inside as well as outside the function.\n" +
                    "\n" +
                    "Note: To understand the call by reference, you must have the basic knowledge of pointers.\n" +
                    "\n" +
                    "Let's try to understand the concept of call by reference in C++ language by the example given below:");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "#include<iostream>\n" +
                    "using namespace std;\n" +
                    "void swap(int *x, int y)\n" +
                    "{\n" +
                    " int swap;\n" +
                    " swap=x;\n" +
                    " x=y;\n" +
                    " *y=swap;\n" +
                    "}\n" +
                    "int main()\n" +
                    "{\n" +
                    " int x=500, y=100;\n" +
                    " swap(&x, &y);  // passing value to function\n" +
                    " cout<<\"Value of x is: \"<<x<<endl;\n" +
                    " cout<<\"Value of y is: \"<<y<<endl;\n" +
                    " return 0;\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Outputs:\nValue of x is: 100\n" +
                    "Value of y is: 500");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Function Recursion\n When function is called within the same function, it is known as recursion in C++. The function which calls the same function, is known as recursive function.\n" +
                    "\n" +
                    "A function that calls itself, and doesn't perform any task after function call, is known as tail recursion. In tail recursion, we generally call the same function with return statement.\n" +
                    "\n" +
                    "C++ Recursion Example\n" +
                    "Let's see an example to print factorial number using recursion in C++ language.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "#include<iostream>\n" +
                    "using namespace std;\n" +
                    "int main()\n" +
                    "{\n" +
                    "int factorial(int);\n" +
                    "int fact,value;\n" +
                    "cout<<\"Enter any number: \";\n" +
                    "cin>>value;\n" +
                    "fact=factorial(value);\n" +
                    "cout<<\"Factorial of a number is: \"<<fact<<endl;\n" +
                    "return 0;\n" +
                    "}\n" +
                    "int factorial(int n)\n" +
                    "{\n" +
                    "if(n<0)\n" +
                    "return(-1); /Wrong value/\n" +
                    "if(n==0)\n" +
                    "return(1);  /Terminating condition/\n" +
                    "else\n" +
                    "{\n" +
                    "return(n*factorial(n-1));\n" +
                    "}\n" +
                    "}");
            arrayList.add(hashMap);


            hashMap = new HashMap<>();
            hashMap.put("name", "Outputs:\nEnter any number: 5\n" +
                    "Factorial of a number is: 120");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "recursionfunction(){\n" +
                    "recursionfunction(); //calling self function\n" +
                    "}");
            arrayList.add(hashMap);



        } else if (element.equals("java")) {

            hashMap = new HashMap<>();
            hashMap.put("name", "Java Methods\nIn general, a method is a way to perform some task. Similarly, the method in Java is a collection of instructions that performs a specific task. It provides the reusability of code. We can also easily modify code using methods. In this section, we will learn what is a method in Java, types of methods, method declaration, and how to call a method in Java.\n" +
                    "\n" +
                    "What is a method in Java?\n" +
                    "A method is a block of code or collection of statements or a set of code grouped together to perform a certain task or operation. It is used to achieve the reusability of code. We write a method once and use it many times. We do not require to write code again and again. It also provides the easy modification and readability of code, just by adding or removing a chunk of code. The method is executed only when we call or invoke it.\n" +
                    "Method Declaration\n" +
                    "The method declaration provides information about method attributes, such as visibility, return-type, name, and arguments. It has six components that are known as method header, as we have shown in the following figure. Method Declaration\n" +
                    "The method declaration provides information about method attributes, such as visibility, return-type, name, and arguments. It has six components that are known as method header, as we have shown in the following figure. Method Signature: Every method has a method signature. It is a part of the method declaration. It includes the method name and parameter list.\n" +
                    "\n" +
                    "Access Specifier: Access specifier or modifier is the access type of the method. It specifies the visibility of the method. Java provides four types of access specifier:\n" +
                    "\n" +
                    "Public: The method is accessible by all classes when we use public specifier in our application.\n" +
                    "Private: When we use a private access specifier, the method is accessible only in the classes in which it is defined.\n" +
                    "Protected: When we use protected access specifier, the method is accessible within the same package or subclasses in a different package.\n" +
                    "Default: When we do not use any access specifier in the method declaration, Java uses default access specifier by default. It is visible only from the same package only.\n" +
                    "Return Type: Return type is a data type that the method returns. It may have a primitive data type, object, collection, void, etc. If the method does not return anything, we use void keyword.\n" +
                    "\n" +
                    "Method Name: It is a unique name that is used to define the name of a method. It must be corresponding to the functionality of the method. Suppose, if we are creating a method for subtraction of two numbers, the method name must be subtraction(). A method is invoked by its name.\n" +
                    "\n" +
                    "Parameter List: It is the list of parameters separated by a comma and enclosed in the pair of parentheses. It contains the data type and variable name. If the method has no parameter, left the parentheses blank.\n" +
                    "\n" +
                    "Method Body: It is a part of the method declaration. It contains all the actions to be performed. It is enclosed within the pair of curly braces.\n" +
                    "\n" +
                    "Naming a Method\n" +
                    "While defining a method, remember that the method name must be a verb and start with a lowercase letter. If the method name has more than two words, the first name must be a verb followed by adjective or noun. In the multi-word method name, the first letter of each word must be in uppercase except the first word. For example:\n" +
                    "\n" +
                    "Single-word method name: sum(), area()\n" +
                    "\n" +
                    "Multi-word method name: areaOfCircle(), stringComparision()\n" +
                    "\n" +
                    "It is also possible that a method has the same name as another method name in the same class, it is known as method overloading.\n" +
                    "\n" +
                    "Types of Method\n" +
                    "There are two types of methods in Java:\n" +
                    "\n" +
                    "Predefined Method\n" +
                    "User-defined Method\n" +
                    "Predefined Method\n" +
                    "In Java, predefined methods are the method that is already defined in the Java class libraries is known as predefined methods. It is also known as the standard library method or built-in method. We can directly use these methods just by calling them in the program at any point. Some pre-defined methods are length(), equals(), compareTo(), sqrt(), etc. When we call any of the predefined methods in our program, a series of codes related to the corresponding method runs in the background that is already stored in the library.\n" +
                    "\n" +
                    "Each and every predefined method is defined inside a class. Such as print() method is defined in the java.io.PrintStream class. It prints the statement that we write inside the method. For example, print(\"Java\"), it prints Java on the console.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "//user defined method\n" +
                    "public static void findEvenOdd(int num)\n" +
                    "{\n" +
                    "//method body\n" +
                    "if(num%2==0)\n" +
                    "System.out.println(num+\" is even\");\n" +
                    "else\n" +
                    "System.out.println(num+\" is odd\");\n" +
                    "}\n" +
                    "We have defined the above method named findevenodd(). It has a parameter num of type int. The method does not return any value that's why we have used void. The method body contains the steps to check the number is even or odd. If the number is even, it prints the number is even, else prints the number is odd.\n" +
                    "import java.util.Scanner;\n" +
                    "public class EvenOdd\n" +
                    "{\n" +
                    "public static void main (String args[])\n" +
                    "{\n" +
                    "//creating Scanner class object\n" +
                    "Scanner scan=new Scanner(System.in);\n" +
                    "System.out.print(\"Enter the number: \");\n" +
                    "//reading value from user\n" +
                    "int num=scan.nextInt();\n" +
                    "//method calling\n" +
                    "findEvenOdd(num);\n" +
                    "}\n" +
                    "//user defined method\n" +
                    "public static void findEvenOdd(int num)\n" +
                    "{\n" +
                    "//method body\n" +
                    "if(num%2==0)\n" +
                    "System.out.println(num+\" is even\");\n" +
                    "else\n" +
                    "System.out.println(num+\" is odd\");\n" +
                    "}\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\nnter the number: 12\n" +
                    "12 is even");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "We have defined the above method named findevenodd(). It has a parameter num of type int. The method does not return any value that's why we have used void. The method body contains the steps to check the number is even or odd. If the number is even, it prints the number is even, else prints the number is odd.");
            arrayList.add(hashMap);



        }else if (element.equals("py")) {

            hashMap = new HashMap<>();
            hashMap.put("name", "Python Function\nA function is a block of code which only runs when it is called.\n" +
                    "\n" +
                    "You can pass data, known as parameters, into a function.\n" +
                    "\n" +
                    "A function can return data as a result.\n" +
                    "\n" +
                    "Creating a Function\n" +
                    "In Python a function is defined using the def keyword:\n" +
                    "\n" +
                    "Example\n" +
                    "def my_function():\n" +
                    "  print(\"Hello from a function\")\n" +
                    "Calling a Function\n" +
                    "To call a function, use the function name followed by parenthesis:\n" +
                    "\n" +
                    "Example\n" +
                    "def my_function():\n" +
                    "  print(\"Hello from a function\")\n" +
                    "\n" +
                    "my_function()");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "#!/usr/bin/python\n" +
                    "\n" +
                    "# Function definition is here\n" +
                    "def changeme( mylist ):\n" +
                    "   \"This changes a passed list into this function\"\n" +
                    "   mylist = [1,2,3,4]; # This would assig new reference in mylist\n" +
                    "   print \"Values inside the function: \", mylist\n" +
                    "   return\n" +
                    "\n" +
                    "# Now you can call changeme function\n" +
                    "mylist = [10,20,30];\n" +
                    "changeme( mylist );\n" +
                    "print \"Values outside the function: \", mylist");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Outputs:\nValues inside the function:  [1, 2, 3, 4]\n" +
                    "Values outside the function:  [10, 20, 30]");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "The parameter mylist is local to the function changeme. Changing mylist within the function does not affect mylist.");
            arrayList.add(hashMap);



        }else if (element.equals("js")) {

            hashMap = new HashMap<>();
            hashMap.put("name", "JS Function\nJavaScript provides functions similar to most of the scripting and programming languages.\n" +
                    "\n" +
                    "In JavaScript, a function allows you to define a block of code, give it a name and then execute it as many times as you want.\n" +
                    "\n" +
                    "A JavaScript function can be defined using function keyword.\n" +
                    "\n" +
                    "Syntax:\n" +
                    "//defining a function\n" +
                    "function <function-name>()\n" +
                    "{\n" +
                    "    // code to be executed\n" +
                    "};\n" +
                    "\n" +
                    "//calling a function\n" +
                    "<function-name>();");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "function ShowMessage(firstName, lastName) {\n" +
                    "    alert(\"Hello \" + firstName + \" \" + lastName);\n" +
                    "}\n" +
                    "\n" +
                    "ShowMessage(\"Steve\", \"Jobs\");");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Outputs:\nHello Steve Jobs");
            arrayList.add(hashMap);



        }else{

            Toast.makeText(this, "Error app Please Try Again Later", Toast.LENGTH_SHORT).show();
        }












        Functions.MyAdapter myadapter = new Functions.MyAdapter();
        request_list.setAdapter(myadapter);
    }

    // Base Adapter
    public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {

            return arrayList.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            //Grid-View Logo


            LayoutInflater layoutInflater = getLayoutInflater();
            View Myview = layoutInflater.inflate(R.layout.item_data_type, null);
            TextView item = Myview.findViewById(R.id.item_text);

            hashMap = arrayList.get(i);


            item.setText(hashMap.get("name"));


            return Myview;
        }
    }
}