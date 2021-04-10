package trainapplogos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

public class Human {
	@OverallHumanAssesment(humanDescription = "Annotation of field name", priorityValue = 100)
	private String name;
	@OverallHumanAssesment(humanDescription = "Annotation of field age", priorityValue = 92)
	private int age;
	@OverallHumanAssesment(humanDescription = "Annotation of field height", priorityValue = 70)
	private int height;
	@OverallHumanAssesment(humanDescription = "Annotation of field weight")
	private int weigth;
	
	private String emotionalState; //this field without annotation
	
	public Human(String name, int age, int height, int weigth, String emotionalState) {
		super();
		this.name = name;
		this.age = age;
		this.height = height;
		this.weigth = weigth;
		this.emotionalState = emotionalState;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeigth() {
		return weigth;
	}

	public void setWeigth(int weigth) {
		this.weigth = weigth;
	}

	public String getEmotionalState() {
		return emotionalState;
	}

	public void setEmotionalState(String emotionalState) {
		this.emotionalState = emotionalState;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", height=" + height + ", weigth=" + weigth
				+ ", emotionalState=" + emotionalState + "]";
	}
	
	public static void saveAnnotationsToFile(String filename, Class<?> customClass) throws IOException {
		File f = new File(filename);
		OutputStream os = new FileOutputStream(f);
		
		Field[] fields = customClass.getDeclaredFields();
		for (int i = 0; i < fields.length; i++) {
			Field field = fields[i];
			
			if (field.getAnnotation(OverallHumanAssesment.class) instanceof OverallHumanAssesment) {
				String fieldName = field.getName();
				String description = field.getAnnotation(OverallHumanAssesment.class).humanDescription();
				int priority = field.getAnnotation(OverallHumanAssesment.class).priorityValue();
				System.out.println("> Output annotated fields with values:");
				System.out.println("  name of field : " + fieldName);
				System.out.println("  field \"description\": " + description);
				System.out.println("  field \"priority value\": " + priority);
				
				System.out.println("> Write data to file " + filename + "...");
				os.write(fieldName.getBytes());
				os.write("\n".getBytes());
				os.write(description.getBytes());
				os.write("\n".getBytes());
				os.write(String.valueOf(priority).getBytes());
				os.write("\n".getBytes());
			}
		}
		
		os.close();
	}
	
	public static void readAnnotationsFromFile(String filename) throws IOException {
		/*File f = new File(filename);
		InputStream os = new FileInputStream(f);
		os.close();*/
	}
	
	
}


