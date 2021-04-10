package trainapplogos;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface OverallHumanAssesment {
	String humanDescription() default "Some default value";
	int priorityValue() default 50;
}
