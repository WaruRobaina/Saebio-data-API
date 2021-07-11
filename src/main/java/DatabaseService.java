import javax.xml.transform.Result;
import java.sql.*;

public class DatabaseService {

    public static void addEntry(Entry entry) throws SQLException {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/saebio", "root", "prueba")) {

            String query = " insert into sensibilidad (procedencia, servicio, tipodemuestra, microorganismo, peticion, " +
                    "fechapeticion, nhc, paciente, fechanacimiento, edad, sexo, mes, año, idtipomuestra, idmicroorganismo, numeroaislamiento, amc," +
                    "amp, amx, an, andi, anfb, atm, azm, bla, bleem, bleev, c1, caz, cbp, cc, cf, cip, cl, clox, clr, clv, " +
                    "cp, cpnm, cro, ctp, ctx, cxma, cxms, cza, czt, dalba, dap, e, emb, epm, fep, fix, flu, fluor, fm, fo, fox, " +
                    "fus, gm, gm500, inh, ipm, itr, k1000, lvx, lzd, mem, met, mf, mino, mlsbi, moxi, mup1, na, nor, norf," +
                    "npcolist, oxa, p, peflox, pip, pit, pos, pz, rf, scf, sm, st2000, sxt, syn, te, tei, temo, tgc, tic," +
                    "ticcla, tn, va, vor)"
                    + " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?," +
                    "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setString(1, entry.getOrigin());
                stmt.setString(2, entry.getService());
                stmt.setString(3, entry.getTypeofsample());
                stmt.setString(4, entry.getMicroorganism());
                stmt.setInt(5, entry.getRequest());
                stmt.setString(6, entry.getRequestdate());
                stmt.setString(7, entry.getNhc());
                stmt.setString(8, entry.getPacient());
                stmt.setString(9, entry.getBirthday());
                stmt.setInt(10,entry.getAge());
                stmt.setString(11, entry.getSex());
                stmt.setInt(12, entry.getMonth());
                stmt.setInt(13, entry.getYear());
                stmt.setInt(14, entry.getIdtypeofsample());
                stmt.setInt(15, entry.getIdmicroorganism());
                stmt.setInt(16, entry.getIsolate());
                stmt.setString(17, entry.getAmc());
                stmt.setString(18, entry.getAmp());
                stmt.setString(19, entry.getAmx());
                stmt.setString(20, entry.getAn());
                stmt.setString(21, entry.getAndi());
                stmt.setString(22, entry.getAnfb());
                stmt.setString(23, entry.getAtm());
                stmt.setString(24, entry.getAzm());
                stmt.setString(25, entry.getBla());
                stmt.setString(26, entry.getBleem());
                stmt.setString(27, entry.getBleev());
                stmt.setString(28, entry.getC1());
                stmt.setString(29, entry.getCaz());
                stmt.setString(30, entry.getCbp());
                stmt.setString(31, entry.getCc());
                stmt.setString(32, entry.getCf());
                stmt.setString(33, entry.getCip());
                stmt.setString(34, entry.getCl());
                stmt.setString(35, entry.getClox());
                stmt.setString(36, entry.getClr());
                stmt.setString(37, entry.getClv());
                stmt.setString(38, entry.getCp());
                stmt.setString(39, entry.getCpnm());
                stmt.setString(40, entry.getCro());
                stmt.setString(41, entry.getCtp());
                stmt.setString(42, entry.getCtx());
                stmt.setString(43, entry.getCxma());
                stmt.setString(44, entry.getCxms());
                stmt.setString(45, entry.getCza());
                stmt.setString(46, entry.getCzt());
                stmt.setString(47, entry.getDalba());
                stmt.setString(48, entry.getDap());
                stmt.setString(49, entry.getE());
                stmt.setString(50, entry.getEmb());
                stmt.setString(51, entry.getEpm());
                stmt.setString(52, entry.getFep());
                stmt.setString(53, entry.getFix());
                stmt.setString(54, entry.getFlu());
                stmt.setString(55, entry.getFluor());
                stmt.setString(56, entry.getFm());
                stmt.setString(57, entry.getFo());
                stmt.setString(58, entry.getFox());
                stmt.setString(59, entry.getFus());
                stmt.setString(60, entry.getGm());
                stmt.setString(61, entry.getGm500());
                stmt.setString(62, entry.getInh());
                stmt.setString(63, entry.getIpm());
                stmt.setString(64, entry.getItr());
                stmt.setString(65, entry.getK1000());
                stmt.setString(66, entry.getLvx());
                stmt.setString(67, entry.getLzd());
                stmt.setString(68, entry.getMem());
                stmt.setString(69, entry.getMet());
                stmt.setString(70, entry.getMf());
                stmt.setString(71, entry.getMino());
                stmt.setString(72, entry.getMlsbi());
                stmt.setString(73, entry.getMoxi());
                stmt.setString(74, entry.getMup1());
                stmt.setString(75, entry.getNa());
                stmt.setString(76, entry.getNor());
                stmt.setString(77, entry.getNorf());
                stmt.setString(78, entry.getNpcolist());
                stmt.setString(79, entry.getOxa());
                stmt.setString(80, entry.getP());
                stmt.setString(81, entry.getPeflox());
                stmt.setString(82, entry.getPip());
                stmt.setString(83, entry.getPit());
                stmt.setString(84, entry.getPos());
                stmt.setString(85, entry.getPz());
                stmt.setString(86, entry.getRf());
                stmt.setString(87, entry.getScf());
                stmt.setString(88, entry.getSm());
                stmt.setString(89, entry.getSt2000());
                stmt.setString(90, entry.getSxt());
                stmt.setString(91, entry.getSyn());
                stmt.setString(92, entry.getTe());
                stmt.setString(93, entry.getTei());
                stmt.setString(94, entry.getTemo());
                stmt.setString(95, entry.getTgc());
                stmt.setString(96, entry.getTic());
                stmt.setString(97, entry.getTiccla());
                stmt.setString(98, entry.getTn());
                stmt.setString(99, entry.getVa());
                stmt.setString(100, entry.getVor());
                stmt.execute();

                connection.close();
            } catch (SQLException e) {
                System.out.println("statement failed");
            }
        } catch (SQLException e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }

    public static void readEntry(int year, String origin){
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/saebio", "root", "prueba")) {
            String query="select * from sensibilidad where año=? and procedencia=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1,year);
            ps.setString(2, origin);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Entry e = new Entry(rs.getString("procedencia"),rs.getString("servicio"),
                        rs.getString("tipodemuestra"), rs.getString("microorganismo"),
                        rs.getInt("peticion"),rs.getString("fechapeticion"),
                        rs.getString("nhc"),rs.getString("paciente"), rs.getString("fechanacimiento"),
                        rs.getInt("edad"),rs.getString("sexo"),rs.getInt("mes"),
                        rs.getInt("año"),rs.getInt("idtipomuestra"),rs.getInt("idmicroorganismo"),
                        rs.getInt("numeroaislamiento"),rs.getString("amc"), rs.getString("amp"),
                        rs.getString("amx"),rs.getString("an"), rs.getString("andi"),
                        rs.getString("anfb"), rs.getString("atm"), rs.getString("azm"),
                        rs.getString("bla"), rs.getString("bleem"), rs.getString("bleev"),
                        rs.getString("c1"), rs.getString("caz"), rs.getString("cbp"),
                        rs.getString("cc"), rs.getString("cf"), rs.getString("cip"),
                        rs.getString("cl"), rs.getString("clox"), rs.getString("clr"),
                        rs.getString("clv"), rs.getString("cp"), rs.getString("cpnm"),
                        rs.getString("cro"), rs.getString("ctp"), rs.getString("ctx"),
                        rs.getString("cxma"), rs.getString("cxms"), rs.getString("cza"),
                        rs.getString("czt"), rs.getString("dalba"), rs.getString("dap"),
                        rs.getString("e"), rs.getString("emb"), rs.getString("epm"),
                        rs.getString("fep"), rs.getString("fix"), rs.getString("flu"),
                        rs.getString("fluor"), rs.getString("fm"), rs.getString("fo"),
                        rs.getString("fox"), rs.getString("fus"), rs.getString("gm"),
                        rs.getString("gm500"), rs.getString("inh"), rs.getString("ipm"),
                        rs.getString("itr"), rs.getString("k1000"), rs.getString("lvx"),
                        rs.getString("lzd"), rs.getString("mem"), rs.getString("met"),
                        rs.getString("mf"), rs.getString("mino"), rs.getString("mlsbi"),
                        rs.getString("moxi"), rs.getString("mup1"), rs.getString("na"),
                        rs.getString("nor"), rs.getString("norf"), rs.getString("npcolist"),
                        rs.getString("oxa"), rs.getString("p"), rs.getString("peflox"),
                        rs.getString("pip"), rs.getString("pit"), rs.getString("pos"),
                        rs.getString("pz"), rs.getString("rf"), rs.getString("scf"),
                        rs.getString("sm"), rs.getString("st2000"), rs.getString("sxt"),
                        rs.getString("syn"),rs.getString("te"), rs.getString("tei"),
                        rs.getString("temo"),rs.getString("tgc"),rs.getString("tic"),
                        rs.getString("ticcla"), rs.getString("tn"), rs.getString("va"),
                        rs.getString("vor"));
                ReportData.countEntry(e);
            }
        } catch (SQLException e) {
            System.out.println("connection failed");
            e.printStackTrace();
        }
    }



}

