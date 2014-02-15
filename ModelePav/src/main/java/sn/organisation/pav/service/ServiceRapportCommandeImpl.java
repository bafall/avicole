package sn.organisation.pav.service;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;

import java.sql.Connection;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;


@Service("serviceRapportCommande")
public class ServiceRapportCommandeImpl implements ServiceRapportCommande {
	
	  @Override
	public byte[] getRapportJasper(JasperReport jasperReport,
              Map<String, Object> parametres){
		  Connection connexion = this.creerConnexionBD();
		  byte[] rapportCommande = null ;
		  try {
			rapportCommande = JasperRunManager.runReportToPdf(jasperReport, parametres, connexion);
		} catch (JRException e) {
			e.printStackTrace();
		}
		  return rapportCommande;
	  }

	private Connection creerConnexionBD() {

		String driver ="com.mysql.jdbc.Driver";		
		String url ="jdbc:mysql://192.168.1.139:3306/pavsn";
		String utilisateur ="dev";
		String pwd = "test";
		Connection connexion = null;
		try {
			Class.forName(driver);
			connexion = DriverManager.getConnection(url, utilisateur, pwd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return connexion;
	}

}
