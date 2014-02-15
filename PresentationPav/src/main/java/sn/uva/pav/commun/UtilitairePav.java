package sn.uva.pav.commun;

import java.util.Locale;
import java.util.Random;
import com.vaadin.data.Item;
import com.vaadin.data.util.HierarchicalContainer;
import com.vaadin.data.util.IndexedContainer;

public final class UtilitairePav {
	
   /**
    * Domaine de valeur : Liste des pays du norme ISO 3166.	
    */
   private static final String[] listePaysIso3166 = new String[] { "AFGHANISTAN", "AF",
           "ÅLAND ISLANDS", "AX", "ALBANIA", "AL", "ALGERIA", "DZ",
           "AMERICAN SAMOA", "AS", "ANDORRA", "AD", "ANGOLA", "AO",
           "ANGUILLA", "AI", "ANTARCTICA", "AQ", "ANTIGUA AND BARBUDA", "AG",
           "ARGENTINA", "AR", "ARMENIA", "AM", "ARUBA", "AW", "AUSTRALIA",
           "AU", "AUSTRIA", "AT", "AZERBAIJAN", "AZ", "BAHAMAS", "BS",
           "BAHRAIN", "BH", "BANGLADESH", "BD", "BARBADOS", "BB", "BELARUS",
           "BY", "BELGIUM", "BE", "BELIZE", "BZ", "BENIN", "BJ", "BERMUDA",
           "BM", "BHUTAN", "BT", "BOLIVIA", "BO", "BOSNIA AND HERZEGOVINA",
           "BA", "BOTSWANA", "BW", "BOUVET ISLAND", "BV", "BRAZIL", "BR",
           "BRITISH INDIAN OCEAN TERRITORY", "IO", "BRUNEI DARUSSALAM", "BN",
           "BULGARIA", "BG", "BURKINA FASO", "BF", "BURUNDI", "BI",
           "CAMBODIA", "KH", "CAMEROON", "CM", "CANADA", "CA", "CAPE VERDE",
           "CV", "CAYMAN ISLANDS", "KY", "CENTRAL AFRICAN REPUBLIC", "CF",
           "CHAD", "TD", "CHILE", "CL", "CHINA", "CN", "CHRISTMAS ISLAND",
           "CX", "COCOS (KEELING) ISLANDS", "CC", "COLOMBIA", "CO", "COMOROS",
           "KM", "CONGO", "CG", "CONGO, THE DEMOCRATIC REPUBLIC OF THE", "CD",
           "COOK ISLANDS", "CK", "COSTA RICA", "CR", "CÃ”TE D'IVOIRE", "CI",
           "CROATIA", "HR", "CUBA", "CU", "CYPRUS", "CY", "CZECH REPUBLIC",
           "CZ", "DENMARK", "DK", "DJIBOUTI", "DJ", "DOMINICA", "DM",
           "DOMINICAN REPUBLIC", "DO", "ECUADOR", "EC", "EGYPT", "EG",
           "EL SALVADOR", "SV", "EQUATORIAL GUINEA", "GQ", "ERITREA", "ER",
           "ESTONIA", "EE", "ETHIOPIA", "ET", "FALKLAND ISLANDS (MALVINAS)",
           "FK", "FAROE ISLANDS", "FO", "FIJI", "FJ", "FINLAND", "FI",
           "FRANCE", "FR", "FRENCH GUIANA", "GF", "FRENCH POLYNESIA", "PF",
           "FRENCH SOUTHERN TERRITORIES", "TF", "GABON", "GA", "GAMBIA", "GM",
           "GEORGIA", "GE", "GERMANY", "DE", "GHANA", "GH", "GIBRALTAR", "GI",
           "GREECE", "GR", "GREENLAND", "GL", "GRENADA", "GD", "GUADELOUPE",
           "GP", "GUAM", "GU", "GUATEMALA", "GT", "GUERNSEY", "GG", "GUINEA",
           "GN", "GUINEA-BISSAU", "GW", "GUYANA", "GY", "HAITI", "HT",
           "HEARD ISLAND AND MCDONALD ISLANDS", "HM",
           "HOLY SEE (VATICAN CITY STATE)", "VA", "HONDURAS", "HN",
           "HONG KONG", "HK", "HUNGARY", "HU", "ICELAND", "IS", "INDIA", "IN",
           "INDONESIA", "ID", "IRAN, ISLAMIC REPUBLIC OF", "IR", "IRAQ", "IQ",
           "IRELAND", "IE", "ISLE OF MAN", "IM", "ISRAEL", "IL", "ITALY",
           "IT", "JAMAICA", "JM", "JAPAN", "JP", "JERSEY", "JE", "JORDAN",
           "JO", "KAZAKHSTAN", "KZ", "KENYA", "KE", "KIRIBATI", "KI",
           "KOREA, DEMOCRATIC PEOPLE'S REPUBLIC OF", "KP",
           "KOREA, REPUBLIC OF", "KR", "KUWAIT", "KW", "KYRGYZSTAN", "KG",
           "LAO PEOPLE'S DEMOCRATIC REPUBLIC", "LA", "LATVIA", "LV",
           "LEBANON", "LB", "LESOTHO", "LS", "LIBERIA", "LR",
           "LIBYAN ARAB JAMAHIRIYA", "LY", "LIECHTENSTEIN", "LI", "LITHUANIA",
           "LT", "LUXEMBOURG", "LU", "MACAO", "MO",
           "MACEDONIA, THE FORMER YUGOSLAV REPUBLIC OF", "MK", "MADAGASCAR",
           "MG", "MALAWI", "MW", "MALAYSIA", "MY", "MALDIVES", "MV", "MALI",
           "ML", "MALTA", "MT", "MARSHALL ISLANDS", "MH", "MARTINIQUE", "MQ",
           "MAURITANIA", "MR", "MAURITIUS", "MU", "MAYOTTE", "YT", "MEXICO",
           "MX", "MICRONESIA, FEDERATED STATES OF", "FM",
           "MOLDOVA, REPUBLIC OF", "MD", "MONACO", "MC", "MONGOLIA", "MN",
           "MONTENEGRO", "ME", "MONTSERRAT", "MS", "MOROCCO", "MA",
           "MOZAMBIQUE", "MZ", "MYANMAR", "MM", "NAMIBIA", "NA", "NAURU",
           "NR", "NEPAL", "NP", "NETHERLANDS", "NL", "NETHERLANDS ANTILLES",
           "AN", "NEW CALEDONIA", "NC", "NEW ZEALAND", "NZ", "NICARAGUA",
           "NI", "NIGER", "NE", "NIGERIA", "NG", "NIUE", "NU",
           "NORFOLK ISLAND", "NF", "NORTHERN MARIANA ISLANDS", "MP", "NORWAY",
           "NO", "OMAN", "OM", "PAKISTAN", "PK", "PALAU", "PW",
           "PALESTINIAN TERRITORY, OCCUPIED", "PS", "PANAMA", "PA",
           "PAPUA NEW GUINEA", "PG", "PARAGUAY", "PY", "PERU", "PE",
           "PHILIPPINES", "PH", "PITCAIRN", "PN", "POLAND", "PL", "PORTUGAL",
           "PT", "PUERTO RICO", "PR", "QATAR", "QA", "REUNION", "RE",
           "ROMANIA", "RO", "RUSSIAN FEDERATION", "RU", "RWANDA", "RW",
           "SAINT BARTHÃ‰LEMY", "BL", "SAINT HELENA", "SH",
           "SAINT KITTS AND NEVIS", "KN", "SAINT LUCIA", "LC", "SAINT MARTIN",
           "MF", "SAINT PIERRE AND MIQUELON", "PM",
           "SAINT VINCENT AND THE GRENADINES", "VC", "SAMOA", "WS",
           "SAN MARINO", "SM", "SAO TOME AND PRINCIPE", "ST", "SAUDI ARABIA",
           "SA", "SENEGAL", "SN", "SERBIA", "RS", "SEYCHELLES", "SC",
           "SIERRA LEONE", "SL", "SINGAPORE", "SG", "SLOVAKIA", "SK",
           "SLOVENIA", "SI", "SOLOMON ISLANDS", "SB", "SOMALIA", "SO",
           "SOUTH AFRICA", "ZA",
           "SOUTH GEORGIA AND THE SOUTH SANDWICH ISLANDS", "GS", "SPAIN",
           "ES", "SRI LANKA", "LK", "SUDAN", "SD", "SURINAME", "SR",
           "SVALBARD AND JAN MAYEN", "SJ", "SWAZILAND", "SZ", "SWEDEN", "SE",
           "SWITZERLAND", "CH", "SYRIAN ARAB REPUBLIC", "SY",
           "TAIWAN, PROVINCE OF CHINA", "TW", "TAJIKISTAN", "TJ",
           "TANZANIA, UNITED REPUBLIC OF", "TZ", "THAILAND", "TH",
           "TIMOR-LESTE", "TL", "TOGO", "TG", "TOKELAU", "TK", "TONGA", "TO",
           "TRINIDAD AND TOBAGO", "TT", "TUNISIA", "TN", "TURKEY", "TR",
           "TURKMENISTAN", "TM", "TURKS AND CAICOS ISLANDS", "TC", "TUVALU",
           "TV", "UGANDA", "UG", "UKRAINE", "UA", "UNITED ARAB EMIRATES",
           "AE", "UNITED KINGDOM", "GB", "UNITED STATES", "US",
           "UNITED STATES MINOR OUTLYING ISLANDS", "UM", "URUGUAY", "UY",
           "UZBEKISTAN", "UZ", "VANUATU", "VU", "VENEZUELA", "VE", "VIET NAM",
           "VN", "VIRGIN ISLANDS, BRITISH", "VG", "VIRGIN ISLANDS, U.S.",
           "VI", "WALLIS AND FUTUNA", "WF", "WESTERN SAHARA", "EH", "YEMEN",
           "YE", "ZAMBIA", "ZM", "ZIMBABWE", "ZW" };
   public static final Object paysIso3166_PROPERTY_NAME = "name";
   public static final Object paysIso3166_PROPERTY_SHORT = "short";
   public static final Object paysIso3166_PROPERTY_FLAG = "flag";
   public static final Object hw_PROPERTY_NAME = "name";

   public static final Object locale_PROPERTY_LOCALE = "locale";
   public static final Object locale_PROPERTY_NAME = "name";
   private static final String[][] locales = { { "fi", "FI", "Finnish" },
           { "de", "DE", "German" }, { "en", "US", "US - English" },
           { "sv", "SE", "Swedish" } };
   private static final String[][] hardware = { //
           { "Desktops", "Dell OptiPlex GX240", "Dell OptiPlex GX260",
                   "Dell OptiPlex GX280" },
           { "Monitors", "Benq T190HD", "Benq T220HD", "Benq T240HD" },
           { "Laptops", "IBM ThinkPad T40", "IBM ThinkPad T43",
                   "IBM ThinkPad T60" } };

   public static final Object PERSON_PROPERTY_FIRSTNAME = "First Name";
   public static final Object PERSON_PROPERTY_LASTNAME = "Last Name";
   private static final String[] firstnames = new String[] { "John", "Mary",
           "Joe", "Sarah", "Jeff", "Jane", "Peter", "Marc", "Robert", "Paula",
           "Lenny", "Kenny", "Nathan", "Nicole", "Laura", "Jos", "Josie",
           "Linus" };
   private static final String[] lastnames = new String[] { "Torvalds",
           "Smith", "Adams", "Black", "Wilson", "Richards", "Thompson",
           "McGoff", "Halas", "Jones", "Beck", "Sheridan", "Picard", "Hill",
           "Fielding", "Einstein" };
   
   /**
    * Domaine de valeurs des sexes.
    */
   private static final String[] listeSexes = new String[] {"Madame", "Mme", "Monsieur", "Mr", "Autre", "Aut"};
   
   public static final Object Sexe_PROPERTY_NAME = "name";
   public static final Object Sexe_PROPERTY_SHORT = "short";
   
   /**
    * Obtenir la liste des sexes.
    * @return
    */
   public static IndexedContainer getListeSexes() {
	    IndexedContainer c = new IndexedContainer();
	    setListeSexes(c);
	    return c;
   }
   
   /**
    * Mise à jour de la liste des sexes
    * @param container
    */
   private static void setListeSexes(IndexedContainer container) {
	    container.addContainerProperty(Sexe_PROPERTY_NAME, String.class,
	            null);
	    container.addContainerProperty(Sexe_PROPERTY_SHORT, String.class,
	            null);

	    for (int i = 0; i < listeSexes.length; i++) {
	        String name = listeSexes[i++];
	        String id = listeSexes[i];
	        Item item = container.addItem(id);
	        item.getItemProperty(Sexe_PROPERTY_NAME).setValue(name);
	        item.getItemProperty(Sexe_PROPERTY_SHORT).setValue(id);

	    }
	    container.sort(new Object[] { Sexe_PROPERTY_SHORT },
	            new boolean[] { true });
	}

 /**
  * Domaine de valeurs Oui ou Non.   
  */
 private static final String[] listeOuiNon = new String[] {"Oui", "O", "Non", "N"};

 public static final Object OuiNon_PROPERTY_NAME = "name";
 public static final Object OuiNon_PROPERTY_SHORT = "short";

 /**
  * Obtenir la liste des Oui et Non
  * @return la liste des Oui et Non
  */
public static IndexedContainer getListeOuiNon() {
    IndexedContainer c = new IndexedContainer();
    setListeOuiNon(c);
    return c;
}
    /**
     * Mise à jour de la liste des Oui Non.
     * @param container
     */
	private static void setListeOuiNon(IndexedContainer container) {
    	container.addContainerProperty(OuiNon_PROPERTY_NAME, String.class,
            null);
    	container.addContainerProperty(OuiNon_PROPERTY_SHORT, String.class,
            null);

    	for (int i = 0; i < listeOuiNon.length; i++) {
        	String name = listeOuiNon[i++];
        	String id = listeOuiNon[i];
        	Item item = container.addItem(id);
        	item.getItemProperty(OuiNon_PROPERTY_NAME).setValue(name);
        	item.getItemProperty(OuiNon_PROPERTY_SHORT).setValue(id);

    	}
    	container.sort(new Object[] { OuiNon_PROPERTY_SHORT },
            new boolean[] { true });
	}
	
	
	 /**
	  * Domaine de valeurs Provinces Canada.   
	  */
	 private static final String[] listeProvinces = new String[] {"ALBERTA", "AB", "COLOMBIE-BRITANIQUE", "BC",
		 "MANITOBA", "MB","NOUVEAU-BRUNSWICK", "NB","TERRE-NEUVE-ET-LABRADOR", "NL", "NOUVELLE-ÉCOSSE", "NS","TERRITOIRES DU NORD-EST", "NT","NUNAVUT", "NU",
		 "ONTARIO", "ON","ÎLE-DU-PRINCE-ÉDOUARD", "PE","QUÉBEC", "QC","SASKATCHEWAN", "SK","TERRITOIRE DU YUKON", "YT"};

	 public static final Object provinceCA_PROPERTY_NAME = "name";
	 public static final Object provinceCA_PROPERTY_SHORT = "short";
    
	 /**
	  * Obtenir la liste des provinces du Canada.
	  * @return la liste des provinces CA.  
	  */
	public static IndexedContainer getListeProvincesCA() {
	    IndexedContainer c = new IndexedContainer();
	    setListeProvincesCA(c);
	    return c;
	}
        /**
         * Mise à jour de la liste des provinces du Canada.
         * @param container
         */
		private static void setListeProvincesCA(IndexedContainer container) {
	    	container.addContainerProperty(provinceCA_PROPERTY_NAME, String.class,
	            null);
	    	container.addContainerProperty(provinceCA_PROPERTY_SHORT, String.class,
	            null);

	    	for (int i = 0; i < listeProvinces.length; i++) {
	        	String name = listeProvinces[i++];
	        	String id = listeProvinces[i];
	        	Item item = container.addItem(id);
	        	item.getItemProperty(provinceCA_PROPERTY_NAME).setValue(name);
	        	item.getItemProperty(provinceCA_PROPERTY_SHORT).setValue(id);

	    	}
	    	container.sort(new Object[] { provinceCA_PROPERTY_SHORT },
	            new boolean[] { true });
		}
		
		
		
		
		
		
		
		 /**
		  * Domaine de valeurs Provinces Canada.   
		  */
		 private static final String[] listeProvincesAutre = new String[] {"AUTRE", "AB"};

		 public static final Object provinceAUTRE_PROPERTY_NAME = "name";
		 public static final Object provinceAUTRE_PROPERTY_SHORT = "short";
	    
		 /**
		  * Obtenir la liste des provinces des autres pays.
		  * @return la liste des provinces .  
		  */
		public static IndexedContainer getListeProvincesAUTRE() {
		    IndexedContainer c = new IndexedContainer(); 
		    setListeProvincesAUTRE(c);
		    return c;
		}
	        /**
	         * Mise à jour de la liste des provinces des autres pays.
	         * @param container
	         */
			private static void setListeProvincesAUTRE(IndexedContainer container) {
		    	container.addContainerProperty(provinceAUTRE_PROPERTY_NAME, String.class,
		            null);
		    	container.addContainerProperty(provinceAUTRE_PROPERTY_SHORT, String.class,
		            null);

		    	for (int i = 0; i < listeProvincesAutre.length; i++) {
		        	String name = listeProvincesAutre[i++];
		        	String id = listeProvincesAutre[i];
		        	Item item = container.addItem(id);
		        	item.getItemProperty(provinceAUTRE_PROPERTY_NAME).setValue(name);
		        	item.getItemProperty(provinceAUTRE_PROPERTY_SHORT).setValue(id);

		    	}
		    	container.sort(new Object[] { provinceAUTRE_PROPERTY_SHORT },
		            new boolean[] { true });
			}

		
		
		
		
		 /**
		  * Domaine de valeurs Provinces Usa.   
		  */
		 private static final String[] listeProvincesUsa = new String[] {"ALASKA", "AK", 
			 "ALABAMA", "AL", "ARKANSAS", "AR","AMERICAN SAMOA", "AS","ARIZONA", "AZ", "CALIFORNIA", 
			 "CA","COLORADO", "CO","CONNECTICUT", "CT","DISTRICT OF COLUMBIA", "DC","DELAWARE", "DE",
			 "FLORIDA", "FL","FEDERATED STATES OF MICRONESIA", "FM", "GEORGIA", "GA","GUAM", "GU",
			 "HAWAII", "HI","IOWA", "IA","IDAHO", "ID","ILLINOIS", "IL","INDIANA", "IN","KANSAS", "KS",
			 "KENTUCKY", "KY","LOUISIANA", "LA","MASSACHUSETTS", "MA","MARYLAND", "MD","MAINE", "ME", 
			 "MARSHALL ISLANDS", "MH","MICHIGAN", "MI","MINNESOTA", "MN","MISSOURI", "MO",
			 "NORTHERN MARIANA ISLANDS", "MP","MISSISSIPPI", "MS"};

		 public static final Object provinceUsa_PROPERTY_NAME = "name";
		 public static final Object provinceUsa_PROPERTY_SHORT = "short";
        
		 /**
		  * Obtenir la liste des provinces des Usa.
		  * @return la liste des provinces des Usa.
		  */
		public static IndexedContainer getListeProvincesUsa() {
		    IndexedContainer c = new IndexedContainer();
		    setListeProvincesUsa(c);
		    return c;
		}
            
		/**
		 * Mise à jour de la liste des provinces des Usa.
		 * @param container
		 */
			private static void setListeProvincesUsa(IndexedContainer container) {
		    	container.addContainerProperty(provinceCA_PROPERTY_NAME, String.class,
		            null);
		    	container.addContainerProperty(provinceCA_PROPERTY_SHORT, String.class,
		            null);

		    	for (int i = 0; i < listeProvincesUsa.length; i++) {
		        	String name = listeProvincesUsa[i++];
		        	String id = listeProvincesUsa[i];
		        	Item item = container.addItem(id);
		        	item.getItemProperty(provinceUsa_PROPERTY_NAME).setValue(name);
		        	item.getItemProperty(provinceUsa_PROPERTY_SHORT).setValue(id);

		    	}
		    	container.sort(new Object[] { provinceUsa_PROPERTY_SHORT },
		            new boolean[] { true });
			}
		
		
		 /**
		  * Domaine de valeurs Régions Canada.   
		  */
		 private static final String[] listeRegions = new String[] {"REGION01", "01", "REGION02", "02"};

		 public static final Object region_PROPERTY_NAME = "name";
		 public static final Object region_PROPERTY_SHORT = "short";
        
		/**
		 * Obtenir la liste des régions. 
		 * @return la liste des régions.
		 */
		public static IndexedContainer getListeRegions() {
		    IndexedContainer c = new IndexedContainer();
		    setListeRegions(c);
		    return c;
		}

		    /**
		     * Mise à jour de la liste des régions.
		     * @param container
		     */
			private static void setListeRegions(IndexedContainer container) {
		    	container.addContainerProperty(region_PROPERTY_NAME, String.class,
		            null);
		    	container.addContainerProperty(region_PROPERTY_SHORT, String.class,
		            null);

		    	for (int i = 0; i < listeRegions.length; i++) {
		        	String name = listeRegions[i++];
		        	String id = listeRegions[i];
		        	Item item = container.addItem(id);
		        	item.getItemProperty(region_PROPERTY_NAME).setValue(name);
		        	item.getItemProperty(region_PROPERTY_SHORT).setValue(id);

		    	}
		    	container.sort(new Object[] { region_PROPERTY_SHORT },
		            new boolean[] { true });
			}
    
	/**
	 * Domaine de valeurs : liste des langues maternelles
	 */
	private static final String[] listeLangueMaternelle = new String[] {"Français", "FR", "Anglais", "AN", "Autre", "AU"};
	public static final Object LangMat_PROPERTY_NAME = "name";
	public static final Object LangMat_PROPERTY_SHORT = "short";
    
	/**
	 * Obtenir la liste des langues maternelles.
	 * @return la liste des langues maternelles.
	 */
	public static IndexedContainer getListeLangueMaternelle() {
		IndexedContainer c = new IndexedContainer();
		setListeLangueMaternelle(c);
		return c;
	}
    
	/**
	 * Mise à jour de la liste des langues maternelles.
	 * @param container
	 */
	private static void setListeLangueMaternelle(IndexedContainer container) {
		container.addContainerProperty(LangMat_PROPERTY_NAME, String.class,
            null);
		container.addContainerProperty(LangMat_PROPERTY_SHORT, String.class,
            null);

		for (int i = 0; i < listeLangueMaternelle.length; i++) {
			String name = listeLangueMaternelle[i++];
			String id = listeLangueMaternelle[i];
			Item item = container.addItem(id);
			item.getItemProperty(LangMat_PROPERTY_NAME).setValue(name);
			item.getItemProperty(LangMat_PROPERTY_SHORT).setValue(id);

		}
		container.sort(new Object[] { LangMat_PROPERTY_SHORT },
            new boolean[] { true });
	}
	
	/**
	 * Domaine de valeurs : liste des statuts
	 */
	private static final String[] listeStatut = new String[] {"Contractuel", "00", "Occasionnel", "01", "Régulier", "10", "Stagiaire", "11"};
	public static final Object statut_PROPERTY_NAME = "name";
	public static final Object statut_PROPERTY_SHORT = "short";

	/**
	 * Obtenir la liste des statuts. 
	 * @return la liste des statuts.
	 */
	public static IndexedContainer getListeStatut() {
		IndexedContainer c = new IndexedContainer();
		setListeStatut(c);
		return c;
	}

	/**
	 * Mise à jour de la liste des statuts
	 * @param container
	 */
	private static void setListeStatut(IndexedContainer container) {
		container.addContainerProperty(statut_PROPERTY_NAME, String.class,
            null);
		container.addContainerProperty(statut_PROPERTY_SHORT, String.class,
            null);

		for (int i = 0; i < listeStatut.length; i++) {
			String name = listeStatut[i++];
			String id = listeStatut[i];
			Item item = container.addItem(id);
			item.getItemProperty(statut_PROPERTY_NAME).setValue(name);
			item.getItemProperty(statut_PROPERTY_SHORT).setValue(id);

		}
		container.sort(new Object[] { statut_PROPERTY_SHORT },
            new boolean[] { true });
	} 
	
	/**
	 * Domaine de valeurs : liste des ministères
	 */
	private static final String[] listeMinistere = new String[] {"MDEIE", "0000", "MELS", "0001", "MAPAQ", "0010" };
	public static final Object ministere_PROPERTY_NAME = "name";
	public static final Object ministere_PROPERTY_SHORT = "short";

	/**
	 * Obtenir la liste des ministères.
	 * @return la liste des ministères.
	 */
	public static IndexedContainer getListeMinistere() {
		IndexedContainer c = new IndexedContainer();
		setListeMinistere(c);
		return c;
	}
 
	/**
	 * Mise à jour de la liste des ministères.
	 * @param container
	 */
	private static void setListeMinistere(IndexedContainer container) {
		container.addContainerProperty(ministere_PROPERTY_NAME, String.class,
            null);
		container.addContainerProperty(ministere_PROPERTY_SHORT, String.class,
            null);

		for (int i = 0; i < listeMinistere.length; i++) {
			String name = listeMinistere[i++];
			String id = listeMinistere[i];
			Item item = container.addItem(id);
			item.getItemProperty(ministere_PROPERTY_NAME).setValue(name);
			item.getItemProperty(ministere_PROPERTY_SHORT).setValue(id);

		}
		container.sort(new Object[] { ministere_PROPERTY_SHORT },
            new boolean[] { true });
	}
	
	
	/**
	 * Domaine de valeurs : liste des classements
	 */
	private static final String[] listeClassement = new String[] {"Agent d'acréditation (295.10)", "0000", "Agent agricole (210.10)", "0001", "Agent culturel (107.10)", "0010" };
	public static final Object classement_PROPERTY_NAME = "name";
	public static final Object classement_PROPERTY_SHORT = "short";

	/**
	 * Obtenir la liste des classements.
	 * @return la liste des classements.
	 */
	public static IndexedContainer getListeClassement() {
		IndexedContainer c = new IndexedContainer();
		setListeClassement(c);
		return c;
	}

	/**
	 * Mise à jour de la liste des classements.
	 * @param container
	 */
	private static void setListeClassement(IndexedContainer container) {
		container.addContainerProperty(classement_PROPERTY_NAME, String.class,
            null);
		container.addContainerProperty(classement_PROPERTY_SHORT, String.class,
            null);

		for (int i = 0; i < listeClassement.length; i++) {
			String name = listeClassement[i++];
			String id = listeClassement[i];
			Item item = container.addItem(id);
			item.getItemProperty(classement_PROPERTY_NAME).setValue(name);
			item.getItemProperty(classement_PROPERTY_SHORT).setValue(id);

		}
		container.sort(new Object[] { classement_PROPERTY_SHORT },
            new boolean[] { true });
	}

/**
 * Domaine de valeur : Liste des déficiences
 */
private static final String[] deficiences = new String[] {
        "Audition", "00", "Parole", "01","Motrice", "02", };
public static final Object Deficience_PROPERTY_NAME = "name";
public static final Object Deficience_PROPERTY_SHORT = "short";

/**
 * Obtenir la liste des déficiences. 
 * @return la liste des déficiences.
 */
public static IndexedContainer getDeficiences() {
    IndexedContainer c = new IndexedContainer();
    setDeficience(c);
    return c;
}

/**
 * Mise à jour de la liste des déficiences.
 * @param container
 */
private static void setDeficience(IndexedContainer container) {
    container.addContainerProperty(Deficience_PROPERTY_NAME, String.class,
            null);
    container.addContainerProperty(Deficience_PROPERTY_SHORT, String.class,
            null);

    for (int i = 0; i < deficiences.length; i++) {
        String name = deficiences[i++];
        String id = deficiences[i];
        Item item = container.addItem(id);
        item.getItemProperty(Deficience_PROPERTY_NAME).setValue(name);
        item.getItemProperty(Deficience_PROPERTY_SHORT).setValue(id);

    }
    container.sort(new Object[] { Deficience_PROPERTY_SHORT },
            new boolean[] { true });
}

public static IndexedContainer getPersonContainer() {
       IndexedContainer contactContainer = new IndexedContainer();
       contactContainer.addContainerProperty(PERSON_PROPERTY_FIRSTNAME,
               String.class, "");
       contactContainer.addContainerProperty(PERSON_PROPERTY_LASTNAME,
               String.class, "");

       Random r = new Random(5);
       for (int i = 0; i < 50;) {
           String fn = firstnames[(int) (r.nextDouble() * firstnames.length)];
           String ln = lastnames[(int) (r.nextDouble() * lastnames.length)];
           String id = fn + ln;
           Item item = contactContainer.addItem(id);
           if (item != null) {
               i++;
               item.getItemProperty(PERSON_PROPERTY_FIRSTNAME).setValue(fn);
               item.getItemProperty(PERSON_PROPERTY_LASTNAME).setValue(ln);
           }
       }
       return contactContainer;
   }

   public static IndexedContainer getLocaleContainer() {
       IndexedContainer localeContainer = new IndexedContainer();
       localeContainer.addContainerProperty(locale_PROPERTY_LOCALE,
               Locale.class, null);
       localeContainer.addContainerProperty(locale_PROPERTY_NAME,
               String.class, null);
       for (int i = 0; i < locales.length; i++) {
           String id = locales[i][2];
           Item item = localeContainer.addItem(id);
           item.getItemProperty(locale_PROPERTY_LOCALE).setValue(
                   new Locale(locales[i][0], locales[i][1]));
           item.getItemProperty(locale_PROPERTY_NAME).setValue(locales[i][2]);
       }

       return localeContainer;
   }

 /*  @Deprecated
   public static IndexedContainer getStaticISO3166Container() {
       return getListePaysIso3166();
   }

   public static IndexedContainer getListePaysIso3166() {
       IndexedContainer c = new IndexedContainer();
       fillListePaysIso3166Container(c);
       return c;
   }

   private static void fillListePaysIso3166Container(IndexedContainer container) {
       container.addContainerProperty(paysIso3166_PROPERTY_NAME, String.class,
               null);
       container.addContainerProperty(paysIso3166_PROPERTY_SHORT, String.class,
               null);
       container.addContainerProperty(paysIso3166_PROPERTY_FLAG, Resource.class,
               null);
       for (int i = 0; i < listePaysIso3166.length; i++) {
           String name = listePaysIso3166[i++];
           String id = listePaysIso3166[i];
           Item item = container.addItem(id);
           item.getItemProperty(paysIso3166_PROPERTY_NAME).setValue(name);
           item.getItemProperty(paysIso3166_PROPERTY_SHORT).setValue(id);
           item.getItemProperty(paysIso3166_PROPERTY_FLAG).setValue(
                   new ThemeResource("../sampler/flags/" + id.toLowerCase()
                           + ".gif"));
       }
       container.sort(new Object[] { paysIso3166_PROPERTY_NAME },
               new boolean[] { true });
   }

   public static HierarchicalContainer getHardwareContainer() {
       Item item = null;
       int itemId = 0; // Increasing numbering for itemId:s

       // Create new container
       HierarchicalContainer hwContainer = new HierarchicalContainer();
       // Create containerproperty for name
       hwContainer.addContainerProperty(hw_PROPERTY_NAME, String.class, null);
       for (int i = 0; i < hardware.length; i++) {
           // Add new item
           item = hwContainer.addItem(itemId);
           // Add name property for item
           item.getItemProperty(hw_PROPERTY_NAME).setValue(hardware[i][0]);
           // Allow children
           hwContainer.setChildrenAllowed(itemId, true);
           itemId++;
           for (int j = 1; j < hardware[i].length; j++) {
               // Add child items
               item = hwContainer.addItem(itemId);
               item.getItemProperty(hw_PROPERTY_NAME).setValue(hardware[i][j]);
               hwContainer.setParent(itemId, itemId - j);
               hwContainer.setChildrenAllowed(itemId, false);
               itemId++;
           }
       }
       return hwContainer;
   }*/


}