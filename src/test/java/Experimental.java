import com.houarizegai.calculator.Department;
import com.houarizegai.calculator.ui.CalculatorUI;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Experimental {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        try {
            // Specify the package name where your test classes are located
            String testPackageName = "com.houarizegai.calculator";

            // Find all classes in the test package with the @TestCase annotation
            List<Class<?>> testClasses = TestCaseScanner.findClassesWithTestCaseAnnotation(testPackageName);

            // Iterate over each test class and find methods with the @TestCase annotation
            for (Class<?> testClass : testClasses) {

                String classPath = testClass.getCanonicalName();
                String department =  testClass.getAnnotation(Department.class).name();

                List<Method> testMethods = TestCaseScanner.findMethodsWithTestCaseAnnotation(testClass);
                for (Method method : testMethods) {

                    System.out.println(classPath + method.getName() + ", Tags: " + department);
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
