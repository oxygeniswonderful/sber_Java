import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReportGeneratorClassTest {

    @org.junit.jupiter.api.Test
    void generate() throws IllegalAccessException {

        List<Car> list = Arrays.asList(new Car(1, "Mercedes", "class-S", 300, 4000, 228),
                new Car(2, "Lamborghini", "Aventator", 400, 5000, 300));
        ReportGeneratorClass<Car> generator = new ReportGeneratorClass<>();
        ReportClass report = generator.generate(list);

        assertArrayEquals(report.strings[1], new String[]{"1", "Mercedes", "class-S", "300", "4000", "228"});
    }
}