package sn.uva.pav.commun;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;

public final class ConnexionPav {
	
	
	//private static Subject utilisateurCourant;
	
	
	public static boolean isUtilisateurConnecte(){
		return getUtilisateurCourant().isAuthenticated();
	}
	
	
	
	public static boolean connecter(String utilisateur, String motDePasse){
		
		// Etape I : Collecte des infos de connexion du sujet 
		UsernamePasswordToken tokenDeConnexion = new UsernamePasswordToken( utilisateur, motDePasse );
		//”Remember Me” Se souvenir de moi
		tokenDeConnexion.setRememberMe(false);
		
		//Etape II : Soumettre les infos de connexion au serveur d'authentification
		//Subject currentUser = SecurityUtils.getSubject();		
		getUtilisateurCourant().login(tokenDeConnexion);
		
		return getUtilisateurCourant().isAuthenticated();
	}
	
	public static Subject getUtilisateurCourant(){
		return SecurityUtils.getSubject();
	}
	
	public static void deconnexion(){
		getUtilisateurCourant().logout();
	}

}
