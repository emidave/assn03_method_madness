# Assignment 03 — Menu-Driven Methods Practice

In this project, you will build a menu-driven Java program that calls a set of helper
methods to perform different tasks (temperature conversion, distance conversion, acronym
generation, triangle printing, and finding the largest character in a `String`). This assignment is designed
to give you practice with **method calls**, **loops**, **conditionals**, **String processing**, and **console
interaction using a `Scanner`**. The menu you implement should repeatedly prompt the user until "Exit" is entered, and for each possible option, you will implement the corresponding methods as
specified in the instructions below.

All output formatting, spelling, spacing, capitalization, and punctuation must match
the examples given. Read every section carefully and follow the requirements precisely.

---

## Step 1: Implementing the main method’s menu ##

Write a main method that:

1. Instantiates a `Scanner` object to read user input.
2. Displays (prints) the following menu to the console exactly as follows:
```
Method Selection Menu
=======================
1. Temperature Conversion (Fahrenheit to Celsius)
2. Distance Conversion (Yards to Feet and Inches)
3. Get Acronym
4. Triangle Generator
5. Exit
=======================
Enter selection (1-5):
```
 
The following examples demonstrate your program's expected behavior for  each possible user input: 
| User Enters | Program Behavior |
|--------------|------------------|
| **1** | Call `doTempConversion(...)` |
| **2** | Call `doDistConversion(...)` |
| **3** | *(Prepare input as needed)* then call `doGetAcronym(...)` |
| **4** | Call `doTriangle(...)` |
| **5** | Print `Exiting...` and end the loop |
| **Any other number** | Print `Error: Invalid option` and re-display the menu |



### Input Rules
- Assume the user will enter an integer for the menu selection.
- Be sure to close the `Scanner` with the `close()` method and end the program after printing “Exiting…” to the console.
- Before calling option 3 (`doGetAcronym`), make sure the input buffer is ready to read a full line. What does this mean? Continue reading to find out!

#### 📘 Note: Flushing the Input Buffer

When using a `Scanner` to read input in Java, different methods handle the Enter key differently.

Methods like `nextInt()`, `nextDouble()`, and `next()` only read PART of the user’s input (for example, just the number). That is, these methods leave the newline character (\n) from the Enter key in what we call an "input buffer."

Contrastingly, methods like  `nextLine()` read the ENTIRE line of text that the user enters (up to the newline).

Because of this, if you call `nextLine()` right after using `nextInt()` or `nextDouble()`, your program might appear to “skip” the user’s input — because it will immediately read that leftover newline stored in the input buffer, instead of waiting for new input.

*In other words...*

The input buffer is like a waiting room for leftover characters that your program hasn’t read yet.

To clear this input buffer, we must add a simple statement to our menu program, which will read and discard that leftover newline:

``` java
scnr.nextLine(); // clears the leftover newline from the buffer
```

🧩 Example: ***Without Flushing***

``` java
Scanner scnr = new Scanner(System.in);`

System.out.print("Enter a number: ");
int num = scnr.nextInt();    // user types 42⏎

System.out.print("Enter a word: ");
String word = scnr.nextLine();  // <-- immediately reads the leftover newline*
System.out.println("You entered: " + word);
```

### User Input:
```
42
hello
```

### Output:
```
Enter a number: 42
Enter a word: You entered:
```

😕 As you can see, without flushing, the program never lets the user type “hello”!
That’s because `nextLine()` grabbed the leftover newline instead of waiting for the user to first type another input.


✅ Example: ***With Flushing***
``` java
Scanner scnr = new Scanner(System.in);

System.out.print("Enter a number: ");
int num = scnr.nextInt();    // user types 42⏎

// flush the input buffer
scnr.nextLine();

System.out.print("Enter a word: ");
String word = scnr.nextLine();   // now it works correctly
System.out.println("You entered: " + word);
```

### User Input:
```
42
hello
```

### Output:
```
Enter a number: 42
Enter a word: You entered: hello
```

However, when we flush the buffer by including the statement `scnr.nextLine()`, our program's behavior now works! ✅ 

In this assignment, you will need to similarly flush the input buffer before reading a full line of text (specifically, in Option 3: Get Acronym) to ensure the user’s input is read correctly.



 

After coding this interactive menu, you will need to code the methods for the program to work!

### Part 01-Temperature Conversion 
Implement the following methods: 

1. `fahrenheitToCelsius`: A public static method that when called and passed a temperature 
value in Fahrenheit will compute and return the equivalent Celsius temperature value. 
Note that the Fahrenheit to Celsius formula is C = (5/9)(F-32).

2. `doTempConversion`: This method is partially implemented and is called by the menu in the main method. Your job is to add the following: 1) Use the `Scanner` passed as a parameter to prompt the user to enter a temperature value in Fahrenheit. 2) Collect and store the user's input in a double variable. 3) Call the `fahrenheitToCelsius` method, passing the user input as an argument. 4) Store the value returned by the 
`fahrenheitToCelsius` method in another double variable. 5) Display the Celsius equivalent value as shown in the examples below. 

 
Here are some examples of what the user should see when the program runs: 

| Example | User Input | Expected Console Output |
|----------|-------------|--------------------------|
| **1** | `100` | `Enter temperature in Fahrenheit : 100` <br> `100.00 degrees Fahrenheit is 37.78 Celsius` |
| **2** | `-20.25` | `Enter temperature in Fahrenheit : -20.25` <br> `-20.25 degrees Fahrenheit is -29.03 Celsius` |

For the given inputs, make sure that your program output looks **exactly** like the examples above —  including spelling, capitalization, punctuation, spaces, and decimal points.

---

### 🧮 Formatting Tip

You can use the `printf` method to format your outputs so they display exactly two decimal places, as demonstrated below:

```java
double totalCost = 19.9875;
// %.2f = floating-point number rounded to 2 decimal places
System.out.printf("Your total cost is $%.2f\n", totalCost);
```


### Part 02-Distance Conversion 
Implement the following methods: 

1. `yardsToFeetAndInches`: A public static method that when called and passed a distance value in yards will compute and return a String value with the equivalent distance in feet 
and inches. Note that a yard is 36 inches (a yard is also 3 feet) and that a foot is 12 inches. Also, a single quote mark is a common notation for a value specified in feet (for 
example, 3 feet is expressed as 3')  and a double quote mark is a common notation for a value specified in inches (for example, 7.5 inches is often expressed as 7.5"). In your implementation, you may need to cast or convert some values from one data type to another. You can also use the `String.format` static method to construct a `String` value with a specified number of decimal places.

2. `doDistConversion`: This method is partially implemented and is called by the menu in the 
main method. Your job is to add the following: 1) Prompt the user to enter a distance in yards. 2) Collect and store the user input in a double variable. 3) Call the   `yardsToFeetAndInches` method, passing the user input as an argument. 4) Store the value returned by the `yardsToFeetAndInches` method in another String variable. 5) Display the equivalent feet and inches value as shown in the examples below. 

Here are some examples showing what the value returned by your `yardsToFeetAndInches` method should be for different argument values: 


### 📏 Example Output for Distance Conversion

| Example | User Input | Expected Console Output |
|----------|-------------|--------------------------|
| **1** | `10.25` | `Enter distance in Yards : 10.25`<br> `10.25 yards in Feet and Inches is : 30' 9.00"`|
| **2** | `100` | `Enter distance in Yards : 100` <br> `100.00 yards in Feet and Inches is : 300' 0.00"` |
| **3** | `0` | `Enter distance in Yards : 0` <br>`0.00 yards in Feet and Inches is : 0' 0.00"` |

Again, make sure that your program output precisely follows the formatting of examples above.

---


### Part 03-Get Acronym 
Implement the following methods: 

1. `getAcronym`: A public static method that when called and passed a String must compute and return a String value that contains just the capitalized first letter of each word. Note: 
the arguments to this method will always be a String containing one or more words, and the words will always be separated by a single space character, and a space character 
will always be followed by another word. 

2. `doGetAcronym`: This method is partially implemented and is called by the menu in the 
main method. Your job is to add the following: 1) Prompt the user to enter some words. 2) Collect and store the user's input in a String variable. 3) Call the `getAcronym` method, passing the user's input as an argument. 4) Store the value returned by the `getAcronym` method in another String variable. 5) Display the name and acronym as shown in the examples below:

 
Here are several examples showing what the value returned by your `getAcronym` method should be for various user inputs:


| Example | User Input | Expected Console Output |
|----------|-------------|--------------------------|
| **1** | `fear of missing out` | `Enter some words : fear of missing out` <br> `Acronym for fear of missing out : FOMO` |
| **2** | `self contained underwater breathing apparatus` | `Enter some words : self contained underwater breathing apparatus` <br> `Acronym for self contained underwater breathing apparatus : SCUBA` |

For any given input, ensure that your program's outputs follow the same formatting as the examples above — including spelling, capitalization, punctuation, spaces, and decimal points.

### Part 04-Triangle Generator
Implement the following method:

1. `doTriangle`: This method is partially implemented and is called by the menu in the main method. Your job is to add the following: Collect the proceeding 3 inputs from the user in this specific order:

        a. Size (base and height) of the triangle
        b. Border character
        c. Interior character

2. With these inputs, print out a triangle made of the border and interior characters as 
shown in the subsequent examples, with the specific inputted base and height.

Here are some examples of what the program should look like when it runs with several different inputs:

***Example 1***
<pre>
Enter size     : 5 
Enter border   : X 
Enter interior : O 
X 
XX 
XOX 
XOOX 
XXXXX 
</pre>

***Example 2***
<pre>
Enter size     : 8
Enter border   : +
Enter interior : - 
+ 
++ 
+-+ 
+--+ 
+---+ 
+----+ 
+-----+ 
++++++++ 
</pre>

***Example 3***
<pre>
Enter size     : 3 
Enter border   : $ 
Enter interior : # 
$ 
$$ 
$$$ 
</pre>

As usual, ensure that your program output looks exactly like the examples above (including the same spelling, capitalization, punctuation, spaces, and decimal points).

### Part 5-Greatest character
Implement a static method named `maxChar` that:
- Takes a non-empty String word as a parameter
- Determines which character in the string is alphabetically largest (hint: use the `String` class’ `compareTo` method)
- Returns the index of that character in the string

***🔠 Example Outputs:***

| Example | Method Call | Expected Result | Explanation |
|----------|--------------|----------------|--------------|
| **1** | `maxChar("apple")` | `4` | `'e'` is alphabetically the largest in the String "apple" |
| **2** | `maxChar("Cat")` | `2` | `'t' > 'C' > 'a'` |
| **3** | `maxChar("azAZ")` | index of `'z'` | Lowercase letters compare larger than uppercase in Java’s `compareTo` method |


### 🧪 Part 6 – JUnit Testing 

Finally, you will write your own **JUnit tests** to verify that each method works correctly on its own (before running your full menu program).

1. Open the file in the directory `assn03_method_madness/method-madness/src/test/java/MethodsTesting.java`

2. This file includes a **blueprint** with five TODO sections — one for each method in your assignment:
- Temperature conversion  
- Distance conversion  
- Acronym generation  
- Triangle generator  
- Greatest character (`maxChar`)

3. For each TODO section:
- Write **one or more JUnit test methods**.  
- When comparing decimal results, use a **tolerance** value (delta) for doubles.  
  Example:  
  ```java
  assertEquals(37.78, result, 0.01);
  ```

4. You can run your tests directly in VS Code:
- Open the **Testing** tab on the sidebar.
- Run the test class `MethodsTesting` or individual test methods.
- ✅ Green = passed, ❌ Red = failed.

**Goal:**  
Your tests should demonstrate that each method performs correctly across a variety of inputs, including edge cases. This is your chance to verify and debug your logic before integrating everything into the main menu program.

---

### 🎯 Final Notes

By completing this assignment, you’re practicing several core programming concepts in Java — including method creation and calling, conditional logic, loops, user input handling, string processing, and formatted output. Each part of this project builds your ability to think modularly and write clear, organized code!

Take your time to test each method carefully and make sure your program’s output matches the examples exactly. Precision and attention to detail are key skills for every programmer!

Keep up the great work — remember, every method you write strengthens your understanding and confidence as a computer scientist. 🚀
