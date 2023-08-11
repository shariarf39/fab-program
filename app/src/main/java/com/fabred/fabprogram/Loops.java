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

public class Loops extends AppCompatActivity {

    private ListView request_list;
    SharedPreferences sharedPreferences;
    HashMap<String, String> hashMap;
    ArrayList<HashMap<String, String>> arrayList = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.oops);

        request_list = findViewById(R.id.listview);


        sharedPreferences = getSharedPreferences("fab_program", Context.MODE_PRIVATE);
        String element = sharedPreferences.getString("language", "Nothing");

        sharedPreferences = getSharedPreferences("basic_to_advance", Context.MODE_PRIVATE);


        if(element.equals("cpp")){
            hashMap = new HashMap<>();
            hashMap.put("name", "data_types_tutorial.dart\nC++ offers the programmer a rich assortment of built-in as well as user defined data types. Following table lists down seven basic C++ data types −\n" +
                    "\n" +
                    "Type   Keyword\n" +
                    "---------------\n" +
                    "Boolean    bool\n" +
                    "Character    char\n" +
                    "Integer    int\n" +
                    "Floating point    float\n" +
                    "Double floating point    double\n" +
                    "Valueless    void\n" +
                    "Wide character    wchar_t");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "#include <iostream>\n" +
                    "using namespace std;\n" +
                    "\n" +
                    "int main() {\n" +
                    "   cout << \"Size of char : \" << sizeof(char) << endl;\n" +
                    "   cout << \"Size of int : \" << sizeof(int) << endl;\n" +
                    "   cout << \"Size of short int : \" << sizeof(short int) << endl;\n" +
                    "   cout << \"Size of long int : \" << sizeof(long int) << endl;\n" +
                    "   cout << \"Size of float : \" << sizeof(float) << endl;\n" +
                    "   cout << \"Size of double : \" << sizeof(double) << endl;\n" +
                    "   cout << \"Size of wchar_t : \" << sizeof(wchar_t) << endl;\n" +
                    "\n" +
                    "   return 0;\n" +
                    "}");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\nSize of char : 1\n" +
                    "Size of int : 4\n" +
                    "Size of short int : 2\n" +
                    "Size of long int : 4\n" +
                    "Size of float : 4\n" +
                    "Size of double : 8\n" +
                    "Size of wchar_t : 4");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Several of the basic types can be modified using one or more of these type modifiers −\n" +
                    "\n" +
                    "\uD83D\uDCA0 signed\n" +
                    "\uD83D\uDCA0 unsigned\n" +
                    "\uD83D\uDCA0 short\n" +
                    "\uD83D\uDCA0 long\n" +
                    "\n" +
                    "\uD83D\uDCA0 This example uses endl, which inserts a new-line character after every line and << operator is being used to pass multiple values out to the screen. We are also using sizeof() operator to get size of various data types.'''),\n" +
                    "");
            arrayList.add(hashMap);


        } else if (element.equals("java")) {

            hashMap = new HashMap<>();
            hashMap.put("name", "Data Types in Java\nData types specify the different sizes and values that can be stored in the variable. There are two types of data types in Java:\n" +
                    "\n" +
                    "Primitive data types: The primitive data types include boolean, char, byte, short, int, long, float and double.\n" +
                    "Non-primitive data types: The non-primitive data types include Classes, Interfaces, and Arrays.\n" +
                    "Java Primitive Data Types\n" +
                    "In Java language, primitive data types are the building blocks of data manipulation. These are the most basic data types available in Java language.\n" +
                    "\n" +
                    "Java is a statically-typed programming language. It means, all variables must be declared before its use. That is why we need to declare variable's type and name.\n" +
                    "\n" +
                    "There are 8 types of primitive data types:\n" +
                    "\n" +
                    "boolean data type\n" +
                    "byte data type\n" +
                    "char data type\n" +
                    "short data type\n" +
                    "int data type\n" +
                    "long data type\n" +
                    "float data type\n" +
                    "double data type");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "int myNum = 100000;\n" +
                    "System.out.println(myNum);");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\n100000");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "int myNum = 5;   // Integer (whole number)\n" +
                    "float myFloatNum = 5.99f;    // Floating point number\n" +
                    "char myLetter = 'D';         // Character\n" +
                    "boolean myBool = true;       // Boolean\n" +
                    "String myText = \"Hello\";     // String");
            arrayList.add(hashMap);





        }else if (element.equals("py")) {

            hashMap = new HashMap<>();
            hashMap.put("name", "Python Data Types\nData types are the classification or categorization of data items. It represents the kind of value that tells what operations can be performed on a particular data. Since everything is an object in Python programming, data types are actually classes and variables are instance (object) of these classes.\n" +
                    "\n" +
                    "Following are the standard or built-in data type of Python:\n" +
                    "\n" +
                    "Numeric\n" +
                    "Sequence Type\n" +
                    "Boolean\n" +
                    "Set\n" +
                    "Dictionary");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "# Python program to \n" +
                    "# demonstrate numeric value\n" +
                    "\n" +
                    "a = 5\n" +
                    "print(\"Type of a: \", type(a))\n" +
                    "\n" +
                    "b = 5.0\n" +
                    "print(\"\\nType of b: \", type(b))\n" +
                    "\n" +
                    "c = 2 + 4j\n" +
                    "print(\"\\nType of c: \", type(c))");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\nType of a:  <class 'int'>\n" +
                    "\n" +
                    "Type of b:  <class 'float'>\n" +
                    "\n" +
                    "Type of c:  <class 'complex'>");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "This is how datatypes works!");
            arrayList.add(hashMap);



        }else if (element.equals("js")) {

            hashMap = new HashMap<>();
            hashMap.put("name", "JS Data-types\nA value in JavaScript is always of a certain type. For example, a string or a number.\n" +
                    "\n" +
                    "There are eight basic data types in JavaScript. Here, we’ll cover them in general and in the next chapters we’ll talk about each of them in detail.\n" +
                    "\n" +
                    "We can put any type in a variable. For example, a variable can at one moment be a string and then store a number:");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "/ BigInt value\n" +
                    "const value1 = 900719925124740998n;\n" +
                    "\n" +
                    "// Adding two big integers\n" +
                    "const result1 = value1 + 1n;\n" +
                    "console.log(result1); // \"900719925124740999n\"\n" +
                    "\n" +
                    "const value2 = 900719925124740998n;\n" +
                    "\n" +
                    "// Error! BitInt and number cannot be added\n" +
                    "const result2 = value2 + 1; \n" +
                    "console.log(result2);");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Output:\n900719925124740999n\n" +
                    "Uncaught TypeError: Cannot mix BigInt and other types");
            arrayList.add(hashMap);

            hashMap = new HashMap<>();
            hashMap.put("name", "Note: BigInt was introduced in the newer version of JavaScript and is not supported by many browsers including Safari.");
            arrayList.add(hashMap);





        }else{

            Toast.makeText(this, "Error app Please Try Again Later", Toast.LENGTH_SHORT).show();
        }












        Loops.MyAdapter myadapter = new Loops.MyAdapter();
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