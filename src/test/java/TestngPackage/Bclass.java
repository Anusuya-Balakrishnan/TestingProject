package TestngPackage;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Bclass {

@BeforeClass
public void classb() {
	System.out.println("Before class");
}
@Test
public void class1() {
	System.out.println("test1");
}
@Test
public void class2() {
	System.out.println("test2");
}
@AfterClass
public void classa() {
	System.out.println("After class");
}
}
