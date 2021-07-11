import com.opencsv.bean.CsvBindByName;

public class CsvEntry {
    @CsvBindByName (column = "Procedencia")
    private String origin;
    @CsvBindByName (column = "Servicio")
    private String service;
    @CsvBindByName (column = "Destino")
    private String destiny;
    @CsvBindByName (column = "Medico")
    private String doctor;
    @CsvBindByName (column = "Area")
    private String area;
    @CsvBindByName (column = "TipoDeMuestra")
    private String type_of_sample;
    @CsvBindByName (column = "Cultivo")
    private String culture;
    @CsvBindByName (column = "Microorganismo")
    private String microorganism;
    @CsvBindByName (column = "ResMicroorganismo")
    private String res_microorganism;
    @CsvBindByName (column = "Peticion")
    private int request;
    @CsvBindByName(column = "FechaPeticion")
    private String request_date;
    @CsvBindByName(column = "NHC")
    private String nhc;
    @CsvBindByName(column = "Paciente")
    private String patient;
    @CsvBindByName(column = "FechaNacimiento")
    private String birthdate;
    @CsvBindByName(column = "Sexo")
    private String sex;
    @CsvBindByName(column = "Urgente")
    private String urgent;
    @CsvBindByName(column = "Mes")
    private int month;
    @CsvBindByName(column = "Año")
    private int year;
    @CsvBindByName(column = "IdTipoMuestra")
    private int id_type_of_sample;
    @CsvBindByName(column = "IdMicroorganismo")
    private int id_microorganism;
    @CsvBindByName(column = "IdArea")
    private int id_area;
    @CsvBindByName(column = "NumeroAislamiento")
    private int isolate;
    @CsvBindByName(column = "AMC")
    private String amc;
    @CsvBindByName(column = "AMP")
    private String amp;
    @CsvBindByName(column = "AMX")
    private String amx;
    @CsvBindByName(column = "AN")
    private String an;
    @CsvBindByName(column = "ANDI")
    private String andi;
    @CsvBindByName(column = "ANFB")
    private String anfb;
    @CsvBindByName(column = "ATM")
    private String atm;
    @CsvBindByName(column = "AZM")
    private String azm;
    @CsvBindByName(column = "BLA")
    private String bla;
    @CsvBindByName(column = "BLEEm")
    private String bleem;
    @CsvBindByName(column = "BLEEv")
    private String bleev;
    @CsvBindByName(column = "C1")
    private String c1;
    @CsvBindByName(column = "CAZ")
    private String caz;
    @CsvBindByName(column = "CBP")
    private String cbp;
    @CsvBindByName(column = "CC")
    private String cc;
    @CsvBindByName(column = "CF")
    private String cf;
    @CsvBindByName(column = "CIP")
    private String cip;
    @CsvBindByName(column = "CL")
    private String cl;
    @CsvBindByName(column = "CLOX")
    private String clox;
    @CsvBindByName(column = "CLR")
    private String clr;
    @CsvBindByName(column = "CLv")
    private String clv;
    @CsvBindByName(column = "CP")
    private String cp;
    @CsvBindByName(column = "Cpnm")
    private String cpnm;
    @CsvBindByName(column = "CRO")
    private String cro;
    @CsvBindByName(column = "CTP")
    private String ctp;
    @CsvBindByName(column = "CTX")
    private String ctx;
    @CsvBindByName(column = "CXMA")
    private String cxma;
    @CsvBindByName(column = "CXMS")
    private String cxms;
    @CsvBindByName(column = "CZA")
    private String cza;
    @CsvBindByName(column = "CZT")
    private String czt;
    @CsvBindByName(column = "DALBA")
    private String dalba;
    @CsvBindByName(column = "DAP")
    private String dap;
    @CsvBindByName(column = "E")
    private String e;
    @CsvBindByName(column = "EMB")
    private String emb;
    @CsvBindByName(column = "EPM")
    private String epm;
    @CsvBindByName(column = "FEP")
    private String fep;
    @CsvBindByName(column = "FIX")
    private String fix;
    @CsvBindByName(column = "FLU")
    private String flu;
    @CsvBindByName(column = "FLUOR")
    private String fluor;
    @CsvBindByName(column = "FM")
    private String fm;
    @CsvBindByName(column = "FO")
    private String fo;
    @CsvBindByName(column = "FOX")
    private String fox;
    @CsvBindByName(column = "FUS")
    private String fus;
    @CsvBindByName(column = "GM")
    private String gm;
    @CsvBindByName(column = "GM500")
    private String gm500;
    @CsvBindByName(column = "INH")
    private String inh;
    @CsvBindByName(column = "IPM")
    private String ipm;
    @CsvBindByName(column = "ITR")
    private String itr;
    @CsvBindByName(column = "K1000")
    private String k1000;
    @CsvBindByName(column = "LVX")
    private String lvx;
    @CsvBindByName(column = "LZD")
    private String lzd;
    @CsvBindByName(column = "MEM")
    private String mem;
    @CsvBindByName(column = "MET")
    private String met;
    @CsvBindByName(column = "MF")
    private String mf;
    @CsvBindByName(column = "MINO")
    private String mino;
    @CsvBindByName(column = "MLSBi")
    private String mlsbi;
    @CsvBindByName(column = "MOXI")
    private String moxi;
    @CsvBindByName(column = "MUP1")
    private String mup1;
    @CsvBindByName(column = "NA")
    private String na;
    @CsvBindByName(column = "NOR")
    private String nor;
    @CsvBindByName(column = "NORF")
    private String norf;
    @CsvBindByName(column = "NPcolist")
    private String npcolist;
    @CsvBindByName(column = "OXA")
    private String oxa;
    @CsvBindByName(column = "P")
    private String p;
    @CsvBindByName(column = "PEFLOX")
    private String peflox;
    @CsvBindByName(column = "PIP")
    private String pip;
    @CsvBindByName(column = "PIT")
    private String pit;
    @CsvBindByName(column = "POS")
    private String pos;
    @CsvBindByName(column = "PZ")
    private String pz;
    @CsvBindByName(column = "RF")
    private String rf;
    @CsvBindByName(column = "SCf")
    private String scf;
    @CsvBindByName(column = "SM")
    private String sm;
    @CsvBindByName(column = "ST2000")
    private String st2000;
    @CsvBindByName(column = "SXT")
    private String sxt;
    @CsvBindByName(column = "SYN")
    private String syn;
    @CsvBindByName(column = "TE")
    private String te;
    @CsvBindByName(column = "TEI")
    private String tei;
    @CsvBindByName(column = "TEMO")
    private String temo;
    @CsvBindByName(column = "TGC")
    private String tgc;
    @CsvBindByName(column = "TIC")
    private String tic;
    @CsvBindByName(column = "TicCla")
    private String ticcla;
    @CsvBindByName(column = "TN")
    private String tn;
    @CsvBindByName(column = "VA")
    private String va;
    @CsvBindByName(column = "VOR")
    private String vor;
    @CsvBindByName(column = "AMCcmi")
    private String amccmi;
    @CsvBindByName(column = "AMPcmi")
    private String ampcmi;
    @CsvBindByName(column = "AMXcmi")
    private String amxcmi;
    @CsvBindByName(column = "ANcmi")
    private String ancmi;
    @CsvBindByName(column = "ANDIcmi")
    private String andicmi;
    @CsvBindByName(column = "ANFBcmi")
    private String anfbcmi;
    @CsvBindByName(column = "ATMcmi")
    private String atmcmi;
    @CsvBindByName(column = "AZMcmi")
    private String azmcmi;
    @CsvBindByName(column = "BLAcmi")
    private String blacmi;
    @CsvBindByName(column = "BLEEmcmi")
    private String bleemcmi;
    @CsvBindByName(column = "BLEEvcmi")
    private String bleevcmi;
    @CsvBindByName(column = "C1cmi")
    private String c1cmi;
    @CsvBindByName(column = "CAZcmi")
    private String cazcmi;
    @CsvBindByName(column = "CBPcmi")
    private String cbpcmi;
    @CsvBindByName(column = "CCcmi")
    private String cccmi;
    @CsvBindByName(column = "CFcmi")
    private String cfcmi;
    @CsvBindByName(column = "CIPcmi")
    private String cipcmi;
    @CsvBindByName(column = "CLcmi")
    private String clcmi;
    @CsvBindByName(column = "CLOXcmi")
    private String cloxcmi;
    @CsvBindByName(column = "CLRcmi")
    private String clrcmi;
    @CsvBindByName(column = "CLvcmi")
    private String clvcmi;
    @CsvBindByName(column = "CPcmi")
    private String cpcmi;
    @CsvBindByName(column = "Cpnmcmi")
    private String cpnmcmi;
    @CsvBindByName(column = "CROcmi")
    private String crocmi;
    @CsvBindByName(column = "CTPcmi")
    private String ctpcmi;
    @CsvBindByName(column = "CTXcmi")
    private String ctxcmi;
    @CsvBindByName(column = "CXMAcmi")
    private String cxmacmi;
    @CsvBindByName(column = "CXMScmi")
    private String cxmscmi;
    @CsvBindByName(column = "CZAcmi")
    private String czacmi;
    @CsvBindByName(column = "CZTcmi")
    private String cztcmi;
    @CsvBindByName(column = "DALBAcmi")
    private String dalbacmi;
    @CsvBindByName(column = "DAPcmi")
    private String dapcmi;
    @CsvBindByName(column = "Ecmi")
    private String ecmi;
    @CsvBindByName(column = "EMBcmi")
    private String embcmi;
    @CsvBindByName(column = "EPMcmi")
    private String epmcmi;
    @CsvBindByName(column = "FEPcmi")
    private String fepcmi;
    @CsvBindByName(column = "FIXcmi")
    private String fixcmi;
    @CsvBindByName(column = "FLUcmi")
    private String flucmi;
    @CsvBindByName(column = "FLUORcmi")
    private String fluorcmi;
    @CsvBindByName(column = "FMcmi")
    private String fmcmi;
    @CsvBindByName(column = "FOcmi")
    private String focmi;
    @CsvBindByName(column = "FOXcmi")
    private String foxcmi;
    @CsvBindByName(column = "FUScmi")
    private String fuscmi;
    @CsvBindByName(column = "GMcmi")
    private String gmcmi;
    @CsvBindByName(column = "GM500cmi")
    private String gm500cmi;
    @CsvBindByName(column = "INHcmi")
    private String inhcmi;
    @CsvBindByName(column = "IPMcmi")
    private String ipmcmi;
    @CsvBindByName(column = "ITRcmi")
    private String itrcmi;
    @CsvBindByName(column = "K1000cmi")
    private String k1000cmi;
    @CsvBindByName(column = "LVXcmi")
    private String lvxcmi;
    @CsvBindByName(column = "LZDcmi")
    private String lzdcmi;
    @CsvBindByName(column = "MEMcmi")
    private String memcmi;
    @CsvBindByName(column = "METcmi")
    private String metcmi;
    @CsvBindByName(column = "MFcmi")
    private String mfcmi;
    @CsvBindByName(column = "MINOcmi")
    private String minocmi;
    @CsvBindByName(column = "MLSBicmi")
    private String mlsbicmi;
    @CsvBindByName(column = "MOXIcmi")
    private String moxicmi;
    @CsvBindByName(column = "MUP1cmi")
    private String mup1cmi;
    @CsvBindByName(column = "NAcmi")
    private String nacmi;
    @CsvBindByName(column = "NORcmi")
    private String norcmi;
    @CsvBindByName(column = "NORFcmi")
    private String norfcmi;
    @CsvBindByName(column = "NPcolistcmi")
    private String npcolistcmi;
    @CsvBindByName(column = "OXAcmi")
    private String oxacmi;
    @CsvBindByName(column = "Pcmi")
    private String pcmi;
    @CsvBindByName(column = "PEFLOXcmi")
    private String pefloxcmi;
    @CsvBindByName(column = "PIPcmi")
    private String pipcmi;
    @CsvBindByName(column = "PITcmi")
    private String pitcmi;
    @CsvBindByName(column = "POScmi")
    private String poscmi;
    @CsvBindByName(column = "PZcmi")
    private String pzcmi;
    @CsvBindByName(column = "RFcmi")
    private String rfcmi;
    @CsvBindByName(column = "SCfcmi")
    private String scfcmi;
    @CsvBindByName(column = "SMcmi")
    private String smcmi;
    @CsvBindByName(column = "ST2000cmi")
    private String st2000cmi;
    @CsvBindByName(column = "SXTcmi")
    private String sxtcmi;
    @CsvBindByName(column = "SYNcmi")
    private String syncmi;
    @CsvBindByName(column = "TEcmi")
    private String tecmi;
    @CsvBindByName(column = "TEIcmi")
    private String teicmi;
    @CsvBindByName(column = "TEMOcmi")
    private String temocmi;
    @CsvBindByName(column = "TGCcmi")
    private String tgccmi;
    @CsvBindByName(column = "TICcmi")
    private String ticcmi;
    @CsvBindByName(column = "TicClacmi")
    private String ticclacmi;
    @CsvBindByName(column = "TNcmi")
    private String tncmi;
    @CsvBindByName(column = "VAcmi")
    private String vacmi;
    /*
    @CsvBindByName(column = "VORcmi")
    private String vorcmi;*/

    public String getRf() {
        return rf;
    }

    public void setRf(String rf) {
        this.rf = rf;
    }

    public String getScf() {
        return scf;
    }

    public void setScf(String scf) {
        this.scf = scf;
    }

    public String getSm() {
        return sm;
    }

    public void setSm(String sm) {
        this.sm = sm;
    }

    public String getSt2000() {
        return st2000;
    }

    public void setSt2000(String st2000) {
        this.st2000 = st2000;
    }

    public String getSxt() {
        return sxt;
    }

    public void setSxt(String sxt) {
        this.sxt = sxt;
    }

    public String getSyn() {
        return syn;
    }

    public void setSyn(String syn) {
        this.syn = syn;
    }

    public String getTe() {
        return te;
    }

    public void setTe(String te) {
        this.te = te;
    }

    public String getTei() {
        return tei;
    }

    public void setTei(String tei) {
        this.tei = tei;
    }

    public String getTemo() {
        return temo;
    }

    public void setTemo(String temo) {
        this.temo = temo;
    }

    public String getTgc() {
        return tgc;
    }

    public void setTgc(String tgc) {
        this.tgc = tgc;
    }

    public String getTic() {
        return tic;
    }

    public void setTic(String tic) {
        this.tic = tic;
    }

    public String getTiccla() {
        return ticcla;
    }

    public void setTiccla(String ticcla) {
        this.ticcla = ticcla;
    }

    public String getTn() {
        return tn;
    }

    public void setTn(String tn) {
        this.tn = tn;
    }

    public String getVa() {
        return va;
    }

    public void setVa(String va) {
        this.va = va;
    }

    public String getVor() {
        return vor;
    }

    public void setVor(String vor) {
        this.vor = vor;
    }

    public String getNa() {
        return na;
    }

    public void setNa(String na) {
        this.na = na;
    }

    public String getNor() {
        return nor;
    }

    public void setNor(String nor) {
        this.nor = nor;
    }

    public String getNorf() {
        return norf;
    }

    public void setNorf(String norf) {
        this.norf = norf;
    }

    public String getNpcolist() {
        return npcolist;
    }

    public void setNpcolist(String npcolist) {
        this.npcolist = npcolist;
    }

    public String getOxa() {
        return oxa;
    }

    public void setOxa(String oxa) {
        this.oxa = oxa;
    }

    public String getP() {
        return p;
    }

    public void setP(String p) {
        this.p = p;
    }

    public String getPeflox() {
        return peflox;
    }

    public void setPeflox(String peflox) {
        this.peflox = peflox;
    }

    public String getPip() {
        return pip;
    }

    public void setPip(String pip) {
        this.pip = pip;
    }

    public String getPit() {
        return pit;
    }

    public void setPit(String pit) {
        this.pit = pit;
    }

    public String getPos() {
        return pos;
    }

    public void setPos(String pos) {
        this.pos = pos;
    }

    public String getPz() {
        return pz;
    }

    public void setPz(String pz) {
        this.pz = pz;
    }

    public String getGm() {
        return gm;
    }

    public void setGm(String gm) {
        this.gm = gm;
    }

    public String getGm500() {
        return gm500;
    }

    public void setGm500(String gm500) {
        this.gm500 = gm500;
    }

    public String getInh() {
        return inh;
    }

    public void setInh(String inh) {
        this.inh = inh;
    }

    public String getIpm() {
        return ipm;
    }

    public void setIpm(String ipm) {
        this.ipm = ipm;
    }

    public String getItr() {
        return itr;
    }

    public void setItr(String itr) {
        this.itr = itr;
    }

    public String getK1000() {
        return k1000;
    }

    public void setK1000(String k1000) {
        this.k1000 = k1000;
    }

    public String getLvx() {
        return lvx;
    }

    public void setLvx(String lvx) {
        this.lvx = lvx;
    }

    public String getLzd() {
        return lzd;
    }

    public void setLzd(String lzd) {
        this.lzd = lzd;
    }

    public String getMem() {
        return mem;
    }

    public void setMem(String mem) {
        this.mem = mem;
    }

    public String getMet() {
        return met;
    }

    public void setMet(String met) {
        this.met = met;
    }

    public String getMf() {
        return mf;
    }

    public void setMf(String mf) {
        this.mf = mf;
    }

    public String getMino() {
        return mino;
    }

    public void setMino(String mino) {
        this.mino = mino;
    }

    public String getMlsbi() {
        return mlsbi;
    }

    public void setMlsbi(String mlsbi) {
        this.mlsbi = mlsbi;
    }

    public String getMoxi() {
        return moxi;
    }

    public void setMoxi(String moxi) {
        this.moxi = moxi;
    }

    public String getMup1() {
        return mup1;
    }

    public void setMup1(String mup1) {
        this.mup1 = mup1;
    }

    public String getDalba() {
        return dalba;
    }

    public void setDalba(String dalba) {
        this.dalba = dalba;
    }

    public String getDap() {
        return dap;
    }

    public void setDap(String dap) {
        this.dap = dap;
    }

    public String getE() {
        return e;
    }

    public void setE(String e) {
        this.e = e;
    }

    public String getEmb() {
        return emb;
    }

    public void setEmb(String emb) {
        this.emb = emb;
    }

    public String getEpm() {
        return epm;
    }

    public void setEpm(String epm) {
        this.epm = epm;
    }

    public String getFep() {
        return fep;
    }

    public void setFep(String fep) {
        this.fep = fep;
    }

    public String getFix() {
        return fix;
    }

    public void setFix(String fix) {
        this.fix = fix;
    }

    public String getFlu() {
        return flu;
    }

    public void setFlu(String flu) {
        this.flu = flu;
    }

    public String getFluor() {
        return fluor;
    }

    public void setFluor(String fluor) {
        this.fluor = fluor;
    }

    public String getFm() {
        return fm;
    }

    public void setFm(String fm) {
        this.fm = fm;
    }

    public String getFo() {
        return fo;
    }

    public void setFo(String fo) {
        this.fo = fo;
    }

    public String getFox() {
        return fox;
    }

    public void setFox(String fox) {
        this.fox = fox;
    }

    public String getFus() {
        return fus;
    }

    public void setFus(String fus) {
        this.fus = fus;
    }

    public String getC1() {
        return c1;
    }

    public void setC1(String c1) {
        this.c1 = c1;
    }

    public String getCaz() {
        return caz;
    }

    public void setCaz(String caz) {
        this.caz = caz;
    }

    public String getCbp() {
        return cbp;
    }

    public void setCbp(String cbp) {
        this.cbp = cbp;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getCip() {
        return cip;
    }

    public void setCip(String cip) {
        this.cip = cip;
    }

    public String getCl() {
        return cl;
    }

    public void setCl(String cl) {
        this.cl = cl;
    }

    public String getClox() {
        return clox;
    }

    public void setClox(String clox) {
        this.clox = clox;
    }

    public String getClr() {
        return clr;
    }

    public void setClr(String clr) {
        this.clr = clr;
    }

    public String getClv() {
        return clv;
    }

    public void setClv(String clv) {
        this.clv = clv;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getCpnm() {
        return cpnm;
    }

    public void setCpnm(String cpnm) {
        this.cpnm = cpnm;
    }

    public String getCro() {
        return cro;
    }

    public void setCro(String cro) {
        this.cro = cro;
    }

    public String getCtp() {
        return ctp;
    }

    public void setCtp(String ctp) {
        this.ctp = ctp;
    }

    public String getCtx() {
        return ctx;
    }

    public void setCtx(String ctx) {
        this.ctx = ctx;
    }

    public String getCxma() {
        return cxma;
    }

    public void setCxma(String cxma) {
        this.cxma = cxma;
    }

    public String getCxms() {
        return cxms;
    }

    public void setCxms(String cxms) {
        this.cxms = cxms;
    }

    public String getCza() {
        return cza;
    }

    public void setCza(String cza) {
        this.cza = cza;
    }

    public String getCzt() {
        return czt;
    }

    public void setCzt(String czt) {
        this.czt = czt;
    }

    public String getBla() {
        return bla;
    }

    public void setBla(String bla) {
        this.bla = bla;
    }

    public String getBleem() {
        return bleem;
    }

    public void setBleem(String bleem) {
        this.bleem = bleem;
    }

    public String getBleev() {
        return bleev;
    }

    public void setBleev(String bleev) {
        this.bleev = bleev;
    }

    public String getAmc() {
        return amc;
    }

    public void setAmc(String amc) {
        this.amc = amc;
    }

    public String getAmp() {
        return amp;
    }

    public void setAmp(String amp) {
        this.amp = amp;
    }

    public String getAmx() {
        return amx;
    }

    public void setAmx(String amx) {
        this.amx = amx;
    }

    public String getAn() {
        return an;
    }

    public void setAn(String an) {
        this.an = an;
    }

    public String getAndi() {
        return andi;
    }

    public void setAndi(String andi) {
        this.andi = andi;
    }

    public String getAnfb() {
        return anfb;
    }

    public void setAnfb(String anfb) {
        this.anfb = anfb;
    }

    public String getAtm() {
        return atm;
    }

    public void setAtm(String atm) {
        this.atm = atm;
    }

    public String getAzm() {
        return azm;
    }

    public void setAzm(String azm) {
        this.azm = azm;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getId_type_of_sample() {
        return id_type_of_sample;
    }

    public void setId_type_of_sample(int id_type_of_sample) {
        this.id_type_of_sample = id_type_of_sample;
    }

    public int getId_microorganism() {
        return id_microorganism;
    }

    public void setId_microorganism(int id_microorganism) {
        this.id_microorganism = id_microorganism;
    }

    public int getId_area() {
        return id_area;
    }

    public void setId_area(int id_area) {
        this.id_area = id_area;
    }

    public int getIsolate() {
        return isolate;
    }

    public void setIsolate(int isolate) {
        this.isolate = isolate;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getUrgent() {
        return urgent;
    }

    public void setUrgent(String urgent) {
        this.urgent = urgent;
    }


    public String getNhc() {
        return nhc;
    }

    public void setNhc(String nhc) {
        this.nhc = nhc;
    }

    public String getPatient() {
        return patient;
    }

    public void setPatient(String patient) {
        this.patient = patient;
    }


    public String getRequest_date() {
        return request_date;
    }

    public void setRequest_date(String request_date) {
        this.request_date = request_date;
    }

    public String getRes_microorganism() {
        return res_microorganism;
    }

    public void setRes_microorganism(String res_microorganism) {
        this.res_microorganism = res_microorganism;
    }

    public int getRequest() {
        return request;
    }

    public void setRequest(int request) {
        this.request = request;
    }

    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    public String getMicroorganism() {
        return microorganism;
    }

    public void setMicroorganism(String microorganism) {
        this.microorganism = microorganism;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getType_of_sample() {
        return type_of_sample;
    }

    public void setType_of_sample(String type_of_sample) {
        this.type_of_sample = type_of_sample;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getService() {
        return service;
    }

    public String getDestiny() {
        return destiny;
    }

    public void setDestiny(String destiny) {
        this.destiny = destiny;
    }

    public void setService(String service) {
        this.service = service;
    }
}
