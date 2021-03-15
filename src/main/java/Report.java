import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public interface Report {

    byte[] asBytes() throws IOException;

    void writeTo(OutputStream os) throws IOException;
}

public class ReportClass implements Report{


    public final String[][] strings;

    public ReportClass(String[][] strings) {

        this.strings = strings;
    }

    @Override
    public void writeTo(OutputStream os) throws IOException {
        os.write(asBytes());
    }

    @Override
    public byte[] asBytes() throws IOException {

        Loader loader = new Loader();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        loader.loadToXLS(strings).write(byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }


    public void renameFields(String[] strs) {

        System.arraycopy(strs, 0, strings[0], 0, strs.length);
    }
}