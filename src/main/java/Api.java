import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import static spark.Spark.post;

public class Api {
    public static void main( String[] args ){
        post("/add",(req,res)->{
            MultipartConfigElement multipartConfigElement = new MultipartConfigElement("/tmp");
            req.raw().setAttribute("org.eclipse.jetty.multipartConfig", multipartConfigElement);
            Part file = req.raw().getPart("file");
            try (InputStream in = file.getInputStream()) {
                Path path = Paths.get("src/main/data/csv_aux.csv");
                Files.copy(in, path, StandardCopyOption.REPLACE_EXISTING);
                CsvReader.Read(path);
            }

            res.redirect("http://localhost:80/saebio-gui/done.php");
            return "OK";
        });
        post("/generate/:report_info", (req,res)->{
            String info = req.params(":report_info");
            String [] aux = info.split(",");
            PDFReport.createReport(Integer.parseInt(aux[1]),aux[0]);
            res.redirect("http://localhost:80/saebio-gui/index.php");
            return "OK";
        });
    }
}
