package com.example.quizapp;// QuestionBank.java


public class QuestionBank {

    public static String questions[]= {
            "Who invented Java Programming?",
            "Which statement is true about Java?",
            "Which component is used to compile, debug, and execute the Java programs?",
            "Which one of the following is not a Java feature?",
            "Which of these cannot be used for a variable name in Java?",
            "What is the extension of java code files?",
            "Which of the following is not an OOPS concept in Java?",
            " What is not the use of “this” keyword in Java?",
            " What will be the error in the following Java code?\n" +
                    "\n" +
                    "    byte b = 50;\n" +
                    "    b = b * 50;",
            "Which of the following is a type of polymorphism in Java Programming?",
            "What is Truncation in Java?",
            " What is the extension of compiled java classes?",
            "Which exception is thrown when java is out of memory?",
            "Which of these are selection statements in Java?",
            "Which of these keywords is used to define interfaces in Java?",
            "Which of the following is a superclass of every class in Java?",
            "Host URL is having length of content 127",
            "Which of the below is not a Java Profiler?",
            "Which of these packages contains the exception Stack Overflow in Java?",
            "Which of these statements is incorrect about Thread?"

    };
    public static String choices[][]= {
            {"Guido van Rossum", "James Gosling", "Dennis Ritchie", "Bjarne Stroustrup"},
            {"Java is a sequence-dependent programming language",
                    "Java is a code-dependent programming language",
                    "Java is a platform-dependent programming language",
                    "Java is a platform-independent programming language"},
            {"JRE", "JIT", "JDK", "JVM"},
            {"Object-oriented", "Use of pointers", "Portable", "Dynamic and Extensible"},
            {"identifier & keyword", "identifier", "keyword", "none of the mentioned"},
            {".js",".txt",".class"," .java"},
            {"Polymorphism"," Inheritance","Compilation","Encapsulation"},
            {"Referring to the instance variable when a local variable has the same name","Passing itself to the method of the same class","Passing itself to another method"," Calling another constructor in constructor chaining"},
            {"b cannot contain value 50","b cannot contain value 100, limited by its range","No error in this code","* operator has converted b * 50 into int, which can not be converted to byte without casting"},
            {"Multiple polymorphism","Compile time polymorphism","Multilevel polymorphism","Execution time polymorphism"},
            {"Floating-point value assigned to a Floating type","Floating-point value assigned to an integer type"," Integer value assigned to floating type","Integer value assigned to floating type"},
            {".js",".txt",".class"," .java"},
            {"MemoryError","OutOfMemoryError","MemoryOutOfBoundsException","MemoryFullException"},
            {"break","continue","for()","if()"},
            {"intf"," Intf","interface","Interface"},
            {"ArrayList","Abstract class","Object class","String"},
            {"127","126","Runtime Error","Compilation Error"},
            {" JProfiler","Eclipse Profiler","JVM","JConsole"},
            {"java.io","java.system","java.lang"," java.util"},
            {"start() method is used to begin execution of the thread","run() method is used to begin execution of a thread before start() method in special cases"," A thread can be formed by implementing Runnable interface only","A thread can be formed by a class that extends Thread class"}

    };
    public static String correctAnswer[]={
            "James Gosling",
            "Java is a platform-independent programming language",
            "JDK",
            "Use of pointers",
            "keyword",
            ".java",
            "Compilation",
            "Passing itself to the method of the same class","" +
            "* operator has converted b * 50 into int, which can not be converted to byte without casting",
            "Compile time polymorphism","" +
            "Floating-point value assigned to an integer type",
            ".class",
            "OutOfMemoryError",
            "if()",
            "interface",
            "Object class",
            "127",
            "JVM",
            "java.lang",
            "run() method is used to begin execution of a thread before start() method in special cases"
    };
    public static String Python_questions[]={
                 "Who developed Python Programming Language?",
                 "Which type of Programming does Python support?",
                 "Is Python case sensitive when dealing with identifiers?",
                 "Is Python code compiled or interpreted?",
                 " What will be the value of the following Python expression?\n" +
                         "\n" +
                         "4 + 3 % 5",
            "Which of the following is used to define a block of code in Python language?",
            "Which keyword is used for function in Python language?",
            "Which of the following character is used to give single-line comments in Python?",
            "Which of the following functions can help us to find the version of python that we are currently",
            "Python supports the creation of anonymous functions at runtime, using a construct called __________",
            "What is the order of precedence in python?",
            "What will be the output of the following Python code snippet if x=1?",
            "What does pip stand for python?",
            "Which of the following is true for variable names in Python?",
            "Which of the following is the truncation division operator in Python?",
            "What will be the output of the following Python code?\n" +
                    "\n" +
                    "l=[1, 0, 2, 0, 'hello', '', []]\n" +
                    "list(filter(bool, l))",
            "Which of the following functions is a built-in function in python?",
            "Which of the following is the use of id() function in python?",
            "What will be the output of the following Python function?\n" +
                    "\n" +
                    "min(max(False,-3,-4), 2,7)",
            "Which of the following is not a core data type in Python programming?",

         };
    public static  String Python_choices[][]={
                 {"Wick van Rossum","Rasmus Lerdorf","Guido van Rossum","Niene Stom"},
                 {" object-oriented programming","structured programming","functional programming"," all of the mentioned"},
                 {"no","yes","machine dependent","none of the mentioned"},
                 {"Python code is only compiled","Python code is both compiled and interpreted","Python code is neither compiled nor interpreted","Python code is only interprete"},
                 {"7","2","1","4"},
            {"Indentation","Key","Brackets","All of the mentioned"},
            {"Function","def","Fun","Define"},
            {"//","#","!","/*"},
            {"sys.version(1)","sys.version(0)","sys.version()","sys.version"},
            {"Pi","anonymous","lambda","none of the mentioned"},
            {"Exponential, Parentheses, Multiplication, Division, Addition, Subtraction","Exponential, Parentheses, Division, Multiplication, Addition, Subtraction","Parentheses, Exponential, Multiplication, Division, Subtraction, Addition","Parentheses, Exponential, Multiplication, Division, Addition, Subtraction"},
            {"4","2","1","8"},
            {"Pip Installs Python","Pip Installs Packages","referred Installer Program","All of the mentioned"},
            {"underscore and ampersand are the only two special characters allowed","unlimited length","all private members must have leading and trailing underscores","none of the mentioned"},
            {"|","//","/","%"},
            {"[1, 0, 2, ‘hello’, ”, []]","Error","[1, 2, ‘hello’]","[1, 0, 2, 0, ‘hello’, ”, []]"},
            {" factorial()","print()","seed()","sqrt()"},
            {"Every object doesn’t have a unique id","Id returns the identity of the object","All of the mentioned","None of the mentioned"},
            {"-4","-3","2","False"},
            {"Tuples","Lists","Class","Dictionary"},



         };
    public static String Python_answer[]={
                 "Guido van Rossum",
                 "all of the mentioned",
                 "yes",
                 "Python code is both compiled and interpreted",
                 "7",
            "Indentation",
            "def",
            "#",
            "sys.version",
            "lambda",
            "Parentheses, Exponential, Multiplication, Division, Addition, Subtraction",
            "4",
            "Preferred Installer Program",
            "unlimited length",
            "//",
            "[1, 2, ‘hello’]",
            "print()",
            " Id returns the identity of the object",
            "False",
            "Class"
         };

    public static String C_question[]={
                " Who is the father of C language?",
                "Which of the following is not a valid C variable name?",
                "All keywords in C are in ____________",
                " Which is valid C expression?",
                " What will be the value of the following C expression?\n" +
                        "\n" +
                        "4 + 3 % 5",
            "Which of the following cannot be a variable name in C?",
            "What is short int in C programming?",
            "Which of the following declaration is not supported by C language?",
            "Which keyword is used to prevent any changes in the variable within a C program?",
            "What is the result of logical or relational expression in C?",
            "Which of the following typecasting is accepted by C language?",
            "Where in C the order of precedence of operators do not exist?",
            "Which of the following is NOT possible with any 2 operators in C?",
            "What is an example of iteration in C?",
            "Functions can return enumeration constants in C?",
            "Functions in C Language are always _________",
            "Which of following is not accepted in C?",
            "Property which allows to produce different executable for different platforms in C is called?",
            "What is #include <stdio.h>?",
            "C preprocessors can have compiler specific features."
        };
    public static  String C_choices[][]={
                {"Steve Jobs","James Gosling","Guido van Rossum","Dennis Ritchie"},
                {"int number;"," int variable_count;","float rate;","int $main;"},
                {" CamelCase letters","UpperCase letters","LowerCase letters","none of the mentioned"},
                {" int my_num = 100,000;","int my_num = 100000;","int my num = 1000;","int $my_num = 10000;"},
                {"7","2","1","4"},
            {"volatile","true","friend","export"},
            {"The basic data type of C","Qualifier","Short is the qualifier and int is the basic data type","All of the mentioned"},
            {"String str;","char *str;","float str = 3e2;","Both “String str;” and “float str = 3e2;”"},
            {"immutable","mutable","const","volatile"},
            {"True or False","0 or 1","0 if an expression is false and any positive number if an expression is true","None of the mentioned"},
            {"Widening conversions","Narrowing conversions","Widening & Narrowing conversions","None of the mentioned"},
            {"Within conditional statements, if, else","Within while, do-while","Within a macro definition","None of the mentioned"},
            {"Different precedence, same associativity","Different precedence, different associativity"," Same precedence, different associativity","All of the mentioned"},
            {"for","while","do-while","all of the above"},
            {"true","false","depends on the compiler","depends on the standard"},
            {"Internal","External","Both Internal and External","External and Internal are not valid terms for functions"},
            {"static a = 10; //static as","static int func (int); //parameter as static","static static int a; //a static variable prefixed with static","all of the mentioned"},
            {"File inclusion","Selective inclusion","Conditional compilation","Recursive macros"},
            {"Preprocessor directive"," Inclusion directive","File inclusion directive","None of the mentioned"},
            {"Ture","False","Depends on the standard","Depends on the platform"}

        };
    public static String C_answer[]={
                "Dennis Ritchie",
                "int $main;",
                "LowerCase letters",
                "int my_num = 100000;",
                "7",
            "volatile",
            "Short is the qualifier and int is the basic data type",
            "String str;",
            "const",
            "0 or 1",
            "Widening & Narrowing conversions",
            "None of the mentioned",
            "Same precedence, different associativity",
            "all of the above",
            "true",
            "External",
            "static static int a; //a static variable prefixed with static",
            "Conditional compilation",
            "Preprocessor directive",
            "True"
        };



}





