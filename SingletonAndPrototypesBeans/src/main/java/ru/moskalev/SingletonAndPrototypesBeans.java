package ru.moskalev;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.util.StopWatch;
import ru.moskalev.scopes.DemoBean;
import ru.moskalev.scopes.LookupConfig;
import ru.moskalev.scopes.Singer;

@SpringBootApplication
public class SingletonAndPrototypesBeans {

	public static void main(String[] args) {
		//SpringApplication.run(JdbcTestProjectApplication.class, args);
		GenericApplicationContext ctx =
				new AnnotationConfigApplicationContext(
						LookupConfig.class);
		DemoBean abstractBean = ctx.getBean("abstractLookupBean", DemoBean.class);
		DemoBean standartBean = ctx.getBean("standardLookupBean", DemoBean.class);
		displaylnfo("abstractLookupBean",abstractBean);
		displaylnfo("standardLookupBean",standartBean);
	}

	public static void displaylnfo(String beanName,
								   DemoBean bean) {
		Singer singerl = bean.getMySinger();
		Singer singer2 = bean.getMySinger();
		System.out.println("" + beanName + ": "
				+ "Singer Instances the Same? "
				+ (singerl == singer2));
		StopWatch stopWatch = new StopWatch();
		stopWatch.start("lookupDemo");
		for (int х = 0; х < 100000; х++) {
			Singer singer = bean.getMySinger();
		//	singer.sing();
		}
			stopWatch.stop();
			System.out.println("lOOOOO gets took "
					+ stopWatch.getTotalTimeMillis() + "ms");
		}

}
