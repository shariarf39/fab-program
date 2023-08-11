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

public class Conditions extends AppCompatActivity {

    private ListView request_list;
    SharedPreferences sharedPreferences;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conditions);
        request_list = findViewById(R.id.listview);


        sharedPreferences = getSharedPreferences("fab_program", Context.MODE_PRIVATE);
        String element = sharedPreferences.getString("language", "Nothing");

        sharedPreferences = getSharedPreferences("basic_to_advance", Context.MODE_PRIVATE);


        if(element.equals("cpp")){
            hashMap = new HashMap<>();
            hashMap.put("name", "if Condition\nIn C++ programming, if statement is used to test the condition. There are various types of if statements in C++.\n" +
                    "\n" +
                    "if statement\n" +
                    "if-else statement\n" +
                    "nested if statement\n" +
                    "if-else-if ladder\n" +
                    "\n" +
                    "The C++ if statement tests the condition. It is executed if condition is true.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "#include <iostream>\n" +
                    "using namespace std;\n" +
                    "\n" +
                    "int main () {\n" +
                    "   int num = 10;\n" +
                    "            if (num % 2 == 0)\n" +
                    "            {\n" +
                    "                cout<<\"It is even number\";\n" +
                    "            }\n" +
                    "   return 0;\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output\nIt is even number");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "if(condition){\n" +
                    "//code to be executed\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "if-else Condition\nThe C++ if-else statement also tests the condition. It executes if block if condition is true otherwise else block is executed.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "#include <iostream>\n" +
                    "using namespace std;\n" +
                    "int main () {\n" +
                    "   int num = 11;\n" +
                    "            if (num % 2 == 0)\n" +
                    "            {\n" +
                    "                cout<<\"It is even number\";\n" +
                    "            }\n" +
                    "            else\n" +
                    "            {\n" +
                    "                cout<<\"It is odd number\";\n" +
                    "            }\n" +
                    "   return 0;\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\nIt is odd number");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "if(condition){\n" +
                    "//code if condition is true\n" +
                    "}else{\n" +
                    "//code if condition is false\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Switch\nC++ switch\n" +
                    "The C++ switch statement executes one statement from multiple conditions. It is like if-else-if ladder statement in C++.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "#include <iostream>\n" +
                    "using namespace std;\n" +
                    "int main () {\n" +
                    "       int num;\n" +
                    "       cout<<\"Enter a number to check grade:\";\n" +
                    "       cin>>num;\n" +
                    "           switch (num)\n" +
                    "          {\n" +
                    "              case 10: cout<<\"It is 10\"; break;\n" +
                    "              case 20: cout<<\"It is 20\"; break;\n" +
                    "              case 30: cout<<\"It is 30\"; break;\n" +
                    "              default: cout<<\"Not 10, 20 or 30\"; break;\n" +
                    "          }\n" +
                    "    }");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\nEnter a number:\n" +
                    "10\n" +
                    "It is 10");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "switch(expression){\n" +
                    "case value1:\n" +
                    " //code to be executed;\n" +
                    " break;\n" +
                    "case value2:\n" +
                    " //code to be executed;\n" +
                    " break;\n" +
                    "......\n" +
                    "\n" +
                    "default:\n" +
                    " //code to be executed if all cases are not matched;\n" +
                    " break;\n" +
                    "}");
            arrayList.add(hashMap);

        } else if (element.equals("java")) {

            hashMap = new HashMap<>();
            hashMap.put("name", "Java Control Statements | Control Flow in Java\nJava compiler executes the code from top to bottom. The statements in the code are executed according to the order in which they appear. However, Java provides statements that can be used to control the flow of Java code. Such statements are called control flow statements. It is one of the fundamental features of Java, which provides a smooth flow of program.\n" +
                    "\n" +
                    "Java provides three types of control flow statements.\n" +
                    "\n" +
                    "Decision Making statements\n" +
                    "if statements\n" +
                    "switch statement\n" +
                    "Loop statements\n" +
                    "do while loop\n" +
                    "while loop\n" +
                    "for loop\n" +
                    "for-each loop\n" +
                    "Jump statements\n" +
                    "break statement\n" +
                    "continue statement\n" +
                    "Decision-Making statements:\n" +
                    "As the name suggests, decision-making statements decide which statement to execute and when. Decision-making statements evaluate the Boolean expression and control the program flow depending upon the result of the condition provided. There are two types of decision-making statements in Java, i.e., If statement and switch statement.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "public class Student {\n" +
                    "public static void main(String[] args) {\n" +
                    "String address = \"Delhi, India\";\n" +
                    "\n" +
                    "if(address.endsWith(\"India\")) {\n" +
                    "    if(address.contains(\"Meerut\")) {\n" +
                    "      System.out.println(\"Your city is Meerut\");\n" +
                    "  } else if(address.contains(\"Noida\")) {\n" +
                    "        System.out.println(\"Your city is Noida\");\n" +
                    "  }else {\n" +
                    "    System.out.println(address.split(\",\")[0]);\n" +
                    "  }\n" +
                    " }else {\n" +
                    "      System.out.println(\"You are not living in India\");\n" +
                    "    }\n" +
                    "  }\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\n Delhi");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "The if-else-if statement contains the if-statement followed by multiple else-if statements. In other words, we can say that it is the chain of if-else statements that create a decision tree where the program may enter in the block of code where the condition is true. We can also define an else statement at the end of the chain.");
            arrayList.add(hashMap);




        }else if (element.equals("py")) {

            hashMap = new HashMap<>();
            hashMap.put("name", "Python if else\nThere comes situations in real life when we need to make some decisions and based on these decisions, we decide what should we do next. Similar situations arises in programming also where we need to make some decisions and based on these decisions we will execute the next block of code.\n" +
                    "\n" +
                    "Decision making statements in programming languages decides the direction of flow of program execution. Decision making statements available in python are:\n" +
                    "\n" +
                    "if statement\n" +
                    "if..else statements\n" +
                    "nested if statements\n" +
                    "if-elif ladder\n" +
                    "Short Hand if statement\n" +
                    "Short Hand if-else statement\n" +
                    "if statement\n" +
                    "\n" +
                    "if statement is the most simple decision making statement. It is used to decide whether a certain statement or block of statements will be executed or not i.e if a certain condition is true then a block of statement is executed otherwise not.\n" +
                    "\n" +
                    "Syntax:\n" +
                    "\n" +
                    "\n" +
                    "\n" +
                    "if condition:\n" +
                    "   # Statements to execute if\n" +
                    "   # condition is true\n" +
                    "Here, condition after evaluation will be either true or false. if statement accepts boolean values – if the value is true then it will execute the block of statements below it otherwise not. We can use condition with bracket ‘(‘ ‘)’ also.\n" +
                    "\n" +
                    "As we know, python uses indentation to identify a block. So the block under an if statement will be identified as shown in the below example:\n" +
                    "\n" +
                    "if condition:\n" +
                    "   statement1\n" +
                    "statement2\n" +
                    "\n" +
                    "# Here if the condition is true, if block \n" +
                    "# will consider only statement1 to be inside \n" +
                    "# its block.\n" +
                    "\n" +
                    "if- else\n" +
                    "\n" +
                    "The if statement alone tells us that if a condition is true it will execute a block of statements and if the condition is false it won’t. But what if we want to do something else if the condition is false. Here comes the else statement. We can use the else statement with if statement to execute a block of code when the condition is false.\n" +
                    "Syntax:\n" +
                    "\n" +
                    "if (condition):\n" +
                    "    # Executes this block if\n" +
                    "    # condition is true\n" +
                    "else:\n" +
                    "    # Executes this block if\n" +
                    "    # condition is false\n");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "# Python program to illustrate if-elif-else ladder\n" +
                    "#!/usr/bin/python\n" +
                    "\n" +
                    "i = 20\n" +
                    "if (i == 10):\n" +
                    "    print (\"i is 10\")\n" +
                    "elif (i == 15):\n" +
                    "    print (\"i is 15\")\n" +
                    "elif (i == 20):\n" +
                    "    print (\"i is 20\")\n" +
                    "else:\n" +
                    "    print (\"i is not present\")");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output: \ni is 20");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "The block of code following the else statement is executed as the condition present in the if statement is false after call the statement which is not in block(without spaces).");
            arrayList.add(hashMap);




        }else if (element.equals("js")) {

            hashMap = new HashMap<>();
            hashMap.put("name", "JS if-else\nThere are multiple different types of conditionals in JavaScript including:\n" +
                    "\n" +
                    "“If” statements: where if a condition is true it is used to specify execution for a block of code.\n" +
                    "“Else” statements: where if the same condition is false it specifies the execution for a block of code.\n" +
                    "“Else if” statements: this specifies a new test if the first condition is false.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "if (false) {\n" +
                    "      var outcome = \"if block\";\n" +
                    "} else if (true) {\n" +
                    "      var outcome = \"first else if block\";\n" +
                    "} else if (true) {\n" +
                    "      var outcome = \"second else if block\";\n" +
                    "} else {\n" +
                    "      var outcome = \"else block\";\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\n\"first else if block\"");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "An else if statement doesn’t need a following else statement to work. If none of the if or else if conditions pass, then JavaScript moves forward and doesn’t run any of the conditional blocks of code.");
            arrayList.add(hashMap);




        }else{

            Toast.makeText(this, "Error app Please Try Again Later", Toast.LENGTH_SHORT).show();
        }












        Conditions.MyAdapter myadapter = new Conditions.MyAdapter();
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
            View Myview = layoutInflater.inflate(R.layout.basic_item, null);
            TextView item = Myview.findViewById(R.id.item_text);

            hashMap = arrayList.get(i);


            item.setText(hashMap.get("name"));


            return Myview;
        }

    }
}