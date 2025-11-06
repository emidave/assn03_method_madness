import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;

public class MethodsTesting {

  @Test
  public void testTemperatureConversion() {
    // TODO: Implement JUnit test for the temperature conversion method
  }

  @Test
  public void testDistanceConversion() {
    // TODO: Implement JUnit test for the distance conversion method
  }

  @Test
  public void testGetAcronym() {
    // TODO: Implement JUnit test for the acronym method
  }

  @Test
  public void testTriangleGenerator() {
    // TODO: Implement JUnit test for the triangle generator method.
    // Since this method test is a bit more complex, follow the guided steps below!

    // STEP 1️⃣: Create simulated user input for the Scanner.
        // For example, the user might enter:
        //   3 (sideA)
        //   3 (sideB)
        //   * (outerChar)
        //   - (innerChar)
        //
        // TODO: Replace the example input below with your own test data if you’d like.
        String input = "3\n3\n*\n-\n";
        Scanner scnr = new Scanner(new ByteArrayInputStream(input.getBytes()));

        // STEP 2️⃣: Capture console output (System.out)
        // Instead of printing to the real console, we’ll temporarily redirect it
        // to a "fake" output stream that we can read later.
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));

        try {
            // STEP 3️⃣: Call the method you want to test
            // TODO: Replace MyClass with the actual class name where we defined doTriangle()
            MyClass.doTriangle(scnr);
        } finally {
            // STEP 4️⃣: Restore System.out (always do this to avoid side effects!)
            System.setOut(originalOut);
        }

        // STEP 5️⃣: Define what the expected printed output *should* look like
        // This includes both the user prompts (from System.out.println)
        // and the triangle shape itself. Be careful with line breaks!
        // HINT: Java text blocks (triple quotes """ """) make this easier to read.
        String expectedOutput = """
        Enter length of side A: 
        Enter length of side B: 
        Enter outer character: 
        Enter inner character: 
        *
        *-
        ***
        """;

        // STEP 6️⃣: Compare the captured output to your expected output
        // TODO: Uncomment the line below after setting up your expectedOutput string.
        // assertEquals(expectedOutput, outContent.toString());

        // 💡 OPTIONAL CHALLENGE:
        // Instead of checking *everything*, you can also check partial output like this:
        // assertTrue(outContent.toString().contains("***"));
  }

  @Test
  public void testMaxChar() {
    // TODO: Implement JUnit test for the max character method
  }
}
