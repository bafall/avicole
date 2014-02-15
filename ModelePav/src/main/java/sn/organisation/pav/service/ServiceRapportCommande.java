package sn.organisation.pav.service;

import java.util.Map;

import net.sf.jasperreports.engine.JasperReport;

public interface ServiceRapportCommande {

	byte[] getRapportJasper(JasperReport jasperReport,
			Map<String, Object> parametres);

}