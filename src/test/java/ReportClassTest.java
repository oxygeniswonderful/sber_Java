import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class ReportClassTest {

    @Test
    void asBytes() throws IllegalAccessException, IOException {

        List<Car> list = Arrays.asList(new Car(1, "Mercedes", "class-S", 300, 4000, 228),
                new Car(2, "Lamborghini", "Aventator", 400, 5000, 300));
        ReportGeneratorClass<Car> generator = new ReportGeneratorClass<>();
        Report report = generator.generate(list);
        System.out.println(Arrays.toString(report.asBytes()));
    }

    @Test
    void renameFields() throws IllegalAccessException {

        List<Car> list = Arrays.asList(new Car(1, "Mercedes", "class-S", 300, 4000, 228),
                new Car(2, "Lamborghini", "Aventator", 400, 5000, 300));
        ReportGeneratorClass<Car> generator = new ReportGeneratorClass<>();
        ReportClass report = generator.generate(list);
        assertEquals(report.strings[0][1], "brand");
        report.renameFields(new String[]{"id", "brand"});
        assertEquals(report.strings[0][1], "brand");
    }
}

