import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

@SpringBootApplication
public class ReplacementMethodForBean {

    public static void main(String[] args) {

        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("config.xml");

        ctx.refresh();
        ReplacementTarget replacementTarget =
                (ReplacementTarget) ctx.getBean("replacementTarget");
        ReplacementTarget standardTarget =
                (ReplacementTarget) ctx.getBean("standardTarget");

        displaylnfo(replacementTarget);
        displaylnfo(standardTarget);
        ctx.close();

    }

    public static void displaylnfo(ReplacementTarget target) {
        System.out.println(target.formatMessage(
                "Thanks for playing, try again!"));
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("perfTest");
        for (int х = 0; х < 1000000; х++) {
            String out = target.formatMessage("No filter in my head");
        }
        stopWatch.stop();
        System.out.println("lOOOOOO invocations took: "
                + stopWatch.getTotalTimeMillis() + "ms");
    }

}