package com.fabred.fabprogram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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

public class Basic extends AppCompatActivity {

    private ListView request_list;
    SharedPreferences sharedPreferences;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic);
        request_list = findViewById(R.id.listview);

        sharedPreferences = getSharedPreferences("fab_program", Context.MODE_PRIVATE);
        String element = sharedPreferences.getString("language", "Nothing");



        if(element.equals("cpp")){

            hashMap = new HashMap<>();
            hashMap.put("name", "Hello World!\n'A \"Hello, World!\" is a simple program that outputs Hello, World! on the screen. Since it's a very simple program, it's often used to introduce a new programming language to a newbie.");
            arrayList.add(hashMap);

           hashMap = new HashMap<>();
            hashMap.put("name", "// Your First C++ Program\n" +
                    "\n" +
                    "#include <iostream>\n" +
                    "\n" +
                    "int main() {\n" +
                    "    std::cout << \"Hello World!\";\n" +
                    "    return 0;\n" +
                    "}");

            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output\nHello World!");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Let us look at the various parts of the above program −\n" +
                    "\n" +
                    "\uD83D\uDCA0 The C++ language defines several headers, which contain information that is either necessary or useful to your program. For this program, the header <iostream> is needed.\n" +
                    "\n" +
                    "\uD83D\uDCA0 The line using namespace std; tells the compiler to use the std namespace. Namespaces are a relatively recent addition to C++.\n" +
                    "\n" +
                    "\uD83D\uDCA0 The next line '// main() is where program execution begins.' is a single-line comment available in C++. Single-line comments begin with // and stop at the end of the line.\n" +
                    "\n" +
                    "\uD83D\uDCA0 The line int main() is the main function where program execution begins.\n" +
                    "\n" +
                    "\uD83D\uDCA0 The next line cout << \"Hello World\"; causes the message \"Hello World\" to be displayed on the screen." +
                    "\uD83D\uDCA0 The next line return 0; terminates main( )function and causes it to return the value 0 to the calling process.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Comments \nC++ supports single-line and multi-line comments. All characters available inside any comment are ignored by C++ compiler.\n" +
                    "\n" +
                    " For example −");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "#include <iostream>\n" +
                    "using namespace std;\n" +
                    "\n" +
                    "int main() {\n" +
                    "   cout << \"Hello World\"; // prints Hello World\n" +
                    "\n" +
                    "   return 0;\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output\nHello World");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "C++ comments start with /* and end with /.");
            arrayList.add(hashMap);


        } else if (element.equals("java")) {
            hashMap = new HashMap<>();
            hashMap.put("name", "Hello world!\n'In this section, we will learn how to write the simple program of Java. We can write a simple hello Java program easily after installing the JDK.\n" +
                    "\n" +
                    "To create a simple Java program, you need to create a class that contains the main method. Let's understand the requirement first.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "class Hello{\n" +
                    "    public static void main(String args[]){\n" +
                    "     System.out.println(\"Hello World\");\n" +
                    "    }\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\nHello World");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Let's see what is the meaning of class, public, static, void, main, String[], System.out.println().\n" +
                    "\n" +
                    "class keyword is used to declare a class in Java.\n" +
                    "public keyword is an access modifier that represents visibility. It means it is visible to all.\n" +
                    "static is a keyword. If we declare any method as static, it is known as the static method. The core advantage of the static method is that there is no need to create an object to invoke the static method. The main() method is executed by the JVM, so it doesn't require creating an object to invoke the main() method. So, it saves memory.\n" +
                    "void is the return type of the method. It means it doesn't return any value.\n" +
                    "main represents the starting point of the program.\n" +
                    "String[] args or String args[] is used for command line argument. We will discuss it in coming section.\n" +
                    "System.out.println() is used to print statement. Here, System is a class, out is an object of the PrintStream class, println() is a method of the PrintStream class. We will discuss the internal working of System.out.println() statement in the coming section.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Java comments\nComments can be used to explain Java code, and to make it more readable. It can also be used to prevent execution when testing alternative code.\n" +
                    "\n" +
                    "Single-line Comments\n" +
                    "Single-line comments start with two forward slashes (//).\n" +
                    "\n" +
                    "Any text between // and the end of the line is ignored by Java (will not be executed).\n" +
                    "\n" +
                    "This example uses a single-line comment before a line of code:");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "// This is a comment\n" +
                    "System.out.println(\"Hello World\");");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output: \n Hello World");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Single or multi-line comments?\n" +
                    "It is up to you which you want to use. Normally, we use // for short comments, and /* */ for longer.");
            arrayList.add(hashMap);





        }else if (element.equals("py")) {

            hashMap = new HashMap<>();
            hashMap.put("name", "Hello World\nIn this program, we have used the built-in print() function to print the string Hello, world! on our screen.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "print('Hello, world!')");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output\nHello, world!");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "In this program, we have used the built-in print() function to print the string Hello, world! on our screen.\n" +
                    "A simple program that displays “Hello, World!”. It's often used to illustrate the syntax of the language.");
            arrayList.add(hashMap);




        }else if (element.equals("js")) {
            hashMap = new HashMap<>();
            hashMap.put("name", "Hello World\nIn this example, you will learn to print 'Hello World' in JavaScript in three different ways.\n" +
                    "\n" +
                    "A \"Hello, World!\" is a simple program that prints Hello, World! on the screen. Since it's a very simple program, this program is often used to introduce a new programming language to beginners.");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "/ the hello world program\n" +
                    "console.log('Hello World');");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\nHello, World!");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Here, the first line is a comment.\n" +
                    "\n" +
                    "// the hello world program\n" +
                    "The second line\n" +
                    "\n" +
                    "console.log('Hello, World!');\n" +
                    "prints the 'Hello, World!' string to the console.");
            arrayList.add(hashMap);






        }else{

            Toast.makeText(this, "Error app Please Try Again Later", Toast.LENGTH_SHORT).show();
        }


        // Hash Map


        Basic.MyAdapter myadapter = new Basic.MyAdapter();
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