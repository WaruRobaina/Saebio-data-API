import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.SQLException;

public class CsvReader {
    //private static final String SAMPLE_CSV_FILE_PATH =
            //"D:\\Desktop\\Waru\\clase\\TFG\\BASES DE DATOS\\sensibilidad\\test.csv";

    public static void Read(Path path) {
        try (Reader reader = Files.newBufferedReader(path)) {

            CsvToBean csvToBean = new CsvToBeanBuilder(reader)
                    .withType(CsvEntry.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .withSeparator(';')
                    .build();

            for (CsvEntry csventry : (Iterable<CsvEntry>) csvToBean) {
                Entry entry = EntryConverter.converter(csventry);
                DatabaseService.addEntry(entry);
            }
        } catch (IOException | SQLException e) {
            System.out.println("read file failed");
        }
    }


}
