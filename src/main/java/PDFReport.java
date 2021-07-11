import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PDFReport {

    private static final String dateFormatName= "dd-MM-yyyy HH.mm.ss";
    private static final String dateFormatCover= "dd/MM/yyyy";

    private static LocalDateTime localDateTime = LocalDateTime.now();
    private static DateTimeFormatter formatterName = DateTimeFormatter.ofPattern(dateFormatName);
    private static String formatDateTimeName = localDateTime.format(formatterName);
    private static DateTimeFormatter formatterCover = DateTimeFormatter.ofPattern(dateFormatCover);
    private static String formatDateTimeCover = localDateTime.format(formatterCover);
    //Windows format path
    private static String home = System.getProperty("user.home");
    private static String path = home + "\\Downloads\\" + "Informe Microbiologia " + formatDateTimeName +".pdf";

    //Colors
    private static BaseColor dark_blue = new BaseColor(0, 31, 77);
    private static BaseColor light_blue = new BaseColor(26, 117, 255);
    private static BaseColor table_border_blue = new BaseColor(0, 92, 230);
    private static BaseColor table_light_blue = new BaseColor(179, 217, 255);
    private static BaseColor table_yellow = new BaseColor(255, 255, 51);
    private static BaseColor green = new BaseColor(10, 102, 10);
    private static BaseColor red = new BaseColor(230, 0, 0);
    private static BaseColor pink = new BaseColor(255, 153, 230);
    //Fonts
    private static Font Times_18_White_B = new Font(Font.FontFamily.TIMES_ROMAN,18, Font.BOLD, BaseColor.WHITE);
    private static Font Times_16_Blue_B = new Font(Font.FontFamily.TIMES_ROMAN,16, Font.BOLD, light_blue);
    private static Font Times_12 = new Font(Font.FontFamily.TIMES_ROMAN,12);
    private static Font Times_13_B = new Font(Font.FontFamily.TIMES_ROMAN,13,Font.BOLD);
    private static Font Times_11 = new Font(Font.FontFamily.TIMES_ROMAN,11);
    private static Font Times_11_B = new Font(Font.FontFamily.TIMES_ROMAN,11, Font.BOLD);
    private static Font Times_10 = new Font(Font.FontFamily.TIMES_ROMAN,10);
    private static Font Times_10_B = new Font(Font.FontFamily.TIMES_ROMAN,10, Font.BOLD);
    private static Font Times_10_B_White = new Font(Font.FontFamily.TIMES_ROMAN,10, Font.BOLD, BaseColor.WHITE);
    private static Font Times_8_B = new Font(Font.FontFamily.TIMES_ROMAN,8, Font.BOLD);
    private static Font Times_11_Green = new Font(Font.FontFamily.TIMES_ROMAN,11,Font.NORMAL, green);
    private static Font Times_11_Red = new Font(Font.FontFamily.TIMES_ROMAN,11, Font.NORMAL, red);
    private static Font Times_8_Green = new Font(Font.FontFamily.TIMES_ROMAN,8,Font.NORMAL, green);
    private static Font Times_8_Red = new Font(Font.FontFamily.TIMES_ROMAN,8, Font.NORMAL, red);
    private static Font Times_8_Blue = new Font(Font.FontFamily.TIMES_ROMAN,8, Font.NORMAL, light_blue);
    private static Font Times_8_Blue_I = new Font(Font.FontFamily.TIMES_ROMAN,8, Font.ITALIC, light_blue);
    private static Font Times_8 = new Font(Font.FontFamily.TIMES_ROMAN,8, Font.NORMAL);
    private static Font Times_8_I = new Font(Font.FontFamily.TIMES_ROMAN,8, Font.ITALIC);


    public static void createReport(int year, String origin){
        try{
            ReportData.reinitializeVariables();
            DatabaseService.readEntry(year, origin);
            ReportData.getPercentages();
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(path));
            doc.open();
            addCoverPage(doc, year, origin);
            addIntroPage(doc, origin);
            addUrinaryContent(doc);
            addExtraContent(doc);
            doc.close();
        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        }
    }

    private static void addCoverPage(Document doc, int year, String origin) throws DocumentException {
        String center="";
        if(origin.equals("atencion primaria area norte")) center = "Atención Primaria Área Norte" ;
        if(origin.equals("hospital de gran canaria dr. negrin")) center = "Hospital Doctor Negrín";
        if(origin.equals("hospital materno infantil")) center = "Hospital Materno Infantil";
        Paragraph cover = new Paragraph();
        addEmptyLine(cover, 5);

        PdfPTable coverTable = new PdfPTable(1);
        coverTable.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell title = new PdfPCell(new Phrase("\n SERVICIO DE MICROBIOLOGÍA \n\n HOSPITAL UNIVERSITARIO DE GRAN " +
                "CANARIA DR. NEGRÍN \n\n", Times_18_White_B));
        title.setBackgroundColor(dark_blue);
        title.setBorderColor(BaseColor.BLACK);
        title.setHorizontalAlignment(Element.ALIGN_CENTER);
        coverTable.addCell(title);

        PdfPCell subtitle = new PdfPCell(new Phrase("\n Informe de sensibilidad antibiótica de los microorganismos " +
                "\n aislados con más frecuencia en "+ center +" \n\n" + year + "\n\n", Times_16_Blue_B));
        subtitle.setBackgroundColor(BaseColor.WHITE);
        subtitle.setBorderColor(BaseColor.BLACK);
        subtitle.setHorizontalAlignment(Element.ALIGN_CENTER);
        coverTable.addCell(subtitle);

        cover.add(coverTable);

        addEmptyLine(cover, 20);
        Paragraph coverFooter = new Paragraph("F.E.A. Microbiología Hospital Universitario de Gran Canaria Dr. Negrín \n" +
                formatDateTimeCover, Times_12);
        coverFooter.setAlignment(Paragraph.ALIGN_CENTER);
        cover.add(coverFooter);

        doc.add(cover);
        doc.newPage();
    }

    private static void addIntroPage(Document doc, String origin) throws DocumentException {
        Paragraph intro = new Paragraph();
        Paragraph introText1;
        if(origin.equals("atencion primaria area norte")) {
            introText1 = new Paragraph("\n\n\n          El propósito de este informe es conocer la distribución de los " +
                    "microorganismos detectados con más frecuencia en el ámbito extrahospitalario, utilizando para ello los " +
                    "datos acumulados de identificación y sensibilidad antibiótica de los cultivos positivos obtenidos a " +
                    "partir de muestras clínicas remitidas desde los centros de salud de Atención Primaria del Área Norte " +
                    "de Gran Canaria.\n\n" +
                    "          Los centros de salud y consultorios locales de los que se ha obtenido la información son los " +
                    "siguientes: Agaete, Alcaravaneras, Aríñez, Artenara, Arucas, Atalaya, Bañaderos, Barrio Atlántico, " +
                    "Caideros, Cambalud, Canalejas, Cardones, Casas Aguilar, Cono Sur, Costa Ayala, Cueva Torres, El Monte, " +
                    "Escaleritas, Firgas, Fontanales, Gáldar, Guanarteme, Guía, La Aldea, Las Lagunetas, Lomo Blanco, " +
                    "Miller Bajo, Montaña Alta, Moya, Puerto, San José, San Lorenzo, San Mateo, San Roque, Santa Brígida, " +
                    "Santidad, Sardina del Norte, Schamann, Tafira, Tamaraceite, Tasarte, Tejeda, Tenoya, Teror, Triana, " +
                    "Utiaca y Valleseco.\n\n" +
                    "          Para los agentes etiológicos bacterianos más frecuentes se han incluido tablas en las que se indican los " +
                    "porcentajes de sensibilidad para los antibióticos más utilizados, desglosando esta información en " +
                    "población adulta y población pediátrica, siempre y cuando exista un mínimo de 30 pacientes con al " +
                    "menos un aislamiento anual de la especie citada. Los criterios empleados se basan en los publicados " +
                    "por el Clinical and LaboratoryStandardsInstitute (CLSI)1. Los datos numéricos en color azul indican un " +
                    "número insuficiente de casos, lo que indica que no se deben tener en cuenta.\n\n" +
                    "          El informe se ha estructurado de acuerdo a los principales síndromes infecciosos que afectan a la " +
                    "comunidad: infecciones del tracto urinario, faringoamigdalitis e " +
                    "infecciones de transmisión sexual. Para adaptarnos a las " +
                    "recomendaciones del Plan Nacional Resistencia Antibióticos (PRAN), basadas en criterios de la Sociedad " +
                    "Española de Enfermedades Infecciosas y Microbiología Clínica (SEIMC), el formato utilizado es el de " +
                    "mapas de resistencia2. \n\n\n" +
                    "    Los criterios resumidos son los siguientes: \n", Times_11);
        } else {
            introText1 = new Paragraph("\n\n\n          El propósito de este informe es conocer la distribución de los " +
                    "microorganismos detectados con más frecuencia en el ámbito hospitalario, utilizando para ello los " +
                    "datos acumulados de identificación y sensibilidad antibiótica de los cultivos positivos obtenidos a " +
                    "partir de el Hospital de Gran Canaria Doctor Negrín.\n\n" +
                    "          Para los agentes etiológicos bacterianos más frecuentes se han incluido tablas en las que se indican los " +
                    "porcentajes de sensibilidad para los antibióticos más utilizados, desglosando esta información en " +
                    "población adulta y población pediátrica, siempre y cuando exista un mínimo de 30 pacientes con al " +
                    "menos un aislamiento anual de la especie citada. Los criterios empleados se basan en los publicados " +
                    "por el Clinical and LaboratoryStandardsInstitute (CLSI)1. Los datos numéricos en color azul indican un " +
                    "número insuficiente de casos, lo que indica que no se deben tener en cuenta.\n\n" +
                    "          El informe se ha estructurado de acuerdo a los principales síndromes infecciosos que afectan a la " +
                    "comunidad: infecciones del tracto urinario, faringoamigdalitis e " +
                    "infecciones de transmisión sexual. Para adaptarnos a las " +
                    "recomendaciones del Plan Nacional Resistencia Antibióticos (PRAN), basadas en criterios de la Sociedad " +
                    "Española de Enfermedades Infecciosas y Microbiología Clínica (SEIMC), el formato utilizado es el de " +
                    "mapas de resistencia2. \n\n\n" +
                    "    Los criterios resumidos son los siguientes: \n", Times_11);
        }
        introText1.setAlignment(Element.ALIGN_JUSTIFIED);
        intro.add(introText1);

        List list = new List(false, false, 0);
        list.add(new ListItem("          Informe con periodicidad anual, comparando los datos con los obtenidos en los " +
                "dos años previos.", Times_11));
        list.add(new ListItem("          Los datos acumulados de sensibilidad para aquellas especies " +
                "con un número de aislamientos no significativo: inferior a 30, se muestran en azul.", Times_11));
        list.add(new ListItem("          Informe del porcentaje de cepas sensibles. Los aislados con categoría “sensible " +
                "a exposición incrementada (I)” se agrupan con las sensibles.", Times_11));
        list.add(new ListItem("          Se excluyen las cepas aisladas de muestras de vigilancia epidemiológica " +
                "(exudados nasales para investigar portadores de Staphylococcus aureus, exudados vagino-rectales de " +
                "gestantes, exudados para búsqueda activa de bacterias multirresistentes, etc.) y las cepas obtenidas " +
                "de reservorios ambientales (aire, superficies, etc.).", Times_11));
        intro.add(list);

        Paragraph introText2 = new Paragraph("\n\n    La escala de colores es la empleada en informes previos: \n", Times_11);
        introText2.setAlignment(Element.ALIGN_JUSTIFIED);
        intro.add(introText2);
        Paragraph introGreen = new Paragraph("          color verde:> 85% de cepas sensibles\n", Times_11_Green);
        introGreen.setAlignment(Element.ALIGN_JUSTIFIED);
        intro.add(introGreen);
        Paragraph introBlack = new Paragraph("          color negro: 50 – 85% de cepas sensibles\n", Times_11);
        introBlack.setAlignment(Element.ALIGN_JUSTIFIED);
        intro.add(introBlack);
        Paragraph introRed = new Paragraph("          color rojo: < 50% de cepas sensibles\n", Times_11_Red);
        introRed.setAlignment(Element.ALIGN_JUSTIFIED);
        intro.add(introRed);

        Paragraph introText3 = new Paragraph("\n\n          Como novedad respecto a años anteriores, en el año 2019 " +
                "el Servicio de Microbiología, siguiendo directrices nacionales y europeas, adoptó los criterios del " +
                "EuropeanCommitteeonAntimicrobialSusceptibilityTesting (EUCAST). Este cambio de criterios para la " +
                "interpretación del antibiograma puede afectar al porcentaje de aislados sensibles respecto a años " +
                "anteriores, sin que éste se deba necesariamente a un incremento o disminución del número de cepas " +
                "resistentes.\n\n",Times_11);
        Paragraph introText4 = new Paragraph("    1.CLSI. Analysis and Presentation of Cumulative Antimicrobial Susceptibility Test Data; Approved " +
                "Guideline –Fourth Edition. CLSI document M39-A4. Wayne, PA: Clinical and Laboratory Standards " +
                "Institute; 2014.\n" +
                "    2.Aspiroz C, Paño-Pardo JR. Elaboración de mapas epidemiológicos de resistencia. Línea estratégica " +
                "I: vigilancia. En: Agencia Española de Medicamentos y Productos Sanitarios. Ministerio de Sanidad, " +
                "Servicios Sociales e Igualdad. Plan Nacional Resistencia Antibióticos; 2017.\n", Times_10);
        introText3.setAlignment(Element.ALIGN_JUSTIFIED);
        introText4.setAlignment(Element.ALIGN_JUSTIFIED);
        intro.add(introText3);
        intro.add(introText4);

        addEmptyLine(intro, 4);

        Paragraph abbTitle = new Paragraph("    Abreviaturas utilizadas para los antibióticos y mecanismos de " +
                "resistencia:\n\n\n", Times_13_B);
        abbTitle.setAlignment(Element.ALIGN_JUSTIFIED);
        intro.add(abbTitle);

        PdfPTable abbTable = new PdfPTable(2);
        abbTable.setHorizontalAlignment(Element.ALIGN_CENTER);

        PdfPCell antibiotic = new PdfPCell(new Phrase("Antibiótico\n",Times_11_B));
        antibiotic.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(antibiotic);
        PdfPCell abbreviation = new PdfPCell(new Phrase("Abreviatura\n",Times_11_B));
        abbreviation.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(abbreviation);
        abbTable.setHeaderRows(1);

        PdfPCell an1 = new PdfPCell(new Phrase("Penicilina G\n",Times_11));
        an1.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an1);
        PdfPCell ab1 = new PdfPCell(new Phrase("PG\n",Times_11));
        ab1.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab1);

        PdfPCell an2 = new PdfPCell(new Phrase("Ampicilina\n",Times_11));
        an2.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an2);
        PdfPCell ab2 = new PdfPCell(new Phrase("AM\n",Times_11));
        ab2.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab2);

        PdfPCell an3 = new PdfPCell(new Phrase("Amoxicilina - ácido clavulánico\n",Times_11));
        an3.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an3);
        PdfPCell ab3 = new PdfPCell(new Phrase("AMC\n",Times_11));
        ab3.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab3);

        PdfPCell an4 = new PdfPCell(new Phrase("Oxacilina\n",Times_11));
        an4.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an4);
        PdfPCell ab4 = new PdfPCell(new Phrase("OX\n",Times_11));
        ab4.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab4);

        PdfPCell an5 = new PdfPCell(new Phrase("Cefuroxima\n",Times_11));
        an5.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an5);
        PdfPCell ab5 = new PdfPCell(new Phrase("CXM\n",Times_11));
        ab5.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab5);

        PdfPCell an6 = new PdfPCell(new Phrase("Ceftriaxona\n",Times_11));
        an6.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an6);
        PdfPCell ab6 = new PdfPCell(new Phrase("CRO\n",Times_11));
        ab6.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab6);

        PdfPCell an7 = new PdfPCell(new Phrase("Cefotaxima\n",Times_11));
        an7.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an7);
        PdfPCell ab7 = new PdfPCell(new Phrase("CTX\n",Times_11));
        ab7.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab7);

        PdfPCell an8 = new PdfPCell(new Phrase("Ceftazidima\n",Times_11));
        an8.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an8);
        PdfPCell ab8 = new PdfPCell(new Phrase("CAZ\n",Times_11));
        ab8.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab8);

        PdfPCell an9 = new PdfPCell(new Phrase("Cefepime\n",Times_11));
        an9.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an9);
        PdfPCell ab9 = new PdfPCell(new Phrase("FEP\n",Times_11));
        ab9.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab9);

        PdfPCell an10 = new PdfPCell(new Phrase("Cefixima\n",Times_11));
        an10.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an10);
        PdfPCell ab10 = new PdfPCell(new Phrase("CFM\n",Times_11));
        ab10.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab10);

        PdfPCell an11 = new PdfPCell(new Phrase("Imipenem\n",Times_11));
        an11.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an11);
        PdfPCell ab11 = new PdfPCell(new Phrase("IMP\n",Times_11));
        ab11.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab11);

        PdfPCell an12 = new PdfPCell(new Phrase("Ertapenem\n",Times_11));
        an12.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an12);
        PdfPCell ab12 = new PdfPCell(new Phrase("ERT\n",Times_11));
        ab12.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab12);

        PdfPCell an13 = new PdfPCell(new Phrase("Eritromicina\n",Times_11));
        an13.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an13);
        PdfPCell ab13 = new PdfPCell(new Phrase("EM\n",Times_11));
        ab13.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab13);

        PdfPCell an14 = new PdfPCell(new Phrase("Azitromicina\n",Times_11));
        an14.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an14);
        PdfPCell ab14 = new PdfPCell(new Phrase("AZM\n",Times_11));
        ab14.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab14);

        PdfPCell an15 = new PdfPCell(new Phrase("Clindamicina\n",Times_11));
        an15.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an15);
        PdfPCell ab15 = new PdfPCell(new Phrase("CC\n",Times_11));
        ab15.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab15);

        PdfPCell an16 = new PdfPCell(new Phrase("Ciboprofloxacino\n",Times_11));
        an16.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an16);
        PdfPCell ab16 = new PdfPCell(new Phrase("CIP\n",Times_11));
        ab16.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab16);

        PdfPCell an17 = new PdfPCell(new Phrase("Levofloxacino\n",Times_11));
        an17.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an17);
        PdfPCell ab17 = new PdfPCell(new Phrase("LVX\n",Times_11));
        ab17.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab17);

        PdfPCell an18 = new PdfPCell(new Phrase("Gentamicina\n",Times_11));
        an18.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an18);
        PdfPCell ab18 = new PdfPCell(new Phrase("GEN\n",Times_11));
        ab18.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab18);

        PdfPCell an19 = new PdfPCell(new Phrase("Tobramicina\n",Times_11));
        an19.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an19);
        PdfPCell ab19 = new PdfPCell(new Phrase("TOB\n",Times_11));
        ab19.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab19);

        PdfPCell an20 = new PdfPCell(new Phrase("Trimetoprim-sulfametoxazol\n",Times_11));
        an20.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an20);
        PdfPCell ab20 = new PdfPCell(new Phrase("SXT\n",Times_11));
        ab20.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab20);

        PdfPCell an21 = new PdfPCell(new Phrase("Fosfomicina\n",Times_11));
        an21.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an21);
        PdfPCell ab21 = new PdfPCell(new Phrase("FOS\n",Times_11));
        ab21.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab21);

        PdfPCell an22 = new PdfPCell(new Phrase("Nitrofurantoína\n",Times_11));
        an22.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an22);
        PdfPCell ab22 = new PdfPCell(new Phrase("NIT\n",Times_11));
        ab22.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab22);

        PdfPCell an23 = new PdfPCell(new Phrase("Mupirocina\n",Times_11));
        an23.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an23);
        PdfPCell ab23 = new PdfPCell(new Phrase("MUP\n",Times_11));
        ab23.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab23);

        PdfPCell an24 = new PdfPCell(new Phrase("Ácido fusídico\n",Times_11));
        an24.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(an24);
        PdfPCell ab24 = new PdfPCell(new Phrase("FUS\n",Times_11));
        ab24.setHorizontalAlignment(Element.ALIGN_CENTER);
        abbTable.addCell(ab24);

        intro.add(abbTable);
        doc.add(intro);
        doc.newPage();
    }

    private static void addUrinaryContent(Document doc) throws DocumentException {
        Paragraph urinary = new Paragraph();

        //Table headers
        float[] columnWidths = {20f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f};
        PdfPTable urinary_f_m14 = new PdfPTable(columnWidths);
        urinary_f_m14.setWidthPercentage(95f);

        PdfPCell title = new PdfPCell(new Phrase("Infección urinaria mujeres (>14 años)", Times_10_B));
        title.setBorderColor(table_border_blue);
        title.setBackgroundColor(table_yellow);
        title.setHorizontalAlignment(Element.ALIGN_CENTER);
        title.setColspan(16);
        urinary_f_m14.addCell(title);

        PdfPCell h4 = new PdfPCell(new Phrase("", Times_10_B_White));
        h4.setBorderColor(table_border_blue);
        h4.setBackgroundColor(dark_blue);
        h4.setColspan(2);
        urinary_f_m14.addCell(h4);

        PdfPCell h3 = new PdfPCell(new Phrase("% Sensibilidad (S+I)", Times_10_B_White));
        h3.setBorderColor(table_border_blue);
        h3.setBackgroundColor(dark_blue);
        h3.setHorizontalAlignment(Element.ALIGN_CENTER);
        h3.setColspan(14);
        urinary_f_m14.addCell(h3);

        PdfPCell h1 = new PdfPCell(new Phrase("Microorganismo", Times_10_B_White));
        h1.setBorderColor(table_border_blue);
        h1.setBackgroundColor(dark_blue);
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(h1);

        PdfPCell h2 = new PdfPCell(new Phrase("N", Times_10_B_White));
        h2.setBorderColor(table_border_blue);
        h2.setBackgroundColor(dark_blue);
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(h2);

        PdfPCell am = new PdfPCell(new Phrase("AM", Times_8_B));
        am.setBorderColor(table_border_blue);
        am.setBackgroundColor(table_light_blue);
        am.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(am);

        PdfPCell amc = new PdfPCell(new Phrase("AMC", Times_8_B));
        amc.setBorderColor(table_border_blue);
        amc.setBackgroundColor(table_light_blue);
        amc.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(amc);

        PdfPCell cxm = new PdfPCell(new Phrase("CXMa)", Times_8_B));
        cxm.setBorderColor(table_border_blue);
        cxm.setBackgroundColor(table_light_blue);
        cxm.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(cxm);

        PdfPCell ctx = new PdfPCell(new Phrase("CTX", Times_8_B));
        ctx.setBorderColor(table_border_blue);
        ctx.setBackgroundColor(table_light_blue);
        ctx.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(ctx);

        PdfPCell caz = new PdfPCell(new Phrase("CAZ", Times_8_B));
        caz.setBorderColor(table_border_blue);
        caz.setBackgroundColor(table_light_blue);
        caz.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(caz);

        PdfPCell fep = new PdfPCell(new Phrase("FEP", Times_8_B));
        fep.setBorderColor(table_border_blue);
        fep.setBackgroundColor(table_light_blue);
        fep.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(fep);

        PdfPCell imp = new PdfPCell(new Phrase("IMP", Times_8_B));
        imp.setBorderColor(table_border_blue);
        imp.setBackgroundColor(table_light_blue);
        imp.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(imp);

        PdfPCell ert = new PdfPCell(new Phrase("ERT", Times_8_B));
        ert.setBorderColor(table_border_blue);
        ert.setBackgroundColor(table_light_blue);
        ert.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(ert);

        PdfPCell cip = new PdfPCell(new Phrase("CIP", Times_8_B));
        cip.setBorderColor(table_border_blue);
        cip.setBackgroundColor(table_light_blue);
        cip.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(cip);

        PdfPCell gen = new PdfPCell(new Phrase("GEN", Times_8_B));
        gen.setBorderColor(table_border_blue);
        gen.setBackgroundColor(table_light_blue);
        gen.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(gen);

        PdfPCell tob = new PdfPCell(new Phrase("TOB", Times_8_B));
        tob.setBorderColor(table_border_blue);
        tob.setBackgroundColor(table_light_blue);
        tob.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(tob);

        PdfPCell nit = new PdfPCell(new Phrase("NITa)", Times_8_B));
        nit.setBorderColor(table_border_blue);
        nit.setBackgroundColor(table_light_blue);
        nit.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(nit);

        PdfPCell sxt = new PdfPCell(new Phrase("SXT", Times_8_B));
        sxt.setBorderColor(table_border_blue);
        sxt.setBackgroundColor(table_light_blue);
        sxt.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(sxt);

        PdfPCell fos = new PdfPCell(new Phrase("FOS", Times_8_B));
        fos.setBorderColor(table_border_blue);
        fos.setBackgroundColor(table_light_blue);
        fos.setHorizontalAlignment(Element.ALIGN_CENTER);
        urinary_f_m14.addCell(fos);

        urinary_f_m14.setHeaderRows(3);

        //Table content
        PdfPCell ec14 = new PdfPCell(new Phrase("E. coli  (>14-50 años)\n",Times_8_I));
        ec14.setHorizontalAlignment(Element.ALIGN_RIGHT);
        ec14.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(ec14);

        int N = ReportData.getN_EColi_F_14();
        int[] array = ReportData.getEColi_F_14();

        ec14 = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        ec14.setHorizontalAlignment(Element.ALIGN_CENTER);
        ec14.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(ec14);
        fillUrinaryFTable(urinary_f_m14, ec14, array, N);

        PdfPCell ec50 = new PdfPCell(new Phrase("E. coli  (>50 años)\n",Times_8_I));
        ec50.setHorizontalAlignment(Element.ALIGN_RIGHT);
        ec50.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(ec50);

        N = ReportData.getN_EColi_F_50();
        array = ReportData.getEColi_F_50();

        ec50 = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        ec50.setHorizontalAlignment(Element.ALIGN_CENTER);
        ec50.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(ec50);
        fillUrinaryFTable(urinary_f_m14, ec50, array, N);

        PdfPCell kpn14 = new PdfPCell(new Phrase("K.pneumoniae  (>14-50 años)\n",Times_8_I));
        kpn14.setHorizontalAlignment(Element.ALIGN_RIGHT);
        kpn14.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(kpn14);

        N = ReportData.getN_K_Pneu_F_14();
        array = ReportData.getK_Pneu_F_14();

        kpn14 = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        kpn14.setHorizontalAlignment(Element.ALIGN_CENTER);
        kpn14.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(kpn14);
        fillUrinaryFTable(urinary_f_m14, kpn14, array, N);

        PdfPCell kpn50 = new PdfPCell(new Phrase("K.pneumoniae  (>50 años)\n",Times_8_I));
        kpn50.setHorizontalAlignment(Element.ALIGN_RIGHT);
        kpn50.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(kpn50);

        N = ReportData.getN_K_Pneu_F_50();
        array = ReportData.getK_Pneu_F_50();

        kpn50 = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        kpn50.setHorizontalAlignment(Element.ALIGN_CENTER);
        kpn50.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(kpn50);
        fillUrinaryFTable(urinary_f_m14, kpn50, array, N);

        PdfPCell cife = new PdfPCell(new Phrase("Citrobacter freundii\n",Times_8_I));
        cife.setHorizontalAlignment(Element.ALIGN_RIGHT);
        cife.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(cife);

        N = ReportData.getN_Citro_Freu_F();
        array = ReportData.getCitro_Freu_F();

        cife = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        cife.setHorizontalAlignment(Element.ALIGN_CENTER);
        cife.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(cife);
        fillUrinaryFTable(urinary_f_m14, cife, array, N);

        PdfPCell ciko = new PdfPCell(new Phrase("Citrobacter koseri\n",Times_8_I));
        ciko.setHorizontalAlignment(Element.ALIGN_RIGHT);
        ciko.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(ciko);

        N = ReportData.getN_Citro_Kos_F();
        array = ReportData.getCitro_Kos_F();

        ciko = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        ciko.setHorizontalAlignment(Element.ALIGN_CENTER);
        ciko.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(ciko);
        fillUrinaryFTable(urinary_f_m14, ciko, array, N);

        PdfPCell encl = new PdfPCell(new Phrase("Enterobacter cloacae\n",Times_8_I));
        encl.setHorizontalAlignment(Element.ALIGN_RIGHT);
        encl.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(encl);

        N = ReportData.getN_Ent_Clo_F();
        array = ReportData.getEnt_Clo_F();

        encl = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        encl.setHorizontalAlignment(Element.ALIGN_CENTER);
        encl.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(encl);
        fillUrinaryFTable(urinary_f_m14, encl, array, N);

        PdfPCell enae = new PdfPCell(new Phrase("Enterobacter aerogenes\n",Times_8_I));
        enae.setHorizontalAlignment(Element.ALIGN_RIGHT);
        enae.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(enae);

        N = ReportData.getN_Ent_Ae_F();
        array = ReportData.getEnt_Ae_F();

        enae = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        enae.setHorizontalAlignment(Element.ALIGN_CENTER);
        enae.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(enae);
        fillUrinaryFTable(urinary_f_m14, enae, array, N);

        PdfPCell klox = new PdfPCell(new Phrase("Klebsiella oxytoca\n",Times_8_I));
        klox.setHorizontalAlignment(Element.ALIGN_RIGHT);
        klox.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(klox);

        N = ReportData.getN_Ent_Ae_F();
        array = ReportData.getEnt_Ae_F();

        klox = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        klox.setHorizontalAlignment(Element.ALIGN_CENTER);
        klox.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(klox);
        fillUrinaryFTable(urinary_f_m14, klox, array, N);

        PdfPCell momo = new PdfPCell(new Phrase("Morganella morganii\n",Times_8_I));
        momo.setHorizontalAlignment(Element.ALIGN_RIGHT);
        momo.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(momo);

        N = ReportData.getN_Morga_F();
        array = ReportData.getMorga_F();

        momo = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        momo.setHorizontalAlignment(Element.ALIGN_CENTER);
        momo.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(momo);
        fillUrinaryFTable(urinary_f_m14, momo, array, N);

        PdfPCell prmi = new PdfPCell(new Phrase("Proteus mirabilis\n",Times_8_I));
        prmi.setHorizontalAlignment(Element.ALIGN_RIGHT);
        prmi.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(prmi);

        N = ReportData.getN_Prot_Mira_F();
        array = ReportData.getProt_Mira_F();

        prmi = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        prmi.setHorizontalAlignment(Element.ALIGN_CENTER);
        prmi.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(prmi);
        fillUrinaryFTable(urinary_f_m14, prmi, array, N);

        PdfPCell pae = new PdfPCell(new Phrase("P. aeruginosa \n",Times_8_I));
        pae.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pae.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(pae);

        N = ReportData.getN_Pseu_Aeru_F();
        array = ReportData.getPseu_Aeru_F();

        pae = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        pae.setHorizontalAlignment(Element.ALIGN_CENTER);
        pae.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(pae);
        fillUrinaryFTable(urinary_f_m14, pae, array, N);

        PdfPCell stsa = new PdfPCell(new Phrase("Staphylococcus saprophyticus\n",Times_8_I));
        stsa.setHorizontalAlignment(Element.ALIGN_RIGHT);
        stsa.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(stsa);

        N = ReportData.getN_Stap_Sapro_F();
        array = ReportData.getStap_Sapro_F();

        stsa = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        stsa.setHorizontalAlignment(Element.ALIGN_CENTER);
        stsa.setBorderColor(table_border_blue);
        urinary_f_m14.addCell(stsa);
        fillUrinaryFTable(urinary_f_m14, stsa, array, N);

        //Table footer
        PdfPCell footer = new PdfPCell(new Phrase("0: resistencia intrínseca", Times_8));
        footer.setBorderColor(table_border_blue);
        footer.setHorizontalAlignment(Element.ALIGN_LEFT);
        footer.setColspan(16);
        urinary_f_m14.addCell(footer);
        footer = new PdfPCell(new Phrase("a) Categoría clínica “Sensible” usando el punto de corte EUCAST para " +
                "la combinación microorganismo/antibiótico en ITU no complicada", Times_8));
        footer.setBorderColor(table_border_blue);
        footer.setHorizontalAlignment(Element.ALIGN_LEFT);
        footer.setColspan(16);
        urinary_f_m14.addCell(footer);

        //Table headers
        float[] columnWidths2 = {20f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f};
        PdfPTable urinary_n = new PdfPTable(columnWidths2);
        urinary_n.setWidthPercentage(80f);

        title = new PdfPCell(new Phrase("Infección urinaria en niños  (<=14 años)", Times_10_B));
        title.setBorderColor(table_border_blue);
        title.setBackgroundColor(table_yellow);
        title.setHorizontalAlignment(Element.ALIGN_CENTER);
        title.setColspan(16);
        urinary_n.addCell(title);

        urinary_n.addCell(h4);
        urinary_n.addCell(h3);
        urinary_n.addCell(h1);
        urinary_n.addCell(h2);
        urinary_n.addCell(am);
        urinary_n.addCell(amc);
        urinary_n.addCell(cxm);
        urinary_n.addCell(ctx);
        urinary_n.addCell(imp);
        urinary_n.addCell(cip);
        urinary_n.addCell(gen);
        urinary_n.addCell(tob);
        urinary_n.addCell(nit);
        urinary_n.addCell(sxt);
        urinary_n.addCell(fos);

        urinary_n.setHeaderRows(3);

        //Table Content
        PdfPCell ec = new PdfPCell(new Phrase("Escherichia coli\n",Times_8_I));
        ec.setHorizontalAlignment(Element.ALIGN_RIGHT);
        ec.setBorderColor(table_border_blue);
        urinary_n.addCell(ec);

        N = ReportData.getN_EColi_N();
        array = ReportData.getEColi_N();

        ec = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        ec.setHorizontalAlignment(Element.ALIGN_CENTER);
        ec.setBorderColor(table_border_blue);
        urinary_n.addCell(ec);
        fillUrinaryFTable(urinary_n, ec, array, N);

        PdfPCell kp = new PdfPCell(new Phrase("Klebsiella pneumoniae\n",Times_8_I));
        kp.setHorizontalAlignment(Element.ALIGN_RIGHT);
        kp.setBorderColor(table_border_blue);
        urinary_n.addCell(kp);

        N = ReportData.getN_K_Pneu_N();
        array = ReportData.getK_Pneu_N();

        kp = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        kp.setHorizontalAlignment(Element.ALIGN_CENTER);
        kp.setBorderColor(table_border_blue);
        urinary_n.addCell(kp);
        fillUrinaryFTable(urinary_n, kp, array, N);

        PdfPCell pm = new PdfPCell(new Phrase("Proteus mirabilis\n",Times_8_I));
        pm.setHorizontalAlignment(Element.ALIGN_RIGHT);
        pm.setBorderColor(table_border_blue);
        urinary_n.addCell(pm);

        N = ReportData.getN_Prot_Mira_N();
        array = ReportData.getProt_Mira_N();

        pm = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        pm.setHorizontalAlignment(Element.ALIGN_CENTER);
        pm.setBorderColor(table_border_blue);
        urinary_n.addCell(pm);
        fillUrinaryFTable(urinary_n, pm, array, N);

        //Table footer
        footer = new PdfPCell(new Phrase("0: resistencia intrínseca", Times_8));
        footer.setBorderColor(table_border_blue);
        footer.setHorizontalAlignment(Element.ALIGN_LEFT);
        footer.setColspan(13);
        urinary_n.addCell(footer);
        footer = new PdfPCell(new Phrase("a) Categoría clínica “Sensible” usando el punto de corte EUCAST para " +
                "la combinación microorganismo/antibiótico en ITU no complicada", Times_8));
        footer.setBorderColor(table_border_blue);
        footer.setHorizontalAlignment(Element.ALIGN_LEFT);
        footer.setColspan(13);
        urinary_n.addCell(footer);

        //Table headers
        PdfPTable urinary_m_m14 = new PdfPTable(columnWidths);
        urinary_m_m14.setWidthPercentage(95f);

        title = new PdfPCell(new Phrase("Infección urinaria en varones (>14 años)", Times_10_B));
        title.setBorderColor(table_border_blue);
        title.setBackgroundColor(table_yellow);
        title.setHorizontalAlignment(Element.ALIGN_CENTER);
        title.setColspan(16);
        urinary_m_m14.addCell(title);

        urinary_m_m14.addCell(h4);
        urinary_m_m14.addCell(h3);
        urinary_m_m14.addCell(h1);
        urinary_m_m14.addCell(h2);
        urinary_m_m14.addCell(am);
        urinary_m_m14.addCell(amc);
        urinary_m_m14.addCell(cxm);
        urinary_m_m14.addCell(ctx);
        urinary_m_m14.addCell(caz);
        urinary_m_m14.addCell(fep);
        urinary_m_m14.addCell(imp);
        urinary_m_m14.addCell(ert);
        urinary_m_m14.addCell(cip);
        urinary_m_m14.addCell(gen);
        urinary_m_m14.addCell(tob);
        urinary_m_m14.addCell(nit);
        urinary_m_m14.addCell(sxt);
        urinary_m_m14.addCell(fos);

        urinary_m_m14.setHeaderRows(3);

        //Table Content
        PdfPCell ecM = new PdfPCell(new Phrase("Escherichia coli\n",Times_8_I));
        ecM.setHorizontalAlignment(Element.ALIGN_RIGHT);
        ecM.setBorderColor(table_border_blue);
        urinary_m_m14.addCell(ecM);

        N = ReportData.getN_EColi_M();
        array = ReportData.getEColi_M();

        ecM = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        ecM.setHorizontalAlignment(Element.ALIGN_CENTER);
        ecM.setBorderColor(table_border_blue);
        urinary_m_m14.addCell(ecM);
        fillUrinaryFTable(urinary_m_m14, ecM, array, N);

        PdfPCell kpM = new PdfPCell(new Phrase("Klebsiella pneumoniae\n",Times_8_I));
        kpM.setHorizontalAlignment(Element.ALIGN_RIGHT);
        kpM.setBorderColor(table_border_blue);
        urinary_m_m14.addCell(kpM);

        N = ReportData.getN_K_Pneu_M();
        array = ReportData.getK_Pneu_M();

        kpM = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        kpM.setHorizontalAlignment(Element.ALIGN_CENTER);
        kpM.setBorderColor(table_border_blue);
        urinary_m_m14.addCell(kpM);
        fillUrinaryFTable(urinary_m_m14, kpM, array, N);

        PdfPCell paeM = new PdfPCell(new Phrase("Pseudomonas aeruginosa \n",Times_8_I));
        paeM.setHorizontalAlignment(Element.ALIGN_RIGHT);
        paeM.setBorderColor(table_border_blue);
        urinary_m_m14.addCell(paeM);

        N = ReportData.getN_Pseu_Aeru_M();
        array = ReportData.getPseu_Aeru_M();

        paeM = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        paeM.setHorizontalAlignment(Element.ALIGN_CENTER);
        paeM.setBorderColor(table_border_blue);
        urinary_m_m14.addCell(paeM);
        fillUrinaryFTable(urinary_m_m14, paeM, array, N);

        //Table footer
        footer = new PdfPCell(new Phrase("0: resistencia intrínseca", Times_8));
        footer.setBorderColor(table_border_blue);
        footer.setHorizontalAlignment(Element.ALIGN_LEFT);
        footer.setColspan(16);
        urinary_m_m14.addCell(footer);
        footer = new PdfPCell(new Phrase("a) Categoría clínica “Sensible” usando el punto de corte EUCAST para " +
                "la combinación microorganismo/antibiótico en ITU no complicada", Times_8));
        footer.setBorderColor(table_border_blue);
        footer.setHorizontalAlignment(Element.ALIGN_LEFT);
        footer.setColspan(16);
        urinary_m_m14.addCell(footer);

        urinary.add(urinary_f_m14);
        addEmptyLine(urinary, 5);
        urinary.add(urinary_n);
        addEmptyLine(urinary, 5);
        urinary.add(urinary_m_m14);
        doc.add(urinary);
        doc.newPage();
    }

    private static void addExtraContent(Document doc) throws DocumentException {
        Paragraph extra = new Paragraph();

        //Table headers
        float[] columnWidths = {20f, 5f, 5f, 5f, 5f, 5f, 5f, 8f, 5f};
        PdfPTable tf = new PdfPTable(columnWidths);
        tf.setWidthPercentage(63f);

        PdfPCell title = new PdfPCell(new Phrase("Faringitis", Times_10_B));
        title.setBorderColor(table_border_blue);
        title.setBackgroundColor(table_light_blue);
        title.setHorizontalAlignment(Element.ALIGN_CENTER);
        title.setColspan(9);
        tf.addCell(title);

        PdfPCell h4 = new PdfPCell(new Phrase("", Times_10_B_White));
        h4.setBorderColor(table_border_blue);
        h4.setBackgroundColor(dark_blue);
        h4.setColspan(2);
        tf.addCell(h4);

        PdfPCell h3 = new PdfPCell(new Phrase("% Sensibilidad (S+I)", Times_10_B_White));
        h3.setBorderColor(table_border_blue);
        h3.setBackgroundColor(dark_blue);
        h3.setHorizontalAlignment(Element.ALIGN_CENTER);
        h3.setColspan(7);
        tf.addCell(h3);

        PdfPCell h1 = new PdfPCell(new Phrase("Microorganismo", Times_10_B_White));
        h1.setBorderColor(table_border_blue);
        h1.setBackgroundColor(dark_blue);
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        tf.addCell(h1);

        PdfPCell h2 = new PdfPCell(new Phrase("N", Times_10_B_White));
        h2.setBorderColor(table_border_blue);
        h2.setBackgroundColor(dark_blue);
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        tf.addCell(h2);

        PdfPCell pg = new PdfPCell(new Phrase("PG", Times_8_B));
        pg.setBorderColor(table_border_blue);
        pg.setBackgroundColor(table_light_blue);
        pg.setHorizontalAlignment(Element.ALIGN_CENTER);
        tf.addCell(pg);

        PdfPCell am = new PdfPCell(new Phrase("AM", Times_8_B));
        am.setBorderColor(table_border_blue);
        am.setBackgroundColor(table_light_blue);
        am.setHorizontalAlignment(Element.ALIGN_CENTER);
        tf.addCell(am);

        PdfPCell amc = new PdfPCell(new Phrase("AMC", Times_8_B));
        amc.setBorderColor(table_border_blue);
        amc.setBackgroundColor(table_light_blue);
        amc.setHorizontalAlignment(Element.ALIGN_CENTER);
        tf.addCell(amc);

        PdfPCell em = new PdfPCell(new Phrase("EM", Times_8_B));
        em.setBorderColor(table_border_blue);
        em.setBackgroundColor(table_light_blue);
        em.setHorizontalAlignment(Element.ALIGN_CENTER);
        tf.addCell(em);

        PdfPCell cc = new PdfPCell(new Phrase("CC", Times_8_B));
        cc.setBorderColor(table_border_blue);
        cc.setBackgroundColor(table_light_blue);
        cc.setHorizontalAlignment(Element.ALIGN_CENTER);
        tf.addCell(cc);

        PdfPCell ml = new PdfPCell(new Phrase("MLSBi", Times_8_B));
        ml.setBorderColor(table_border_blue);
        ml.setBackgroundColor(table_light_blue);
        ml.setHorizontalAlignment(Element.ALIGN_CENTER);
        tf.addCell(ml);

        PdfPCell lvx = new PdfPCell(new Phrase("LVX", Times_8_B));
        lvx.setBorderColor(table_border_blue);
        lvx.setBackgroundColor(table_light_blue);
        lvx.setHorizontalAlignment(Element.ALIGN_CENTER);
        tf.addCell(lvx);

        tf.setHeaderRows(3);

        //Table content
        PdfPCell stpy = new PdfPCell(new Phrase("Streptococcus pyogenes\n",Times_8_I));
        stpy.setHorizontalAlignment(Element.ALIGN_RIGHT);
        stpy.setBorderColor(table_border_blue);
        tf.addCell(stpy);

        int N = ReportData.getN_Strep_Pyo();
        int[] array = ReportData.getStrep_Pyo();

        stpy = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        stpy.setHorizontalAlignment(Element.ALIGN_CENTER);
        stpy.setBorderColor(table_border_blue);
        tf.addCell(stpy);
        fillUrinaryFTable(tf, stpy, array, N);

        //Table headers
        float[] columnWidths2 = {20f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f, 5f};
        PdfPTable toc = new PdfPTable(columnWidths2);
        toc.setWidthPercentage(90f);

        title = new PdfPCell(new Phrase("Infecciones óticas y conjuntivales", Times_10_B));
        title.setBorderColor(table_border_blue);
        title.setBackgroundColor(table_light_blue);
        title.setHorizontalAlignment(Element.ALIGN_CENTER);
        title.setColspan(15);
        toc.addCell(title);

        h4 = new PdfPCell(new Phrase("", Times_10_B_White));
        h4.setBorderColor(table_border_blue);
        h4.setBackgroundColor(dark_blue);
        h4.setColspan(2);
        toc.addCell(h4);

        h3 = new PdfPCell(new Phrase("% Sensibilidad (S+I)", Times_10_B_White));
        h3.setBorderColor(table_border_blue);
        h3.setBackgroundColor(dark_blue);
        h3.setHorizontalAlignment(Element.ALIGN_CENTER);
        h3.setColspan(13);
        toc.addCell(h3);

        h1 = new PdfPCell(new Phrase("Microorganismo", Times_10_B_White));
        h1.setBorderColor(table_border_blue);
        h1.setBackgroundColor(dark_blue);
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(h1);

        h2 = new PdfPCell(new Phrase("N", Times_10_B_White));
        h2.setBorderColor(table_border_blue);
        h2.setBackgroundColor(dark_blue);
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(h2);

        toc.addCell(am);
        toc.addCell(amc);

        PdfPCell cfm = new PdfPCell(new Phrase("CFM", Times_8_B));
        cfm.setBorderColor(table_border_blue);
        cfm.setBackgroundColor(table_light_blue);
        cfm.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(cfm);

        PdfPCell cro = new PdfPCell(new Phrase("CRO", Times_8_B));
        cro.setBorderColor(table_border_blue);
        cro.setBackgroundColor(table_light_blue);
        cro.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(cro);

        PdfPCell caz = new PdfPCell(new Phrase("CAZ", Times_8_B));
        caz.setBorderColor(table_border_blue);
        caz.setBackgroundColor(table_light_blue);
        caz.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(caz);

        PdfPCell fep = new PdfPCell(new Phrase("FEP", Times_8_B));
        fep.setBorderColor(table_border_blue);
        fep.setBackgroundColor(table_light_blue);
        fep.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(fep);

        PdfPCell atm = new PdfPCell(new Phrase("ATM", Times_8_B));
        atm.setBorderColor(table_border_blue);
        atm.setBackgroundColor(table_light_blue);
        atm.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(atm);

        PdfPCell imp = new PdfPCell(new Phrase("IMP", Times_8_B));
        imp.setBorderColor(table_border_blue);
        imp.setBackgroundColor(table_light_blue);
        imp.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(imp);

        PdfPCell cip = new PdfPCell(new Phrase("CIP", Times_8_B));
        cip.setBorderColor(table_border_blue);
        cip.setBackgroundColor(table_light_blue);
        cip.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(cip);

        toc.addCell(lvx);

        PdfPCell gen = new PdfPCell(new Phrase("GEN", Times_8_B));
        gen.setBorderColor(table_border_blue);
        gen.setBackgroundColor(table_light_blue);
        gen.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(gen);

        PdfPCell tob = new PdfPCell(new Phrase("TOB", Times_8_B));
        tob.setBorderColor(table_border_blue);
        tob.setBackgroundColor(table_light_blue);
        tob.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(tob);

        PdfPCell sxt = new PdfPCell(new Phrase("SXT", Times_8_B));
        sxt.setBorderColor(table_border_blue);
        sxt.setBackgroundColor(table_light_blue);
        sxt.setHorizontalAlignment(Element.ALIGN_CENTER);
        toc.addCell(sxt);

        toc.setHeaderRows(3);

        //Table content
        PdfPCell psae = new PdfPCell(new Phrase("Pseudomonas aeruginosa\n",Times_8_I));
        psae.setHorizontalAlignment(Element.ALIGN_RIGHT);
        psae.setBorderColor(table_border_blue);
        toc.addCell(psae);

        N = ReportData.getN_Pseu_Aeru_O();
        array = ReportData.getPseu_Aeru_O();

        psae = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        psae.setHorizontalAlignment(Element.ALIGN_CENTER);
        psae.setBorderColor(table_border_blue);
        toc.addCell(psae);
        fillUrinaryFTable(toc, psae, array, N);

        PdfPCell haein = new PdfPCell(new Phrase("Haemophilus influenzae\n",Times_8_I));
        haein.setHorizontalAlignment(Element.ALIGN_RIGHT);
        haein.setBorderColor(table_border_blue);
        toc.addCell(haein);

        N = ReportData.getN_Hae_In_O();
        array = ReportData.getHae_In_O();

        haein = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        haein.setHorizontalAlignment(Element.ALIGN_CENTER);
        haein.setBorderColor(table_border_blue);
        toc.addCell(haein);
        fillUrinaryFTable(toc, haein, array, N);

        //Table headers
        float[] columnWidths3 = {20f, 5f, 5f, 5f, 5f, 5f};
        PdfPTable ts = new PdfPTable(columnWidths3);
        ts.setWidthPercentage(45f);

        title = new PdfPCell(new Phrase("Infecciones de transmisión sexual", Times_10_B));
        title.setBorderColor(table_border_blue);
        title.setBackgroundColor(pink);
        title.setHorizontalAlignment(Element.ALIGN_CENTER);
        title.setColspan(6);
        ts.addCell(title);

        h4 = new PdfPCell(new Phrase("", Times_10_B_White));
        h4.setBorderColor(table_border_blue);
        h4.setBackgroundColor(dark_blue);
        h4.setColspan(2);
        ts.addCell(h4);

        h3 = new PdfPCell(new Phrase("% Sensibilidad (S+I)", Times_10_B_White));
        h3.setBorderColor(table_border_blue);
        h3.setBackgroundColor(dark_blue);
        h3.setHorizontalAlignment(Element.ALIGN_CENTER);
        h3.setColspan(13);
        ts.addCell(h3);

        h1 = new PdfPCell(new Phrase("Microorganismo", Times_10_B_White));
        h1.setBorderColor(table_border_blue);
        h1.setBackgroundColor(dark_blue);
        h1.setHorizontalAlignment(Element.ALIGN_CENTER);
        ts.addCell(h1);

        h2 = new PdfPCell(new Phrase("N", Times_10_B_White));
        h2.setBorderColor(table_border_blue);
        h2.setBackgroundColor(dark_blue);
        h2.setHorizontalAlignment(Element.ALIGN_CENTER);
        ts.addCell(h2);

        ts.addCell(cro);
        ts.addCell(cfm);
        ts.addCell(cip);

        PdfPCell azm = new PdfPCell(new Phrase("AZM", Times_8_B));
        azm.setBorderColor(table_border_blue);
        azm.setBackgroundColor(table_light_blue);
        azm.setHorizontalAlignment(Element.ALIGN_CENTER);
        ts.addCell(azm);

        //Table content
        PdfPCell nei = new PdfPCell(new Phrase("Neisseria gonorrhoeae\n",Times_8_I));
        nei.setHorizontalAlignment(Element.ALIGN_RIGHT);
        nei.setBorderColor(table_border_blue);
        ts.addCell(nei);

        N = ReportData.getN_Nei();
        array = ReportData.getNei();

        nei = new PdfPCell(new Phrase(N + "\n",colorN(N)));
        nei.setHorizontalAlignment(Element.ALIGN_CENTER);
        nei.setBorderColor(table_border_blue);
        ts.addCell(nei);
        fillUrinaryFTable(ts, nei, array, N);


        extra.add(tf);
        addEmptyLine(extra, 5);
        extra.add(toc);
        addEmptyLine(extra, 5);
        extra.add(ts);
        doc.add(extra);
    }

    private static void addEmptyLine(Paragraph p, int n) {
        for (int i = 0; i < n; i++) {
            p.add(Chunk.NEWLINE);
        }
    }

    private static Font colorNumber(int n, int N) {
        if(N < 30) {
            return Times_8_Blue;
        } else {
            if (n < 50) {
                return Times_8_Red;
            } else {
                if (n <= 85) {
                    return Times_8;
                } else {
                    return Times_8_Green;
                }
            }
        }
    }

    private static Font colorN(int N){
        if(N < 30) {
            return Times_8_Blue_I;
        } else {
            return  Times_8_I;
        }
    }

    private static void fillUrinaryFTable(PdfPTable t, PdfPCell c, int [] a, int N) {
        int l = a.length;
        for(int i = 0; i<l; i++){
            c = new PdfPCell(new Phrase(a[i] + "\n",colorNumber(a[i], N)));
            c.setHorizontalAlignment(Element.ALIGN_CENTER);
            c.setBorderColor(table_border_blue);
            t.addCell(c);
        }
    }
}
