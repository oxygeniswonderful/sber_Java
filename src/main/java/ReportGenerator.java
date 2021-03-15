import java.lang.reflect.Field;
import java.util.List;
import java.util.Arrays;

public interface ReportGenerator<T> {

    ReportClass generate(List<T> entities) throws IllegalAccessException;
}

class ReportGeneratorClass<T> implements ReportGenerator<T> {

    @Override
    public ReportClass generate(List<T> entities) throws IllegalAccessException {

        int index = 0;
        Class<?> clazz = entities.get(0).getClass();
        Field[] fields = clazz.getDeclaredFields();
        String[][] strings = new String[entities.size() + 1][fields.length];

        for (Field field : fields) {

            strings[0][index] = field.getName();
            ++index;
        }

        index = 1;
        int j = 0;

        for (T element : entities) {

            for (Field field : fields) {

                field.setAccessible(true);
                strings[index][j] = field.get(element).toString();
                ++j;
            }

            ++index;
            j = 0;
        }

        for (String[] stringsForCycle : strings) {

            for (String str : stringsForCycle)

                System.out.print(str + " ");

            System.out.println("\n");
        }

        return new ReportClass(strings);
    }
}
