package sn.uva.pav.commun;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import com.vaadin.server.FileResource;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Image;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;


/**
 * Classe Utilitaire personnalisée d'upload de fichier.
 * Elle permet de charger les images et vignettes dans la table des 
 * articles  
 * @author bafal
 *
 */
public class UploadPav  extends CustomComponent  implements Receiver, SucceededListener {
	
	private VerticalLayout cadreUpload; 
	private File fichier;
	private Image image;
	
	Logger logger = Logger.getLogger(UploadPav.class);
	
	public UploadPav (String titre){
		
		cadreUpload = new VerticalLayout();
		
		setCompositionRoot(cadreUpload);
		
		Upload upload = new Upload(titre, this);
		upload.addSucceededListener(this);
		image = new Image(titre);
		image.setVisible(false);
		
		cadreUpload.addComponent(upload);
		cadreUpload.addComponent(image);
	}

	@Override
	public void uploadSucceeded(SucceededEvent event) {
		// Traitement en cas de succés du upload 
		image.setSource(new FileResource(fichier));
		image.setVisible(true);
		
		logger.info("Upload de fichier SUCCESS :: "+event.getFilename());
		
	}

	@Override
	public OutputStream receiveUpload(String filename, String mimeType) {
		fichier = new File(filename);
		
		FileOutputStream fos = null; 
		
		try {
			fos = new FileOutputStream(fichier);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage(), e);
		}
		return fos;
	}
	
	
    /**
     * Méthode permettant de retourner un tableau de byte.
     * @param f : Fichier à transformer en un tableau de byte.
     * @return : un tableau de bytes.
     * @throws IOException : Gestion des erreurs à notre guise.
     */
	private byte[] getByteFromFile(File f) {

		int length = (int) f.length();
		byte[] data = new byte[length];

		BufferedInputStream in;
		try {
			in = new BufferedInputStream(
					new FileInputStream(f));
			int result = in.read(data, 0, length);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return data;
	}
	
	public byte[] getByteUpload(){
		return  getByteFromFile(fichier);
	}

}
