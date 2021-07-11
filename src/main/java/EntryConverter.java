import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

public class EntryConverter {
    public static Entry converter(CsvEntry csventry){
        String origin = normalizeString(csventry.getOrigin());
        if(origin.equals("hospital univ. g.c. dr. negrin")){
            origin="hospital de gran canaria dr. negrin";
        }
        String service = normalizeString(csventry.getService());
        String type_of_sample = normalizeString(csventry.getType_of_sample());
        String microorganism = normalizeString(csventry.getMicroorganism());
        String nhc = normalizeString(csventry.getNhc());
        String patient = normalizeString(csventry.getPatient().toLowerCase().trim().replaceAll(" +", " "));
        String sex = normalizeString(csventry.getSex().toLowerCase().trim().replaceAll(" +", " "));
        String request_date = normalizeDate(csventry.getRequest_date());
        String aux_birthdate="2000-01-01";
        int age = getAge(aux_birthdate);
        String amc = normalizeAntibiotic(csventry.getAmc());
        String amp = normalizeAntibiotic(csventry.getAmp());
        String amx = normalizeAntibiotic(csventry.getAmx());
        String an = normalizeAntibiotic(csventry.getAn());
        String andi = normalizeAntibiotic(csventry.getAndi());
        String anfb = normalizeAntibiotic(csventry.getAnfb());
        String atm = normalizeAntibiotic(csventry.getAtm());
        String azm = normalizeAntibiotic(csventry.getAzm());
        String bla = normalizeAntibiotic(csventry.getBla());
        String bleem = normalizeAntibiotic(csventry.getBleem());
        String bleev = normalizeAntibiotic(csventry.getBleev());
        String c1 = normalizeAntibiotic(csventry.getC1());
        String caz = normalizeAntibiotic(csventry.getCaz());
        String cbp = normalizeAntibiotic(csventry.getCbp());
        String cc = normalizeAntibiotic(csventry.getCc());
        String cf = normalizeAntibiotic(csventry.getCf());
        String cip = normalizeAntibiotic(csventry.getCip());
        String cl = normalizeAntibiotic(csventry.getCl());
        String clox = normalizeAntibiotic(csventry.getClox());
        String clr = normalizeAntibiotic(csventry.getClr());
        String clv = normalizeAntibiotic(csventry.getClv());
        String cp = normalizeAntibiotic(csventry.getCp());
        String cpnm = normalizeAntibiotic(csventry.getCpnm());
        String cro = normalizeAntibiotic(csventry.getCro());
        String ctp = normalizeAntibiotic(csventry.getCtp());
        String ctx = normalizeAntibiotic(csventry.getCtx());
        String cxma = normalizeAntibiotic(csventry.getCxma());
        String cxms = normalizeAntibiotic(csventry.getCxms());
        String cza = normalizeAntibiotic(csventry.getCza());
        String czt = normalizeAntibiotic(csventry.getCzt());
        String dalba = normalizeAntibiotic(csventry.getDalba());
        String dap = normalizeAntibiotic(csventry.getDap());
        String e = normalizeAntibiotic(csventry.getE());
        String emb = normalizeAntibiotic(csventry.getEmb());
        String epm = normalizeAntibiotic(csventry.getEpm());
        String fep = normalizeAntibiotic(csventry.getFep());
        String fix = normalizeAntibiotic(csventry.getFix());
        String flu = normalizeAntibiotic(csventry.getFlu());
        String fluor = normalizeAntibiotic(csventry.getFluor());
        String fm = normalizeAntibiotic(csventry.getFm());
        String fo = normalizeAntibiotic(csventry.getFo());
        String fox = normalizeAntibiotic(csventry.getFox());
        String fus = normalizeAntibiotic(csventry.getFus());
        String gm = normalizeAntibiotic(csventry.getGm());
        String gm500 = normalizeAntibiotic(csventry.getGm500());
        String inh = normalizeAntibiotic(csventry.getInh());
        String ipm = normalizeAntibiotic(csventry.getIpm());
        String itr = normalizeAntibiotic(csventry.getItr());
        String k1000 = normalizeAntibiotic(csventry.getK1000());
        String lvx = normalizeAntibiotic(csventry.getLvx());
        String lzd = normalizeAntibiotic(csventry.getLzd());
        String mem = normalizeAntibiotic(csventry.getMem());
        String met = normalizeAntibiotic(csventry.getMet());
        String mf = normalizeAntibiotic(csventry.getMf());
        String mino = normalizeAntibiotic(csventry.getMino());
        String mlsbi = normalizeAntibiotic(csventry.getMlsbi());
        String moxi = normalizeAntibiotic(csventry.getMoxi());
        String mup1 = normalizeAntibiotic(csventry.getMup1());
        String na = normalizeAntibiotic(csventry.getNa());
        String nor = normalizeAntibiotic(csventry.getNor());
        String norf = normalizeAntibiotic(csventry.getNorf());
        String npcolist = normalizeAntibiotic(csventry.getNpcolist());
        String oxa = normalizeAntibiotic(csventry.getOxa());
        String p = normalizeAntibiotic(csventry.getP());
        String peflox = normalizeAntibiotic(csventry.getPeflox());
        String pip = normalizeAntibiotic(csventry.getPip());
        String pit = normalizeAntibiotic(csventry.getPit());
        String pos = normalizeAntibiotic(csventry.getPos());
        String pz = normalizeAntibiotic(csventry.getPz());
        String rf = normalizeAntibiotic(csventry.getRf());
        String scf = normalizeAntibiotic(csventry.getScf());
        String sm = normalizeAntibiotic(csventry.getSm());
        String st2000 = normalizeAntibiotic(csventry.getSt2000());
        String sxt = normalizeAntibiotic(csventry.getSxt());
        String syn = normalizeAntibiotic(csventry.getSyn());
        String te = normalizeAntibiotic(csventry.getTe());
        String tei = normalizeAntibiotic(csventry.getTei());
        String temo = normalizeAntibiotic(csventry.getTemo());
        String tgc = normalizeAntibiotic(csventry.getTgc());
        String tic = normalizeAntibiotic(csventry.getTic());
        String ticcla = normalizeAntibiotic(csventry.getTiccla());
        String tn = normalizeAntibiotic(csventry.getTn());
        String va = normalizeAntibiotic(csventry.getVa());
        String vor = normalizeAntibiotic(csventry.getVor());

        return new Entry(origin, service, type_of_sample, microorganism, csventry.getRequest(),
                request_date, nhc, patient, aux_birthdate, age, sex, csventry.getMonth(), csventry.getYear(),
                csventry.getId_type_of_sample(), csventry.getId_microorganism(), csventry.getIsolate(), amc,
                amp, amx, an, andi, anfb, atm, azm, bla, bleem, bleev, c1, caz, cbp, cc, cf, cip, cl, clox, clr, clv,
                cp, cpnm, cro, ctp, ctx, cxma, cxms, cza, czt, dalba, dap, e, emb, epm, fep, fix, flu, fluor, fm, fo,
                fox, fus, gm, gm500, inh, ipm, itr, k1000, lvx, lzd, mem, met, mf, mino, mlsbi, moxi, mup1, na, nor,
                norf, npcolist, oxa, p, peflox, pip, pit, pos, pz, rf, scf, sm, st2000, sxt, syn, te, tei, temo, tgc,
                tic, ticcla, tn, va, vor);
    }

    private static String normalizeString(String str){
        return str.toLowerCase().trim().replaceAll(" +", " ");
    }

    private static String normalizeAntibiotic(String str){
        str = str.toLowerCase().trim().replaceAll(" +", " ");
        if (str.equals("s") || str.equals("saexpo") || str.equals("i") || str.equals("intermedio")) str = "sensible";
        if (str.equals("atu") || str.equals("r")) str = "resistente";
        return str;
    }

    private static String normalizeDate(String date){
        String res="";
        String input_format="dd/MM/yyyy";
        String normalized_format = "yyyy-MM-dd";
        SimpleDateFormat inputdate = new SimpleDateFormat(input_format);
        SimpleDateFormat resdate = new SimpleDateFormat(normalized_format);
        try {
            Date requestdate = inputdate.parse(date);
            res = resdate.format(requestdate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return res;
    }

    private static int getAge(String date){
        //Random age for anonimized data
        /*int age;
        if(date.equals("")){
            age=140;
        } else {
            int day = Integer.parseInt(date.substring(0,2));
            int month = Integer.parseInt(date.substring(3,5));
            int year = Integer.parseInt(date.substring(6,10));
            LocalDate now = LocalDate.now();
            LocalDate birth = LocalDate.of(year, month, day);
            age = Period.between(birth, now).getYears();
        }*/
        int age = (int) (Math.random() * (95 - 12)) + 12;
        return age;
    }

}
