import java.util.ArrayList;
import java.util.List;

import com.rahavoi.behavior.param.Apple;
import com.rahavoi.behavior.param.AppleColorPrinter;
import com.rahavoi.behavior.param.AppleService;
import com.rahavoi.behavior.param.AppleWeightColorPrinter;
import com.rahavoi.behavior.param.AppleWeightPrinter;


public class Runner {
	public static void main(String[] args){
		AppleService aService = new AppleService();
		Apple a1 = new Apple("green", 124);
		Apple a2 = new Apple("red", 160);
		
		List<Apple> apples = new ArrayList<Apple>();
		apples.add(a1);
		apples.add(a2);
		
		aService.prettyPrintApple(apples, new AppleWeightPrinter());
		aService.prettyPrintApple(apples, new AppleColorPrinter());
		aService.prettyPrintApple(apples, new AppleWeightColorPrinter());
	}
}
