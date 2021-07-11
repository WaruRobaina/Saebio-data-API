public class ReportData {
    static private int N_EColi_F_14 = 0, N_EColi_F_50 = 0, N_K_Pneu_F_14 = 0, N_K_Pneu_F_50 = 0, N_Citro_Freu_F = 0,
            N_Citro_Kos_F = 0, N_Ent_Clo_F = 0, N_Ent_Ae_F = 0, N_Kleb_Oxy_F = 0, N_Morga_F = 0, N_Prot_Mira_F = 0,
            N_Pseu_Aeru_F = 0, N_Stap_Sapro_F = 0, N_EColi_N = 0, N_Prot_Mira_N = 0, N_K_Pneu_N = 0, N_EColi_M = 0,
            N_K_Pneu_M = 0, N_Pseu_Aeru_M = 0, N_Strep_Pyo = 0, N_Pseu_Aeru_O = 0, N_Hae_In_O = 0, N_Nei = 0;
    static private int [] EColi_F_14 = new int[14], EColi_F_50 = new int[14], K_Pneu_F_14 = new int[14], K_Pneu_F_50 = new int[14],
            Citro_Freu_F = new int[14], Citro_Kos_F = new int[14], Ent_Clo_F = new int[14], Ent_Ae_F = new int[14],
            Kleb_Oxy_F = new int[14], Morga_F = new int[14], Prot_Mira_F = new int[14], Pseu_Aeru_F = new int[14],
            Stap_Sapro_F = new int[14], EColi_N = new int[11], Prot_Mira_N = new int[11], K_Pneu_N = new int[11],
            EColi_M = new int[14], K_Pneu_M = new int[14], Pseu_Aeru_M = new int[14], Strep_Pyo = new int[7],
            Pseu_Aeru_O = new int[13], Hae_In_O = new int[13], Nei = new int[4];


    public static int getN_EColi_F_14() {
        return N_EColi_F_14;
    }

    public static int getN_EColi_F_50() {
        return N_EColi_F_50;
    }

    public static int getN_K_Pneu_F_14() {
        return N_K_Pneu_F_14;
    }

    public static int getN_K_Pneu_F_50() {
        return N_K_Pneu_F_50;
    }

    public static int getN_Citro_Freu_F() {
        return N_Citro_Freu_F;
    }

    public static int getN_Citro_Kos_F() {
        return N_Citro_Kos_F;
    }

    public static int getN_Ent_Clo_F() {
        return N_Ent_Clo_F;
    }

    public static int getN_Ent_Ae_F() {
        return N_Ent_Ae_F;
    }

    public static int getN_Kleb_Oxy_F() {
        return N_Kleb_Oxy_F;
    }

    public static int getN_Morga_F() {
        return N_Morga_F;
    }

    public static int getN_Prot_Mira_F() {
        return N_Prot_Mira_F;
    }

    public static int getN_Pseu_Aeru_F() {
        return N_Pseu_Aeru_F;
    }

    public static int getN_Stap_Sapro_F() {
        return N_Stap_Sapro_F;
    }

    public static int getN_Pseu_Aeru_O() {
        return N_Pseu_Aeru_O;
    }

    public static int getN_Hae_In_O() {
        return N_Hae_In_O;
    }

    public static int[] getPseu_Aeru_O() {
        return Pseu_Aeru_O;
    }

    public static int[] getHae_In_O() {
        return Hae_In_O;
    }

    public static void countEntry(Entry entry){
        if(entry.getSex().equals("f")){
            switch (entry.getMicroorganism()){
                case "escherichia coli":
                    if(entry.getTypeofsample().contains("orina")){
                        if(entry.getAge() > 14 && entry.getAge() <= 50){
                            N_EColi_F_14 ++;
                            urinaryFCount(entry, EColi_F_14);
                        } else {
                            if(entry.getAge() > 50){
                                N_EColi_F_50++;
                                urinaryFCount(entry, EColi_F_50);
                            } else {
                                N_EColi_N++;
                                urinaryNCount(entry, EColi_N);
                            }
                        }
                    }
                    break;
                case "klebsiella pneumoniae":
                    if(entry.getTypeofsample().contains("orina")){
                        if(entry.getAge() > 14 && entry.getAge() <= 50){
                            N_K_Pneu_F_14 ++;
                            urinaryFCount(entry, K_Pneu_F_14);
                        } else {
                            if(entry.getAge() > 50){
                                N_K_Pneu_F_50++;
                                urinaryFCount(entry, K_Pneu_F_50);
                            } else {
                                N_K_Pneu_N++;
                                urinaryNCount(entry, K_Pneu_N);
                            }
                        }
                    }
                    break;
                case "citrobacter freundii":
                    if(entry.getTypeofsample().contains("orina")){
                        if(entry.getAge() > 14){
                            N_Citro_Freu_F ++;
                            urinaryFCount(entry, Citro_Freu_F);
                        }
                    }
                    break;
                case "citrobacter koseri":
                    if(entry.getTypeofsample().contains("orina")){
                        if(entry.getAge() > 14){
                            N_Citro_Kos_F ++;
                            urinaryFCount(entry, Citro_Kos_F);
                        }
                    }
                    break;
                case "enterobacter cloacae complex":
                    if(entry.getTypeofsample().contains("orina")){
                        if(entry.getAge() > 14){
                            N_Ent_Clo_F ++;
                            urinaryFCount(entry, Ent_Clo_F);
                        }
                    }
                    break;
                case "enterobacter aerogenes":
                    if(entry.getTypeofsample().contains("orina")){
                        if(entry.getAge() > 14){
                            N_Ent_Ae_F ++;
                            urinaryFCount(entry, Ent_Ae_F);
                        }
                    }
                    break;
                case "klebsiella oxytoca":
                    if(entry.getTypeofsample().contains("orina")){
                        if(entry.getAge() > 14){
                            N_Kleb_Oxy_F ++;
                            urinaryFCount(entry, Kleb_Oxy_F);
                        }
                    }
                    break;
                case "morganella morganii":
                    if(entry.getTypeofsample().contains("orina")){
                        if(entry.getAge() > 14){
                            N_Morga_F ++;
                            urinaryFCount(entry, Morga_F);
                        }
                    }
                    break;
                case "proteus mirabilis":
                    if(entry.getTypeofsample().contains("orina")){
                        if(entry.getAge() > 14){
                            N_Prot_Mira_F ++;
                            urinaryFCount(entry, Prot_Mira_F);
                        } else {
                            N_Prot_Mira_N++;
                            urinaryNCount(entry, Prot_Mira_N);
                        }
                    }
                    break;
                case "pseudomonas aeruginosa":
                    if(entry.getTypeofsample().contains("orina")){
                        if(entry.getAge() > 14){
                            N_Pseu_Aeru_F ++;
                            urinaryFCount(entry, Pseu_Aeru_F);
                        }
                    } else {
                        String aux=entry.getTypeofsample();
                        if(aux.contains("exudado ótico") || aux.contains("exudado otico") || aux.contains("exudado conjuntival")){
                            N_Pseu_Aeru_O++;
                            ocularCount(entry, Pseu_Aeru_O);
                        }
                    }
                    break;
                case "staphylococcus saprophyticus":
                    if(entry.getTypeofsample().contains("orina")){
                        if(entry.getAge() > 14){
                            N_Stap_Sapro_F ++;
                            urinaryFCount(entry, Stap_Sapro_F);
                        }
                    }
                    break;
                case "streptococcus pyogenes":
                    if(entry.getTypeofsample().equals("exudado faríngeo") || entry.getTypeofsample().equals("exudado nasofaríngeo")){
                        N_Strep_Pyo++;
                        faringeusCount(entry, Strep_Pyo);
                    }
                    break;

                case "haemophilus influenzae":
                    String aux=entry.getTypeofsample();
                    if(aux.contains("exudado ótico") || aux.contains("exudado otico") || aux.contains("exudado conjuntival")){
                        N_Hae_In_O++;
                        ocularCount(entry, Hae_In_O);
                    }
                    break;
                case "neisseria gonorrhoeae":
                    String aux2=entry.getTypeofsample();
                    if(aux2.equals("exudado uretral") || aux2.equals("exudado vaginal") || aux2.equals("exudado endocervical")
                    || aux2.equals("exudado vulvar")) {
                        N_Nei++;
                        sexualCount(entry, Nei);
                    }
                    break;

            }
        } else {
            if(entry.getSex().equals("m")){
                switch (entry.getMicroorganism()){
                    case "escherichia coli":
                        if(entry.getTypeofsample().contains("orina")){
                            if(entry.getAge() <=14 ){
                                N_EColi_N++;
                                urinaryNCount(entry, EColi_N);
                            } else {
                                N_EColi_M++;
                                urinaryFCount(entry,EColi_M);
                            }
                        }
                        break;
                    case "klebsiella pneumoniae":
                        if(entry.getTypeofsample().contains("orina")){
                            if(entry.getAge() <=14 ){
                                N_K_Pneu_N++;
                                urinaryNCount(entry, K_Pneu_N);
                            } else {
                                N_K_Pneu_M++;
                                urinaryFCount(entry, K_Pneu_M);
                            }
                        }
                        break;
                    case "pseudomonas aeruginosa":
                        if(entry.getTypeofsample().contains("orina")){
                            if(entry.getAge()>14){
                                N_Pseu_Aeru_M++;
                                urinaryFCount(entry, Pseu_Aeru_M);
                            }
                        } else {
                            String aux=entry.getTypeofsample();
                            if(aux.contains("exudado ótico") || aux.contains("exudado otico") || aux.contains("exudado conjuntival")){
                                N_Pseu_Aeru_O++;
                                ocularCount(entry, Pseu_Aeru_O);
                            }
                        }
                        break;
                    case "proteus mirabilis":
                        if(entry.getTypeofsample().contains("orina")){
                            if(entry.getAge() <=14 ){
                                N_Prot_Mira_N++;
                                urinaryNCount(entry, Prot_Mira_N);
                            }
                        }
                        break;
                    case "streptococcus pyogenes":
                        if(entry.getTypeofsample().equals("exudado faríngeo") || entry.getTypeofsample().equals("exudado nasofaríngeo")){
                            N_Strep_Pyo++;
                            faringeusCount(entry, Strep_Pyo);
                        }
                        break;
                    case "haemophilus influenzae":
                        String aux=entry.getTypeofsample();
                        if(aux.contains("exudado ótico") || aux.contains("exudado otico") || aux.contains("exudado conjuntival")){
                            N_Hae_In_O++;
                            ocularCount(entry, Hae_In_O);
                        }
                        break;
                    case "neisseria gonorrhoeae":
                        String aux2=entry.getTypeofsample();
                        if(aux2.equals("exudado uretral") || aux2.equals("exudado vaginal") || aux2.equals("exudado endocervical")
                                || aux2.equals("exudado vulvar")) {
                            N_Nei++;
                            sexualCount(entry, Nei);
                        }
                        break;
                }
            }
        }
    }

    public static int getN_EColi_M() {
        return N_EColi_M;
    }

    public static int getN_K_Pneu_M() {
        return N_K_Pneu_M;
    }

    public static int getN_Pseu_Aeru_M() {
        return N_Pseu_Aeru_M;
    }

    public static int[] getEColi_M() {
        return EColi_M;
    }

    public static int[] getK_Pneu_M() {
        return K_Pneu_M;
    }

    public static int[] getPseu_Aeru_M() {
        return Pseu_Aeru_M;
    }

    public static int getN_Nei() {
        return N_Nei;
    }

    public static int[] getNei() {
        return Nei;
    }

    public static void getPercentages(){
        // Urinary >14 F Table
        getPercentage(N_EColi_F_14, EColi_F_14);
        getPercentage(N_EColi_F_50, EColi_F_50);
        getPercentage(N_K_Pneu_F_14, K_Pneu_F_14);
        getPercentage(N_K_Pneu_F_50, K_Pneu_F_50);
        getPercentage(N_Citro_Freu_F, Citro_Freu_F);
        getPercentage(N_Citro_Kos_F, Citro_Kos_F);
        getPercentage(N_Ent_Clo_F, Ent_Clo_F);
        getPercentage(N_Ent_Ae_F, Ent_Ae_F);
        getPercentage(N_Kleb_Oxy_F, Kleb_Oxy_F);
        getPercentage(N_Morga_F, Morga_F);
        getPercentage(N_Prot_Mira_F, Prot_Mira_F);
        getPercentage(N_Pseu_Aeru_F, Pseu_Aeru_F);
        getPercentage(N_Stap_Sapro_F, Stap_Sapro_F);

        // Urinary <14 Table
        getPercentage(N_EColi_N, EColi_N);
        getPercentage(N_K_Pneu_N, K_Pneu_N);
        getPercentage(N_Prot_Mira_N, Prot_Mira_N);

        //Urinary >14 M Table
        getPercentage(N_EColi_M, EColi_M);
        getPercentage(N_K_Pneu_M, K_Pneu_M);
        getPercentage(N_Pseu_Aeru_M, Pseu_Aeru_M);

        //Faringeus
        getPercentage(N_Strep_Pyo, Strep_Pyo);

        //Ocular
        getPercentage(N_Pseu_Aeru_O, Pseu_Aeru_O);
        getPercentage(N_Hae_In_O, Hae_In_O);

        //Sexual
        getPercentage(N_Nei, Nei);

    }

    public static int getN_Strep_Pyo() {
        return N_Strep_Pyo;
    }

    public static int[] getStrep_Pyo() {
        return Strep_Pyo;
    }

    public static int[] getEColi_F_14() {
        return EColi_F_14;
    }

    public static int[] getEColi_F_50() {
        return EColi_F_50;
    }

    public static int[] getK_Pneu_F_14() {
        return K_Pneu_F_14;
    }

    public static int[] getK_Pneu_F_50() {
        return K_Pneu_F_50;
    }

    public static int[] getCitro_Freu_F() {
        return Citro_Freu_F;
    }

    public static int[] getCitro_Kos_F() {
        return Citro_Kos_F;
    }

    public static int[] getEnt_Clo_F() {
        return Ent_Clo_F;
    }

    public static int[] getEnt_Ae_F() {
        return Ent_Ae_F;
    }

    public static int[] getKleb_Oxy_F() {
        return Kleb_Oxy_F;
    }

    public static int[] getMorga_F() {
        return Morga_F;
    }

    public static int[] getProt_Mira_F() {
        return Prot_Mira_F;
    }

    public static int[] getPseu_Aeru_F() {
        return Pseu_Aeru_F;
    }

    public static int getN_EColi_N() {
        return N_EColi_N;
    }

    public static int getN_Prot_Mira_N() {
        return N_Prot_Mira_N;
    }

    public static int getN_K_Pneu_N() {
        return N_K_Pneu_N;
    }

    public static int[] getEColi_N() {
        return EColi_N;
    }

    public static int[] getProt_Mira_N() {
        return Prot_Mira_N;
    }

    public static int[] getK_Pneu_N() {
        return K_Pneu_N;
    }

    public static int[] getStap_Sapro_F() {
        return Stap_Sapro_F;
    }

    private static void urinaryFCount (Entry entry, int[] array){
        if(entry.getAmp().equals("sensible")) array[0]++;
        if(entry.getAmc().equals("sensible")) array[1]++;
        if(entry.getCxma().equals("sensible")) array[2]++;
        if(entry.getCtx().equals("sensible")) array[3]++;
        if(entry.getCaz().equals("sensible")) array[4]++;
        if(entry.getFep().equals("sensible")) array[5]++;
        if(entry.getIpm().equals("sensible")) array[6]++;
        if(entry.getEpm().equals("sensible")) array[7]++;
        if(entry.getCip().equals("sensible")) array[8]++;
        if(entry.getGm().equals("sensible")) array[9]++;
        if(entry.getTn().equals("sensible")) array[10]++;
        if(entry.getFm().equals("sensible")) array[11]++;
        if(entry.getSxt().equals("sensible")) array[12]++;
        if(entry.getFo().equals("sensible")) array[13]++;
    }

    private static void urinaryNCount (Entry entry, int[] array){
        if(entry.getAmp().equals("sensible")) array[0]++;
        if(entry.getAmc().equals("sensible")) array[1]++;
        if(entry.getCxma().equals("sensible")) array[2]++;
        if(entry.getCtx().equals("sensible")) array[3]++;
        if(entry.getIpm().equals("sensible")) array[4]++;
        if(entry.getCip().equals("sensible")) array[5]++;
        if(entry.getGm().equals("sensible")) array[6]++;
        if(entry.getTn().equals("sensible")) array[7]++;
        if(entry.getFm().equals("sensible")) array[8]++;
        if(entry.getSxt().equals("sensible")) array[9]++;
        if(entry.getFo().equals("sensible")) array[10]++;
    }

    private static void faringeusCount(Entry entry, int[] a){
        if(entry.getP().equals("sensible")) a[0]++;
        if(entry.getAmp().equals("sensible")) a[1]++;
        if(entry.getAmc().equals("sensible")) a[2]++;
        if(entry.getE().equals("sensible")) a[3]++;
        if(entry.getCc().equals("sensible")) a[4]++;
        if(entry.getMlsbi().equals("sensible")) a[5]++;
        if(entry.getLvx().equals("sensible")) a[6]++;
    }

    private static void ocularCount(Entry entry, int[] array){
        if(entry.getAmp().equals("sensible")) array[0]++;
        if(entry.getAmc().equals("sensible")) array[1]++;
        if(entry.getFix().equals("sensible")) array[2]++;
        if(entry.getCro().equals("sensible")) array[3]++;
        if(entry.getCaz().equals("sensible")) array[4]++;
        if(entry.getFep().equals("sensible")) array[5]++;
        if(entry.getAtm().equals("sensible")) array[6]++;
        if(entry.getIpm().equals("sensible")) array[7]++;
        if(entry.getCip().equals("sensible")) array[8]++;
        if(entry.getLvx().equals("sensible")) array[9]++;
        if(entry.getGm().equals("sensible")) array[10]++;
        if(entry.getTn().equals("sensible")) array[11]++;
        if(entry.getSxt().equals("sensible")) array[12]++;
    }

    private static void sexualCount(Entry entry, int[] array){
        if(entry.getCro().equals("sensible")) array[0]++;
        if(entry.getFix().equals("sensible")) array[1]++;
        if(entry.getCip().equals("sensible")) array[2]++;
        if(entry.getAzm().equals("sensible")) array[3]++;
    }

    private static void getPercentage(int N, int[] array){
        int lenght = array.length;
        for(int i = 0; i<lenght; i++){
            int n = array[i];
            if(N != 0){
                array[i] = Math.round((n*100)/N);
            } else {
                array[i] = 0;
            }
        }
    }

    public static void reinitializeVariables(){
        N_EColi_F_14 = 0;
        N_EColi_F_50 = 0;
        N_K_Pneu_F_14 = 0;
        N_K_Pneu_F_50 = 0;
        N_Citro_Freu_F = 0;
        N_Citro_Kos_F = 0;
        N_Ent_Clo_F = 0;
        N_Ent_Ae_F = 0;
        N_Kleb_Oxy_F = 0;
        N_Morga_F = 0;
        N_Prot_Mira_F = 0;
        N_Pseu_Aeru_F = 0;
        N_Stap_Sapro_F = 0;
        N_EColi_N = 0;
        N_Prot_Mira_N = 0;
        N_K_Pneu_N = 0;
        N_EColi_M = 0;
        N_K_Pneu_M = 0;
        N_Pseu_Aeru_M = 0;
        N_Strep_Pyo = 0;
        N_Pseu_Aeru_O = 0;
        N_Hae_In_O = 0;
        N_Nei = 0;
        EColi_F_14 = new int[14];
        EColi_F_50 = new int[14];
        K_Pneu_F_14 = new int[14];
        K_Pneu_F_50 = new int[14];
        Citro_Freu_F = new int[14];
        Citro_Kos_F = new int[14];
        Ent_Clo_F = new int[14];
        Ent_Ae_F = new int[14];
        Kleb_Oxy_F = new int[14];
        Morga_F = new int[14];
        Prot_Mira_F = new int[14];
        Pseu_Aeru_F = new int[14];
        Stap_Sapro_F = new int[14];
        EColi_N = new int[11];
        Prot_Mira_N = new int[11];
        K_Pneu_N = new int[11];
        EColi_M = new int[14];
        K_Pneu_M = new int[14];
        Pseu_Aeru_M = new int[14];
        Strep_Pyo = new int[7];
        Pseu_Aeru_O = new int[13];
        Hae_In_O = new int[13];
        Nei = new int[4];
    }


}
